from django.urls import path
from . import views

urlpatterns = [
    path('', views.inventory, name='inventory'),
    path('item_add', views.item_add, name='item_add'),
    path('item_detail/<int:pk>', views.item_detail, name='item_detail'),
    path('item_edit/<int:pk>', views.item_edit, name='item_edit'),
]