from django.db import models
from django.contrib.auth.models import BaseUserManager, AbstractBaseUser, PermissionsMixin
import requests, sys, os, hashlib, hmac, base64, time, datetime
from random import randint
from django.utils import timezone
from model_utils.models import TimeStampedModel

# Create your models here.
class UserManager(BaseUserManager):
    def create_user(self, email, nickname, phone_number, is_retailer, password=None):
        if not email:
            raise ValueError('이메일은 필수항목입니다.')
        if not password:
            raise ValueError('비밀번호는 필수항목입니다.')
        if not nickname:
            raise ValueError('닉네임은 필수항목입니다.')
        if not phone_number:
            raise ValueError('전화번호는 필수항목입니다.')

        user = self.model(
            email=self.normalize_email(email),
            nickname=nickname,
            phone_number=phone_number,
            is_retailer_id=is_retailer
        )

        user.set_password(password)
        user.save(using=self._db)
        return user

    def create_superuser(self, email, nickname, phone_number, password):
        user = self.create_user(
            email,
            password=password,
            nickname=nickname,
            phone_number=phone_number,
            is_retailer=3
        )
        user.is_superuser = True
        user.is_staff = True
        user.is_admin = True
        user.save(using=self._db)
        return user

class Group(models.Model):
    name = models.CharField(max_length=10)

    def __str__(self):
        return self.name

class User(AbstractBaseUser, PermissionsMixin):
    objects = UserManager()

    email = models.EmailField(
        verbose_name='email',
        max_length=50,
        unique=True,
    )
    nickname = models.CharField(
        max_length=10,
        unique=True
        )
    phone_number = models.CharField(max_length=11)

    is_retailer = models.ForeignKey(Group, on_delete=models.CASCADE)
    is_active = models.BooleanField(default=True)
    is_admin = models.BooleanField(default=False)
    is_superuser = models.BooleanField(default=False)
    is_staff = models.BooleanField(default=False)
    date_joined = models.DateTimeField(auto_now_add=True)

    USERNAME_FIELD = 'email'
    REQUIRED_FIELDS = ['nickname', 'phone_number']


class Auth_Sms(TimeStampedModel):
    phone_number = models.CharField(verbose_name='휴대폰 번호', primary_key=True, max_length=11)
    auth_number = models.IntegerField(verbose_name='인증 번호')

    class Meta:
        db_table = 'auth_sms'
    
    def save(self, *args, **kwargs):
        self.auth_number = randint(100000, 1000000)
        super().save(*args, **kwargs)
        self.send_sms()

    def send_sms(self):
        url = "https://sens.apigw.ntruss.com/sms/v2/services/ncp:sms:kr:265023124780:truffle_sms/messages"
        data = {
            "type": "SMS",
            "from": "01095004870",
            "content": "[Truffle] ",
            "messages": [
                {
                    "to": str(self.phone_number),
                    "content": "[Truffle] 인증번호 [{}]를 입력해주세요.".format(self.auth_number)
                }
            ],
            
        }
        def make_signature():
            timestamp = int(time.time() * 1000)
            timestamp = str(timestamp)

            access_key = "lBa83C55tmv1CuV3P8T1"	  
            secret_key = "MYyrXncu9zu1OehpKMHPu865KqMEJ5nQrzsbHQ6S"
            secret_key = bytes(secret_key, 'UTF-8')

            method = "POST"
            uri = "/sms/v2/services/ncp:sms:kr:265023124780:truffle_sms/messages" 
            message = method + " " + uri + "\n" + timestamp + "\n" + access_key
            message = bytes(message, 'UTF-8')
            signingKey = base64.b64encode(hmac.new(secret_key, message, digestmod=hashlib.sha256).digest())
            return signingKey

        signature = make_signature()
        headers = {
            "Content-Type": "application/json; charset=utf-8",
            "x-ncp-apigw-timestamp": str(int(time.time() * 1000)),
            "x-ncp-iam-access-key": "lBa83C55tmv1CuV3P8T1",
            "x-ncp-apigw-signature-v2": signature
        }
        print(requests.post(url, json=data, headers=headers))


    @classmethod
    def check_auth_number(cls, p_num, c_num):
        time_limit = timezone.now() - datetime.timedelta(minutes=5)
        result = cls.objects.filter(
            phone_number=p_num,
            auth_number=c_num,
            modified__gte=time_limit
        )
        if result:
            return True
        return False

