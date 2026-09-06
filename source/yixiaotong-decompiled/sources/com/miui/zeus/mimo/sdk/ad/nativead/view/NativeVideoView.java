package com.miui.zeus.mimo.sdk.ad.nativead.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.d7;
import com.miui.zeus.mimo.sdk.i;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeVideoView extends FrameLayout implements d7 {
    private MimoMediaView mMimoMediaView;
    private OnVideoListener mVideoListener;

    public interface OnVideoListener {
        void onVideoEnd();

        void onVideoError();

        void onVideoPause();

        void onVideoProgressUpdate(int i, int i2);

        void onVideoResume();

        void onVideoStart();

        void onVolumeChanged(boolean z);
    }

    public NativeVideoView(Context context) {
        super(context);
        addView(context, (AttributeSet) null);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        addView(context, attributeSet);
    }

    public NativeVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        addView(context, attributeSet);
    }

    private void addView(Context context, AttributeSet attributeSet) {
        NCall.IV(new Object[]{193, this, context, attributeSet});
    }

    public boolean isMute() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY), this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onCreateViewSuccess(i iVar) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO), this, iVar});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicEnd() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicMode() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY), this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoEnd() {
        NCall.IV(new Object[]{198, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoError() {
        NCall.IV(new Object[]{199, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoPause() {
        NCall.IV(new Object[]{200, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoProgressUpdate(int i, int i2) {
        NCall.IV(new Object[]{201, this, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoResume() {
        NCall.IV(new Object[]{202, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoStart() {
        NCall.IV(new Object[]{203, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVolumeChanged(boolean z) {
        NCall.IV(new Object[]{204, this, Boolean.valueOf(z)});
    }

    public void pause() {
        NCall.IV(new Object[]{205, this});
    }

    public void release() {
        NCall.IV(new Object[]{206, this});
    }

    public void resume() {
        NCall.IV(new Object[]{207, this});
    }

    public void setMute(boolean z) {
        NCall.IV(new Object[]{208, this, Boolean.valueOf(z)});
    }

    public void setVideoListener(OnVideoListener onVideoListener) {
        NCall.IV(new Object[]{209, this, onVideoListener});
    }
}
