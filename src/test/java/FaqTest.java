import org.junit.Test;
import ru.practikum_services.qa_scooter.MainPage;


public class FaqTest extends BaseUITest{

    @Test
    public void checkFaqHowMuchCost(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqHowMuchCost();
    }

    @Test
    public void checkFaqSeveralScooters(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqSeveralScooters();
    }
    @Test
    public void checkFaqRentTime(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqRentTime();
    }
    @Test
    public void checkFaqRentToday(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqRentToday();
    }

    @Test
    public void checkFaqRentLonger(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqRentLonger();
    }
    @Test
    public void checkFaqCharge(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqCharge();
    }
    @Test
    public void checkFaqCancelOrder(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqCancelOrder();
    }
    @Test
    public void checkFaqMkad(){
        MainPage objMainPage = new MainPage(driver);
        objMainPage.checkFaqMkad();
    }
}
