package com.ubix.ssp.ad.e.s.g;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8856a;
    private String b;
    private String c;
    private long d;
    private long e;
    private int f = 42;
    private String g = "";

    private static String a(int i) {
        switch (i) {
            case 42:
                return " wait ";
            case 43:
                return " prepare ";
            case 44:
                return " loading ";
            case 45:
                return " pause ";
            case 46:
                return " complete ";
            case 47:
                return " fail ";
            default:
                return "  错误的未知状态 ";
        }
    }

    public long a() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public void b(long j) {
        this.d = j;
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return this.b;
    }

    public void c(String str) {
        this.c = str;
    }

    public String d() {
        if (!TextUtils.isEmpty(this.g)) {
            return this.g;
        }
        Matcher matcher = Pattern.compile("([^/]+)\\.apk").matcher(this.b);
        if (matcher.find()) {
            this.g = matcher.group();
        }
        return TextUtils.isEmpty(this.g) ? "" : this.g;
    }

    public void d(String str) {
        this.f8856a = str;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.f8856a;
    }

    public long g() {
        return this.d;
    }

    public String toString() {
        return "FileInfo{id='" + this.f8856a + "', downloadUrl='" + this.b + "', filePath='" + this.c + "', size=" + this.d + ", downloadLocation=" + this.e + ", downloadStatus=" + a(this.f) + '}';
    }
}
