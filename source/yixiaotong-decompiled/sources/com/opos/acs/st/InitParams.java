package com.opos.acs.st;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InitParams {
    private boolean isLoganInit;
    private boolean isTablet;
    private String pkgName;

    public static class Builder {
        private boolean isTablet = false;
        private String pkgName = null;
        private boolean isLoganInit = true;

        public InitParams build() {
            return new InitParams(this);
        }

        public Builder setIsLoganInit(boolean z) {
            this.isLoganInit = z;
            return this;
        }

        public Builder setIsTablet(boolean z) {
            this.isTablet = z;
            return this;
        }

        public Builder setPkgName(String str) {
            this.pkgName = str;
            return this;
        }
    }

    public InitParams(Builder builder) {
        this.pkgName = null;
        this.isTablet = false;
        this.isLoganInit = true;
        this.pkgName = builder.pkgName;
        this.isTablet = builder.isTablet;
        this.isLoganInit = builder.isLoganInit;
    }

    public boolean getIsLoganInit() {
        return this.isLoganInit;
    }

    public boolean getIsTablet() {
        return this.isTablet;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String toString() {
        return "InitParams{pkgName='" + this.pkgName + "', isTablet=" + this.isTablet + ", isLoganInit=" + this.isLoganInit + '}';
    }
}
