package org.benoneill.journey.world;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "world")
public class WorldInfo {


    @XmlAttribute(name = "title")
    String title;
    @XmlAttribute(name = "desc")
    String description;
    @XmlAttribute(name = "author")
    String author;
    @XmlAttribute(name = "copyright")
    String copyright;

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


}
