package com.dgsw.liblong.repository;

import com.dgsw.liblong.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByBookName(String bookName);
    //대출 조회
    List<Book> findAllByBorrowedTrue();
    //반납 조회
    List<Book> findAllByBorrowedFalse();
}
