package Tests;

import Libraries.BrowserDriver;
import Methods.Memberships;
import Methods.TicketPurchase;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TicketMasterTest extends BrowserDriver {

    @BeforeMethod
    public void setUpTicketPurchase()
    {
        browser();
    }

    @Test(priority = 1)
    public void runMethod()
    {
        TicketPurchase ticketMaster = new TicketPurchase(driver);
        ticketMaster.submitCommands();




        }
    @AfterClass
            public void teardown(){
        driver.close();
    }

    @Test(priority = 2)
    public void runMemberships(){
        Memberships memberships = new Memberships(driver);
        memberships.submitCommands();

    }




}
