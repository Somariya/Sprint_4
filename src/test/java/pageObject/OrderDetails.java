package pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderDetails {
    private final WebDriver webDriver;
    //локатор поля ввода "Имя"
    private By orderNameField = By.xpath("//input[@placeholder='* Имя']");

    //локатор поля ввода "Фамилия"
    private By orderLastNameField = By.xpath("//input[@placeholder='* Фамилия']");

    //локатор поля "Адрес: куда привезти заказ"
    private By orderAddressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    //локатор поля ввода "Станция метро"
    private By orderMetroStationField = By.className("select-search__input");

    // локатор выпадающего списка метро
    private By orderMetroStationFieldFull = By.xpath("//*[@class='select-search__select']");

    //локатор поля ввода "Телефон: на него позвонит курьер"
    private By orderNumberPhoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //локатор кнопки "Далее"
    private By orderButtonNext = By.xpath("//button[text()='Далее']");

    // локатор поля ввода "Когда привезти самокат"
    private By orderTime = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    //локатор для выбора даты в выпадающем календаре
    private By orderTimeFull = By.xpath("//div[@class='react-datepicker__day react-datepicker__day--016 react-datepicker__day--selected']");

    // локатор для поля "Срок аренды"
    private By orderRentalPeriod = By.xpath("//div[@class='Dropdown-placeholder']");

    //локатор выпадающего списка в поле "Срок аренды" (двое суток)
    private By orderRentalTwoDay = By.xpath("//div[@class='Dropdown-option'] [2]");

    //локатор выпадающего списка в поле "Срок аренды" (четверо суток)
    private By orderRentalFourDay = By.xpath("//div[@class='Dropdown-option'] [4]");

    // локатор чекбокса "Серая безысходность"
    private By checkBoxGreyColorScooter = By.xpath("//input[@id='grey']");

    // локатор чекбокса "Черный жемчуг"
    private By checkBoxBlackColorScooter = By.xpath("//input[@id='black']");

    // локатор кнопки "Заказать"
    private By orderButtonOnOrderPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // локатор кнопки "Да" на странице подтверждения заказа
    private By orderConfirmationButton = By.xpath("//button[text()='Да']");

    // локатор подтверждения заказа
    private By orderConfirmation = By.xpath("//div[text()='Заказ оформлен']");

    //локатор поля ввода "Комментарий для курьера"
    private By orderCommentField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    public OrderDetails(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterOrderName(String name) {
        webDriver.findElement(orderNameField).sendKeys(name);
    }

    public void enterOrderLastName(String lastName) {
        webDriver.findElement(orderLastNameField).sendKeys(lastName);
    }

    public void enterOrderAddress(String address) {
        webDriver.findElement(orderAddressField).sendKeys(address);
    }

    public void enterMetroStation(String metroStation) {
        webDriver.findElement(orderMetroStationField).sendKeys(metroStation);
    }

    public void clickMetroStationFull() {
        webDriver.findElement(orderMetroStationFieldFull).click();
    }

    public void enterNumberPhone(String numberPhone) {
        webDriver.findElement(orderNumberPhoneField).sendKeys(numberPhone);
    }

    public void clickOrderButtonNext() {
        webDriver.findElement(orderButtonNext).click();
    }


    //шаг "Заполнение данных заказчика"

    public void enterClientDetails(String name, String lastName, String address, String metroStation, String numberPhone){
        enterOrderName(name);
        enterOrderLastName(lastName);
        enterOrderAddress(address);
        enterMetroStation(metroStation);
        clickMetroStationFull();
        enterNumberPhone(numberPhone);
        clickOrderButtonNext();

    }
    public void enterOrderTime(String time) {
        webDriver.findElement(orderTime).sendKeys(time, Keys.ENTER);
    }

    public void clickOrderRentalPeriod() {
        webDriver.findElement(orderRentalPeriod).click();
    }

    public void enterOrderRentalTwoDay() {
        webDriver.findElement(orderRentalTwoDay).click();
    }

    public void enterOrderRentalFourDay() {
        webDriver.findElement(orderRentalFourDay).click();
    }

    public void clickCheckBoxGreyColorScooter() {
        webDriver.findElement(checkBoxGreyColorScooter).click();
    }

    public void clickCheckBoxBlackColorScooter() {
        webDriver.findElement(checkBoxBlackColorScooter).click();
    }

    public void enterOrderComment(String comment) {
        webDriver.findElement(orderCommentField).sendKeys(comment);
    }

    public void clickOrderButtonOnOrderPage() {
        webDriver.findElement(orderButtonOnOrderPage).click();
    }

    public void clickOrderConfirmationButton() {
        webDriver.findElement(orderConfirmationButton).click();
    }

    public boolean checkOrderConfirmationIsDisplayed() {
        return webDriver.findElement(orderConfirmation).isDisplayed();
    }
}