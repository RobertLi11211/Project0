package com.revature.pojos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car implements Serializable {

	private String vin;
	private Map<Double, String> offers = new HashMap<>();
	private double acceptedOffer = 0;
	private String make;
	private String model;
	private String color;
	private List<Double> payments;
	private double remainingPayment;
	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Map<Double, String> getOffers() {
		return offers;
	}

	public void setOffers(Map<Double, String> offers) {
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

	public List<Double> getPayments() {
		return payments;
	}

	public void setPayments(List<Double> payments) {
		this.payments = payments;
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
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((payments == null) ? 0 : payments.hashCode());
		temp = Double.doubleToLongBits(remainingPayment);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (payments == null) {
			if (other.payments != null)
				return false;
		} else if (!payments.equals(other.payments))
			return false;
		if (Double.doubleToLongBits(remainingPayment) != Double.doubleToLongBits(other.remainingPayment))
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
				+ ", model=" + model + ", color=" + color + ", payments=" + payments + ", remainingPayment="
				+ remainingPayment + ", owner=" + owner + "]";
	}

	public Car(String vin, String make, String model, String color) {
		super();
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

}
