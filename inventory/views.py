from django.shortcuts import get_object_or_404, render
from .models import InventoryTable

# Create your views here.
def inventory(request):
    inlist = InventoryTable.objects.all()
    return render(request, 'inventory/inventory.html', {'list': inlist})

def item_detail(request, pk):
    post = get_object_or_404(InventoryTable, pk=pk)
    return render(request, 'blog/post_detail.html', {'item': item})