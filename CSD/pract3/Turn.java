
/**
 * Ant turns to a Dir
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Turn extends Op {
    public Dir d; 
    public Turn(int a, Dir d)     {super(a); this.d=d;}
    public String toString() {return super.toString()+" Turn "+d;}
}