package Object;

/**
 *
 * @author minh
 */
public class ThongKe {
    private String tendausach;
    private int sosachmuon;
    private String madocgia;
    private float tienphat;

    public ThongKe() {
    }

    public ThongKe(String tendausach, int sosachmuon, String madocgia, float tienphat) {
        this.tendausach = tendausach;
        this.sosachmuon = sosachmuon;
        this.madocgia = madocgia;
        this.tienphat = tienphat;
    }

    public String getTendausach() {
        return tendausach;
    }

    public void setTendausach(String tendausach) {
        this.tendausach = tendausach;
    }

    public int getSosachmuon() {
        return sosachmuon;
    }

    public void setSosachmuon(int sosachmuon) {
        this.sosachmuon = sosachmuon;
    }

    public String getMadocgia() {
        return madocgia;
    }

    public void setMadocgia(String madocgia) {
        this.madocgia = madocgia;
    }

    public float getTienphat() {
        return tienphat;
    }

    public void setTienphat(float tienphat) {
        this.tienphat = tienphat;
    }

    

    
}
