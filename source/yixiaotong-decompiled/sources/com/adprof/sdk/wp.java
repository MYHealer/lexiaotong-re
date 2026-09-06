package com.adprof.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile wp f1509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Long f811a = 120000L;
    public static final byte[] d = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f813a;
    public SharedPreferences b;
    public SharedPreferences c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f814a = new byte[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final byte[] f815b = new byte[0];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final byte[] f816c = new byte[0];

    public wp(Context context) {
        this.f813a = null;
        this.b = null;
        this.c = null;
        try {
            this.f812a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            Context contextA = yp.a(context);
            this.f813a = contextA.getSharedPreferences("identifier_sp_story_book_file", 4);
            this.b = contextA.getSharedPreferences("identifier_hiad_sp_bed_rock_file", 4);
            this.c = contextA.getSharedPreferences("identifier_hiad_sp_red_stone_file", 4);
        } catch (Throwable th) {
            Log.w("Aes128", "get SharedPreference error: " + th.getClass().getSimpleName());
        }
    }

    public static wp a(Context context) {
        wp wpVar;
        if (f1509a != null) {
            return f1509a;
        }
        synchronized (d) {
            if (f1509a == null) {
                f1509a = new wp(context);
            }
            wpVar = f1509a;
        }
        return wpVar;
    }

    public void a(String str) {
        synchronized (this.f815b) {
            if (this.c != null) {
                this.c.edit().putString("read_first_chapter", xp.d(str, xp.b(this.f812a))).apply();
            }
        }
    }

    public boolean a() {
        synchronized (this.f816c) {
            SharedPreferences sharedPreferences = this.f813a;
            if (sharedPreferences == null) {
                return false;
            }
            long j = sharedPreferences.getLong("read_first_chapter_time", -1L);
            if (j < 0) {
                return false;
            }
            return j + f811a.longValue() > System.currentTimeMillis();
        }
    }

    public void b(String str) {
        synchronized (this.f814a) {
            SharedPreferences sharedPreferences = this.b;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("get_a_book", str).commit();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this.f816c) {
            SharedPreferences sharedPreferences = this.f813a;
            z = false;
            if (sharedPreferences != null) {
                z = sharedPreferences.getBoolean("has_read_first_chapter", false);
            }
        }
        return z;
    }
}
