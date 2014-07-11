package ben.kn.algorithms.data;

/**
 * This generic data is an extension of {@link Data}, containing a name,
 * intValue, and doubleValue.
 * 
 * @author Ben (bknear@gmail.com)
 * @since Feb 28, 2013
 */
public class GenericData extends Data {
	private String name;
	private int intValue;
	private double doubleValue;

	public GenericData() {
	}

	public GenericData(String name) {
		this.name = name;
	}

	public GenericData(int intValue) {
		this.intValue = intValue;
	}

	public GenericData(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public GenericData(String name, int intValue) {
		this.name = name;
		this.intValue = intValue;
	}

	public GenericData(String name, double doubleValue) {
		this.name = name;
		this.doubleValue = doubleValue;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(double doubleValue) {
		this.doubleValue = doubleValue;
	}

	@Override
	public String toString() {
		String s = "{";
		if ( name != null ) {
			s += name + ", ";
		}
		s += intValue + ", " + doubleValue + "}";
		return s;
	}

	@Override
	public String strValue() {
		return intValue + "";
	}
}
