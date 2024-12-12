package menu.dto;

public class WeeklyMenuCategoryDto {

    private final String mondayCategory;
    private final String tuesdayCategory;
    private final String wednesdayCategory;
    private final String thursdayCategory;
    private final String fridayCategory;

    public WeeklyMenuCategoryDto(String mondayCategory, String tuesdayCategory, String wednesdayCategory, String thursdayCategory, String fridayCategory) {
        this.mondayCategory = mondayCategory;
        this.tuesdayCategory = tuesdayCategory;
        this.wednesdayCategory = wednesdayCategory;
        this.thursdayCategory = thursdayCategory;
        this.fridayCategory = fridayCategory;
    }

    public String getMondayCategory() {
        return mondayCategory;
    }

    public String getTuesdayCategory() {
        return tuesdayCategory;
    }

    public String getWednesdayCategory() {
        return wednesdayCategory;
    }

    public String getThursdayCategory() {
        return thursdayCategory;
    }

    public String getFridayCategory() {
        return fridayCategory;
    }
}

