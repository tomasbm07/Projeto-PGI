from django.shortcuts import render
from .forms import ContactForm
from django.core.mail import send_mail
from django.conf import settings
from django.http import HttpResponse


def homepage(request):

    if request.method == "GET":
        form = ContactForm()
        return render(request, "web/index.html", {'form': form})
    
    elif request.method == "POST":

        form = ContactForm(request.POST)
        if form.is_valid():
            nome = form.cleaned_data['nome']
            email = form.cleaned_data['email']
            
            msg = f"Nome: {nome}\nEmail: {email}\nMensagem:\n"
            msg += form.cleaned_data['mensagem']
            try:
                send_mail(
                    subject = "Better Land Form",
                    message = msg,
                    from_email = settings.EMAIL_HOST_USER,
                    recipient_list = [settings.EMAIL_HOST_USER]
                )
            except:
                print("============ Error sending email =====================")
        
            return render(request, "web/index.html", {'form': form})
        else:
            print("Form not valid")
            form = ContactForm()
            return render(request, "web/index.html", {'form': form})
        


