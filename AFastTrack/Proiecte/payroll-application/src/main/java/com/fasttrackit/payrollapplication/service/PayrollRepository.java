package com.fasttrackit.payrollapplication.service;

import com.fasttrackit.payrollapplication.model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Embeddable;
import java.util.List;

public interface PayrollRepository extends JpaRepository<Payroll, Long> {

    //List<Payroll> findByID(Long id);

    @Query("select c from Payroll c where c.id = :id")
    List<Payroll> findByIdByQuery(@Param("id") Long id);

/*
    List<Country> findByContinent(String name);

    @Query("select c from Country c where c.continent=:name")
    List<Country> findByContinentByQuery(@Param("name") String name);

    @Query(value = "select c from Country c where c.continent=:name", nativeQuery = true)
    List<Country> findByContinentByNativeQuery(@Param("name") String name);

    @Query("select c from Country c where (:continent is null or c.continent=:continent)" +
            "and (c.population >= :minPopulation or :minPopulation is null)" +
            "and (c.population <= :maxPopulation or :maxPopulation is null)"
    )
    List<Country> getByContinentAndMinPopulationAndMinPopulation
            (@Param("continent") String continent, @Param("minPopulation") Long minPopulation,
             @Param("maxPopulation") Long maxPopulation);
}

 */

}
