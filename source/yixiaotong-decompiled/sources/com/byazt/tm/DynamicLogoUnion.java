package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.nr.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 2402})
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.z = new ImageView(context);
        this.z.setTag(Integer.valueOf(getClickArea()));
        if (com.byazt.sr.uj.c()) {
            this.x = Math.max(dynamicRootView.getLogoUnionHeight(), this.x);
        }
        addView(this.z, getWidgetLayoutParams());
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (com.byazt.sr.uj.c()) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        z.c(getContext(), "tt_ad_logo", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicLogoUnion.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                ((ImageView) DynamicLogoUnion.this.z).setImageDrawable(new BitmapDrawable(DynamicLogoUnion.this.getContext().getResources(), bitmap));
                ((ImageView) DynamicLogoUnion.this.z).setColorFilter(DynamicLogoUnion.this.t.sp(), PorterDuff.Mode.SRC_IN);
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        return true;
    }
}
