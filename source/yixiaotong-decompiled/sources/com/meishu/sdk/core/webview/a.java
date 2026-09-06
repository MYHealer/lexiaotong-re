package com.meishu.sdk.core.webview;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.a1;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.u;
import com.meishu.sdk.core.utils.x0;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.webview.jsbridge.bean.CheckAppInstallParam;
import com.meishu.sdk.core.webview.jsbridge.bean.ClickAppDownloadInfoParam;
import com.meishu.sdk.core.webview.jsbridge.bean.ClickTempParam;
import com.meishu.sdk.core.webview.jsbridge.bean.EventUrlReportParam;
import com.meishu.sdk.core.webview.jsbridge.bean.GetH5AdInfoResBean;
import com.meishu.sdk.core.webview.jsbridge.bean.H5NotifyErrorParam;
import com.meishu.sdk.core.webview.jsbridge.bean.InvokeDeepLinkParam;
import com.meishu.sdk.core.webview.jsbridge.bean.OpenWebViewPageParam;
import com.meishu.sdk.core.webview.jsbridge.bean.SetShakeOrTurnStateParam;
import com.meishu.sdk.core.webview.jsbridge.bean.SetSoundsOpenParam;
import com.meishu.sdk.core.webview.jsbridge.bean.SetVideoPlayStateParam;
import com.meishu.sdk.core.webview.jsbridge.bean.UUIDParam;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: ADMateJSBridge.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseAdSlot f4972a;
    public final com.meishu.sdk.platform.ms.c b;
    public final g c;
    public boolean d;
    public final k e;
    public com.meishu.sdk.core.webview.listener.c f;
    public com.meishu.sdk.core.webview.listener.d g;
    public SoftReference<WebView> h;

    /* JADX INFO: renamed from: com.meishu.sdk.core.webview.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ADMateJSBridge.java */
    public class C0820a extends k {
        public C0820a() {
        }
    }

    /* JADX INFO: compiled from: ADMateJSBridge.java */
    public class b extends com.meishu.sdk.core.safe.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InvokeDeepLinkParam f4973a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public b(InvokeDeepLinkParam invokeDeepLinkParam, int i, String str) {
            this.f4973a = invokeDeepLinkParam;
            this.b = i;
            this.c = str;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            WebView webView;
            a aVar = a.this;
            aVar.getClass();
            try {
                SoftReference<WebView> softReference = aVar.h;
                webView = softReference != null ? softReference.get() : null;
            } catch (Exception unused) {
            }
            com.meishu.sdk.core.webview.jsbridge.util.a.a(webView, this.f4973a.getCallbackFunc(), "{\"code\":" + this.b + ",\"msg\":\"" + this.c + "\"}");
        }
    }

    public a(com.meishu.sdk.platform.ms.c cVar, WebView webView, g gVar, boolean z) {
        this.b = cVar;
        this.c = gVar;
        this.d = z;
        AdSlot adSlotA = cVar != null ? cVar.a() : null;
        if (adSlotA instanceof BaseAdSlot) {
            BaseAdSlot baseAdSlot = (BaseAdSlot) adSlotA;
            this.f4972a = baseAdSlot;
            baseAdSlot.getReq_id();
        }
        this.h = new SoftReference<>(webView);
        this.e = new C0820a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(InvokeDeepLinkParam invokeDeepLinkParam, int i, String str) {
        if (TextUtils.isEmpty(invokeDeepLinkParam.getCallbackFunc())) {
            return;
        }
        SdkHandler.runOnMainThread(new b(invokeDeepLinkParam, i, str));
    }

    @JavascriptInterface
    public String checkAppInstall(String str) {
        CheckAppInstallParam checkAppInstallParam = (CheckAppInstallParam) a(str, CheckAppInstallParam.class);
        if (checkAppInstallParam != null) {
            checkAppInstallParam.getUuid();
            if (a()) {
                return "{\"install_status\":" + (!TextUtils.isEmpty(checkAppInstallParam.getDeep_link()) ? com.meishu.sdk.core.utils.f.a(checkAppInstallParam.getDeep_link()) : false) + com.alipay.sdk.util.i.d;
            }
        }
        LogUtil.dev("ADMateJSBridge", "checkAppInstall, The request is invalid");
        return "";
    }

    @JavascriptInterface
    public void clickAppDownloadInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ClickAppDownloadInfoParam clickAppDownloadInfoParam = (ClickAppDownloadInfoParam) a(str, ClickAppDownloadInfoParam.class);
        if (clickAppDownloadInfoParam != null) {
            clickAppDownloadInfoParam.getUuid();
            if (a()) {
                try {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null && dVar.clickAppDownloadInfo(clickAppDownloadInfoParam.getType())) {
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                DownloadView.openByType(this.b, clickAppDownloadInfoParam.getType());
                return;
            }
        }
        LogUtil.dev("ADMateJSBridge", "clickAppDownloadInfo, The request is invalid");
    }

    @JavascriptInterface
    public void clickTemp(String str) {
        a(str, true);
    }

    @JavascriptInterface
    public void closePage(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                try {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        dVar.onClosePage();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "closePage, The request is invalid");
    }

    @JavascriptInterface
    public void dismissAd(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                try {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        dVar.dismissAd();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "dismissAd, The request is invalid");
    }

    @JavascriptInterface
    public void eventUrlReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        EventUrlReportParam eventUrlReportParam = (EventUrlReportParam) a(str, EventUrlReportParam.class);
        if (eventUrlReportParam != null) {
            eventUrlReportParam.getUuid();
            if (a()) {
                try {
                    o1.a(this.f4972a.getEventUrl(), eventUrlReportParam.getEvent_id(), eventUrlReportParam.getError_code(), eventUrlReportParam.getError_mesg());
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "eventUrlReport, The request is invalid");
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    @JavascriptInterface
    public String getActivityState(String str) {
        if (!TextUtils.isEmpty(str)) {
            UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
            if (uUIDParam != null) {
                uUIDParam.getUuid();
                if (a()) {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        String str2 = "{\"state\":" + dVar.getActivityState() + com.alipay.sdk.util.i.d;
                        LogUtil.dev("ADMateJSBridge", "getActivityState callback." + str2);
                        return str2;
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "getActivityState, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "getActivityState, The request is invalid");
            }
        }
        return "";
    }

    @JavascriptInterface
    public String getAdInfo(String str) {
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                String json = u.f4948a.toJson(GetH5AdInfoResBean.make(this.f4972a, x0.b(AdSdk.getContext()), this.d));
                LogUtil.dev("ADMateJSBridge", "getAdInfo, callback:" + json);
                return json;
            }
        }
        LogUtil.dev("ADMateJSBridge", "getAdInfo, The request is invalid");
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    @JavascriptInterface
    public String getDeviceInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
            if (uUIDParam != null) {
                uUIDParam.getUuid();
                if (a()) {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        String deviceInfo = dVar.getDeviceInfo();
                        LogUtil.dev("ADMateJSBridge", "getDeviceInfo callback." + deviceInfo);
                        return deviceInfo;
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "getDeviceInfo, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "getDeviceInfo, The request is invalid");
            }
        }
        return "";
    }

    @JavascriptInterface
    public String getJSApiVersion(String str) {
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                return "{\"version\":2051303}";
            }
        }
        LogUtil.dev("ADMateJSBridge", "getJSApiVersion, The request is invalid");
        return "";
    }

    @JavascriptInterface
    public void h5NotifyError(String str) {
        try {
            H5NotifyErrorParam h5NotifyErrorParam = (H5NotifyErrorParam) a(str, H5NotifyErrorParam.class);
            if (h5NotifyErrorParam != null) {
                h5NotifyErrorParam.getUuid();
                if (a()) {
                    try {
                        a1.a(this.f4972a, 15, h5NotifyErrorParam.getCode(), h5NotifyErrorParam.getMessage());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        this.e.a(false);
                        return;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
            }
            LogUtil.dev("ADMateJSBridge", "h5NotifyError, The request is invalid");
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @JavascriptInterface
    public void h5Readied(String str) {
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                try {
                    this.e.a(true);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "h5Readied, The request is invalid");
    }

    @JavascriptInterface
    public void invokeDeepLink(String str) {
        final InvokeDeepLinkParam invokeDeepLinkParam = (InvokeDeepLinkParam) a(str, InvokeDeepLinkParam.class);
        if (invokeDeepLinkParam != null) {
            invokeDeepLinkParam.getUuid();
            if (a()) {
                new com.meishu.sdk.core.webview.jsbridge.a(this.b).a(invokeDeepLinkParam, new com.meishu.sdk.core.webview.jsbridge.a.InterfaceC0823a() { // from class: com.meishu.sdk.core.webview.a$$ExternalSyntheticLambda0
                    @Override // com.meishu.sdk.core.webview.jsbridge.a.InterfaceC0823a
                    public final void a(int i, String str2) {
                        this.f$0.a(invokeDeepLinkParam, i, str2);
                    }
                });
                return;
            }
        }
        LogUtil.dev("ADMateJSBridge", "invokeDeepLink, The request is invalid");
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    @JavascriptInterface
    public String isAppBackground(String str) {
        if (!TextUtils.isEmpty(str)) {
            UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
            if (uUIDParam != null) {
                uUIDParam.getUuid();
                if (a()) {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        return "{\"is_background\":" + (dVar.isAppBackground() ? 1 : 0) + com.alipay.sdk.util.i.d;
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "isAppBackground, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "isAppBackground, The request is invalid");
            }
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004e  */
    @JavascriptInterface
    public String isSoundsOpen(String str) {
        if (!TextUtils.isEmpty(str)) {
            UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
            if (uUIDParam != null) {
                uUIDParam.getUuid();
                if (a()) {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        boolean zIsSoundsOpen = dVar.isSoundsOpen();
                        LogUtil.dev("ADMateJSBridge", "isSoundsOpen isOpen:" + (zIsSoundsOpen ? 1 : 0));
                        return "{\"isOpen\":" + (zIsSoundsOpen ? 1 : 0) + com.alipay.sdk.util.i.d;
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "isSoundsOpen, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "isSoundsOpen, The request is invalid");
            }
        }
        return "";
    }

    @JavascriptInterface
    public void notifyRewarded(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UUIDParam uUIDParam = (UUIDParam) a(str, UUIDParam.class);
        if (uUIDParam != null) {
            uUIDParam.getUuid();
            if (a()) {
                try {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        dVar.notifyRewarded();
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "notifyRewarded, The request is invalid");
    }

    @JavascriptInterface
    @Deprecated
    public void onQuickRewardClick(String str) {
        a(str, false);
    }

    @JavascriptInterface
    public String openWebViewPage(String str) {
        String strA;
        OpenWebViewPageParam openWebViewPageParam = (OpenWebViewPageParam) a(str, OpenWebViewPageParam.class);
        String string = "";
        if (openWebViewPageParam != null) {
            openWebViewPageParam.getUuid();
            if (a()) {
                com.meishu.sdk.platform.ms.c cVar = this.b;
                com.meishu.sdk.core.webview.jsbridge.b bVar = new com.meishu.sdk.core.webview.jsbridge.b(cVar);
                try {
                    if (bVar.f4983a == null) {
                        strA = com.meishu.sdk.core.webview.jsbridge.b.a(false, "初始化错误");
                    } else if (TextUtils.isEmpty(openWebViewPageParam.getUrl())) {
                        strA = com.meishu.sdk.core.webview.jsbridge.b.a(false, "url 为空");
                    } else {
                        bVar.f4983a.setdUrl(new String[]{openWebViewPageParam.getUrl()});
                        com.meishu.sdk.core.utils.f.b(cVar, AdSdk.getContext(), bVar.f4983a, openWebViewPageParam.getOpen_type() == 1);
                        strA = com.meishu.sdk.core.webview.jsbridge.b.a(true, "");
                    }
                    return strA;
                } catch (Exception e) {
                    e.printStackTrace();
                    StringBuilder sb = new StringBuilder("未知错误:");
                    try {
                        string = e.toString();
                    } catch (Exception unused) {
                    }
                    return com.meishu.sdk.core.webview.jsbridge.b.a(false, sb.append(string).toString());
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "openWebViewPage, The request is invalid");
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    @JavascriptInterface
    public String setShakeOrTurnState(String str) {
        if (!TextUtils.isEmpty(str)) {
            SetShakeOrTurnStateParam setShakeOrTurnStateParam = (SetShakeOrTurnStateParam) a(str, SetShakeOrTurnStateParam.class);
            if (setShakeOrTurnStateParam != null) {
                setShakeOrTurnStateParam.getUuid();
                if (a()) {
                    try {
                        com.meishu.sdk.core.webview.listener.d dVar = this.g;
                        if (dVar != null) {
                            return "{\"isOpen\":" + (dVar.setShakeOrTurnState(setShakeOrTurnStateParam.getIsOpen()) ? 1 : 0) + com.alipay.sdk.util.i.d;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "setShakeOrTurnState, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "setShakeOrTurnState, The request is invalid");
            }
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    @JavascriptInterface
    public String setSoundsOpen(String str) {
        if (!TextUtils.isEmpty(str)) {
            SetSoundsOpenParam setSoundsOpenParam = (SetSoundsOpenParam) a(str, SetSoundsOpenParam.class);
            if (setSoundsOpenParam != null) {
                setSoundsOpenParam.getUuid();
                if (a()) {
                    try {
                        com.meishu.sdk.core.webview.listener.d dVar = this.g;
                        if (dVar != null) {
                            dVar.setSoundsOpen(setSoundsOpenParam.getIsOpen());
                            return "{\"isOpen\":" + (setSoundsOpenParam.getIsOpen() ? 1 : 0) + com.alipay.sdk.util.i.d;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "setSoundsOpen, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "setSoundsOpen, The request is invalid");
            }
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0046  */
    @JavascriptInterface
    public String setVideoPlayState(String str) {
        if (!TextUtils.isEmpty(str)) {
            SetVideoPlayStateParam setVideoPlayStateParam = (SetVideoPlayStateParam) a(str, SetVideoPlayStateParam.class);
            if (setVideoPlayStateParam != null) {
                setVideoPlayStateParam.getUuid();
                if (a()) {
                    try {
                        com.meishu.sdk.core.webview.listener.d dVar = this.g;
                        if (dVar != null) {
                            dVar.setVideoPlayState(setVideoPlayStateParam.getIsPlay());
                            return "{\"isPlay\":" + (setVideoPlayStateParam.getIsPlay() ? 1 : 0) + com.alipay.sdk.util.i.d;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    LogUtil.dev("ADMateJSBridge", "setVideoPlayState, The request is invalid");
                }
            } else {
                LogUtil.dev("ADMateJSBridge", "setVideoPlayState, The request is invalid");
            }
        }
        return "";
    }

    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ClickTempParam clickTempParam = (ClickTempParam) a(str, ClickTempParam.class);
        if (clickTempParam != null) {
            clickTempParam.getUuid();
            if (a()) {
                if (z && clickTempParam.getAct_type() <= 0) {
                    LogUtil.dev("ADMateJSBridge", "clickTemp, The act_type is invalid");
                    return;
                }
                try {
                    com.meishu.sdk.core.webview.listener.d dVar = this.g;
                    if (dVar != null) {
                        dVar.onWebClicked(clickTempParam);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
        LogUtil.dev("ADMateJSBridge", "clickTemp, The request is invalid");
    }

    public final <T> T a(String str, Class<T> cls) {
        try {
            return (T) u.f4948a.fromJson(str, (Class) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final boolean a() {
        try {
            return o.a(this.c.d);
        } catch (Exception unused) {
            return false;
        }
    }
}
