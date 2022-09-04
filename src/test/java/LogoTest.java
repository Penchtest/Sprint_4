import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practikum_services.qa_scooter.MainPage;

import java.time.Duration;

public class LogoTest extends BaseUITest{

    @Test
    public void checkLogoScooterLink(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickLogoScooter();
        Assert.assertEquals("Ссылка неверна", "https://qa-scooter.praktikum-services.ru/", driver.getCurrentUrl());
    }

    @Test
    public void checkLogoYandexLink() {
        MainPage objMainPage = new MainPage(driver);
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        objMainPage.clickLogoYandex();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.urlContains("http"));
        Assert.assertEquals("Ссылка неверна", "https://yandex.ru/", driver.getCurrentUrl());}
}