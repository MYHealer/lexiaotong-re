package com.miui.zeus.mimo.sdk.view;

import android.webkit.JavascriptInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BaseJavaScriptHandler {
    @JavascriptInterface
    public void cancelDownloadAppDirectly() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES), this});
    }

    @JavascriptInterface
    public boolean checkAppInstall() {
        return NCall.IZ(new Object[]{462, this});
    }

    @JavascriptInterface
    public boolean checkAppInstall(String str) {
        return NCall.IZ(new Object[]{463, this, str});
    }

    @JavascriptInterface
    public void clickAppIntroduction() {
        NCall.IV(new Object[]{464, this});
    }

    @JavascriptInterface
    public void clickAppPermission() {
        NCall.IV(new Object[]{465, this});
    }

    @JavascriptInterface
    public void clickAppPrivacy() {
        NCall.IV(new Object[]{466, this});
    }

    @JavascriptInterface
    public void onClick(String str) {
        NCall.IV(new Object[]{467, this, str});
    }

    @JavascriptInterface
    public void onClose() {
        NCall.IV(new Object[]{468, this});
    }

    @JavascriptInterface
    public void onVolumeStatusChanged(int i) {
        NCall.IV(new Object[]{469, this, Integer.valueOf(i)});
    }
}
