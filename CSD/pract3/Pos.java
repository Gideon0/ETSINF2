
/**
 * 2d position
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Pos {
    public int x,y;
    public         Pos     (int x0,int y0){x=x0; y=y0;}
    public         Pos     (Pos p, Dir d) {this(p.x+d.x, p.y+d.y);}
    public boolean     eq (Pos p)         {return x==p.x && y==p.y;}
    public boolean     legal(int T)         {return x>=0 && y>=0 && x<T && y<T;}
        public String   toString()              {return "("+x+","+y+")";}
}