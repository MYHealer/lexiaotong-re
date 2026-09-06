package com.opos.cmn.an.e.d;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5884a;

    public a(Context context, String str, int i) {
        this.f5884a = null;
        if (context == null || com.opos.cmn.an.d.a.a(str)) {
            return;
        }
        this.f5884a = context.getSharedPreferences(str, i);
    }

    private boolean a(SharedPreferences.Editor editor, String str, Object obj) {
        if (editor == null || com.opos.cmn.an.d.a.a(str) || obj == null || this.f5884a == null) {
            return false;
        }
        try {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else {
                if (!(obj instanceof Set)) {
                    return false;
                }
                editor.putStringSet(str, (Set) obj);
            }
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "put", e);
            return false;
        }
    }

    public long a(String str, long j) {
        SharedPreferences sharedPreferences;
        if (com.opos.cmn.an.d.a.a(str) || (sharedPreferences = this.f5884a) == null) {
            return j;
        }
        try {
            return sharedPreferences.getLong(str, j);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "getLong", e);
            return j;
        }
    }

    public Map<String, ?> a() {
        SharedPreferences sharedPreferences = this.f5884a;
        if (sharedPreferences != null) {
            return sharedPreferences.getAll();
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences;
        if (com.opos.cmn.an.d.a.a(str) || (sharedPreferences = this.f5884a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove(str);
            editorEdit.commit();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "removeAndCommit", e);
        }
    }

    public void a(String str, Object obj) {
        SharedPreferences sharedPreferences;
        if (com.opos.cmn.an.d.a.a(str) || obj == null || (sharedPreferences = this.f5884a) == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (a(editorEdit, str, obj)) {
                editorEdit.apply();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "putAndApply", e);
        }
    }

    public boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences;
        if (com.opos.cmn.an.d.a.a(str) || (sharedPreferences = this.f5884a) == null) {
            return z;
        }
        try {
            return sharedPreferences.getBoolean(str, z);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPEngine", "getBoolean", e);
            return z;
        }
    }
}
