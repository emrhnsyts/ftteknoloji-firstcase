package com.emrhnsyts.ftteknoloji.service;

import com.emrhnsyts.ftteknoloji.entity.Kullanici;
import com.emrhnsyts.ftteknoloji.exception.KullaniciNotFoundException;
import com.emrhnsyts.ftteknoloji.repository.KullaniciRepository;
import com.emrhnsyts.ftteknoloji.response.KullaniciResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KullaniciService {
    private final KullaniciRepository kullaniciRepository;

    //Bir kullanıcının yapmış olduğu yorumları listeleyen bir metot yazınız.
    public KullaniciResponse getKullaniciWithCommentsById(Long kullaniciId) {
        Optional<Kullanici> optionalKullanici = kullaniciRepository.findById(kullaniciId);
        if (!optionalKullanici.isPresent()) {
            throw new KullaniciNotFoundException("Kullanici not found.");
        }
        return new KullaniciResponse(optionalKullanici.get());
    }

    protected Kullanici getKullaniciForService(Long kullaniciId) {
        Optional<Kullanici> optionalKullanici = kullaniciRepository.findById(kullaniciId);
        if (!optionalKullanici.isPresent()) {
            throw new KullaniciNotFoundException("Kullanici not found.");
        }
        return optionalKullanici.get();
    }
}
