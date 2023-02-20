package com.knk.refrigerator_manager.ingre_refri;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Ingre_refriRepository extends JpaRepository<Ingre_refri, Long> {

    @Query("select ir from Ingre_refri as ir where ir.ingredient.ingreID = :IngreID and ir.refrigerator.refriID = :RefriID")
    Optional<Ingre_refri> findByRefriIDAndIngreID(@Param("RefriID")Long RefriID, @Param("IngreID")Long IngreID);

    @Query("select ir from Ingre_refri as ir where ir.refrigerator.refriID = :refriID")
    List<Ingre_refri> findAllByRefriID(@Param("refriID")Long refriID);
}
