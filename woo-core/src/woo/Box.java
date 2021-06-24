package woo;

import java.io.Serializable;

public class Box extends Product implements Serializable{
	private String _serviceType;


	public Box (String id, String serviceType, String supplierId, int price, int criticValue, int numberExistences) {
		super(id, criticValue, numberExistences, supplierId, price);
		this._serviceType = serviceType;
	}

	public String getServiceType() {	return this._serviceType;	}

	@Override
	public String toString() {
		return "BOX|" + super.getId() + "|" + super.getSupplierId() + "|" + super.getPrice() + "|" + super.getCriticValue() + "|" + super.getNumberExistences() + "|" + this._serviceType;
	}
}