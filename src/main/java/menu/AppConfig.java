package menu;

import menu.controller.Controller;
import menu.domain.random.RandomCategoryPicker;
import menu.domain.random.RandomMenuPicker;
import menu.handler.InputHandler;
import menu.handler.InputValidator;
import menu.service.RandomMenuService;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    public Controller controller() {
        return new Controller(
                new RandomMenuService(
                        new InputHandler(
                                new InputView(),
                                new InputValidator()),
                        new RandomCategoryPicker(),
                        new RandomMenuPicker()),
                new OutputView());
    }
}
