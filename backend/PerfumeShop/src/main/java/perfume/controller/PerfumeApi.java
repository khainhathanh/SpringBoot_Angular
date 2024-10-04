package perfume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import perfume.entity.Carousel;
import perfume.entity.Perfume;
import perfume.service.PerfumeService;

@RestController
public class PerfumeApi {
	
	@Autowired
	private  PerfumeService perfumeService;
	
	@GetMapping("/listAllPerfumes")
    public List<Perfume> getAllUsers() {
        return perfumeService.listAllPerfumes();
    }
	
	@GetMapping("/listAllCarousel")
    public List<Carousel> getAllCarousel() {
        return perfumeService.listAllCarousel();
    }
}
