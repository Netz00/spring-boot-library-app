package com.netz00.libraryapp.repository;

import com.netz00.libraryapp.domain.Lending;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {
}
