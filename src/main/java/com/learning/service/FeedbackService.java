package com.learning.service;

import com.learning.model.Feedback;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

public interface FeedbackService {
     List<Feedback> getFeedbacks(Integer id);
     void createFeedback(Integer id,
                        String detail,
                        Integer rate,
                        Principal principal);

     void deleteById(Integer id);

     List<Feedback> getFeedbacks(String username);
     void updateFeedback(Integer id,
                         String detail,
                         Integer rate,
                         Principal principal);

}
