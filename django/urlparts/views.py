# -*- coding: utf-8 -*-
from __future__ import unicode_literals
from django.shortcuts import render
from django.http import HttpResponse
from django.core import urlresolvers

from django.shortcuts import render

# Create your views here.
def details(e, request):
    relative_uri = urlresolvers.reverse("details")
    uri = request.get_full_path
    return HttpResponse(uri)
