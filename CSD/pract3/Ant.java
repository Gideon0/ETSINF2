
/**
 * Write a description of class Ant here.
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
import java.util.concurrent.*;

public class Ant extends Thread {
    int id, movs; Terrain t;
    public Ant(int a, Terrain t, int movs) {id=a; this.t=t; this.movs=movs;}
    void delay() throws InterruptedException {
        sleep(20+ThreadLocalRandom.current().nextInt(100));
    }
    public void run() {
      try {
        t.hi(id); delay();
        while (movs>0) {movs--; t.move(id); delay();} 
        t.bye(id);
      } catch (InterruptedException e) {e.printStackTrace();}
    }
}