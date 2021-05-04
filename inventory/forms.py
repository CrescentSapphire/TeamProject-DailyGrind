from inventory.views import Inventory
from django import forms
from .models import Inventory
from crispy_forms.helper import FormHelper
from crispy_forms.layout import Submit, Layout, Row

class searchForm(forms.ModelForm):
    
    class Meta:
        model = Inventory
        fields = ('sc_name',)
        
    def __init__(self, *args, **kwargs):
        super(searchForm, self).__init__(*args, **kwargs)
        self.helper = FormHelper()
        self.helper.form_id = 'id-finding-search-form'
        self.helper.form_method = "POST"
        
        self.helper.layout = Layout(
            Row('sc_name', css_class='form-group col-md-6 mb-0', )
        )
        self.helper.add_input(Submit('submit', 'Submit'))
        
class addForm(forms.ModelForm):
    
    class Meta:
        model = Inventory
        fields = ('sc_name', 'sc_daily_demand', 'sc_popularity', 'sc_days_before_out',)
    
    def __init__(self, *args, **kwargs):
        super(addForm, self).__init__(*args, **kwargs)
        self.helper = FormHelper()
        self.helper.form_id = 'id-finding-add-form'
        self.helper.form_method = "POST"
        
        self.helper.layout = Layout(
            Row('sc_name', css_class='form-group col-md-6 mb-0'),
            Row('sc_daily_demand', css_class='form-group col-md-6 mb-0'),
            Row('sc_popularity', css_class='form-group col-md-6 mb-0'),
            Row('sc_days_before_out', css_class='form-group col-md-6 mb-0'),
        )
        self.helper.add_input(Submit('submit', 'Submit'))

class editForm(forms.ModelForm):
    
    class Meta:
        model = Inventory
        fields = ('sc_daily_demand', 'sc_popularity', 'sc_days_before_out',)
    
    def __init__(self, *args, **kwargs):
        super(editForm, self).__init__(*args, **kwargs)
        self.helper = FormHelper()
        self.helper.form_id = 'id-finding-edit-form'
        self.helper.form_method = "POST"
        
        self.helper.layout = Layout(
            Row('sc_name', css_class='form-group col-md-6 mb-0'),
            Row('sc_daily_demand', css_class='form-group col-md-6 mb-0'),
            Row('sc_popularity', css_class='form-group col-md-6 mb-0'),
            Row('sc_days_before_out', css_class='form-group col-md-6 mb-0'),
        )
        self.helper.add_input(Submit('submit', 'Submit'))