package com.emrhnsyts.ftteknoloji.entity;

import com.emrhnsyts.ftteknoloji.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Kullanici extends BaseEntity {
    @Column(length = 50, nullable = false)
    private String adi;
    @Column(length = 50, nullable = false)
    private String soyadi;
    @Column(length = 50, nullable = false, unique = true)
    private String email;
    @Column(length = 15, nullable = false, unique = true)
    private String telefon;
    @OneToMany(mappedBy = "kullanici", fetch = FetchType.LAZY)
    private List<UrunYorum> urunYorums;
}
