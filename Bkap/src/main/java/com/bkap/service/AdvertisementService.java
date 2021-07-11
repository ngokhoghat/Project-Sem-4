
package com.bkap.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bkap.entities.Advertisement;
import com.bkap.repository.AdvertisementRepository;

@Service
public class AdvertisementService {
	@Autowired
	private AdvertisementRepository advertisementRepository;

	public Page<Advertisement> findAll(int pageNo, int pageSize) {
		Pageable sortedByOrder = PageRequest.of(pageNo, pageSize, Sort.by("advertisementOrder"));
		return advertisementRepository.findAll(sortedByOrder);
	}

	public Advertisement findById(Long id) {
		return advertisementRepository.findById(id).get();
	}

	public List<Advertisement> findByIsUseTrue() {
		return advertisementRepository.findByIsUseTrue();
	}

	public Advertisement save(Advertisement advertisement) {
		return advertisementRepository.save(advertisement);
	}

}
