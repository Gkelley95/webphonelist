package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class ListItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="BRAND")
	private String brand;
	@Column(name="ITEM")
	private String item;
	@Column(name="PRICE")
	private String price;
	
	public ListItem() {		
	}

	public ListItem(String s, String i, String p) {
		this.brand = s;
		this.item = i;
		this.price = p;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ListItem [id=" + id + ", brand=" + brand + ", item=" + item + ", price=" + price + "]";
	}

	public String returnItemDetails() {
		return brand + ": " + item + " " + price;
	}
	
}
