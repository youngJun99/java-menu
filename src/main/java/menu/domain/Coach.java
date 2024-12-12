package menu.domain;

import menu.constants.Errors;
import menu.dto.CoachMenuDto;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int NAME_LENGTH_UPPER_LIMIT = 4;
    private static final int NAME_LENGTH_LOWER_LIMIT = 2;
    private static final int UNEATABLE_FOOD_LOWER_LIMIT = 0;
    private static final int UNEATABLE_FOOD_UPPER_LIMIT = 2;


    private final String name;
    private List<String> uneatableFood;
    private List<String> weekMenu;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.weekMenu = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setFoodsCannotEat(List<String> uneatableFood) {
        validateUneatableFood(uneatableFood);
        this.uneatableFood = uneatableFood;
    }

    public boolean setNextMenu(String menuName) {
        if (!uneatableFood.contains(menuName) && !weekMenu.contains(menuName)) {
            weekMenu.add(menuName);
            return true;
        }
        return false;
    }

    //메뉴가 완성된 경우에 실행이 됩니다.
    public CoachMenuDto getCoachMenu() {
        return new CoachMenuDto(name,
                weekMenu.get(0),
                weekMenu.get(1),
                weekMenu.get(2),
                weekMenu.get(3),
                weekMenu.get(4));
    }

    private void validateNameLength(String name) {
        if (name.length() < NAME_LENGTH_LOWER_LIMIT || name.length() > NAME_LENGTH_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.COACH_NAME_RANGE.getMessage(), NAME_LENGTH_LOWER_LIMIT, NAME_LENGTH_UPPER_LIMIT));
        }
    }

    private void validateUneatableFood(List<String> uneatableFood) {
        if (uneatableFood.size() > UNEATABLE_FOOD_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(Errors.UNEATABLE_FOODS_RANGE.getMessage(), UNEATABLE_FOOD_LOWER_LIMIT, UNEATABLE_FOOD_UPPER_LIMIT));
        }
    }

}



