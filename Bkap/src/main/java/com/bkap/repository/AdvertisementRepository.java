package com.bkap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
	List<Advertisement> findByIsUseTrue();
}
