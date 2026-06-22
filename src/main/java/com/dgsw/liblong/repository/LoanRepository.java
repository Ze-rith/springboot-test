package com.dgsw.liblong.repository;

import com.dgsw.liblong.entity.LoansEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Long, LoansEntity> {
}
