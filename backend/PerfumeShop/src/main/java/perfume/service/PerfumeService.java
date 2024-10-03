package perfume.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import perfume.entity.Perfume;
import perfume.repository.PerfumeRepository;


@Service
public class PerfumeService {
	
	@Autowired
	private PerfumeRepository perfumeRepository;

	public List<Perfume> listAllPerfumes() {
        return perfumeRepository.findAll();
    }
	
}
