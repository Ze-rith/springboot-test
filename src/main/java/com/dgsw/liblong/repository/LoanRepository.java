package com.dgsw.liblong.repository;

import com.dgsw.liblong.entity.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoansEntity, Long> {
}