package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.splash.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSSplashTwistView extends PPSBaseTwistView {
    public PPSSplashTwistView(Context context) {
        super(context);
        Code(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public PPSSplashTwistView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        String str;
        fh.V("PPSSplashTwistView", "init");
        try {
            this.Code = inflate(context, R.layout.hiad_layout_splash_twist, this);
            this.F = (ImageView) this.Code.findViewById(R.id.hiad_phone_jpg);
            this.V = (TextView) this.Code.findViewById(R.id.hiad_twist_string);
            this.I = (TextView) this.Code.findViewById(R.id.hiad_twist_desc);
        } catch (RuntimeException unused) {
            str = "init RuntimeException";
            fh.I("PPSSplashTwistView", str);
        } catch (Exception unused2) {
            str = "init error";
            fh.I("PPSSplashTwistView", str);
        }
    }
}
