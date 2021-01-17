package oving1;

public class stoppeklokke {
    private static int minutes;
    private static int seconds;
    private static int milliseconds;

    private int ticks;
    private int prev_ticks;
    private int session_ticks;
    private int total_ticks;

    private boolean run; //Boolsk variable som er true når stoppeklokken teller
    private boolean start;

    public stoppeklokke() {
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
        seconds = (i / 1000) % 60;
        minutes = (i / (1000 * 60)) %60;
        milliseconds = i%1000;

        return String.format("%02d:%02d.%d", minutes, seconds, milliseconds); //Bruker %-formattering for å gjøre det ryffig
    }
    public void tick(int t){
        ticks += t;
    }
    public void start(){
        run = true;
        start = true;
        session_ticks = 0;
    }
    public void stop(){
        total_ticks+=ticks;
        prev_ticks = ticks;
        session_ticks += ticks;
        ticks=0;
        run=false;

    }
    public boolean isStarted(){
        return run==true;
    }
    public boolean isStopped(){
        if(session_ticks==0) {
            return false;
        }
        else{
            return run==false;
        }
    }
    public void lap() {
        prev_ticks = ticks;
        session_ticks += ticks;
        total_ticks += ticks;
        ticks = 0;
    }
    public int getTicks(){
        return total_ticks+ticks;
    }

    public int getTime(){
        if (start==false){
            return -1;
        }
        else {
            return session_ticks + ticks;
        }
    }
    public int getLapTime(){
        return ticks;
    }

    public int getLastLapTime(){
        return prev_ticks;
    }

    public void stats(){
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
