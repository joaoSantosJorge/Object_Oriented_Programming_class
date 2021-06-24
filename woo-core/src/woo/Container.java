

//ALTERAR -> CONTENTOR VEM DE CAIXA

package woo;

import java.io.Serializable;

public class Container extends Product implements Serializable{
	private String _serviceType;
	private String _serviceLevel;

	public Container (String id, String serviceType, String serviceLevel, String supplierId, int price, int criticValue, int numberExistences) {
		super(id, criticValue, numberExistences, supplierId, price);
		this._serviceType = serviceType;
		this._serviceLevel = serviceLevel;
	}

	public String getServiceType() {	return this._serviceType;	}
	public String getServiceLevel() {	return this._serviceLevel;	}

	@Override
	public String toString() {
		return "CONTAINER|" + super.getId() + "|" + super.getSupplierId() + "|" + super.getPrice() + "|" + super.getCriticValue() + "|" + super.getNumberExistences() + "|" + this._serviceType + "|" + this._serviceLevel;
	}
}