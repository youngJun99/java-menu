package menu.domain;

import menu.dto.CoachMenuDto;

import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private static final int COACH_LENGTH_UPPER_LIMIT = 5;
    private static final int COACH_LENGTH_LOWER_LIMIT = 2;

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<String> getCoachNames() {
        return coaches.stream()
                .map(Coach::getName)
                .collect(Collectors.toList());
    }

    public boolean setCoachMenu(String coachName, String menuName) {
        return coaches.stream()
                .filter(coach -> coach.getName().equals(coachName))
                .map(coach -> coach.setNextMenu(menuName))
                .findFirst()
                .get();
    }

    public List<CoachMenuDto> getCoachMenus() {
        return coaches.stream()
                .map(Coach::getCoachMenu)
                .collect(Collectors.toList());
    }

}
