package menu.domain;

import menu.constants.Errors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CoachesTest {

    @ParameterizedTest
    @DisplayName("코치들은 2명에서 5명 사이여야 한다.")
    @ValueSource(strings = {"코치일", "코치일,코치이,코치삼,코치사,코치오,코치육"})
    void invalidCoachesInput(String input) {
        assertThatThrownBy(() -> {
            Coaches coaches = generate(input);
        }).hasMessageContaining(String.format(Errors.COACHES_RANGE.getMessage(), 2, 5));
    }

    private Coaches generate(String input) {
        return new Coaches(Arrays.asList(input.split(",")).stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }

}
