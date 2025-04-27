package net.imad.patient_demo_tp2.Repositry_DAO;

import net.imad.patient_demo_tp2.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

}
