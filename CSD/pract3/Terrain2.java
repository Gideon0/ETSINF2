
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Utilizando las herramientas ReentrantLocky Condition proporcionadas en java.util.concurrent, desarrolle Terrain1.
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Terrain2 implements Terrain {
    Viewer v;
    ReentrantLock lock = new ReentrantLock();
    Condition[][] c;

    public  Terrain2 (int t, int ants, int movs) {
        v=new Viewer(t,ants,movs,"2.- ReentrantLock and ConditionArray");
        for (int i=0; i<ants; i++) new Ant(i,this,movs).start();
        c = new Condition[t][t];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                 c[i][j] = lock.newCondition();
            }
        }
    }

    public void     hi      (int a) {
        lock.lock();
        try{
            v.hi(a); 
        }finally{lock.unlock();}
    }

    public void     bye     (int a) {
        lock.lock();
        try{
            v.bye(a);
        }finally{lock.unlock();}
    }

    public void     move    (int a) throws InterruptedException {
        lock.lock();
        try {
            v.turn(a); Pos dest=v.dest(a);
            int getX = dest.x;
            int getY = dest.y; 
            int x = v.getPos(a).x;
            int y = v.getPos(a).y;
            while (v.occupied(dest)) {c[getX][getY].await(); v.retry(a);}
            v.go(a); 
            c[x][y].signal();
        }finally{lock.unlock();}
    }
}
