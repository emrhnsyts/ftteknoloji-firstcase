package com.emrhnsyts.ftteknoloji.controller;

import com.emrhnsyts.ftteknoloji.response.UrunResponse;
import com.emrhnsyts.ftteknoloji.service.UrunService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/uruns")
@RequiredArgsConstructor
public class UrunController {
    private final UrunService urunService;


    //Bir ürüne ait yorumları listeleyen bir metot yazınız.
    @GetMapping("/{urunId}")
    public UrunResponse getUrunsWithComments(@PathVariable("urunId") Long urunId) {
        return urunService.getUrunWithCommentsById(urunId);
    }

    //Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız
    @GetMapping("/expired")
    public List<UrunResponse> getExpiredUruns() {
        return urunService.getExpiredUruns();
    }

    //Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    @GetMapping("/notExpired")
    public List<UrunResponse> getNotExpiredUruns() {
        return urunService.getNotExpiredUruns();
    }


}
