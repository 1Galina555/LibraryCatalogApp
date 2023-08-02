package com.example.librarycatalogapp;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LibraryController {

    // репозиторий (внедряется через DI)
    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("ping")
    public String ping() {
        return "pong";
    }
    @GetMapping("book")
    public Iterable<Book> getAll() {
        return bookRepository.findAll();
    }

    // 2. добавление или изменение
    @PostMapping("bookAdd")
    public Book add(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // 3. получение по id
    @GetMapping("book/{id}")
    public Optional<Book> get(@PathVariable Integer id) {
        return bookRepository.findById(id);
    }

    // 4. удаление  по id
    @DeleteMapping("book/{id}")
    public void delete(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }

}

