package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.ct;
import com.baidu.mobads.sdk.internal.cu;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class CpuAdView extends RelativeLayout {
    private cu mAdProd;

    public interface CpuAdViewInternalStatusListener {
        void loadDataError(String str);

        void onAdClick();

        void onAdImpression(String str);

        void onContentClick();

        void onContentImpression(String str);

        void onExitLp();

        void onLpContentStatus(Map<String, Object> map);
    }

    public CpuAdView(Context context) {
        super(context);
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        ct ctVar = new ct(context);
        this.mAdProd = new cu(context, ctVar, str, i, cPUWebAdRequestParam);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public CpuAdView(Context context, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam, CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        super(context);
        ct ctVar = new ct(context);
        cu cuVar = new cu(context, ctVar, str, i, cPUWebAdRequestParam);
        this.mAdProd = cuVar;
        cuVar.a(cpuAdViewInternalStatusListener);
        addView(ctVar, new ViewGroup.LayoutParams(-1, -1));
    }

    public void onResume() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).onResume();
        }
    }

    public void onPause() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).onPause();
        }
    }

    public void onDestroy() {
        View viewW = this.mAdProd.w();
        if (viewW instanceof WebView) {
            ((WebView) viewW).destroy();
        }
    }

    public boolean onKeyBackDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    protected boolean canGoBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                return webView.canGoBack();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    protected void goBack() {
        try {
            WebView webView = (WebView) this.mAdProd.w();
            if (webView != null) {
                webView.goBack();
            }
        } catch (Throwable unused) {
        }
    }

    public void requestData() {
        cu cuVar = this.mAdProd;
        if (cuVar != null) {
            cuVar.a();
        }
    }
}
