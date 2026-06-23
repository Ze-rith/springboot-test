package com.dgsw.liblong.service;

import com.dgsw.liblong.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturnService {

    private final LoanRepository loanRepository;

    public void returnBook(Long id) {
        loanRepository.deleteById(id);
    }

}
