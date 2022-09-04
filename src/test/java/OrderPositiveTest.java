import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.practikum_services.qa_scooter.MainPage;
import ru.practikum_services.qa_scooter.OrderPage;


//Проверка создания заказа

@RunWith(Parameterized.class)

public class OrderPositiveTest extends BaseUITest{
    private final String scenario;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String deliveryTime;
    private final int days;
    private final String colour;
    private final String comment;


    public OrderPositiveTest(String scenario, String name, String surname, String address, String metro, String phone, String deliveryTime, int days, String colour, String comment) {
        this.scenario = scenario;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.deliveryTime = deliveryTime;
        this.days = days;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"ByHeaderButton", "Елена", "Рогова", "Москва", "ВДНХ", "+79163556518", "01.09.2022", 1, "серая безысходность", "комментарий"},
                {"ByMiddleButton", "Иван", "Иванов", "Иваново", "Филёвский парк", "+79153054309", "10.10.2023", 6, "чёрный жемчуг", "Привезите поскорее"},
        };
    }

    @After
    public void goToStartUrl(){
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void checkSuccessfulOrderByHeaderButton()  {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieWindow();
        objMainPage.clickOrderButtonByScenario(scenario);
        OrderPage objPage = new OrderPage(driver);
        objPage.fillOrderForm(name, surname, address, metro, phone, deliveryTime, days, colour, comment);
        objPage.confirmOrder();
        Assert.assertTrue("Заказ должен сформроваться", objPage.checkOrder());
    }


}