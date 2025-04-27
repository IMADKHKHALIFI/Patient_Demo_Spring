package net.imad.patient_demo_tp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class RendezVous {
    @Id
    private String  id ;
    private Date date ;
    @Enumerated(EnumType.STRING) // ce ligne a nous aide de stocker les information de notre rondez vous sous format Strng et pas les ID des patient ..id de medcin ...etc ghi bach tafham
    private StatusRDV status ;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Patient patient ;
    @ManyToOne
    private Medcin medcin ;


    @OneToOne(mappedBy = "rendezVous")
    private Consultation consultation ;

}
