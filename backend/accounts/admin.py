from django.contrib import admin
from . import models

# Register your models here.
@admin.register(models.User)
class UserAdmin(admin.ModelAdmin):
    list_display = (
        'email',
        'nickname',
    )

    list_display_links = (
        'email',
        'nickname',
    )

admin.site.register(models.Group)