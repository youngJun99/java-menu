package menu.handler;

import menu.constants.Errors;
import menu.domain.Coach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("코치들의 입력은 한글로 , 구분자를 기준으로 올바르게 입력해야한다.")
    @ValueSource(strings = {"pobi,youngJun", "pobi:youngJun", "pobi,"})
    void invalidCoachesInput(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateCoachNameInput(input);
        }).hasMessageContaining(Errors.INVALID_COACH_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("코치들이 못먹는 음식은, 구분자를 기준으로 올바르게 입력해야 한다.")
    @ValueSource(strings = {"뇨끼?깐풍기", "뇨끼:깐풍기", "뇨끼,"})
    void invalidUneatableFoods(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateUneatableFoodInput(input);
        }).hasMessageContaining(Errors.INVALID_COACH_UNEATABLE_FOOD_INPUT.getMessage());
    }

    @ParameterizedTest
    @DisplayName("코치들이 못먹는 음식은, 반드시 메뉴에 있는 음식이여야 한다.")
    @ValueSource(strings = {"용준라면,포비아", "포비라면", "백종원 라면"})
    void noSuchMenus(String input) {
        assertThatThrownBy(() -> {
            inputValidator.validateUneatableFoodInput(input);
        }).hasMessageContaining(Errors.NO_SUCH_MENU.getMessage());
    }

}
