package com.dgsw.liblong.service;

import com.dgsw.liblong.dto.LoanRequestDto;
import com.dgsw.liblong.dto.LoanResponseDto;
import com.dgsw.liblong.entity.LoansEntity;
import com.dgsw.liblong.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public LoanResponseDto loanBook(LoanRequestDto dto) {

        LoansEntity loan = LoansEntity.builder()
                .bookId(dto.getBookId())
                .borrower(dto.getBorrower())
                .loanDate(LocalDateTime.now())
                .build();

        LoansEntity savedLoan = loanRepository.save(loan);

        return LoanResponseDto.builder()
                .id(savedLoan.getId())
                .bookId(savedLoan.getBookId())
                .borrower(savedLoan.getBorrower())
                .loanDate(savedLoan.getLoanDate())
                .build();
    }
}