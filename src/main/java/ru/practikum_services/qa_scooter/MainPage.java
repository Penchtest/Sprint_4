package ru.practikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

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
    public void closeCookieWindow(){
        if (driver.findElements(acceptCookieButton).size()>0) {driver.findElement(acceptCookieButton).click();}
    }
    //Проверка соответствия ответов на вопросы
    public void checkFaqHowMuchCost() {
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqHowMuchCost));
        driver.findElement(faqHowMuchCost).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerHowMuchCost));
        assertEquals("Текст не сходится", expected, driver.findElement(answerHowMuchCost).getText());
    }

    public void checkFaqSeveralScooters() {
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqSeveralScooters));
        driver.findElement(faqSeveralScooters).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerSeveralScooters));
        assertEquals(expected, driver.findElement(answerSeveralScooters).getText());
    }
    public void checkFaqRentTime() {
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentTime));
        driver.findElement(faqRentTime).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerRentTime));
        assertEquals(expected, driver.findElement(answerRentTime).getText());
    }
    public void checkFaqRentToday() {
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentToday));
        driver.findElement(faqRentToday).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(answerRentToday));
        assertEquals(expected, driver.findElement(answerRentToday).getText());
    }
    public void checkFaqRentLonger() {
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqRentLonger));
        driver.findElement(faqRentLonger).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerRentLonger));
        assertEquals(expected, driver.findElement(answerRentLonger).getText());
    }
    public void checkFaqCharge() {
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqCharge));
        driver.findElement(faqCharge).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerCharge));
        assertEquals(expected, driver.findElement(answerCharge).getText());
    }
    public void checkFaqCancelOrder() {
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqCancelOrder));
        driver.findElement(faqCancelOrder).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerCancelOrder));
        assertEquals(expected, driver.findElement(answerCancelOrder).getText());
    }
    public void checkFaqMkad() {
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(faqMkad));
        driver.findElement(faqMkad).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(answerMkad));
        assertEquals(expected, driver.findElement(answerMkad).getText());
    }
    public void clickOrderButtonHeader(){
        driver.findElement(orderButtonHeader).click();
    }

    public void clickOrderButtonMiddle(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickOrderButtonByScenario(String scenario){
        if (scenario.equals(scenarioHeaderButton))
            driver.findElement(orderButtonHeader).click();
        if (scenario.equals(scenarioMiddleButton))
            driver.findElement(orderButtonMiddle).click();
    }


    //Нажатие логотипов
    public void clickLogoScooter(){
        driver.findElement(logoScooter).click();
    }
    public void clickLogoYandex(){driver.findElement(logoYandex).click();}

}