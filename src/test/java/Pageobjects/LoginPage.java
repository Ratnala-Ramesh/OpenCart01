package Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
   public LoginPage(WebDriver driver){
	   super(driver);
   }
   @FindBy(xpath="//*[@id='input-email']") WebElement Email;
   @FindBy(xpath="//*[@name='password']") WebElement Password;
   @FindBy(xpath="//*[@value='Login']") WebElement button;
   
   public void Email(String email) {
	   Email.sendKeys(email);
   }
   public void Password(String password) {
	   Password.sendKeys(password);
   }
   public void button() {
	   button.click();
   }
}
