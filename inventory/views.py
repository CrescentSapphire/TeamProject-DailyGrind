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
    return render(request, 'inventory/item_detail.html', {'item': item})

#down below are my methods, you can try to alter them

def item_detail1(request):
    if request.method == "POST":
        if "search-bar" in request.POST:
            searched = request.POST['search-bar']
            results = Inventory.objects.filter(sc_name__contains=searched)
        return render(request, 'inventory/item_detail.html', {'searched': searched, 'results': results})
    else:
        return render(request, 'inventory/item_detail.html', {})

def update_item(request):
    item_name = request.POST.get("update", "")
    print(item_name)
    popularity = request.POST.get("hidden-popularity", "")
    daily_demand = request.POST.get("hidden-daily-demand", "")
    days_before_out = request.POST.get("hidden-days-before-out", "")
    return render(request, 'inventory/update_items.html', {'item_name': item_name, 'popularity': popularity, 'daily_demand': daily_demand, 'days_before_out':days_before_out})

def update_item_attributes(request):
    table = InventoryTable(Inventory.objects.all())
    name = request.POST.get("test")
    popularity = request.POST.get("popularity", "")
    daily_demand = request.POST.get("daily-demand", "")
    days_before_out = request.POST.get("days-before-out", "")
    print(name)
    Inventory.objects.get(sc_name=name)
    Inventory.objects.filter(sc_name=name).update(sc_daily_demand=daily_demand, sc_popularity=popularity, sc_days_before_out=days_before_out)

    return render(request, 'inventory/inventory.html', {"table" : table})
