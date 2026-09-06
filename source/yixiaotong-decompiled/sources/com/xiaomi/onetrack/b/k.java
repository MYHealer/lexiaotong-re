package com.xiaomi.onetrack.b;

import android.database.Cursor;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class k implements Callable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9458a;
    public final /* synthetic */ h b;

    public k(h hVar, String str) {
        this.b = hVar;
        this.f9458a = str;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0109: MOVE (r10 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:32:0x0109 */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public l call() throws Throwable {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            try {
                cursorQuery = this.b.b.getWritableDatabase().query(s.d(new byte[]{85, 79, 85, 91, 16, 66, 62, 7, 10, 13, 68, 1}, "0905d1"), null, s.d(new byte[]{7, 68, 70, 111, 88, 93, 92, 91}, "f46019"), new String[]{this.f9458a}, null, null, null);
                try {
                    int columnIndex = cursorQuery.getColumnIndex(s.d(new byte[]{3, 19, 66, 104, 15, 6}, "bc27fb"));
                    int columnIndex2 = cursorQuery.getColumnIndex(s.d(new byte[]{82, 91, 93, 66, 82, 111, 5, 5, Ascii.DC2, 3}, "172760"));
                    int columnIndex3 = cursorQuery.getColumnIndex(s.d(new byte[]{6, 82, 71, 87, 57, 14, 0, Ascii.ETB, 14}, "b336ff"));
                    int columnIndex4 = cursorQuery.getColumnIndex(s.d(new byte[]{70, 15, 84, 81, 66, Ascii.SYN, 0, 9, Ascii.SYN}, "2f941b"));
                    if (cursorQuery.moveToNext()) {
                        l lVar = new l();
                        lVar.f9459a = cursorQuery.getString(columnIndex);
                        String string = cursorQuery.getString(columnIndex2);
                        if (!TextUtils.isEmpty(string)) {
                            lVar.e = new JSONObject(string);
                        }
                        lVar.b = h.b(lVar.e);
                        lVar.d = cursorQuery.getString(columnIndex3);
                        lVar.c = cursorQuery.getLong(columnIndex4);
                        try {
                            cursorQuery.close();
                        } catch (Exception unused) {
                            p.a(s.d(new byte[]{115, 89, 95, 80, 88, 3, 37, 6, 43, 3, 95, 4, 87, 83, 67}, "06161d"), s.d(new byte[]{82, 87, 76, 114, 13, 87, 7, 13, 1, 66, 17, 6, SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 75, 94, 16, Ascii.ETB, 2, 8, 9, 17, 84}, "5281b9"));
                        }
                        return lVar;
                    }
                } catch (Exception e) {
                    e = e;
                    p.a(s.d(new byte[]{116, 14, 11, 5, 13, 83, 37, 6, 43, 3, 95, 4, 80, 4, Ascii.ETB}, "7aecd4"), e.getMessage());
                    if (cursorQuery != null) {
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    try {
                        cursor2.close();
                    } catch (Exception unused2) {
                        p.a(s.d(new byte[]{116, 94, 90, 0, 10, 6, 37, 6, 43, 3, 95, 4, 80, 84, 70}, "714fca"), s.d(new byte[]{4, 4, 17, 34, 95, 88, 7, 13, 1, 66, 17, 6, Ascii.SYN, 19, Ascii.SYN, 14, 66, Ascii.CAN, 2, 8, 9, 17, 84}, "caea06"));
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw th;
        }
        try {
            cursorQuery.close();
        } catch (Exception unused3) {
            p.a(s.d(new byte[]{118, 12, 10, 94, 80, 4, 37, 6, 43, 3, 95, 4, 82, 6, Ascii.SYN}, "5cd89c"), s.d(new byte[]{4, 83, 16, 112, 13, 92, 7, 13, 1, 66, 17, 6, Ascii.SYN, 68, Ascii.ETB, 92, 16, Ascii.FS, 2, 8, 9, 17, 84}, "c6d3b2"));
        }
        return null;
    }
}
