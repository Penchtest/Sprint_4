import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import ru.practikum_services.qa_scooter.MainPage;

public abstract class BaseUITest {
    protected static WebDriver driver;

    @BeforeClass
    public static void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().window().maximize();
        MainPage objMainPage = new MainPage(driver);
        objMainPage.closeCookieWindow();
    }

    @After
    public void clearData(){
        driver.manage().deleteAllCookies();
        ((WebStorage)driver).getSessionStorage().clear();
        ((WebStorage)driver).getLocalStorage().clear();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }
}
