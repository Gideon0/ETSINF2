// CSD feb 2013 Juansa Sendra

public class Pool4 extends Pool { //kids cannot enter if there are instructors waiting to exit
    private int instructors = 0;
    private int kids = 0;
    private int maxKids;
    private int maxCap;
    private int nadadores = 0;
    private int esperando = 0;
    
    public void init(int ki, int cap){
        maxKids = ki;
        maxCap = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException{
        while(instructors == 0 || (kids + 1) > (maxKids * instructors) || nadadores >= maxCap || esperando > 0){
            log.waitingToSwim();
            wait();
        }
        kids++;
        log.swimming();
        nadadores++;
    }
    
    public synchronized void kidRests(){
        kids--;
        nadadores--;
        log.resting();
        notifyAll();
    }
    
    public synchronized void instructorSwims()throws InterruptedException{
        while(nadadores >= maxCap){
            log.waitingToSwim();
            wait();
        }
        instructors++;
        nadadores++;
        log.swimming();
        notifyAll();
    }
    
    public synchronized void instructorRests() throws InterruptedException{
        while(kids > 0 && instructors == 1 || ((instructors - 1) * maxKids) < kids){
            esperando++;
            log.waitingToRest();
            wait();
            esperando--;
        }
        instructors--;
        nadadores--;
        log.resting(); 
        notifyAll();
    }
}
