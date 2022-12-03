
public class Main {

    public static void main(String[] args) {
        showIntroduction();
        test();

    }

    private static void showIntroduction() {
        System.out.println("This is a tester for the Car  class in Maman 12");
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
        System.out.println("Error occurred. Here is the error: " + error + "\n");
    }

    private static void logSuccess() {
        System.out.println("Test passed!\n");
    }

    private static void logCarValues(Car car) {
        System.out.println("The values returned by the getters are: " +
                "\nId:" + car.getId() +
                "\nType:" + car.getType() +
                "\nBrand: " + car.getBrand() +
                "\nisManual" + car.isManual());
    }

    private static void logCarValues(Car car, String carName) {
        System.out.println("The values returned by the getters of" + carName + "are: " +
                "\nId:" + car.getId() +
                "\nType:" + car.getType() +
                "\nBrand: " + car.getBrand() +
                "\nisManual" + car.isManual());
        System.out.println();
    }

    private static void testMainConstructor() {
        Car car = new Car(9814241, 'A', "Ford", false);

        logTest("Check if constructor correctly constructs the object");
        if (car.getId() == 9814241 && car.getType() == 'A' && car.getBrand().equals("Ford") && !car.isManual()) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values, probably a problem with the constructors or the getters");
            logCarValues(car);
        }

        Car carly = new Car(98, 'B', "Mekhoniot Yafot Inc.", true);
        logTest("Check if the constructor notices the id is not valid and changes it accordingly");
        if (carly.getId() == 9999999 && carly.getType() == 'B' && carly.getBrand().equals("Mekhoniot Yafot Inc.") && carly.isManual()) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values, probably a problem with the constructors, getters, or validation");
            logCarValues(carly);
        }
    }

    private static void testCopyConstructor() {
        Car car = new Car(1234567, 'D', "Toyota", false);
        Car copiedCar = new Car(car);

        logTest("Check if the copy constructor correctly copies the values");
        if (copiedCar.getId() == 1234567 && copiedCar.getType() == 'D' && copiedCar.getBrand().equals("Toyota") && !copiedCar.isManual()) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values, probably a problem with constructor, copy constructor or getters, copied car:");
            logCarValues(copiedCar);
        }
    }

    private static void testSetters() {
        Car car = new Car(1253123, 'D', "Mazda", false);

        logTest("Test if setters correctly change the values");
        car.setBrand("Ferrari");
        car.setId(1201201);

        if (car.getId() == 1201201 && car.getBrand().equals("Ferrari")) {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values");
            logCarValues(car);
        }

        Car carly = new Car(1241251, 'C', "Ford", true);

        logTest("Check if setType will change the type even though the new car won't be valid. trying to set the type to M");
        carly.setType('M');

        if (carly.getId() == 1241251 && carly.getBrand().equals("Ford") && carly.isManual() && carly.getType() == 'C') {
            logSuccess();
        }
        else {
            logError("Didn't get the correct values, probably problem with getters, setters, or constructor");
            logCarValues(carly);
        }

    }

    private static void testEqualsMethod() {
        Car car1 = new Car(1231231, 'D', "Ford", false);
        Car car2 = new Car(2121324, 'D', "Ford", false);

        logTest("Checking if equals method correctly ignores the id and compares all the other values");
        if (car1.equals(car2)) {
            logSuccess();
        }
        else {
            logError("Returned false, even though the two cars are equal");
            logCarValues(car1, "car1");
            logCarValues(car2, "car2");
        }
    }

    private static void testBetterMethod() {
        Car badCar = new Car(9994440, 'D', "Tesla", true);
        Car goodCar = new Car(1111112, 'D', "Tesla", false);

        logTest("Check if goodCar is better than badCar even though they have the same type (goodCar is not manual while badCar is)");
        if (goodCar.better(badCar)) {
            logSuccess();
        }
        else {
            logError("Returned false even though goodCar is better than badCar");
        }
    }

    private static void testWorseMethod() {
        Car badCar = new Car(1212888, 'A', "Epsilon", false);
        Car goodCar = new Car(1233333, 'C', "Epsilon", false);

        logTest("Check if badCar.worse(goodCar) returns true. the type of badCar is A and the type of goodCar is C. Both are not manual");
        if (badCar.worse(goodCar)) {
            logSuccess();
        }
        else {
            logError("Returned true even though badCar is worse than goodCar");
        }
    }

    private static void testToStringMethod() {
        Car car = new Car(1928751, 'D', "Mazda", false);

        logTest("Checking if toString returns the details in the correct format");
        if (car.toString().equals("id:1928751 type:D brand:Mazda gear:auto")) {
            logSuccess();
        }
        else {
            logError("Returned the string: \n" +
                    car.toString());
        }

        Car carly = new Car(1, 'A', "American Cars", true);
        logTest("Checking if toString returns the details in the correct format");
        if (carly.toString().equals("id:9999999 type:A brand:American Cars gear:manual")) {
            logSuccess();
        }
        else {
            logError("Returned he string: \n" +
                    carly.toString());
        }
    }
    
}

    private static void test() {
        testMainConstructor();
        testCopyConstructor();
        testSetters();
        testEqualsMethod();
        testBetterMethod();
        testWorseMethod();
        testToStringMethod();
    }
}