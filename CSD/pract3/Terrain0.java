
/**
 * Native monitor based Terrain
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Terrain0 implements Terrain {
    Viewer v;
    public  Terrain0 (int t, int ants, int movs) {
        v=new Viewer(t,ants,movs,"0.- basic monitor");
        for (int i=0; i<ants; i++) new Ant(i,this,movs).start();
    }
    public synchronized void     hi      (int a) {v.hi(a);    }
    public synchronized void     bye     (int a) {v.bye(a);    }
    public synchronized void     move    (int a) throws InterruptedException {
        v.turn(a); Pos dest=v.dest(a); 
        while (v.occupied(dest)) {wait(); v.retry(a);}
        v.go(a); notifyAll();
    }
}