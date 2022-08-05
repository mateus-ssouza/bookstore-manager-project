package com.mateussouza.gerenciadelivros.controller;

import com.mateussouza.gerenciadelivros.dto.MessageResponseDTO;
import com.mateussouza.gerenciadelivros.entity.Book;
import com.mateussouza.gerenciadelivros.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID" + savedBook.getId())
                .build();
    }
}
