package net.imad.patient_demo_tp2.service;

import net.imad.patient_demo_tp2.entities.Consultation;
import net.imad.patient_demo_tp2.entities.Medcin;
import net.imad.patient_demo_tp2.entities.Patient;
import net.imad.patient_demo_tp2.entities.RendezVous;

public interface IHospitalservice {
    Patient savePatient(Patient patient );
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRendezVous(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);


}
