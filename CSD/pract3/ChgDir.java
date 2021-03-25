
/**
 * Ant changes Dir because destination is not empty
 * 
 * @author CSD Juansa Sendra 
 * @version 2021
 */
public class ChgDir extends Op {
    public Dir d; 
    public ChgDir(int a, Dir d) {super(a); this.d=d;}
    public String toString() {return super.toString()+" ChgDir "+d;}
}