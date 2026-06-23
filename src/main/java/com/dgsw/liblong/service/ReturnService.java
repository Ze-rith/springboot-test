package com.dgsw.liblong.service;

import com.dgsw.liblong.entity.Book;
import com.dgsw.liblong.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final BookRepository bookRepository;

    @Transactional
    public void returnBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 도서입니다."));
        book.returnBook();
    }

}
