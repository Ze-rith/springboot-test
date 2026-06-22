package com.dgsw.liblong.repository;

import com.dgsw.liblong.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
