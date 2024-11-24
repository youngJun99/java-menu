package menu.handler;

import menu.view.InputView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    private static final String DELIMITER = ",";

    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public List<String> getCoaches() {
        inputView.printStartMessage();
        String input = inputView.printGetCoachNames();
        inputValidator.validateCoachInput(input);
        return List.of(input.split(DELIMITER));
    }

    public List<String> getNonEatableMenusOf(String coachName) {
        String input = inputView.printGetNoneEatableMenus(coachName);
        inputValidator.validateNonEatableMenuInput(input);
        if (input.isBlank()) {
            return new ArrayList<>();
        }
        return List.of(input.split(DELIMITER));
    }

}
