package gov.uk.check.visa.utlities;

import gov.uk.check.visa.browserfactory.ManageBrowser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    public Utility() {
    }

    public void typeKeysAndEnter(String key) {
        Actions actions = new Actions(driver);
        actions.keyDown(key.toLowerCase()).keyUp(key.toLowerCase()).sendKeys(new CharSequence[]{Keys.ENTER}).build().perform();
    }

    public int generateRandomNumber() {
        return (int)(Math.random() * 5000.0 + 1.0);
    }

    public static String getRandomString(int length) {
        StringBuilder sb = new StringBuilder();
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        for(int i = 0; i < length; ++i) {
            int index = (int)(Math.random() * (double)characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    public void sendTextToElement(WebElement element, String str) {
        element.sendKeys(new CharSequence[]{str});
    }

    public List<WebElement> webElementList(By by) {
        return driver.findElements(by);
    }

    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(new CharSequence[]{Keys.CONTROL + "a"});
        driver.findElement(by).sendKeys(new CharSequence[]{Keys.DELETE});
    }

    public void sendTabAndEnterKey(By by) {
        driver.findElement(by).sendKeys(new CharSequence[]{Keys.TAB});
    }

    public void switchToAlert() {
        driver.switchTo().alert();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    public void selectByVisibleTextFromDropDown(WebElement element, String text) {
        (new Select(element)).selectByVisibleText(text);
    }

    public void selectByValueFromDropDown(By by, String value) {
        (new Select(driver.findElement(by))).selectByValue(value);
    }

    public void selectByValueFromDropDown(WebElement element, String value) {
        (new Select(element)).selectByValue(value);
    }

    public void selectByIndexFromDropDown(By by, int index) {
        (new Select(driver.findElement(by))).selectByIndex(index);
    }

    public void selectByIndexFromDropDown(WebElement element, int index) {
        (new Select(element)).selectByIndex(index);
    }

    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = (new Select(driver.findElement(by))).getOptions();
        Iterator var4 = allOptions.iterator();

        while(var4.hasNext()) {
            WebElement options = (WebElement)var4.next();
            if (options.getText().contains(text)) {
                options.click();
            }
        }

    }

    public void closeAllWindows(List<String> hList, String parentWindow) {
        Iterator var3 = hList.iterator();

        while(var3.hasNext()) {
            String str = (String)var3.next();
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }

    }

    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        Iterator var3 = hList.iterator();

        String title;
        do {
            if (!var3.hasNext()) {
                return false;
            }

            String str = (String)var3.next();
            title = driver.switchTo().window(str).getTitle();
        } while(!title.contains(windowTitle));

        System.out.println("Found the right window....");
        return true;
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void mouseHoverToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().perform();
    }

    public void mouseHoverToElementAndClick(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds((long)time));
        return (WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(final By by, int time, int pollingTime) {
        Wait<WebDriver> wait = (new FluentWait(driver)).withTimeout(Duration.ofSeconds((long)time)).pollingEvery(Duration.ofSeconds((long)pollingTime)).ignoring(NoSuchElementException.class);
        WebElement element = (WebElement)wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }

    public boolean verifyThatElementIsDisplayed(By by) {
        WebElement element = driver.findElement(by);
        return element.isDisplayed();
    }

    public boolean verifyThatElementIsDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        return text.equals(element.getText());
    }

    public boolean verifyThatTextIsDisplayed(WebElement element, String text) {
        return text.equals(element.getText());
    }

    public static void takeScreenShot() {
        String filePath = System.getProperty("user.dir") + "/src/main/java/com/nopcommerce/demo/screenshots/";
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File scr1 = (File)screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(scr1, new File(filePath + getRandomString(10) + ".jpg"));
        } catch (IOException var4) {
            IOException e = var4;
            e.printStackTrace();
        }

    }

    public static String currentTimeStamp() {
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");
    }

    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File scr1 = (File)screenshot.getScreenshotAs(OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;

        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException var7) {
            IOException e = var7;
            e.printStackTrace();
        }

        return destination;
    }

    public static byte[] getScreenShot() {
        return (byte[])((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}


