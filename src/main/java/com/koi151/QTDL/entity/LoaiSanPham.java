package com.koi151.QTDL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "loai_san_pham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoaiSanPham extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long maLoai;

    @OneToMany(mappedBy = "loaiSanPham",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<SanPham> dsSanPham;

    @Column(name = "tenLoai", nullable = false, length = 100)
    private String tenLoai;
}
