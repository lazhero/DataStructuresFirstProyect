package cr.ac.tec.Controls;

public class IntHolder {
    private int saved;
    public IntHolder(int saved){
        this.saved=saved;

    }

    public int getSaved() {
        return saved;
    }

    public void setSaved(int saved) {
        this.saved = saved;
    }
    public void lowSaved(int decrease){
        this.saved-=decrease;
    }
}
