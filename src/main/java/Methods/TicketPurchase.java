package Methods;

import Libraries.BrowserDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TicketPurchase extends BrowserDriver {

    By acceptBtn = By.xpath("//button[contains(@class,'cky-btn-accept')]");
    By acceptBtn2 = By.xpath("//*[@id='site']/div[4]/div[2]/button[1]");
    By locationbox = By.xpath("//a[contains(@href, '/en/tickets') and contains(., 'Purchase your tickets')]");
    By onedayTicket = By.xpath("//a[contains(., 'One-day ticket')]");
    By ticketSectionBtn = By.xpath("(//a[contains(@href,'/en/tickets')])[1]");
    By OnedayTicket = By.xpath("//a[contains(., 'One-day ticket')]");
    By dateButton = By.cssSelector("input[id^='date_visit_']");
    By plusButton1 = By.xpath("//*[@id='t724209102']/div[2]/div/div[2]/div[3]/div[4]/table/tbody/tr/td[3]/div");
    By plusButton2 = By.xpath("//*[@id='t724209102']/div[2]/div/div[2]/div[4]/div[4]/table/tbody/tr/td[3]/div");
    By plusButton3 = By.xpath("//*[@id='t724209102']/div[2]/div/div[2]/div[5]/div[4]/table/tbody/tr/td[3]/div");
    By plusButton4 = By.xpath("//*[@id='t724209102']/div[2]/div/div[2]/div[6]/div[4]/table/tbody/tr/td[3]/div");
    By plusButton5 = By.xpath("//*[@id='t724209102']/div[2]/div/div[2]/div[7]/div[4]/table/tbody/tr/td[3]/div");
    By continueBtn = By.xpath("//*[@id='ssd365105055']/div/div[3]/div/div[2]");
    By donationBox = By.xpath("//label[contains(@class,'cff-checkbox-style')]");
    By donation10 = By.xpath("//*[@id='opt_amount']/table[2]/tbody/tr/td[1]/label");
    By addtoOrder = By.xpath("//*[@id='add_donation_cntonsel']/div[3]/div");
    By continueBtn2= By.xpath("//div[@class='button th_bt_next']");
    By homeButton = By.xpath("//*[@id='ps1444467860']");


    public TicketPurchase(WebDriver driver) {
        super(driver);
    }

    public TicketPurchase() {
    }


    public void clickDate()
    {
        WebElement datebutton = wait.until(ExpectedConditions.presenceOfElementLocated(dateButton));

        // Add tomorrow's date dynamically
        LocalDate targetDate = LocalDate.now().plusDays(1);
        //2. Format it to match the required placeholder format "YYYY-MM-DD"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = targetDate.format(formatter);
        //3. Inject value and dispatch events so the page/form registers the change
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].value = arguments[1]; " +
                        "arguments[0].dispatchEvent(new Event('input', {bubbles: true})); " +
                        "arguments[0].dispatchEvent(new Event('change', {bubbles: true})); " +
                        "arguments[0].dispatchEvent(new Event('blur', {bubbles: true}));",datebutton,formattedDate);

    }



    public void visibility ()
    {

        System.out.println("Starting visibility wait...");

        WebElement ticketSection = wait.until(
                ExpectedConditions.presenceOfElementLocated(ticketSectionBtn)
        );

        System.out.println("Element exists in DOM");

        System.out.println("Displayed: " + ticketSection.isDisplayed());
        System.out.println("Enabled: " + ticketSection.isEnabled());
    }
    public void whyVisibility() {


        WebElement ticketSection = wait.until(driver -> {
            List<WebElement> elements = driver.findElements(ticketSectionBtn);

            for (WebElement element : elements) {
                if (element.isDisplayed() && element.isEnabled()) {

                    return element;
                }
            }

            return null;

        }
        );
        ticketSection.click();
    }

    public void clickVisibleTicketSection() {

        List<WebElement> ticketSections =
                driver.findElements(ticketSectionBtn);

        for (WebElement ticket : ticketSections) {

            if (ticket.isDisplayed() && ticket.isEnabled()) {

                System.out.println("Visible ticket link found");

                ticket.click();

                return;
            }
        }

        throw new RuntimeException("No visible ticket link found");
    }







    public void submitCommands()
    {
        waitAndClick(acceptBtn);
        waitAndClick(acceptBtn2);
        bypass(ticketSectionBtn);
        bypass(OnedayTicket);
        System.out.println("Before date step: " + driver.getTitle() + " " + driver.getCurrentUrl());
        switchWindows();
        clickDate();
        clickPlusButton(plusButton1, 0);
        clickPlusButton(plusButton2, 1);
        clickPlusButton(plusButton3,5 );
        clickPlusButton(plusButton4, 9);
        clickPlusButton(plusButton5, 10);
        clickWait2(continueBtn);
        clickWait2(donationBox);
        clickWait2(donation10);
        clickWait2(addtoOrder);
        clickWait2(continueBtn2);
        clickWait2(homeButton);



    }
}
