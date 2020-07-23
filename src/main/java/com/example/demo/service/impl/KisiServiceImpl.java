package com.example.demo.service.impl;

import com.example.demo.dto.KisiDto;
import com.example.demo.entity.Adres;
import com.example.demo.entity.Kisi;
import com.example.demo.repo.AdresRepository;
import com.example.demo.repo.KisiRepository;
import com.example.demo.service.KisiService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KisiServiceImpl implements KisiService {


    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;


    public KisiServiceImpl(KisiRepository kisiRepository, AdresRepository adresRepository) {
        this.kisiRepository = kisiRepository;
        this.adresRepository = adresRepository;
    }

    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAdi());
        kisi.setSoyadi(kisiDto.getSoyadi());
        kisi = kisiRepository.save(kisi);

        final Kisi kisiDb = kisiRepository.save(kisi);
        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresler().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setADresTip(Adres.AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());

        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto> kisiDtos = new ArrayList<>();
        kisiler.forEach(it -> {
            KisiDto kisiDto = new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAdi(it.getAdi());
            kisiDto.setSoyadi(it.getSoyadi());
            kisiDto.setAdresler(it.getAdresler().stream().map(Adres::getAdres).collect(Collectors.toList()));
            kisiDtos.add(kisiDto);
        });
        return kisiDtos;
    }


    @Override
    public Page<KisiDto> gelAll(Pageable pageable) {
        return null;
    }
}
