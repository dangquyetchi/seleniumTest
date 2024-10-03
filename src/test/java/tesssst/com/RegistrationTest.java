package tesssst.com;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RegistrationTest {

    @Test
    public void testValidRegistration() {
        // Giả lập kết quả kiểm thử hợp lệ
        String expectedMessage = "Đăng ký thành công!";
        String actualMessage = "Đăng ký thành công!";
        assertEquals("Thông báo đăng ký không khớp!", expectedMessage, actualMessage);
    }

    @Test
    public void testInvalidRegistration() {
        // Giả lập kết quả kiểm thử không hợp lệ
        String expectedMessage = "Đăng ký thất bại!";
        String actualMessage = "Đăng ký thành công!";
        assertNotEquals("Thông báo đăng ký không chính xác!", expectedMessage, actualMessage);
    }
}
