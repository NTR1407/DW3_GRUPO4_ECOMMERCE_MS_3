package com.ordenes.repository;

import com.ordenes.model.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Long> {

    List<Orden> findAll();

    @Query(value = " SELECT c FROM Orden c WHERE c.id =:aId ")
    Optional<Orden> findById(Long aId);

}
