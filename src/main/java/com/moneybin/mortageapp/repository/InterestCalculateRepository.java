package com.moneybin.mortageapp.repository;

import com.moneybin.mortageapp.beans.Prospects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestCalculateRepository extends JpaRepository<Prospects, Long> {
}
