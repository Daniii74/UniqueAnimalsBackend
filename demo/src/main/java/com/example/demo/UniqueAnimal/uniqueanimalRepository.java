package com.example.demo.UniqueAnimal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface uniqueanimalRepository extends JpaRepository<uniqueanimal, Long>{

    @Query(value = "select * from uniqueanimal u where u.name like %?1% ", nativeQuery = true)
    List<uniqueanimal> getUniqueanimalByName(String name);

    @Query(value = "SELECT * FROM uniqueanimal u WHERE u.region ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<uniqueanimal> getUniqueanimalByRegion(String region);
}   
