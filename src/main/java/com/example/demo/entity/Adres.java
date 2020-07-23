package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "kisi_adres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Adres implements Serializable {

    @Id
    @SequenceGenerator(name="seq_kisi_adres",allocationSize = 1) //auto_increment
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE) //datayı otomatik sequencegeneratorden alıcak
    private Long id;

    @Column(length = 500,name = "adres")
    private String adres;

    @Enumerated //enum olduğu iç,n
    AdresTip aDresTip;

    @Column(name = "aktif")
    Boolean aktif;

    @ManyToOne()
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip{
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}
