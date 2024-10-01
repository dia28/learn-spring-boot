package com.learning.advanced.jpa;

import com.learning.advanced.jpa.dao.AppDAO;
import com.learning.advanced.jpa.entity.Instructor;
import com.learning.advanced.jpa.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//			createInstructor(appDAO);
            findInstructor(appDAO);
            deleteInstructor(appDAO);
        };
    }

    private void deleteInstructor(AppDAO appDAO) {
        int id = 3;
        appDAO.delete(id);
        System.out.println("Deleted instructor with id " + id);
    }

    private void findInstructor(AppDAO appDAO) {
        int id = 1;
        System.out.println("Finding instructor with id: " + id);
        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Found instructor: " + instructor);
        System.out.println("the associated instructor details are: " + instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor(
                "Gabriel", "Darby", "gabi.darby@gmail.com"
        );
        InstructorDetail instructorDetail = new InstructorDetail(
                "http://www.luv2code.com/youtube",
                "Football"
        );

        tempInstructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Instructor saved successfully: " + tempInstructor);
    }


}
