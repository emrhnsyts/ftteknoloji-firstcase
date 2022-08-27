package com.emrhnsyts.ftteknoloji.repository;

import com.emrhnsyts.ftteknoloji.entity.Urun;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface UrunRepository extends JpaRepository<Urun, Long> {
    List<Urun> findUrunsBySonKullanmaTarihiBefore(LocalDate now);
    List<Urun> findUrunsBySonKullanmaTarihiAfterOrSonKullanmaTarihiNull(LocalDate now);
}
