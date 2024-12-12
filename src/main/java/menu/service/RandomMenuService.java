package menu.service;

import menu.constants.MenuCategory;
import menu.domain.Coaches;
import menu.domain.random.RandomCategoryPicker;
import menu.domain.random.RandomMenuPicker;
import menu.dto.CoachMenuDto;
import menu.dto.WeeklyMenuCategoryDto;
import menu.handler.InputHandler;

import java.util.List;

public class RandomMenuService {

    private final InputHandler inputHandler;
    private final RandomCategoryPicker randomCategoryPicker;
    private final RandomMenuPicker randomMenuPicker;
    private List<MenuCategory> weeklyMenuCategory;
    private List<CoachMenuDto> coachMenus;

    public RandomMenuService(InputHandler inputHandler, RandomCategoryPicker randomCategoryPicker, RandomMenuPicker randomMenuPicker) {
        this.inputHandler = inputHandler;
        this.randomCategoryPicker = randomCategoryPicker;
        this.randomMenuPicker = randomMenuPicker;
        this.weeklyMenuCategory = randomCategoryPicker.getWeeklyCategory();
    }

    public void initializeService() {
        Coaches coaches = inputHandler.requestCoaches();
        inputHandler.setUneatableFood(coaches);
        selectRandomMenusFor(coaches);
        this.coachMenus = coaches.getCoachMenus();
    }

    private void selectRandomMenusFor(Coaches coaches) {
        List<String> coachNames = coaches.getCoachNames();
        weeklyMenuCategory.forEach(menuCategory -> {
            coachNames.forEach(coach->{
                String randomMenu = randomMenuPicker.pickRandomMenu(menuCategory);
                boolean menuNotSelected = true;
                while(menuNotSelected){
                    menuNotSelected = !coaches.setCoachMenu(coach,randomMenu);
                }
            });
        });
    }

    public WeeklyMenuCategoryDto getWeeklyMenuCategory() {
        return new WeeklyMenuCategoryDto(
                weeklyMenuCategory.get(0).name(),
                weeklyMenuCategory.get(1).name(),
                weeklyMenuCategory.get(2).name(),
                weeklyMenuCategory.get(3).name(),
                weeklyMenuCategory.get(4).name()
        );
    }

    public List<CoachMenuDto> getCoachMenus() {
        return coachMenus;
    }

}
