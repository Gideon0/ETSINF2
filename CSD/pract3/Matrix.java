
/**
 * State of cells and Ants
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
import java.util.concurrent.*;

public class Matrix {
    private int T,A;
    private Pos[] pos; 
    private Dir[] dir;
    public Matrix(int t, int a) {T=t; A=a; pos = new Pos[A]; dir = new Dir[A];}
    int        rand        (int max) {return ThreadLocalRandom.current().nextInt(max);}
    Pos     freeCell    () {
        int x,y;
        do {x=rand(T); y=rand(T);} while(!isFree(new Pos(x,y)));
        return new Pos(x,y);
    }
    public boolean isFree (Pos p) {
        if (!p.legal(T)) return false;
        for (int i=0; i<A; i++) if (pos[i]!=null && pos[i].eq(p)) return false;
        return true;
    }
    public boolean occupied  (Pos p) {return !isFree(p);}
    public Dir       randDir(int a) { 
        do {turn(a,Dir.values()[rand(4)]);} while(!dest(a).legal(T));
        return dir[a];
    }
    public Dir     freeDir(int a) {
        for (int i=0; i<4; i++) {
            turn(a,Dir.values()[i]); if (isFree(dest(a))) break;
        }
        return dir[a];
    }
    public void turn    (int a, Dir d)     {dir[a]=d;}
    public void go        (int a)            {pos[a]=new Pos(pos[a],dir[a]); dir[a]=null;}
    public Pos  getPos    (int a)            {return pos[a];}
    public Dir  getDir    (int a)            {return dir[a];}
    public Pos  dest    (int a)            {return new Pos(pos[a],dir[a]);}
    public Pos  hi        (int a)          {Pos p=freeCell(); dir[a]=null; pos[a]=p; return p;}
    public void bye        (int a)            {dir[a]=null; pos[a]=null;}
    public Dir    chgDir    (int a)            {Dir d=freeDir(a); dir[a]=d; return d;}
    
    public void opHi    (int a, Pos p)    {pos[a]=p; dir[a]=null;}
    public void opTurn    (int a, Dir d)     {          dir[a]=d;   }
    public void opBye    (int a)            {pos[a]=null; dir[a]=null;}
    public void opGo    (int a)            {pos[a]=new Pos(pos[a],dir[a]); dir[a]=null;}
    public void opChgDir(int a, Dir d)    {dir[a]=d;}
}
