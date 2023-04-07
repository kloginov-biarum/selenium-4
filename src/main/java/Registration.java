import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Registration {
    ChromeDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/ergrevegvrg/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://suninjuly.github.io/registration1.html");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void successfulRegAllFields() throws InterruptedException {
        WebElement firstNameInputFiled =
                driver.findElement(By.cssSelector("input[placeholder='Input your first name']"));
        firstNameInputFiled.sendKeys("John");
        WebElement lastNameInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputFiled.sendKeys("Bright");
        //email, phone, address
        WebElement emailInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys("jbright@gmail.com");
        WebElement phoneInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("423523576");
        WebElement addressInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputFiled.sendKeys("Hdfgsgjdsgh");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
       // sleep(2000);
        submitButton.click();
        WebElement headerSuccess =
                driver.findElement(By.tagName("h1"));
        assertEquals("Congratulations! You have successfully registered!",
                headerSuccess.getText());
        assertTrue(headerSuccess.getText().contains("Congratulations!"));
        System.out.println(driver.getCurrentUrl());
        //registration_result in URL
        assertTrue(driver.getCurrentUrl().contains("registration_result"));
    }
    @Test
    public void withoutFirstName(){
        WebElement lastNameInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your last name']"));
        lastNameInputFiled.sendKeys("Bright");
        //email, phone, address
        WebElement emailInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your email']"));
        emailInputFiled.sendKeys("jbright@gmail.com");
        WebElement phoneInputField =
                driver.findElement(By.cssSelector("[placeholder='Input your phone:']"));
        phoneInputField.sendKeys("423523576");
        WebElement addressInputFiled =
                driver.findElement(By.cssSelector("[placeholder='Input your address:']"));
        addressInputFiled.sendKeys("Hdfgsgjdsgh");
        WebElement submitButton =
                driver.findElement(By.cssSelector("[type='submit']"));
        // sleep(2000);
        submitButton.click();
        WebElement firstNameInputFiled =
                driver.findElement(By.cssSelector("input[placeholder='Input your first name']"));
        assertTrue(firstNameInputFiled.getAttribute("validationMessage").contains("Заполните это поле"));
    }



}
