package tesssst.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginTest {
    public static void main(String[] args) {
    	 //Khởi tạo browser với Chrome
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        try {
            // 1. Mở trang đăng nhập Facebook
            driver.get("https://www.facebook.com");

            // 2. Nhập tên người dùng
            WebElement emailField = driver.findElement(By.id("email"));
            emailField.sendKeys("dangquyetchi273@gmail.com");

            // 3. Nhập mật khẩu
            WebElement passwordField = driver.findElement(By.id("pass"));
            passwordField.sendKeys("dangquyetchi273");

            // 4. Nhấn nút đăng nhập
            WebElement loginButton = driver.findElement(By.name("login"));
            loginButton.click();

            // 5. Đợi một chút để trình duyệt chuyển hướng
            Thread.sleep(5000);

            // 6. Kiểm tra nếu người dùng được chuyển hướng đến trang chính
            String currentURL = driver.getCurrentUrl();
            if (currentURL.contains("facebook.com")) {
                System.out.println("Đăng nhập thành công - Test Passed!");
            } else {
                System.out.println("Đăng nhập không thành công - Test Failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt sau khi kiểm thử xong
            driver.quit();
        }
    }
}

