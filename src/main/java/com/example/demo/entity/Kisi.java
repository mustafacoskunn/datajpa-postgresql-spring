package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kisi")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Kisi {

    @Id
    @SequenceGenerator(name="seq_kisi",allocationSize = 1) //auto_increment
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE) //datayı otomatik sequencegeneratorden alıcak
    private Long id;

    @Column(length = 40,name = "adi")
    private String adi;

    @Column(length = 40,name = "soyadi")
    private String soyadi;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresler;
}
