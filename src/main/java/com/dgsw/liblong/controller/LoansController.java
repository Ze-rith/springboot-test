package com.dgsw.liblong.controller;

import com.dgsw.liblong.dto.LoanRequestDto;
import com.dgsw.liblong.dto.LoanResponseDto;
import com.dgsw.liblong.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoansController {

    private final LoanService loanService;

    @PostMapping
    public LoanResponseDto loanBook(@RequestBody LoanRequestDto dto) {
        return loanService.loanBook(dto);
    }
}