package com.emrhnsyts.ftteknoloji.response;

import com.emrhnsyts.ftteknoloji.entity.Urun;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UrunResponse {
    private Long id;
    private String adi;
    private Double fiyat;
    private LocalDate sonKullanmaTarihi;
    private List<UrunYorumResponseWithKullaniciId> urunYorums;

    public UrunResponse(Urun urun) {
        this.id = urun.getId();
        this.adi = urun.getAdi();
        this.fiyat = urun.getFiyat();
        this.sonKullanmaTarihi = urun.getSonKullanmaTarihi();
        this.urunYorums = urun.getUrunYorums().stream().map(
                urunYorum -> {
                    return new UrunYorumResponseWithKullaniciId(urunYorum);
                }
        ).collect(Collectors.toList());
    }
}
