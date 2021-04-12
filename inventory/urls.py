from django.urls import path
from . import views

urlpatterns = [
    path('', views.inventory, name='inventory'),
    path('item/<int:pk>/', views.item_detail, name='item_detail'),
]