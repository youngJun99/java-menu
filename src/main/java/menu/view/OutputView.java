package menu.view;

import menu.dto.CategoryDTO;
import menu.dto.CoachMenuDTO;

import java.util.List;

public class OutputView {

    private static final String CATEGORY_PRINT_FORMAT = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private static final String COACH_MENU_PRINT_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";

    public void printCategoryOutput(CategoryDTO categories) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.printf(CATEGORY_PRINT_FORMAT,
                categories.getCategories().get(0),
                categories.getCategories().get(1),
                categories.getCategories().get(2),
                categories.getCategories().get(3),
                categories.getCategories().get(4));
    }


    public void printCoachMatchedOutput(List<CoachMenuDTO> result) {
        result.forEach(this::printCoachMenu);
        System.out.println("\n추천을 완료했습니다.");
    }

    private void printCoachMenu(CoachMenuDTO coachMenuDTO) {
        System.out.printf(COACH_MENU_PRINT_FORMAT,
                coachMenuDTO.getName(),
                coachMenuDTO.getMenus().get(0),
                coachMenuDTO.getMenus().get(1),
                coachMenuDTO.getMenus().get(2),
                coachMenuDTO.getMenus().get(3),
                coachMenuDTO.getMenus().get(4));
        System.out.println();
    }

}
