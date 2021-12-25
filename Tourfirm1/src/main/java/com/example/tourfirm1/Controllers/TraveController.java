package com.example.tourfirm1.Controllers;

import com.example.tourfirm1.models.Tour;
import com.example.tourfirm1.reposytories.ToursRepository;
import com.example.tourfirm1.services.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TraveController {
    @Autowired
    ToursRepository toursRepository;
    private final TourService tourService;

    @GetMapping("/")
    public String traves(@RequestParam(name = "title",required = false) String title, Model model){
        model.addAttribute("Tours",tourService.tours(title));
        return "Travels";
    }

    @GetMapping("/TraveagencyTravels")
    public String travesAgency(@RequestParam(name = "title",required = false) String title, Model model){
        model.addAttribute("Tours",tourService.tours(title));
        return "TraveagencyTravels";
    }

    @PostMapping("/TraveagencyTravels/tour/create")
   public String createTour(Tour tour){
        tourService.saveTour(tour);
        return "redirect:/TraveagencyTravels";
    }

    @PostMapping("/tour/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        tourService.deleteTour(id);
        return "redirect:/TraveagencyTravels";
    }

    @GetMapping("/tour/{id}")
    public String TourInfo(@PathVariable Long id, Model model) {
        model.addAttribute("Tour", tourService.getTourById(id));
        return "Tourinfo";
    }

    @GetMapping("TraveagencyTravels/tour/{id}")
    public String TraveagencyTourinfo(@PathVariable Long id, Model model) {
        model.addAttribute("Tour", tourService.getTourById(id));
        return "TraveagencyTourinfo";
    }

    @GetMapping("TraveagencyTravels/edit/{id}")
    public String TraveagencyTravelsedit(@PathVariable Long id, Model model){
        Optional<Tour> tour = toursRepository.findById(id);
        ArrayList<Tour> res = new ArrayList<>();
        tour.ifPresent(res::add);
        model.addAttribute("Tour",res);
        return "Travels-edit";
    }

    @PostMapping("/TraveagencyTravels/Travelsedit/")
    public String TraveagencyTravelsUpdate(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam String country,
            @RequestParam String description,
            @RequestParam int price) {
        Tour tour = toursRepository.findById(id).orElseThrow();
        tour.setTitle(title);
        tour.setCountry(country);
        tour.setDescription(description);
        tour.setPrice(price);
        toursRepository.save(tour);

        return "redirect:/TraveagencyTravels";
    }


}
