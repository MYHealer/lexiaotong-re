package com.jd.ad.sdk.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.jd.ad.sdk.jad_n_an.jad_n_mz;
import com.jd.ad.sdk.jad_n_an.jad_n_na;
import com.jd.ad.sdk.multi.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class JADNativeWidget {
    private JADNativeWidget() {
    }

    public static Bitmap getJDLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo);
    }

    public static Bitmap getLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo_normal);
    }

    public static View getShakeAnimationView(Context context) {
        return new jad_n_mz(context).getView();
    }

    public static View getSwipeAnimationView(Context context) {
        return new jad_n_na(context).getView();
    }

    public static Bitmap getTextLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.jad_logo_no_ic);
    }

    public static View getShakeAnimationView(Context context, String str) {
        return new jad_n_mz(context, str).getView();
    }
}
