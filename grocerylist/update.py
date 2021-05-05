from datetime import datetime
from apscheduler.schedulers.background import BackgroundScheduler
from grocerylist import grocerylistAPI

def start():
    scheduler = BackgroundScheduler()
    scheduler.add_job(grocerylistAPI.update_grocerylist, 'interval', minutes=1440)
    scheduler.start()