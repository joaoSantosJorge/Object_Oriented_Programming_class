package woo.app.main;

import pt.tecnico.po.ui.Command;
import pt.tecnico.po.ui.DialogException;
import pt.tecnico.po.ui.Input;
import woo.Storefront;

import java.io.IOException;
import woo.exceptions.*;


/**
 * Save current state to file under current name (if unnamed, query for name).
 */
public class DoSave extends Command<Storefront> {

  private Input<String> _filename;

  /** @param receiver */
  public DoSave(Storefront receiver) {
    super(Label.SAVE, receiver);
    _filename = _form.addStringInput(Message.newSaveAs());
  }

  /** @see pt.tecnico.po.ui.Command#execute() */
  @Override
  public final void execute() {

    try {
      if (!_receiver.getSave())
        if (_receiver.getFilename().equals("")) {
          //Input
          _form.parse();
          //nome do ficheiro -> valor lido input
          _receiver.saveAs(_filename.value());
        }

    
    _receiver.save();
    }
    catch(MissingFileAssociationException |ImportFileException | IOException e) {  e.printStackTrace();  }
  }

}
