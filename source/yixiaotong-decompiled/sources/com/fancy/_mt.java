package com.fancy;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.alipay.sdk.tid.b;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.bi;
import com.meishu.sdk.core.view.DownloadView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mt implements _md {
    public boolean _A;
    public AtomicBoolean _B;
    public _lp _a;
    public _f _b;
    public AdSlot _c;
    public _f0 _d;
    public String _e;
    public String _g;
    public String _h;
    public int _i;
    public int _j;
    public WeakReference<PtgBaseVideoActivity> _m;
    public FrameLayout _n;
    public ProgressBar _o;
    public boolean _q;
    public boolean _r;
    public FrameLayout _s;
    public _jd _t;
    public boolean _u;
    public _l6 _x;
    public boolean _f = false;
    public boolean _k = false;
    public boolean _l = false;
    public int _p = -1;
    public final AtomicBoolean _v = new AtomicBoolean();
    public final AtomicBoolean _w = new AtomicBoolean();
    public boolean _y = false;
    public Handler _z = new Handler(Looper.getMainLooper());
    public final _a _C = new _a();
    public final _b _D = new _b();

    public class _b implements PtgAppDownloadListener {
        public _b() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str) {
            _m8._a()._a(_mt.this._e, j, j2, str);
            if (j > 0) {
                _mt _mtVar = _mt.this;
                Object[][] objArr = {new Object[]{"progress", Float.valueOf((float) ((j2 * 100.0d) / j))}};
                _mtVar.getClass();
                _mtVar._a("onDownloadProgressUpdate", _mt._a(objArr));
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadCancel() {
            _m8._a()._c(_mt.this._e);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadFailed(String str) {
            _m8._a()._a(_mt.this._e, str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadFinished(String str) {
            _m8._a()._b(_mt.this._e, str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str) {
            _m8._a()._b(_mt.this._e, j, j2, str);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onIdle() {
            _m8._a()._d(_mt.this._e);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onInstalled(String str) {
            _m8._a()._c(_mt.this._e, str);
        }
    }

    public class _d implements _lp._c {
        public _d() {
        }

        public final void _a(String str) {
            _mt _mtVar = _mt.this;
            String[][] strArr = {new String[]{"state", "error"}, new String[]{b.f, String.valueOf(System.currentTimeMillis())}};
            _mtVar.getClass();
            _mtVar._a("onVideoStateChanged", _mt._a(strArr));
            _mt _mtVar2 = _mt.this;
            _mtVar2._A = true;
            ProgressBar progressBar = _mtVar2._o;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.SUC_ERR;
            _mtVar2._a(serverErr.getCode(), serverErr.getMsg(), false);
            _m8._a()._a(_mtVar2._e, PtgErrorCode.SDK_RESOURCE_ERROR, str);
            PtgBaseVideoActivity ptgBaseVideoActivity = _mtVar2._m.get();
            WeakReference<Toast> weakReference = _on._a;
            Context origApplicationContext = StubApp.getOrigApplicationContext(ptgBaseVideoActivity.getApplicationContext());
            Toast toast = _on._a.get();
            if (toast != null) {
                toast.cancel();
            }
            Toast toastMakeText = Toast.makeText(origApplicationContext, "领取奖励成功", 1);
            toastMakeText.show();
            _on._a = new WeakReference<>(toastMakeText);
            if (_mtVar2._m.get() != null) {
                _mtVar2._m.get()._a();
            }
        }
    }

    public static String _a(Object[][] objArr) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Object[] objArr2 : objArr) {
                if (objArr2 != null && objArr2.length >= 2) {
                    Object obj = objArr2[0];
                    if (obj instanceof String) {
                        String str = (String) obj;
                        Object objValueOf = objArr2[1];
                        if (objValueOf == null) {
                            objValueOf = JSONObject.NULL;
                        } else if (!(objValueOf instanceof Number) && !(objValueOf instanceof Boolean) && !(objValueOf instanceof JSONObject) && !(objValueOf instanceof JSONArray)) {
                            objValueOf = String.valueOf(objValueOf);
                        }
                        jSONObject.put(str, objValueOf);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public static void _a(_mt _mtVar, int i, JSONObject jSONObject) {
        PtgBaseVideoActivity ptgBaseVideoActivity = _mtVar._m.get();
        if (ptgBaseVideoActivity == null) {
            return;
        }
        if (i == 2) {
            ptgBaseVideoActivity._a();
            return;
        }
        if (i == 5) {
            String strOptString = jSONObject.optString("feedbackUrl", null);
            if (TextUtil.isNotEmpty(strOptString)) {
                _di _diVar = new _di(ptgBaseVideoActivity);
                _diVar.setWebViewBridgeListener(new _mv(_mtVar, _diVar, ptgBaseVideoActivity));
                _diVar._a(strOptString, _mtVar._n);
                return;
            }
            return;
        }
        Object tag = _mtVar._s.getTag(R.id.fancy_native_view_tag);
        if (tag instanceof _ok) {
            _ok _okVar = (_ok) tag;
            int iOptInt = jSONObject.optInt("dx", -1);
            int iOptInt2 = jSONObject.optInt("dy", -1);
            int iOptInt3 = jSONObject.optInt("ux", -1);
            int iOptInt4 = jSONObject.optInt("uy", -1);
            long jOptLong = jSONObject.optLong(CrashHianalyticsData.TIME, -1L);
            if (iOptInt != -1 && iOptInt2 != -1 && iOptInt3 != -1 && iOptInt4 != -1 && jOptLong != -1) {
                _okVar._a = iOptInt;
                _okVar._b = iOptInt2;
                _okVar._d = iOptInt3;
                _okVar._e = iOptInt4;
                _okVar._f = System.currentTimeMillis();
                _okVar._c = System.currentTimeMillis();
            }
        }
        int i2 = 6;
        if (i != 6) {
            i2 = i == 1 ? 4 : 0;
        }
        _mtVar._a(_mtVar._s, i2, null, false);
    }

    public static void _b(_mt _mtVar) {
        _f _fVar;
        if (_mtVar._f) {
            if (!_mtVar._q || !_mtVar._r) {
                return;
            }
        } else if (!_mtVar._q) {
            return;
        }
        if (_mtVar._v.compareAndSet(false, true)) {
            _n1._a(_mtVar._n, _mtVar._b);
            AtomicBoolean atomicBoolean = _mtVar._B;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
                _m8._a()._a(_mtVar._e);
            }
            WeakReference<PtgBaseVideoActivity> weakReference = _mtVar._m;
            PtgBaseVideoActivity ptgBaseVideoActivity = weakReference != null ? weakReference.get() : null;
            if (ptgBaseVideoActivity == null || (_fVar = _mtVar._b) == null || _mtVar._t == null || _mtVar._u) {
                return;
            }
            _mtVar._u = true;
            _fVar._K = System.currentTimeMillis();
            _mtVar._t._a(ptgBaseVideoActivity);
        }
    }

    @Override // com.fancy._md
    public final void _a() {
    }

    @Override // com.fancy._md
    public final void _b() {
    }

    @Override // com.fancy._md
    public final void _c() {
    }

    @Override // com.fancy._md
    public final void _d() {
        _lp _lpVar = this._a;
        if (_lpVar != null) {
            _lpVar._h = true;
            NiceVideoPlayer niceVideoPlayer = _lpVar._a;
            if (niceVideoPlayer != null) {
                niceVideoPlayer._c();
                _lpVar._a = null;
            }
            if (_lpVar._b != null) {
                _lpVar._b = null;
            }
            AdTemplateWebView adTemplateWebView = _lpVar._c;
            if (adTemplateWebView != null) {
                adTemplateWebView.destroy();
                _lpVar._c = null;
            }
            ImageView imageView = _lpVar._d;
            if (imageView != null) {
                imageView.setImageBitmap(null);
                _lpVar._d = null;
            }
            _lpVar._f = null;
            this._a = null;
        }
        Handler handler = this._z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this._z = null;
        }
        _jd _jdVar = this._t;
        if (_jdVar != null) {
            _jdVar._c();
            _jdVar._c = null;
            _jdVar._d = null;
            _jdVar._o = null;
            this._t = null;
        }
        WeakReference<PtgBaseVideoActivity> weakReference = this._m;
        if (weakReference != null) {
            weakReference.clear();
            this._m = null;
        }
        _f _fVar = this._b;
        if (_fVar != null && _fVar._a == 0) {
            String str = _fVar._i;
            HashMap map = _cv._a;
            if (!TextUtils.isEmpty(str)) {
                _cv._a.remove(com.fancy.adsdk.lib.utils._a._c(str));
            }
        }
        _m8 _m8Var_a = _m8._a();
        String str2 = this._e;
        if (str2 == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str2);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdClose();
                }
            }
        }
        _m8._a()._b(this._e);
    }

    public final String _e() {
        _f0 _f0Var;
        List<Integer> list;
        _f _fVar = this._b;
        if (_fVar == null || TextUtil.isEmpty(_fVar._M) || this._m.get() == null || (_f0Var = this._b._E) == null || _f0Var._h == null) {
            return "";
        }
        PtgBaseVideoActivity ptgBaseVideoActivity = this._m.get();
        String strReplace = this._b._M;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", ScreenUtils.getScreenWidth(ptgBaseVideoActivity));
            jSONObject.put("height", ScreenUtils.getScreenHeight(ptgBaseVideoActivity));
            jSONObject.put("safeBottom", ScreenUtils.dpToPx(ptgBaseVideoActivity, 9.0f));
            jSONObject.put("hideAdFeedBack", this._b._V);
            _i _iVar = this._b._s;
            if (_iVar != null) {
                jSONObject.put("showShake", _iVar._c());
            }
            strReplace = strReplace.replace("__E__", jSONObject.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ba.at, this._b._j());
            jSONObject2.put(CrashHianalyticsData.TIME, this._f ? this._b._e() : 10);
            boolean z = false;
            jSONObject2.put("muted", this._d._b == 1);
            jSONObject2.put("taskSubedTime", this._b._E._h._b);
            jSONObject2.put("taskWindowShowTime", this._b._E._h._a);
            jSONObject2.put("taskType", this._b._a == 0 ? 2 : 1);
            _i _iVar2 = this._b._s;
            jSONObject2.put("isFullCli", _iVar2 != null && _iVar2._d() && (list = _iVar2._g) != null && list.contains(2));
            _i _iVar3 = this._b._s;
            if (_iVar3 != null && _iVar3._b()) {
                z = true;
            }
            jSONObject2.put("isFc", z);
            _i _iVar4 = this._b._s;
            jSONObject2.put("fcDly", _iVar4 != null ? _iVar4._a() : 0L);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", this._g);
            jSONObject3.put(IAdInterListener.AdReqParam.WIDTH, this._i);
            jSONObject3.put(IAdInterListener.AdReqParam.HEIGHT, this._j);
            if (this._b._u()) {
                jSONObject2.put("video", jSONObject3);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject3);
                jSONObject2.put(bi.Code, jSONArray);
            }
            AppInfo appInfo = this._b._c;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("title", this._b._l());
            jSONObject4.put("desc", this._b._d());
            jSONObject4.put("logo", this._b._i());
            if (appInfo != null) {
                jSONObject4.put("name", appInfo.getName());
                jSONObject4.put("desc_url", appInfo.getFunctionDescUrl());
                jSONObject4.put("package_name", appInfo.getPackage_name());
                jSONObject4.put(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PERMISSION, appInfo.getPermissionProtocolUrl());
                jSONObject4.put("developer", appInfo.getDevelopers());
                jSONObject4.put("version", appInfo.getAppVersion());
                jSONObject4.put(DownloadView.CLICK_DOWNLOAD_INFO_TYPE_PRIVACY, appInfo.getPrivacyProtocolUrl());
            }
            jSONObject2.put("appInfo", jSONObject4);
            jSONObject2.put("reqId", this._b._w);
            AdSlot adSlot = this._c;
            if (adSlot != null) {
                _c7 _c7Var_m = adSlot._m();
                jSONObject2.put("devInfo", _c7Var_m != null ? _c7Var_m._a() : "");
            }
            return strReplace.replace("__C__", jSONObject2.toString());
        } catch (JSONException unused) {
            return strReplace;
        }
    }

    @Override // com.fancy._md
    public final void onWindowFocusChanged(boolean z) {
        if (!z) {
            _jd _jdVar = this._t;
            if (_jdVar != null) {
                _ng._a(_jdVar._b);
            }
            _a("onPageVisibilityChanged", _a(new Object[][]{new Object[]{"hidden", Boolean.TRUE}}));
            return;
        }
        _jd _jdVar2 = this._t;
        if (_jdVar2 != null) {
            _jdVar2._a(this._y);
        }
        _a("onPageVisibilityChanged", _a(new Object[][]{new Object[]{"hidden", Boolean.FALSE}}));
        _cv._a(PtgAdSdk.getContext(), this._b);
    }

    public class _a implements _jd._b {
        public _a() {
        }

        @Override // com.fancy._jd._b
        public final void _a(View view, int i, _oj _ojVar) {
            _mt.this._a("onShakeTriggered", null);
            _mt _mtVar = _mt.this;
            _mtVar._a(view, i, _ojVar, true);
            FrameLayout frameLayout = _mtVar._s;
            if (frameLayout != null) {
                _n1._a(frameLayout, view, (View) null);
            }
        }

        @Override // com.fancy._jd._b
        public final void _b(View view, int i, _oj _ojVar) {
            _mt.this._a(view, i, _ojVar, false);
        }

        @Override // com.fancy._jd._b
        public final void _a(boolean z) {
            _mt _mtVar = _mt.this;
            Object[][] objArr = {new Object[]{"visible", Boolean.valueOf(z)}};
            _mtVar.getClass();
            _mtVar._a("onShakeViewChange", _mt._a(objArr));
        }
    }

    public class _c implements _eq {
        public _c() {
        }

        @Override // com.fancy._eq
        public final void _a() {
        }

        @Override // com.fancy._eq
        public final void _a(int i) {
            if (-1 == i) {
                _mt _mtVar = _mt.this;
                _mtVar.getClass();
                _mtVar._a("onDownloadStatusChange", _mt._a(new Object[][]{new Object[]{"downloadStatus", 1}}));
            }
            _mt _mtVar2 = _mt.this;
            _jd _jdVar = _mtVar2._t;
            if (_jdVar != null) {
                _jdVar._a(_mtVar2._y);
            }
        }

        @Override // com.fancy._eq
        public final void _b() {
            _mt _mtVar = _mt.this;
            _mtVar.getClass();
            _mtVar._a("onDownloadStatusChange", _mt._a(new Object[][]{new Object[]{"downloadStatus", 1}}));
        }

        @Override // com.fancy._eq
        public final void _a(String str) {
            _m8._a()._a(_mt.this._e, PtgErrorCode.SDK_RESOURCE_ERROR, str);
        }
    }

    public static void _a(_mt _mtVar) {
        if (_mtVar._w.compareAndSet(false, true)) {
            ProgressBar progressBar = _mtVar._o;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            WeakReference<PtgBaseVideoActivity> weakReference = _mtVar._m;
            PtgBaseVideoActivity ptgBaseVideoActivity = weakReference != null ? weakReference.get() : null;
            if (ptgBaseVideoActivity instanceof PtgRewardVideoPortraitActivity) {
                PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = (PtgRewardVideoPortraitActivity) ptgBaseVideoActivity;
                if (ptgRewardVideoPortraitActivity.isFinishing() || !ptgRewardVideoPortraitActivity._L.compareAndSet(false, true)) {
                    return;
                }
                ptgRewardVideoPortraitActivity.runOnUiThread(new _kn(ptgRewardVideoPortraitActivity));
            }
        }
    }

    public final void _a(String str, String str2) {
        AdTemplateWebView adTemplateWebView;
        _lp _lpVar = this._a;
        if (_lpVar == null || _lpVar._h || (adTemplateWebView = _lpVar._c) == null) {
            return;
        }
        adTemplateWebView.post(new _2(adTemplateWebView, str, str2));
    }

    public final void _a(int i, String str, boolean z) {
        int rewardAmount;
        String rewardName;
        int i2;
        _m8 _m8Var_a = _m8._a();
        String str2 = this._e;
        Bundle bundle = new Bundle();
        bundle.putInt(PtgRewardConstant.REWARD_PARAMS.SERVER_CODE, i);
        bundle.putString(PtgRewardConstant.REWARD_PARAMS.SERVER_MSG, str);
        AdSlot adSlot = this._c;
        _f0 _f0Var = this._d;
        if (adSlot != null && adSlot.getRewardAmount() > 0) {
            rewardAmount = adSlot.getRewardAmount();
        } else if (_f0Var == null || (rewardAmount = _f0Var._e) <= 0) {
            rewardAmount = 0;
        }
        bundle.putInt("reward_amount", rewardAmount);
        AdSlot adSlot2 = this._c;
        _f0 _f0Var2 = this._d;
        if (adSlot2 == null || TextUtils.isEmpty(adSlot2.getRewardName())) {
            rewardName = (_f0Var2 == null || TextUtils.isEmpty(_f0Var2._d)) ? "" : _f0Var2._d;
        } else {
            rewardName = adSlot2.getRewardName();
        }
        bundle.putString("reward_name", rewardName);
        if (this._A) {
            i2 = 3;
        } else {
            i2 = this._p > 0 ? 2 : 1;
        }
        bundle.putInt("reward_type", i2);
        AdSlot adSlot3 = this._c;
        if (adSlot3 != null) {
            bundle.putString("extra", adSlot3.getMediaExtra());
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, this._c.getUserID());
        } else {
            bundle.putString("extra", "");
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, "");
        }
        if (str2 == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str2);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onRewardVerify(z, bundle);
                }
            }
        }
        this._k = true;
    }

    public final void _a(View view, int i, _oj _ojVar, boolean z) {
        if (view == null || this._b == null) {
            return;
        }
        AdSlot adSlot = this._c;
        if (adSlot != null) {
            adSlot._e(i);
        }
        this._y = true;
        _f _fVar = this._b;
        _fVar._v = _ojVar;
        _de._a(_fVar);
        boolean z2 = z && this._b._r();
        _f _fVar2 = this._b;
        if (z2) {
            i = 0;
        }
        _n1._a(view, _fVar2, i);
        _m8 _m8Var_a = _m8._a();
        String str = this._e;
        if (str == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdVideoBarClick();
                }
            }
        }
        _b3._a(view.getContext(), this._b, this._c, new _c());
        _jd _jdVar = this._t;
        if (_jdVar != null) {
            _kr._a(_jdVar._j, _jdVar._l);
            this._t._c();
        }
    }

    @Override // com.fancy._md
    public final void _a(PtgBaseVideoActivity ptgBaseVideoActivity, PtgRewardVideoPortraitActivity._a _aVar, AtomicBoolean atomicBoolean) {
        _f0 _f0Var;
        NiceVideoPlayer niceVideoPlayer;
        WeakReference<PtgBaseVideoActivity> weakReference = new WeakReference<>(ptgBaseVideoActivity);
        this._m = weakReference;
        this._B = atomicBoolean;
        PtgBaseVideoActivity ptgBaseVideoActivity2 = weakReference.get();
        if (ptgBaseVideoActivity2 != null) {
            this._e = ptgBaseVideoActivity2.getIntent().getStringExtra("VIDEO_ADVERT_ID");
            this._b = (_f) _m8._a()._a.get(this._e);
            this._c = (AdSlot) _m8._a()._b.get(this._e);
            this._x = new _l6();
            _f _fVar = this._b;
            if (_fVar != null && (_f0Var = _fVar._E) != null) {
                this._d = _f0Var;
                boolean z_u = _fVar._u();
                this._f = z_u;
                if (z_u) {
                    _l3 _l3Var_m = this._b._m();
                    if (_l3Var_m != null) {
                        this._i = _l3Var_m._c;
                        this._j = _l3Var_m._d;
                        this._g = _l3Var_m._a;
                        this._h = _l3Var_m._b;
                    }
                } else {
                    _jz _jzVar_f = this._b._f();
                    if (_jzVar_f != null) {
                        this._i = _jzVar_f._b;
                        this._j = _jzVar_f._c;
                        this._g = _jzVar_f._a;
                    }
                }
                if (!TextUtil.isEmpty(this._g)) {
                    _f _fVar2 = this._b;
                    if (_fVar2 != null && _fVar2._a == 0) {
                        String str = _fVar2._i;
                        _b _bVar = this._D;
                        HashMap map = _cv._a;
                        if (!TextUtils.isEmpty(str) && _bVar != null) {
                            String str_c = com.fancy.adsdk.lib.utils._a._c(str);
                            HashMap map2 = _cv._a;
                            if (map2.containsKey(str_c)) {
                                map2.remove(str_c);
                            }
                            map2.put(str_c, _bVar);
                        }
                    }
                    this._n = (FrameLayout) ptgBaseVideoActivity.findViewById(R.id.ptg_video_reward_container);
                    this._s = (FrameLayout) ptgBaseVideoActivity.findViewById(R.id.ptg_reward_root);
                    this._o = (ProgressBar) ptgBaseVideoActivity.findViewById(R.id.ptg_reward_playable_loading);
                    _p5._a((ImageView) ptgBaseVideoActivity.findViewById(R.id.ptg_sdk_ad_logo_iv));
                    _jd _jdVar = new _jd(this._b, this._C);
                    this._t = _jdVar;
                    FrameLayout frameLayout = this._s;
                    _jdVar._c = frameLayout;
                    _jdVar._d = frameLayout;
                    _n1._a(frameLayout, frameLayout, (View) null);
                    ProgressBar progressBar = this._o;
                    if (progressBar != null) {
                        progressBar.setVisibility(0);
                    }
                    _lp._b _bVar2 = new _lp._b();
                    _bVar2._a = this._d._a;
                    _bVar2._b = this._i;
                    _bVar2._c = this._j;
                    _bVar2._e = this._f;
                    _bVar2._d = this._g;
                    _lp _lpVar = new _lp(ptgBaseVideoActivity, _bVar2);
                    this._a = _lpVar;
                    _lpVar.setContainerListener(new _d());
                    this._n.addView(this._a, new FrameLayout.LayoutParams(-1, -1));
                    if (this._f) {
                        _lp _lpVar2 = this._a;
                        String str2 = this._g;
                        String str3 = this._h;
                        _lpVar2.setAdType(_3.VIDEO);
                        _lpVar2._a();
                        if (!TextUtil.isEmpty(str3)) {
                            str2 = str3;
                        }
                        _lpVar2._a(str2);
                        if (!_lpVar2._h && (niceVideoPlayer = _lpVar2._a) != null) {
                            if (niceVideoPlayer._l == 4) {
                                NiceVideoPlayer._a(new _hf(niceVideoPlayer));
                            } else {
                                niceVideoPlayer._d();
                            }
                        }
                        if (this._a != null) {
                            this._a._c.loadDataWithBaseURL(null, _e(), "text/html", "UTF-8", null);
                        }
                        this._a.setMute(this._d._b == 1);
                    } else {
                        this._a._b(_e());
                    }
                    this._z.postDelayed(new _mu(this), 5000L);
                    return;
                }
            }
        }
        _m8 _m8Var_a = _m8._a();
        String str4 = this._e;
        AdErrorImpl adErrorImpl = new AdErrorImpl();
        adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
        adErrorImpl._b = "数据初始化失败";
        _m8Var_a._a(str4, adErrorImpl);
        ptgBaseVideoActivity._a();
    }
}
