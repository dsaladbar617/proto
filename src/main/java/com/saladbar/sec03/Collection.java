package com.saladbar.sec03;

import com.saladbar.domain.sec03.Book;
import com.saladbar.domain.sec03.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Collection {
    private static final Logger log = LoggerFactory.getLogger(Collection.class);

    public static void main(String[] args) {
        var book1 = Book.newBuilder().setTitle("FBGM").setAuthor("Ya Boi").setPublicationYear(2022).build();
        var book2 = Book.newBuilder().setTitle("YOLO").setAuthor("Sqaggins").setPublicationYear(2024).build();
        var book3 = book1.toBuilder().setTitle("Fuck this shit").build();

        var library = Library.newBuilder().setName("Deez Books")
//                .addBooks(book1)
//                .addBooks(book2)
//                .addBooks(book3)
                .addAllBooks(List.of(book1, book2, book3))
                .build();
        log.info("Library: {}", library);
    }
}
