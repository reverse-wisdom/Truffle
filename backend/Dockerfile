FROM python:3.6.7

ENV PYTHONUNBUFFERED 1

RUN apt-get -y update && \
    apt-get -y install vim && \
    mkdir -p /src/docker-django
COPY . /src/docker-django

WORKDIR /src/docker-django

RUN pip install --upgrade pip && \
    pip install -r requirements.txt