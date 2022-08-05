package com.mateussouza.gerenciadelivros.mapper;


import com.mateussouza.gerenciadelivros.dto.BookDTO;
import com.mateussouza.gerenciadelivros.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
