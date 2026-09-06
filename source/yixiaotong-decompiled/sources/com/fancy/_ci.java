package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ci {
    public Set<String> _H;
    public String _O;
    public String _P;
    public boolean _Q;
    public boolean _R;
    public String _c;
    public int _d;
    public _cd _m;
    public int _n;
    public long _o;
    public boolean _p;
    public String _q;
    public String _r;
    public String _s;
    public String _t;
    public String _u;
    public String _v;
    public String _w;
    public String _x;
    public String _a = "";
    public long _b = 0;
    public int _e = 1;
    public int _f = 0;
    public double _g = 1.0d;
    public long _h = 0;
    public long _i = 0;
    public int _S = 1;
    public String _T = "";
    public HashSet _j = new HashSet();
    public HashSet _k = new HashSet();
    public HashSet _l = new HashSet();
    public HashSet _M = new HashSet();
    public HashSet _N = new HashSet();
    public HashSet _K = new HashSet();
    public HashSet _L = new HashSet();
    public Set<String> _y = new HashSet();
    public Set<String> _z = new HashSet();
    public Set<String> _A = new HashSet();
    public Set<String> _B = new HashSet();
    public Set<String> _C = new HashSet();
    public Set<String> _D = new HashSet();
    public Set<String> _E = new HashSet();
    public Set<String> _F = new HashSet();
    public Set<String> _G = new HashSet();
    public Set<String> _I = new HashSet();
    public Set<String> _J = new HashSet();

    public final Set<String> _c() {
        if (this._y.isEmpty()) {
            String str = TextUtils.isEmpty(this._r) ? this._q : this._r;
            if (!TextUtils.isEmpty(str)) {
                this._y.add(str);
            }
        }
        return this._y;
    }

    public final Set<String> _d() {
        if (this._A.isEmpty()) {
            String str = TextUtils.isEmpty(this._t) ? this._q : this._t;
            if (!TextUtils.isEmpty(str)) {
                this._A.add(str);
            }
        }
        return this._A;
    }

    public final String _e() {
        return TextUtils.isEmpty(this._P) ? this._T : this._P;
    }

    public final Set<String> _g() {
        if (this._B.isEmpty()) {
            String str = TextUtils.isEmpty(this._u) ? this._q : this._u;
            if (!TextUtils.isEmpty(str)) {
                this._B.add(str);
            }
        }
        return this._B;
    }

    public final Set<String> _h() {
        if (this._z.isEmpty()) {
            String str = TextUtils.isEmpty(this._t) ? this._q : this._s;
            if (!TextUtils.isEmpty(str)) {
                this._z.add(str);
            }
        }
        return this._z;
    }

    public final int _i() {
        return this._e;
    }

    public final String toString() {
        return _j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_j._a(_ie._a("DispatchPolicyCustomerItem{hashcode='").append(hashCode()).append('\'').append("slotId='"), this._a, '\'', ", adKey=").append(this._b).append(", consumerType='"), this._c, '\'', ", consumerSlotType=").append(this._d).append(", weight=").append(this._e).append(", level=").append(this._f).append(", discRatio=").append(this._g).append(", consumerPrice=").append(this._h).append(", consumerOrgPrice=").append(this._i).append(", targetingGeo=").append(this._j).append(", targetingHour=").append(this._k).append(", targetingOsVersion=").append(this._l).append(", frequencyPolicy=").append(this._m).append(", bidCreativeQuantity=").append(this._n).append(", creativeAliveDuration=").append(this._o).append(", ignore=").append(this._p).append(", tracking='"), this._q, '\'', ", bidTracking='"), this._r, '\'', ", impTracking='"), this._s, '\'', ", clickTracking='"), this._t, '\'', ", errorTracking='"), this._u, '\'', ", bidSucTracking='"), this._v, '\'', ", bidSelectedTracking='"), this._w, '\'', ", dpTracking='"), this._x, '\'', ", bidTrackingUrls=").append(this._y).append(", impTrackingUrls=").append(this._z).append(", clickTrackingUrls=").append(this._A).append(", errorTrackingUrls=").append(this._B).append(", bidSucTrackingUrls=").append(this._C).append(", bidSelectedTrackingUrls=").append(this._D).append(", dpTrackingUrls=").append(this._E).append(", vpTrackingUrls=").append(this._F).append(", filterTrackingUrls=").append(this._G).append(", noticeBidLossTracking=").append(this._I).append(", noticeBidWinTracking=").append(this._J).append(", whitelist=").append(this._K).append(", blockPackets=").append(this._L).append(", blackAppList=").append(this._M).append(", blackKeywordList=").append(this._N).append(", vendorId='"), this._O, '\'', ", consumerSlotId='"), this._P, '\'', ", hotSpot=").append(this._Q).append(", twicePrompt=").append(this._R).append(", layer=").append(this._S).append('}').toString();
    }

    public final Set<String> _a() {
        if (this._D.isEmpty()) {
            String str = this._w;
            if (!TextUtils.isEmpty(str)) {
                this._D.add(str);
            }
        }
        return this._D;
    }

    public final Set<String> _b() {
        if (this._C.isEmpty()) {
            String str = this._v;
            if (!TextUtils.isEmpty(str)) {
                this._C.add(str);
            }
        }
        return this._C;
    }

    public final Set<String> _f() {
        if (this._E.isEmpty()) {
            String str = this._x;
            if (!TextUtils.isEmpty(str)) {
                this._E.add(str);
            }
        }
        return this._E;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x022e  */
    /* JADX WARN: Code duplicated, block: B:103:0x022f A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x023a  */
    /* JADX WARN: Code duplicated, block: B:107:0x023b A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:110:0x0246  */
    /* JADX WARN: Code duplicated, block: B:111:0x0247 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0252  */
    /* JADX WARN: Code duplicated, block: B:115:0x0253 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x025e  */
    /* JADX WARN: Code duplicated, block: B:119:0x025f A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:134:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:138:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:15:0x0083  */
    /* JADX WARN: Code duplicated, block: B:16:0x0085 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x008b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0091 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00af A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00b5 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00c4 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00eb A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00f1 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x0100 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0119  */
    /* JADX WARN: Code duplicated, block: B:48:0x0120 A[Catch: JSONException -> 0x02ca, LOOP:2: B:46:0x011a->B:48:0x0120, LOOP_END, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0138  */
    /* JADX WARN: Code duplicated, block: B:54:0x013f A[Catch: JSONException -> 0x02ca, LOOP:3: B:52:0x0139->B:54:0x013f, LOOP_END, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0157  */
    /* JADX WARN: Code duplicated, block: B:60:0x015e A[Catch: JSONException -> 0x02ca, LOOP:4: B:58:0x0158->B:60:0x015e, LOOP_END, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0172 A[Catch: JSONException -> 0x02ca, TRY_LEAVE, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0196 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01da  */
    /* JADX WARN: Code duplicated, block: B:75:0x01db A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e7 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f3 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ff A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x020a  */
    /* JADX WARN: Code duplicated, block: B:91:0x020b A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0216  */
    /* JADX WARN: Code duplicated, block: B:95:0x0217 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0222  */
    /* JADX WARN: Code duplicated, block: B:99:0x0223 A[Catch: JSONException -> 0x02ca, TryCatch #2 {JSONException -> 0x02ca, blocks: (B:3:0x0005, B:5:0x003f, B:11:0x0074, B:13:0x007b, B:19:0x008c, B:21:0x0093, B:24:0x00a9, B:26:0x00af, B:28:0x00b5, B:30:0x00c4, B:31:0x00c9, B:32:0x00cc, B:35:0x00e5, B:37:0x00eb, B:39:0x00f1, B:41:0x0100, B:42:0x0105, B:43:0x0108, B:46:0x011a, B:48:0x0120, B:49:0x0130, B:52:0x0139, B:54:0x013f, B:55:0x014f, B:58:0x0158, B:60:0x015e, B:61:0x016a, B:63:0x0172, B:65:0x0186, B:67:0x018a, B:69:0x018e, B:71:0x0196, B:72:0x01d6, B:76:0x01e0, B:80:0x01ec, B:84:0x01f8, B:88:0x0204, B:92:0x0210, B:96:0x021c, B:100:0x0228, B:104:0x0234, B:108:0x0240, B:112:0x024c, B:116:0x0258, B:120:0x0264, B:119:0x025f, B:115:0x0253, B:111:0x0247, B:107:0x023b, B:103:0x022f, B:99:0x0223, B:95:0x0217, B:91:0x020b, B:87:0x01ff, B:83:0x01f3, B:79:0x01e7, B:75:0x01db, B:16:0x0085, B:20:0x0091, B:8:0x006d, B:12:0x0079, B:64:0x0177), top: B:131:0x0005, inners: #1 }] */
    public final boolean _a(JSONObject jSONObject, _cj _cjVar, _ck _ckVar) {
        int iOptInt;
        JSONObject jSONObject2;
        long jOptLong;
        JSONObject jSONObject3;
        JSONArray jSONArrayOptJSONArray;
        HashMap map;
        JSONArray jSONArrayOptJSONArray2;
        HashMap map2;
        JSONArray jSONArrayOptJSONArray3;
        JSONArray jSONArrayOptJSONArray4;
        JSONArray jSONArrayOptJSONArray5;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        Set<String> hashSet;
        Set<String> hashSet2;
        Set<String> hashSet3;
        Set<String> hashSet4;
        Set<String> hashSet5;
        Set<String> hashSet6;
        Set<String> hashSet7;
        Set<String> hashSet8;
        Set<String> hashSet9;
        Set<String> hashSet10;
        Set<String> hashSet11;
        Set<String> hashSet12;
        int i;
        int i2;
        int i3;
        int i4;
        JSONObject jSONObject4;
        _aw _awVar_a;
        int i5;
        JSONObject jSONObject5;
        _aw _awVar_a2;
        try {
            this._b = jSONObject.optLong("adKey");
            this._e = jSONObject.optInt("weight");
            this._g = jSONObject.optDouble("discRatio", 1.0d);
            this._S = jSONObject.optInt("layer");
            this._p = jSONObject.optBoolean("ignore");
            this._d = jSONObject.optInt("consumerSlotType");
            try {
                this._f = jSONObject.getInt("level");
            } catch (Exception unused) {
            }
            this._Q = jSONObject.optBoolean("hotSpot");
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("consumer");
            this._c = jSONObjectOptJSONObject3.optString("consumerType");
            this._O = jSONObjectOptJSONObject3.optString("vendorId");
            this._P = jSONObjectOptJSONObject3.optString("consumerSlotId");
            if (!jSONObjectOptJSONObject3.has("bidCreativeQuantity")) {
                if (jSONObject.has("bidCreativeQuantity")) {
                    jSONObject2 = jSONObject;
                } else {
                    iOptInt = _cjVar._h;
                }
                this._n = iOptInt;
                if (jSONObjectOptJSONObject3.has("creativeAliveDuration")) {
                    if (jSONObject.has("creativeAliveDuration")) {
                        jSONObject3 = jSONObject;
                    } else {
                        jOptLong = _cjVar._g;
                    }
                    this._o = jOptLong;
                    this._R = _cjVar._y;
                    jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("whitelist");
                    map = new HashMap(_cjVar._i);
                    if (jSONArrayOptJSONArray != null) {
                        for (i5 = 0; i5 < jSONArrayOptJSONArray.length(); i5++) {
                            jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                            if (jSONObject5 != null) {
                                _awVar_a2 = new _aw()._a(jSONObject5);
                                if (_awVar_a2._a()) {
                                    map.put(_awVar_a2._b, _awVar_a2);
                                }
                            }
                        }
                    }
                    this._K.addAll(map.values());
                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                    map2 = new HashMap(_cjVar._j);
                    if (jSONArrayOptJSONArray2 != null) {
                        for (i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                            jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                            if (jSONObject4 != null) {
                                _awVar_a = new _aw()._a(jSONObject4);
                                if (_awVar_a._a()) {
                                    map2.put(_awVar_a._b, _awVar_a);
                                }
                            }
                        }
                    }
                    this._L.addAll(map2.values());
                    jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                    if (jSONArrayOptJSONArray3 != null) {
                        for (i3 = 0; i3 != jSONArrayOptJSONArray3.length(); i3++) {
                            this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                        }
                    }
                    jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                    if (jSONArrayOptJSONArray4 != null) {
                        for (i2 = 0; i2 != jSONArrayOptJSONArray4.length(); i2++) {
                            this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                        }
                    }
                    jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                    if (jSONArrayOptJSONArray5 != null) {
                        for (i = 0; i != jSONArrayOptJSONArray5.length(); i++) {
                            this._l.add(jSONArrayOptJSONArray5.getString(i));
                        }
                    }
                    jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                    if (jSONObjectOptJSONObject != null) {
                        _cd _cdVar = new _cd();
                        try {
                            jSONObjectOptJSONObject.getInt("freqCount");
                            jSONObjectOptJSONObject.getInt("periodUnit");
                            jSONObjectOptJSONObject.getInt("periodCount");
                            this._m = _cdVar;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            return false;
                        }
                    }
                    jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                    if (jSONObjectOptJSONObject2 != null) {
                        this._q = jSONObjectOptJSONObject2.optString("tracking");
                        this._s = jSONObjectOptJSONObject2.optString("impTracking");
                        this._t = jSONObjectOptJSONObject2.optString("clickTracking");
                        this._r = jSONObjectOptJSONObject2.optString("bidTracking");
                        this._u = jSONObjectOptJSONObject2.optString("errorTracking");
                        this._v = jSONObjectOptJSONObject2.optString("bidSucTracking");
                        this._w = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                        this._x = jSONObjectOptJSONObject2.optString("dpTracking");
                    }
                    hashSet = _ckVar._F;
                    if (hashSet != null) {
                        hashSet = new HashSet<>();
                    }
                    this._D = hashSet;
                    hashSet2 = _ckVar._E;
                    if (hashSet2 != null) {
                        hashSet2 = new HashSet<>();
                    }
                    this._C = hashSet2;
                    hashSet3 = _ckVar._z;
                    if (hashSet3 != null) {
                        hashSet3 = new HashSet<>();
                    }
                    this._y = hashSet3;
                    hashSet4 = _ckVar._B;
                    if (hashSet4 != null) {
                        hashSet4 = new HashSet<>();
                    }
                    this._A = hashSet4;
                    hashSet5 = _ckVar._G;
                    if (hashSet5 != null) {
                        hashSet5 = new HashSet<>();
                    }
                    this._E = hashSet5;
                    hashSet6 = _ckVar._D;
                    if (hashSet6 != null) {
                        hashSet6 = new HashSet<>();
                    }
                    this._B = hashSet6;
                    hashSet7 = _ckVar._A;
                    if (hashSet7 != null) {
                        hashSet7 = new HashSet<>();
                    }
                    this._z = hashSet7;
                    hashSet8 = _ckVar._H;
                    if (hashSet8 != null) {
                        hashSet8 = new HashSet<>();
                    }
                    this._F = hashSet8;
                    hashSet9 = _ckVar._C;
                    if (hashSet9 != null) {
                        hashSet9 = new HashSet<>();
                    }
                    this._H = hashSet9;
                    hashSet10 = _ckVar._I;
                    if (hashSet10 != null) {
                        hashSet10 = new HashSet<>();
                    }
                    this._G = hashSet10;
                    hashSet11 = _ckVar._J;
                    if (hashSet11 != null) {
                        hashSet11 = new HashSet<>();
                    }
                    this._I = hashSet11;
                    hashSet12 = _ckVar._K;
                    if (hashSet12 != null) {
                        hashSet12 = new HashSet<>();
                    }
                    this._J = hashSet12;
                    _a().addAll(_cjVar._p);
                    _b().addAll(_cjVar._o);
                    _c().addAll(_cjVar._k);
                    _d().addAll(_cjVar._m);
                    _f().addAll(_cjVar._q);
                    _g().addAll(_cjVar._n);
                    _h().addAll(_cjVar._l);
                    this._F.addAll(_cjVar._r);
                    this._G.addAll(_cjVar._s);
                    this._I.addAll(_cjVar._t);
                    this._J.addAll(_cjVar._u);
                    this._H.addAll(_cjVar._v);
                    return true;
                }
                jSONObject3 = jSONObjectOptJSONObject3;
                jOptLong = jSONObject3.optLong("creativeAliveDuration");
                this._o = jOptLong;
                this._R = _cjVar._y;
                jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("whitelist");
                map = new HashMap(_cjVar._i);
                if (jSONArrayOptJSONArray != null) {
                    while (i5 < jSONArrayOptJSONArray.length()) {
                        jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                        if (jSONObject5 != null) {
                            _awVar_a2 = new _aw()._a(jSONObject5);
                            if (_awVar_a2._a()) {
                                map.put(_awVar_a2._b, _awVar_a2);
                            }
                        }
                    }
                }
                this._K.addAll(map.values());
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                map2 = new HashMap(_cjVar._j);
                if (jSONArrayOptJSONArray2 != null) {
                    while (i4 < jSONArrayOptJSONArray2.length()) {
                        jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if (jSONObject4 != null) {
                            _awVar_a = new _aw()._a(jSONObject4);
                            if (_awVar_a._a()) {
                                map2.put(_awVar_a._b, _awVar_a);
                            }
                        }
                    }
                }
                this._L.addAll(map2.values());
                jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                if (jSONArrayOptJSONArray3 != null) {
                    while (i3 != jSONArrayOptJSONArray3.length()) {
                        this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                    }
                }
                jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                if (jSONArrayOptJSONArray4 != null) {
                    while (i2 != jSONArrayOptJSONArray4.length()) {
                        this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                    }
                }
                jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                if (jSONArrayOptJSONArray5 != null) {
                    while (i != jSONArrayOptJSONArray5.length()) {
                        this._l.add(jSONArrayOptJSONArray5.getString(i));
                    }
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                if (jSONObjectOptJSONObject != null) {
                    _cd _cdVar2 = new _cd();
                    jSONObjectOptJSONObject.getInt("freqCount");
                    jSONObjectOptJSONObject.getInt("periodUnit");
                    jSONObjectOptJSONObject.getInt("periodCount");
                    this._m = _cdVar2;
                }
                jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                if (jSONObjectOptJSONObject2 != null) {
                    this._q = jSONObjectOptJSONObject2.optString("tracking");
                    this._s = jSONObjectOptJSONObject2.optString("impTracking");
                    this._t = jSONObjectOptJSONObject2.optString("clickTracking");
                    this._r = jSONObjectOptJSONObject2.optString("bidTracking");
                    this._u = jSONObjectOptJSONObject2.optString("errorTracking");
                    this._v = jSONObjectOptJSONObject2.optString("bidSucTracking");
                    this._w = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                    this._x = jSONObjectOptJSONObject2.optString("dpTracking");
                }
                hashSet = _ckVar._F;
                if (hashSet != null) {
                    hashSet = new HashSet<>();
                }
                this._D = hashSet;
                hashSet2 = _ckVar._E;
                if (hashSet2 != null) {
                    hashSet2 = new HashSet<>();
                }
                this._C = hashSet2;
                hashSet3 = _ckVar._z;
                if (hashSet3 != null) {
                    hashSet3 = new HashSet<>();
                }
                this._y = hashSet3;
                hashSet4 = _ckVar._B;
                if (hashSet4 != null) {
                    hashSet4 = new HashSet<>();
                }
                this._A = hashSet4;
                hashSet5 = _ckVar._G;
                if (hashSet5 != null) {
                    hashSet5 = new HashSet<>();
                }
                this._E = hashSet5;
                hashSet6 = _ckVar._D;
                if (hashSet6 != null) {
                    hashSet6 = new HashSet<>();
                }
                this._B = hashSet6;
                hashSet7 = _ckVar._A;
                if (hashSet7 != null) {
                    hashSet7 = new HashSet<>();
                }
                this._z = hashSet7;
                hashSet8 = _ckVar._H;
                if (hashSet8 != null) {
                    hashSet8 = new HashSet<>();
                }
                this._F = hashSet8;
                hashSet9 = _ckVar._C;
                if (hashSet9 != null) {
                    hashSet9 = new HashSet<>();
                }
                this._H = hashSet9;
                hashSet10 = _ckVar._I;
                if (hashSet10 != null) {
                    hashSet10 = new HashSet<>();
                }
                this._G = hashSet10;
                hashSet11 = _ckVar._J;
                if (hashSet11 != null) {
                    hashSet11 = new HashSet<>();
                }
                this._I = hashSet11;
                hashSet12 = _ckVar._K;
                if (hashSet12 != null) {
                    hashSet12 = new HashSet<>();
                }
                this._J = hashSet12;
                _a().addAll(_cjVar._p);
                _b().addAll(_cjVar._o);
                _c().addAll(_cjVar._k);
                _d().addAll(_cjVar._m);
                _f().addAll(_cjVar._q);
                _g().addAll(_cjVar._n);
                _h().addAll(_cjVar._l);
                this._F.addAll(_cjVar._r);
                this._G.addAll(_cjVar._s);
                this._I.addAll(_cjVar._t);
                this._J.addAll(_cjVar._u);
                this._H.addAll(_cjVar._v);
                return true;
            }
            jSONObject2 = jSONObjectOptJSONObject3;
            iOptInt = jSONObject2.optInt("bidCreativeQuantity");
            this._n = iOptInt;
            if (jSONObjectOptJSONObject3.has("creativeAliveDuration")) {
                if (jSONObject.has("creativeAliveDuration")) {
                    jSONObject3 = jSONObject;
                } else {
                    jOptLong = _cjVar._g;
                }
                this._o = jOptLong;
                this._R = _cjVar._y;
                jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("whitelist");
                map = new HashMap(_cjVar._i);
                if (jSONArrayOptJSONArray != null) {
                    while (i5 < jSONArrayOptJSONArray.length()) {
                        jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                        if (jSONObject5 != null) {
                            _awVar_a2 = new _aw()._a(jSONObject5);
                            if (_awVar_a2._a()) {
                                map.put(_awVar_a2._b, _awVar_a2);
                            }
                        }
                    }
                }
                this._K.addAll(map.values());
                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
                map2 = new HashMap(_cjVar._j);
                if (jSONArrayOptJSONArray2 != null) {
                    while (i4 < jSONArrayOptJSONArray2.length()) {
                        jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                        if (jSONObject4 != null) {
                            _awVar_a = new _aw()._a(jSONObject4);
                            if (_awVar_a._a()) {
                                map2.put(_awVar_a._b, _awVar_a);
                            }
                        }
                    }
                }
                this._L.addAll(map2.values());
                jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
                if (jSONArrayOptJSONArray3 != null) {
                    while (i3 != jSONArrayOptJSONArray3.length()) {
                        this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                    }
                }
                jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
                if (jSONArrayOptJSONArray4 != null) {
                    while (i2 != jSONArrayOptJSONArray4.length()) {
                        this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                    }
                }
                jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
                if (jSONArrayOptJSONArray5 != null) {
                    while (i != jSONArrayOptJSONArray5.length()) {
                        this._l.add(jSONArrayOptJSONArray5.getString(i));
                    }
                }
                jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
                if (jSONObjectOptJSONObject != null) {
                    _cd _cdVar3 = new _cd();
                    jSONObjectOptJSONObject.getInt("freqCount");
                    jSONObjectOptJSONObject.getInt("periodUnit");
                    jSONObjectOptJSONObject.getInt("periodCount");
                    this._m = _cdVar3;
                }
                jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
                if (jSONObjectOptJSONObject2 != null) {
                    this._q = jSONObjectOptJSONObject2.optString("tracking");
                    this._s = jSONObjectOptJSONObject2.optString("impTracking");
                    this._t = jSONObjectOptJSONObject2.optString("clickTracking");
                    this._r = jSONObjectOptJSONObject2.optString("bidTracking");
                    this._u = jSONObjectOptJSONObject2.optString("errorTracking");
                    this._v = jSONObjectOptJSONObject2.optString("bidSucTracking");
                    this._w = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                    this._x = jSONObjectOptJSONObject2.optString("dpTracking");
                }
                hashSet = _ckVar._F;
                if (hashSet != null) {
                    hashSet = new HashSet<>();
                }
                this._D = hashSet;
                hashSet2 = _ckVar._E;
                if (hashSet2 != null) {
                    hashSet2 = new HashSet<>();
                }
                this._C = hashSet2;
                hashSet3 = _ckVar._z;
                if (hashSet3 != null) {
                    hashSet3 = new HashSet<>();
                }
                this._y = hashSet3;
                hashSet4 = _ckVar._B;
                if (hashSet4 != null) {
                    hashSet4 = new HashSet<>();
                }
                this._A = hashSet4;
                hashSet5 = _ckVar._G;
                if (hashSet5 != null) {
                    hashSet5 = new HashSet<>();
                }
                this._E = hashSet5;
                hashSet6 = _ckVar._D;
                if (hashSet6 != null) {
                    hashSet6 = new HashSet<>();
                }
                this._B = hashSet6;
                hashSet7 = _ckVar._A;
                if (hashSet7 != null) {
                    hashSet7 = new HashSet<>();
                }
                this._z = hashSet7;
                hashSet8 = _ckVar._H;
                if (hashSet8 != null) {
                    hashSet8 = new HashSet<>();
                }
                this._F = hashSet8;
                hashSet9 = _ckVar._C;
                if (hashSet9 != null) {
                    hashSet9 = new HashSet<>();
                }
                this._H = hashSet9;
                hashSet10 = _ckVar._I;
                if (hashSet10 != null) {
                    hashSet10 = new HashSet<>();
                }
                this._G = hashSet10;
                hashSet11 = _ckVar._J;
                if (hashSet11 != null) {
                    hashSet11 = new HashSet<>();
                }
                this._I = hashSet11;
                hashSet12 = _ckVar._K;
                if (hashSet12 != null) {
                    hashSet12 = new HashSet<>();
                }
                this._J = hashSet12;
                _a().addAll(_cjVar._p);
                _b().addAll(_cjVar._o);
                _c().addAll(_cjVar._k);
                _d().addAll(_cjVar._m);
                _f().addAll(_cjVar._q);
                _g().addAll(_cjVar._n);
                _h().addAll(_cjVar._l);
                this._F.addAll(_cjVar._r);
                this._G.addAll(_cjVar._s);
                this._I.addAll(_cjVar._t);
                this._J.addAll(_cjVar._u);
                this._H.addAll(_cjVar._v);
                return true;
            }
            jSONObject3 = jSONObjectOptJSONObject3;
            jOptLong = jSONObject3.optLong("creativeAliveDuration");
            this._o = jOptLong;
            this._R = _cjVar._y;
            jSONArrayOptJSONArray = jSONObjectOptJSONObject3.optJSONArray("whitelist");
            map = new HashMap(_cjVar._i);
            if (jSONArrayOptJSONArray != null) {
                while (i5 < jSONArrayOptJSONArray.length()) {
                    jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i5);
                    if (jSONObject5 != null) {
                        _awVar_a2 = new _aw()._a(jSONObject5);
                        if (_awVar_a2._a()) {
                            map.put(_awVar_a2._b, _awVar_a2);
                        }
                    }
                }
            }
            this._K.addAll(map.values());
            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject3.optJSONArray("blockPacket");
            map2 = new HashMap(_cjVar._j);
            if (jSONArrayOptJSONArray2 != null) {
                while (i4 < jSONArrayOptJSONArray2.length()) {
                    jSONObject4 = jSONArrayOptJSONArray2.getJSONObject(i4);
                    if (jSONObject4 != null) {
                        _awVar_a = new _aw()._a(jSONObject4);
                        if (_awVar_a._a()) {
                            map2.put(_awVar_a._b, _awVar_a);
                        }
                    }
                }
            }
            this._L.addAll(map2.values());
            jSONArrayOptJSONArray3 = jSONObject.optJSONArray("geoCode");
            if (jSONArrayOptJSONArray3 != null) {
                while (i3 != jSONArrayOptJSONArray3.length()) {
                    this._j.add(Long.valueOf(jSONArrayOptJSONArray3.getLong(i3)));
                }
            }
            jSONArrayOptJSONArray4 = jSONObject.optJSONArray("hour");
            if (jSONArrayOptJSONArray4 != null) {
                while (i2 != jSONArrayOptJSONArray4.length()) {
                    this._k.add(Long.valueOf(jSONArrayOptJSONArray4.getLong(i2)));
                }
            }
            jSONArrayOptJSONArray5 = jSONObject.optJSONArray("osVersion");
            if (jSONArrayOptJSONArray5 != null) {
                while (i != jSONArrayOptJSONArray5.length()) {
                    this._l.add(jSONArrayOptJSONArray5.getString(i));
                }
            }
            jSONObjectOptJSONObject = jSONObject.optJSONObject("freqControl");
            if (jSONObjectOptJSONObject != null) {
                _cd _cdVar4 = new _cd();
                jSONObjectOptJSONObject.getInt("freqCount");
                jSONObjectOptJSONObject.getInt("periodUnit");
                jSONObjectOptJSONObject.getInt("periodCount");
                this._m = _cdVar4;
            }
            jSONObjectOptJSONObject2 = jSONObject.optJSONObject("trackingData");
            if (jSONObjectOptJSONObject2 != null) {
                this._q = jSONObjectOptJSONObject2.optString("tracking");
                this._s = jSONObjectOptJSONObject2.optString("impTracking");
                this._t = jSONObjectOptJSONObject2.optString("clickTracking");
                this._r = jSONObjectOptJSONObject2.optString("bidTracking");
                this._u = jSONObjectOptJSONObject2.optString("errorTracking");
                this._v = jSONObjectOptJSONObject2.optString("bidSucTracking");
                this._w = jSONObjectOptJSONObject2.optString("bidSelectedTracking");
                this._x = jSONObjectOptJSONObject2.optString("dpTracking");
            }
            hashSet = _ckVar._F;
            if (hashSet != null) {
                hashSet = new HashSet<>();
            }
            this._D = hashSet;
            hashSet2 = _ckVar._E;
            if (hashSet2 != null) {
                hashSet2 = new HashSet<>();
            }
            this._C = hashSet2;
            hashSet3 = _ckVar._z;
            if (hashSet3 != null) {
                hashSet3 = new HashSet<>();
            }
            this._y = hashSet3;
            hashSet4 = _ckVar._B;
            if (hashSet4 != null) {
                hashSet4 = new HashSet<>();
            }
            this._A = hashSet4;
            hashSet5 = _ckVar._G;
            if (hashSet5 != null) {
                hashSet5 = new HashSet<>();
            }
            this._E = hashSet5;
            hashSet6 = _ckVar._D;
            if (hashSet6 != null) {
                hashSet6 = new HashSet<>();
            }
            this._B = hashSet6;
            hashSet7 = _ckVar._A;
            if (hashSet7 != null) {
                hashSet7 = new HashSet<>();
            }
            this._z = hashSet7;
            hashSet8 = _ckVar._H;
            if (hashSet8 != null) {
                hashSet8 = new HashSet<>();
            }
            this._F = hashSet8;
            hashSet9 = _ckVar._C;
            if (hashSet9 != null) {
                hashSet9 = new HashSet<>();
            }
            this._H = hashSet9;
            hashSet10 = _ckVar._I;
            if (hashSet10 != null) {
                hashSet10 = new HashSet<>();
            }
            this._G = hashSet10;
            hashSet11 = _ckVar._J;
            if (hashSet11 != null) {
                hashSet11 = new HashSet<>();
            }
            this._I = hashSet11;
            hashSet12 = _ckVar._K;
            if (hashSet12 != null) {
                hashSet12 = new HashSet<>();
            }
            this._J = hashSet12;
            _a().addAll(_cjVar._p);
            _b().addAll(_cjVar._o);
            _c().addAll(_cjVar._k);
            _d().addAll(_cjVar._m);
            _f().addAll(_cjVar._q);
            _g().addAll(_cjVar._n);
            _h().addAll(_cjVar._l);
            this._F.addAll(_cjVar._r);
            this._G.addAll(_cjVar._s);
            this._I.addAll(_cjVar._t);
            this._J.addAll(_cjVar._u);
            this._H.addAll(_cjVar._v);
            return true;
        } catch (JSONException e2) {
            Logger.d(e2.getMessage());
            return false;
        }
    }
}
