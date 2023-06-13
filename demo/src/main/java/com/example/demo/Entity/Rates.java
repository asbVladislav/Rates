package com.example.demo.Entity;





import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table( name="Rate")
public class Rates {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int ID;
    @Column(name = "Cur_ID", nullable = false)
    private int Cur_ID;
    private String Cur_Name;
    private double Cur_OfficialRate;
    private String Cur_Abbreviation;
    private Date Date;
    private int Cur_Scale;


}
