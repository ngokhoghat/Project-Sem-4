package com.bkap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkap.entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
