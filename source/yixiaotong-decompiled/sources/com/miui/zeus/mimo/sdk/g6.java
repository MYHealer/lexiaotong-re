package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import java.util.HashMap;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g6 extends g9 {
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ h6 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g6(h6 h6Var, String str, String str2, String str3, String str4) {
        super(str, str2);
        this.e = h6Var;
        this.c = str3;
        this.d = str4;
    }

    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() {
        HashMap map = new HashMap();
        map.put(ijiami_1011.s.s.s.d(new byte[]{12, 86, 16, 67, 88, 13, 13, 1, 2, 35, 65, Ascii.NAK, 41, 81, 16, 67}, "e8c79a"), this.c);
        map.put(ijiami_1011.s.s.s.d(new byte[]{67, 92, 71}, "595599"), this.d);
        this.e.f5452a.track(ijiami_1011.s.s.s.d(new byte[]{35, 49, 102, Base64.padSymbol, 43, 122, 50, 48, 39, 46, 125, 32, 38, 62, 122, 43, 49, 96}, "ba6bb4"), map);
    }
}
