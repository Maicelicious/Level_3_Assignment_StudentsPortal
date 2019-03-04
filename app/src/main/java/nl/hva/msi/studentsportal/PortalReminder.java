package nl.hva.msi.studentsportal;

public class PortalReminder {

    private String mTitle;
    private String mUrl;

    public PortalReminder(String mTitle, String mUrl) {
        this.mTitle = mTitle;
        this.mUrl = mUrl;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public void setmUrl(String mUrl) {
        this.mUrl = mUrl;
    }
}
