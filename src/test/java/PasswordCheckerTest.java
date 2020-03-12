import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    @Test
    void hasSpecial() {
        assertTrue(PasswordChecker.hasSpecial("HelloW0rld@"));
    }

    @Test
    void passwordIsValid() {
        assertTrue(PasswordChecker.passwordIsValid("HelloWorld12#"));
    }

    @Test
    void passwordIsOk() {
        assertTrue(PasswordChecker.passwordIsOk("HelloW0rld"));
    }
}