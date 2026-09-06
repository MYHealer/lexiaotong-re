package com.heytap.mspsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.stub.StubApp;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f3478a = true;
    private SharedPreferences b;
    private SharedPreferences.Editor c = null;

    public e(Context context, String str, int i) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(str, i);
    }

    public e a(String str) {
        if (!f3478a && this.b == null) {
            throw new AssertionError();
        }
        if (this.c == null) {
            this.c = this.b.edit();
        }
        this.c.remove(str);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T a(String str, T t) {
        Object stringSet;
        if (!f3478a && this.b == null) {
            throw new AssertionError();
        }
        if (t instanceof Boolean) {
            stringSet = Boolean.valueOf(this.b.getBoolean(str, ((Boolean) t).booleanValue()));
        } else if (t instanceof Float) {
            stringSet = Float.valueOf(this.b.getFloat(str, ((Float) t).floatValue()));
        } else if (t instanceof Integer) {
            stringSet = Integer.valueOf(this.b.getInt(str, ((Integer) t).intValue()));
        } else if (t instanceof Long) {
            stringSet = Long.valueOf(this.b.getLong(str, ((Long) t).longValue()));
        } else {
            stringSet = t instanceof Set ? this.b.getStringSet(str, (Set) t) : this.b.getString(str, (String) t);
        }
        return stringSet == null ? t : (T) stringSet;
    }

    public void a() {
        SharedPreferences.Editor editor = this.c;
        if (editor != null) {
            editor.apply();
        }
    }

    public e b(String str, Object obj) {
        if (!f3478a && this.b == null) {
            throw new AssertionError();
        }
        if (this.c == null) {
            this.c = this.b.edit();
        }
        if (obj instanceof Boolean) {
            this.c.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            this.c.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Integer) {
            this.c.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            this.c.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Set) {
            this.c.putStringSet(str, (Set) obj);
        } else {
            this.c.putString(str, (String) obj);
        }
        return this;
    }
}
