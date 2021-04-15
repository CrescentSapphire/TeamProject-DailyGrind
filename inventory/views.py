from django.shortcuts import get_object_or_404, render
from django.contrib.auth import logout
from .models import Inventory
from .tables import InventoryTable


# Create your views here.
def inventory(request):
    table = InventoryTable(Inventory.objects.all())
    return render(request, 'inventory/inventory.html', {"table": table})

def item_detail(request, pk):
    item = get_object_or_404(Inventory, pk=pk)
    return render(request, 'blog/post_detail.html', {'item': item})
