package net.imad.patient_demo_tp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medcin {
        @Id
        @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
        private Long id ;
        private String nom ;
        private String email ;
        private String specialite ;
        @OneToMany(mappedBy = "medcin" , fetch = jakarta.persistence.FetchType.LAZY)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        private Collection<RendezVous> rendezvous ;

}
