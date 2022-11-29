package ex2india.com.pointofinterest.radius;

public class Radius {

    private int radiusMiles;
    private String title;

    public Radius(int radiusMiles, String title) {
        this.radiusMiles = radiusMiles;
        this.title = title;
    }

    public int getRadiusMiles() {
        return radiusMiles;
    }

    public void setRadiusMiles(int radiusMiles) {
        this.radiusMiles = radiusMiles;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
