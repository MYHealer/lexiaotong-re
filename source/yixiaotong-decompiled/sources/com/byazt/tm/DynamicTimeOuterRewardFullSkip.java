package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.nr.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 277})
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.byazt.kn.ve {
    public boolean c;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.c = dynamicRootView.getRenderRequest().z();
        }
        this.sp = this.x;
        this.z = new ImageView(context);
        this.z.setTag(Integer.valueOf(getClickArea()));
        addView(this.z, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().p()) {
            return;
        }
        this.z.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableC = com.byazt.or.uj.c(getContext(), this.t);
        if (drawableC != null) {
            ((ImageView) this.z).setBackground(drawableC);
        }
        if (this.c) {
            z.c(getContext(), "tt_close_btn", (ImageView) this.z, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } else {
            z.c(getContext(), "tt_skip_btn", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicTimeOuterRewardFullSkip.1
                @Override // com.byazt.qr.c
                public void c(Bitmap bitmap) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(DynamicTimeOuterRewardFullSkip.this.getContext().getResources(), bitmap);
                    bitmapDrawable.setAutoMirrored(true);
                    ((ImageView) DynamicTimeOuterRewardFullSkip.this.z).setImageDrawable(bitmapDrawable);
                }
            }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.byazt.kn.ve
    public void c(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
