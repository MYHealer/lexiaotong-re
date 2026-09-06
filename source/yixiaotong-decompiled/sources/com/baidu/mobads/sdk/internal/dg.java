package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class dg extends bj {
    private int A;
    private RequestParameters B;
    private boolean C;
    private g.a D;
    private BaiduNativeManager.ExpressAdListener E;
    private BaiduNativeManager.EntryAdListener F;
    private g.b G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<NativeResponse> f1806a;
    private List<ExpressResponse> t;
    private List<EntryResponse> u;
    private int v;
    private boolean w;
    private String x;
    private String y;
    private int z;

    public void a(int i) {
        this.H = i;
    }

    public void a(int i, int i2) {
        this.I = i;
        this.J = i2;
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.F = entryAdListener;
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.E = expressAdListener;
    }

    public void a(g.a aVar) {
        this.D = aVar;
    }

    public void a(g.b bVar) {
        this.G = bVar;
    }

    public void b(boolean z) {
        this.C = z;
    }

    public void c(boolean z) {
        this.K = z;
    }

    public void d(boolean z) {
        this.L = z;
    }

    public String e() {
        return this.x;
    }

    public RequestParameters f() {
        return this.B;
    }

    public String g() {
        return this.y;
    }

    public dg(Context context, String str, String str2, boolean z, int i) {
        super(context);
        this.C = false;
        this.H = 0;
        this.I = 0;
        this.J = 0;
        this.K = false;
        this.L = false;
        this.y = str;
        this.x = str2;
        this.w = z;
        this.v = i;
        this.z = 600;
        this.A = 500;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
        } else {
            this.n = true;
            this.m.loadAd(j(), k());
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.z = width;
            this.A = height;
        }
        this.B = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            map.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, map);
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.M());
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, map);
        Object obj = map.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.M());
            map.put(IAdInterListener.AdReqParam.WIDTH, Integer.valueOf(this.I));
            map.put(IAdInterListener.AdReqParam.HEIGHT, Integer.valueOf(this.J));
            map.put("container", viewGroup);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, map);
    }

    public void b(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "destroyExpressView");
            jSONObject.put("uniqueId", aVar.M());
            map.put("container", viewGroup);
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, map);
    }

    public boolean a(View view, a aVar, int i) {
        JSONObject jSONObject = new JSONObject();
        HashMap map = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            map.put("view", view);
            map.put("code", Integer.valueOf(i));
        } catch (JSONException e) {
            bv.a().a(e);
        }
        a(jSONObject, map);
        Object obj = map.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int iIntValue = ((Integer) data.get("viewWidth")).intValue();
        int iIntValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i = 0; i < this.t.size(); i++) {
            bs bsVar = (bs) this.t.get(i);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(view, iIntValue, iIntValue2);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.E == null || iOAdEvent == null || this.t == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int iIntValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i = 0; i < this.t.size(); i++) {
            bs bsVar = (bs) this.t.get(i);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(view, str2, iIntValue);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        int i = 0;
        if (this.E != null && this.t != null) {
            while (i < this.t.size()) {
                bs bsVar = (bs) this.t.get(i);
                if (TextUtils.equals(bsVar.a(), str)) {
                    if (TextUtils.equals(com.huawei.openalliance.ad.constant.br.b.V, str2)) {
                        bsVar.d();
                    } else if (TextUtils.equals("click", str2)) {
                        Object obj = data.get("reason");
                        bsVar.b(obj instanceof String ? (String) obj : "");
                    } else if (TextUtils.equals("close", str2)) {
                        bsVar.e();
                    }
                }
                i++;
            }
            return;
        }
        if (this.f1806a != null) {
            while (i < this.f1806a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    if (TextUtils.equals(com.huawei.openalliance.ad.constant.br.b.V, str2)) {
                        xAdNativeResponse.onDislikeShow();
                    } else if (TextUtils.equals("click", str2)) {
                        Object obj2 = data.get("reason");
                        xAdNativeResponse.onDislikeClick(obj2 instanceof String ? (String) obj2 : "");
                    } else if (TextUtils.equals("close", str2)) {
                        xAdNativeResponse.onDislikeClose();
                    }
                }
                i++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        int i = 0;
        if (this.E != null && this.t != null) {
            while (i < this.t.size()) {
                bs bsVar = (bs) this.t.get(i);
                if (TextUtils.equals(bsVar.a(), str)) {
                    bsVar.a(bsVar);
                }
                i++;
            }
            return;
        }
        if (this.f1806a != null) {
            while (i < this.f1806a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                    xAdNativeResponse.onAdClose(xAdNativeResponse);
                }
                i++;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f1806a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i = 0; i < this.f1806a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (TextUtils.equals(com.huawei.openalliance.ad.constant.br.b.C, str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                } else if (TextUtils.equals("e_commerce_dismiss", str2)) {
                    xAdNativeResponse.onECommerceDismiss();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void l(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f1806a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        int code = iOAdEvent.getCode();
        String str = (String) data.remove("uniqueId");
        for (int i = 0; i < this.f1806a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                xAdNativeResponse.onAdEvent(code, data);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(IOAdEvent iOAdEvent) {
        if (this.G == null || iOAdEvent == null || this.f1806a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i = 0; i < this.f1806a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.G.a(xAdNativeResponse);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00bd  */
    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        int i;
        int iOptInt;
        boolean zB;
        if (this.D == null && this.E == null && this.F == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVarA = b.a(this.p);
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i3 = 0;
        while (i3 < bVarA.a().size()) {
            a aVar = bVarA.a().get(i3);
            String strM = aVar.m();
            if (aVar.q() == 1) {
                i = 1;
            } else {
                i = 3;
                if (aVar.q() == 2) {
                    if (strM == null || strM.equals("") || strM.equals("null") || hashSet.contains(strM)) {
                        i2 = 1;
                        i = 1;
                    } else {
                        hashSet.add(strM);
                        if (!bw.a(this.i, strM)) {
                            i = 2;
                        }
                    }
                } else {
                    if (aVar.q() == 512) {
                        try {
                            JSONObject jSONObject = new JSONObject(aVar.r());
                            iOptInt = jSONObject.optInt("fb_act", i2);
                            try {
                                zB = bw.b(this.i, jSONObject.optString("page", ""));
                            } catch (Throwable unused) {
                                zB = false;
                            }
                        } catch (Throwable unused2) {
                            iOptInt = 0;
                        }
                        if (!zB) {
                            if (iOptInt == 1 || iOptInt != 2) {
                                i = 1;
                            } else if (TextUtils.isEmpty(strM) || !bw.a(this.i, strM)) {
                                i = 2;
                            }
                        }
                    } else {
                        i = 1;
                    }
                    i2 = 0;
                }
            }
            if (i2 == 0) {
                if (this.D != null) {
                    XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.i, this, aVar);
                    xAdNativeResponse.setIsDownloadApp(i == 2);
                    xAdNativeResponse.setAdActionType(i);
                    arrayList.add(xAdNativeResponse);
                } else if (this.E != null) {
                    bs bsVar = new bs(this.i, this, aVar);
                    bsVar.a(i);
                    arrayList2.add(bsVar);
                } else if (this.F != null) {
                    arrayList3.add(new XAdEntryResponse(this.i, this, aVar));
                }
            }
            i3++;
            i2 = 0;
        }
        g.a aVar2 = this.D;
        if (aVar2 != null) {
            this.f1806a = arrayList;
            aVar2.a(arrayList);
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            this.t = arrayList2;
            expressAdListener.onNativeLoad(arrayList2);
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            this.u = arrayList3;
            entryAdListener.onNativeLoad(arrayList3);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.b(i, str, xAdNativeResponse);
        }
        if (this.E != null) {
            bs bsVar = new bs(this.i, this, null);
            bsVar.a(str2);
            this.E.onNativeFail(i, str, bsVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i, String str, String str2) {
        if (this.D != null) {
            XAdNativeResponse xAdNativeResponse = new XAdNativeResponse(this.i, this, null);
            xAdNativeResponse.setNoAdUniqueId(str2);
            this.D.a(i, str, xAdNativeResponse);
        }
        if (this.E != null) {
            bs bsVar = new bs(this.i, this, null);
            bsVar.a(str2);
            this.E.onNoAd(i, str, bsVar);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f1806a != null) {
            while (i < this.f1806a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.a(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.t != null) {
            while (i < this.t.size()) {
                bs bsVar = (bs) this.t.get(i);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.c();
                }
                i++;
            }
            return;
        }
        if (this.F == null || TextUtils.isEmpty(message) || this.u == null) {
            return;
        }
        while (i < this.u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.u.get(i);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onADExposed();
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i = 0;
        if (this.D != null && data != null && this.f1806a != null) {
            String str = (String) data.get("instanceInfo");
            while (i < this.f1806a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.D.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i++;
            }
            return;
        }
        if (this.F == null || data == null || this.u == null) {
            return;
        }
        String str2 = (String) data.get("instanceInfo");
        while (i < this.u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.u.get(i);
            if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.D != null && !TextUtils.isEmpty(message) && this.f1806a != null) {
            while (i < this.f1806a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.D.b(xAdNativeResponse);
                }
                i++;
            }
            return;
        }
        if (this.E != null && !TextUtils.isEmpty(message) && this.t != null) {
            while (i < this.t.size()) {
                bs bsVar = (bs) this.t.get(i);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.b();
                }
                i++;
            }
            return;
        }
        if (this.F == null || TextUtils.isEmpty(message) || this.u == null) {
            return;
        }
        while (i < this.u.size()) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.u.get(i);
            if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdClick();
            }
            i++;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.F;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        g.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.E;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f1806a != null) {
            for (int i = 0; i < this.f1806a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.t != null) {
            for (int i2 = 0; i2 < this.t.size(); i2++) {
                bs bsVar = (bs) this.t.get(i2);
                if (TextUtils.equals(str, bsVar.a())) {
                    bsVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.u == null) {
            return;
        }
        for (int i3 = 0; i3 < this.u.size(); i3++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.u.get(i3);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f1806a != null) {
            for (int i = 0; i < this.f1806a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            bs bsVar = (bs) this.t.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.g();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f1806a != null) {
            for (int i = 0; i < this.f1806a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            bs bsVar = (bs) this.t.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.h();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f1806a != null) {
            for (int i = 0; i < this.f1806a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            bs bsVar = (bs) this.t.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f1806a != null) {
            for (int i = 0; i < this.f1806a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f1806a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.t == null) {
            return;
        }
        for (int i2 = 0; i2 < this.t.size(); i2++) {
            bs bsVar = (bs) this.t.get(i2);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.b(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap map2 = new HashMap(map);
        HashMap<String, String> map3 = new HashMap<>();
        int i = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (map2.containsKey(str)) {
                String str2 = (String) map2.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                    map3.put(str, str2);
                    i = length;
                }
            }
        }
        for (String str3 : ArticleInfo.PREDEFINED_KEYS_UNLIMITED) {
            if (map2.containsKey(str3)) {
                String str4 = (String) map2.remove(str3);
                if (!TextUtils.isEmpty(str4)) {
                    map3.put(str3, str4);
                }
            }
        }
        if (!map2.isEmpty()) {
            for (String str5 : map2.keySet()) {
                if (!TextUtils.isEmpty(str5)) {
                    String str6 = (String) map2.get(str5);
                    if (!TextUtils.isEmpty(str6)) {
                        int length2 = i + str5.length() + str6.length();
                        if (length2 >= 150) {
                            break;
                        }
                        map3.put("c_" + str5, str6);
                        i = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.o = map3;
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> mapA = m.a(map);
            if (this.o == null) {
                this.o = new HashMap<>();
            }
            if (mapA.isEmpty()) {
                return;
            }
            for (String str : mapA.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = mapA.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.o.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.x);
            this.m.createProdHandler(jSONObject2);
            this.m.setAdContainer(this.h);
            m();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.x);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.y);
            if (cs.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            if ("video".equals(this.x)) {
                jSONObject.put("at", "10");
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.z);
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, "" + this.A);
            jSONObject.put("msa", this.K ? 16527 : MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE);
            jSONObject = m.a(jSONObject, b(this.o));
            jSONObject.put("opt", this.H);
            if (this.H == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.v);
            jSONObject.put("isCacheVideo", this.w);
            jSONObject.put("cacheVideoOnlyWifi", this.C);
            RequestParameters requestParameters = this.B;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
            jSONObject.put("reward_on_downloaded", this.L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }
}
