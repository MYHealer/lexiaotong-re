package com.adprof.sdk;

import android.database.sqlite.SQLiteDatabase;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f1262a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rk f421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f422a;
    public final String b;

    public k7(l7 l7Var, SQLiteDatabase sQLiteDatabase, String str, String str2, rk rkVar) {
        this.f422a = str;
        this.f1262a = sQLiteDatabase;
        this.b = str2;
        this.f421a = rkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1262a.delete(this.f422a, this.b, null);
            rk rkVar = this.f421a;
            if (rkVar != null) {
                rkVar.a((List) null);
            }
        } catch (Throwable th) {
            rk rkVar2 = this.f421a;
            if (rkVar2 != null) {
                rkVar2.a(new Error(th.getMessage()));
            }
        }
    }
}
