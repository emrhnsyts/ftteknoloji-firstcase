package com.emrhnsyts.ftteknoloji.repository;

import com.emrhnsyts.ftteknoloji.entity.UrunYorum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UrunYorumRepository extends JpaRepository<UrunYorum, Long> {
    List<UrunYorum> findUrunYorumsByUrunIdAndYorumTarihiBetween(Long urunId, LocalDate from, LocalDate to);

    List<UrunYorum> findUrunYorumsByKullaniciIdAndYorumTarihiBetween(Long kullaniciId, LocalDate from, LocalDate to);
}
