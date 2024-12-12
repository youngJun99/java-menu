package menu.domain;

import menu.constants.Errors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    private static Coach exampleCoach = new Coach("예시용");

    @ParameterizedTest
    @DisplayName("코치의 이름은 2글자에서 4글자 사이여야 한다.")
    @ValueSource(strings = {"정말정말정말긴이름","이름이네글자이상","김"})
    void invalidCoachName(String input) {
        assertThatThrownBy(() -> {
            Coach coach = new Coach(input);
        }).hasMessageContaining(String.format(Errors.COACH_NAME_RANGE.getMessage(),2,4));
    }

    // 메뉴의 유효성은 validator 에서 담당합니다.
    @ParameterizedTest
    @DisplayName("코치가 못먹는 음식은 최소 0개에서 2개 사이여야 한다.")
    @ValueSource(strings = {"음식1,음식2,음식3","음식1,음식2,음식3,음식4"})
    void invalidUneatableFoods(String input) {
        assertThatThrownBy(() -> {
            exampleCoach.setFoodsCannotEat(Arrays.asList(input.split(",")));
        }).hasMessageContaining(String.format(Errors.UNEATABLE_FOODS_RANGE.getMessage(),0,2));
    }

}
