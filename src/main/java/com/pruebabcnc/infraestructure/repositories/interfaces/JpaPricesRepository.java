package com.pruebabcnc.infraestructure.repositories.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebabcnc.infraestructure.entities.PriceEntity;

@Repository
public interface JpaPricesRepository extends JpaRepository<PriceEntity,Integer>{
	  @Query("SELECT p FROM PriceEntity p WHERE p.productId = :product_id AND p.brandId = :brand_id AND p.startDate<= :date AND p.endDate >= :date ORDER BY p.priority DESC")
	  Optional<List<PriceEntity>> findPriceByProductIdBrandIdAndDate(@Param("product_id") Integer productId, @Param("brand_id") Integer brandId, @Param("date") LocalDateTime date);
}
