// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    private int instructors = 0;
    private int kids = 0;
    private int maxKids;
    
    public void init(int ki, int cap){
        maxKids = ki;
    }
    
    public synchronized void kidSwims() throws InterruptedException{
        while(instructors == 0 || (kids + 1) > (maxKids * instructors)){
            log.waitingToSwim();
            wait();
        }
        kids++;
        log.swimming();
    }
    
    public synchronized void kidRests(){
        kids--;
        log.resting();
        notifyAll();
    }
    
    public synchronized void instructorSwims(){
        instructors++;
        log.swimming();
        notifyAll();
    }
    
    public void instructorRests() throws InterruptedException{
        while(kids > 0 && instructors == 1 || ((instructors - 1) * maxKids) < kids){
            log.waitingToRest();
            wait();
        }
        instructors--;
        log.resting(); 
        notifyAll();
    }
}
