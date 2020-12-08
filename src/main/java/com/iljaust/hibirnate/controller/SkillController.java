package com.iljaust.hibirnate.controller;

import com.iljaust.hibirnate.model.Skill;
import com.iljaust.hibirnate.service.SkillService;

import java.util.List;

public class SkillController {
    private SkillService skillService = new SkillService();

    public void deleteById(long id){

        skillService.deleteById(id);
    }

    public Skill save(Skill skill){
       return skillService.save(skill);
    }

    public Skill getById(long id){

        return skillService.getById(id);
    }

    public List<Skill> getAll(){

        return skillService.getAll();
    }

    public Skill update(Skill skill){

        return skillService.update(skill);
    }
}
