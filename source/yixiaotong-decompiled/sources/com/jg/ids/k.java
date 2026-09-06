package com.jg.ids;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final k f4612a = new k();
    private SharedPreferences b = null;

    private k() {
    }

    public final void a(Context context) {
        if (this.b == null) {
            this.b = context.getSharedPreferences("jg_ids", 0);
        }
    }

    public static k a() {
        return f4612a;
    }

    public final String b() {
        return this.b.getString("jg_aaid", "");
    }

    public final void a(String str) {
        SharedPreferences.Editor editorEdit = this.b.edit();
        editorEdit.putString("jg_aaid", str);
        editorEdit.commit();
    }

    public final String c() {
        return this.b.getString("jg_vaid", "");
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.b.edit();
        editorEdit.putString("jg_vaid", str);
        editorEdit.commit();
    }

    public final String d() {
        return this.b.getString("jg_oaid", "");
    }

    public final void c(String str) {
        SharedPreferences.Editor editorEdit = this.b.edit();
        editorEdit.putString("jg_oaid", str);
        editorEdit.commit();
    }
}
