package com.example.zoo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zoo.Entities.Enclosure;
import com.example.zoo.Repositories.EnclosureRepository;

import jakarta.validation.constraints.NotNull;
@Service
public class EnclosureService {
    @Autowired
    private EnclosureRepository er;
    public void addEnclosure(@NotNull Enclosure enclosure){
        er.save(enclosure);
    }
    public List<Enclosure> findAll(){
        return er.findAll();
    }
    public List<Enclosure> findByID(long id){
        return er.findByID(id);
    }
    public void deleteEnclusure(long id){
        if (!er.existsById(id)) {
            throw new RuntimeException("Enclosure with id " + id + " not found");
        }else{
            er.deleteById(id);
        }
    }
}
