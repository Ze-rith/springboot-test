package com.dgsw.liblong.service;

import com.dgsw.liblong.dto.LoanRequestDto;
import com.dgsw.liblong.dto.LoanResponseDto;
import com.dgsw.liblong.entity.Book;
import com.dgsw.liblong.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final BookRepository bookRepository;

    @Transactional
    public LoanResponseDto loanBook(LoanRequestDto dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 도서입니다."));

        book.loanTo(dto.getBorrower());

        return LoanResponseDto.builder()
                .id(book.getId())
                .bookId(book.getId())
                .borrower(book.getBorrower())
                .loanDate(book.getLoanDate())
                .build();
    }
}