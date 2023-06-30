package tests;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.object.MainPage;
import page.object.OrderDetails;
@RunWith(Parameterized.class)

public class TestZakaz {
    WebDriver webDriver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String numberPhone;
    private final String time;
    private final String comment;
    private final boolean isOrderButton;

    public TestZakaz(String name, String lastName, String address, String metroStation, String numberPhone, String time, String comment, boolean isOrderButton) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.numberPhone = numberPhone;
        this.time = time;
        this.comment = comment;
        this.isOrderButton = isOrderButton;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][]{
                {"Инна", "Алексеева", "Чонгарский бульвар, д.5, кв. 9", "Речной вокзал", "79087655555", "09.01.2023", "аеноапаоплпр", true},
                {"ИВАН", "Васильев", "Маросейка, 15", "Динамо", "71112223333", "22.08.2023", "отказ", false},
                {"Рената", "Литвинова", "красная площадь, д.1", "Речной вокзал", "77777777777", "08.11.20", "да", true},
                {"Яна", "Альберт", "Римская набережная", "Лубянка", "78909089900", "31.08.2023", "нет", false},
        };
    }

    @Before
    public void setupAll() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","C:\\Users\\KMS\\Documents\\WebDriver\\bin\\geckodriver.exe");
        webDriver= new FirefoxDriver();
    }


    @Test
    public void shouldBeOrderScooterOnButtonPageHeaderWithRequiredFieldTest() {
        OrderDetails OrderDetails = new OrderDetails(webDriver);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
        mainPage.clickButtonCookies();
        mainPage.clickOrderButton(isOrderButton);
        OrderDetails.enterClientDetails(name, lastName, address, metroStation, numberPhone);
        OrderDetails.enterOrderTime(time);
        OrderDetails.clickOrderRentalPeriod();
        OrderDetails.enterOrderRentalTwoDay();
        OrderDetails.clickCheckBoxGreyColorScooter();
        OrderDetails.enterOrderComment(comment);
        OrderDetails.clickOrderButtonOnOrderPage();
        OrderDetails.clickOrderConfirmationButton();
        boolean isDisplayed = OrderDetails.checkOrderConfirmationIsDisplayed();
        Assert.assertTrue("Confirmation is not displayed", isDisplayed);
    }

    @After
    public void tearDown() {

        webDriver.quit();
    }
}