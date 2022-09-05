package ru.practikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    //кнопка "Заказать" в хедере
    private By orderButtonHeader = By.className("Button_Button__ra12g");
    //кнопка "Заказать" в центре страницы
    private By orderButtonMiddle = By.className("Home_FinishButton__1_cWm");
    //кнопка "Все привыкли" в окне с куками
    private By acceptCookieButton = By.id("rcc-confirm-button");

    //Вопрос 1 Сколько это стоит? И как оплатить?
    private By faqHowMuchCost = By.id("accordion__heading-0");
    //Вопрос 2 Хочу сразу несколько самокатов! Так можно?
    private By faqSeveralScooters = By.id("accordion__heading-1");
    //Вопрос 3 Как рассчитывается время аренды?
    private By faqRentTime = By.id("accordion__heading-2");
    //Вопрос 4 Можно ли заказать самокат прямо на сегодня?
    private By faqRentToday = By.id("accordion__heading-3");
    //Вопрос 5 Можно ли продлить заказ или вернуть самокат раньше?
    private By faqRentLonger = By.id("accordion__heading-4");
    //Вопрос 6 Вы привозите зарядку вместе с самокатом?
    private By faqCharge = By.id("accordion__heading-5");
    //Вопрос 7 Можно ли отменить заказ?
    private By faqCancelOrder = By.id("accordion__heading-6");
    //Вопрос 8 Можно ли отменить заказ?
    private By faqMkad = By.id("accordion__heading-7");

    //  Ответ на вопрос 1
    private By answerHowMuchCost = By.xpath("//div[@id='accordion__panel-0']/p");
    //  Ответ на вопрос 2
    private By answerSeveralScooters = By.xpath("//div[@id='accordion__panel-1']/p");
    //  Ответ на вопрос 3
    private By answerRentTime = By.xpath("//div[@id='accordion__panel-2']/p");
    //  Ответ на вопрос 4
    private By answerRentToday = By.xpath("//div[@id='accordion__panel-3']/p");
    //  Ответ на вопрос 5
    private By answerRentLonger = By.xpath("//div[@id='accordion__panel-4']/p");
    //  Ответ на вопрос 6
    private By answerCharge = By.xpath("//div[@id='accordion__panel-5']/p");
    //  Ответ на вопрос 7
    private By answerCancelOrder = By.xpath("//div[@id='accordion__panel-6']/p");
    //  Ответ на вопрос 8
    private By answerMkad = By.xpath("//div[@id='accordion__panel-7']/p");

    //логотип Яндекса
    private By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //логотип Самоката
    private By logoScooter = By.className("Header_LogoScooter__3lsAR");


    public static final String scenarioHeaderButton = "ByHeaderButton";
    public static final String scenarioMiddleButton = "ByMiddleButton";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Закрыть окно с куками
    public void closeCookieWindow() {
        if (driver.findElements(acceptCookieButton).size() > 0) {
            driver.findElement(acceptCookieButton).click();
        }
    }

    //Проверка соответствия ответов на вопросы
    public String getAnswerFaqHowMuchCost() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqHowMuchCost));
        driver.findElement(faqHowMuchCost).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerHowMuchCost));
        return (driver.findElement(answerHowMuchCost).getText());

    }

    public String getAnswerFaqSeveralScooters() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqSeveralScooters));
        driver.findElement(faqSeveralScooters).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerSeveralScooters));
        return (driver.findElement(answerSeveralScooters).getText());
    }

    public String getAnswerFaqRentTime() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentTime));
        driver.findElement(faqRentTime).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerRentTime));
        return (driver.findElement(answerRentTime).getText());
    }

    public String getAnswerFaqRentToday() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentToday));
        driver.findElement(faqRentToday).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerRentToday));
        return (driver.findElement(answerRentToday).getText());
    }

    public String getAnswerFaqRentLonger() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentLonger));
        driver.findElement(faqRentLonger).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerRentLonger));
        return (driver.findElement(answerRentLonger).getText());
    }

    public String getAnswerFaqCharge() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqCharge));
        driver.findElement(faqCharge).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerCharge));
        return (driver.findElement(answerCharge).getText());
    }

    public String getAnswerFaqCancelOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqCancelOrder));
        driver.findElement(faqCancelOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerCancelOrder));
        return (driver.findElement(answerCancelOrder).getText());
    }

    public String getAnswerFaqMkad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqMkad));
        driver.findElement(faqMkad).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerMkad));
        return (driver.findElement(answerMkad).getText());
    }

    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonMiddle() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickOrderButtonByScenario(String scenario) {
        if (scenario.equals(scenarioHeaderButton))
            driver.findElement(orderButtonHeader).click();
        if (scenario.equals(scenarioMiddleButton))
            driver.findElement(orderButtonMiddle).click();
    }


    //Нажатие логотипов
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }

    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }

}