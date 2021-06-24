package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;
//FIXME import other classes

/**
 * Show current date.
 */
public class DoDisplayDate extends Command<Storefront> {


  public DoDisplayDate(Storefront receiver) {
    super(Label.SHOW_DATE, receiver);
  }

  @Override
  public final void execute() throws DialogException {
    _display.addLine(Message.currentDate(_receiver.getStore().getDate()));
    _display.display();
  }
}
