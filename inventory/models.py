from django.db import models

class Inventory(models.Model):
    sc_id = models.IntegerField(primary_key=True)
    sc_name = models.CharField(max_length=90)
    sc_daily_demand = models.IntegerField(blank=True, null=True)
    sc_popularity = models.CharField(max_length=20, blank=True, null=True)
    sc_days_before_out = models.IntegerField(blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'sams_club_inventory'
