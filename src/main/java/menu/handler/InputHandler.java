package menu.handler;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.utils.ErrorCatcher;
import menu.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputHandler {

    private final InputView inputView;
    private final InputValidator inputValidator;

    public InputHandler(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public Coaches requestCoaches() {
        return ErrorCatcher.returnRetryHandler(this::getCoaches);
    }

    private Coaches getCoaches() {
        String coaches = inputView.getCoaches();
        inputValidator.validateCoachNameInput(coaches);
        return new Coaches(Arrays.asList(coaches.split(",")).stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }

    public void setUneatableFood(Coaches coaches) {
        List<String> coachNames = coaches.getCoachNames();
        coachNames.forEach(coachName -> {
            List<String> unEatableFoodList = ErrorCatcher.returnRetryHandler(()->getUnEatableFoodList(coachName));
            coaches.setUnEatableFoodFor(coachName,unEatableFoodList);
        });
    }

    private List<String> getUnEatableFoodList(String name) {
        String input = inputView.getUnEatableFoodOfCoach(name);
        inputValidator.validateUneatableFoodInput(input);
        if(input.isBlank()){
            return new ArrayList<>();
        }
        return Arrays.asList(input.split(","));
    }

}
