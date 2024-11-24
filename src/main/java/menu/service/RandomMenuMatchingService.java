package menu.service;

import menu.domain.coach.Coaches;
import menu.domain.menu.MenuEnum;
import menu.domain.random.RandomNumberGenerator;
import menu.dto.CategoryDTO;
import menu.dto.CoachMenuDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomMenuMatchingService {

    private static final int DAYS_TO_MATCH = 5;
    private static final int MAX_DUPLICATE_OF_CATEGORY = 2;

    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> randomCategoryIndex;

    public RandomMenuMatchingService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public CategoryDTO matchRandomMenuCategory() {
        matchRandomMenuCategories();
        return new CategoryDTO(randomCategoryIndex.stream()
                .map(MenuEnum::getCategoryName)
                .collect(Collectors.toList()));
    }

    public List<CoachMenuDTO> matchRandomMenu(Coaches coaches) {
        List<String> coachNames = coaches.getCoachNames();

        return coachNames.stream().map(coach -> {
                    List<String> menus = new ArrayList<>();
                    randomCategoryIndex.forEach(index -> {
                                while (true) {
                                    int randomMenuIndex = randomNumberGenerator.generateBetweenRange(1, MenuEnum.getNumberOfMenus(index));
                                    String randomMenu = MenuEnum.getMenuName(index, randomMenuIndex);
                                    if (!menus.contains(randomMenu) && coaches.canEat(coach, randomMenu)) {
                                        menus.add(randomMenu);
                                        break;
                                    }
                                }
                            });
                    return new CoachMenuDTO(coach,menus);
                }).collect(Collectors.toList());
    }


    private void matchRandomMenuCategories() {
        List<Integer> categories = new ArrayList<>();

        while (categories.size() < DAYS_TO_MATCH) {
            int categoryNumber = randomNumberGenerator.generateBetweenRange(1, MenuEnum.getNumberOfCategories());
            int duplicate = (int) categories.stream()
                    .filter(index -> index == categoryNumber)
                    .count();
            if (duplicate < MAX_DUPLICATE_OF_CATEGORY) {
                categories.add(categoryNumber);
            }
        }
        randomCategoryIndex = categories;
    }
}
