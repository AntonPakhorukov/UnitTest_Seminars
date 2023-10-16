import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {
    @Test
    void testIntegrationGetUserById() {
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        assertEquals(repo.getUserById(3), service.getUserName(3));
    }
}
