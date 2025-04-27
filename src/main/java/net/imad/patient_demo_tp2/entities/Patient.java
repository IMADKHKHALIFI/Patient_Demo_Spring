package net.imad.patient_demo_tp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Collection;


@Entity
@Data //pour getters et setter
@NoArgsConstructor //constructeur sans paramaitre
@AllArgsConstructor  //constructeur avec paramaitre

public class Patient {
    @Id @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    @Temporal( jakarta.persistence.TemporalType.DATE)
    private Date dateNaissance ;
    private boolean malade ;
    @OneToMany(mappedBy = "patient")
    private Collection<RendezVous> rendezvous;


}
