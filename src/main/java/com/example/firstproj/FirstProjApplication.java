package com.example.firstproj;

import com.example.firstproj.entities.Patient;
import com.example.firstproj.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class FirstProjApplication implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepo;
    public static void main(String[] args) {
        SpringApplication.run(FirstProjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepo.save(new Patient( null,"Messi",new Date(),true,34));
        patientRepo.save(new Patient( null,"Malango",new Date(),true,56));
        patientRepo.save(new Patient( null,"Gogo",new Date(),true,49));
        patientRepo.save(new Patient( null,"Neymar",new Date(),true,21));
        patientRepo.save(new Patient( null,"Gotze",new Date(),true,33));
        patientRepo.save(new Patient( null,"Kane",new Date(),true,66));

       // List<Patient>p = patientRepo.findByMalade(true);

//        for(Patient v :p)
//        {
//            System.out.println(v.toString());
//        }

//        Page<Patient> p= patientRepo.findByMalade(true,PageRequest.of(0,5));
//
//        System.out.println("==============================================");
//        p.forEach(x->{
//            System.out.println(x.toString());
//        });
//        List<Patient>p3=patientRepo.findByMalade(true);
//        p3.forEach(v->{
//            System.out.println(v.toString());
//        });
//        for(Patient v:p )
//        {
//            System.out.println(v.getId());
//            System.out.println(v.getNom());
//            System.out.println(v.getDateNaissance());
//            System.out.println(v.isMalade());
//            System.out.println(v.getScore());
//            System.out.println("==============================================");
//        }

//        Patient p2 =patientRepo.findById(2L).orElse(null);
//        System.out.println((p2==null)?"Aucun patient ":p2.toString());
//
//        System.out.println("Totale pages : "+p.getTotalPages());
//        System.out.println("Totale elements : "+p.getTotalElements());
//
//        System.out.println("Num page : "+p.getNumber());

//        p2.setMalade(true);
//        patientRepo.save(p2);
//
//        patientRepo.deleteById(1l);

        List<Patient> p=patientRepo.findByNomAndScoreLessThan("Messi",60);
        p.forEach(x->
        {
            System.out.println(x.toString());
        });
        p=patientRepo.ChercherPatientMalade(false);
        p.forEach(x->
        {
            System.out.println(x.toString());
        });
    }
}
