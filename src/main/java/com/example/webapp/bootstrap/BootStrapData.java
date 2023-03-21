package com.example.webapp.bootstrap;

import com.example.webapp.domain.Author;
import com.example.webapp.domain.Book;
import com.example.webapp.domain.Publisher;
import com.example.webapp.repositories.AuthorRepository;
import com.example.webapp.repositories.BookRepository;
import com.example.webapp.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository  bookRepository, PublishRepository publishRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishRepository = publishRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Author sidney = new Author("Sidney","Sheldon");
        Book book = new Book("Dooms Day Conspiracy","123124");

        Publisher publisher = new Publisher();
        publisher.setName("Little, Brown and Company");
        publisher.setCity("Boston");
        publisher.setState("MA");

        publishRepository.save(publisher);

        sidney.getBooks().add(book);
        book.getAuthors().add(sidney);

        authorRepository.save(sidney);
        bookRepository.save(book);

        Author stephenie = new Author("Stephenie","Meyer");
        Book twilight_saga = new Book("Twilight Saga","124123");

        stephenie.getBooks().add(twilight_saga);
        twilight_saga.getAuthors().add(stephenie);
        twilight_saga.setPublisher(publisher);


        publisher.getBooks().add(twilight_saga);


        authorRepository.save(stephenie);
        bookRepository.save(twilight_saga);
        publishRepository.save(publisher);

        System.out.println("Number of books: "+bookRepository.count());
        System.out.println("Number of publishers: "+publishRepository.count());


    }
}
