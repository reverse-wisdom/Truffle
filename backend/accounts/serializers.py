from rest_framework import serializers
from django.contrib.auth import get_user_model
from .models import Auth_Sms


class SignupSerializer(serializers.ModelSerializer):
    password = serializers.CharField(write_only=True)

    class Meta:
        model = get_user_model()
        fields = ['id', 'email', 'nickname', 'phone_number', 'is_retailer', 'password']

class AuthSmsSerializer(serializers.ModelSerializer):

    class Meta:
        model = Auth_Sms
        fields = ['phone_number', 'auth_number']

class AuthSmsQuerySerializer(serializers.ModelSerializer):
    phone_number = serializers.CharField(required=True)
    auth_number = serializers.IntegerField(required=True)

    class Meta:
        model = Auth_Sms
        fields = ['phone_number', 'auth_number']
        
    