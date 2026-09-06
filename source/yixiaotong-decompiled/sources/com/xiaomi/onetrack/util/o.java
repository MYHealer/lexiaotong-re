package com.xiaomi.onetrack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9520a = ijiami_1011.s.s.s.d(new byte[]{87}, "8c2ced");
    private static final String b = ijiami_1011.s.s.s.d(new byte[]{6, 87, 13, 77, 80, 15, Ascii.NAK, 94, 73, 77, 82, 10, 8, Ascii.SYN, 14, 80, SignedBytes.MAX_POWER_OF_TWO, 8, 79, 5, 8, 3, 93, Ascii.FS, 17, 81, 0, 74, Ascii.ESC, 46, 15, 1, 50, 16, 80, 6, 14, 104, 17, 86, 67, 8, 5, 1, Ascii.DC4, 77, 88, 11, Ascii.SYN, 113, 7}, "e8c95a");
    private static final String c = ijiami_1011.s.s.s.d(new byte[]{93, 90, 17, 123, 0}, "44b2d9");
    private static final String d = ijiami_1011.s.s.s.d(new byte[]{73, 8, 80}, "9c7ddf");
    private static final String e = ijiami_1011.s.s.s.d(new byte[]{66, 11, 1, 95}, "1bf190");
    private static volatile o f;
    private static String g;
    private static String j;
    private boolean k = false;
    private final Context h = com.xiaomi.onetrack.f.a.a();
    private final Context i = com.xiaomi.onetrack.f.a.b();

    private o() {
        j = com.xiaomi.onetrack.f.a.e();
    }

    public static o a() {
        if (f == null) {
            synchronized (o.class) {
                if (f == null) {
                    f = new o();
                }
            }
        }
        return f;
    }

    private void b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri uri = Uri.parse(b);
            ContentValues contentValues = new ContentValues();
            contentValues.put(j, str);
            this.i.getContentResolver().insert(uri, contentValues);
        } catch (Exception e2) {
            aa.e(str);
            p.a(f9520a, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 85, 67, 100, 93, 90, 14, 16, 3, 33, 80, 6, 91, 85, 126, 88, 75, 67, 0, 10, 5, 7, 120, 1, 19, 85}, "307687"), e2);
        }
    }

    private String c() {
        String string = null;
        try {
            Uri.Builder builderBuildUpon = Uri.parse(b).buildUpon();
            builderBuildUpon.appendQueryParameter(d, j);
            builderBuildUpon.appendQueryParameter(e, com.xiaomi.onetrack.d.a.a(c + j));
            Cursor cursorQuery = this.i.getContentResolver().query(builderBuildUpon.build(), null, null, null, null);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(0);
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            p.a(f9520a, ijiami_1011.s.s.s.d(new byte[]{94, 85, 76, 107, 7, 88, 14, 16, 3, 33, 80, 6, 81, 85, 113, 87, 17, 65, 0, 10, 5, 7, 120, 1, Ascii.EM, 85}, "9089b5"), e2);
        }
        return string;
    }

    private String d() {
        String strA = aa.a(this.h);
        if (TextUtils.isEmpty(strA)) {
            return aa.m();
        }
        aa.e(strA);
        return strA;
    }

    public void a(Boolean bool) {
        this.k = bool.booleanValue();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        g = str;
        if (this.k) {
            b(str);
        }
        aa.e(g);
    }

    public String b() {
        String strD;
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (this.k) {
            strD = c();
            String strD2 = d();
            if (TextUtils.isEmpty(strD) && !TextUtils.isEmpty(strD2)) {
                b(strD2);
                strD = strD2;
            } else if (!TextUtils.isEmpty(strD) && TextUtils.isEmpty(strD2)) {
                aa.e(strD);
            }
        } else {
            strD = d();
        }
        if (TextUtils.isEmpty(strD)) {
            String string = UUID.randomUUID().toString();
            g = string;
            if (this.k) {
                b(string);
            }
            aa.e(g);
        } else {
            g = strD;
        }
        return g;
    }
}
