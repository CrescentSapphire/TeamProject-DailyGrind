from django.urls import path
from . import views

urlpatterns = [
    path('', views.inventory, name='inventory'),
    #here I put a 1 after stuff to denote my methods. 
    path('item_search1', views.item_detail1, name='item_detail1'),
    path('update_information', views.update_item, name='update_information'),
    path('update_item_attributes', views.update_item_attributes, name='update_item_attributes'),
]