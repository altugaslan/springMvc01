package com.tpe.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Basarmak istedigin gorevi giriniz")
    private String gorevAdi;
    @NotBlank(message = "Aldigin gorev icin sahip olman gerekenleri giriniz")
    private String gorevinGerektirdikleri;
    @NotNull(message = "Ne kadarlik bir surede basarabilirsin?")
    private Integer gorevSuresi;

    private LocalDateTime gorevTarihi=LocalDateTime.now();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGorevAdi() {
        return gorevAdi;
    }

    public void setGorevAdi(String gorevAdi) {
        this.gorevAdi = gorevAdi;
    }

    public String getGorevinGerektirdikleri() {
        return gorevinGerektirdikleri;
    }

    public void setGorevinGerektirdikleri(String gorevinGerektirdikleri) {
        this.gorevinGerektirdikleri = gorevinGerektirdikleri;
    }

    public Integer getGorevSuresi() {
        return gorevSuresi;
    }

    public void setGorevSuresi(Integer gorevSuresi) {
        this.gorevSuresi = gorevSuresi;
    }

    public LocalDateTime getGorevTarihi() {
        return gorevTarihi;
    }

    public void setGorevTarihi(LocalDateTime gorevTarihi) {
        this.gorevTarihi = gorevTarihi;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", gorevAdi='" + gorevAdi + '\'' +
                ", gorevinGerektirdikleri='" + gorevinGerektirdikleri + '\'' +
                ", gorevSuresi=" + gorevSuresi +
                ", gorevTarihi=" + gorevTarihi +
                '}';
    }
}
