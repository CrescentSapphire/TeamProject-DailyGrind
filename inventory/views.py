from django.shortcuts import get_object_or_404, render
from django.contrib.auth import logout
from .models import Inventory
from .tables import InventoryTable


# Create your views here.
def inventory(request):
    table = InventoryTable(Inventory.objects.all())
    return render(request, 'inventory/inventory.html', {"table": table})

def item_detail(request):
    if request.method == "POST":
        if "search-bar" in request.POST:
            searched = request.POST['search-bar']
            results = Inventory.objects.filter(sc_name__contains=searched)
        return render(request, 'inventory/item_detail.html', {'searched': searched, 'results': results})
    else:
        return render(request, 'inventory/item_detail.html', {})
