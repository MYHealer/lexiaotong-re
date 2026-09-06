package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cu extends bj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, Object> f1793a;
    private int t;
    private RelativeLayout u;
    private CpuAdView.CpuAdViewInternalStatusListener v;

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.v = cpuAdViewInternalStatusListener;
    }

    public cu(Context context, RelativeLayout relativeLayout, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.q = str;
        this.u = relativeLayout;
        this.t = i;
        if (cPUWebAdRequestParam == null) {
            az.c().e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.f1793a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        if (this.m != null) {
            try {
                jSONObject.put("channel", this.t);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.q)) {
                    jSONObject.put("appid", this.q);
                }
                if (this.u != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.m.createProdHandler(jSONObject2);
                    this.m.setAdContainer(this.u);
                    m();
                    this.m.addEventListener("Update_fbReader_Setting", new cv(this));
                    this.m.addEventListener("closeInterstitialAd", new cw(this));
                    this.m.addEventListener("feOpenFbReader", new cx(this));
                    JSONObject jSONObjectA = m.a(this.f1793a);
                    jSONObjectA.put("isInitNovelSDK", ao.f());
                    this.m.loadAd(jSONObject, jSONObjectA);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        ao.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, String str, int i3, int i4, String str2) {
        ao.a(i);
        ao.b(i2);
        ao.a(new cy(this, i3, i4, str2));
        ao.a(this.i, str);
    }

    public Activity e() {
        return ao.c();
    }

    public boolean f() {
        return ao.d();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.v != null && bool != null && bool.booleanValue()) {
            this.v.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.v != null && bool != null && bool.booleanValue()) {
            this.v.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i, String str2) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.v;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(IOAdEvent iOAdEvent) {
        if (this.v == null || iOAdEvent == null) {
            return;
        }
        this.v.onLpContentStatus(iOAdEvent.getData());
    }
}
