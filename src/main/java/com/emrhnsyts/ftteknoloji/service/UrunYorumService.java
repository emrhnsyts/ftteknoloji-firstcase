package com.emrhnsyts.ftteknoloji.service;

import com.emrhnsyts.ftteknoloji.entity.Kullanici;
import com.emrhnsyts.ftteknoloji.entity.Urun;

import com.emrhnsyts.ftteknoloji.repository.UrunYorumRepository;
import com.emrhnsyts.ftteknoloji.response.UrunYorumResponseWithKullaniciId;
import com.emrhnsyts.ftteknoloji.response.UrunYorumResponseWithUrunId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UrunYorumService {
    private final UrunYorumRepository urunYorumRepository;
    private final UrunService urunService;
    private final KullaniciService kullaniciService;


    //Verilen tarih aralıklarında belirli bir ürüne yapılmış olan yorumları gösteren bir metot yazınız.
    public List<UrunYorumResponseWithKullaniciId> getCommentsByUrunIdAndPeriod(Long urunId, String from, String to) {
        Urun urun = urunService.getUrunForService(urunId);

        String[] fromSplit;
        String[] toSplit;
        LocalDate fromDate;
        LocalDate toDate;
        try {
            fromSplit = from.split("-");
            toSplit = to.split("-");
            fromDate = LocalDate.of(Integer.parseInt(fromSplit[0]),
                    Integer.parseInt(fromSplit[1]),
                    Integer.parseInt(fromSplit[2]));
            toDate = LocalDate.of(Integer.parseInt(toSplit[0]),
                    Integer.parseInt(toSplit[1]),
                    Integer.parseInt(toSplit[2]));
        } catch (Exception e) {
            throw new DateTimeException("Bad date format.");

        }
        return urunYorumRepository.findUrunYorumsByUrunIdAndYorumTarihiBetween(urun.getId(), fromDate, toDate)
                .stream()
                .map((urunYorum -> {
                    return new UrunYorumResponseWithKullaniciId(urunYorum);
                })).collect(Collectors.toList());
    }

    //Bir kullanıcının belirli tarihler aralığında yapmış olduğu yorumları gösteren bir metot yazınız.
    public List<UrunYorumResponseWithUrunId> getCommentsByKullaniciIdAndPeriod(Long kullaniciId, String from, String to) {
        Kullanici kullanici = kullaniciService.getKullaniciForService(kullaniciId);

        String[] fromSplit;
        String[] toSplit;
        LocalDate fromDate;
        LocalDate toDate;
        try {
            fromSplit = from.split("-");
            toSplit = to.split("-");
            fromDate = LocalDate.of(Integer.parseInt(fromSplit[0]),
                    Integer.parseInt(fromSplit[1]),
                    Integer.parseInt(fromSplit[2]));
            toDate = LocalDate.of(Integer.parseInt(toSplit[0]),
                    Integer.parseInt(toSplit[1]),
                    Integer.parseInt(toSplit[2]));
        } catch (Exception e) {
            throw new DateTimeException("Bad date format.");
        }
        return urunYorumRepository.findUrunYorumsByKullaniciIdAndYorumTarihiBetween(kullanici.getId(), fromDate, toDate)
                .stream()
                .map((urunYorum -> {
                    return new UrunYorumResponseWithUrunId(urunYorum);
                })).collect(Collectors.toList());
    }
}
