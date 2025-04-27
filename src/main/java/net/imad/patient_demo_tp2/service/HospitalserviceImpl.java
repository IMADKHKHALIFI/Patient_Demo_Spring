package net.imad.patient_demo_tp2.service;

import jakarta.transaction.Transactional;
import net.imad.patient_demo_tp2.Repositry_DAO.ConsultationRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.MedcinRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.PatientRepository;
import net.imad.patient_demo_tp2.Repositry_DAO.RendezVousRepository;
import net.imad.patient_demo_tp2.entities.Consultation;
import net.imad.patient_demo_tp2.entities.Medcin;
import net.imad.patient_demo_tp2.entities.Patient;
import net.imad.patient_demo_tp2.entities.RendezVous;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class HospitalserviceImpl implements IHospitalservice {
    //Pour faire linjection de depondance on a deux methode
    //le premiere est dutliser la notation @Autowired a chaqeu repo
    //deuximme methode est dutiliser constucteur
    
    private PatientRepository patientRepository;
    private MedcinRepository medcinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalserviceImpl(PatientRepository patientRepository, MedcinRepository medcinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medcinRepository = medcinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medcin saveMedcin(Medcin medcin) {

        return medcinRepository.save(medcin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
