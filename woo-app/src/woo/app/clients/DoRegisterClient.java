package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.Client;
import woo.app.exceptions.DuplicateClientKeyException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;

/**
 * Register new client.
 */
public class DoRegisterClient extends Command<Storefront> {

  private Input<String> _key;
  private Input<String> _name;
  private Input<String> _address;

  public DoRegisterClient(Storefront storefront) {
    super(Label.REGISTER_CLIENT, storefront);
    _key = _form.addStringInput(Message.requestClientKey());
    _name = _form.addStringInput(Message.requestClientName());
    _address = _form.addStringInput(Message.requestClientAddress());
  }

  @Override
  public void execute() throws DialogException {
  	_form.parse();

    Map<String, Client> clientTreeCpy = _receiver.getStore().getClientTree();
    Set<String> set = clientTreeCpy.keySet();


    for (String key : set) {
      if (key.equals(this._key))
        throw new DuplicateClientKeyException(_key.value());
    }

  	//if (_receiver.getStore().getClient(_key.value()) != null)
  		//throw new DuplicateClientKeyException(_key.value());

    

    //for (Client c : _receiver.getStore().getClient()) {
      //System.out.println(c);
      //if (c.getID() == this._key.value())
        //throw new DuplicateClientKeyException(_key.value());
    

  	Client client = new Client(_key.value(), _name.value(), _address.value());

  	_receiver.getStore().getClientTree().put(_key.value(), client);


  }

}
