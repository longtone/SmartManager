package com.app.carrot.smartmanager.vo;

/**
 * Created by 101 on 2016/4/5.
 * 广告页面实体类，用于封装从服务器获取的广告数据
 */
public class AD {
    //图片地址
    private String pic_url;
    //连接页面地址
    private String page_url;
    //广告标题内容
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }
}
