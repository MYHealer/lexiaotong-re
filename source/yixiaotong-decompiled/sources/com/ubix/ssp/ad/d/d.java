package com.ubix.ssp.ad.d;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8607a;
    private String b;
    private boolean c;
    private boolean d;

    public d(String str, String str2, boolean z) {
        this.f8607a = str;
        this.b = str2;
        this.c = z;
        this.d = z;
    }

    public static d a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri uri = Uri.parse(str);
            return new d(uri.getScheme(), uri.getHost(), z);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        return this.b.equals("host") || this.b.equals(str);
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(this.f8607a)) {
            return false;
        }
        return this.f8607a.equals("scheme") || this.f8607a.equals(str);
    }

    public boolean a(String str, String str2) {
        if (b(str) && a(str2)) {
            if (this.c) {
                return false;
            }
            this.c = true;
        }
        return true;
    }

    public boolean b(String str, String str2) {
        return b(str) && a(str2);
    }

    public void c(String str, String str2) {
        if (!this.d && b(str) && a(str2)) {
            this.c = false;
        }
    }
}
