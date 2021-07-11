package com.bkap.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bkap.entities.Advertisement;
import com.bkap.entities.Image;
import com.bkap.model.AdvertisementBannerModel;
import com.bkap.service.AdvertisementService;
import com.bkap.service.ImageService;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementAPI {
	@Autowired
	private ImageService imageService;

	@Autowired
	private AdvertisementService advertisementService;

	@GetMapping("")
	public ResponseEntity<String> getAdvertisement() {
		return ResponseEntity.ok("Success");
	}

	@PostMapping("/create-advertisement")
	public ResponseEntity<Object> createAdvertisement(@RequestBody AdvertisementBannerModel advertisementBannerModel) {
		try {
			Page<Advertisement> page = advertisementService.findAll(0, 10);

			int advOrder = 0;

			if (page != null) {
				List<Advertisement> advertisements = page.getContent();

				if (!advertisements.isEmpty()) {
					Advertisement topAdv = advertisements.get(0);

					if (topAdv != null) {
						advOrder = topAdv.getAdvertisementOrder();
					}
				}
			}

			Advertisement advertisement = new Advertisement();
			advertisement.setIsUse(true);
			advertisement.setDisplayName(advertisementBannerModel.displayName);
			advertisement.setBtnName(advertisementBannerModel.btnName);
			advertisement.setBtnLink(advertisementBannerModel.btnLink);
			advertisement.setBtnIsUse(advertisementBannerModel.btnIsUse);
			advertisement.setContent(advertisementBannerModel.content);
			advertisement.setAdvertisementOrder(advOrder + 1);
			advertisementService.save(advertisement);

			Image image = new Image();
			image.setLinkImage("http://localhost:8888/files/" + advertisementBannerModel.image);
			image.setAdvertisement(advertisement);
			imageService.save(image);

			return ResponseEntity.ok(advertisementBannerModel);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e);
		}

	}

	@PostMapping("/edit-advertisement")
	public ResponseEntity<Object> editAdvertisement(@RequestBody AdvertisementBannerModel advertisementBannerModel) {
		try {
			Advertisement advertisement = advertisementService.findById(advertisementBannerModel.id);
			advertisement.setDisplayName(advertisementBannerModel.displayName);
			advertisement.setBtnName(advertisementBannerModel.btnName);
			advertisement.setBtnLink(advertisementBannerModel.btnLink);
			advertisement.setBtnIsUse(advertisementBannerModel.btnIsUse);
			advertisement.setContent(advertisementBannerModel.content);
			advertisementService.save(advertisement);

			if (advertisementBannerModel.image != null) {
				Image image = advertisement.getImages().get(0);
				image.setLinkImage("http://localhost:8888/files/" + advertisementBannerModel.image);
				imageService.save(image);
			}

			return ResponseEntity.ok(advertisementBannerModel);

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("");
		}

	}
}
