package menu.controller;

import menu.domain.coach.Coaches;
import menu.dto.CategoryDTO;
import menu.dto.CoachMenuDTO;
import menu.service.CoachSettingService;
import menu.service.RandomMenuMatchingService;
import menu.view.OutputView;

import java.util.List;

public class Controller {

    private final CoachSettingService coachSettingService;
    private final RandomMenuMatchingService randomMenuMatchingService;
    private final OutputView outputView;

    public Controller(CoachSettingService coachSettingService, RandomMenuMatchingService randomMenuMatchingService, OutputView outputView) {
        this.coachSettingService = coachSettingService;
        this.randomMenuMatchingService = randomMenuMatchingService;
        this.outputView = outputView;
    }

    public void run() {
        Coaches coaches = coachSettingService.InitializeCoaches();
        CategoryDTO categoryDTO = randomMenuMatchingService.matchRandomMenuCategory();
        List<CoachMenuDTO> coachMenuDTOList = randomMenuMatchingService.matchRandomMenu(coaches);
        outputView.printCategoryOutput(categoryDTO);
        outputView.printCoachMatchedOutput(coachMenuDTOList);
    }
}
