package menu.handler;

import menu.constants.Errors;

public class InputValidatorImpl implements InputValidator {

    private static final String COACH_INPUT_REGEX = "^([가-힣a-zA-Z]+)(,([가-힣a-zA-Z]+))*$";
    private static final String NON_EATABLE_MENU_REGEX = "^(\\s*|([가-힣]+)(,([가-힣]+))*)$";

    @Override
    public void validateCoachInput(String input) {
        if (DoesNotMatchCoachRegex(input)) {
            throw new IllegalArgumentException(Errors.COACH_INPUT_INVALID.getMessage());
        }
    }

    @Override
    public void validateNonEatableMenuInput(String input) {
        if (DoesnotMatchNonEatableMenuRegex(input)) {
            throw new IllegalArgumentException(Errors.NON_EATABLE_MENU_INPUT_INVALID.getMessage());
        }
    }

    private static boolean DoesnotMatchNonEatableMenuRegex(String input) {
        return !input.matches(NON_EATABLE_MENU_REGEX);
    }

    private static boolean DoesNotMatchCoachRegex(String input) {
        return !input.matches(COACH_INPUT_REGEX);
    }


}
