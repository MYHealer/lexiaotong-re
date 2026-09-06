package com.yfanads.android.adx.components.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.yfanads.ads.R;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseAppActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RelativeLayout f9564a;

    public static void a(Context context) {
        try {
            Toast.makeText(context, context.getString(R.string.yf_download_toast), 0).show();
        } catch (Exception e) {
            YFLog.error(" downLoadToast error" + e.getMessage());
        }
    }

    public abstract void a();

    public abstract void b();

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.yfanads.android.adx.utils.d.b(this);
        com.yfanads.android.adx.utils.d.a(this);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f9564a = relativeLayout;
        setContentView(relativeLayout);
        a();
        b();
    }
}
