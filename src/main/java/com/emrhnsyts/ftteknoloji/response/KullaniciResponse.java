package com.emrhnsyts.ftteknoloji.response;

import com.emrhnsyts.ftteknoloji.entity.Kullanici;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KullaniciResponse {
    private Long id;
    private String adi;
    private String soyadi;
    private String email;
    private String telefon;
    private List<UrunYorumResponseWithUrunId> urunYorums;

    public KullaniciResponse(Kullanici kullanici) {
        this.id = kullanici.getId();
        this.adi = kullanici.getAdi();
        this.soyadi = kullanici.getSoyadi();
        this.email = kullanici.getEmail();
        this.telefon = kullanici.getTelefon();
        this.urunYorums = kullanici.getUrunYorums().stream().map(
                urunYorum -> {
                    return new UrunYorumResponseWithUrunId(urunYorum);
                }
        ).collect(Collectors.toList());
    }
}
