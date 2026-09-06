package com.kwad.sdk.core.adlog;

import android.text.TextUtils;
import client.android.yixiaotong.sdk.qrcode.decode.DecodeThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static ExecutorService aLI = GlobalThreadPools.Oc();
    public static JSONObject aLJ;
    public static boolean aLK;

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (aVar != null) {
            try {
                if (adTemplate.fromCache) {
                    aVar.a(h.cI(adTemplate));
                }
                aVar.e(adTemplate, null, null);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
                return;
            }
        }
        a(adTemplate, 2, aVar, jSONObject);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, al.a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.nm = i;
        if (adTemplate.swipeAngle != 0) {
            aVar2.aMR = adTemplate.swipeAngle;
        }
        if (aVar != null) {
            aVar2.no = aVar;
        }
        a(adTemplate, aVar2, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, bVar != null ? bVar.Jh() : null, jSONObject);
    }

    public static boolean b(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (adTemplate.mPvReported) {
            return false;
        }
        adTemplate.mPvReported = true;
        AdInfo adInfoEO = e.eO(adTemplate);
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.eq(IT());
        com.kwad.sdk.core.adlog.c.a aVarJh = bVar.Jh();
        if (adTemplate.fromCache) {
            aVarJh.a(h.cI(adTemplate));
        }
        aVarJh.aMI = I(adInfoEO) ? 1 : 0;
        return a(adTemplate, 1, aVarJh, jSONObject);
    }

    private static int IT() {
        return as.isOrientationPortrait() ? 2 : 1;
    }

    private static boolean I(AdInfo adInfo) {
        f fVar = (f) ServiceProvider.get(f.class);
        if (fVar == null) {
            return false;
        }
        String strAE = com.kwad.sdk.core.response.helper.a.aE(adInfo);
        if (TextUtils.isEmpty(strAE)) {
            return false;
        }
        return au.aw(fVar.getContext(), strAE);
    }

    public static void a(AdTemplate adTemplate, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        if (j != -1) {
            c0733a.duration = j;
            aVar.QZ = c0733a;
        }
        a(adTemplate, 934, aVar, (JSONObject) null);
    }

    @Deprecated
    public static void a(AdTemplate adTemplate, int i, long j, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMh = i;
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.duration = j;
        aVar.QZ = c0733a;
        a(adTemplate, 3, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        a(adTemplate, 3, bVar != null ? bVar.Jh() : null, jSONObject);
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, long j2, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.zV = j;
        aVar.aMK = i2;
        aVar.aMh = i;
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.duration = j2;
        aVar.QZ = c0733a;
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void cn(AdTemplate adTemplate) {
        w(adTemplate, 4);
    }

    public static void co(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        adTemplate.downLoadType = 3;
        aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 30, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 33, aVar, jSONObject);
    }

    public static void b(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 34, aVar, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.b bVar) {
        AdInfo adInfoEO = e.eO(adTemplate);
        String str = adInfoEO.downloadFilePath;
        if (str == null) {
            return;
        }
        String strAE = com.kwad.sdk.core.response.helper.a.aE(adInfoEO);
        String strHW = au.hW(str);
        if (strHW == null || TextUtils.isEmpty(strHW) || strHW.equals(strAE)) {
            return;
        }
        bVar.ee(strHW);
        bVar.ed(strAE);
        adInfoEO.adBaseInfo.appPackageName = strHW;
    }

    public static void c(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aLI.submit(new bi() { // from class: com.kwad.sdk.core.adlog.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
                c0733a.aLm = adTemplate.downLoadType;
                com.kwad.sdk.core.adlog.c.b bVarEf = new com.kwad.sdk.core.adlog.c.b().b(c0733a).ef(adTemplate.downloadSource);
                c.a(adTemplate, bVarEf);
                c.a(adTemplate, 31, bVarEf.Jh(), jSONObject);
                AdInfo adInfoEO = e.eO(adTemplate);
                au.aA(adInfoEO.downloadFilePath, adInfoEO.downloadId);
            }
        });
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadSource = adTemplate.downloadSource;
        aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 35, aVar, jSONObject);
    }

    public static void e(final AdTemplate adTemplate, final JSONObject jSONObject) {
        aLI.submit(new bi() { // from class: com.kwad.sdk.core.adlog.c.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                AdInfo adInfoEO = e.eO(adTemplate);
                int iAB = au.aB(adInfoEO.downloadId, com.kwad.sdk.core.response.helper.a.aE(adInfoEO));
                com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
                aVar.downloadSource = adTemplate.downloadSource;
                aVar.aMw = iAB;
                aVar.aMx = adTemplate.installFrom;
                aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
                aVar.QZ.aLm = adTemplate.downLoadType;
                c.a(adTemplate, 32, aVar, jSONObject);
            }
        });
    }

    public static void cp(AdTemplate adTemplate) {
        w(adTemplate, 36);
    }

    public static void cq(AdTemplate adTemplate) {
        w(adTemplate, 38);
    }

    public static void cr(AdTemplate adTemplate) {
        w(adTemplate, 41);
    }

    public static void cs(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMB = com.kwad.sdk.core.response.helper.a.aE(e.eO(adTemplate));
        a(adTemplate, DecodeThread.ALL_MODE, aVar, new JSONObject());
    }

    public static void l(AdTemplate adTemplate, int i) {
        adTemplate.mInstallApkFromSDK = true;
        adTemplate.mInstallApkFormUser = i == 1;
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMN = i;
        aVar.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 37, aVar, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.Ra = i;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, aVar, (JSONObject) null);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int code;
        public String msg;

        public a(int i, String str) {
            this.code = i;
            this.msg = str;
        }
    }

    public static void a(AdTemplate adTemplate, a aVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = new com.kwad.sdk.core.adlog.c.a();
        aVar2.aMy = aVar.toJson().toString();
        aVar2.a(new com.kwad.sdk.core.adlog.a.C0733a());
        aVar2.QZ.aLm = adTemplate.downLoadType;
        a(adTemplate, 40, aVar2, (JSONObject) null);
    }

    public static void f(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 399, jSONObject);
    }

    public static void ct(AdTemplate adTemplate) {
        f(adTemplate, null);
    }

    public static void cu(AdTemplate adTemplate) {
        g(adTemplate, null);
    }

    public static void g(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 400, jSONObject);
    }

    public static void h(AdTemplate adTemplate, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMh = 1;
        aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
        aVar.QZ.templateId = "101";
        a(adTemplate, 3, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aMt = i;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, 1038, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aMt = i;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, 1039, aVar, (JSONObject) null);
    }

    public static void c(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aMt = i;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, String str, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        aVar.aMt = i;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMt = 1;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void d(AdTemplate adTemplate, String str, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMt = i;
        if (aVar.QZ == null) {
            aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
        }
        aVar.QZ.aLG = i2;
        if (!str.equals("")) {
            aVar.aMu = str;
        }
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, aVar, (JSONObject) null);
    }

    public static void n(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMv = i;
        d(adTemplate, "wxsmallapp", 1, aVar);
    }

    public static void o(AdTemplate adTemplate, int i) {
        n(adTemplate, i, 0);
    }

    public static void n(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMH = i;
        aVar.Rb = i2;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        if (z) {
            c0733a.aLq = 1;
        } else {
            c0733a.aLq = 2;
        }
        aVar.a(c0733a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        if (z) {
            c0733a.aLq = 1;
        } else {
            c0733a.aLq = 2;
        }
        aVar.a(c0733a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, aVar, (JSONObject) null);
    }

    public static void cv(AdTemplate adTemplate) {
        w(adTemplate, 58);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 50, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.aMF = j;
        a(adTemplate, 51, aVar, (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, long j) {
        a(adTemplate, 52, com.kwad.sdk.core.adlog.c.a.Jf().aB(j), (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar, long j) {
        aVar.aMF = j;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD, aVar, (JSONObject) null);
    }

    public static void b(AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        a(adTemplate, 59, aVar, (JSONObject) null);
    }

    public static void i(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, 501, jSONObject);
    }

    public static void o(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMi = 69;
        aVar.aMD = i;
        aVar.aME = i2;
        a(adTemplate, 501, aVar, (JSONObject) null);
    }

    public static void j(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME, jSONObject);
    }

    public static void k(AdTemplate adTemplate, JSONObject jSONObject) {
        d(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, jSONObject);
    }

    public static void c(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME, bVar != null ? bVar.Jh() : null, (JSONObject) null);
    }

    public static void p(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMg = i;
        a(adTemplate, 759, aVar, (JSONObject) null);
    }

    public static void q(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMf = i;
        a(adTemplate, 28, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMf = i;
        a(adTemplate, 402, aVar, jSONObject);
    }

    public static void cw(AdTemplate adTemplate) {
        w(adTemplate, DetailedCreativeType.LONG_TEXT);
    }

    @Deprecated
    public static void b(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        d(adTemplate, jSONObject, new com.kwad.sdk.core.adlog.c.b().ee(i));
    }

    public static void d(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarJh = bVar.Jh();
        aVarJh.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVarJh, jSONObject);
    }

    public static void r(AdTemplate adTemplate, int i) {
        if (adTemplate == null) {
            return;
        }
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMB = com.kwad.sdk.core.response.helper.a.aE(e.eO(adTemplate));
        a(adTemplate, i, aVar, new JSONObject());
    }

    public static void c(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMB = com.kwad.sdk.core.response.helper.a.aE(e.eO(adTemplate));
        aVar.aMi = 93;
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, aVar, (JSONObject) null);
    }

    public static void s(AdTemplate adTemplate, int i) {
        a(adTemplate, i, new com.kwad.sdk.core.adlog.c.a(), new JSONObject());
    }

    @Deprecated
    public static void t(AdTemplate adTemplate, int i) {
        e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().ee(i));
    }

    public static void e(AdTemplate adTemplate, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.b bVar) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        com.kwad.sdk.core.adlog.c.a aVarJh = bVar.Jh();
        aVarJh.e(adTemplate, null, null);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID, aVarJh, jSONObject);
    }

    public static void m(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMk = j;
        a(adTemplate, 600, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, AdExposureFailedReason adExposureFailedReason) {
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == -9999 || i == 6) {
            com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
            aVar.aMl = i;
            if (adExposureFailedReason != null) {
                aVar.aMm = adExposureFailedReason.winEcpm;
                try {
                    aVar.adnType = adExposureFailedReason.adnType;
                    if (adExposureFailedReason.adnType == 2) {
                        aVar.adnName = adExposureFailedReason.adnName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adUserName)) {
                        aVar.aMn = adExposureFailedReason.adUserName;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adTitle)) {
                        aVar.aMo = adExposureFailedReason.adTitle;
                    }
                    if (!TextUtils.isEmpty(adExposureFailedReason.adRequestId)) {
                        aVar.aMp = adExposureFailedReason.adRequestId;
                    }
                    aVar.aMq = adExposureFailedReason.isShow;
                    aVar.aMr = adExposureFailedReason.isClick;
                    aVar.adnMaterialType = adExposureFailedReason.adnMaterialType;
                    aVar.adnMaterialUrl = adExposureFailedReason.adnMaterialUrl;
                } catch (Throwable unused) {
                }
            }
            a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_START_TIME, aVar, (JSONObject) null);
        }
    }

    public static void cx(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.downloadStatus = com.kwad.sdk.core.response.helper.a.bG(e.eO(adTemplate));
        com.kwad.sdk.core.d.c.d("AdReportManager", "reportDownloadCardClose downloadStatus=" + aVar.downloadStatus);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT, aVar, (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, int i, JSONObject jSONObject, String str) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.QY = str;
        a(adTemplate, i, aVar, jSONObject);
    }

    public static void cy(AdTemplate adTemplate) {
        w(adTemplate, 722);
    }

    public static void cz(AdTemplate adTemplate) {
        w(adTemplate, 721);
    }

    public static void n(AdTemplate adTemplate, long j) {
        com.kwad.sdk.core.adlog.c.a aVar = new com.kwad.sdk.core.adlog.c.a();
        aVar.aMG = j;
        a(adTemplate, 401, aVar, (JSONObject) null);
    }

    public static void k(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLn = 1;
        bVar.b(c0733a);
        if (z) {
            bVar.el(33);
        }
        a(adTemplate, 804, bVar.Jh(), (JSONObject) null);
    }

    public static void cA(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLx = com.kwad.sdk.core.response.helper.a.dG(e.eO(adTemplate)) ? 1 : 0;
        c0733a.aLE = 1;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0733a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.Jh(), (JSONObject) null);
    }

    public static void u(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLx = com.kwad.sdk.core.response.helper.a.dG(e.eO(adTemplate)) ? 1 : 0;
        c0733a.aLE = i;
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        bVar.b(c0733a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_VERSION, bVar.Jh(), (JSONObject) null);
    }

    public static void l(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLn = 2;
        bVar.b(c0733a);
        if (z) {
            bVar.el(33);
        }
        a(adTemplate, 804, bVar.Jh(), (JSONObject) null);
    }

    public static void v(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLC = i;
        bVar.b(c0733a);
        a(adTemplate, 1032, bVar.Jh(), (JSONObject) null);
    }

    public static void p(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLC = i;
        c0733a.aLD = i2;
        bVar.b(c0733a);
        a(adTemplate, 1030, bVar.Jh(), (JSONObject) null);
    }

    public static void q(AdTemplate adTemplate, int i, int i2) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLC = i;
        c0733a.aLD = i2;
        bVar.b(c0733a);
        a(adTemplate, 1033, bVar.Jh(), (JSONObject) null);
    }

    public static void cB(AdTemplate adTemplate) {
        a(adTemplate, 1031, (com.kwad.sdk.core.adlog.c.a) null, (JSONObject) null);
    }

    public static void m(AdTemplate adTemplate, boolean z) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLr = z;
        bVar.b(c0733a);
        a(adTemplate, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, bVar.Jh(), (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, boolean z, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLr = z;
        bVar.b(c0733a);
        bVar.er(i);
        a(adTemplate, 935, bVar.Jh(), (JSONObject) null);
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i) {
        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
        com.kwad.sdk.core.adlog.a.C0733a c0733a = new com.kwad.sdk.core.adlog.a.C0733a();
        c0733a.aLx = com.kwad.sdk.core.response.helper.a.dG(e.eO(adTemplate)) ? 1 : 0;
        c0733a.aLz = str;
        c0733a.aLA = str2;
        c0733a.aLB = i;
        bVar.b(c0733a);
        a(adTemplate, 1024, bVar.Jh(), (JSONObject) null);
    }

    private static void w(AdTemplate adTemplate, int i) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, new JSONObject());
    }

    private static void d(AdTemplate adTemplate, int i, JSONObject jSONObject) {
        a(adTemplate, i, (com.kwad.sdk.core.adlog.c.a) null, jSONObject);
    }

    public static boolean a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (adTemplate == null || !cC(adTemplate)) {
            return false;
        }
        if (aVar == null) {
            aVar = new com.kwad.sdk.core.adlog.c.a();
        }
        aVar.aMJ = com.kwad.sdk.core.response.helper.a.aZ(e.eO(adTemplate));
        aVar.adxResult = adTemplate.adxResult;
        if (i == 2 && aLK) {
            if (aVar.QZ == null) {
                aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
            }
            aVar.QZ.aLt = aLJ;
        }
        if (i == 1 && e.eI(adTemplate) == 4 && com.kwad.sdk.core.response.helper.a.dC(e.eO(adTemplate))) {
            if (aVar.QZ == null) {
                aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
            }
            aVar.QZ.aLs = com.kwad.sdk.core.response.helper.a.dD(e.eO(adTemplate));
        }
        if (i == 1 || i == 2) {
            if (aVar.QZ == null) {
                aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
            }
            aVar.QZ.aLx = com.kwad.sdk.core.response.helper.a.dG(e.eO(adTemplate)) ? 1 : 0;
            if (AdTemplate.isInnerEcCancelDowngrade) {
                aVar.QZ.aLy = 1;
            }
        }
        aVar.cF(adTemplate);
        aVar.adTemplate = adTemplate;
        aVar.aKI = i;
        aVar.aMe = jSONObject;
        com.kwad.sdk.core.d.c.d("AdReportManager", new StringBuilder().append(i).toString());
        b.a(aVar);
        return true;
    }

    private static boolean cC(AdTemplate adTemplate) {
        if (e.eG(adTemplate)) {
            return true;
        }
        f fVar = (f) ServiceProvider.get(f.class);
        return fVar != null && fVar.bn(adTemplate);
    }
}
