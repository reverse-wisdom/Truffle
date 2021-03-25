from django.shortcuts import render, get_object_or_404
from django.contrib.auth import get_user_model

from rest_framework.decorators import api_view, authentication_classes, permission_classes
from rest_framework.response import Response
from rest_framework import status, viewsets
from rest_framework.permissions import IsAuthenticated
from rest_framework_jwt.authentication import JSONWebTokenAuthentication
from rest_framework.views import APIView

from drf_yasg.utils import swagger_auto_schema

from .models import User, Auth_Sms
from .serializers import SignupSerializer, AuthSmsSerializer, AuthSmsQuerySerializer
# Create your views here.

class Signup(viewsets.ModelViewSet):
    serializer_class = SignupSerializer

    def signup(self, request):
        password = request.data.get('password')

        serializer = SignupSerializer(data=request.data)

        if serializer.is_valid(raise_exception=True):
            user = serializer.save()
            user.set_password(password)
            user.save()

        return Response(serializer.data, status=status.HTTP_201_CREATED)

class Verify_phone(viewsets.ModelViewSet):
    serializer_class = AuthSmsSerializer

    def post(self, request):
        try:
            p_num = request.data['phone_number']
        except KeyError:
            return Response({'message': 'Bad Request'}, status=status.HTTP_400_BAD_REQUEST)
        else:
            Auth_Sms.objects.update_or_create(phone_number=p_num)
            return Response({'message': 'OK'})
    
    @swagger_auto_schema(query_serializer=AuthSmsQuerySerializer)
    def get(self, request):
        try:
            p_num = request.query_params['phone_number']
            a_num = request.query_params['auth_number']
        except KeyError:
            return Response({'message': 'Bad Request'}, status=status.HTTP_400_BAD_REQUEST)
        else:
            result = Auth_Sms.check_auth_number(p_num, a_num)
            return Response({'message': result})