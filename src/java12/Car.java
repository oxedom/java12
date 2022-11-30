package java12;

public class Car {

    // fields
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;



    // constructor
    Car(int id, char type, String brand, boolean isManual ) {
        this._id = id;
        this._type = type;
        this.set_brand(brand);
        this._isManual = isManual;
     
    }
    
    // methods
    void increaseSpeed() {
        System.out.println("Cock");
    }

	public String get_brand() {
		return _brand;
	}

	public void set_brand(String _brand) {
		this._brand = _brand;
	}
    
    // ...
}