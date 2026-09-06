package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.api.BaseAdImpl;
import com.hihonor.adsdk.base.dialog.DateFlowTipActivity;
import com.hihonor.adsdk.base.download.p;
import com.hihonor.adsdk.base.widget.web.jsbridge.JsBridgeWebView;
import com.hihonor.adsdk.base.widget.web.jsbridge.MyWebView;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.h;
import com.hihonor.adsdk.common.f.o;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b extends f<BaseAd> {
    protected static final String hnadsr = "BaseAdJSWebActivity";
    protected static final String hnadss = "download";
    protected static final String hnadst = "downloadUrl";
    protected static final String hnadsu = "pkgName";
    protected static final String hnadsv = "isClick";
    protected static final String hnadsw = "clickX";
    protected static final String hnadsx = "clickY";
    protected static final String hnadsy = "state";
    protected static final String hnadsz = "type";
    protected int hnadso;
    protected int hnadsp;
    private C0451b hnadsq = new C0451b(this);

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.widget.base.b$b, reason: collision with other inner class name */
    private static class C0451b implements p {
        WeakReference<b> hnadsa;
        com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> hnadsb;

        public C0451b(b bVar) {
            this.hnadsa = new WeakReference<>(bVar);
        }

        public void hnadsa(com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
            this.hnadsb = aVar;
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsb(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "StateChangeCallbackListener onStartDownloadFail: " + i + ", " + str, new Object[0]);
            b0.hnadsb(R.string.ads_download_fail);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsc(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onPauseFail,code: " + i + ",mgs: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsd(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onGetAppStatusFail,code: " + i + ",msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadse(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onCancelFail,code: " + i + ",msg: " + str, new Object[0]);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsa(int i, String str) {
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "StateChangeCallbackListener onStartInstallFail: " + i + ", " + str, new Object[0]);
            b0.hnadsb(R.string.ads_install_fail);
        }

        @Override // com.hihonor.adsdk.base.download.p
        public void hnadsa(com.hihonor.adsdk.base.download.g gVar) {
            if (gVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onStatusChange: adDIInfo is null", new Object[0]);
            } else if (this.hnadsa.get() == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onStatusChange: BaseAdJSWebActivity is null", new Object[0]);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "adDIInfo status: " + gVar.k() + ", adDIInfo progress: " + gVar.e() + ", AppPackage: " + gVar.hnadsd(), new Object[0]);
                hnadsa(gVar.k());
            }
        }

        public void hnadsa(int i) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(b.hnadsy, i);
                this.hnadsb.hnadsb(jSONObject);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(b.hnadsr, "sendStateToHtml, json error, Exception: " + e.getMessage(), new Object[0]);
            }
        }
    }

    private void hnadsr() {
        this.hnadsq.hnadsa((com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject>) null);
        T t = this.hnadsg;
        if (t != 0) {
            com.hihonor.adsdk.base.download.f.hnadsa((BaseAd) t).hnadsa(this.hnadsq);
        }
        this.hnadsq = null;
    }

    private void hnadss() {
        DateFlowTipActivity.hnadsa((BaseAd) this.hnadsg, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadst() {
        T t = this.hnadsg;
        if (t == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsr, "openJsBridgeApp, mBaseAd is null", new Object[0]);
        } else {
            com.hihonor.adsdk.base.download.f.hnadsa((BaseAdImpl) t).hnadse(this.hnadsq, 0);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected MyWebView hnadsd() {
        JsBridgeWebView jsBridgeWebView = new JsBridgeWebView(new MutableContextWrapper(HnAds.get().getContext()));
        Context context = jsBridgeWebView.getContext();
        if (context instanceof MutableContextWrapper) {
            ((MutableContextWrapper) context).setBaseContext(this);
        }
        WebView.setWebContentsDebuggingEnabled(false);
        jsBridgeWebView.hnadsa(new a(this), "download");
        return jsBridgeWebView;
    }

    @Override // com.hihonor.adsdk.base.widget.base.f
    protected void hnadsf() {
        super.hnadsf();
        hnadsr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class a {
        protected WeakReference<b> hnadsa;

        public a(b bVar) {
            this.hnadsa = new WeakReference<>(bVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void hnadsa(b bVar, Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a aVar) {
            if (h.hnadsa(bVar)) {
                bVar.hnadsa(obj, aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void hnadsb(b bVar, Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a aVar) {
            if (h.hnadsa(bVar)) {
                bVar.hnadsb(obj, aVar);
            }
        }

        @JavascriptInterface
        public void onClickListener(Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
            final b bVar = this.hnadsa.get();
            final int iOptInt = ((JSONObject) obj).optInt("type", -1);
            bVar.runOnUiThread(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.b$a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.hnadsa(bVar, iOptInt);
                }
            });
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onClickListener and type " + obj, new Object[0]);
        }

        @JavascriptInterface
        public void onJumpListener(Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
            final b bVar = this.hnadsa.get();
            bVar.runOnUiThread(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.b$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    b.a.hnadsa(bVar);
                }
            });
            com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "onJumpListener.", new Object[0]);
        }

        @JavascriptInterface
        public void openApp(Object obj) {
            final b bVar = this.hnadsa.get();
            if (bVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "openApp() WebCommonActivity is null", new Object[0]);
            } else {
                bVar.runOnUiThread(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.b$a$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.hnadsb(bVar);
                    }
                });
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "DownLoadJsApi openApp has finished", new Object[0]);
            }
        }

        @JavascriptInterface
        public void queryState(final Object obj, final com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
            if (obj == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "queryState() Object msg is null", new Object[0]);
                return;
            }
            final b bVar = this.hnadsa.get();
            if (bVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "queryState() WebCommonActivity is null", new Object[0]);
            } else {
                bVar.runOnUiThread(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.b$a$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.hnadsa(bVar, obj, aVar);
                    }
                });
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "DownLoadJsApi queryState has finished", new Object[0]);
            }
        }

        @JavascriptInterface
        public void startDownLoad(final Object obj, final com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
            if (obj == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "startDownLoad()  Object msg is null", new Object[0]);
                return;
            }
            final b bVar = this.hnadsa.get();
            if (bVar == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "startDownLoad() WebCommonActivity is null", new Object[0]);
            } else {
                bVar.runOnUiThread(new Runnable() { // from class: com.hihonor.adsdk.base.widget.base.b$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.a.hnadsb(bVar, obj, aVar);
                    }
                });
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsr, "DownLoadJsApi startDownLoad has finished", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void hnadsa(b bVar, int i) {
            if (h.hnadsa(bVar) && i == 0) {
                bVar.hnadso++;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void hnadsb(b bVar) {
            if (h.hnadsa(bVar)) {
                bVar.hnadst();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void hnadsa(b bVar) {
            if (h.hnadsa(bVar)) {
                bVar.hnadsp++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hnadsb(Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsr, "startJsBridgeDownload, mBaseAd is null", new Object[0]);
            return;
        }
        int iHnadsa = hnadsa(obj, aVar);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsr, "startJsBridgeDownload state:" + iHnadsa, new Object[0]);
        boolean zHnadsf = o.hnadsf(HnAds.get().getContext());
        int iHnadsb = o.hnadsb(HnAds.get().getContext());
        BaseAdImpl baseAdImpl = (BaseAdImpl) this.hnadsg;
        if (baseAdImpl.getInstallPkgType() != 0 || zHnadsf || iHnadsb == 0) {
            if (iHnadsa != -1 && iHnadsa != 2100 && iHnadsa != 2012 && iHnadsa != 2013) {
                switch (iHnadsa) {
                    case 2006:
                    case 2007:
                    case 2008:
                        break;
                    default:
                        com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadsb(this.hnadsq, 0);
                        break;
                }
                return;
            }
            com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadse(this.hnadsq, 0);
            return;
        }
        if (iHnadsa == -1) {
            com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadsb(this.hnadsq, 0);
            hnadss();
            return;
        }
        if (iHnadsa != 2100 && iHnadsa != 2012 && iHnadsa != 2013) {
            switch (iHnadsa) {
                case 2006:
                case 2007:
                case 2008:
                    break;
                default:
                    com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadsb(this.hnadsq, 0);
                    break;
            }
            return;
        }
        com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadse(this.hnadsq, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int hnadsa(Object obj, com.hihonor.adsdk.base.widget.web.jsbridge.a<JSONObject> aVar) {
        if (this.hnadsg == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsr, "queryJsBridgeState, mBaseAd is null", new Object[0]);
            return -1;
        }
        JSONObject jSONObject = (JSONObject) obj;
        String strOptString = jSONObject.optString(hnadst);
        String strOptString2 = jSONObject.optString("pkgName");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsr, "from H5Web downloadUrl or pkgName is empty", new Object[0]);
        }
        boolean zOptBoolean = jSONObject.has(hnadsv) ? jSONObject.optBoolean(hnadsv) : false;
        if (this.hnadsg != 0 && zOptBoolean) {
            this.hnadse.hnadsa(jSONObject.optInt("clickX"), jSONObject.optInt("clickY"));
        }
        T t = this.hnadsg;
        if (t instanceof BaseAdImpl) {
            BaseAdImpl baseAdImpl = (BaseAdImpl) t;
            this.hnadsq.hnadsa(aVar);
            com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadsb(this.hnadsq, 0);
            com.hihonor.adsdk.base.download.g gVarHnadsa = com.hihonor.adsdk.base.download.f.hnadsa(baseAdImpl).hnadsa();
            if (gVarHnadsa != null) {
                int iK = gVarHnadsa.k();
                this.hnadsq.hnadsa(iK);
                return iK;
            }
        }
        return -1;
    }
}
