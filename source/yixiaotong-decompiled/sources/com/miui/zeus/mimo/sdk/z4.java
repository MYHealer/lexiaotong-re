package com.miui.zeus.mimo.sdk;

import android.net.Uri;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class z4 extends g9 {
    public final /* synthetic */ MimoAdInfo c;
    public final /* synthetic */ y4 d;

    public class a implements g5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5758a;

        public a(String str) {
            this.f5758a = str;
        }

        @Override // com.miui.zeus.mimo.sdk.g5.b
        public void a(String str) {
        }

        @Override // com.miui.zeus.mimo.sdk.g5.b
        public void b(String str) throws Throwable {
            if (b.a(str, this.f5758a)) {
                File file = new File(t4.a().c(str, false));
                z4 z4Var = z4.this;
                y4.a(z4Var.d, z4Var.c, file);
            }
        }
    }

    public z4(y4 y4Var, MimoAdInfo mimoAdInfo) {
        this.d = y4Var;
        this.c = mimoAdInfo;
    }

    @Override // com.miui.zeus.mimo.sdk.g9
    public void a() throws Throwable {
        Uri uri = Uri.parse(this.c.w);
        String str = uri.getScheme() + ijiami_1011.s.s.s.d(new byte[]{9, Ascii.RS, 75}, "31dd0d") + uri.getAuthority() + uri.getPath();
        String strC = t4.a().c(str, this.c.F0);
        if (b.h(strC)) {
            y4.a(this.d, this.c, new File(strC));
            return;
        }
        a aVar = new a(str);
        this.d.f5748a.add(aVar);
        t4.a().a(aVar);
        t4.a().a(str, e5.a(this.c));
    }
}
