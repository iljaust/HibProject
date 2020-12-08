package com.iljaust.hibirnate.view;

import com.iljaust.hibirnate.model.Skill;
import com.iljaust.hibirnate.controller.SkillController;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private SkillController controller = new SkillController();
    private Scanner scan = new Scanner(System.in);

    public void deleteSkillById(){
        Long inputID = scan.nextLong();
        controller.deleteById(inputID);
    }

    public void saveSkill(){
        String skillName = scan.nextLine();
        Skill skill = new Skill(null, skillName);
        controller.save(skill);
    }

    public void getByIdSkill(){
        Long inputID = scan.nextLong();
        Skill skill = controller.getById(inputID);
        System.out.println(skill);
    }

    public void updateSkill(){
        long id = scan.nextLong();
        String skillName = scan.nextLine();
        controller.update(new Skill(id,skillName));
    }

    public void getAllSkills(){
        List<Skill> skills = controller.getAll();

        skills.forEach(System.out::println);
    }
}
