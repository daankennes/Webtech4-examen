from django.conf.urls import url
from . import views

urlpatterns = [
  # +
  # url(r'^urlparts/(?\d+)/$', views.details, name='details')
  url(r'^(/?[a-zA-Z0-9]+)*$', views.details, name='details'),
]