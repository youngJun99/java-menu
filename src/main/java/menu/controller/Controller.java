package menu.controller;

import menu.dto.CoachMenuDto;
import menu.dto.WeeklyMenuCategoryDto;
import menu.service.RandomMenuService;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    private final RandomMenuService randomMenuService;
    private final OutputView outputView;

    public Controller(RandomMenuService randomMenuService, OutputView outputView) {
        this.randomMenuService = randomMenuService;
        this.outputView = outputView;
    }

    public void run() {
        randomMenuService.initializeService();
        WeeklyMenuCategoryDto weeklyMenuCategoryDto = randomMenuService.getWeeklyMenuCategory();
        List<CoachMenuDto> coachMenuDtos = randomMenuService.getCoachMenus();
        outputView.printResults(weeklyMenuCategoryDto, coachMenuDtos);
    }
}
