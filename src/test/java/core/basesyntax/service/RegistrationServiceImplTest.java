package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RegistrationServiceImplTest {
    private static RegistrationServiceImpl registrationService;
    private static User user;

    @BeforeAll
    static void beforeAll() {
        registrationService = new RegistrationServiceImpl();
        user = new User();
    }

    //login
    @Test
    void register_loginIsNull_ok() {
        user.setLogin(null);
        user.setPassword("abcdef");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_loginContainsSpace_ok() {
        user.setLogin("abc def");
        user.setPassword("abcdef");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_loginIsTooShort_ok() {
        user.setLogin("abc");
        user.setPassword("abcdef");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_loginIsLongEnough_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcdef");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_loginLengthIsMoreThanEnough_ok() {
        user.setLogin("abcdefhij");
        user.setPassword("abcdefghi");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    //password
    @Test
    void register_passwordIsNull_ok() {
        user.setLogin("abcdef");
        user.setPassword(null);
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_passwordContainsSpace_ok() {
        user.setLogin("abcdef");
        user.setPassword("abc def");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_passwordIsTooShort_ok() {
        user.setLogin("abcdef");
        user.setPassword("abc");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_passwordIsLongEnough_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcdef");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_passwordLengthIsMoreThanEnough_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcdefghi");
        user.setAge(20);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    //age
    @Test
    void register_notOldEnough_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcde");
        user.setAge(17);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_isOldEnough_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcdef");
        user.setAge(18);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }

    @Test
    void register_moreThanEnoughOld_ok() {
        user.setLogin("abcdef");
        user.setPassword("abcdef");
        user.setAge(25);
        assertThrows(InvalidDataException.class, () -> registrationService.register(user));
    }
}