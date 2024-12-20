package menu.domain.menu;

import menu.constants.Errors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum MenuEnum {

    일식(1, "일식", "규동,우동,미소시루,스시,가츠동,오니기리,하이라이스,라멘,오코노미야끼"),
    한식(2, "한식", "김밥,김치찌개,쌈밥,된장찌개,비빔밥,칼국수,불고기,떡볶이,제육볶음"),
    중식(3, "중식", "깐풍기,볶음면,동파육,짜장면,짬뽕,마파두부,탕수육,토마토 달걀볶음,고추잡채"),
    아시안(4, "아시안", "팟타이,카오 팟,나시고렝,파인애플 볶음밥,쌀국수,똠얌꿍,반미,월남쌈,분짜"),
    양식(5, "양식", "라자냐,그라탱,뇨끼,끼슈,프렌치 토스트,바게트,스파게티,피자,파니니");

    private final int categoryNumber;
    private final String foodCategoryName;
    private final List<String> menus;

    MenuEnum(int categoryNumber, String foodCategory, String menus) {
        this.categoryNumber = categoryNumber;
        this.foodCategoryName = foodCategory;
        this.menus = List.of(menus.split(","));
    }

    public static boolean contains(String menu) {
        return Arrays.stream(MenuEnum.values())
                .anyMatch(enumValue -> enumValue.menus.contains(menu));
    }

    public static int getNumberOfCategories() {
        return (int) Arrays.stream(MenuEnum.values())
                .count();
    }

    public static String getCategoryName(int index) {
        return Arrays.stream(MenuEnum.values())
                .filter(category -> category.categoryNumber == index)
                .map(MenuEnum::getFoodCategoryName)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.MENU_CHECK.getMessage()));
    }

    public static List<String> getMenusFrom(int index) {
        return new ArrayList<>(Arrays.stream(MenuEnum.values())
                .filter(category -> category.categoryNumber == index)
                .map(MenuEnum::getMenus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Errors.MENU_CHECK.getMessage())));
    }

    public List<String> getMenus() {
        return menus;
    }

    public String getFoodCategoryName() {
        return foodCategoryName;
    }


}
