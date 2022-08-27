package com.emrhnsyts.ftteknoloji.response;

import com.emrhnsyts.ftteknoloji.entity.UrunYorum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrunYorumResponseWithKullaniciId {
    private Long id;
    private String yorum;
    private LocalDate yorumTarihi;
    private Long kullaniciId;


    public UrunYorumResponseWithKullaniciId(UrunYorum urunYorum) {
        this.id = urunYorum.getId();
        this.yorum = urunYorum.getYorum();
        this.yorumTarihi = urunYorum.getYorumTarihi();
        this.kullaniciId = urunYorum.getKullanici().getId();
    }
}
