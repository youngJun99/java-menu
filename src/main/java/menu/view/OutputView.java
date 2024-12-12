package menu.view;

import menu.dto.CoachMenuDto;
import menu.dto.WeeklyMenuCategoryDto;

import java.util.List;

public class OutputView {

    private static final String WEEKLY_CATEGORY_PRINT_FORMAT = "[ 카테고리 | %s | %s | %s | %s | %s ]";
    private static final String COACH_MENU_PRINT_FORMAT = "[ %s | %s | %s | %s | %s | %s ]";


    public void printResults(WeeklyMenuCategoryDto weeklyMenuCategoryDto, List<CoachMenuDto> coachMenuDtos) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        printWeeklyMenuCategory(weeklyMenuCategoryDto);
        printCoachMenus(coachMenuDtos);
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printWeeklyMenuCategory(WeeklyMenuCategoryDto weeklyMenuCategoryDto) {
        System.out.println(String.format(WEEKLY_CATEGORY_PRINT_FORMAT,
                weeklyMenuCategoryDto.getMondayCategory(),
                weeklyMenuCategoryDto.getTuesdayCategory(),
                weeklyMenuCategoryDto.getWednesdayCategory(),
                weeklyMenuCategoryDto.getThursdayCategory(),
                weeklyMenuCategoryDto.getFridayCategory()));
    }

    private void printCoachMenus(List<CoachMenuDto> coachMenuDtos) {
        coachMenuDtos.forEach(coachMenuDto -> {
            System.out.println(String.format(COACH_MENU_PRINT_FORMAT,
                    coachMenuDto.getName(),
                    coachMenuDto.getMondayMenu(),
                    coachMenuDto.getTuesdayMenu(),
                    coachMenuDto.getWednesdayMenu(),
                    coachMenuDto.getThursdayMenu(),
                    coachMenuDto.getFridayMenu()));
        });
    }

}



