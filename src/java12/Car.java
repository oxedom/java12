package java12;

public class Car {

    // fields
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;

    //Sam notes; Make sure that a user can't enter a int under 0 or overthose max numbers;
    //type of car rank must be A B C D If the type isn't one of those set default to A
    //MAKE SURE THAT BRAND ISNT NULL WHEN OBJECT IS CREATED 
    final String DEFAULT_TYPE = "A";
    final int MAX_ID = 9999999;
    

    // Main Constructor 
    Car(int id, char type, String brand, boolean isManual ) {
        this._id = id;
        this._type = type;
        this._brand = brand;
        this._isManual = isManual;
     
    }
    
    //Copy Constructor for Car;
    public Car(Car copyCar) {
    	this._id = copyCar._id;
    	this._type = copyCar._type;
    	this._brand = copyCar._brand;
    	this._isManual = copyCar._isManual;
    	
    }
    
    // methods
    //THINGS TO MAKE
    //getId, getType, getBrand, isManual
    //MAKE SURE THEY ARE FOOL PROOF NO BUGS TO BYPASS THEM;
    //Setters, setId setType setBrand setIsManual;
//    public String toString()
    //toString SHOULD RETURNA SOMETHING LIKE
//    id:1234567 type:A brand:Mazda gear:manual
//    id:8877665 type:D brand:Toyota gear:auto
//    id:9999999 type:B brand:Renault gear:manual
    	
    //OVERRIDE EQUALS METHOD TO CHECK IF TWO CARS HAVE THE SAME PROPS;
    
    void printBrand() {
        System.out.println(_brand);
    }

//	public String get_brand() {
//		return _brand;
//	}
//
//	public void set_brand(String _brand) {
//		this._brand = _brand;
//	}
    
    // ...
}