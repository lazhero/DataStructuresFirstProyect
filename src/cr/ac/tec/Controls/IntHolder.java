package cr.ac.tec.Controls;

public class IntHolder {
    private int saved;

    /**
     *
     * @param saved
     */
    public IntHolder(int saved){
        this.saved=saved;
    }

    /**
     *
     * @return
     */
    public int getSaved() {
        return saved;
    }

    /**
     *
     * @param saved
     */
    public void setSaved(int saved) {
        this.saved = saved;
    }

    /**
     *
     * @param decrease
     */
    public void lowSaved(int decrease){
        this.saved-=decrease;
    }
}
