package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SafeBundle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f4409a;

    public SafeBundle() {
        this(new Bundle());
    }

    public boolean containsKey(String str) {
        try {
            return this.f4409a.containsKey(str);
        } catch (Exception unused) {
            a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
    }

    public Object get(String str) {
        try {
            return this.f4409a.get(str);
        } catch (Exception e) {
            a.a("SafeBundle", "get exception: " + e.getMessage(), true);
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f4409a;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public String getString(String str) {
        try {
            return this.f4409a.getString(str);
        } catch (Exception e) {
            a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f4409a.isEmpty();
        } catch (Exception unused) {
            a.a("SafeBundle", "isEmpty exception");
            return true;
        }
    }

    public int size() {
        try {
            return this.f4409a.size();
        } catch (Exception unused) {
            a.a("SafeBundle", "size exception");
            return 0;
        }
    }

    public String toString() {
        return this.f4409a.toString();
    }

    public SafeBundle(Bundle bundle) {
        this.f4409a = bundle == null ? new Bundle() : bundle;
    }

    public int getInt(String str, int i) {
        try {
            return this.f4409a.getInt(str, i);
        } catch (Exception e) {
            a.a("SafeBundle", "getInt exception: " + e.getMessage(), true);
            return i;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f4409a.getString(str, str2);
        } catch (Exception e) {
            a.a("SafeBundle", "getString exception: " + e.getMessage(), true);
            return str2;
        }
    }
}
