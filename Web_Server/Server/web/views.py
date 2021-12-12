from django.shortcuts import render
from .models import Contact_form


def homepage(request):

    if request.method == "GET":
        return render(request, "web/index.html")
    elif request.method == "POST":
        if request.POST.get("form"):
            print(request.POST["name"])
            print(request.POST["email"])
            print(request.POST["msg"])

            info = Contact_form(name=request.POST["name"], email=request.POST["email"], message=request.POST["msg"])
            info.save()
        
        return render(request, "web/index.html")

