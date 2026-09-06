package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.PowerManager;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.google.gson.GsonBuilder;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.utils.GsonHolder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import okio.Utf8;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e6 extends g9 {
    public final /* synthetic */ AdEvent c;
    public final /* synthetic */ String d;
    public final /* synthetic */ MimoAdInfo e;
    public final /* synthetic */ n6 f;
    public final /* synthetic */ k6 g;
    public final /* synthetic */ h6 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e6(h6 h6Var, String str, String str2, AdEvent adEvent, String str3, MimoAdInfo mimoAdInfo, n6 n6Var, k6 k6Var) {
        super(str, str2);
        this.h = h6Var;
        this.c = adEvent;
        this.d = str3;
        this.e = mimoAdInfo;
        this.f = n6Var;
        this.g = k6Var;
    }

    /* JADX WARN: Code duplicated, block: B:192:0x0804  */
    /* JADX WARN: Code duplicated, block: B:25:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:86:0x03e6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13, types: [com.xiaomi.onetrack.OneTrack] */
    /* JADX WARN: Type inference failed for: r3v19, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v20, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v21, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v22, types: [java.util.List<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v27, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() {
        String str;
        String str2;
        boolean z;
        ?? r9;
        ?? arrayList;
        String host;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        long j;
        int i;
        int i2;
        int i3;
        String strD;
        m.a(ijiami_1011.s.s.s.d(new byte[]{42, 93, 87, 102, 70, 0, 2, 15, 3, 16}, "e3224a"), ijiami_1011.s.s.s.d(new byte[]{124, 15, 93, 102, Ascii.SYN, 2, 2, 15, 50, 16, 80, 6, 88, 4, 74, Ascii.DC2, 16, 17, 0, 7, 13, 35, 85, 32, 69, 4, 86, 70, 68, 89, 65}, "3a82dc") + this.c.getName());
        HashMap map = new HashMap();
        map.put(ijiami_1011.s.s.s.d(new byte[]{66, 11, 90, 71, 69, 4, 40, 0}, "7e360a"), this.d);
        map.put(ijiami_1011.s.s.s.d(new byte[]{89}, "7bf933"), h9.a(y8.f5752a));
        map.put(ijiami_1011.s.s.s.d(new byte[]{91, 90, 3, 65, 75, 80, 2, 15, 53, 13, 68, Ascii.ETB, 87, 81}, "44f591"), ijiami_1011.s.s.s.d(new byte[]{85, 92, 11, 14, 48, 84, 10}, "85fac0"));
        MimoAdInfo mimoAdInfo = this.e;
        s3 s3Var = mimoAdInfo != null ? mimoAdInfo.e0 : null;
        if (s3Var != null) {
            map.put(ijiami_1011.s.s.s.d(new byte[]{69, 95}, "51291e"), s3Var.b);
            map.put(ijiami_1011.s.s.s.d(new byte[]{4, Ascii.DC4, 85}, "eb67e3"), Integer.valueOf(s3Var.d));
            map.put(ijiami_1011.s.s.s.d(new byte[]{80, 69, 86}, "1382b1"), s3Var.c);
        } else {
            map.put(ijiami_1011.s.s.s.d(new byte[]{70, 15}, "6a169a"), y8.f5752a.getPackageName());
            Context context = y8.f5752a;
            int i4 = f9.f5428a;
            map.put(ijiami_1011.s.s.s.d(new byte[]{0, 67, 80}, "a53b1b"), Integer.valueOf(f9.a(context, context.getPackageName())));
            String strD2 = ijiami_1011.s.s.s.d(new byte[]{5, 66, 90}, "d443ad");
            Context context2 = y8.f5752a;
            PackageInfo packageInfoA = f9.a(context2, context2.getPackageName(), 0);
            map.put(strD2, packageInfoA != null ? packageInfoA.versionName : null);
        }
        n6 n6Var = this.f;
        if (n6Var != null && this.c == AdEvent.CLICK) {
            map.put(ijiami_1011.s.s.s.d(new byte[]{86, 12, 69, 89, 62}, "2c27f2"), Integer.valueOf(n6Var.f5538a));
            map.put(ijiami_1011.s.s.s.d(new byte[]{80, 11, 17, 8, 58}, "4dffc7"), Integer.valueOf(this.f.b));
            map.put(ijiami_1011.s.s.s.d(new byte[]{66, Ascii.NAK, 108}, "7e4982"), Integer.valueOf(this.f.c));
            map.put(ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.NAK, 104}, "5e1e1a"), Integer.valueOf(this.f.d));
            map.put(ijiami_1011.s.s.s.d(new byte[]{65, 10, 5, Ascii.NAK, 91}, "6caa38"), Integer.valueOf(this.f.e));
            map.put(ijiami_1011.s.s.s.d(new byte[]{13, 83, 81, 2, 88, 76}, "e68e08"), Integer.valueOf(this.f.f));
        }
        h6 h6Var = this.h;
        MimoAdInfo mimoAdInfo2 = this.e;
        h6Var.getClass();
        if (mimoAdInfo2 == null) {
            str = null;
        } else {
            str = mimoAdInfo2.c;
            if (TextUtils.isEmpty(str)) {
                str = null;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList2 = new ArrayList();
            HashMap map2 = new HashMap();
            map2.put(ijiami_1011.s.s.s.d(new byte[]{3, 78}, "f620fb"), str);
            arrayList2.add(map2);
            map.put(ijiami_1011.s.s.s.d(new byte[]{3, 93, 99, 16, 86, 87, 10, 45, 8, 4, 94}, "b97b74"), arrayList2);
        }
        h6 h6Var2 = this.h;
        AdEvent adEvent = this.c;
        k6 k6Var = this.g;
        MimoAdInfo mimoAdInfo3 = this.e;
        h6Var2.getClass();
        HashMap map3 = new HashMap();
        if (mimoAdInfo3 != null) {
            map3.put(ijiami_1011.s.s.s.d(new byte[]{67, 83, 85, 66, 94, 88, Ascii.NAK, 1, 50, Ascii.ESC, 65, 0}, "768229"), mimoAdInfo3.p0.trim());
            map3.put(ijiami_1011.s.s.s.d(new byte[]{69, 65, 72, 92, 87}, "65102c"), Integer.valueOf(mimoAdInfo3.s));
            if (mimoAdInfo3.T) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{70, 91, Ascii.DC4, 34, 5, 68, 5, 48, Ascii.US, Ascii.DC2, 84}, "24dad6"), String.valueOf(mimoAdInfo3.w0));
                map3.put(ijiami_1011.s.s.s.d(new byte[]{86, 70, 11, 92, 3, 54, 14, 5, Ascii.NAK, Ascii.SYN, 101, Ascii.FS, 65, 86}, "13b8fb"), b.h(String.valueOf(mimoAdInfo3.z0)) ? String.valueOf(mimoAdInfo3.z0) : null);
            }
            map3.put(ijiami_1011.s.s.s.d(new byte[]{69, 14, 84, 73, 83, Ascii.ETB, 53, Ascii.GS, Ascii.SYN, 7}, "5b506e"), mimoAdInfo3.U);
        }
        if (k6Var != null) {
            i6 i6Var = k6Var.f5509a;
            if (i6Var != null) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{2, 8, 89, 90, 13, 105, 0, 3, 3, 54, 72, Ascii.NAK, 4}, "ad09f9"), i6Var.f5462a);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{81, 92, 81, 2, 93, 33, Ascii.ETB, 1, 8, Ascii.SYN, 101, Ascii.FS, 66, 85}, "208a6d"), i6Var.b);
                ClickAreaType clickAreaType = i6Var.c;
                if (clickAreaType != null && mimoAdInfo3 != null) {
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{5, 15, 10, 83, 83, 114, 19, 1, 7}, "fcc083"), clickAreaType.getTag());
                    ClickEventType clickEventTypeA = mimoAdInfo3.a(clickAreaType);
                    if (clickEventTypeA == ClickEventType.DEFAULT) {
                        i3 = 0;
                        strD = ijiami_1011.s.s.s.d(new byte[]{93, 65, 117, Ascii.SYN, Ascii.SYN, 10, 37, 11, 17, 12, 93, 10, 85, 86, 117, 17, 7, 4}, "424cbe");
                    } else if (clickEventTypeA == ClickEventType.CLICK_AUTO_DOWNLOAD) {
                        i3 = 1;
                        strD = ijiami_1011.s.s.s.d(new byte[]{95, Ascii.DC2, 121, 65, Ascii.SYN, 95, 37, 11, 17, 12, 93, 10, 87, 5, 121, 70, 7, 81}, "6a84b0");
                    } else if (clickEventTypeA == ClickEventType.CLICK_NO_AUTO_DOWNLOAD) {
                        map3.put(ijiami_1011.s.s.s.d(new byte[]{95, 75, 113, 68, Ascii.DC2, 87, 37, 11, 17, 12, 93, 10, 87, 92, 113, 67, 3, 89}, "6801f8"), 2);
                    }
                    map3.put(strD, i3);
                }
                j6 j6Var = i6Var.d;
                if (j6Var != null) {
                    HashMap<String, m6> map4 = j6Var.b;
                    if (map4 != null && !map4.isEmpty()) {
                        for (Map.Entry<String, m6> entry : j6Var.b.entrySet()) {
                            h6Var2.a(map3, entry.getKey(), entry.getValue());
                        }
                    }
                    h6Var2.a(map3, ijiami_1011.s.s.s.d(new byte[]{93, 13, 68, 15, 92, 94, 0, 0, 36, Ascii.SYN, 95, 44, 87, 4, 92}, "9b3a01"), j6Var.f5500a);
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{83, 14, 10, 5, 14, 109}, "0bcfe5"), Integer.valueOf(j6Var.c));
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{80, 89, 90, 87, 14, 104}, "3534e1"), Integer.valueOf(j6Var.d));
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{66, 94, 1, SignedBytes.MAX_POWER_OF_TWO, 83, 87, 13, 1, 39, 16, 84, 4}, "47d725"), j6Var.e);
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{93, Ascii.SYN, 42, 91, 16, 84, Ascii.DC4, Ascii.SYN, 3, 6}, "4ee9c7"), j6Var.f);
                    if (b.h(j6Var.g)) {
                        map3.put(ijiami_1011.s.s.s.d(new byte[]{84, Ascii.ETB, 15, 102, 86, Ascii.GS, Ascii.NAK}, "6ca23e"), j6Var.g);
                    }
                }
                if (clickAreaType != null) {
                    String strD3 = ijiami_1011.s.s.s.d(new byte[]{50, 126, 124}, "a28fd5");
                    l6 l6Var = k6Var.k;
                    int iOrdinal = clickAreaType.ordinal();
                    if (iOrdinal == 28 || iOrdinal == 36) {
                        i2 = 1;
                    } else {
                        if (iOrdinal != 33) {
                            if (iOrdinal == 34) {
                                i2 = 1;
                            }
                        } else if (l6Var != null && b.a(l6Var.i, ijiami_1011.s.s.s.d(new byte[]{97, 12, 88, 13, 4}, "2d9fac"))) {
                            i2 = 2;
                        } else if (l6Var != null) {
                            i2 = 5;
                        }
                        i2 = 0;
                    }
                    map3.put(strD3, Integer.valueOf(i2));
                }
            }
            o6 o6Var = k6Var.b;
            if (o6Var != null) {
                HashMap<String, m6> map5 = o6Var.b;
                if (map5 != null && !map5.isEmpty()) {
                    for (Map.Entry<String, m6> entry2 : o6Var.b.entrySet()) {
                        h6Var2.a(map3, entry2.getKey(), entry2.getValue());
                    }
                }
                h6Var2.a(map3, ijiami_1011.s.s.s.d(new byte[]{93, 87, Ascii.DC4, 91, 93, 11, 0, 0, 36, Ascii.SYN, 95, 44, 87, 94, 12}, "98c51d"), o6Var.f5550a);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 95, 82, 19, 89, 87, 13, 1, 39, 16, 84, 4}, "d67d85"), o6Var.c);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{81, Ascii.ETB, 127, 80, Ascii.SYN, 80, Ascii.DC4, Ascii.SYN, 3, 6}, "8d02e3"), o6Var.d);
            }
            String str3 = k6Var.c;
            if (!TextUtils.isEmpty(str3)) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{70, 90, 83, 93, 90, 125, 15, 8, 15, 12, 84, 41, 95, 82, 83, 81, 91, 85}, "037852"), Boolean.valueOf(b.a(str3, false)));
            }
            String str4 = k6Var.h;
            if (!TextUtils.isEmpty(str4)) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{71, 81, 67, 5, 70, 82, 38, 1, Ascii.DC2, 54, 72, Ascii.NAK, 80}, "544d46"), Integer.valueOf(b.a(str4, 0)));
            }
            String str5 = k6Var.g;
            if (!TextUtils.isEmpty(str5)) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 89, 3, Ascii.ESC, 98, 89, 12, 1}, "f5bb60"), Integer.valueOf(b.a(str5, 0)));
            }
            Map<String, Long> map6 = k6Var.d;
            if (map6 != null && !map6.isEmpty()) {
                Long l = map6.get(ijiami_1011.s.s.s.d(new byte[]{126, 123, 118, 113, 125, 97, 53, 59, 42, 45, 98, 54, 105, 98, 99, 112, 123, 119}, "621982"));
                if (l != null) {
                    k6Var.f = String.valueOf(l);
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{85, 13, 92, 49, 93, 89, 41, 13, 1, 10, 84, Ascii.SYN, 67, 40, 87, Ascii.NAK, 71, 103, 19, 13, 5, 7}, "7d8f47"), l);
                }
                Long l2 = map6.get(ijiami_1011.s.s.s.d(new byte[]{115, 62, 104, 116, 123, 49, 62, 39, 41, 49, 101, 58, 102, 52, 113, 114, 125}, "6f818e"));
                if (l2 != null) {
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{3, 13, 1, 97, 88, 87, 49, Ascii.SYN, 15, 1, 84}, "ade619"), l2);
                }
            }
            Map<String, Object> map7 = k6Var.e;
            if (map7 != null && !map7.isEmpty()) {
                Object obj = map7.get(ijiami_1011.s.s.s.d(new byte[]{102, 40, 121, 104, 51, 102, 40, 39, 35}, "1a77c4"));
                if (obj instanceof Long) {
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{0, 93, 93, 41, 92, 74, Ascii.DC2, 51, 15, 12, 97, Ascii.ETB, 11, 87, 92}, "b49e39"), obj);
                }
                Object obj2 = map7.get(ijiami_1011.s.s.s.d(new byte[]{124, 127, 98, 106, 59, 103, 36, 37, 53, 45, 127}, "0019d5"));
                if (obj2 instanceof String) {
                    String str6 = (String) obj2;
                    k6Var.j = ijiami_1011.s.s.s.d(new byte[]{85, 81, 8}, "da8a45");
                    k6Var.i = ijiami_1011.s.s.s.d(new byte[]{-36, -80, -114, -44, -103, -78, -124, -22, -7, -121, -86, -59, Ascii.NAK, Ascii.NAK}, "958171") + str6;
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{6, 89, 5, 122, 13, 70, Ascii.DC2, 54, 3, 3, 66, 10, 10, 115, 14, 82, 7}, "d0a6b5"), ijiami_1011.s.s.s.d(new byte[]{7, 0, 1}, "6018e1"));
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{86, 10, 82, 124, 10, 74, Ascii.DC2, 54, 3, 3, 66, 10, 90, 46, 69, 87}, "4c60e9"), ijiami_1011.s.s.s.d(new byte[]{-128, -74, -123, -48, -118, -9, -124, -22, -7, -121, -86, -59, 73}, "e3341a") + str6);
                } else if (obj2 instanceof t3) {
                    t3 t3Var = (t3) obj2;
                    k6Var.j = String.valueOf(t3Var.f5612a);
                    k6Var.i = t3Var.b;
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{85, 11, 86, 46, 91, Ascii.NAK, Ascii.DC2, 54, 3, 3, 66, 10, 89, 33, 93, 6, 81}, "7b2b4f"), Integer.valueOf(t3Var.f5612a));
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{86, 13, 7, 41, 93, 67, Ascii.DC2, 54, 3, 3, 66, 10, 90, 41, 16, 2}, "4dce20"), t3Var.b);
                }
                Object obj3 = map7.get(ijiami_1011.s.s.s.d(new byte[]{116, 39, 40, 110, 122, 38}, "5cf13b"));
                if (obj3 instanceof Integer) {
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{7, 13, 7, 123, 9, 68, Ascii.DC2, 37, 2, 12, 120, 1}, "edc7f7"), obj3);
                }
            }
            String str7 = k6Var.j;
            if (!TextUtils.isEmpty(str7)) {
                map3.put(ijiami_1011.s.s.s.d(new byte[]{2, 87, 93, 3}, "a89f9d"), str7);
            }
            map3.put(ijiami_1011.s.s.s.d(new byte[]{88, Ascii.NAK, 3}, "5fda27"), k6Var.i);
            str2 = k6Var.f;
            l6 l6Var2 = k6Var.k;
            if (l6Var2 != null) {
                String str8 = l6Var2.f5521a;
                if (TextUtils.isEmpty(str8)) {
                    i = 7;
                } else {
                    i = 7;
                    map3.put(ijiami_1011.s.s.s.d(new byte[]{74, 41, 88, 74, 120, 87, 2}, "2d9294"), str8);
                }
                String str9 = l6Var2.b;
                if (!TextUtils.isEmpty(str9)) {
                    byte[] bArr = new byte[i];
                    // fill-array-data instruction
                    bArr[0] = 75;
                    bArr[1] = 120;
                    bArr[2] = 5;
                    bArr[3] = 64;
                    bArr[4] = 37;
                    bArr[5] = 91;
                    bArr[6] = 2;
                    map3.put(ijiami_1011.s.s.s.d(bArr, "25d8d8"), str9);
                }
                if (!TextUtils.isEmpty(l6Var2.c)) {
                    byte[] bArr2 = new byte[i];
                    // fill-array-data instruction
                    bArr2[0] = 72;
                    bArr2[1] = 124;
                    bArr2[2] = 3;
                    bArr2[3] = 64;
                    bArr2[4] = 118;
                    bArr2[5] = 1;
                    bArr2[6] = 2;
                    map3.put(ijiami_1011.s.s.s.d(bArr2, "21b87b"), str8);
                }
                map3.put(ijiami_1011.s.s.s.d(new byte[]{72, 112, 95, 1, 91, 83}, "011f76"), l6Var2.d);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 119, 90, 82, 94, 92}, "f64529"), l6Var2.e);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{Ascii.FS, 35, 91, 80, 92, 85}, "fb5700"), l6Var2.f);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{85, 90, 7, 81, 92, 82, 19, 5, Ascii.DC2, 11, 94, 11}, "49d407"), l6Var2.g);
                map3.put(ijiami_1011.s.s.s.d(new byte[]{77, 68, Ascii.SYN, 87, 98, 8, 12, 1}, "91d96a"), Long.valueOf(l6Var2.h));
            }
        } else {
            str2 = null;
        }
        if (mimoAdInfo3 != null && adEvent == AdEvent.CLICK) {
            map3.put(ijiami_1011.s.s.s.d(new byte[]{81, 94, 81, 6, 9, 87, 3, 8, 3, 35, 67, 0, 83, 126, 81, Ascii.SYN, Ascii.SYN}, "228eb6"), mimoAdInfo3.Y);
            map3.put(ijiami_1011.s.s.s.d(new byte[]{89, 9, 93, 37, 70, 76, 14, 32, 9, Ascii.NAK, 95, 9, 88, 7, 87, 37, 65, 93, 0, 40, 15, 17, 69}, "7f3d38"), mimoAdInfo3.Z);
            map3.put(ijiami_1011.s.s.s.d(new byte[]{12, 80, 86, 103, 89, 85, Ascii.SYN}, "d12100"), Boolean.valueOf(mimoAdInfo3.V));
        }
        String strD4 = ijiami_1011.s.s.s.d(new byte[]{81, 69, 55, 90, 70, 81, 4, 10, 41, 4, 87}, "86d944");
        Context context3 = y8.f5752a;
        int i5 = f9.f5428a;
        try {
            z = !((PowerManager) context3.getSystemService(ijiami_1011.s.s.s.d(new byte[]{69, 89, Ascii.SYN, 4, Ascii.SYN}, "56aad3"))).isScreenOn();
        } catch (Exception unused) {
            z = false;
        }
        map3.put(strD4, Boolean.valueOf(z));
        if (b.h("")) {
            map3.put(ijiami_1011.s.s.s.d(new byte[]{3, 70, 10, 93, 53, 95, Ascii.DC4, Ascii.SYN, 5, 7}, "e4e0f0"), "");
        }
        if (!map3.isEmpty()) {
            String strD5 = ijiami_1011.s.s.s.d(new byte[]{9, 95, 85, 98, 69, 5, 2, 15, 54, 3, 67, 4, 11, 66}, "f1067d");
            if (GsonHolder.f5639a == null) {
                synchronized (GsonHolder.class) {
                    if (GsonHolder.f5639a == null) {
                        GsonHolder.f5639a = new GsonBuilder().registerTypeAdapter(GsonHolder.IntegerDeserializer.class, new GsonHolder.IntegerDeserializer()).create();
                    }
                }
            }
            map.put(strD5, GsonHolder.f5639a.toJson(map3));
        }
        if (!TextUtils.isEmpty(str2)) {
            String strD6 = ijiami_1011.s.s.s.d(new byte[]{0, 88, 86, 97, 65, 94, 2, 1}, "b12137");
            if (TextUtils.isEmpty(str2)) {
                j = 0;
            } else {
                try {
                    j = Long.parseLong(str2);
                } catch (Exception unused2) {
                    j = 0;
                }
            }
            map.put(strD6, Long.valueOf(j));
        }
        MimoAdInfo mimoAdInfo4 = this.e;
        if (mimoAdInfo4 != null) {
            AdEvent adEvent2 = this.c;
            if (adEvent2 == AdEvent.CLICK) {
                h6 h6Var3 = this.h;
                n6 n6Var2 = this.f;
                l6 l6Var3 = this.g.k;
                List<String> list = mimoAdInfo4.K;
                h6Var3.getClass();
                if (list == null) {
                    arrayList = 0;
                } else {
                    arrayList = new ArrayList();
                    for (int i6 = 0; i6 < list.size(); i6++) {
                        String strReplace = list.get(i6);
                        if (!TextUtils.isEmpty(strReplace)) {
                            Context context4 = y8.f5752a;
                            if (!TextUtils.isEmpty(strReplace)) {
                                String strD7 = ijiami_1011.s.s.s.d(new byte[]{71, 2, 113, 103, 124, 125, 53, 44, 67, 85, 117}, "b53059");
                                if (n6Var2 != null) {
                                    float f17 = n6Var2.e;
                                    int i7 = f9.f5428a;
                                    f = f17 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f = -999.0f;
                                }
                                String strReplace2 = strReplace.replace(strD7, String.valueOf(f));
                                String strD8 = ijiami_1011.s.s.s.d(new byte[]{67, 99, 121, 115, 53, 124, Ascii.FS}, "8407a4");
                                if (n6Var2 != null) {
                                    float f18 = n6Var2.e;
                                    int i8 = f9.f5428a;
                                    f2 = f18 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f2 = -999.0f;
                                }
                                String strReplace3 = strReplace2.replace(strD8, String.valueOf(f2));
                                String strD9 = ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 83, 118, 112, 114, 123, 38, 44, 50, 71, 6, 33}, "ed4872");
                                if (n6Var2 != null) {
                                    float f19 = n6Var2.f;
                                    int i9 = f9.f5428a;
                                    f3 = f19 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f3 = -999.0f;
                                }
                                String strReplace4 = strReplace3.replace(strD9, String.valueOf(f3));
                                String strD10 = ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 126, 112, 40, 118, 123, 53, Ascii.EM}, "d65a13");
                                if (n6Var2 != null) {
                                    float f20 = n6Var2.f;
                                    int i10 = f9.f5428a;
                                    f4 = f20 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f4 = -999.0f;
                                }
                                String strReplace5 = strReplace4.replace(strD10, String.valueOf(f4));
                                String strD11 = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 82, 117, 113, 33, 107, 68, 83, 34}, "1e70e3");
                                if (n6Var2 != null) {
                                    float f21 = n6Var2.g;
                                    int i11 = f9.f5428a;
                                    f5 = f21 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f5 = -999.0f;
                                }
                                String strReplace6 = strReplace5.replace(strD11, String.valueOf(f5));
                                String strD12 = ijiami_1011.s.s.s.d(new byte[]{74, 37, 124, 108, Ascii.CAN}, "1d84e1");
                                if (n6Var2 != null) {
                                    float f22 = n6Var2.g;
                                    int i12 = f9.f5428a;
                                    f6 = f22 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f6 = -999.0f;
                                }
                                String strReplace7 = strReplace6.replace(strD12, String.valueOf(f6));
                                String strD13 = ijiami_1011.s.s.s.d(new byte[]{65, 81, 123, 115, 124, 58, 68, 83, 34}, "df928c");
                                if (n6Var2 != null) {
                                    float f23 = n6Var2.h;
                                    int i13 = f9.f5428a;
                                    f7 = f23 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f7 = -999.0f;
                                }
                                String strReplace8 = strReplace7.replace(strD13, String.valueOf(f7));
                                String strD14 = ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 121, 33, 104, Ascii.FS}, "f8e1a7");
                                if (n6Var2 != null) {
                                    float f24 = n6Var2.h;
                                    int i14 = f9.f5428a;
                                    f8 = f24 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f8 = -999.0f;
                                }
                                String strReplace9 = strReplace8.replace(strD14, String.valueOf(f8));
                                String strD15 = ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 85, 36, 33, 127, 49, 47, 60, 67, 85, 117}, "ebfe0f");
                                if (n6Var2 != null) {
                                    float f25 = n6Var2.f5538a;
                                    int i15 = f9.f5428a;
                                    f9 = f25 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f9 = -999.0f;
                                }
                                String strReplace10 = strReplace9.replace(strD15, String.valueOf(f9));
                                String strD16 = ijiami_1011.s.s.s.d(new byte[]{77, 118, 119, 101, 47, 57, Ascii.FS}, "6282aa");
                                if (n6Var2 != null) {
                                    float f26 = n6Var2.f5538a;
                                    int i16 = f9.f5428a;
                                    f10 = f26 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f10 = -999.0f;
                                }
                                String strReplace11 = strReplace10.replace(strD16, String.valueOf(f10));
                                String strD17 = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 14, 122, 112, 121, 96, 47, Base64.padSymbol, 67, 85, 117}, "798467");
                                if (n6Var2 != null) {
                                    float f27 = n6Var2.b;
                                    int i17 = f9.f5428a;
                                    f11 = f27 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f11 = -999.0f;
                                }
                                String strReplace12 = strReplace11.replace(strD17, String.valueOf(f11));
                                String strD18 = ijiami_1011.s.s.s.d(new byte[]{78, 113, 41, 99, 125, 110, Ascii.FS}, "55f437");
                                if (n6Var2 != null) {
                                    float f28 = n6Var2.b;
                                    int i18 = f9.f5428a;
                                    f12 = f28 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f12 = -999.0f;
                                }
                                String strReplace13 = strReplace12.replace(strD18, String.valueOf(f12));
                                String strD19 = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 85, 36, 98, 97, 58, 68, 83, 34}, "1bf71b");
                                if (n6Var2 != null) {
                                    float f29 = n6Var2.c;
                                    int i19 = f9.f5428a;
                                    f13 = f29 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f13 = -999.0f;
                                }
                                String strReplace14 = strReplace13.replace(strD19, String.valueOf(f13));
                                String strD20 = ijiami_1011.s.s.s.d(new byte[]{74, 97, 101, Base64.padSymbol, 75}, "145e65");
                                if (n6Var2 != null) {
                                    float f30 = n6Var2.c;
                                    int i20 = f9.f5428a;
                                    f14 = f30 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f14 = -999.0f;
                                }
                                String strReplace15 = strReplace14.replace(strD20, String.valueOf(f14));
                                String strD21 = ijiami_1011.s.s.s.d(new byte[]{19, 2, 36, 103, 50, 58, 68, 83, 34}, "65f2bc");
                                if (n6Var2 != null) {
                                    float f31 = n6Var2.d;
                                    int i21 = f9.f5428a;
                                    f15 = f31 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f15 = -999.0f;
                                }
                                String strReplace16 = strReplace15.replace(strD21, String.valueOf(f15)).replace(ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, 110, 57, 120, 114, 111, 62, 37, 37, 33, 76}, "c6f537"), String.valueOf(l6Var3 != null ? b.f(l6Var3.f5521a) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 86, 123, 104, Base64.padSymbol, 44, 32, 60, 57, 35, 114, 38, Ascii.SYN, 86, 125}, "3a90ba"), String.valueOf(l6Var3 != null ? b.f(l6Var3.f5521a) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{67, 56, 57, 40, 34, 97, 62, 37, 37, 33, 76}, "8afec9"), String.valueOf(l6Var3 != null ? b.f(l6Var3.b) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{16, 6, 39, 105, 109, 116, 32, 60, 57, 35, 114, 38, 16, 6, 33}, "51e029"), String.valueOf(l6Var3 != null ? b.f(l6Var3.b) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{76, 56, 106, 124, 32, 105, 62, 37, 37, 33, 76}, "7b51a1"), String.valueOf(l6Var3 != null ? b.f(l6Var3.c) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{65, 2, 114, Utf8.REPLACEMENT_BYTE, 108, 125, 32, 60, 57, 35, 114, 38, 65, 2, 116}, "d50e30"), String.valueOf(l6Var3 != null ? b.f(l6Var3.c) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{75, 103, 101, 49, 127, 107, 57, Ascii.EM}, "030c14"), String.valueOf(l6Var3 != null ? b.d(l6Var3.d) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 2, 115, 100, 98, 107, 47, 59, 62, 71, 6, 33}, "051079"), String.valueOf(l6Var3 != null ? b.d(l6Var3.d) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{78, 97, 99, 51, 125, 107, 56, Ascii.EM}, "556a34"), String.valueOf(l6Var3 != null ? b.d(l6Var3.e) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{19, 6, 122, 109, 98, 98, 47, 59, Utf8.REPLACEMENT_BYTE, 71, 6, 33}, "618970"), String.valueOf(l6Var3 != null ? b.d(l6Var3.e) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{66, 108, 101, 55, 40, 60, 59, Ascii.EM}, "980efc"), String.valueOf(l6Var3 != null ? b.d(l6Var3.f) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 83, 112, 103, 100, 106, 47, 59, 60, 71, 6, 33}, "8d2318"), String.valueOf(l6Var3 != null ? b.d(l6Var3.f) : -999)).replace(ijiami_1011.s.s.s.d(new byte[]{78, 98, 102, 55, 120, 59, 53, 45, 43, 39, 76}, "563e6d"), String.valueOf(l6Var3 != null ? l6Var3.h : -999L)).replace(ijiami_1011.s.s.s.d(new byte[]{70, 4, 38, 108, 100, 52, 47, 59, 50, 43, 124, 32, 70, 4, 32}, "c3d81f"), String.valueOf(l6Var3 != null ? l6Var3.h : -999L)).replace(ijiami_1011.s.s.s.d(new byte[]{79, 96, 117, 116, Ascii.US}, "4390b7"), String.valueOf(b.a(l6Var3))).replace(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 83, 113, 106, 122, 116, 68, 83, 34}, "3d3960"), String.valueOf(b.a(l6Var3)));
                                String strD22 = ijiami_1011.s.s.s.d(new byte[]{76, 51, 102, 110, 72}, "7f6758");
                                if (n6Var2 != null) {
                                    float f32 = n6Var2.d;
                                    int i22 = f9.f5428a;
                                    f16 = f32 / context4.getResources().getDisplayMetrics().density;
                                } else {
                                    f16 = -999.0f;
                                }
                                strReplace = strReplace16.replace(strD22, String.valueOf(f16));
                            }
                            arrayList.add(strReplace);
                        }
                    }
                }
            } else if (adEvent2 == AdEvent.VIEW) {
                arrayList = mimoAdInfo4.J;
            } else if (adEvent2 == AdEvent.VIDEO_START) {
                arrayList = mimoAdInfo4.L;
            } else if (adEvent2 == AdEvent.VIDEO_PAUSE) {
                arrayList = mimoAdInfo4.M;
            } else if (adEvent2 == AdEvent.VIDEO_FINISH) {
                arrayList = mimoAdInfo4.N;
            } else {
                arrayList = 0;
            }
            if (arrayList == 0 || arrayList.isEmpty()) {
                r9 = arrayList;
            } else {
                String str10 = this.d;
                HashMap map8 = new HashMap();
                map8.put(ijiami_1011.s.s.s.d(new byte[]{65, 91, 70, 16, 0, 93}, "243bc8"), ijiami_1011.s.s.s.d(new byte[]{86, 8, 0, Ascii.ETB, 75, 5, 2, 15}, "9fec9d"));
                map8.put(ijiami_1011.s.s.s.d(new byte[]{68, 11, 88, Ascii.DC2, 65, 84, 40, 0}, "1e1c41"), str10);
                ArrayList arrayList3 = new ArrayList();
                for (String strA : arrayList) {
                    if (strA != null) {
                        try {
                            host = Uri.parse(strA).getHost();
                        } catch (Exception unused3) {
                            host = null;
                        }
                        if (host != null && (TextUtils.equals(ijiami_1011.s.s.s.d(new byte[]{91, 89, 15, 81, Ascii.DC2, 93, 19, 73, 5, 10, 84, 6, 93, Ascii.CAN, 0, 92, 72, 74, 8, 5, 9, 15, 88, 75, 85, 89, 12}, "66a8f2"), host) || TextUtils.equals(ijiami_1011.s.s.s.d(new byte[]{74, 16, 4, 3, 13, 10, 6, 73, 11, 13, 95, 12, 77, 11, Ascii.ETB, 73, 7, 12, 4, 7, 13, 76, 80, 1, Ascii.ETB, Ascii.FS, 12, 5, 11, 9, 8, 74, 5, 13, 92}, "9deddd"), host))) {
                            strA = b.a(strA, map8);
                        }
                    }
                    arrayList3.add(strA);
                }
                r9 = arrayList3;
            }
        } else {
            r9 = 0;
        }
        if (r9 == 0 || r9.isEmpty()) {
            this.h.f5452a.adTrack(this.c.getName(), map);
        } else {
            this.h.f5452a.adTrack(this.c.getName(), map, r9);
        }
    }
}
