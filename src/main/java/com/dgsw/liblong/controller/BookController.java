package com.dgsw.liblong.controller;

import com.dgsw.liblong.dto.BookRequestDto;
import com.dgsw.liblong.dto.BookResponseDto;
import com.dgsw.liblong.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Tag(name = "Book API", description = "도서 등록 및 조회 API")
public class BookController {

    private final BookService bookService;

    @Operation(summary = "도서 등록", description = "새로운 도서를 등록합니다.")
    @PostMapping
    public ResponseEntity<BookResponseDto> register(@RequestBody BookRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.register(dto));
    }

    @Operation(summary = "전체 도서 조회", description = "등록된 모든 도서를 조회합니다.")
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @Operation(summary = "도서 이름 조회", description = "책 이름으로 도서를 조회합니다. 동일한 이름의 책이 여러 권이면 전부 반환합니다.")
    @GetMapping("/search")
    public ResponseEntity<List<BookResponseDto>> findByBookName(@RequestParam String bookName) {
        return ResponseEntity.ok(bookService.findByBookName(bookName));
    }
    @Operation(summary = "대출 도서 조회", description = "현재 대출된 모든 도서를 조회합니다.")
    @GetMapping("/loaned")
    public ResponseEntity<List<BookResponseDto>> findLoanedBooks() {
        return ResponseEntity.ok(bookService.findLoanedBooks());
    }

    @Operation(summary = "반납 도서 조회", description = "반납된 모든 도서를 조회합니다.")
    @GetMapping("/returned")
    public ResponseEntity<List<BookResponseDto>> findReturnedBooks() {
        return ResponseEntity.ok(bookService.findReturnedBooks());
    }
}
