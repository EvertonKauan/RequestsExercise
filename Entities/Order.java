package Entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import EntitieClient.Client;
import EntitiesEnum.OrderStatus;

public class Order {
	private Date date;
	private OrderStatus status;
	private Product prod;
	private OrderItem orderitem;
	
	private List<OrderItem> items;
	private Client cliente;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	
	private List<OrderItem> orit = new ArrayList<>();
	
	public Order() {
	}

	public OrderItem getOrderitem() {
		return orderitem;
	}

	public Order(Date date, OrderStatus status, Client cliente) {
		super();
		this.date = date;
		this.status = status;
		this.cliente = cliente;
	}

	public void setOrderitem(OrderItem orderitem) {
		this.orderitem = orderitem;
	}

	public List<OrderItem> getOrit() {
		return orit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public Client getCliente() {
		return cliente;
	}

	public void setCliente(Client cliente) {
		this.cliente = cliente;
	}
	
	public List<OrderItem> getItem() {
		return orit;
	}

	public void addItem(OrderItem price) {
		orit.add(price);
	}
	
	public void removeItem(OrderItem price) {
		orit.remove(price);
	}
	
	public double totalValue(OrderItem subTotal) {
		double sum = 0;
		for (OrderItem t : orit) {
			sum += t.subTotal();
			}
		return sum;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(getDate()));
		sb.append("\n");
		sb.append("Order Status: " + getStatus());
		sb.append("\n");
		sb.append("Client: " + getCliente() );
		sb.append("\n");
		sb.append("\n");
		sb.append("Order Itens: " );
		sb.append("\n");
		for (OrderItem c : orit) {
			sb.append(c + "\n");
		}
		sb.append("\n");
		sb.append("Total price: $");
		sb.append(String.format("%.2f", totalValue(orderitem)));
		return sb.toString();
		}
	/*public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(new Date()) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(cliente + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();*/
	
	}
