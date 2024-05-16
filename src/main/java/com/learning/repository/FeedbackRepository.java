package com.learning.repository;

import com.learning.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    @Query("SELECT f FROM Feedback f WHERE f.user.username = :username")
    List<Feedback> findByUserUsername(String username);

    @Query("SELECT f FROM Feedback f WHERE f.product.product_id = :product_id")
    List<Feedback> findByProductProduct_id(Integer product_id);
}
