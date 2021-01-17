package oving1;

//Lage liste med rundetider
//Siste lap

public class stopwatchreal {
    /*Variabler, "public" har samme funksjon som "global" i python, definerer scoopet til globalt.
      Bruker long fordi millis() er et såpass stort tall. */

    private static long time_start; //Long-variabel for tiden stoppeklokken startet
    private static long time_stop; //Long-varuabel for sluttid

    private static long current_millis; //Variabel for antall ticks klokken har kjørt
    private static long last_lap; //Lagrer verdien til siste lap som ble målt
    private static long current_lap;

    private static long minutes;
    private static long seconds;
    private static long milliseconds;

    private boolean run; //Boolsk variable som er true når stoppeklokken teller


    public stopwatchreal() {
        time_start = 0;
        time_stop = 0;

        current_millis = System.currentTimeMillis();

        last_lap = 0;
        current_lap = 0;

        minutes = 0;
        seconds = 0;
        milliseconds = 0;

        run = false;
    }


    //Dette er funksjonene som starter og stopper stoppeklokken

    public void start() { //Bruker en void-funksjon til dette grunnet ingen returns
        time_start = System.currentTimeMillis(); //Setter variablen time_start til millis og bruker dette som 0-refereanse
        run = true; //Setter denne til true som vil si at den nå tar tiden
        System.out.println("Time started!"); //Printer i konsollen at tidtakingen har startet;
    }

    public void stop() { //Bruker en void-funksjon til dette grunnet ingen returns
        time_stop = System.currentTimeMillis()-time_start; //setter sluttiden lik millis tid minus 0-referansen.
        run = false; //Setter run til false som betyr at vi nå ikke tar ikke tiden
        System.out.println("Time stopped!"); //Printer i konsollen at tidtakingen har sluttet
        time_start = 0;
        //Må printe siste laptime
        run = false;
        System.out.println("Total time: "+formatclock(time_stop));
    }

    public void lap() { //Funksjon som avslutter nåværende runde og starter ny.
        current_lap = System.currentTimeMillis()-time_start; //Denne holder på den totale tiden fra start.
        last_lap = current_lap - last_lap; //Lagrer laptiden til senere bruk, MERK: lagrer kun siste.
        //Viktig å merke seg at den bruker siste lagrede verdi til å anskaffe en ny verdi.

        System.out.println("New lap! Lap time: "+formatclock(last_lap));

    }

   public String formatclock(long i){ //Funksjon som formatterer tiden i millisekunder til [minutter:sekunder:millisekunder]
       seconds = (i / 1000) % 60;
       minutes = (i / (1000 * 60)) %60;
       milliseconds = i%1000;

       return String.format("%02d:%02d.%d", minutes, seconds, milliseconds); //Bruker %-formattering for å gjøre det ryffig
   }

    public long getLastLapTime(){
        if (run = false){
            int nolap = -1;
            return (nolap);
        }
        return last_lap;
    }

    public long getTicks() {
        return current_millis; //Antall ticks fra millis ble startet.
    }

    /*public long getLapTime() {
        long laptime = time_start-System.currentTimeMillis();
        return laptime;
    }

    public long getTime() {

    }

     */


    //Dette kunne forkortes til bare en funksjon, men siden oppgaven spurte om det:
    public boolean isStarted(){
       return run==true;
    }

    public boolean isStopped(){
        return run==false;
    }


    public static void main(String[] args) throws InterruptedException { //Det er her koden faktisk blir executed

        stopwatchreal sw = new stopwatchreal();
        sw.start();
        Thread.sleep(2000);
        sw.lap();
        System.out.println(sw.isStarted());
        Thread.sleep(1500);
        sw.lap();
        Thread.sleep(3500);
        System.out.println(sw.isStopped());

    }

    }



