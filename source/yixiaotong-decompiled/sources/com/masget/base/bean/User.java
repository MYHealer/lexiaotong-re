package com.masget.base.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.masget.base.BR;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class User extends BaseObservable {
    private int addressid = -8;
    private String appkey;
    private List<String> bannerurls;
    private long companyid;
    private String companyname;
    private int companytypeid;
    private String companytypename;
    private String email;
    private String loginname;
    private String loginprefix;
    private String loginpwd;
    private String merchantid;
    private String mobilephone;
    private int roletypeid;
    private String roletypename;
    private String secretkey;
    private String session;
    private String stafficon;
    private long staffid;
    private String staffname;
    private long stationid;
    private String stationname;
    private String url;

    public int getAddressid() {
        return this.addressid;
    }

    @Bindable
    public String getAppkey() {
        return this.appkey;
    }

    @Bindable
    public List<String> getBannerurls() {
        return this.bannerurls;
    }

    @Bindable
    public long getCompanyid() {
        return this.companyid;
    }

    @Bindable
    public String getCompanyname() {
        return this.companyname;
    }

    @Bindable
    public int getCompanytypeid() {
        return this.companytypeid;
    }

    @Bindable
    public String getCompanytypename() {
        return this.companytypename;
    }

    @Bindable
    public String getEmail() {
        return this.email;
    }

    @Bindable
    public String getLoginname() {
        return this.loginname;
    }

    public String getLoginprefix() {
        return this.loginprefix;
    }

    @Bindable
    public String getLoginpwd() {
        return this.loginpwd;
    }

    public String getMerchantid() {
        return this.loginprefix;
    }

    @Bindable
    public String getMobilephone() {
        return this.mobilephone;
    }

    @Bindable
    public int getRoletypeid() {
        return this.roletypeid;
    }

    @Bindable
    public String getRoletypename() {
        return this.roletypename;
    }

    @Bindable
    public String getSecretkey() {
        return this.secretkey;
    }

    @Bindable
    public String getSession() {
        return this.session;
    }

    @Bindable
    public String getStafficon() {
        return this.stafficon;
    }

    @Bindable
    public long getStaffid() {
        return this.staffid;
    }

    @Bindable
    public String getStaffname() {
        return this.staffname;
    }

    @Bindable
    public long getStationid() {
        return this.stationid;
    }

    @Bindable
    public String getStationname() {
        return this.stationname;
    }

    @Bindable
    public String getUrl() {
        return this.url;
    }

    public void setBannerurls(List<String> list) {
        this.bannerurls = list;
    }

    public void setLoginprefix(String str) {
        this.loginprefix = str;
    }

    public void setMerchantid(String str) {
        this.merchantid = str;
    }

    public void setSecretkey(String str) {
        this.secretkey = str;
        notifyPropertyChanged(BR.secretkey);
    }

    public void setSession(String str) {
        this.session = str;
        notifyPropertyChanged(BR.session);
    }

    public void setAppkey(String str) {
        this.appkey = str;
        notifyPropertyChanged(BR.appkey);
    }

    public void setCompanyid(long j) {
        this.companyid = j;
        notifyPropertyChanged(BR.companyid);
    }

    public void setCompanyname(String str) {
        this.companyname = str;
        notifyPropertyChanged(BR.companyname);
    }

    public void setStationid(long j) {
        this.stationid = j;
        notifyPropertyChanged(BR.stationid);
    }

    public void setStationname(String str) {
        this.stationname = str;
        notifyPropertyChanged(BR.stationname);
    }

    public void setStaffid(long j) {
        this.staffid = j;
        notifyPropertyChanged(BR.staffid);
    }

    public void setStaffname(String str) {
        this.staffname = str;
        notifyPropertyChanged(BR.staffname);
    }

    public void setMobilephone(String str) {
        this.mobilephone = str;
        notifyPropertyChanged(BR.mobilephone);
    }

    public void setLoginname(String str) {
        this.loginname = str;
        notifyPropertyChanged(BR.loginname);
    }

    public void setCompanytypeid(int i) {
        this.companytypeid = i;
        notifyPropertyChanged(BR.companytypeid);
    }

    public void setEmail(String str) {
        this.email = str;
        notifyPropertyChanged(BR.email);
    }

    public void setStafficon(String str) {
        this.stafficon = str;
        notifyPropertyChanged(BR.stafficon);
    }

    public void setRoletypeid(int i) {
        this.roletypeid = i;
        notifyPropertyChanged(BR.roletypeid);
    }

    public void setRoletypename(String str) {
        this.roletypename = str;
        notifyPropertyChanged(BR.roletypename);
    }

    public void setLoginpwd(String str) {
        this.loginpwd = str;
        notifyPropertyChanged(BR.loginpwd);
    }

    public void setCompanytypename(String str) {
        this.companytypename = str;
        notifyPropertyChanged(BR.companytypename);
    }

    public void setUrl(String str) {
        this.url = str;
        notifyPropertyChanged(BR.url);
    }
}
