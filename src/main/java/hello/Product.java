package hello;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by vinit.bothra on 1/12/15.
 */
@Getter
@Setter
public class Product {

	String baseSku;

	String title;

	String description;

	String categoryId;

	Integer price;

	Product() {
	}

	public Product(String baseSku, String title, String description, String categoryId, Integer price) {
		this.baseSku = baseSku;
		this.title = title;
		this.description = description;
		this.categoryId = categoryId;
		this.price = price;
	}


}
