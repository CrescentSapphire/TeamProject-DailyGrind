import smtplib
from inventory.models import Inventory

def _get_grocery_list():
    grocery_list = []
    inventory =  Inventory.objects.all()
    for i in inventory:
        if i.sc_days_before_out <= 5:
            grocery_list.append(i.name)
    return grocery_list
    
def update_grocerylist():
    grocery_list = _get_grocery_list()
    smtp = smtplib.SMTP('smtp-mail.gami.com', port='587')
    smtp.ehlo()
    smtp.starttls()
    smtp.login('dailygrindinventory@gmail.com', 'Mokoniji13!')
    smtp.sendmail('tphiggins@unomaha.edu', grocery_list.as_string())
    smtp.quit()