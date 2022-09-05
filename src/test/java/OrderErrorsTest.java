import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.practikum_services.qa_scooter.MainPage;
import ru.practikum_services.qa_scooter.OrderPage;

public class OrderErrorsTest extends BaseUITest {

    @Before
    public void clickOrderButtonHeader() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickOrderButtonHeader();
    }

    @Test
    public void checkOrderFormNameErrorMessages() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillNameOrderForm("Elena");
        Assert.assertEquals("Текст ошибки для поля Имя неверный", "Введите корректное имя", objOrderPage.getNameErrorMessage());
    }

    @Test
    public void checkOrderFormSurnameErrorMessages() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillSurnameOrderForm("Rogova");
        Assert.assertEquals("Текст ошибки для поля Фамилия неверный", "Введите корректную фамилию", objOrderPage.getSurNameErrorMessage());
    }

    @Test
    public void checkOrderFormAddressErrorMessages() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillAddressOrderForm("Moscow");
        Assert.assertEquals("Текст ошибки для поля Адрес неверный", "Введите корректный адрес", objOrderPage.getAddressErrorMessage());
    }

    @Test
    public void checkOrderFormMetroErrorMessages() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.emptyMetroOrderForm();
        Assert.assertEquals("Текст ошибки для поля Метро неверный", "Выберите станцию", objOrderPage.getMetroErrorMessage());
    }

    @Test
    public void checkOrderFormPhoneErrorMessages() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.fillPhoneOrderForm("12345");
        Assert.assertEquals("Текст ошибки для поля Телефон неверный", "Введите корректный номер", objOrderPage.getPhoneErrorMessage());
    }

    @Test
    public void checkOrderNotFound() {
        OrderPage objOrderPage = new OrderPage(driver);
        objOrderPage.enterOrderNumber("123");
        Assert.assertTrue("Заказ не найден не отображается", objOrderPage.orderNotFoundIsDisplayed());
    }
}
