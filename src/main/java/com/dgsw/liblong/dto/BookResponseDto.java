package com.dgsw.liblong.dto;

import com.dgsw.liblong.entity.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private final Long id;
    private final String bookName;
    private final String description;
    private final boolean borrowed;

    public BookResponseDto(Book book) {
        this.id = book.getId();
        this.bookName = book.getBookName();
        this.description = book.getDescription();
        this.borrowed = book.isBorrowed();
    }
}
