package net.imad.patient_demo_tp2;

import net.imad.patient_demo_tp2.Repositry_DAO.ConsultationRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.MedcinRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.PatientRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.RendezVousRepository;
import net.imad.patient_demo_tp2.entities.*;
import net.imad.patient_demo_tp2.service.IHospitalservice;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class PatientDemoTp2Application   {

    public static void main(String[] args) {
        SpringApplication.run(PatientDemoTp2Application.class, args);
    }

    @Bean //avec notation Bean : il va s'excute au demarage , et en meme temp cette methode va retorner un objet Composante Spring !!
    CommandLineRunner start(IHospitalservice hospitalservice ,
                            PatientRepository patientRepository ,
                            MedcinRepository medcinRepository ,
                            RendezVousRepository rendezVousRepository ,
                            ConsultationRepository consultationRepository){
        return args -> {
            Stream.of("imad" ,"hamza" , "yassine")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalservice.savePatient(patient);});
            Stream.of("AMIN" ,"HASSAN" , "FATIMAZZAHRA")
                    .forEach(name->{
                        Medcin medcin = new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gamil.com");
                        medcin.setSpecialite(Math.random()<0.5?"Cardiologie":"Neurologie");
                        hospitalservice.saveMedcin(medcin);});
            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient2 = patientRepository.findByNom("imad");

            Medcin medcin = medcinRepository.findById(1L).orElse(null);
            Medcin medcin2 = medcinRepository.findByNom("AMIN");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedcin(medcin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalservice.saveRendezVous(rendezVous);
            System.out.println(saveDRDV.getId());

            RendezVous rendezVous2 = rendezVousRepository.findAll().get(0);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(rendezVous.getDate());
            consultation.setRapport("Le patient a un mal de sang");
            consultation.setRendezVous(rendezVous2);
            hospitalservice.saveConsultation(consultation);
        };
    }
}
