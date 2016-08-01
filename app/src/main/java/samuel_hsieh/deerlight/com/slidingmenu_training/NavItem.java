package samuel_hsieh.deerlight.com.slidingmenu_training;

/**
 * Created by samuel_hsieh on 15/9/22.
 */
public class NavItem {

    private String title;
    private String subtitle;
    private int resIcon;
    String color;

    public NavItem(String title, String subtitle, int resIcon , String color) {
        this.title = title;
        this.subtitle = subtitle;
        this.resIcon = resIcon;
        this.color = color;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public int getResIcon() {
        return resIcon;
    }

    public String getColor() {
        return color;
    }

}
