package com.dagger.test.model;

public class CmsItem {
    public String cmsUrl;
    public String cmsTitle;
    public String cmsThumbnail;

    public CmsItem(String url, String title, String thumbnail) {
        cmsUrl = url;
        cmsTitle = title;
        cmsThumbnail = thumbnail;
    }
}
