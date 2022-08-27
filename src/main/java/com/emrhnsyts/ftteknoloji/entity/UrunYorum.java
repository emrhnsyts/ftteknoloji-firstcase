package com.emrhnsyts.ftteknoloji.entity;

import com.emrhnsyts.ftteknoloji.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class UrunYorum extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT", length = 500)
    private String yorum;
    @CreatedDate
    private LocalDate yorumTarihi;
    @ManyToOne(fetch = FetchType.LAZY)
    private Urun urun;
    @ManyToOne(fetch = FetchType.LAZY)
    private Kullanici kullanici;
}
