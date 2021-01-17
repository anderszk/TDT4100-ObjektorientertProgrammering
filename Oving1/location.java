package oving1;


import java.util.Arrays; //importerer bibliotek for å kunne behandle arrays i koden

public class location //Lager en class som heter "location"
{
    //Variabler, "public" har samme funksjon som "global" i python, definerer scoopet til globalt
    private static int xCoor; //Integer-variabel som lagrer verdien for x-koordinatet
    private static int yCoor; //Integer-variabel som lagrer verdien for y-koordinatet

    public location(){ //Variabler som skal brukes i funksjonene under
        xCoor = 0; //Som inneholder x-verdien
        yCoor = 0; //og y-verdien
    }

    static void up() { //Funksjon for å bevege seg opp
        yCoor --; //som tilsvarer mindre y-verdi
    }
    static void down() { //Funksjon for å bevege seg ned
        yCoor++; //som tilsvarer større y-verdi
    }
    static void left() { //Funksjon for å bevege seg mot venstre
        xCoor--; //som tilsvarer mindre x-verdi
    }
    static void right() { //Funksjon for å bevege seg opp
        xCoor++; //som tilsvarer større x-verdi
    }
    static void getX() {  //Funksjon for å printe x-verdien i tallverdi, dette fordi funksjonene over ikke faktisk viser noe til bruker
        System.out.println("The current x-position is: "+xCoor+"\n"); //Bruker System.out.println for å printe +newline
    }
    static void getY() { //Funksjon for å printe y-verdi
        System.out.println("The current y-position is: "+yCoor+"\n"); //Bruker System.out.println for å printe +newline
    }
    static void coordinates() { //Funksjon for å reformatere verdiene til koordinater
        int[] print_coordinates = {xCoor,yCoor}; //Array som inneholden x-verdien og y-verdien
        System.out.println("In coordinates: "+ Arrays.toString(print_coordinates)); //Printer ut arrayen i konsollen
    }

    public static void main(String[] args) { //Det er her koden faktisk blir executed

        location position = new location(); //Lager et objekt med "new"
        position.up();
        position.down();
        position.up();
        position.up();
        position.right();
        position.left();
        position.right();
        position.right();

        position.getX(); //Printer x-verdien i konsollen
        position.getY(); //Printer y-verdien i konsollen
        coordinates(); //Printer x-verdien og y-verdien på koordinatform

    }

}