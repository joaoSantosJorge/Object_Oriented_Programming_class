package woo.app.suppliers;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.Supplier;

/**
 * Show all suppliers.
 */
public class DoShowSuppliers extends Command<Storefront> {

  //FIXME add input fields

  public DoShowSuppliers(Storefront receiver) {
    super(Label.SHOW_ALL_SUPPLIERS, receiver);
    //FIXME init input fields
  }

  @Override
  public void execute() throws DialogException {
  	for (Supplier supplier : _receiver.getStore().getSupplierTree().values())
  		if(supplier.getActivate() == true)
  			_display.addLine(supplier.toString() + "|" + Message.yes());
  		else
  			_display.addLine(supplier.toString() + "|" + Message.no());

  	_display.display();
  }
}
