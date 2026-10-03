package Methods;

import Libraries.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Memberships extends BrowserDriver {
    By acceptBtn = By.xpath("//button[contains(@class,'cky-btn-accept')]");
    By acceptBtn2 = By.xpath("//*[@id='site']/div[4]/div[2]/button[1]");
    By memberships = By.xpath("(//a[contains(@href,'/en/tickets')])[1]");
    By purchaseMembership = By.xpath("//a[contains(@class,'bg-color-green-80') and contains(@href, '/en/zoo')]");
    By individualMembership = By.xpath("//*[@id='page-index-detail']/main/article/div[2]/section[3]/div/div/div/a");
    By studentMembership = By.xpath("//*[contains(@id,'frmaa')]/div[2]/div[1]/div[1]/div[5]/div[2]/div[1]");
    By familyMembership = By.xpath("//*[contains(@id,'frmaa')]/div[2]/div[1]/div[1]/div[5]/div[3]");
    By lifeMembership = By.xpath("//*[contains(@id,'frmaa')]/div[2]/div[1]/div[1]/div[5]/div[4]");
    By firstName = By.xpath("//input[@id='firstname']");
    public Memberships(WebDriver driver)
    {
        super(driver);
    }
    public Memberships()
    {

    }
    public void submitCommands(){
        clickWait2(acceptBtn);
        clickWait2(acceptBtn2);
        bypass(memberships);
        clickWait2(purchaseMembership);
        bypass(individualMembership);
        bypass(studentMembership);
        bypass(familyMembership);
        clickWait2(lifeMembership);
        sendKeys(firstName);





    }


    }





