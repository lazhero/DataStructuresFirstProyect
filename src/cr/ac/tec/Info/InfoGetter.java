package cr.ac.tec.Info;

public class InfoGetter {
    private static InfoGetter instance;
    private Info info;
    private InfoGetter(){

    }
    public static InfoGetter getInstance(){
        synchronized (InfoGetter.class){
            if(instance==null){
                instance=new InfoGetter();
            }
        }

        return instance;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }
}
