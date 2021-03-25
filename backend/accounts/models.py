from django.db import models
from django.contrib.auth.models import BaseUserManager, AbstractBaseUser, PermissionsMixin

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



