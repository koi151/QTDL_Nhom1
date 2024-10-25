package com.koi151.QTDL.repository;

import com.koi151.QTDL.entity.DaiLy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaiLyRepository extends JpaRepository<DaiLy, Long> {
    Boolean existsByTenDL(String name);
}