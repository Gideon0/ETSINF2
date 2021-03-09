package pract2;

// CSD Mar 2013 Juansa Sendra

public class BothOrNoneTable extends RegularTable { //both or none
    public BothOrNoneTable(StateManager state) {
        super(state);
    }
    
    public synchronized void takeLR(int id) throws InterruptedException {
        while(!(state.leftFree(id) && state.rightFree(id))){
            state.wtakeLR(id);
            wait();
        }
        state.takeR(id);
        state.takeL(id);
    }
}
