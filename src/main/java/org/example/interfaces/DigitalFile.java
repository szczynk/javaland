package org.example.interfaces;

public interface DigitalFile {
    String getName();

    void setName(String name);

    default String getLink() {
        return "https://amazon.com";
    }

    default void setLink(String link) {
    }
}
