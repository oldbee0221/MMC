package cheema.mirine.mymagic.pojo_classes;


public class KeylogPojo {

    public KeylogPojo(String key, String ans){
        this.key = key;
        this.ans = ans;
    }

    public String getKey() {
        return key;
    }

    public String getAns() {
        return ans;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    //variables
    private String key;
    private String ans;
}
