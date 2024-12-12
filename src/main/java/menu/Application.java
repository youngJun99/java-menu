package menu;

import menu.domain.Coaches;
import menu.handler.InputHandler;
import menu.handler.InputValidator;
import menu.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler(new InputView(), new InputValidator());
        Coaches coaches = inputHandler.getCoaches();
        System.out.println(coaches);
    }
}
