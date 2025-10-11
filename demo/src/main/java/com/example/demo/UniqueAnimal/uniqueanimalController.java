package com.example.demo.UniqueAnimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class uniqueanimalController {
    @Autowired
    private uniqueanimalService uniqueanimalService;

    @GetMapping("/uniqueanimals")
    public Object getAlluniqueanimals(){
        return uniqueanimalService.getAlluniqueanimals();
    }

    @GetMapping("/uniqueanimal/{id}")
    public Object getAllUniqueAnimalById(@PathVariable Long id){
        return uniqueanimalService.getUniqueanimalById(id);
    }

    @GetMapping("/uniqueanimals/region/{region}")
    public Object getUniqueanimalByRegion(@PathVariable String region){
        return uniqueanimalService.getuniqueanimalByRegion(region);
    }

    @GetMapping("/uniqueanimals/search")
    public Object getUniqueanimalByName(@RequestParam String name){
        if(name != null){
            return uniqueanimalService.getuniqueanimalByName(name);
        }
        else{
            return uniqueanimalService.getAlluniqueanimals();
        }

    }

    @PostMapping("/uniqueanimal")
    public Object addUniqueanimal(@RequestBody uniqueanimal uniqueanimal){
        return uniqueanimalService.addUniqueanimal(uniqueanimal);
    }

    @PutMapping("/uniqueanimal/{id}")
    public uniqueanimal updateUniqueanimal(@PathVariable Long id, @RequestBody uniqueanimal uniqueanimal){
        uniqueanimalService.updateUniqueanimalById(id, uniqueanimal);
        return uniqueanimalService.getUniqueanimalById(id);
    }

    @DeleteMapping("/uniqueanimal/{id}")
    public Object deleteUniqueanimal(@PathVariable Long id){
        uniqueanimalService.deleteUniqueanimal(id);
        return uniqueanimalService.getAlluniqueanimals();
    }
}
