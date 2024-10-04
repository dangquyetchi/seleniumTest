package tesssst.com;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserRegistrationTest {
    WebDriver driver;  // Khai báo WebDriver ở cấp lớp

    @Before
    public void setUp() {
        // Khởi tạo WebDriver chỉ một lần ở đây
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Chạy ở chế độ không giao diện
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://localhost:8000/register");  // Thay thế bằng URL của form đăng ký
    }
    // Kiểm thử đăng ký với dữ liệu hợp lệ
    @Test
    public void testValidRegistration() {
        // Điền dữ liệu hợp lệ vào form
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("password_confirmation"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        nameField.sendKeys("John Doe");
        emailField.sendKeys("johndoe@example.com");
        addressField.sendKeys("123 Main Street");
        phoneField.sendKeys("1234567890");
        passwordField.sendKeys("StrongPassword123!");
        confirmPasswordField.sendKeys("StrongPassword123!");
        submitButton.click();

        
    }

    // Kiểm thử với tên người dùng đã tồn tại
    @Test
    public void testExistingUser() {
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("password_confirmation"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        nameField.sendKeys("John Doe");
        emailField.sendKeys("dangquyetchi273@gmail.com");
        addressField.sendKeys("123 Main Street");
        phoneField.sendKeys("1234567890");
        passwordField.sendKeys("StrongPassword123!");
        confirmPasswordField.sendKeys("StrongPassword123!");
        submitButton.click();

        // Kiểm tra thông báo lỗi tên người dùng đã tồn tại
        WebElement errorMessage = driver.findElement(By.className("alert-danger"));
        Assert.assertEquals("Tên người dùng đã tồn tại!", errorMessage.getText());
    }

    // Kiểm thử với mật khẩu yếu
    @Test
    public void testWeakPassword() {
        WebElement nameField = driver.findElement(By.id("name"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement addressField = driver.findElement(By.id("address"));
        WebElement phoneField = driver.findElement(By.id("phone"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("password_confirmation"));
        WebElement submitButton = driver.findElement(By.tagName("button"));

        nameField.sendKeys("New User");
        emailField.sendKeys("newuser@example.com");
        addressField.sendKeys("123 Main Street");
        phoneField.sendKeys("1234567890");
        passwordField.sendKeys("weakpass");
        confirmPasswordField.sendKeys("weakpass");
        submitButton.click();

        // Kiểm tra thông báo lỗi mật khẩu yếu
        WebElement errorMessage = driver.findElement(By.className("alert-danger"));
        Assert.assertEquals("Mật khẩu không đủ mạnh!", errorMessage.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

