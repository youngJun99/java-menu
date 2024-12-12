package menu.domain;

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




}

"""
### 코치들(Coaches)
-[ ] 일단 List<Coach> 로 생각하고 있다. (핸들러에서 잘 넣어줄 것. 완성된 것으로)
        -[ ] 최소 2명에서 최대 5명으로 validate
-[ ] 코치 이름들을 전부 출력하는 getter를 만들자
-[ ] 특정 코치의 이름과 메뉴를 String, String으로 입력해주었을 경우에 성공 여부를 알려준다.
        -[ ] 마지막에 결국 모든 코치들의 이름, 월, 화, 수, 목 ,금 메뉴를 담은 Dto를 뽑아내줄 수 있어야 겠다.


"""
