package POJO;

import Model.User;

public class Book {
    public String isbn;

    public Book(User user, String isbn) {
        this.isbn = "{\n" +
                "    \"userId\": \"" + user.getUserId() + "\",\n" +
                "    \"collectionOfIsbns\": [\n" +
                "        {\n" +
                "            \"isbn\": \"" + isbn + "\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
    }

    public String getIsbn() {
        return isbn;
    }
}
