package com.masget.base;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AppConfig {
    private static final String APP_CONFIG = "config";
    public static final String APP_ID = "400000684";
    public static final String CONF_APP_UNIQUEID = "APP_UNIQUEID";
    public static final String CONF_COOKIE = "cookie";
    public static final String DEFAULT_APPKEY = "6a57f807c55c4d9a";
    public static final String FORMAT = "json";
    public static final String KEY_NIGHT_MODE_SWITCH = "night_mode_switch";
    public static final String OPEN_API_VERSION = "2.0";
    public static String SUB_APPKEY = "6a57f807c55c4d9a";
    public static String SUB_APP_ID = "400000684";
    public static final int ZHIBAO_REP = 30002;
    public static final int ZHIBAO_REQ = 30001;
    public static final String alipay = "https://qr.alipay.com";
    private static AppConfig appConfig;
    private static Map<Integer, String> maps;
    private Context mContext;

    public Map<Integer, String> getMaps() {
        return maps;
    }

    public static AppConfig getAppConfig(Context context) {
        if (appConfig == null) {
            AppConfig appConfig2 = new AppConfig();
            appConfig = appConfig2;
            appConfig2.mContext = context;
        }
        if (maps == null) {
            maps = new HashMap();
        }
        return appConfig;
    }

    public String get(String str) throws Throwable {
        Properties properties = get();
        if (properties != null) {
            return properties.getProperty(str);
        }
        return null;
    }

    public Properties get() throws Throwable {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(this.mContext.getDir(APP_CONFIG, 0).getPath() + File.separator + APP_CONFIG);
                try {
                    properties.load(fileInputStream2);
                    fileInputStream2.close();
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    fileInputStream.close();
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        fileInputStream.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return properties;
    }

    private void setProps(Properties properties) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.mContext.getDir(APP_CONFIG, 0), APP_CONFIG));
                try {
                    properties.store(fileOutputStream2, (String) null);
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    try {
                        fileOutputStream.close();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    public void set(Properties properties) throws Throwable {
        Properties properties2 = get();
        properties2.putAll(properties);
        setProps(properties2);
    }

    public void set(String str, String str2) throws Throwable {
        Properties properties = get();
        properties.setProperty(str, str2);
        setProps(properties);
    }

    public void remove(String... strArr) throws Throwable {
        Properties properties = get();
        for (String str : strArr) {
            properties.remove(str);
        }
        setProps(properties);
    }
}
