package stateandbehavior;

public class StopWatch {
    private int ticks; //a tick, or one millisecond (1 ms) here.
    private boolean beginTimer; //will start the stopwatch.
    private boolean endTimer; //will stop the stopwatch.
    private int lapTime; //stores number of ticks or ms for current lap.
    private int totalTicks; //is the total number of ticks (ms) ever "detected".
    private int sessionTime; //counts ticks from sw is started until sw is stopped.
    private int prevLapTime; //the number of ticks from previous lap.


    //Constructor
    public StopWatch() {
        // TODO Auto-generated constructor stub
        this.ticks = 0;
        this.beginTimer = false; //false until start() is called (and after stop() is called).
        this.endTimer = false; //false until stop() is called.
        this.lapTime = 0;
        this.totalTicks = 0;
        this.sessionTime = 0;
        this.prevLapTime = 0;
    }

    public boolean isStarted() { //Checks if the sw has been started.
        if (beginTimer == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStopped() { //Checks if the sw has been stopped.
        if (endTimer == true) {
            return true;
        } else {
            return false;
        }
    }

    public int getTicks() { //Returns total number of ticks detected (adds all ticks ever from tick(int ticks)).
        return totalTicks;
    }

    public int getTime() {
        if (!(isStarted())) { //If sw is not started, returns '-1'.
            return -1;
        } else {
            return sessionTime; //Else, returns ticks detected since sw is started (not affected by laps).
        }
    }

    public int getLapTime() {
        if (!(isStarted())) { //If sw is not started, returns '-1'.
            return -1;
        } else {
            return lapTime; //Else, returns ticks detected within current lap.
        }
    }

    public int getLastLapTime() {
        if (prevLapTime == 0) { //If no previous or "last lap" exists, return '-1'.
            return -1;
        } else {
            return prevLapTime; //Otherwise, return number of ticks from previous lap.
        }
    }


    public void tick(int ticks) { //The timer within the sw, counts "ticks" amount of ticks.
        this.ticks = ticks; //Not sure if this is necessary, don't remember.
        this.lapTime += ticks; //Add ticks to current lapTime.
        this.totalTicks += ticks; //Add ticks to total amount of ticks.
        if (! (isStopped())) { //Add ticks to current sessionTime, if the sw is active.
            this.sessionTime += ticks;
        }

    }

    public void start() { //Initiates sw.
        this.beginTimer = true; //confirmation that sw is started (for isStarted()).
        this.sessionTime=0; //Begin new session.
        this.lapTime = 0;  //Begin new lap.
    }

    public void stop() { //Stops sw.
        this.endTimer = true; //confirmation that sw is stopped (for isStopped()).
        ticks = 0; //resets number of ticks
        prevLapTime = lapTime; //stop() will also end and store current lap time.
        lapTime = 0; //resets lapTime.

    }

    public void lap() { //
        prevLapTime = lapTime; //stores the completed lap in "last lap" variable prevLapTime.
        lapTime = 0; //resets lapTime
        ticks = 0; //resets ticks
    }


    public static void main(String[] args) { //A selection of some debugging tools.
        StopWatch sw = new StopWatch();
        System.out.println("Ticks right now: " + sw.ticks); //should be '0'.
        sw.tick(3);
        System.out.println("Ticks after sw.tick(3): " + sw.ticks); //should be '3'.
        sw.start();
        System.out.println("Status after sw.start(): totalTicks: " + sw.totalTicks + ", sessionTime: " + sw.sessionTime + ", lapTime: " + sw.lapTime );
        System.out.println(sw.getTime());
        sw.tick(5);
        System.out.println("Status after sw.tick(5): totalTicks: " + sw.totalTicks + ", sessionTime: " + sw.sessionTime + ", lapTime: " + sw.lapTime );
        System.out.println(sw.getTime());
        sw.lap();
        System.out.println("Status after sw.lap(): totalTicks: " + sw.totalTicks + ", sessionTime: " + sw.sessionTime + ", lapTime: " + sw.lapTime );
        System.out.println(sw.getTime());
        sw.stop();
        System.out.println("Status after sw.stop(): totalTicks: " + sw.totalTicks + ", sessionTime: " + sw.sessionTime + ", lapTime: " + sw.lapTime );
    }

}
