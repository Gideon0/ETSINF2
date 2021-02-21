// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool {   //no kids alone
    private int instructors = 0;
    private int kids = 0;
    public void init(int ki, int cap){}
    
    public synchronized void kidSwims() throws InterruptedException {
        while(instructors <= 0){
            log.waitingToSwim();
            wait();
        }
        kids++;
        log.swimming();
    }
    
    public synchronized void kidRests(){
        log.resting();
        kids--;
        notifyAll();
    }
    
    public synchronized void instructorSwims(){
        log.swimming();
        instructors++;
        notifyAll();
    }
    
    public synchronized void instructorRests() throws InterruptedException {
        while(instructors == 1 && kids > 0){
            log.waitingToRest();
            wait();
        }
        instructors--;
        log.resting();
    }
}
