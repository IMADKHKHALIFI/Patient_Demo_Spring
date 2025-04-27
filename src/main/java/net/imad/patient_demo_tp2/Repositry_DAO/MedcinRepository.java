package net.imad.patient_demo_tp2.Repositry_DAO;

import net.imad.patient_demo_tp2.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin, Long> {
    Medcin findByNom(String nom);

}
