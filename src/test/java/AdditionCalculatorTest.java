import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionCalculatorTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        File file = new File("index.html");
        driver.get(file.toURI().toString());
    }

    @Test
    public void testAdditionFunctional() {
        WebElement num1Input = driver.findElement(By.id("number1"));
        WebElement num2Input = driver.findElement(By.id("number2"));
        WebElement addButton = driver.findElement(By.id("addButton"));
        WebElement resultDisplay = driver.findElement(By.id("result"));

        num1Input.sendKeys("25");
        num2Input.sendKeys("75");
        addButton.click();

        assertEquals("Result: 100", resultDisplay.getText());
    }

    @Test
    public void testInvalidInputFunctional() {
        WebElement num1Input = driver.findElement(By.id("number1"));
        WebElement addButton = driver.findElement(By.id("addButton"));
        WebElement resultDisplay = driver.findElement(By.id("result"));

        num1Input.sendKeys("10");
        addButton.click();

        assertEquals("Result: Please enter valid numbers", resultDisplay.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}