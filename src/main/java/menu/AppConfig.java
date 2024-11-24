package menu;

import menu.controller.Controller;
import menu.domain.random.RandomNumberGeneratorImpl;
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
                        new RandomNumberGeneratorImpl()),
                new OutputView());
    }
}
