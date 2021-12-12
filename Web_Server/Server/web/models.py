from django.db import models

# Create your models here.

class Contact_form(models.Model):
    name = models.CharField(max_length=20)
    email = models.CharField(max_length=30)
    message = models.CharField(max_length=16084)