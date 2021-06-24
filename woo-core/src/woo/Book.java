package woo;

import java.io.Serializable;

public class Book extends Product implements Serializable{
	private String _title;
	private String _author;
	private String _isbn;

	public Book(String id, String title, String author, String isbn, String supplierId, int price, int criticValue, int numberExistences) {
		super(id, criticValue, numberExistences, supplierId, price);
		this._title = title;
		this._author = author;
		this._isbn = isbn;
	}

	public String getTitle() 	{	return this._title;	}
	public String getAuthor() 	{	return this._author;	}
	public String getIsbn()		{	return this._title;	}

	@Override
	public String toString() {
		return "BOOK|" + super.getId() + "|" + super.getSupplierId() + "|" + super.getPrice() + "|" + super.getCriticValue() + "|" + super.getNumberExistences() + "|" + this._title + "|" + this._author + "|" + this._isbn;
	}
}