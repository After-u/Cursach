package com.example.tourfirm1.services;


import com.example.tourfirm1.models.Tour;
import com.example.tourfirm1.reposytories.ToursRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TourService {
    private final ToursRepository toursRepository;

    public List<Tour> tours(String title){
        if (title!=null) return toursRepository.findByTitle(title);
        return toursRepository.findAll();
    }

    public void saveTour(Tour tour){
        log.info("Added new tour {}",tour);
        toursRepository.save(tour);
    }

    public void editTour(Tour tour){

    }

    public void deleteTour(Long id){
        log.info("Deleted tour {}", toursRepository.getById(id));
        toursRepository.deleteById(id);
    }

    public Tour getTourById(Long id) {
        return toursRepository.findById(id).orElse(null);
    }
}
