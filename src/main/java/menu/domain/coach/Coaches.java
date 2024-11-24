package menu.domain.coach;

import menu.constants.Errors;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public void setUnEatableMenuFor(String coachName, List<String> unEatableMenu) {
        Coach coach = coaches.stream()
                .filter(c -> c.getName().equals(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.COACH_CHECK.getMessage()));

        coach.setNonEatableMenu(unEatableMenu);
    }

    public boolean canEat(String coachName, String menuName) {
        Coach coach = coaches.stream()
                .filter(c -> c.getName().equals(coachName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.COACH_CHECK.getMessage()));
        return coach.canEat(menuName);
    }
}
