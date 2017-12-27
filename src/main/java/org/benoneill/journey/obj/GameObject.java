package org.benoneill.journey.obj;

/**
 * The base for most object a game will generally need.
 */
public class GameObject {

    private String tag;
    private String description;

    /**
     * Creates a new GameObject with a tag and description.
     * @param tag the long name of the object
     * @param description a brief description of the object
     */
    public GameObject(String tag, String description) {
        this.tag = tag;
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

}
