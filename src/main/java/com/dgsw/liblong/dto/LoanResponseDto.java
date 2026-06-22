package com.dgsw.liblong.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LoanResponseDto {

    private Long id;

    private Long bookId;

    private String borrower;

    private LocalDateTime loanDate;
}