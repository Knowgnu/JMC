package TypeF;

public class Review2 {


    private String sKeyword1;
    private String sKeyword2;
    private String sKeyword3;
    private int sCode2;

    public String getsKeyword1() {
        return sKeyword1;
    }

    public void setsKeyword1(String sKeyword1) {
        this.sKeyword1 = sKeyword1;
    }

    public String getsKeyword2() {
        return sKeyword2;
    }

    public void setsKeyword2(String sKeyword2) {
        this.sKeyword2 = sKeyword2;
    }

    public String getsKeyword3() {
        return sKeyword3;
    }

    public void setsKeyword3(String sKeyword3) {
        this.sKeyword3 = sKeyword3;
    }

    public int getsCode2() {
        return sCode2;
    }

    public void setsCode2(int sCode2) {
        this.sCode2 = sCode2;
    }

    @Override
    public String toString() {
        return "Review2{" +
                "sKeyword1='" + sKeyword1 + '\'' +
                ", sKeyword2='" + sKeyword2 + '\'' +
                ", sKeyword3='" + sKeyword3 + '\'' +
                ", sCode2=" + sCode2 +
                '}';
    }
}
