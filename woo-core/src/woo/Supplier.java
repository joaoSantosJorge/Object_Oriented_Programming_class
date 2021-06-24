package woo;

import java.io.Serializable;
import java.util.ArrayList;

public class Supplier implements Serializable{
	private String _id;
	private String _name;
	private String _address;
	private ArrayList<Transaction> _transactions;
	private boolean _activate;

	public Supplier(String id, String name, String address) {
		this._id = id;
		this._name = name;
		this._address = address;
		this._transactions = new ArrayList<Transaction>();
		this._activate = true;
	}

	public String getId() 								{	return this._id;	}
	public String getName() 							{	return this._name;	}
	public String getAddress() 							{	return this._address;	}
	public ArrayList<Transaction> getTransactions() 	{	return this._transactions;	}
	public boolean getActivate() 						{	return this._activate;	}

	@Override
	public String toString() {
		return this._id + "|" + this._name +"|" + this._address;
	}
}