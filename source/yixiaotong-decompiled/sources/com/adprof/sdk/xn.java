package com.adprof.sdk;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xn f1525a = new xn();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile int f841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f842a = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ii f844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wn f845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f846a;

    /* JADX WARN: Code duplicated, block: B:100:0x01c5 A[LOOP:1: B:99:0x01c3->B:100:0x01c5, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:117:0x0121 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x00de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x01a3 A[EDGE_INSN: B:134:0x01a3->B:88:0x01a3 BREAK  A[LOOP:0: B:39:0x00dc->B:87:0x0198], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x004b A[PHI: r6
  0x004b: PHI (r6v18 android.database.Cursor) = (r6v17 android.database.Cursor), (r6v20 android.database.Cursor) binds: [B:10:0x002a, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x0117 A[Catch: all -> 0x0177, TRY_LEAVE, TryCatch #6 {all -> 0x0177, blocks: (B:44:0x0105, B:46:0x0117), top: B:121:0x0105 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0170  */
    /* JADX WARN: Code duplicated, block: B:86:0x0196  */
    /* JADX WARN: Code duplicated, block: B:93:0x01ae A[PHI: r3
  0x01ae: PHI (r3v2 android.database.Cursor) = (r3v1 android.database.Cursor), (r3v4 android.database.Cursor) binds: [B:92:0x01ac, B:88:0x01a3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:96:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c1  */
    public static void a(xn xnVar) {
        Cursor cursorRawQuery;
        int i;
        int size;
        int i2;
        int i3;
        int columnIndex;
        int columnIndex2;
        int columnIndex3;
        int columnIndex4;
        int columnIndex5;
        int columnIndex6;
        int columnIndex7;
        int columnIndex8;
        int columnIndex9;
        int i4;
        int i5;
        int i6;
        int i7;
        String string;
        Long lValueOf;
        String string2;
        n2 n2Var;
        long count;
        Long lValueOf2;
        l7 l7Var;
        Cursor cursorRawQuery2 = null;
        xnVar.f843a.removeCallbacksAndMessages(null);
        try {
            SQLiteDatabase readableDatabase = tk.f1443a.getReadableDatabase();
            cursorRawQuery = readableDatabase.rawQuery("select * from tracks", null);
            if (cursorRawQuery != null) {
                try {
                    count = cursorRawQuery.getCount();
                    cursorRawQuery.close();
                    cursorRawQuery = null;
                } catch (Throwable th) {
                    th = th;
                    try {
                        pk.b("cleanLimitAdTracker ", th);
                        if (cursorRawQuery != null) {
                        }
                        ArrayList arrayList = new ArrayList();
                        cursorRawQuery2 = tk.f1443a.getReadableDatabase().rawQuery("select * from tracks order by id desc limit 5", null);
                        if (cursorRawQuery2 != null) {
                            columnIndex = cursorRawQuery2.getColumnIndex("url");
                            columnIndex2 = cursorRawQuery2.getColumnIndex("id");
                            columnIndex3 = cursorRawQuery2.getColumnIndex(NotificationCompat.CATEGORY_EVENT);
                            columnIndex4 = cursorRawQuery2.getColumnIndex("request_id");
                            columnIndex5 = cursorRawQuery2.getColumnIndex(com.alipay.sdk.tid.b.f);
                            columnIndex6 = cursorRawQuery2.getColumnIndex(com.huawei.openalliance.ad.constant.ba.at);
                            columnIndex7 = cursorRawQuery2.getColumnIndex("retryNum");
                            columnIndex8 = cursorRawQuery2.getColumnIndex("extInfo");
                            columnIndex9 = cursorRawQuery2.getColumnIndex("messageType");
                            i4 = 0;
                            for (i = 5; i4 < i; i = 5) {
                                try {
                                    string = cursorRawQuery2.getString(columnIndex);
                                    lValueOf = Long.valueOf(cursorRawQuery2.getLong(columnIndex2));
                                    string2 = cursorRawQuery2.getString(columnIndex3);
                                    i5 = columnIndex;
                                    try {
                                        String string3 = cursorRawQuery2.getString(columnIndex4);
                                        cursorRawQuery2.getLong(columnIndex5);
                                        String string4 = cursorRawQuery2.getString(columnIndex6);
                                        Integer numValueOf = Integer.valueOf(cursorRawQuery2.getInt(columnIndex7));
                                        i6 = columnIndex2;
                                        try {
                                            String string5 = cursorRawQuery2.getString(columnIndex8);
                                            Integer numValueOf2 = Integer.valueOf(cursorRawQuery2.getInt(columnIndex9));
                                            if (TextUtils.isEmpty(string)) {
                                                columnIndex9 = columnIndex9;
                                                i7 = columnIndex3;
                                            } else {
                                                if (lValueOf.longValue() >= 0) {
                                                    try {
                                                        if (TextUtils.isEmpty(string2)) {
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        columnIndex9 = columnIndex9;
                                                    }
                                                }
                                                columnIndex9 = columnIndex9;
                                                i7 = columnIndex3;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            columnIndex9 = columnIndex9;
                                            i7 = columnIndex3;
                                            pk.b("getAdTrackList error", th);
                                            if (!cursorRawQuery2.moveToNext()) {
                                                break;
                                                if (cursorRawQuery2 != null) {
                                                    cursorRawQuery2.close();
                                                }
                                                xnVar.f846a = arrayList;
                                                xnVar.f841a = 0;
                                                size = xnVar.f846a.size();
                                                if (size > 5) {
                                                    i2 = 5;
                                                } else {
                                                    i2 = size;
                                                }
                                                for (i3 = 0; i3 < i2; i3++) {
                                                    xnVar.a();
                                                }
                                            }
                                            i4++;
                                            columnIndex = i5;
                                            columnIndex2 = i6;
                                            columnIndex3 = i7;
                                            columnIndex9 = columnIndex9;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        i6 = columnIndex2;
                                        i7 = columnIndex3;
                                        pk.b("getAdTrackList error", th);
                                        if (!cursorRawQuery2.moveToNext()) {
                                            break;
                                            if (cursorRawQuery2 != null) {
                                                cursorRawQuery2.close();
                                            }
                                            xnVar.f846a = arrayList;
                                            xnVar.f841a = 0;
                                            size = xnVar.f846a.size();
                                            if (size > 5) {
                                                i2 = 5;
                                            } else {
                                                i2 = size;
                                            }
                                            while (i3 < i2) {
                                                xnVar.a();
                                            }
                                        }
                                        i4++;
                                        columnIndex = i5;
                                        columnIndex2 = i6;
                                        columnIndex3 = i7;
                                        columnIndex9 = columnIndex9;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    i5 = columnIndex;
                                }
                                columnIndex = i5;
                                columnIndex2 = i6;
                                columnIndex3 = i7;
                                columnIndex9 = columnIndex9;
                            }
                        }
                        if (cursorRawQuery2 != null) {
                            cursorRawQuery2.close();
                        }
                        xnVar.f846a = arrayList;
                        xnVar.f841a = 0;
                        size = xnVar.f846a.size();
                        if (size > 5) {
                            i2 = 5;
                        } else {
                            i2 = size;
                        }
                        while (i3 < i2) {
                            xnVar.a();
                        }
                    } catch (Throwable th6) {
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th6;
                    }
                }
            } else {
                count = 0;
            }
            if (count > 6000) {
                cursorRawQuery = readableDatabase.rawQuery("select * from tracks order by id desc limit 6000", null);
                int columnIndex10 = cursorRawQuery.getColumnIndex("id");
                if (cursorRawQuery.moveToLast()) {
                    lValueOf2 = Long.valueOf(cursorRawQuery.getLong(columnIndex10));
                    cursorRawQuery.close();
                    cursorRawQuery = null;
                } else {
                    lValueOf2 = null;
                }
            } else {
                lValueOf2 = null;
            }
            if (lValueOf2 != null) {
                String str = "id <'" + lValueOf2 + "'";
                synchronized (l7.class) {
                    l7Var = l7.f1280a;
                }
                l7Var.a(tk.f1443a.getWritableDatabase(), "tracks", str, new k2());
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Throwable th7) {
            th = th7;
            cursorRawQuery = null;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            cursorRawQuery2 = tk.f1443a.getReadableDatabase().rawQuery("select * from tracks order by id desc limit 5", null);
            if (cursorRawQuery2 != null && cursorRawQuery2.moveToFirst()) {
                columnIndex = cursorRawQuery2.getColumnIndex("url");
                columnIndex2 = cursorRawQuery2.getColumnIndex("id");
                columnIndex3 = cursorRawQuery2.getColumnIndex(NotificationCompat.CATEGORY_EVENT);
                columnIndex4 = cursorRawQuery2.getColumnIndex("request_id");
                columnIndex5 = cursorRawQuery2.getColumnIndex(com.alipay.sdk.tid.b.f);
                columnIndex6 = cursorRawQuery2.getColumnIndex(com.huawei.openalliance.ad.constant.ba.at);
                columnIndex7 = cursorRawQuery2.getColumnIndex("retryNum");
                columnIndex8 = cursorRawQuery2.getColumnIndex("extInfo");
                columnIndex9 = cursorRawQuery2.getColumnIndex("messageType");
                i4 = 0;
                while (i4 < i) {
                    string = cursorRawQuery2.getString(columnIndex);
                    lValueOf = Long.valueOf(cursorRawQuery2.getLong(columnIndex2));
                    string2 = cursorRawQuery2.getString(columnIndex3);
                    i5 = columnIndex;
                    String string6 = cursorRawQuery2.getString(columnIndex4);
                    cursorRawQuery2.getLong(columnIndex5);
                    String string7 = cursorRawQuery2.getString(columnIndex6);
                    Integer numValueOf3 = Integer.valueOf(cursorRawQuery2.getInt(columnIndex7));
                    i6 = columnIndex2;
                    String string8 = cursorRawQuery2.getString(columnIndex8);
                    Integer numValueOf4 = Integer.valueOf(cursorRawQuery2.getInt(columnIndex9));
                    if (TextUtils.isEmpty(string)) {
                        if (lValueOf.longValue() >= 0) {
                            if (TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string6)) {
                                columnIndex9 = columnIndex9;
                                try {
                                    int iIntValue = numValueOf4.intValue();
                                    i7 = columnIndex3;
                                    if (iIntValue != 1) {
                                        try {
                                            n2Var = n2.TRACKING_URL;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            pk.b("getAdTrackList error", th);
                                        }
                                    } else {
                                        n2Var = n2.QUARTILE_EVENT;
                                    }
                                    o2 o2Var = new o2(n2Var, string, string2, string6);
                                    o2Var.f529a = lValueOf;
                                    o2Var.b = Integer.valueOf(numValueOf3.intValue());
                                    if (!TextUtils.isEmpty(string7)) {
                                        o2Var.c = l1.a(string7);
                                    }
                                    o2Var.e = string8;
                                    arrayList2.add(o2Var);
                                } catch (Throwable th9) {
                                    th = th9;
                                    i7 = columnIndex3;
                                    pk.b("getAdTrackList error", th);
                                    if (!cursorRawQuery2.moveToNext()) {
                                        break;
                                        if (cursorRawQuery2 != null) {
                                            cursorRawQuery2.close();
                                        }
                                        xnVar.f846a = arrayList2;
                                        xnVar.f841a = 0;
                                        size = xnVar.f846a.size();
                                        if (size > 5) {
                                            i2 = 5;
                                        } else {
                                            i2 = size;
                                        }
                                        while (i3 < i2) {
                                            xnVar.a();
                                        }
                                    }
                                    i4++;
                                    columnIndex = i5;
                                    columnIndex2 = i6;
                                    columnIndex3 = i7;
                                    columnIndex9 = columnIndex9;
                                }
                                if (!cursorRawQuery2.moveToNext()) {
                                    break;
                                } else {
                                    i4++;
                                }
                            }
                        }
                        columnIndex9 = columnIndex9;
                        i7 = columnIndex3;
                    } else {
                        columnIndex9 = columnIndex9;
                        i7 = columnIndex3;
                    }
                    columnIndex = i5;
                    columnIndex2 = i6;
                    columnIndex3 = i7;
                    columnIndex9 = columnIndex9;
                }
            }
            if (cursorRawQuery2 != null) {
                cursorRawQuery2.close();
            }
        } catch (Throwable th10) {
            try {
                pk.b("getlogs fail", th10);
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
            } catch (Throwable th11) {
                if (cursorRawQuery2 != null) {
                    cursorRawQuery2.close();
                }
                throw th11;
            }
        }
        xnVar.f846a = arrayList2;
        xnVar.f841a = 0;
        size = xnVar.f846a.size();
        if (size > 5) {
            i2 = 5;
        } else {
            i2 = size;
        }
        while (i3 < i2) {
            xnVar.a();
        }
    }

    public void a(long j) {
        this.f842a = j * 1000;
    }

    public void b() {
        if (this.f844a != null) {
            return;
        }
        in.a().getClass();
        Handler handler = new Handler(jn.f404a.getLooper());
        this.f843a = handler;
        vn vnVar = new vn(this, handler);
        this.f844a = vnVar;
        vnVar.a(this.f842a);
    }

    public final void a() {
        if (this.f846a == null || this.f841a >= this.f846a.size()) {
            return;
        }
        List list = this.f846a;
        int i = this.f841a;
        this.f841a = i + 1;
        o2 o2Var = (o2) list.get(i);
        wn wnVar = o2Var.f1334a.equals(n2.TRACKING_URL) ? this.f845a : null;
        if (wnVar == null) {
            return;
        }
        a(o2Var, null, false, true, new tn(this, wnVar));
    }

    public static void a(o2 o2Var, v5 v5Var, boolean z, boolean z2, wn wnVar) {
        if (o2Var.f1334a != n2.QUARTILE_EVENT) {
            if (!o2Var.f531a || z) {
                String str = o2Var.d;
                if (!z) {
                    o2Var.f531a = true;
                }
                int iIntValue = 0;
                boolean z3 = o2Var.f529a != null;
                o2Var.d = str;
                if (pk.f594a) {
                    pk.d("sendTracking finalUrlString = " + str);
                }
                if (!z3) {
                    Integer num = o2Var.f528a;
                    if (num == null) {
                        num = 0;
                    }
                    iIntValue = num.intValue();
                }
                yn ynVar = new yn(str, iIntValue, y6.a().m729a(), new un(o2Var, wnVar, z2, z3));
                a3 a3Var = ig.d;
                a3 a3Var2 = ig.f;
                if (a3Var == null && a3Var2 == null) {
                    pk.b("RequestQueue is null");
                    return;
                }
                if (!z3 ? a3Var == null : a3Var2 != null) {
                    a3Var = a3Var2;
                }
                a3Var.a(ynVar);
            }
        }
    }
}
