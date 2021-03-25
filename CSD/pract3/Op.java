
/**
 * Base class for simulation ops
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Op {
    String ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public int a; 
    public Op(int a) {this.a=a;}
    public String toString() {return ""+ch.charAt(a);}
}