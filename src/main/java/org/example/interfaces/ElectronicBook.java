package org.example.interfaces;

// Interfaces and multiple inheritance
//
// In Java, a class can achieve multiple inheritance by implementing multiple interfaces.
//
//          ┌───────────────────┐
//          │       Class       │
//          └┬────────┬────────┬┘
// implements│        │        │extends
//           ▼        ▼        ▼
//    ┌─────────┐ ┌─────────┐ ┌─────┐
//    │Interface│ │Interface│ │Class│
//    └─────────┘ └─────────┘ └─────┘
//
//
//              ┌───────────┐
//              │ Interface │
//              └┬─────────┬┘
//        extends│         │
//               ▼         ▼
//         ┌─────────┐ ┌─────────┐
//         │Interface│ │Interface│
//         └─────────┘ └─────────┘
//
// To implement multiple interfaces,
// the class header must specify each interface in a comma-delimited list.
//
// If multiple interfaces contain a method with the same signature,
// the implementing class can provide a single implementation to satisfy the requirement.
//
// If multiple interfaces contain a method with the same name but different return types,
// it will result in a compilation error.
public class ElectronicBook implements Product, DigitalFile {
    private String name;
    private String author;
    private int page;
    private String isbn;
    private String attachment;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
