package com.emrhnsyts.ftteknoloji.service;

import com.emrhnsyts.ftteknoloji.entity.Urun;
import com.emrhnsyts.ftteknoloji.entity.UrunYorum;
import com.emrhnsyts.ftteknoloji.exception.UrunNotFoundException;
import com.emrhnsyts.ftteknoloji.repository.UrunRepository;
import com.emrhnsyts.ftteknoloji.response.UrunResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class UrunService {
    private final UrunRepository urunRepository;

    //Bir ürüne ait yorumları listeleyen bir metot yazınız.
    public UrunResponse getUrunWithCommentsById(Long urunId) {
        Optional<Urun> optionalUrun = urunRepository.findById(urunId);
        if (!optionalUrun.isPresent()) {
            throw new UrunNotFoundException("Urun not found.");
        }
        return new UrunResponse(optionalUrun.get());
    }


    //Son kullanma tarihi geçmiş ürünleri listeleyen bir metot yazınız
    public List<UrunResponse> getExpiredUruns() {
        return urunRepository.findUrunsBySonKullanmaTarihiBefore(LocalDate.now()).stream().map(
                urun -> {
                    return new UrunResponse(urun);
                }
        ).collect(Collectors.toList());
    }

    //Son kullanma tarihi geçmemiş ürünleri listeleyen bir metot yazınız. (Son kullanma tarihi boş olanlar da gelmeli.)
    public List<UrunResponse> getNotExpiredUruns() {
        return urunRepository.findUrunsBySonKullanmaTarihiAfterOrSonKullanmaTarihiNull(LocalDate.now()).stream().map(
                urun -> {
                    return new UrunResponse(urun);
                }
        ).collect(Collectors.toList());
    }

    protected Urun getUrunForService(Long urunId) {
        Optional<Urun> optionalUrun = urunRepository.findById(urunId);
        if (!optionalUrun.isPresent()) {
            throw new UrunNotFoundException("Urun not found.");
        }
        return optionalUrun.get();
    }

}
