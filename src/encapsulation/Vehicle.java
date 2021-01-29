package encapsulation;

import java.util.*; //Import all the util-modules
import java.lang.*; //Import all the lang-modules

public class Vehicle { //Create a class called vehicles
    private char vehicleType, fuel; //Accepted values vehicle: M, C. Accepted values fuel: H, E, D, G
    private String reg; //EL||EK for electric, HY for hydrogen, XX except EL,EK,HY. Motorcycles have 4 chars and cars 5 chars
    private String instructions = """

            -------------- Parameters --------------
            Vehicle: Enter C for car and M for motorcycle
            Fuel: H for Hydrogen, E for electricity
             D for Diesel and G for Gasoline
            Reg: EL or EK for electric cars, HY for hydrogen
            XX where X∈[A to Z] => !(Æ,Ø,Å)
            Motorcycles has XX1234 and Cars has XX12345
             where 12345 are arbitrary integers between 0-9""";

    private boolean checkVehicle(char v) { //Validates the vehicle type
        String vehicleStr = Character.toString(v);
        if ((vehicleStr.startsWith("C") || vehicleStr.startsWith("M")) && Character.toString(v).length() == 1){ //Checks if the character is either C or M using RegEx and 1 in length
            return true;
        }
        else{
            throw new IllegalArgumentException("Invalid vehicle-type");
        }
    }

    private boolean checkFuel(char f) { //Validates the fuel-type
        if (Character.toString(f).matches("[DEGH]") && Character.toString(f).length() == 1){ //Checks if the character is either D, E, G or H using RegEx and 1 in length
            return true;
        }
        else{
            throw new IllegalArgumentException("Invalid fuel-type");
        }
    }


    private boolean checkReg(String r, char v) { //validates the registration number
        String firstTwo = r.substring(0,2);
        String numbers = r.substring(2);
        String vehicleType = Character.toString(v);
        String firstReg = r.substring(0,1);
        String secondReg = r.substring(1,2);

        if (vehicleType.equals("M") && firstReg.equals("H") && secondReg.equals("Y")){
            return false;
        }

        if (firstTwo.matches("[A-Z]+") && numbers.matches("[0-9]+") &&
                ((r.length() == 6 && vehicleType.equals("M")) ||
                        ((r.length() == 7) && vehicleType.equals("C")))){
            return true;
        }
        else {
            throw new IllegalArgumentException("Invalid registration number");
        }
    }

    private boolean checkCombination(char v, char f, String r) {
        String firstReg = r.substring(0,1);
        String secondReg = r.substring(1);
        String fueltype = Character.toString(f);

        //Sjekker El-biler
        if ((firstReg.startsWith("E") && (secondReg.startsWith("L")) || secondReg.startsWith("K"))){ //|| (firstReg.startsWith("H") && secondReg.startsWith("Y")){
            return fueltype.equals("E");
        }
        //Sjekker hydrogenbiler
        else if (firstReg.startsWith("H") && secondReg.startsWith("Y") && Character.toString(v).equals("C")){
            return fueltype.equals("H");
        }
        //Sjekker vanlige biler
        else if(!(firstReg.startsWith("E") && (secondReg.startsWith("L") || secondReg.startsWith("K")) || (firstReg.startsWith("H") && secondReg.startsWith("Y")))){
            return fueltype.matches("[DG]");
        }
        return false;
    }


    //Illegalargument i boolaen for å sjekke om biltype reg stemmer


    public Vehicle(char v, char f, String r) {
        if (checkVehicle(v) && checkFuel(f) && checkReg(r, v)) { //Må sjekkes med studass
            if (checkCombination(v, f ,r)){
                this.vehicleType = v;
                this.fuel = f;
                this.reg = r;
            }
            else{
                throw new IllegalArgumentException("An error occured while trying to set your values");
            }
        }
        else {
            throw new IllegalArgumentException("Ugyldige parametere, les instruksjoner");
        }
    }



    public char getFuelType() {
        return this.fuel;
    }

    public char getVehicleType() {
        return this.vehicleType;
    }

    public String getRegistrationNumber() {
        return this.reg;
    }

    public void setRegistrationNumber(String reg) {
        if(checkReg(reg, vehicleType)) {
            if (checkCombination(vehicleType, fuel, reg)) {
                this.reg = reg;
            }
            else{
                throw new IllegalArgumentException("This vehicle is ducked");
            }
        }
        else{
            throw new IllegalArgumentException("Error; Invalid registration number");
        }
    }




}
