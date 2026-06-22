package com.dgsw.liblong.service;

import com.dgsw.liblong.dto.BookRequestDto;
import com.dgsw.liblong.dto.BookResponseDto;
import com.dgsw.liblong.entity.Book;
import com.dgsw.liblong.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public BookResponseDto register(BookRequestDto dto) {
        Book book = Book.builder()
                .bookName(dto.getBookName())
                .description(dto.getDescription())
                .borrowed(dto.isBorrowed())
                .build();
        return new BookResponseDto(bookRepository.save(book));
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll().stream()
                .map(BookResponseDto::new)
                .toList();
    }

    public List<BookResponseDto> findByBookName(String bookName) {
        return bookRepository.findAllByBookName(bookName).stream()
                .map(BookResponseDto::new)
                .toList();
    }
    //대출 조회
    public List<BookResponseDto> findLoanedBooks() {
        return bookRepository.findAllByBorrowedTrue().stream()
                .map(BookResponseDto::new)
                .toList();
    }

    //반납 조회
    public List<BookResponseDto> findReturnedBooks() {
        return bookRepository.findAllByBorrowedFalse().stream()
                .map(BookResponseDto::new)
                .toList();
    }
}
