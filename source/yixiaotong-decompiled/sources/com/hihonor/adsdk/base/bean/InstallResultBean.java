package com.hihonor.adsdk.base.bean;

import com.hihonor.adsdk.base.dialog.installnotify.AdInstallNotify;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InstallResultBean {
    private String adId;
    private AdInstallNotify adInstallNotify;
    private String adRequestId;
    private String adUnitId;
    private String brand;
    private String imgUrl;
    private String title;

    public static final class BeanBuilder {
        private String adId;
        private AdInstallNotify adInstallNotify;
        private String adRequestId;
        private String adUnitId;
        private String brand;
        private String imgUrl;
        private String title;

        public InstallResultBean build() {
            InstallResultBean installResultBean = new InstallResultBean();
            installResultBean.adInstallNotify = this.adInstallNotify;
            installResultBean.adId = this.adId;
            installResultBean.adRequestId = this.adRequestId;
            installResultBean.imgUrl = this.imgUrl;
            installResultBean.title = this.title;
            installResultBean.adUnitId = this.adUnitId;
            installResultBean.brand = this.brand;
            return installResultBean;
        }

        public BeanBuilder setAdId(String str) {
            this.adId = str;
            return this;
        }

        public BeanBuilder setAdInstallNotify(AdInstallNotify adInstallNotify) {
            this.adInstallNotify = adInstallNotify;
            return this;
        }

        public BeanBuilder setAdRequestId(String str) {
            this.adRequestId = str;
            return this;
        }

        public BeanBuilder setAdUnitId(String str) {
            this.adUnitId = str;
            return this;
        }

        public BeanBuilder setBrand(String str) {
            this.brand = str;
            return this;
        }

        public BeanBuilder setImgUrl(String str) {
            this.imgUrl = str;
            return this;
        }

        public BeanBuilder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    public String getAdId() {
        return this.adId;
    }

    public AdInstallNotify getAdInstallNotify() {
        return this.adInstallNotify;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getTitle() {
        return this.title;
    }
}
