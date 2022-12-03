package java12;

public class RentTester {

    public static void main(String[] args) {
        showIntroduction();
        test();

    }

    private static void showIntroduction() {
        System.out.println("This is a tester for the Rent class in Maman 12");
        System.out.println("You are more than welcome to change it and redistribute your modifications");
        System.out.println("This tester is provided AS IS");
        System.out.println("It should not be used instead of the testers provided by the university");
        System.out.println("You must use the testers provided by the university");
        System.out.println("I don't take any responsibility for the grade you receive, whether you use this tester or not");
        System.out.println();
    }

    private static void logTest(String test) {
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Test: " + test);
    }
    private static void logError(String error) {
        System.out.println("Error occurred 😟😟😟. Here is the error: " + error + "\n");
    }

    private static void logSuccess() {
        System.out.println("Test passed! ☺☺☺ 🔥🔥🔥\n");
    }

    private static void logRentValues(Rent rent) {
        System.out.println("The values returned by the getters are: " +
                "\nName: " + rent.getName() +
                "\nPick Date:" + rent.getPickDate() +
                "\nReturn Date: " + rent.getReturnDate() +
                "\nCar: " + rent.getCar());
    }

    private static void testMainConstructor() {
        Car car = new Car(1234567, 'D', "Ford", true);
        Date pickDate = new Date(2, 2, 2000);
        Date returnDate = new Date(1, 2, 2000);
        Rent rent = new Rent("Yossi Gavni", car, pickDate, returnDate);
 
        logTest("Check if the main constructor notices the return date is before the pick date and sets the day after pick date as return date");
        if (rent.getReturnDate().getDay() == 3 && rent.getReturnDate().getMonth() == 2 && rent.getReturnDate().getYear() == 2000) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values");
            logRentValues(rent);
        }

        logTest("Check aliasing in main constructor");
        if (pickDate != rent.getPickDate()) {
            logSuccess();
        }
        else {
            logError("pickDate = rent.getPickDate(), you probably have aliasing in your main constructor");
        }
    }

    private static void testCopyConstructor() {
        Car car = new Car(9878741, 'C', "Honda", false);
        Date pickDate = new Date(26, 9, 1500);
        Date returnDate = new Date(5, 10, 1501);
        Rent rent = new Rent("Giora", car, pickDate, returnDate);
        Rent copiedRent = new Rent(rent);

        logTest("Checking if copy constructor correctly copies the values");

        Date copiedPickDate = copiedRent.getPickDate();
        Date copiedReturnDate = copiedRent.getReturnDate();
        Car copiedCar = copiedRent.getCar();

        if (copiedRent.getName().equals("Giora") && 
            copiedPickDate.getDay() == 26 && copiedPickDate.getMonth() == 9 && copiedPickDate.getYear() == 1500 &&
            copiedReturnDate.getDay() == 5 && copiedReturnDate.getMonth() == 10 && copiedReturnDate.getYear() == 1501 &&
            copiedCar.getId() == 9878741 && copiedCar.getType() == 'C' && !copiedCar.isManual() && copiedCar.getBrand().equals("Honda")) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values");
            logRentValues(rent);
        }

        logTest("Checking aliasing in copy constructor");
        if (copiedCar != rent.getCar() && copiedPickDate != rent.getPickDate() && copiedReturnDate != rent.getReturnDate()) {
            logSuccess();
        }
        else {
            logError("You have aliasing in your copy constructor");
        }
    }

    private static void testSetters() {
        Car car = new Car(1249491, 'A', "Hyundai", false);
        Date pick = new Date(4, 5, 6000);
        Date ret = new Date(4, 5, 6001);
        Rent rent = new Rent("Michael Yakson", car, pick, ret);

        logTest("Checking setters");
        rent.setName("Itzhak Malkieli");

        Car car1 = new Car(1249491, 'D', "Hyundai", true);
        rent.setCar(new Car(car1));

        if (rent.getName().equals("Itzhak Malkieli") && rent.getCar().isManual() && rent.getCar().getType() == 'D') {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values");
            logRentValues(rent);
        }

        logTest("Checking aliasing in setters");

        if (car1 != rent.getCar()) {
            logSuccess();
        }
        else {
            logError("You have aliasing in setCar");
        }
    }

    private static void testDiff() {
    	   Car car = new Car(1114442, 'D', "Maly", true);
           Date pick = new Date(1, 5, 2000);
           Date ret = new Date(5, 6, 2001);
           Rent rent = new Rent("Naomi", car, pick, ret);
           
           logTest("Checking the howManyDays method. It should return 400");
           if (ret.difference(pick) == 400) {
               logSuccess();
           }
           else {
               logError("Didn't get the correct amount of days between pick and return. Got: " + rent.howManyDays());
           }
           
    }
    
    

    private static void testGetPriceMethod() {
        Date pickDate = new Date(1, 5, 2010);
        Date returnDate = new Date(2, 9, 2011);
        Car car = new Car(1212121, 'B', "Ford", true);
        Rent rent = new Rent("Manny & Gloria", car, pickDate, returnDate);

        logTest("Checking if getPrice returns the correct price");
        if (rent.getPrice() == 66105) {
            logSuccess();
        }
        else {
            logError("Got " + rent.getPrice() + " Instead of " + 66105);
        }


        Date pickDate1 = new Date(29, 2, 2000);
        Date returnDate1 = new Date(3, 3, 2000);
        Car car1 = new Car(1000000, 'D', "Car", false);
        
        Rent rent1 = new Rent("Israel", car1, pickDate1, returnDate1);
        
        logTest("Checking if getPrice returns the correct price");
        if (rent1.getPrice() == 720) {
            logSuccess();
        }
        else {
            logError("Got " + rent1.getPrice() + " Instead of " + 720);
        }

        Date pickDate2 = new Date(19, 7, 5000);
        Date returnDate2 = new Date(26, 7, 5000);
        Car car2 = new Car(1119494, 'A', "Carly Bit Me", true);
        Rent rent2 = new Rent("Charles", car2, pickDate2, returnDate2);
        logTest("Checking if getPrice returns the correct price");
        if (rent2.getPrice() == 630) {
            logSuccess();
        }
        else {
            logError("Got " + rent2.getPrice() + " Instead of 630");
        }
    }

//    private static void testUpgradeMethod() {
//        Car car = new Car(1111111, 'B', "Fazda", true);
//        Date pick = new Date(1, 4, 2000);
//        Date ret = new Date(1, 4, 3000);
//        Rent rent = new Rent("Gadi", car, pick, ret);
//
//        logTest("Checking if the car is actually replaced when the new car is better. Checking if the correct price is returned. Assuming equals method in Car works properly");
//        Car betterCar = new Car(1112223, 'D', "Israel Cars", false);
//        int price = rent.upgrade(betterCar);
//
//        if (rent.getCar().equals(betterCar) && price == 29584629) {
//            logSuccess();
//        }
//
//        logTest("Checking aliasing in upgrade method");
//        if (betterCar != rent.getCar()) {
//            logSuccess();
//        }
//        else {
//            logError("You probably have aliasing in your upgrade method");
//        }
//    }
//
//    private static void testOverlapMethod() {
//        Date pickDate1 = new Date(1, 5, 3000);
//        Date returnDate1 = new Date(2, 6, 3000);
//        Car car1 = new Car(1112223, 'A', "Ford", true);
//        Rent rent1 = new Rent("Israel", car1, pickDate1, returnDate1);
//
//        Date pickDate2 = new Date(3, 4, 3000);
//        Date returnDate2 = new Date(1, 5, 3000);
//        Rent rent2 = new Rent("Israel", car1, pickDate2, returnDate2);
//
//        logTest("Checking overlap method and toString");
//        Rent rent3 = rent1.overlap(rent2);
//        if (rent3.toString().equals("Name:Israel From:03/04/3000 To:02/06/3000 Type:A Days:60 Price:5440")) {
//            logSuccess();
//        }
//        else {
//            logError("Didn't get the correct string. Got: " + rent3);
//        }
//    }

    private static void test() {
        testMainConstructor();
        testCopyConstructor();
        testSetters();
        testDiff();
        testGetPriceMethod();
//        testUpgradeMethod();
//        testOverlapMethod();
    }
}