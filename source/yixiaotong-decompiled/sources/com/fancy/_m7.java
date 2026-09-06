package com.fancy;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.model.AdSlot;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m7 {
    public static final AtomicBoolean _a = new AtomicBoolean(false);

    public class _a implements Runnable {
        public final /* synthetic */ AtomicBoolean _a;
        public final /* synthetic */ _b4 _b;

        public _a(AtomicBoolean atomicBoolean, _b4 _b4Var) {
            this._a = atomicBoolean;
            this._b = _b4Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this._a.compareAndSet(false, true)) {
                _m7._a.set(false);
                _m7._a((_b4<Boolean>) this._b, PtgRewardConstant.ServerErr.ERR_TIMEOUT, (String) null);
            }
        }
    }

    public class _b implements _e7 {
        public final /* synthetic */ AtomicBoolean _a;
        public final /* synthetic */ Handler _b;
        public final /* synthetic */ Runnable _c;
        public final /* synthetic */ _b4 _d;

        public class _a implements Runnable {
            public final /* synthetic */ int _a;
            public final /* synthetic */ String _b;

            public _a(int i, String str) {
                this._a = i;
                this._b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (this._a == 0 || TextUtils.isEmpty(this._b)) {
                    _m7._a((_b4<Boolean>) _b.this._d, PtgRewardConstant.ServerErr.ERR_SERVER, (String) null);
                    return;
                }
                try {
                    try {
                        _b.this._d._a(Boolean.valueOf(new JSONObject(this._b).optBoolean("isValid", false)));
                    } catch (Throwable unused) {
                    }
                } catch (Exception e) {
                    _m7._a((_b4<Boolean>) _b.this._d, PtgRewardConstant.ServerErr.ERR_PAR, e.getMessage());
                }
            }
        }

        public _b(AtomicBoolean atomicBoolean, Handler handler, _a _aVar, _b4 _b4Var) {
            this._a = atomicBoolean;
            this._b = handler;
            this._c = _aVar;
            this._d = _b4Var;
        }

        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar) {
        }

        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar, int i, String str) {
            if (this._a.compareAndSet(false, true)) {
                this._b.removeCallbacks(this._c);
                _m7._a.set(false);
                com.fancy.adsdk.lib.utils._d._c(new _a(i, str));
            }
        }
    }

    public static String _a(String str, LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (!linkedHashMap.isEmpty()) {
            String str2 = str.contains("?") ? str.endsWith("?") ? "" : "&" : "?";
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                sb.append(str2).append(com.fancy.adsdk.lib.utils._a._b((String) entry.getKey())).append('=').append(com.fancy.adsdk.lib.utils._a._b((String) entry.getValue()));
                str2 = "&";
            }
        }
        return sb.toString();
    }

    public static LinkedHashMap _a(AdSlot adSlot, String str, int i) {
        String mediaSecret = PtgAdSdk.getConfig().getMediaSecret();
        String mediaId = PtgAdSdk.getConfig().getMediaId();
        String ptgSlotID = adSlot.getPtgSlotID();
        String userID = adSlot.getUserID();
        String str_l = adSlot._l();
        String mediaExtra = adSlot.getMediaExtra();
        String string = mediaSecret + x.bQ + str_l;
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(string.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            string = sb.toString();
        } catch (Exception unused) {
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(_m9._a("1"), userID);
        linkedHashMap.put(_m9._a("2"), str_l);
        linkedHashMap.put(_m9._a("3"), str);
        linkedHashMap.put(_m9._a("4"), String.valueOf(i));
        linkedHashMap.put(_m9._a("5"), mediaExtra);
        linkedHashMap.put(_m9._a("6"), string);
        linkedHashMap.put(_m9._a("7"), mediaId);
        linkedHashMap.put(_m9._a("8"), ptgSlotID);
        return linkedHashMap;
    }

    public static void _a(String str, AdSlot adSlot, String str2, int i, _b4<Boolean> _b4Var) {
        AtomicBoolean atomicBoolean = _a;
        if (atomicBoolean.compareAndSet(false, true)) {
            if (-1 != _gx._b(PtgAdSdk.getContext())) {
                if (TextUtils.isEmpty(str) || adSlot == null) {
                    atomicBoolean.set(false);
                    _a(_b4Var, PtgRewardConstant.ServerErr.ERR_BODY, (String) null);
                    return;
                }
                try {
                    String str_a = _a(str, _a(adSlot, str2, i));
                    if (TextUtils.isEmpty(str_a)) {
                        atomicBoolean.set(false);
                        _a(_b4Var, PtgRewardConstant.ServerErr.ERR_PARAMS, (String) null);
                        return;
                    }
                    AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
                    Handler handler = new Handler(Looper.getMainLooper());
                    _a _aVar = new _a(atomicBoolean2, _b4Var);
                    if (!handler.postDelayed(_aVar, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
                        if (atomicBoolean2.compareAndSet(false, true)) {
                            atomicBoolean.set(false);
                            _a(_b4Var, PtgRewardConstant.ServerErr.ERR_TIMEOUT, (String) null);
                            return;
                        }
                        return;
                    }
                    _b _bVar = new _b(atomicBoolean2, handler, _aVar, _b4Var);
                    NetUtils._f _fVar = NetUtils._a;
                    com.fancy.adsdk.lib.core.net._a _aVar2 = new com.fancy.adsdk.lib.core.net._a(str_a);
                    _aVar2._d = "GET";
                    _aVar2._h = _bVar;
                    NetUtils._b.offer(_aVar2);
                    return;
                } catch (Exception e) {
                    _a.set(false);
                    _a(_b4Var, PtgRewardConstant.ServerErr.ERR_PARAMS, e.getMessage());
                    return;
                }
            }
            atomicBoolean.set(false);
            _a(_b4Var, PtgRewardConstant.ServerErr.ERR_NET, (String) null);
        }
    }

    public static void _a(_b4<Boolean> _b4Var, PtgRewardConstant.ServerErr serverErr, String str) {
        if (_b4Var == null) {
            return;
        }
        String msg = str == null ? serverErr.getMsg() : serverErr.getMsg() + " : " + str;
        try {
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            adErrorImpl._a = serverErr.getCode();
            adErrorImpl._b = msg;
            _b4Var.onError(adErrorImpl);
        } catch (Throwable unused) {
        }
    }
}
