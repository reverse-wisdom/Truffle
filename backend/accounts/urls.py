from django.urls import path
from . import views

from rest_framework_jwt.views import obtain_jwt_token

app_name = 'accounts'

urlpatterns = [
    path('signup/', views.Signup.as_view({'post': 'signup'}), name='signup'),
    path('verify_phone/', views.Verify_phone.as_view({'post': 'post', 'get': 'get'}), name='verify_phone'),
    path('login/', obtain_jwt_token)
]
