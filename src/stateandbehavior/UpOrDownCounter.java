package stateandbehavior; //Ligger i samme pakke som de andre oppgavene

public class UpOrDownCounter {  //Lager class
    private int end; //Variabel for sluttverdi
    private int counter; //Variabel for startverdi

    public UpOrDownCounter(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException("Startvalue == endvalue, please change one of them");
        }
        this.counter = start; //Setter start som counter med "this"
        this.end = end; //Setter end som end med "this" (inngangsparametere)
    }

    public int getCounter() { //Funksjon som returnerer telleren
        return counter; //Return-funksjon
    }

    public boolean count() {
        if (!(counter == end)) {//Hvis ikke telleren er lik sluttverdien, tell
            if (counter < end) { //Hvis startverdi er lavere en sluttverdi ++
                counter += 1;
            } else { //Hvis startverdi er høyere enn sluttverdi --
                counter -= 1;
            }
        }
        return (!(counter == end)); //Returnerer i tillegg en boolsk variabel som viser true eller false avhengig av retning
    }
}