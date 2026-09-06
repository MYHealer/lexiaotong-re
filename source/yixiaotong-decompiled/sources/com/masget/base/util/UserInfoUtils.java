package com.masget.base.util;

import com.masget.base.UnionBaseApplication;
import com.masget.base.bean.User;
import java.util.Properties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class UserInfoUtils {
    public static void saveUserInfo(User user, UnionBaseApplication unionBaseApplication) {
        unionBaseApplication.setProperties(new Properties() { // from class: com.masget.base.util.UserInfoUtils.1
            {
                try {
                    setProperty("user.appkey", StringUtils.getString(this.val$user.getAppkey()));
                    setProperty("user.session", StringUtils.getString(this.val$user.getSession()));
                    setProperty("user.companyid", String.valueOf(this.val$user.getCompanyid()));
                    setProperty("user.companyname", StringUtils.getString(this.val$user.getCompanyname()));
                    setProperty("user.companytypeid", String.valueOf(this.val$user.getCompanytypeid()));
                    setProperty("user.companytypename", StringUtils.getString(this.val$user.getCompanytypename()));
                    setProperty("user.stationid", String.valueOf(this.val$user.getStationid()));
                    setProperty("user.stationname", StringUtils.getString(this.val$user.getStationname()));
                    setProperty("user.staffid", String.valueOf(this.val$user.getStaffid()));
                    setProperty("user.staffname", StringUtils.getString(this.val$user.getStaffname()));
                    setProperty("user.stafficon", StringUtils.getString(this.val$user.getStafficon()));
                    setProperty("user.roletypeid", String.valueOf(this.val$user.getRoletypeid()));
                    setProperty("user.roletypename", StringUtils.getString(this.val$user.getRoletypename()));
                    setProperty("user.email", StringUtils.getString(this.val$user.getEmail()));
                    setProperty("user.loginname", StringUtils.getString(this.val$user.getLoginname()));
                    setProperty("user.mobilephone", StringUtils.getString(this.val$user.getMobilephone()));
                    setProperty("user.loginpwd", CyptoUtils.AesEncrypt(this.val$user.getLoginpwd(), this.val$user.getAppkey(), this.val$user.getAppkey()));
                    setProperty("user.url", StringUtils.getString(this.val$user.getUrl()));
                    setProperty("user.secretkey", StringUtils.getString(this.val$user.getSecretkey()));
                    setProperty("user.loginprefix", StringUtils.getString(this.val$user.getLoginprefix()));
                    setProperty("user.merchantid", StringUtils.getString(this.val$user.getMerchantid()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void updateUserInfo(User user, UnionBaseApplication unionBaseApplication) {
        unionBaseApplication.setProperties(new Properties() { // from class: com.masget.base.util.UserInfoUtils.2
            {
                setProperty("user.appkey", this.val$user.getAppkey());
                setProperty("user.session", this.val$user.getSession());
                setProperty("user.companyid", String.valueOf(this.val$user.getCompanyid()));
                setProperty("user.companyname", StringUtils.getString(this.val$user.getCompanyname()));
                setProperty("user.companytypeid", String.valueOf(this.val$user.getCompanytypeid()));
                setProperty("user.companytypename", StringUtils.getString(this.val$user.getCompanytypename()));
                setProperty("user.stationid", String.valueOf(this.val$user.getStationid()));
                setProperty("user.stationname", StringUtils.getString(this.val$user.getStationname()));
                setProperty("user.staffid", String.valueOf(this.val$user.getStaffid()));
                setProperty("user.staffname", StringUtils.getString(this.val$user.getStaffname()));
                setProperty("user.stafficon", StringUtils.getString(this.val$user.getStafficon()));
                setProperty("user.roletypeid", String.valueOf(this.val$user.getRoletypeid()));
                setProperty("user.roletypename", StringUtils.getString(this.val$user.getRoletypename()));
                setProperty("user.email", StringUtils.getString(this.val$user.getEmail()));
                setProperty("user.loginname", this.val$user.getLoginname());
                setProperty("user.mobilephone", StringUtils.getString(this.val$user.getMobilephone()));
                setProperty("user.loginpwd", CyptoUtils.AesEncrypt(this.val$user.getLoginpwd(), this.val$user.getAppkey(), this.val$user.getAppkey()));
                setProperty("user.secretkey", StringUtils.getString(this.val$user.getSecretkey()));
                setProperty("user.loginprefix", StringUtils.getString(this.val$user.getLoginprefix()));
                setProperty("user.merchantid", StringUtils.getString(this.val$user.getMerchantid()));
            }
        });
    }

    public static User getLoginUser(UnionBaseApplication unionBaseApplication) {
        User user = new User();
        user.setAppkey(unionBaseApplication.getProperty("user.appkey"));
        user.setSession(unionBaseApplication.getProperty("user.session"));
        user.setCompanyid(StringUtils.toLong(unionBaseApplication.getProperty("user.companyid")));
        user.setCompanyname(unionBaseApplication.getProperty("user.companyname"));
        user.setCompanytypeid(StringUtils.toInt(unionBaseApplication.getProperty("user.companytypeid")));
        user.setCompanytypename(unionBaseApplication.getProperty("user.companytypename"));
        user.setStationid(StringUtils.toLong(unionBaseApplication.getProperty("user.stationid")));
        user.setStationname(unionBaseApplication.getProperty("user.stationname"));
        user.setStaffid(StringUtils.toLong(unionBaseApplication.getProperty("user.staffid")));
        user.setStaffname(unionBaseApplication.getProperty("user.staffname"));
        user.setStafficon(unionBaseApplication.getProperty("user.stafficon"));
        user.setRoletypeid(StringUtils.toInt(unionBaseApplication.getProperty("user.roletypeid")));
        user.setRoletypename(unionBaseApplication.getProperty("user.roletypename"));
        user.setEmail(unionBaseApplication.getProperty("user.email"));
        user.setLoginname(unionBaseApplication.getProperty("user.loginname"));
        user.setMobilephone(unionBaseApplication.getProperty("user.mobilephone"));
        user.setUrl(unionBaseApplication.getProperty("user.url"));
        user.setSecretkey(unionBaseApplication.getProperty("user.secretkey"));
        user.setLoginprefix(unionBaseApplication.getProperty("user.loginprefix"));
        user.setMerchantid(unionBaseApplication.getProperty("user.merchantid"));
        if (unionBaseApplication.getProperty("user.loginpwd") != null) {
            user.setLoginpwd(CyptoUtils.AesDesencrypt(unionBaseApplication.getProperty("user.loginpwd"), user.getAppkey(), user.getAppkey()));
        }
        return user;
    }
}
