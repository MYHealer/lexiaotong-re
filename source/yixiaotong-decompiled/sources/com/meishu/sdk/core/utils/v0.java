package com.meishu.sdk.core.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.meishu.sdk.core.AdSdk;
import java.io.File;
import java.lang.ref.SoftReference;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: RequestUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v0 extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoftReference f4953a;

    public v0(SoftReference softReference) {
        this.f4953a = softReference;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            Context context = (Context) this.f4953a.get();
            if (x0.f == null) {
                try {
                    x0.f = context.getResources().getDisplayMetrics();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            DisplayMetrics displayMetrics = x0.f;
            x0.E = x0.e((Context) this.f4953a.get());
            x0.F = x0.j((Context) this.f4953a.get());
            try {
                if (TextUtils.isEmpty(x0.t) && !x0.o()) {
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    File externalFilesDir = AdSdk.getContext().getExternalFilesDir(null);
                    if (externalFilesDir != null) {
                        x0.t = decimalFormat.format(externalFilesDir.getUsableSpace() / 1048576);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            x0.e();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
