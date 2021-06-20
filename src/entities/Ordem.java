package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrdemStatus;

public class Ordem {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrdemStatus status;
	
	private Client client;
	
	private List<Ordemitem> items = new ArrayList<Ordemitem>();
	
	public Ordem() {
	}

	public Ordem(Date moment, OrdemStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrdemStatus getStatus() {
		return status;
	}

	public void setStatus(OrdemStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(Ordemitem item) {
		items.add(item);
	}
	public void removeItem(Ordemitem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (Ordemitem it : items) {
			sum += it.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment)+ "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: \n");
		for (Ordemitem item : items) {
			 sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
		 
	}

}
