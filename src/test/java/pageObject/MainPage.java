package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver webDriver;

    //кнопка Заказать1
    private final By orderOne = By.xpath("//Button[@class='Button_Button__ra12g']");
    //кнопка Заказать2
    private final By orderTwo = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //вопросы о важном (список)


    //локатор вопроса "Сколько это стоит и как оплатить?"
    private final By oneQuestion = By.xpath("(//div[@class='accordion__heading'])[1]");

    //локатор текста ответа 1
    private final By oneAnswer = By.xpath("//*[@id='accordion__panel-0']/p");

    //локатор вопроса "Хочу сразу несколько самокатов! Так можно?"
    private final By twoQuestion = By.xpath("(//div[@class='accordion__heading'])[2]");

    //локатор текста ответа 2
    private final By twoAnswer = By.xpath("//*[@id='accordion__panel-1']/p");

    //локатор вопроса "Как рассчитывается время аренды?"
    private final By threeQuestion = By.xpath("(//div[@class='accordion__heading'])[3]");

    //локатор текста ответа 3
    private final By threeAnswer = By.xpath("//*[@id='accordion__panel-2']/p");

    //локатор вопроса "Можно ли заказать самокат прямо на сегодня?"
    private final By fourQuestion = By.xpath("(//div[@class='accordion__heading'])[4]");

    //локатор текста ответа 4
    private final By fourAnswer = By.xpath("//*[@id='accordion__panel-3']/p");

    //локатор вопроса "Можно ли продлить заказ или вернуть самокат раньше?"
    private final By fiveQuestion = By.xpath("(//div[@class='accordion__heading'])[5]");

    //локатор текста ответа 5
    private final By fiveAnswer = By.xpath("//*[@id='accordion__panel-4']/p");

    //локатор вопроса "Вы привозите зарядку вместе с самокатом?"
    private final By sixQuestion = By.xpath("(//div[@class='accordion__heading'])[6]");

    //локатор текста ответа 6
    private final By sixAnswer = By.xpath("//*[@id='accordion__panel-5']/p");

    //локатор вопроса "Можно ли отменить заказ?"
    private final By sevenQuestion = By.xpath("(//div[@class='accordion__heading'])[7]");

    //локатор текста ответа 7
    private final By sevenAnswer = By.xpath("//*[@id='accordion__panel-6']/p");

    //локатор вопроса "Я жизу за МКАДом, привезёте?"
    private final By eightQuestion = By.xpath("(//div[@class='accordion__heading'])[8]");

    //локатор текста ответа 8
    private final By eightAnswer = By.xpath("//*[@id='accordion__panel-7']/p");

    // локатор кнопки куков
    private final By buttonCookies = By.id("rcc-confirm-button");



    public MainPage(WebDriver webDriver){

        this.webDriver=webDriver;
    }

    public void open() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }
    public void clickOrderButton(boolean isOrderButton) {
        if (isOrderButton) {
            webDriver.findElement(orderOne).click();
        } else {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(orderTwo));
            webDriver.findElement(orderTwo).click();
        }
    }
    public void scrollToQuestion(By dropQuestion) {
        WebElement dropDownQuestionElement = webDriver.findElement(dropQuestion);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", dropDownQuestionElement);
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(dropDownQuestionElement));
    }
    public String clickDropDownQuestion(String dropDownQuestion) {
        if ("Сколько это стоит? И как оплатить?".equals(dropDownQuestion)) {
            scrollToQuestion(oneQuestion);
            webDriver.findElement(oneQuestion).click();
            return webDriver.findElement(oneAnswer).getText();
        } else if ("Хочу сразу несколько самокатов! Так можно?".equals(dropDownQuestion)) {
            scrollToQuestion(twoQuestion);
            webDriver.findElement(twoQuestion).click();
            return webDriver.findElement(twoAnswer).getText();
        } else if ("Как рассчитывается время аренды?".equals(dropDownQuestion)) {
            scrollToQuestion(threeQuestion);
            webDriver.findElement(threeQuestion).click();
            return webDriver.findElement(threeAnswer).getText();
        } else if ("Можно ли заказать самокат прямо на сегодня?".equals(dropDownQuestion)) {
            scrollToQuestion(fourQuestion);
            webDriver.findElement(fourQuestion).click();
            return webDriver.findElement(fourAnswer).getText();
        } else if ("Можно ли продлить заказ или вернуть самокат раньше?".equals(dropDownQuestion)) {
            scrollToQuestion(fiveQuestion);
            webDriver.findElement(fiveQuestion).click();
            return webDriver.findElement(fiveAnswer).getText();
        } else if ("Вы привозите зарядку вместе с самокатом?".equals(dropDownQuestion)) {
            scrollToQuestion(sixQuestion);
            webDriver.findElement(sixQuestion).click();
            return webDriver.findElement(sixAnswer).getText();
        } else if ("Можно ли отменить заказ?".equals(dropDownQuestion)) {
            scrollToQuestion(sevenQuestion);
            webDriver.findElement(sevenQuestion).click();
            return webDriver.findElement(sevenAnswer).getText();
        } else if ("Я жизу за МКАДом, привезёте?".equals(dropDownQuestion)) {
            scrollToQuestion(eightQuestion);
            webDriver.findElement(eightQuestion).click();
            return webDriver.findElement(eightAnswer).getText();
        } else {
            throw new IllegalArgumentException("Вопрос не найден: " + dropDownQuestion);
        }
    }

    public void clickButtonCookies() {
        webDriver.findElement(buttonCookies).click();
    }

}

