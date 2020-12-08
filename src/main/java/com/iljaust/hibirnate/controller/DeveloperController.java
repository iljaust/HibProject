package com.iljaust.hibirnate.controller;

import com.iljaust.hibirnate.model.Developer;
import com.iljaust.hibirnate.service.DeveloperService;

import java.util.List;

public class DeveloperController {
    DeveloperService developerService = new DeveloperService();

    public void deleteById(long id){

        developerService.deleteById(id);
    }

    public Developer save(Developer developer){

        return developerService.save(developer);
    }

    public Developer getById(long id){

        return developerService.getById(id);
    }

    public List<Developer> getAll(){

        return developerService.getAll();
    }

    public Developer update(Developer developer){

        return developerService.update(developer);
    }
}
