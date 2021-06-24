package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import woo.app.exceptions.InvalidDateException;
//FIXME import other classes

/**
 * Advance current date.
 */
public class DoAdvanceDate extends Command<Storefront> {
  
  private Input<Integer> _days;

  public DoAdvanceDate(Storefront receiver) {
    super(Label.ADVANCE_DATE, receiver);
    _days = _form.addIntegerInput(Message.requestDaysToAdvance());
  }

  @Override
  public final void execute() throws DialogException {
    _form.parse();
    if (_days.value() < 1)
    	throw new InvalidDateException(_days.value());

    int addDate = _receiver.getStore().getDate() + _days.value();
    _receiver.getStore().setDate(addDate);
  }
}
