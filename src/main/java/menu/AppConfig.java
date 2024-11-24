package menu;

import menu.controller.Controller;
import menu.domain.random.RandomCategoryPickerImpl;
import menu.domain.random.RandomMenuPickerImpl;
import menu.handler.InputHandler;
import menu.handler.InputValidatorImpl;
import menu.service.CoachSettingService;
import menu.service.RandomMenuMatchingService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    public Controller controller() {
        return new Controller(
                new CoachSettingService(
                        new InputHandler(
                                new InputView(),
                                new InputValidatorImpl())),
                new RandomMenuMatchingService(
                        new RandomCategoryPickerImpl(),
                        new RandomMenuPickerImpl()),
                new OutputView());
    }
}
