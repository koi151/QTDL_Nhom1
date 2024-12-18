package com.koi151.QTDL.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "product_category")
@Table(name = "product_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory extends BaseEntityNoDefaultVal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "productCategory",
        cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Product> products;

    @Column(name = "categoryName", nullable = false, length = 100)
    private String categoryName;
}
