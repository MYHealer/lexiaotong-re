package com.byazt.tm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.byazt.aq.x;
import com.byazt.nr.z;
import com.byazt.or.i;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 1104})
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.byazt.kn.tt {
    @Override // com.byazt.tm.DynamicBaseWidget
    public boolean uj() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.z = new ImageView(context);
        this.z.setTag(5);
        addView(this.z, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().p()) {
            return;
        }
        this.z.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        if (com.byazt.sr.uj.c()) {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.z).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.yp.tt);
        if (com.byazt.sr.uj.c()) {
            Drawable drawableC = com.byazt.or.uj.c(getContext(), this.t);
            if (drawableC == null) {
                return true;
            }
            ((ImageView) this.z).setBackground(drawableC);
            return true;
        }
        ((ImageView) this.z).setBackgroundDrawable(i.c(0, Integer.valueOf(this.t.md()), new int[]{this.x / 2}, null, null, null));
        return true;
    }

    @Override // com.byazt.kn.tt
    public void setSoundMute(boolean z) {
        z.c(getContext(), z ? "tt_mute" : "tt_unmute", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.tm.DynamicMutedView.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                ((ImageView) DynamicMutedView.this.z).setImageDrawable(new BitmapDrawable(DynamicMutedView.this.getContext().getResources(), bitmap));
                if (((ImageView) DynamicMutedView.this.z).getDrawable() != null) {
                    ((ImageView) DynamicMutedView.this.z).getDrawable().setAutoMirrored(true);
                }
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
    }
}
