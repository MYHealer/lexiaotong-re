package com.jd.ad.sdk.jad_py;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.jd.ad.sdk.jad_qz.jad_iv;
import com.jd.ad.sdk.jad_xg.jad_dq;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public final AssetManager jad_dq;
    public com.jd.ad.sdk.jad_lu.jad_an jad_er;
    public final jad_iv<String> jad_an = new jad_iv<>();
    public final Map<jad_iv<String>, Typeface> jad_bo = new HashMap();
    public final Map<String, Typeface> jad_cp = new HashMap();
    public String jad_fs = ".ttf";

    public jad_an(Drawable.Callback callback, com.jd.ad.sdk.jad_lu.jad_an jad_anVar) {
        AssetManager assets;
        this.jad_er = jad_anVar;
        if (callback instanceof View) {
            assets = ((View) callback).getContext().getAssets();
        } else {
            jad_dq.jad_an("LottieDrawable must be inside of a view for images to work.");
            assets = null;
        }
        this.jad_dq = assets;
    }
}
