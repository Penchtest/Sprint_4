package ru.practikum_services.qa_scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    //цвета самокатов
    public static final String BLACK_COLOUR = "чёрный жемчуг";
    public static final String GREY_COLOUR = "серая безысходность";

    //Поле ввода "Имя"
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле ввода "Фамилия"
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле ввода "Адрес"
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле ввода "Станция метро"
    private By metroField = By.xpath("//input[@placeholder='* Станция метро']");
    //Поле ввода "Телефон"
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка "Далее"
    private By nextButton = By.xpath("//button[text()='Далее']");
    //Поле для ввода даты
    private By deliveryTimeField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Элементы выпадающего списка со сроком аренды
    private By timeRentDropDown  = By.xpath("//div[@class='Dropdown-option']");
    //Поле "Срок аренды"
    private By timeRentField = By.xpath("//div[text()='* Срок аренды']");
    //Чекбокс для цвета чёрный жемчуг
    private By blackColourCheckbox = By.xpath("//input[@id='black']");
    //Чекбокс для цвета серая безысходность
    private By greyColourCheckbox = By.xpath("//input[@id='grey']");
    //Поле для комментария
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Кнопка "Заказать"
    private By orderButton = By.xpath("(//button[text()='Заказать'])[2]");
    //Кнопка "Да" в подтверждении заказа
    private By yesButton = By.xpath(".//button[text()='Да']");
    //Окно с информацией об успешно созданном заказе
    private By orderModalWindow = By.xpath("//div[@class='Order_ModalHeader__3FDaJ']");

    //Подсказка при вводе некорректного имени
    private By nameErrorMessage = By.xpath(".//div[text()='Введите корректное имя']");
    //Подсказка при вводе некорректного имени
    private By surnameErrorMessage = By.xpath(".//div[text()='Введите корректную фамилию']");
    //Подсказка при вводе некорректного имени
    private By addressErrorMessage = By.xpath(".//div[text()='Введите корректный адрес']");
    //Подсказка при вводе некорректного имени
    private By metroErrorMessage = By.xpath(".//div[text()='Выберите станцию']");
    //Подсказка при вводе некорректного имени
    private By phoneErrorMessage = By.xpath(".//div[text()='Введите корректный номер']");

    //Кнопка "Статус заказа"
    private By statusOrderButton = By.xpath(".//button[text()='Статус заказа']");
    //Поле для ввода номера заказа
    private By orderNumberField = By.xpath(".//input[@placeholder='Введите номер заказа']");
    //Кнопка Go
    private By goButton = By.xpath(".//button[text()='Go!']");
    //Картинка "Заказ не найден"
    private By orderNotFoundImage = By.xpath(".//img[@alt='Not found']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //Заполнение формы заказа
    public void fillOrderForm (String name, String surname, String address, String metro, String phone, String deliveryTime, int days, String colour, String comment) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).sendKeys(metro);
        driver.findElement(metroField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(metroField).sendKeys(Keys.ENTER);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
        driver.findElement(deliveryTimeField).sendKeys(deliveryTime);
        driver.findElement(deliveryTimeField).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(timeRentField).click();
        (driver.findElements(timeRentDropDown)).get(days-1).click();
        if (colour.equals(BLACK_COLOUR)) {
            driver.findElement(blackColourCheckbox).click();}
        if (colour.equals(GREY_COLOUR)) {
            driver.findElement(greyColourCheckbox).click();}
        driver.findElement(commentField).sendKeys(comment);
        driver.findElement(orderButton).click();
    }

    //методы для получения ошибок при некорректных данных
    public void fillNameOrderForm(String name){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(nextButton).click();
    }
    public void fillSurnameOrderForm(String surname){
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(nextButton).click();
    }
    public void fillAddressOrderForm(String address){
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(nextButton).click();
    }
    public void emptyMetroOrderForm(){
        driver.findElement(nextButton).click();
    }
    public void fillPhoneOrderForm(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(nextButton).click();
    }

    //метод подтверждения заказа
    public void confirmOrder(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(yesButton));
        driver.findElement(yesButton).click();}

    //поиск окна с информацией о созданном заказе
    public boolean checkOrder(){
        return driver.findElement(orderModalWindow).isDisplayed();}

    //получение текста ошибки при вводе некорректных данных
    public String getNameErrorMessage(){
        return driver.findElement(nameErrorMessage).getText();
    }
    public String getSurNameErrorMessage(){
        return driver.findElement(surnameErrorMessage).getText();
    }
    public String getAddressErrorMessage(){
        return driver.findElement(addressErrorMessage).getText();
    }
    public String getMetroErrorMessage(){
        return driver.findElement(metroErrorMessage).getText();
    }
    public String getPhoneErrorMessage(){
        return driver.findElement(phoneErrorMessage).getText();
    }

    //Ввести номер заказа
    public void enterOrderNumber(String orderNumber){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(statusOrderButton));
        driver.findElement(statusOrderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderNumberField));
        driver.findElement(orderNumberField).sendKeys(orderNumber);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(goButton));
        driver.findElement(goButton).click();
    }

    //Проверка, появилось ли окно с информацией о заказе
    public boolean orderNotFoundIsDisplayed(){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(orderNotFoundImage));
        return driver.findElement(orderNotFoundImage).isDisplayed();}
}







