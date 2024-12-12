package menu;

import menu.controller.Controller;
import menu.domain.Coaches;
import menu.handler.InputHandler;
import menu.handler.InputValidator;
import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Controller controller = appConfig.controller();
        controller.run();;
    }
}
