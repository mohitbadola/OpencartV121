package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
    public AccountRegistrationPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement txtLastname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkdPolicy;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    public void setTxtFirstname(String fname){
        txtFirstname.sendKeys(fname);
    }
    public void setLastName(String lname){
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }

    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy(){
//        chkdPolicy.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", chkdPolicy);
    }


    public void clickSubmit(){
//        btnSubmit.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnSubmit);
    }

    public String getConfirmationMsg(){
        try{
            return (msgConfirmation.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }
}
