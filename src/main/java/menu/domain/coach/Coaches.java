package menu.domain.coach;

import menu.constants.Errors;

import java.util.List;

public class Coaches {

    private static final int COACHES_RANGE_UPPER_LIMIT = 5;
    private static final int COACHES_RANGE_LOWER_LIMIT = 2;

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

    private void validateCoaches(List<Coach> coaches) {
        if (coaches.size() < COACHES_RANGE_LOWER_LIMIT || coaches.size() > COACHES_RANGE_UPPER_LIMIT) {
            throw new IllegalArgumentException(String.format(
                    Errors.COACHES_RANGE.getMessage(),
                    COACHES_RANGE_LOWER_LIMIT,
                    COACHES_RANGE_UPPER_LIMIT));
        }
    }
}
