package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.app.exceptions.UnknownClientKeyException;
import woo.Client;
//FIXME import other classes

/**
 * Show client.
 */
public class DoShowClient extends Command<Storefront> {

  private Input<String> _key;

  public DoShowClient(Storefront storefront) {
    super(Label.SHOW_CLIENT, storefront);
    _key = _form.addStringInput(Message.requestClientKey());
  }

  @Override
  public void execute() throws DialogException {
  	_form.parse();


    Client c = _receiver.getStore().getClientTree().get(_key.value());

    //if no key or key does not match
  	//if (c.getID() == null) {
  		//throw new UnknownClientKeyException(_key.value());
    //}


  	_display.addLine(c.toString());
  	_display.display();
    //FIXME implement command
  }

}
