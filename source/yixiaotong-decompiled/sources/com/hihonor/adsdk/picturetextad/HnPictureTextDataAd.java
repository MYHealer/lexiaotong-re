package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.api.AdVideo;
import com.hihonor.adsdk.base.api.CustomVideo;
import com.hihonor.adsdk.base.api.HnMediationExpressDataAd;
import com.hihonor.adsdk.base.api.feed.AdDislike;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.download.OnDownloadStatusChangedListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnPictureTextDataAd extends HnMediationExpressDataAd<PictureTextExpressAd> implements PictureTextExpressAd {
    public HnPictureTextDataAd(PictureTextExpressAd pictureTextExpressAd) {
        super(pictureTextExpressAd);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public AdDislike getAdDislike() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getAdDislike();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public AdVideo getAdVideo() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getAdVideo();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public String getCoverUrl() {
        return hnadsc() ? ((PictureTextExpressAd) this.hnadsd).getCoverUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public CustomVideo getCustomVideo() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getCustomVideo();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public long getVideoDuration() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getVideoDuration();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public int getVideoHeight() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getVideoHeight();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public int getVideoWidth() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).getVideoWidth();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public boolean hasVideo() {
        if (hnadsc()) {
            return ((PictureTextExpressAd) this.hnadsd).hasVideo();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseExpressAd, com.hihonor.adsdk.base.api.BaseAd
    public void setAdListener(AdListener adListener) {
        super.setAdListener(adListener);
    }

    @Override // com.hihonor.adsdk.base.api.feed.PictureTextExpressAd
    public void setDownloadStatusChange(OnDownloadStatusChangedListener onDownloadStatusChangedListener) {
    }
}
