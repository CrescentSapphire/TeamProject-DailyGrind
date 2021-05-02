# tables.py
import django_tables2 as tables
from .models import Inventory

class InventoryTable(tables.Table):
    detail = tables.TemplateColumn('<a href="item_detail/{{record.sc_id}}">Detail</a>')
    update = tables.TemplateColumn('<a href="item_edit/{{record.sc_id}}">Edit</a>')
    class Meta:
        model = Inventory
        template_name = "django_tables2/bootstrap-responsive.html"
        attrs = {
            "class" : "table table-bordered table-hover",
            "th" : { "class" : "thead-light", "scope" : "col"},
            "td" : {"scope" : "row",}
        }
        exclude = ["sc_id"]