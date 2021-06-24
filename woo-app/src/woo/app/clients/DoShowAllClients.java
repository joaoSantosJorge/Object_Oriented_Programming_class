package woo.app.clients;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.Client;
import java.util.Map;
import java.util.TreeMap;
//FIXME import other classes

/**
 * Show all clients.
 */
public class DoShowAllClients extends Command<Storefront> {

  //FIXME add input fields

  public DoShowAllClients(Storefront storefront) {
    super(Label.SHOW_ALL_CLIENTS, storefront);
	//FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {

    for (Client client : _receiver.getStore().getClientTree().values()) {
    	_display.addLine(client.toString());
    }
    _display.display();
  }
}
