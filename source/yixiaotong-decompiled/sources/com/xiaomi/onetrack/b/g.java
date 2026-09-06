package com.xiaomi.onetrack.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import ijiami_1011.s.s.s;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class g extends SQLiteOpenHelper {
    private static final int j = 1;
    private static final String i = s.d(new byte[]{113, 95, 86, 7, 94, 5, 37, 5, Ascii.DC2, 3, 83, 4, 65, 85, 112, 4, 91, Ascii.DC2, 4, Ascii.SYN}, "208a7b");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9453a = s.d(new byte[]{93, 11, 85, 59, 67, SignedBytes.MAX_POWER_OF_TWO, 0, 7, 13, Base64.padSymbol, 82, 9, 93, 16, 84}, "2e0d72");
    public static final String b = s.d(new byte[]{85, 68, 85, 86, 67, 16, 62, 7, 10, 13, 68, 1}, "02087c");
    public static final String c = s.d(new byte[]{107, 10, 82}, "4c6b9f");
    public static final String d = s.d(new byte[]{82, 68, 19, 109, 94, 1}, "34c27e");
    public static final String e = s.d(new byte[]{2, 93, 86, 77, 6, 108, 5, 5, Ascii.DC2, 3}, "a198b3");
    public static final String f = s.d(new byte[]{84, 82, 65, 88, 59, 11, 0, Ascii.ETB, 14}, "0359dc");
    public static final String g = s.d(new byte[]{16, 90, 94, 83, 70, SignedBytes.MAX_POWER_OF_TWO, 0, 9, Ascii.SYN}, "d33654");
    public static final String h = s.d(new byte[]{32, 52, 113, 34, 108, 32, 65, 48, 39, 32, 125, 32, 67, 3, 66, 6, 86, 17, Ascii.DC2, 59, 5, 14, 94, 16, 7, 70, Ascii.FS, 60, 81, 1, 65, 68, 47, 44, 101, 32, 36, 35, 102, 67, 104, 55, 40, 41, 39, 48, 104, 69, 40, 35, 109, 67, 121, 48, 53, 43, 47, 44, 114, 55, 38, 43, 113, 45, 108, 73, 0, Ascii.DC4, Ascii.SYN, Base64.padSymbol, 88, 1, 67, 50, 113, 59, 108, 73, 2, 8, 9, Ascii.ETB, 85, 58, 7, 7, SignedBytes.MAX_POWER_OF_TWO, 2, Ascii.CAN, 49, 36, 60, 50, 78, 69, 12, 14, 3, 71, Ascii.ETB, 89, 8, 17, 68, 47, 44, 101, 32, 36, 35, 102, 79, 92, 4, Ascii.NAK, 5, 57, 10, 80, Ascii.SYN, 11, 70, 96, 38, 96, 49, 72}, "cf4c8e");

    public g(Context context) {
        super(context, s.d(new byte[]{13, 91, 80, 108, 69, 75, 0, 7, 13, Base64.padSymbol, 82, 9, 13, SignedBytes.MAX_POWER_OF_TWO, 81}, "b55319"), (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(h);
        Log.d(i, s.d(new byte[]{14, 11, 37, 65, 85, 4, Ascii.NAK, 1, 92, 66}, "aef30e"));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
