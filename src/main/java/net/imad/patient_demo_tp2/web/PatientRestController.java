package net.imad.patient_demo_tp2.web;



//par exemple pour consulter la list des patients sa c est pourquoi en creé le package web


import net.imad.patient_demo_tp2.Repositry_DAO.PatientRepository;
import net.imad.patient_demo_tp2.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patienList(){
        return patientRepository.findAll();
    }
}
