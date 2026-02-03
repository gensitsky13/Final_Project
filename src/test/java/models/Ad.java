package models;

public class Ad {
    private final String title;
    private final String description;
    private final String category;

    public Ad(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
}

