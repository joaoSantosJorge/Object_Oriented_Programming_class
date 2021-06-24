package woo;
import java.io.Serializable;


public class Client implements Serializable{
	private String _id;
	private String _name;
	private String _address;
	private Statute _Statute;
	private int _purchasesMade;
	private int _purchasesPaid;

	public Client(String id, String name, String address) {
		this._id = id;
		this._name = name;
		this._address = address;
		this._Statute = new Statute();
		this._purchasesMade = 0;
		this._purchasesPaid = 0;

	}

	public String getId() 		{	return this._id;	}
	public String getName() 	{	return this._name;	}
	public String getAddress()	{	return this._address;	}


	@Override
	public String toString() {
		return this._id + "|"+ this._name + "|" + this._address + "|" + this._Statute.toString() + "|" + this._purchasesMade + "|" + this._purchasesPaid;
	}


	//public void buy() {}
	//public void discount() {}


}