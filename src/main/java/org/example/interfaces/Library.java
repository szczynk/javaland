package org.example.interfaces;

public class Library {
    public static void main(String[] args) {
        Product book = new Book(); // Object created using implementing class
        book.setName("A tale of two cities");

        System.out.println("name: " + book.getName());
        System.out.println("price: " + book.getPrice());

        //  if a class implements multiple interfaces,
        //  the type of that created object from that class can be considered
        //  as any of those interfaces or the class itself.
        ElectronicBook eBook = new ElectronicBook();
        eBook.setName("A tale of two cities");

        System.out.println("name: " + eBook.getName());
        System.out.println("Attachment: " + eBook.getAttachment());

        System.out.println("price: " + eBook.getPrice());

        System.out.println("price: " + eBook.getLink());
    }
}
