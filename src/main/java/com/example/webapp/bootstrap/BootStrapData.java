package com.example.webapp.bootstrap;

import com.example.webapp.domain.Author;
import com.example.webapp.domain.Book;
import com.example.webapp.repositories.AuthorRepository;
import com.example.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository  bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Author sidney = new Author("Sidney","Sheldon");
        Book book = new Book("Dooms Day Conspiracy","123124");

        sidney.getBooks().add(book);
        book.getAuthors().add(sidney);

        authorRepository.save(sidney);
        bookRepository.save(book);

        Author stephenie = new Author("Stephenie","Meyer");
        Book twilight_saga = new Book("Twilight Saga","124123");

        stephenie.getBooks().add(twilight_saga);
        twilight_saga.getAuthors().add(stephenie);

        authorRepository.save(stephenie);
        bookRepository.save(twilight_saga);

        System.out.println("Number of books: "+bookRepository.count());

    }
}
