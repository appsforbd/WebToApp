package com.shazal.webview.app.model;

public class PageItem {
    private String pageLink;
    private int pageIcon;
    private String pageID;
    private String pageTitle;

    public PageItem(final String pageID, final String pageTitle, final String pageLink, final int pageIcon) {
        this.pageID = pageID;
        this.pageTitle = pageTitle;
        this.pageLink = pageLink;
        this.pageIcon = pageIcon;
    }

    public String getPageLink() {
        return pageLink;
    }

    public void setPageLink(String pageLink) {
        this.pageLink = pageLink;
    }

    public int getPageIcon() {
        return pageIcon;
    }

    public void setPageIcon(int pageIcon) {
        this.pageIcon = pageIcon;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
