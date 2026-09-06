package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1730a = z.p;
    private static final String b = "pauseDlByPk";
    private static final String c = "cancelDlByPk";
    private static final String d = "resumeDownload";
    private static final String e = "getDownloadStatus";
    private static at g;
    private au f;

    private at(Context context) {
        this.f = au.a(context, f1730a);
    }

    public static at a(Context context) {
        if (g == null) {
            synchronized (at.class) {
                if (g == null) {
                    g = new at(context);
                }
            }
        }
        return g;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, b, str, 1);
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, c, str);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context == null || jSONObject == null) {
            return false;
        }
        Object objB = this.f.b(null, d, context, jSONObject, str, str2);
        if (objB instanceof Boolean) {
            return ((Boolean) objB).booleanValue();
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bw.a(context, str)) {
            return 103;
        }
        Object objB = this.f.b(null, e, str);
        if (objB instanceof Integer) {
            return ((Integer) objB).intValue();
        }
        return -1;
    }
}
