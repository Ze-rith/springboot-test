package com.dgsw.liblong.controller;

import com.dgsw.liblong.entity.LoansEntity;
import com.dgsw.liblong.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoansController {

    private final LoanRepository loanRepository;

    // 대출
    @PostMapping
    public LoansEntity loanBook(@RequestBody LoansEntity loansEntity) {

        loansEntity.setLoanDate(LocalDateTime.now());

        return loanRepository.save(loansEntity);
    }

    // 전체 대출 조회
    @GetMapping
    public List<LoansEntity> getLoans() {
        return loanRepository.findAll();
    }

    // 특정 대출 조회
    @GetMapping("/{id}")
    public LoansEntity getLoan(@PathVariable Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("대출 정보가 없습니다."));
    }
}