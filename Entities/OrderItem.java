package Entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private Product prod;
	
	public OrderItem(Integer quantity, Double price, Product prod) {
		this.quantity = quantity;
		this.price = price;
		this.prod = prod;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		Double subTotal = quantity * price;
		return subTotal;
		
	}
	@Override
	public String toString() {
		return "Product: " + prod.getName() + ", " + "Quantitty: " + getQuantity() + ", " + "Price: " + getPrice() + ", " + "SubTotal: " + subTotal();
	}
	
	
	
}
