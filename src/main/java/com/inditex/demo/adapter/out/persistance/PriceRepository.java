package com.inditex.demo.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<PriceJPAEntity, PriceId> {

    @Query(value = """
           SELECT *
           FROM PRICES
           WHERE PRODUCT_ID = :productId
           AND BRAND_ID = :brandId
           AND PARSEDATETIME(REPLACE(REPLACE(START_DATE, '-', ' '), '.', ':'), 'yyyy MM dd HH:mm:ss') <= :startDate
           AND PARSEDATETIME(REPLACE(REPLACE(END_DATE, '-', ' '), '.', ':'), 'yyyy MM dd HH:mm:ss') >= :startDate
           ORDER BY PRIORITY DESC
           """, nativeQuery = true)
    Optional<List<PriceJPAEntity>> findPricesByCriteria(LocalDateTime startDate, long productId, int brandId);
}
