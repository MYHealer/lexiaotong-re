package com.xiaomi.onetrack.b;

import android.database.sqlite.SQLiteDatabase;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9457a;
    public final /* synthetic */ h b;

    public j(h hVar, String str) {
        this.b = hVar;
        this.f9457a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            SQLiteDatabase writableDatabase = this.b.b.getWritableDatabase();
            String strD = s.d(new byte[]{85, 72, 17, 60, 8, 2, 92, 91}, "48acaf");
            writableDatabase.delete(s.d(new byte[]{82, 70, 82, 8, 66, 70, 62, 7, 10, 13, 68, 1}, "707f65"), strD, new String[]{this.f9457a});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
