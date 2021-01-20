package oving1;

public class stoppeklokke { //Lager en klasse kalt "stoppeklokke"
    private static int minutes; //Variabel som lagrer minutter for formattering
    private static int seconds; //Variabel som lagrer sekunder for formatterin
    private static int milliseconds; //Variabel som lagrer millis for formatterin

    private int ticks; //Lagrer ticks imellom intervaller
    private int prev_ticks; //Lagrer antall ticks for forrige måling
    private int session_ticks; //Lagrer ticks mellom start og stopp
    private int total_ticks; //Lagrer totalt antall ticks fra programmet startet

    private boolean run; //Boolsk variable som er true når man gjør en målingn teller
    private boolean start; //Boolsk variabel som er true når klokken starter

    public stoppeklokke() { //Samler og gir verdier til variablene, alle starter på 0 eller false
        ticks = 0;
        session_ticks = 0;
        total_ticks = 0;
        prev_ticks = 0;

        minutes = 0;
        seconds = 0;
        milliseconds = 0;

        run = false;
        start = false;
    }

    public String formatclock(int i){ //Funksjon som formatterer tiden i millisekunder til [minutter:sekunder:millisekunder]
        seconds = (i / 1000) % 60; //Finner antall sekunder og ekskluderer rest
        minutes = (i / (1000 * 60)) %60; //Finner antall minutter og ekskluderer rest
        milliseconds = i%1000; //Deler på 1000 for å finne ms

        return String.format("%02d:%02d.%d", minutes, seconds, milliseconds); //Bruker %-formattering for å gjøre det ryddig
    }
    public void tick(int t){
        ticks += t;
    } //Funksjon som tar antall ticks som parametervariabel

    public void start(){ //Starter klokken
        run = true;
        start = true;
        session_ticks = 0; //Resetter session-ticks
    }
    public void stop(){//Stopper klokken
        total_ticks+=ticks; //Legger til ticks mellom forrige lap og slutt
        prev_ticks = ticks; //Lagrer forrige runde som ticks før man stoppet målingen
        session_ticks += ticks; //Legger til ticks mellom siste måling og stopp til totalen for måletiden
        ticks=0; //Resetter ticks
        run=false; //Sier at målingen er over når du skriver stop();

    }
    public boolean isStarted(){
        return start==true;
    } //True hvis start(); er kalt og false ellers
    public boolean isStopped(){ //

        if(session_ticks==0) { //Unik scenario når du gir ticks som input og klokken ikke er startet
            return false;
        }
        else{
            return run==false; //Når klokken teller
        }
    }
    public void lap() { //Funksjon som gjør lager et nytt intervall
        prev_ticks = ticks; //Forrige antall ticks
        session_ticks += ticks; //Legger til i total for måleintervallet
        total_ticks += ticks; //Legger til total siden programmet ble kjørt
        ticks = 0; //Resetter nåværende ticks
    }
    public int getTicks(){
        return total_ticks+ticks;
    } //Returnerer antall tics fra forrige måling + nåværende

    public int getTime(){ //Returnerer antall ticks for måleperiode, false om klokken ikke er startet
        if (start==false){
            return -1;
        }
        else {
            return session_ticks + ticks;
        }
    }
    public int getLapTime(){ //Ticks for nåværende intervall
        if (start==false) {
            return -1;
        }
        else{return ticks;}
    }

    public int getLastLapTime(){ //Ticks for forrige intervall
        if (prev_ticks==0) {
            return -1;
        }
        else{return prev_ticks;}
        }

    public void stats(){ //Omgjør millisekunder tik et (mm:ss:ddd)-format
        System.out.println("Total time:"+formatclock(getTicks())+"\n"+"Session time: "+formatclock(getTime())+"\n"+"Current time: "+formatclock(ticks));
    }

    public static void main(String[] args) throws InterruptedException { //Det er her koden faktisk blir executed

        stoppeklokke sw = new stoppeklokke();

        sw.start();
        sw.tick(5);
        sw.lap();
        sw.tick(100);
        sw.lap();
        sw.tick(123);
        System.out.println(sw.getLapTime()); //Burde vise 123
        System.out.println(sw.getTime()); //Burde vise 5+100+123 = 228
        System.out.println(sw.getLastLapTime()); //Burde vise 100
        sw.stop();
        System.out.println(sw.getLapTime()); //Burde vise 0 siden stop();
        System.out.println(sw.getTime()); //Burde vise 228
        System.out.println(sw.getLastLapTime()); //Burde vise 123

    }

}
