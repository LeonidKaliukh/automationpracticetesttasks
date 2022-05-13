package Asserts;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthorizationAsserts {

    public AuthorizationAsserts checkAuthorizationErrors(String expectedError, String actualError) {
        step("check Authorization error ", ()->
                assertThat(expectedError.equals(actualError)));
        return this;
    }
}
