package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.User;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
    private final By makeAppointment = By.id("btn-make-appointment");
    private final By usernameField = By.cssSelector("#txt-username");
    private final By passwordField = By.cssSelector("#txt-password");
    private final By loginButton = By.cssSelector("#btn-login");
    private final By facilityDropDown = By.cssSelector("#combo_facility");
    private final By apply = By.cssSelector("#chk_hospotal_readmission");
    private final By radioButton = By.cssSelector("#radio_program_medicaid");
    private final By date = By.cssSelector("#txt_visit_date");
    private final By date2 = By.cssSelector("tbody tr:nth-child(2) td:nth-child(1)");
    private final By comment = By.cssSelector("#txt_comment");
    private final By bookButton = By.cssSelector("#btn-book-appointment");

    private String comment1;


   public String getComment() {
        return comment1;
    }

    public HomePage setComment(String comment1) {
        this.comment1 = comment1;
        return this;
    }
    public HomePage clickMakeAppoinment(){
        wait.until(ExpectedConditions.elementToBeClickable(makeAppointment)).click();
        return this;
    }
    public HomePage enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);

        return this;
    }

    public HomePage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
        return this;
    }

    public HomePage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return this;
    }

    public HomePage login(User user){
        return  enterUsername(user.getUsername()).enterPassword(user.getPassword()).clickLoginButton();
    }

    public HomePage selectFacility(String facility) {
         Select select = new Select(driver.findElement(facilityDropDown));
      select.selectByVisibleText(facility);
        return this;
    }

    public HomePage selectButton(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(apply));

        if(!e.isSelected()){
            e.click();
        }
        return this;
    }
    public HomePage selectRadioButton(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(radioButton));

        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

    public HomePage clickDate(){
        wait.until(ExpectedConditions.elementToBeClickable(date)).click();
        return this;
    }

    public HomePage clickDate2(){
        wait.until(ExpectedConditions.elementToBeClickable(date2)).click();
        return this;
    }

    public HomePage enterComment(String comment2){
        wait.until(ExpectedConditions.visibilityOfElementLocated(comment)).sendKeys(comment2);
        return this;
    }

    public HomePage clickBookButton(){
        wait.until(ExpectedConditions.elementToBeClickable(bookButton)).click();
        return this;
    }

    }
