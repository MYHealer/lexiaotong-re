package com.miui.zeus.mimo.sdk.ad.nativead.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.imageutils.JfifUtil;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeSixElementsView extends FrameLayout {
    public NativeSixElementsView(Context context) {
        super(context);
        addView(context, (AttributeSet) null);
    }

    public NativeSixElementsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(context, attributeSet);
    }

    public NativeSixElementsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        addView(context, attributeSet);
    }

    public NativeSixElementsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        addView(context, attributeSet);
    }

    private void addView(Context context, AttributeSet attributeSet) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR), this, context, attributeSet});
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR), this, drawable});
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        NCall.IV(new Object[]{223, this, Integer.valueOf(i)});
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        NCall.IV(new Object[]{224, this, Integer.valueOf(i)});
    }

    public void setTextColor(int i) {
        NCall.IV(new Object[]{Integer.valueOf(JfifUtil.MARKER_APP1), this, Integer.valueOf(i)});
    }
}
