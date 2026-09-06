package com.miui.zeus.mimo.sdk.ad.nativead;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.ad.nativead.view.DirectDownloadView;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeSixElementsView;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeVideoView;
import ijiami_1011.NCall;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeAdViewBinder {
    private TextView adLogoView;
    private ImageView appIconView;
    private View closeBtnView;
    private View customVideoView;
    private View[] customView;
    private TextView descView;
    private DirectDownloadView directDownloadView;
    private ImageView imageView;
    private List<ImageView> imageViews;
    private NativeSixElementsView sixElementsView;
    private TextView titleView;
    private NativeVideoView videoView;

    public static final class Builder {
        private TextView adLogoView;
        private ImageView appIconView;
        private View closeBtnView;
        private View customVideoView;
        private View[] customView;
        private TextView descView;
        private DirectDownloadView directDownloadView;
        private ImageView imageView;
        private List<ImageView> imageViews;
        private NativeSixElementsView sixElementsView;
        private TextView titleView;
        private NativeVideoView videoView;

        public NativeAdViewBinder build() {
            return (NativeAdViewBinder) NCall.IL(new Object[]{Integer.valueOf(Opcodes.FCMPL), this});
        }

        public Builder setAdLogoView(TextView textView) {
            return (Builder) NCall.IL(new Object[]{150, this, textView});
        }

        public Builder setAppIcon(ImageView imageView) {
            return (Builder) NCall.IL(new Object[]{151, this, imageView});
        }

        public Builder setCloseView(View view) {
            return (Builder) NCall.IL(new Object[]{152, this, view});
        }

        public Builder setCustomView(View... viewArr) {
            if (viewArr != null && viewArr.length > 0) {
                this.customView = viewArr;
            }
            return this;
        }

        public Builder setDescView(TextView textView) {
            return (Builder) NCall.IL(new Object[]{153, this, textView});
        }

        public Builder setDirectDownloadView(DirectDownloadView directDownloadView) {
            return (Builder) NCall.IL(new Object[]{154, this, directDownloadView});
        }

        public Builder setImageView(ImageView imageView) {
            return (Builder) NCall.IL(new Object[]{155, this, imageView});
        }

        public Builder setImageViews(List<ImageView> list) {
            return (Builder) NCall.IL(new Object[]{156, this, list});
        }

        public Builder setSixElementsView(NativeSixElementsView nativeSixElementsView) {
            return (Builder) NCall.IL(new Object[]{157, this, nativeSixElementsView});
        }

        public Builder setTitleView(TextView textView) {
            return (Builder) NCall.IL(new Object[]{158, this, textView});
        }

        public Builder setVideoView(View view) {
            return (Builder) NCall.IL(new Object[]{159, this, view});
        }

        public Builder setVideoView(NativeVideoView nativeVideoView) {
            return (Builder) NCall.IL(new Object[]{160, this, nativeVideoView});
        }
    }

    public NativeAdViewBinder(Builder builder) {
        this.closeBtnView = builder.closeBtnView;
        this.adLogoView = builder.adLogoView;
        this.directDownloadView = builder.directDownloadView;
        this.sixElementsView = builder.sixElementsView;
        this.titleView = builder.titleView;
        this.descView = builder.descView;
        this.appIconView = builder.appIconView;
        this.videoView = builder.videoView;
        this.imageView = builder.imageView;
        this.imageViews = builder.imageViews;
        this.customVideoView = builder.customVideoView;
        this.customView = builder.customView;
    }

    public void destroy() {
        NCall.IV(new Object[]{180, this});
    }

    public TextView getAdLogoView() {
        return (TextView) NCall.IL(new Object[]{181, this});
    }

    public ImageView getAppIconView() {
        return (ImageView) NCall.IL(new Object[]{182, this});
    }

    public View getCloseBtnView() {
        return (View) NCall.IL(new Object[]{183, this});
    }

    public View getCustomVideoView() {
        return (View) NCall.IL(new Object[]{184, this});
    }

    public View[] getCustomView() {
        return (View[]) NCall.IL(new Object[]{185, this});
    }

    public TextView getDescView() {
        return (TextView) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS), this});
    }

    public DirectDownloadView getDirectDownloadView() {
        return (DirectDownloadView) NCall.IL(new Object[]{187, this});
    }

    public ImageView getImageView() {
        return (ImageView) NCall.IL(new Object[]{188, this});
    }

    public List<ImageView> getImageViews() {
        return (List) NCall.IL(new Object[]{189, this});
    }

    public NativeSixElementsView getSixElementsView() {
        return (NativeSixElementsView) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), this});
    }

    public TextView getTitleView() {
        return (TextView) NCall.IL(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED), this});
    }

    public NativeVideoView getVideoView() {
        return (NativeVideoView) NCall.IL(new Object[]{192, this});
    }
}
