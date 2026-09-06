package com.opos.mobad.ad;

import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    public static final String a(int i) {
        if (i == 10003) {
            return "now time over ad expire time.";
        }
        if (i == 10006) {
            return "interstitial ad data is null.";
        }
        if (i == 10010) {
            return "ad has loaded,but not ready to show";
        }
        if (i == 10208) {
            return "splash ad render failed.";
        }
        if (i == 10700) {
            return "show error, please reload";
        }
        if (i == 10702) {
            return "ad had overlap, please reload others";
        }
        if (i == 11001) {
            return "ad has destroyed.";
        }
        switch (i) {
            case 10100:
                return "no net.";
            case MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED /* 10101 */:
                return "execute net request exception.";
            case 10102:
                return "parse ad response exception.";
            default:
                switch (i) {
                    case 10400:
                        return "no stream video to play.";
                    case 10401:
                        return "no local cached video to play.";
                    case 10402:
                        return "no video to play.";
                    case 10403:
                        return "no net,can't play video.";
                    case 10404:
                        return "video has expired.";
                    case 10405:
                        return "reward video only can play on 4.1 android version and above";
                    case 10406:
                        return "stream video only can be played in wifi net.";
                    case 10407:
                        return "unsupported play mode.";
                    case 10408:
                        return "video not cached.";
                    case 10409:
                        return "unknown creative.";
                    case 10410:
                        return "source exception.";
                    case 10411:
                        return "renderer exception.";
                    case 10412:
                        return "unexpected exception.";
                    case 10413:
                        return "video fail for zk";
                    case 10414:
                        return "Try to play video, but sdk is not initialized.";
                    case 10415:
                        return "play video remote error";
                    case 10416:
                        return "out of memory when playing video";
                    case 10417:
                        return "play video timeout";
                    default:
                        switch (i) {
                            case 10500:
                                return "get adView is null.";
                            case 10501:
                                return "unknown creative.";
                            case 10502:
                                return "The bottomArea view already has a parent..please not attachToRoot";
                            default:
                                switch (i) {
                                    case 10600:
                                        return "unknown creative.";
                                    case 10601:
                                        return "render null data";
                                    case 10602:
                                        return "render interactive time out";
                                    case 10603:
                                        return "render interactive fail";
                                    case 10604:
                                        return "render interactive resource fail";
                                    default:
                                        switch (i) {
                                            case 11003:
                                                return "you request ad too often.";
                                            case 11004:
                                                return "you shouldn't play ad on the top in the shaped screen mobile";
                                            case 11005:
                                                return "ads must display on android version after19";
                                            case 11006:
                                                return "request is destroyed, please check destruction logic and retry";
                                            case 11007:
                                                return "No matching ad, please use another device or avoid too frequent requests";
                                            case 11008:
                                                return "SDK not initialized";
                                            case 11009:
                                                return "network timeout, please check network status and retry";
                                            default:
                                                return "unknown error.";
                                        }
                                }
                        }
                }
        }
    }
}
