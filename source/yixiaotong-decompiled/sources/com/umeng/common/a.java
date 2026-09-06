package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: EncryptHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9199a = null;
    private static final String b = "umeng+";
    private static final String c = "ek__id";
    private static final String d = "ek_key";
    private static String e = "";
    private static final String f = "umeng_subprocess_info";
    private static String g = "";
    private static a h;

    private a() {
    }

    public static a a() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    private String c(String str) {
        String string = "";
        try {
            String strSubstring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strSubstring.length(); i++) {
                char cCharAt = strSubstring.charAt(i);
                if (Character.isDigit(cCharAt)) {
                    if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                        sb.append(0);
                    } else {
                        sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                    }
                } else {
                    sb.append(cCharAt);
                }
            }
            string = sb.toString();
            return string + new StringBuilder(string).reverse().toString();
        } catch (Throwable unused) {
            return string;
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f9199a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + e);
                }
                SharedPreferences sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f, 0);
                if (sharedPreferences != null) {
                    g = sharedPreferences.getString(c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + g);
                }
                f9199a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f9199a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f9199a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f9199a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        String str2;
        try {
            return TextUtils.isEmpty(f9199a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f9199a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            String str3 = null;
            if (TextUtils.isEmpty(e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                String str4 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), e.getBytes()));
                try {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                    return str4;
                } catch (Exception unused2) {
                    str3 = str4;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                    try {
                        String str5 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), g.getBytes()));
                        try {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                            return str5;
                        } catch (Throwable unused3) {
                            str2 = str5;
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                            return str2;
                        }
                    } catch (Throwable unused4) {
                        str2 = str3;
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }
}
