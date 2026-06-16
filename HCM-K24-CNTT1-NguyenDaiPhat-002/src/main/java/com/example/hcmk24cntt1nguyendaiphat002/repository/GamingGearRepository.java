package com.example.hcmk24cntt1nguyendaiphat002.repository;

import com.example.hcmk24cntt1nguyendaiphat002.entity.GamingGear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamingGearRepository extends JpaRepository<GamingGear, Long> {
}
