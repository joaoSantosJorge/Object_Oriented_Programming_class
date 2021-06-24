package woo;

import java.io.*;
import woo.exceptions.*;

import java.lang.Integer;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


/**
 * Class Store implements a store.
 */
public class Store implements Serializable {

  /** Serial number for serialization. */
  private static final long serialVersionUID = 202009192006L;


  private int _date;
  private int _transactionCounter;

  private ArrayList<Product> _products;
  private Map<String, Client> _clients;
  private Map<String, Box> _boxes;
  private Map<String, Container> _containers;
  private Map<String, Book> _books;
  private Map<String, Supplier> _suppliers;



  
  public Store() {
    _products =     new ArrayList<Product>();
    _clients =      new TreeMap<String, Client>();
    _boxes =        new TreeMap<String, Box>();
    _containers =   new TreeMap<String, Container>();
    _books =        new TreeMap<String, Book>();
    _suppliers =    new TreeMap<String, Supplier>();
  }


  public void setDate(int date) { this._date = date;  }


  public int getDate() {                          return this._date;  }
  public ArrayList<Product> getProduct() {        return this._products;  }
  public Map<String, Client> getClientTree() {    return this._clients; }
  public Map<String, Supplier>getSupplierTree() { return this._suppliers;}
  public Client getClient(String key) {           return this._clients.get(key);  }
  public Supplier getSupplier(String key) {       return this._suppliers.get(key);  }

  /**
   * @param txtfile filename to be loaded.
   * @throws IOException
   * @throws BadEntryException
   */
  void importFile(String txtfile) throws BadEntryException, FileNotFoundException/* FIXME maybe other exceptions */ {


    try {
      BufferedReader in = new BufferedReader(new FileReader(txtfile));  
      String s = new String();
      while ((s = in.readLine()) != null) {

        String[] fields = s.split("\\|");
        if (fields[0].equals("CLIENT")) {

          Client client = new Client(fields[1],fields[2],fields[3]);
          _clients.put(client.getId(), client);
          
        }
        else if (fields[0].equals("SUPPLIER")) {
          Supplier supplier = new Supplier(fields[1],fields[2],fields[3]);
          _suppliers.put(supplier.getId(), supplier);

        }
        else if (fields[0].equals("BOX")) {
          Box box = new Box(fields[1], fields[2], fields[3], Integer.parseInt(fields[4]), Integer.parseInt(fields[5]), Integer.parseInt(fields[6]));
          _boxes.put(box.getId(), box);

          _products.add(box);
        }
        else if (fields[0].equals("CONTAINER")) {
          Container container = new Container(fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));
          _containers.put(container.getId(), container);

          _products.add(container);
        }
        else if (fields[0].equals("BOOK")) {
          Book book = new Book(fields[1], fields[2], fields[3], fields[4], fields[5], Integer.parseInt(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]));
          _books.put(book.getId(), book);

          _products.add(book);
        }

      }


    }
    catch (IOException e) {
      System.out.println("IOException!");
      e.printStackTrace();
    }
    
  }



}
