from django import forms
from .models import Inventory


class editForm(forms.ModelForm):

    class Meta:
        model = Inventory
        fields = ['sc_daily_demand', 'sc_popularity', 'sc_days_before_out'] 