package net.imad.patient_demo_tp2.Repositry_DAO;

import net.imad.patient_demo_tp2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
