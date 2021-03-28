
/**
 * Application entry point
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Ants
{
     static int readArg(String[] args, int i, int def, int min, int max) {
        if (i>=args.length) return def;
        int r = Integer.parseInt(args[i]); return r<min? min: r>max? max: r;
    }
    /* ARGUMENTS
     * type of Terrain (0..3, default 0)
         *   Terrain0: native monitor
         *   Terrain1: general monitor, 1 general condition
         *   Terrain2: general monitor, one condition per cell
         *   Terrain3: general monitor, one condition per cell, no deadlock
         * Size of terrain (side 6..10, default 8)
         * Number of ants  (10..26, default 15)
         * Number of moves per ant (2..5, default 3)
     */  
    public static void main(String[] args) throws InterruptedException {
        int type=readArg(args,0,0,0,3);
        int T = readArg(args,1, 8, 6,10);
        int A = readArg(args,2,15,10,26);
        int M = readArg(args,3, 3, 2, 5);
        switch (type) {
        case 0: new Terrain0(T,A,M); break;
        case 1: new Terrain1(T,A,M); break; // must be Terrain1 TO BE IMPLEMENTED
        case 2: new Terrain2(T,A,M); break; // must be Terrain2 TO BE IMPLEMENTED
        case 3: new Terrain3(T,A,M);        // must be Terrain3 TO BE IMPLEMENTED
        }
    }
}
