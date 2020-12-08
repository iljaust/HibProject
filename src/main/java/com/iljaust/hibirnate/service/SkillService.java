package com.iljaust.hibirnate.service;

import com.iljaust.hibirnate.model.Skill;
import com.iljaust.hibirnate.repository.SkillRepository;
import com.iljaust.hibirnate.repository.SkillRepositoryImpl;

import java.util.List;

public class SkillService {
    private SkillRepository skillRepository = new SkillRepositoryImpl();


    public List<Skill> getAll(){

        return skillRepository.getAll();

    }

    public Skill update(Skill skill) {

        return skillRepository.update(skill);
    }

    public void deleteById(Long id) {

        skillRepository.deleteById(id);
    }

    public Skill save(Skill skill) {

        skillRepository.save(skill);
        return skill;
    }

    public Skill getById(Long id) {

        return skillRepository.getById(id);
    }
}
