import smtplib
from inventory.models import Inventory

def _get_grocery_list():
    grocery_list = []
    inventory =  Inventory.objects.all()
    for i in inventory:
        if i.sc_days_before_out <= 5:
            grocery_list.append(i.sc_name)
    listToStr = '\n'.join([str(elem) for elem in grocery_list])
    print(listToStr)
    return listToStr
    
def update_grocerylist():
    grocery_list = _get_grocery_list()
    smtp = smtplib.SMTP('smtp.gmail.com', port='587')
    smtp.ehlo()
    smtp.starttls()
    smtp.login('dailygrindinventory@gmail.com', 'Mokoniji13!')
    smtp.sendmail('dailygrindinventory@gmail.com', 'tphiggins@unomaha.edu', grocery_list.encode("ascii", errors="ignore"))
    smtp.quit()