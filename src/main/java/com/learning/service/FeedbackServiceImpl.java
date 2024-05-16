package com.learning.service;

import com.learning.dto.FeedbackDTO;
import com.learning.model.Feedback;
import com.learning.model.Product;
import com.learning.model.User;
import com.learning.repository.FeedbackRepository;

import com.learning.repository.ProductRepository;
import com.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Feedback> getFeedbacks(String username) {
        return feedbackRepository.findByUserUsername(username);
    }

    @Override
    public List<Feedback> getFeedbacks(Integer id) {
        return feedbackRepository.findByProductProduct_id(id);
    }

    @Override
    public void createFeedback(Integer id,
                              String detail,
                              Integer rate,
                              Principal principal) {
        User user =userRepository.findByUsername(principal.getName());
        Product product = productRepository.findById(id).get();

        Feedback feedback =Feedback.builder()
                .user(user)
                .product(product)
                .detail(detail)
                .rate(rate)
                .build();
        feedbackRepository.save(feedback);
    }

    @Override
    public void deleteById(Integer id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public void updateFeedback(Integer id, String detail,
                                   Integer rate,
                                   Principal principal) {
        Feedback feedback = feedbackRepository.findById(id)
                .orElseThrow();
        User existingUser =userRepository.findByUsername(principal.getName());
        Product existingProduct = productRepository.findById(id)
                .orElseThrow();
        feedback.setDetail(detail);
        feedback.setRate(rate);
        feedback.setUser(existingUser);
        feedback.setProduct(existingProduct);

        feedbackRepository.save(feedback);
    }
}
