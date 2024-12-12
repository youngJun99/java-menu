package menu.handler;

import menu.constants.Errors;
import menu.constants.MenuCategory;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String COACH_VALIDATION_REGEX = "^[가-힣]+(,[가-힣]+)*$";
    private static final String UNEATABLE_FOOD_VALIDATION_REGEX  = "^$|^[가-힣\\s]+(,([가-힣\\s]+))*$";

    public void validateCoachNameInput(String input) {
        if(!input.matches(COACH_VALIDATION_REGEX)){
            throw new IllegalArgumentException(Errors.INVALID_COACH_INPUT.getMessage());
        }
    }

    public void validateUneatableFoodInput(String input) {
        if(!input.matches(UNEATABLE_FOOD_VALIDATION_REGEX)){
            throw new IllegalArgumentException(Errors.INVALID_COACH_UNEATABLE_FOOD_INPUT.getMessage());
        }
        if(input.isBlank()){
            return;
        }
        List<String> menus = Arrays.asList(input.split(","));
        boolean menuIsValid = menus.stream()
                .allMatch(MenuCategory::menuIsValid);
        if(!menuIsValid) {
            throw new IllegalArgumentException(Errors.NO_SUCH_MENU.getMessage());
        }
    }


}

