package ben.kn.algorithms.data;

/**
 * This object refers to an object of data.
 * 
 * @author Ben (bknear@gmail.com)
 * @since Feb 28, 2013
 */
public abstract class Data {

	public abstract int getIntValue();

	public abstract String strValue();

	public boolean equals(Data d) {
		if ( d.getIntValue() == getIntValue() ) {
			return true;
		} else {
			return false;
		}
	}

}
