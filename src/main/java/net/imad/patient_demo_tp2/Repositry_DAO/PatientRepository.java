package net.imad.patient_demo_tp2.Repositry_DAO;

import net.imad.patient_demo_tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);
}
