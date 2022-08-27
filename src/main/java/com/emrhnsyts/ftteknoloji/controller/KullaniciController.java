package com.emrhnsyts.ftteknoloji.controller;

import com.emrhnsyts.ftteknoloji.response.KullaniciResponse;
import com.emrhnsyts.ftteknoloji.response.UrunYorumResponseWithKullaniciId;
import com.emrhnsyts.ftteknoloji.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/kullanicis")
@RestController
public class KullaniciController {
    private final KullaniciService kullaniciService;

    //Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    @GetMapping("/{kullaniciId}")
    public KullaniciResponse getKullaniciWithComments(@PathVariable("kullaniciId") Long kullaniciId) {
        return kullaniciService.getKullaniciWithCommentsById(kullaniciId);
    }
}
