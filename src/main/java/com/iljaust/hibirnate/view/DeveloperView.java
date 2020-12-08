package com.iljaust.hibirnate.view;

import com.iljaust.hibirnate.model.Developer;
import com.iljaust.hibirnate.controller.DeveloperController;

import java.util.List;
import java.util.Scanner;

public class DeveloperView {
    private final DeveloperController controller = new DeveloperController();
    private final Scanner scan = new Scanner(System.in);

    public void deleteById(){
        Long inputID = scan.nextLong();
        controller.deleteById(inputID);
    }

    public void save(){
        String developerName = scan.nextLine();
        Developer developer = new Developer(developerName,null);
        controller.save(developer);
    }

    public void getByIdDev(){
        Long inputID = scan.nextLong();
        Developer developer = controller.getById(inputID);
        System.out.println(developer);
    }

    public void update(){
        long id = scan.nextLong();
        String developerName = scan.nextLine();
        controller.update(new Developer(developerName,id));
    }

    public void getAll(){
        List<Developer> developers = controller.getAll();

        developers.forEach(System.out::println);
    }
}
