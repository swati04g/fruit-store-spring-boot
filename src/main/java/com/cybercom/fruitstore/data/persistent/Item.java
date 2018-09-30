package com.cybercom.fruitstore.data.persistent;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Item implements java.io.Serializable {

	private static final long serialVersionUID = -7542865246382197538L;

	@Id
	@GeneratedValue
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY)
    private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
