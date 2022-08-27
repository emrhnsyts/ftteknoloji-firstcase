package com.emrhnsyts.ftteknoloji.entity;

import com.emrhnsyts.ftteknoloji.entity.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Urun extends BaseEntity {
    @Column(nullable = false)
    private String adi;
    private Double fiyat;
    private LocalDate sonKullanmaTarihi;
    @OneToMany(mappedBy = "urun", fetch = FetchType.LAZY)
    private List<UrunYorum> urunYorums;

}
