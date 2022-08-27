package com.emrhnsyts.ftteknoloji.controller;

import com.emrhnsyts.ftteknoloji.response.UrunYorumResponseWithKullaniciId;
import com.emrhnsyts.ftteknoloji.response.UrunYorumResponseWithUrunId;
import com.emrhnsyts.ftteknoloji.service.UrunYorumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/urunYorums")
@RestController
@RequiredArgsConstructor
public class UrunYorumsController {
    private final UrunYorumService urunYorumService;

    //Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    @GetMapping("urun/{urunId}/from/{from}/to/{to}")
    public List<UrunYorumResponseWithKullaniciId> getYorumsByUrunIdAndPeriod(@PathVariable("urunId") Long urunId,
                                                                             @PathVariable("from") String from,
                                                                             @PathVariable("to") String to) {
        return urunYorumService.getCommentsByUrunIdAndPeriod(urunId, from, to);
    }

    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    @GetMapping("kullanici/{kullaniciId}/from/{from}/to/{to}")
    public List<UrunYorumResponseWithUrunId> getYorumsByKullaniciIdAndPeriod(@PathVariable("kullaniciId") Long kullaniciId,
                                                                             @PathVariable("from") String from,
                                                                             @PathVariable("to") String to) {
        return urunYorumService.getCommentsByKullaniciIdAndPeriod(kullaniciId, from, to);
    }
}
