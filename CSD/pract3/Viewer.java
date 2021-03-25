
/**
 * GUI
 * 
 * @author CSD Juansa Sendra 
 * @version 2021
 */
import java.awt.*;
import java.awt.font.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.concurrent.*;

public class Viewer extends Panel {
    final Font bold = new Font("Courier",Font.BOLD ,40);
    final Font plain= new Font("Times"  ,Font.PLAIN,16);
    Matrix m; 
    Op[] ops; int nOps=0;
    int idx=-1; //states-list selected index
    int T,A, retries=0, nev=0;
    List states; String msg, chN="0123456789";

    public Viewer(int cols, int ants, int movs, String msg) {
        T=cols; A=ants; m=new Matrix(T,A); ops= new Op[20*A]; 
        states=new List(4*T,false); this.msg=msg;
        states.setFont(new Font(Font.MONOSPACED,Font.PLAIN,12));
        JFrame window= new JFrame("CSD.- Ants "+String.format("%dx%d, %d ants, %d moves per ant",T,T,A,movs));
        Panel matrix = this; matrix.setBackground(Color.WHITE); matrix.setPreferredSize(new Dimension(10+50*(T+1),55*(T+1)));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new FlowLayout());
        window.getContentPane().add(matrix); window.getContentPane().add(states); 
        window.pack(); window.setVisible(true);
        states.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                idx = states.getSelectedIndex(); repaint();
            }
        });
    }
    void drawXrule(Graphics g) {for (int i=0; i<T; i++) drawLetter(g,chN.charAt(i)+"",0,i+1,false);}
    void drawYrule(Graphics g) {for (int i=0; i<T; i++) drawLetter(g,chN.charAt(i)+"",i+1,0,false);}
    void drawGrid (Graphics g) {
        for (int i=1; i<T+2; i++) {
            g.drawLine(50  , 30+i*50, (T+1)*50, 30+i*50); // horiz
            g.drawLine(i*50, 80     , i*50    , 30+(T+1)*50); // vert
        }
    }
    void drawLetter (Graphics g, String s, int x, int y, boolean red) {
        g.setFont(bold);
        if (red) g.setColor(Color.RED);
        g.drawString(s, 14+50*y, 66+50*x);
        if (red) g.setColor(Color.BLACK);
    }
    void drawDir(Graphics g, int x, int y, Dir d) {
        switch (d) {
        case N: g.fillOval(21+50*y,30+50*x,8,8); break;
        case W: g.fillOval(   50*y,51+50*x,8,8); break;
        case S: g.fillOval(21+50*y,72+50*x,8,8); break;
        case E: g.fillOval(42+50*y,51+50*x,8,8); break;
        }
    }
    void drawCell(Graphics g, int i, Pos p, Dir d) {
        if (p==null) {return;}
        String chA="ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
        g.setFont(bold);
        drawLetter(g, chA.charAt(i)+"", 1+p.x, 1+p.y, d!=null);
        if (d!=null) drawDir(g,1+p.x, 1+p.y,d);
    }
    public void paint(Graphics g) {
        g.setFont(plain); g.drawString(msg+"   "+retries+" retries",10,25);
        drawGrid(g); drawXrule(g); drawYrule(g);
        if (idx<0) return;
        Matrix mat= new Matrix(T,A);
        for (int i=0; i<=idx; i++) {
            Op op=ops[i];
            try {
            if (Class.forName("Hi"    ).isInstance(op)) {mat.opHi     (op.a,((Hi)op).p);}
            if (Class.forName("Bye"   ).isInstance(op)) {mat.opBye     (op.a);}
            if (Class.forName("Turn"  ).isInstance(op)) {mat.opTurn     (op.a,((Turn)op).d);}
            if (Class.forName("Go"    ).isInstance(op)) {mat.opGo     (op.a);}
            if (Class.forName("ChgDir").isInstance(op)) {mat.opChgDir(op.a,((ChgDir)op).d);}
            } catch (ClassNotFoundException e) {e.printStackTrace();}
        }    
        for (int i=0; i<A; i++) drawCell(g,i,mat.getPos(i),mat.getDir(i));
    }
    public void     hi       (int a) {Op o=new Hi(a,m.hi(a));             states.add(o+""); ops[nOps++]=o;}
    public void     bye      (int a) {Op o=new Bye(a);           m.bye(a); states.add(o+""); ops[nOps++]=o;}
    public void     turn     (int a) {Op o=new Turn(a,m.randDir(a));     states.add(o+""); ops[nOps++]=o;}
    public void     go       (int a) {Op o=new Go(a);           m.go(a);  states.add(o+""); ops[nOps++]=o;}
    public void     retry    (int a) {Op o=new Retry(a);       retries++;states.add(o+""); ops[nOps++]=o;}
    public void        chgDir    (int a) {Op o=new ChgDir(a,m.chgDir(a));     states.add(o+""); ops[nOps++]=o;}
    public Pos      dest     (int a) {return m.dest(a);}
    public Pos        getPos    (int a) {return m.getPos(a);}
    public boolean     occupied(Pos p) {return m.occupied(p);}
}
