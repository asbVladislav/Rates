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
@Table( name="Currency")
public class Currency {


    @Id
    @Column(name = "Cur_ID", nullable = false)
    private int Cur_ID;
    private int Cur_ParentID;
    private int Cur_Code;
    private String Cur_Abbreviation;
    private String Cur_Name;
    private String Cur_Name_Bel;
    private String Cur_Name_Eng;
    private String Cur_QuotName;
    private String Cur_QuotName_Bel;
    private String Cur_QuotName_Eng;
    private String Cur_NameMulti;
    private String Cur_Name_BelMulti;
    private String Cur_Name_EngMulti;
    private int Cur_Scale;
    private int Cur_Periodicity;
    private Date Cur_DateStart;
    private Date Cur_DateEnd;



}
