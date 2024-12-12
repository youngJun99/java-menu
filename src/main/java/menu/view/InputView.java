package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String getCoaches() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return readLine();
    }

    public String getUnEatableFoodOfCoach(String name) {
        System.out.println(name+"(이)가 못 먹는 메뉴를 입력해 주세요.");
        return readLine();
    }

}

