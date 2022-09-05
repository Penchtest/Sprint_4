import org.junit.Test;
import ru.practikum_services.qa_scooter.MainPage;

import static org.junit.Assert.assertEquals;


public class FaqTest extends BaseUITest {

    @Test
    public void checkFaqHowMuchCost() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqHowMuchCost());
    }

    @Test
    public void checkFaqSeveralScooters() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqSeveralScooters());
    }

    @Test
    public void checkFaqRentTime() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqRentTime());
    }

    @Test
    public void checkFaqRentToday() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqRentToday());
    }

    @Test
    public void checkFaqRentLonger() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqRentLonger());
    }

    @Test
    public void checkFaqCharge() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqCharge());
    }

    @Test
    public void checkFaqCancelOrder() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqCancelOrder());
    }

    @Test
    public void checkFaqMkad() {
        MainPage objMainPage = new MainPage(driver);
        String expectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        assertEquals("Текст не сходится", expectedAnswer, objMainPage.getAnswerFaqMkad());
    }
}
