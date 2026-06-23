package com.dgsw.liblong.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String bookName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private boolean borrowed;

    private String borrower;

    private LocalDateTime loanDate;

    public void loanTo(String borrower) {
        this.borrowed = true;
        this.borrower = borrower;
        this.loanDate = LocalDateTime.now();
    }

    public void returnBook() {
        this.borrowed = false;
        this.borrower = null;
        this.loanDate = null;
    }
}
