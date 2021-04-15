from django.urls import path
from . import views

urlpatterns = [
    path('', views.inventory, name='inventory'),
    path('item_search', views.item_detail, name='item_detail'),
]