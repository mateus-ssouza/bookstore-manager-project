package com.mateussouza.gerenciadelivros.repository;

import com.mateussouza.gerenciadelivros.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
