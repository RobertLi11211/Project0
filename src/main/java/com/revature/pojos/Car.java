package com.revature.pojos;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Car implements Serializable{
	
	private String vin;	
	private Map<Double, Offer> offers = new HashMap<>();
	private double acceptedOffer;
	private String make;
	private String model;
	private String color;
	private double remainingPayment;
	
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public Map<Double, Offer> getOffers() {
		return offers;
	}
	public void setOffers(Map<Double, Offer> offers) {
		this.offers = offers;
	}
	public double getAcceptedOffer() {
		return acceptedOffer;
	}
	public void setAcceptedOffer(double acceptedOffer) {
		this.acceptedOffer = acceptedOffer;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
	public double getRemainingPayment() {
		return remainingPayment;
	}
	public void setRemainingPayment(double remainingPayment) {
		this.remainingPayment = remainingPayment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(acceptedOffer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((offers == null) ? 0 : offers.hashCode());
		result = prime * result + ((vin == null) ? 0 : vin.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (Double.doubleToLongBits(acceptedOffer) != Double.doubleToLongBits(other.acceptedOffer))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (offers == null) {
			if (other.offers != null)
				return false;
		} else if (!offers.equals(other.offers))
			return false;
		if (vin == null) {
			if (other.vin != null)
				return false;
		} else if (!vin.equals(other.vin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car [vin=" + vin + ", offers=" + offers + ", acceptedOffer=" + acceptedOffer + ", make=" + make
				+ ", model=" + model + ", color=" + color + "]";
	}
	public Car(String vin, Map<Double, Offer> offers, double acceptedOffer, String make, String model, String color) {
		super();
		this.vin = vin;
		this.offers = offers;
		this.acceptedOffer = acceptedOffer;
		this.make = make;
		this.model = model;
		this.color = color;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
