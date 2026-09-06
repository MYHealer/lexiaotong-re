package com.xiaomi.onetrack.api;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class b implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9421a;
    public final /* synthetic */ a b;

    public b(a aVar, Intent intent) {
        this.b = aVar;
        this.f9421a = intent;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x01ac A[PHI: r2 r3
  0x01ac: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v7 java.lang.String) binds: [B:32:0x01aa, B:24:0x0185] A[DONT_GENERATE, DONT_INLINE]
  0x01ac: PHI (r3v4 android.database.Cursor) = (r3v3 android.database.Cursor), (r3v12 android.database.Cursor) binds: [B:32:0x01aa, B:24:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:37:0x01b3  */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String call() throws Throwable {
        Cursor cursor;
        Cursor cursorQuery;
        String string = "";
        try {
            try {
                if (!a.f()) {
                    return "";
                }
                String stringExtra = this.f9421a.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{67, 82, 85, 91, 0, 81, 4}, "3360a6"));
                String stringExtra2 = this.f9421a.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{80, 12, 66, 16, 89, 85, 13, 1, Ascii.DC4}, "9b1d89"));
                String stringExtra3 = this.f9421a.getStringExtra(ijiami_1011.s.s.s.d(new byte[]{88, 12, 17, 89, 113, 84, Ascii.NAK, 13, 16, 7, 120, 1}, "5ed007"));
                long longExtra = this.f9421a.getLongExtra(ijiami_1011.s.s.s.d(new byte[]{14, 90, 71, 12, 115, 6, Ascii.NAK, 13, 16, 7, 101, 12, 14, 86}, "c32e2e"), -1L);
                long longExtra2 = this.f9421a.getLongExtra(ijiami_1011.s.s.s.d(new byte[]{85, 82, 67, 90, 66, 85, 53, 13, 11, 7}, "417340"), -1L);
                int intExtra = this.f9421a.getIntExtra(ijiami_1011.s.s.s.d(new byte[]{19, 17, 80, 70, 45, 2}, "fb54df"), -1);
                String strValueOf = String.valueOf(System.currentTimeMillis());
                Uri.Builder builderBuildUpon = Uri.parse(ijiami_1011.s.s.s.d(new byte[]{86, 14, 88, 70, 1, 12, Ascii.NAK, 94, 73, 77, 82, 10, 88, 79, 91, 91, 17, 11, 79, 5, 8, 3, 93, Ascii.FS, 65, 8, 85, 65, 74, 45, 15, 1, 50, 16, 80, 6, 94, 49, 68, 93, Ascii.DC2, 11, 5, 1, Ascii.DC4, 77, 69, Ascii.ETB, 84, 2, 83, 123, 0}, "5a62db")).buildUpon();
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 82, 6}, "e9a8ab"), a.j);
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{69, 95, 94, 13}, "669cc1"), com.xiaomi.onetrack.d.a.a(ijiami_1011.s.s.s.d(new byte[]{69, Ascii.DC4, 87, 1, 86, 42, 5}, "1f6b3c") + a.j + strValueOf));
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 2, 82, 88, 5, 3, 4}, "fc13dd"), stringExtra);
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{95, 11, 67, 71, 82, 14, 13, 1, Ascii.DC4}, "6e033b"), stringExtra2);
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{15, 12, 16, 88, 120, 85, Ascii.NAK, 13, 16, 7, 120, 1}, "bee196"), stringExtra3);
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{95, 93, 66, 10, 119, 85, Ascii.NAK, 13, 16, 7, 101, 12, 95, 81}, "247c66"), String.valueOf(longExtra));
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{88, 90, Ascii.NAK, 92, Ascii.DC4, 3, 53, 13, 11, 7}, "99a5bf"), String.valueOf(longExtra2));
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{65, 66, 81, 71, 112, 0}, "41459d"), String.valueOf(intExtra));
                builderBuildUpon.appendQueryParameter(ijiami_1011.s.s.s.d(new byte[]{67, 67, 84, 74, SignedBytes.MAX_POWER_OF_TWO, 53, 8, 9, 3}, "26189a"), strValueOf);
                cursorQuery = this.b.i.getContentResolver().query(builderBuildUpon.build(), null, null, null, null);
                if (cursorQuery != null) {
                    while (cursorQuery.moveToNext()) {
                        try {
                            string = cursorQuery.getString(0);
                        } catch (Exception e) {
                            e = e;
                            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{119, 17, 68, 32, 0, 69, 8, Ascii.DC2, 3, 32, 67, 10, 87, 5, 87, 0, 16, 69, 44, 5, 8, 3, 86, 0, 68}, "6a4ac1"), ijiami_1011.s.s.s.d(new byte[]{80, Ascii.FS, 91, 84, 17, 70, 8, 11, 8, 66, 70, 13, 92, 8, 93, 17, 6, 87, Ascii.NAK, 48, Ascii.DC4, 3, 82, 0, 124, 0}, "5d81a2"), e);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
        com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{119, 17, 68, 32, 0, 69, 8, Ascii.DC2, 3, 32, 67, 10, 87, 5, 87, 0, 16, 69, 44, 5, 8, 3, 86, 0, 68}, "6a4ac1"), ijiami_1011.s.s.s.d(new byte[]{80, Ascii.FS, 91, 84, 17, 70, 8, 11, 8, 66, 70, 13, 92, 8, 93, 17, 6, 87, Ascii.NAK, 48, Ascii.DC4, 3, 82, 0, 124, 0}, "5d81a2"), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }
}
