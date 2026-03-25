
package models;

public class Ad {
    private final String title;
    private final String category;
    private final String condition; // "Новый" или "Б/у"
    private final String city;
    private final String description;
    private final String price;

    public Ad(String title, String category, String condition, String city, String description, String price) {
        this.title = title;
        this.category = category;
        this.condition = condition;
        this.city = city;
        this.description = description;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getCondition() { return condition; }
    public String getCity() { return city; }
    public String getDescription() { return description; }
    public String getPrice() { return price; }
}