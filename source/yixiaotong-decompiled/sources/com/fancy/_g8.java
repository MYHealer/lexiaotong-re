package com.fancy;

import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.model.PtgImageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g8 implements NativeAdvertData {
    public final String _a;
    public final String _b;
    public final String _c;
    public final String _d;
    public final ArrayList _e;
    public final String _f;
    public final String _g;
    public final String _h;
    public final int _i;
    public final int _j;
    public final int _k;
    public final AppInfo _l;
    public final int _m;
    public final long _n;
    public final String _o;
    public final String _p;
    public final boolean _q;
    public final int _r;
    public final String _s;
    public final String _t;

    public _g8(String str, String str2, String str3, List list, String str4, int i, int i2, int i3, AppInfo appInfo, boolean z, String str5, String str6, long j, String str7, String str8, boolean z2, int i4, String str9, String str10, String str11) {
        this._b = str;
        this._c = str2;
        this._d = str3;
        this._h = str4;
        this._i = i;
        this._j = i2;
        this._k = i3;
        this._l = appInfo;
        this._m = z ? 2 : 1;
        this._n = j;
        this._o = str7;
        this._p = str8;
        this._q = z2;
        this._r = i4;
        this._s = str9;
        this._f = str5;
        this._g = str6;
        this._a = str10;
        this._t = str11;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                _jz _jzVar = (_jz) it.next();
                PtgImageInfo ptgImageInfo = new PtgImageInfo();
                ptgImageInfo.setImageUrl(_jzVar._b());
                ptgImageInfo.setWidth(_jzVar._c());
                ptgImageInfo.setHeight(_jzVar._a());
                ptgImageInfo.setMimeType(str4);
                arrayList.add(ptgImageInfo);
            }
        }
        this._e = arrayList;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final void destroy() {
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final int getAction() {
        return this._k;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final int getAid() {
        return this._r;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final AppInfo getApp() {
        return this._l;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getBrand() {
        return this._o;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getButtonText() {
        return this._s;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getDesc() {
        return this._c;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final long getDuration() {
        return this._n;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final int getHeight() {
        return this._j;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final List<PtgImageInfo> getImageList() {
        return this._e;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getLandUrl() {
        return this._t;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getLogo() {
        return this._p;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getMaterialId() {
        return this._a;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getMime() {
        return this._h;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getStyle() {
        return this._d;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getTitle() {
        return this._b;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final int getType() {
        return this._m;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getVideoCover() {
        return this._f;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final String getVideoUrl() {
        return this._g;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final int getWidth() {
        return this._i;
    }

    @Override // com.fancy.adsdk.lib.interf.NativeAdvertData
    public final boolean isSupportShake() {
        return this._q;
    }
}
