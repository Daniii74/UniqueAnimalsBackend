package com.example.demo.UniqueAnimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class uniqueanimalController {
    @Autowired
    private uniqueanimalService uniqueanimalService;

    @GetMapping("/uniqueanumals")
    public Object getAllUniqueAnimals(){
        return uniqueanimalService.getAlluniqueanimals();
    }

    @GetMapping("/uniqueanumals")
    public Object getAllUniqueAnimalById(@PathVariable Long Id){
        return uniqueanimalService.getUniqueanimaById(Id);
    }

    

}
