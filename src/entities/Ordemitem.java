package entities;

public class Ordemitem {
	
	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public Ordemitem(){
	}
	public Ordemitem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantily(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return price * quantity;
	}
	
	@Override
	public String toString() {
		return getProduct().getName()
				+ ", $"
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity
				+ ", Subtotal: $"
				+ String.format("%.2f", subTotal());
		
	}
	
	

}
