

from django import forms
from django.conf import settings
from django.core.mail import message, send_mail


class ContactForm(forms.Form):

    nome = forms.CharField(max_length=50)
    email = forms.EmailField()
    mensagem = forms.CharField()
    
