from django.http.response import HttpResponseRedirect
from django.shortcuts import get_object_or_404, render
from django.contrib.auth import logout
from django.urls.base import reverse
from .models import Inventory
from .tables import InventoryTable
from .forms import searchForm, addForm, editForm


# Create your views here.
def inventory(request):
    if request.method == "POST":
        if "sc_name" in request.POST:
            searched = request.POST['sc_name']
            results = Inventory.objects.filter(sc_name__contains=searched)
    else:
        results = Inventory.objects.all()
    table = InventoryTable(results)
    form = searchForm()
    data_dict = {
        "table": table,
        "form": form,
    }
    return render(request, 'inventory/inventory.html', data_dict)

def item_detail(request, pk):
    item = get_object_or_404(Inventory, pk=pk)
    return render(request, 'inventory/item_detail.html', {'item': item})

def item_add(request):
    if request.method == 'POST':
        form = addForm(request.POST)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect('inventory/inventory.html')
    else:
        form = addForm()
    return render(request, 'inventory/item_add.html', {'form': form})

def item_edit(request, pk):
    record = get_object_or_404(Inventory, pk=pk)
    if request.method == 'POST':
        form = editForm(request.POST, instance=record)
        if form.is_valid():
            form.save()
            return HttpResponseRedirect(reverse('inventory:item_detail', args=(record.pk,)))
    else:
        form = editForm(instance=record)
    return render(request, 'inventory/item_edit.html', {'form': form})

def item_delete(request, pk):
    record = get_object_or_404(Inventory, pk=pk)
    Inventory.objects.filter(pk=record.pk).delete()
    return render(request, 'inventory/inventory.html')