
/**
 * Direction of movement
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public enum Dir {
    N(-1,0),W(0,-1),S(1,0),E(0,1);
    public int x,y;
    private Dir(int ix, int iy) {x=ix; y=iy;}
    public String toString() {return this==N?"North": this==S?"South": this==E?"East":"West";}
}