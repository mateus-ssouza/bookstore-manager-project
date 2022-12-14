package com.mateussouza.gerenciadelivros.service;

import com.mateussouza.gerenciadelivros.entity.Book;
import com.mateussouza.gerenciadelivros.exception.BookNotFoundException;
import com.mateussouza.gerenciadelivros.mapper.BookMapper;
import com.mateussouza.gerenciadelivros.repository.BookRepository;
import com.mateussouza.gerenciadelivros.dto.BookDTO;
import com.mateussouza.gerenciadelivros.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId())
                .build();
    }

    public BookDTO findById(Long id) throws BookNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        return bookMapper.toDTO(book);
    }
}
