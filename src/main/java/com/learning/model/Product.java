package com.learning.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
//lombok generate automatic getter setter
@Getter
@Setter
@Table(name = "products")
public class Product implements Serializable {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	private Integer saleoff_id;


	@ManyToOne
	@JoinColumn(name = "typeofproduct_id",nullable=false)
	//cho nay can phai manytoone
	private TypeOfProducts typeofproducts;

	private String product_name;
	
	private Integer quantity;
	
	private int price;
	
	private String product_desc;

	@OneToMany(mappedBy = "product")
	private List<Cart> carts;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Image> images;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Collection<Feedback> feedbacks;

	public void setImages(List<Image> images) {
		this.images = images;
	}


	public Product(Integer product_id, Integer saleoff_id, TypeOfProducts typeofproducts, String product_name, Integer quantity, int price, String product_desc) {
		this.product_id = product_id;
		this.saleoff_id = saleoff_id;
		this.typeofproducts = typeofproducts;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.product_desc = product_desc;
	}

	public Product() {
		super();
	}
	
	
	
}
