package menu.service;

import menu.domain.coach.Coach;
import menu.domain.coach.Coaches;
import menu.handler.InputHandler;

import java.util.List;
import java.util.stream.Collectors;

import static menu.utils.ErrorCatcher.voidRetryHandler;

public class CoachSettingService {

    private final InputHandler inputHandler;
    private Coaches coaches;

    public CoachSettingService(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public Coaches InitializeCoaches() {
        SetCoachNames();
        SetNonEatableMenuForEach();
        return coaches;
    }

    private void SetCoachNames() {
        voidRetryHandler(this::CoachInputFromUser);
    }

    private void SetNonEatableMenuForEach() {
        List<String> names = coaches.getCoachNames();
        names.forEach(name -> {
            voidRetryHandler(() -> setNoneEatableMenuFor(name));
        });
    }

    private void setNoneEatableMenuFor(String name) {
        List<String> nonEatableMenus = inputHandler.getNonEatableMenusOf(name);
        coaches.setUnEatableMenuFor(name, nonEatableMenus);
    }

    private void CoachInputFromUser() {
        coaches = new Coaches(inputHandler.getCoaches().stream()
                .map(Coach::new)
                .collect(Collectors.toList()));
    }


}
