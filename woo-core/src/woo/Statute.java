package woo;
import java.io.Serializable;


public class Statute implements Serializable{
	private boolean _normal;
	private boolean _selection;
	private boolean _elite;

	public Statute() {
		_normal = true;
		_selection = false;
		_elite = false;
	}

	@Override
	public String toString() {
		if(_normal)
			return "NORMAL";
		else if(_selection)
			return "SELECTION";
		
		return "ELITE";
	}
	
}