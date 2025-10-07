package com.example.demo.UniqueAnimal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

@Repository
public interface uniqueanimalRepository extends JpaRepository<uniqueanimal, Long>{

    List<uniqueanimal> getUniqueanimalByRegion(String region);

    @Query(value = "select * from uniqueanimal u where u.name like %?1% ", nativeQuery = true)
    List<uniqueanimal> getUniqueanimalByName(String name);
}   
