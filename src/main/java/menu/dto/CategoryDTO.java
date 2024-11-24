package menu.dto;

import java.util.List;

public class CategoryDTO {

    private final List<String> categories;

    public CategoryDTO(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getCategories() {
        return categories;
    }
}
