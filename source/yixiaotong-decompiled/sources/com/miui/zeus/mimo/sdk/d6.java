package com.miui.zeus.mimo.sdk;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d6 extends g9 {
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ long g;
    public final /* synthetic */ String h;
    public final /* synthetic */ s3 i;
    public final /* synthetic */ String j;
    public final /* synthetic */ String k;
    public final /* synthetic */ String l;
    public final /* synthetic */ h6 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d6(h6 h6Var, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, s3 s3Var, String str8, String str9, String str10) {
        super(str, str2);
        this.m = h6Var;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = j;
        this.h = str7;
        this.i = s3Var;
        this.j = str8;
        this.k = str9;
        this.l = str10;
    }

    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() {
        String str;
        String strD;
        String strValueOf;
        if (b.g(this.c)) {
            str = ijiami_1011.s.s.s.d(new byte[]{42, 91, 3, 50, Ascii.SYN, 2, 2, 15, 50, 16, 80, 6, 14, 80, Ascii.DC4, 70, 0, 10, 0, 3, 8, 13, 66, 12, Ascii.SYN, 97, Ascii.DC4, 7, 7, 8, 65, 94, 70}, "e5ffdc") + this.d;
            strD = ijiami_1011.s.s.s.d(new byte[]{43, 89, 86, 97, 19, 7, 2, 15, 3, 16}, "d735af");
        } else {
            str = ijiami_1011.s.s.s.d(new byte[]{44, 93, 82, 101, 69, 84, 2, 15, 50, 16, 80, 6, 8, 86, 69, 17, 83, 92, 0, 3, 8, 13, 66, 12, 16, 103, 69, 80, 84, 94, 65, 94, 70}, "c37175") + this.d + ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, Ascii.NAK}, "85949a") + this.c;
            strD = ijiami_1011.s.s.s.d(new byte[]{120, 86, 6, 48, 17, 86, 2, 15, 3, 16}, "78cdc7");
        }
        m.a(strD, str);
        HashMap map = new HashMap();
        map.put(ijiami_1011.s.s.s.d(new byte[]{65, 72, 42, 84}, "48c045"), this.e);
        map.put(ijiami_1011.s.s.s.d(new byte[]{71, 68, 93}, "26101d"), this.f);
        map.put(ijiami_1011.s.s.s.d(new byte[]{88, 5, Ascii.DC2}, "4dfb4f"), Long.valueOf(System.currentTimeMillis() - this.g));
        map.put(ijiami_1011.s.s.s.d(new byte[]{70}, "4c8c50"), this.c);
        map.put(ijiami_1011.s.s.s.d(new byte[]{87, 81, 127, 7}, "656c56"), this.h);
        String strD2 = ijiami_1011.s.s.s.d(new byte[]{19, 13}, "cc1bbd");
        s3 s3Var = this.i;
        map.put(strD2, s3Var != null ? s3Var.b : y8.f5752a.getPackageName());
        map.put(ijiami_1011.s.s.s.d(new byte[]{67, 66, 84, 80, 93, 113, 5}, "705388"), y8.e);
        map.put(ijiami_1011.s.s.s.d(new byte[]{13}, "ccf431"), Integer.valueOf(h9.b(y8.f5752a)));
        String strD3 = ijiami_1011.s.s.s.d(new byte[]{67, 6, 66}, "5c0a98");
        try {
            Field declaredField = y8.f5752a.getClassLoader().loadClass(ijiami_1011.s.s.s.d(new byte[]{90, 90, 15, Ascii.SYN, 11, 91, Ascii.DC4, 13, 72, Ascii.CAN, 84, 16, 74, Ascii.ESC, 15, 81, 11, 93, 79, Ascii.ETB, 2, 9, Ascii.US, 39, 76, 92, 14, 92, 37, 93, 15, 2, 15, 5}, "95b8f2")).getDeclaredField(ijiami_1011.s.s.s.d(new byte[]{50, 119, 48, 102, 44, 42, 47, 59, 40, 35, 124, 32}, "d2b5ee"));
            declaredField.setAccessible(true);
            strValueOf = String.valueOf(declaredField.get(null));
        } catch (Exception e) {
            e.printStackTrace();
            strValueOf = "";
        }
        map.put(strD3, strValueOf);
        map.put(ijiami_1011.s.s.s.d(new byte[]{87, 93, 75}, "54180a"), ijiami_1011.s.s.s.d(new byte[]{94, 12, 85, 14}, "3e8a76"));
        map.put(ijiami_1011.s.s.s.d(new byte[]{91, 74, 3}, "69dbbb"), this.j);
        map.put(ijiami_1011.s.s.s.d(new byte[]{86, 88, 3, 65, Ascii.SYN, 83, 2, 15, 53, 13, 68, Ascii.ETB, 90, 83}, "96f5d2"), ijiami_1011.s.s.s.d(new byte[]{14, 10, 12, 93, 55, 83, 10}, "cca2d7"));
        String str2 = this.k;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Integer.parseInt(str2);
                map.put(ijiami_1011.s.s.s.d(new byte[]{76, 74, 68, 93}, "834829"), Integer.valueOf(Integer.parseInt(this.k)));
            } catch (Exception unused) {
            }
        }
        String str3 = this.l;
        if (!TextUtils.isEmpty(str3)) {
            try {
                Integer.parseInt(str3);
                map.put(ijiami_1011.s.s.s.d(new byte[]{81, 90, 80, 7}, "254bd0"), Integer.valueOf(Integer.parseInt(this.l)));
            } catch (Exception unused2) {
            }
        }
        this.m.f5452a.track(this.d, map);
    }
}
