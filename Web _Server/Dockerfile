FROM python:3.9.5-alpine

RUN apk update && apk add python3-dev

ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1
ENV DEBUG 0

COPY . .

WORKDIR /Server

RUN pip install -r requirements.txt

#RUN adduser -D myuser
#USER myuser

EXPOSE $PORT

