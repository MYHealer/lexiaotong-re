package com.yfanads.android.adx.components.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.components.base.i;

/* JADX INFO: compiled from: AdxFullScreenVideoViewHolder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a extends i {
    public final RelativeLayout s;
    public final ImageView t;

    public a(View view) {
        super(view);
        this.t = (ImageView) view.findViewById(R.id.ad_image);
        this.s = (RelativeLayout) view.findViewById(R.id.ad_image_area);
    }
}
