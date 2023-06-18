package tests;

import POM.mainPage;
import POM.orderDetails;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)

public class testZakaz {
    WebDriver webDriver;
    private final String name;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String numberPhone;
    private final String time;
    private final String comment;
    private final boolean isOrderButton;

    public testZakaz(String name, String lastName, String address, String metroStation, String numberPhone, String time, String comment, boolean isOrderButton) {
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


    @Test
    public void shouldBeOrderScooterOnButtonPageHeaderWithRequiredFieldTest() {
        orderDetails orderPage = new orderDetails(webDriver);
        mainPage mainPage = new mainPage(webDriver);
        mainPage.open();
        mainPage.clickButtonCookies();
        mainPage.clickOrderButton(isOrderButton);
        orderPage.enterOrderName(name);
        orderPage.enterOrderLastName(lastName);
        orderPage.enterOrderAddress(address);
        orderPage.enterMetroStation(metroStation);
        orderPage.clickMetroStationFull();
        orderPage.enterNumberPhone(numberPhone);
        orderPage.clickOrderButtonNext();
        orderPage.enterOrderTime(time);
        orderPage.clickOrderRentalPeriod();
        orderPage.enterOrderRentalTwoDay();
        orderPage.clickCheckBoxGreyColorScooter();
        orderPage.enterOrderComment(comment);
        orderPage.clickOrderButtonOnOrderPage();
        orderPage.clickOrderConfirmationButton();
        boolean isDisplayed = orderPage.checkOrderConfirmationIsDisplayed();
        Assert.assertTrue("Confirmation is not displayed", isDisplayed);
    }

    @After
    public void tearDown() {

        webDriver.quit();
    }
}