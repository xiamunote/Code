# -*- coding: utf-8 -*-
# Generated by Django 1.10.6 on 2017-04-02 23:46
from __future__ import unicode_literals

from django.conf import settings
from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        migrations.swappable_dependency(settings.AUTH_USER_MODEL),
        ('booksystem', '0001_initial'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='passenger',
            name='flight',
        ),
        migrations.AddField(
            model_name='flight',
            name='user',
            field=models.ForeignKey(default=1, on_delete=django.db.models.deletion.CASCADE, to=settings.AUTH_USER_MODEL),
        ),
        migrations.DeleteModel(
            name='Passenger',
        ),
    ]
