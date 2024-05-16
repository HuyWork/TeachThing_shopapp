package com.learning.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "feedbacks")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id",nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "detail", length = 350)
    private String detail;

    @Column(name = "rate", nullable = false)
    private int rate;
}
