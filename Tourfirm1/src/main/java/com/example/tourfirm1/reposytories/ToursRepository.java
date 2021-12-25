package com.example.tourfirm1.reposytories;

import com.example.tourfirm1.models.Tour;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToursRepository extends JpaRepository<Tour,Long> {
    List<Tour> findByTitle(String title);
}
