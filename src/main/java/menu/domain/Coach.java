package menu.domain;

import menu.constants.Errors;

import java.util.List;

public class Coach {

    private static final int NAME_LENGTH_UPPER_LIMIT = 4;
    private static final int NAME_LENGTH_LOWER_LIMIT = 2;
    private static final int UNEATABLE_FOOD_LOWER_LIMIT = 0;
    private static final int UNEATABLE_FOOD_UPPER_LIMIT = 2;


    private final String name;
    private List<String> uneatableFood;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public void setFoodsCannotEat(List<String> uneatableFood) {
        validateUneatableFood(uneatableFood);
        this.uneatableFood = uneatableFood;
    }

    private void validateNameLength(String name) {
        if(name.length() < NAME_LENGTH_LOWER_LIMIT || name.length() > NAME_LENGTH_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.COACH_NAME_RANGE.getMessage(),NAME_LENGTH_LOWER_LIMIT,NAME_LENGTH_UPPER_LIMIT));
        }
    }

    private void validateUneatableFood(List<String> uneatableFood) {
        if(uneatableFood.size() >UNEATABLE_FOOD_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.UNEATABLE_FOODS_RANGE.getMessage(),UNEATABLE_FOOD_LOWER_LIMIT,UNEATABLE_FOOD_UPPER_LIMIT));
        }
    }

}



