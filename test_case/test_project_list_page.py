from selenium import webdriver
from inventory.models import Inventory
from django.contrib.staticfiles.testing import StaticLiveServerTestCase

class TestProjectListPage(StaticLiveServerTestCase):
    
    def setUp(self):
        self.browser = webdriver.Chrome('test_case/chromedriver.exe')
        
    def tearDown(self):
        self.browser.close()
        
    def test_no_project_alert_is_display(self):
        self.browser.get(self.live_server_url)
        
        