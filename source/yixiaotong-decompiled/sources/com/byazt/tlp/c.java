package com.byazt.tlp;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.sa.n;
import com.byazt.xj.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD, 20})
public class c extends ve<UgenGif> {
    public String c;
    public ImageView.ScaleType yo;

    public c(Context context) {
        super(context);
        this.yo = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UgenGif c() {
        this.n = new UgenGif(this.tt);
        ((UgenGif) this.n).c(this);
        return (UgenGif) this.n;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        x();
        ((UgenGif) this.n).setScaleType(this.yo);
    }

    private void x() {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        if (this.c.startsWith("local://")) {
            try {
                z.c(this.tt, this.c.replace("local://", ""), (ImageView) this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        n.c().tt().c(this.i, this.c, (ImageView) this.n, null);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.yo = sl(str2);
        } else if (str.equals(OapsKey.KEY_SRC)) {
            this.c = str2;
        }
    }

    private ImageView.ScaleType sl(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.byazt.xj.ve, com.byazt.sa.uj
    public void n() {
        super.n();
    }

    @Override // com.byazt.xj.ve, com.byazt.sa.uj
    public void c(boolean z) {
        super.c(z);
        if (z) {
            tt();
        }
    }
}
