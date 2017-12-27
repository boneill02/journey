package org.benoneill.journey.world;

public class WorldInfo {

    String title;
    String description;
    String author;
    String copyright;
    String[] loadOrder;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String[] getLoadOrder() {
        return loadOrder;
    }

    public void setLoadOrder(String[] loadOrder) {
        this.loadOrder = loadOrder;
    }

}
