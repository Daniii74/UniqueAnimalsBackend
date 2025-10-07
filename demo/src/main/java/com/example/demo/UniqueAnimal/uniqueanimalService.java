package com.example.demo.UniqueAnimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class uniqueanimalService {
    @Autowired
    private uniqueanimalRepository uniqueanimalRepository;

    public Object getAlluniqueanimals(){
        return uniqueanimalRepository.findAll();
    }

    public uniqueanimal getUniqueanimaById(@PathVariable long Id){
        return uniqueanimalRepository.findById(Id).orElse(null);
    }

    public Object getuniqueanimalByRegion(String region){
        return uniqueanimalRepository.getUniqueanimalByRegion(region);
    }

    public Object getuniqueanimalByName(String Name){
        return uniqueanimalRepository.getUniqueanimalByName(Name);
    }

    public uniqueanimal addUniqueanimal(uniqueanimal uniqueanimal){
        return uniqueanimalRepository.save(uniqueanimal);
    }

    public uniqueanimal updateUniqueanimalById(Long Id, uniqueanimal uniqueanimal){
        return uniqueanimalRepository.save(uniqueanimal);
    }

    public void deleteUniqueanimal(Long Id){
        uniqueanimalRepository.deleteById(Id);
    }


}
