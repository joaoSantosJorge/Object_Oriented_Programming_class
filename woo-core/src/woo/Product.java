package woo;

import java.io.Serializable;


public class Product implements Serializable{
	private String _id;
	private int _criticValue;
	private int _numberExistences;
	private String _supplierId;
	private int _price;

	public Product(String id, int criticValue, int numberExistences, String supplierId, int price) {
		this._id = id;
		this._criticValue = criticValue;
		this._numberExistences = numberExistences;
		this._supplierId = supplierId;
		this._price = price;
	}

	public String getId() 				{	return this._id;	}
	public int getCriticValue() 		{	return this._criticValue;	}
	public int getNumberExistences() 	{	return this._numberExistences;	}
	public String getSupplierId() 		{	return this._supplierId;	}
	public int getPrice() 				{	return this._price;	}



	@Override
	public String toString() {
		return "PRODUCT|" + this._id + "|" + this._criticValue +"|" + this._numberExistences + "|" + this._supplierId + "|" + this._price;
	}
}