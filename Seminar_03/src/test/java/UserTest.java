import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void testUserAccess(){
        User user = new User("name", "password", false);
        assertTrue(user.authenticate("name", "password"));
    }
    @Test
    void testUserDenied(){
        User user = new User("name1", "password1", false);
        assertFalse(user.authenticate("name", "password"));
    }
}
