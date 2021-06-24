package woo;

import java.io.*;
import woo.exceptions.*;

import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;



/**
 * Storefront: façade for the core classes.
 */
public class Storefront{

  /** Current filename. */
  private String _filename = "";

  /** The actual store. */
  private Store _store = new Store();

  private boolean _save = false;


  //FIXME define other attributes
  //FIXME define constructor(s)
  //FIXME define other methods

  public Store getStore() { return this._store; }
  public String getFilename() { return this._filename;  }
  public boolean getSave() { return this._save; }

  /**
   * @throws IOException
   * @throws FileNotFoundException
   * @throws MissingFileAssociationException
   */
  public void save() throws IOException, FileNotFoundException, MissingFileAssociationException, ImportFileException {

    try {
      ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)));
      oos.writeObject(_store);
      oos.close();
    }
    catch (FileNotFoundException  e) {
      throw new FileNotFoundException();
    }
    catch (IOException e) {
      // do not know what to do...
      e.printStackTrace();
    }

  }

  /**
   * @param filename
   * @throws MissingFileAssociationException
   * @throws IOException
   * @throws FileNotFoundException
   */
  public void saveAs(String filename) throws MissingFileAssociationException, FileNotFoundException, IOException {
    _filename = filename;
  }

  /**
   * @param filename
   * @throws UnavailableFileException
   */
  public void load(String filename) throws UnavailableFileException {
    try {
      ObjectInputStream ois = new ObjectInputStream(new  BufferedInputStream(new FileInputStream(filename)));
      _store = (Store) ois.readObject();
      ois.close();
      _filename = filename;
    }
    catch (FileNotFoundException e) {
      throw new UnavailableFileException(this._filename);
    }
    catch(ClassNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      //I dont know what to do.................
      e.printStackTrace();
    }
  }

  /**
   * @param textfile
   * @throws ImportFileException
   */
  public void importFile(String textfile) throws ImportFileException{
    try {
      _store.importFile(textfile);


    } catch (BadEntryException | FileNotFoundException/* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(textfile);
    }
  }

}
