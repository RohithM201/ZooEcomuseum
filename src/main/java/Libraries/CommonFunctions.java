package Libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;
import java.util.Set;

public class CommonFunctions {
    public WebDriver driver;
    public WebDriverWait wait;
    public JavascriptExecutor js;


    public CommonFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
    }

    public CommonFunctions() {
    }


    public void waitAndClick(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (NullPointerException e) {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void bypass(By a) {
        WebElement ticketLink = wait.until(
                ExpectedConditions.presenceOfElementLocated(a)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", ticketLink);
    }

    public void switchWindows() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
    private WebElement firstClickableElement (By locator) {
        for (WebElement element : driver.findElements(locator)) {
            if (element.isDisplayed() && element.isEnabled()) {
                return element;
            }
        }
        return null;
    }

    public void clickWait2(By a) {
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(a));
        try
        { element.click();

        } catch (ElementNotInteractableException e)
        {
            js.executeScript("arguments[0].click();",element);

        }



    }

    private boolean isDisabled(WebElement element)
    {
        String disabled = element.getAttribute("disabled");
        String ariaDisabled = element.getAttribute("aria-disabled");
        String className = element.getAttribute("class");

        return disabled != null
                ||"true".equalsIgnoreCase(ariaDisabled)
                || (className != null && className.toLowerCase().contains("disabled"));
    }

    public int clickPlusButton(By increaseButton, int timesToClick)
    {
        int clicks = 0;

        while (clicks < timesToClick) {
            WebElement button = firstClickableElement(increaseButton);

            if (button == null || isDisabled(button)) {
                return clicks;

            }
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", button);

            try {
                button.click();

            } catch (ElementNotInteractableException e) {
                js.executeScript("arguments[0].click();", button);

            }
            clicks++;



        }
        return clicks;

    }
    public void clickWait1 (By a)
    {
        driver.findElement(a).click();
    }
    public void sendKeys(By a)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String userInput = scanner.nextLine(); //reads text input
        driver.findElement(a).sendKeys(userInput);
    }

}








