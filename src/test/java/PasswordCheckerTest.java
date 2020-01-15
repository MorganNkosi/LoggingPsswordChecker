import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {

    @Test
    void hasSpecial() {
        PasswordChecker special = new PasswordChecker();

        assertTrue(PasswordChecker.hasSpecial("HelloW0rld@"));
    }

    @Test
    void passwordIsValid() {
        PasswordChecker valid = new PasswordChecker();
        assertTrue(PasswordChecker.passwordIsValid("HelloWorld12#"));
    }

    @Test
    void passwordIsOk() {
        PasswordChecker isOk = new PasswordChecker();
        assertTrue(PasswordChecker.passwordIsOk("HelloW0rld"));
    }
}