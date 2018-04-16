from django.conf.urls import url, include
from django.contrib import admin

urlpatterns = [
    url(r'^$', include('urlparts.urls')),
    url(r'^admin/', admin.site.urls),
    url(r'^posts/', include('posts.urls')),
    url(r'^urlparts/', include('urlparts.urls')),
]
