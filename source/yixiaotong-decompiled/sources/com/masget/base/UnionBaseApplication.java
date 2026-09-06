package com.masget.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.masget.base.bean.User;
import com.masget.base.util.UserInfoUtils;
import com.stub.StubApp;
import java.util.Properties;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class UnionBaseApplication extends Application {
    public static final String TAG = "UnionBaseApplication";
    static Context _context;
    static Resources _resource;
    private static UnionBaseApplication instance;
    private boolean isLandiNeedLoadAIDAndRID = true;
    private boolean isLoginLayoutVisible;
    private JSONObject rdata;
    private RequestQueue requestQueue;
    private SharedPreferences sp;

    public static UnionBaseApplication getInstance() {
        return instance;
    }

    public boolean getIsLandiNeedLoadAIDAndRID() {
        return this.isLandiNeedLoadAIDAndRID;
    }

    public boolean isLoginLayoutVisible() {
        return this.isLoginLayoutVisible;
    }

    public void setLoginLayoutVisible(boolean z) {
        this.isLoginLayoutVisible = z;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
        Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
        _context = origApplicationContext;
        _resource = origApplicationContext.getResources();
        SharedPreferences sharedPreferences = getSharedPreferences("masget_shared_preferences_config", 0);
        this.sp = sharedPreferences;
        this.isLandiNeedLoadAIDAndRID = sharedPreferences.getBoolean("isLandiNeedLoadAid", true);
    }

    public static synchronized UnionBaseApplication context() {
        return (UnionBaseApplication) _context;
    }

    public String getProperty(String str) {
        return AppConfig.getAppConfig(this).get(str);
    }

    public void removeProperty(String... strArr) throws Throwable {
        AppConfig.getAppConfig(this).remove(strArr);
    }

    public void cleanLoginInfo() throws Throwable {
        removeProperty("user.appkey", "user.session", "user.companyid", "user.companyname", "user.companytypeid", "user.companytypename", "user.stationid", "user.stationname", "user.staffid", "user.staffname", "user.roletypeid", "user.roletypename", "user.stafficon", "user.email", "user.loginname", "user.mobilephone", "user.loginpwd", "user.url");
    }

    public void saveUserInfo(User user) {
        UserInfoUtils.saveUserInfo(user, this);
    }

    public User getUserDate() {
        User loginUser = UserInfoUtils.getLoginUser(this);
        return loginUser == null ? new User() : loginUser;
    }

    public void setProperties(Properties properties) {
        AppConfig.getAppConfig(this).set(properties);
    }

    private RequestQueue getRequestQueue() {
        if (this.requestQueue == null) {
            this.requestQueue = Volley.newRequestQueue(StubApp.getOrigApplicationContext(getApplicationContext()));
        }
        return this.requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request, String str) {
        request.setTag(str);
        getRequestQueue().add(request);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object obj) {
        RequestQueue requestQueue = this.requestQueue;
        if (requestQueue != null) {
            requestQueue.cancelAll(obj);
        }
    }

    public void setLandiNeedLoadAIDAndRID(boolean z) {
        this.isLandiNeedLoadAIDAndRID = z;
        SharedPreferences.Editor editorEdit = this.sp.edit();
        editorEdit.putBoolean("isLandiNeedLoadAid", z);
        editorEdit.apply();
    }

    public void saveLoginTime(long j) {
        SharedPreferences.Editor editorEdit = this.sp.edit();
        editorEdit.putLong("loginTime", j);
        editorEdit.commit();
    }

    public long getLoginTime() {
        return this.sp.getLong("loginTime", -1L);
    }
}
