FROM python:3.9.5-alpine

RUN apk update && apk add python3-dev

COPY requirements.txt .

RUN pip install -r requirements.txt

COPY . .

EXPOSE 8050

WORKDIR Server/

CMD python manage.py runserver 0.0.0.0:8050

