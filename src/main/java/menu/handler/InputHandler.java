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

    public Coaches getCoaches() {
        List<Coach> coaches = ErrorCatcher.returnRetryHandler(this::getCoachList);
        coaches.forEach(coach -> {
                    List<String> uneatableFoods = ErrorCatcher.returnRetryHandler(()->getUnEatableFoodList(coach.getName()));
                    coach.setFoodsCannotEat(uneatableFoods);
                });
        return new Coaches(coaches);
    }

    private List<Coach> getCoachList() {
        String coaches = inputView.getCoaches();
        inputValidator.validateCoachNameInput(coaches);
        return Arrays.asList(coaches.split(",")).stream()
                .map(Coach::new)
                .collect(Collectors.toList());
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
