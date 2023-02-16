package com.bootapp.rest.restapp.data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bootapp.rest.restapp.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	
}