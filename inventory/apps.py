from django.apps import AppConfig


class InventoryConfig(AppConfig):
    name = 'inventory'
    
    def ready(self):
        from grocerylist import update
        update.start()
