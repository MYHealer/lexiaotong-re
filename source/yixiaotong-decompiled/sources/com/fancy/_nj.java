package com.fancy;

import android.text.TextUtils;
import android.util.Pair;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.utils.Logger;
import com.huawei.openalliance.ad.constant.ba;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _nj<T> implements _m {
    public static final WeakHashMap<Object, _p> _b = new WeakHashMap<>();
    public static final Pattern _c = Pattern.compile("^[a-zA-Z][0-9a-zA-Z+_\\\\-\\\\.]*:((//[#0-9a-zA-Z;/?:@&=+$\\\\.\\\\-_!~*'()%]+)|([#0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%]+[#0-9a-zA-Z/;?:@&=+$\\\\.\\\\-_!~*'()%]*)|(/[#0-9a-zA-Z;?:@&=+$\\\\.\\\\-_!~*'()%]+[#0-9a-zA-Z/;?:@&=+$\\\\.\\\\-_!~*'()%]*))");
    public T _a;

    public _nj(T t) {
        this._a = t;
    }

    public final _p _a() {
        _p _pVar;
        String str;
        String str2;
        _p _pVar2 = null;
        if (this._a == null) {
            return null;
        }
        WeakHashMap<Object, _p> weakHashMap = _b;
        synchronized (weakHashMap) {
            _pVar = weakHashMap.get(this._a);
        }
        if (_pVar != null) {
            return _pVar;
        }
        _ip _ipVar = (_ip) this;
        _f _fVar = (_f) this._a;
        try {
            ArrayList arrayList = new ArrayList();
            String name = "";
            String package_name = "";
            AppInfo appInfo = _fVar._c;
            if (appInfo != null) {
                name = appInfo.getName() == null ? "" : _fVar._c.getName();
                package_name = _fVar._c.getPackage_name() == null ? "" : _fVar._c.getPackage_name();
                if (_fVar._c.getIcon_url() != null) {
                    _fVar._c.getIcon_url();
                }
            }
            String str3 = name;
            String str4 = package_name;
            if (_fVar._a == 0) {
                str2 = _fVar._i;
                str = "";
            } else {
                str = _fVar._i;
                str2 = "";
            }
            String str5 = _fVar._d;
            if (str5 == null) {
                str5 = "";
            }
            String str6 = str5;
            _l3 _l3Var_m = _fVar._m();
            if (_l3Var_m != null) {
                arrayList.add(_l3Var_m._a);
            }
            List<_jz> list_h = _fVar._h();
            if (list_h != null) {
                Iterator<_jz> it = list_h.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next()._a);
                }
            }
            String str_d = _fVar._d() == null ? "" : _fVar._d();
            _pVar2 = new _p(_ipVar._d._t()._h, _fVar._b, _ipVar._d.getPtgSlotID(), _ipVar._d._w(), _ipVar._d.getCodeId(), arrayList, _fVar._l() == null ? "" : _fVar._l(), str_d, str, str6, str3, str2, str4);
        } catch (Exception unused) {
        }
        if (_pVar2 != null) {
            WeakHashMap<Object, _p> weakHashMap2 = _b;
            synchronized (weakHashMap2) {
                weakHashMap2.put(this._a, _pVar2);
            }
        }
        return _pVar2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:169:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:188:0x02dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x013f A[PHI: r0 r8 r21 r22
  0x013f: PHI (r0v49 java.lang.String) = (r0v16 java.lang.String), (r0v17 java.lang.String), (r0v19 java.lang.String), (r0v50 java.lang.String) binds: [B:73:0x0134, B:70:0x0126, B:62:0x0101, B:19:0x007b] A[DONT_GENERATE, DONT_INLINE]
  0x013f: PHI (r8v10 java.lang.String) = (r8v1 java.lang.String), (r8v2 java.lang.String), (r8v4 java.lang.String), (r8v11 java.lang.String) binds: [B:73:0x0134, B:70:0x0126, B:62:0x0101, B:19:0x007b] A[DONT_GENERATE, DONT_INLINE]
  0x013f: PHI (r21v8 java.lang.String) = (r21v1 java.lang.String), (r21v2 java.lang.String), (r21v4 java.lang.String), (r21v9 java.lang.String) binds: [B:73:0x0134, B:70:0x0126, B:62:0x0101, B:19:0x007b] A[DONT_GENERATE, DONT_INLINE]
  0x013f: PHI (r22v5 java.lang.String) = (r22v0 java.lang.String), (r22v0 java.lang.String), (r22v0 java.lang.String), (r22v6 java.lang.String) binds: [B:73:0x0134, B:70:0x0126, B:62:0x0101, B:19:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Failed to find 'out' block for switch in B:78:0x0140. Please report as an issue. */
    public final _o _a(HashSet hashSet, int i) {
        _p _pVar;
        _aw _awVar;
        Pair pair_a;
        String str;
        String str2;
        byte b;
        ArrayList arrayList;
        _p _pVar_a = _a();
        if (hashSet.size() > 0 && _pVar_a != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                _aw _awVar2 = (_aw) it.next();
                if (_awVar2._a()) {
                    ArrayList arrayList2 = _awVar2._a;
                    HashMap map = new HashMap();
                    try {
                        Collections.emptyList();
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            String str3 = (String) it2.next();
                            int iHashCode = str3.hashCode();
                            String str4 = "industryId";
                            it2 = it2;
                            it = it;
                            _awVar2 = _awVar2;
                            map = map;
                            _p _pVar2 = _pVar_a;
                            String str5 = "consumerAdId";
                            String str6 = ba.at;
                            switch (iHashCode) {
                                case -1086538152:
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    if (str3.equals("slotType")) {
                                        b = 3;
                                    } else {
                                        b = -1;
                                    }
                                    break;
                                case -899454023:
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    if (str3.equals(str2)) {
                                        b = 2;
                                    } else {
                                        b = -1;
                                    }
                                    break;
                                case -896505829:
                                    str5 = str5;
                                    str = "appPackageName";
                                    if (str3.equals(str6)) {
                                        b = 12;
                                        str6 = str6;
                                        str2 = "slotId";
                                    } else {
                                        str6 = str6;
                                        str2 = "slotId";
                                        b = -1;
                                    }
                                    break;
                                case -841439820:
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    if (str3.equals(str5)) {
                                        b = 1;
                                    } else {
                                        b = -1;
                                    }
                                    break;
                                case -840852400:
                                    if (str3.equals("consumerType")) {
                                        b = 5;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case -794136500:
                                    if (str3.equals("appName")) {
                                        b = 13;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case -645952689:
                                    if (str3.equals("consumerSlotId")) {
                                        b = 4;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case -441921776:
                                    if (str3.equals("appPackageName")) {
                                        b = 14;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 2988190:
                                    if (str3.equals("adId")) {
                                        b = 0;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 3079825:
                                    if (str3.equals("desc")) {
                                        b = 7;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 110371416:
                                    if (str3.equals("title")) {
                                        b = 6;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 122999369:
                                    if (str3.equals("landingPageUrl")) {
                                        b = 10;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 629233382:
                                    if (str3.equals("deeplink")) {
                                        b = 11;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 940773407:
                                    if (str3.equals("mediaId")) {
                                        b = 16;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 1733138150:
                                    if (str3.equals("appDownloadUrl")) {
                                        b = 15;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 1916674817:
                                    if (str3.equals("imgList")) {
                                        b = 8;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                case 1938508697:
                                    if (str3.equals("industryId")) {
                                        b = 9;
                                        str = "appPackageName";
                                        str2 = "slotId";
                                    }
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                                default:
                                    str5 = str5;
                                    str = "appPackageName";
                                    str2 = "slotId";
                                    b = -1;
                                    break;
                            }
                            try {
                                switch (b) {
                                    case 0:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        str4 = "adId";
                                        try {
                                            map.put(str4, arrayList);
                                            _pVar_a = _pVar;
                                        } catch (Exception e) {
                                            e = e;
                                            e.printStackTrace();
                                            if (!map.isEmpty()) {
                                                _awVar = _awVar2;
                                                pair_a = _ly._a(map, _awVar._c, _pVar, i);
                                                if (pair_a != null) {
                                                    Logger.e(_ie._a(" [Filter] Be intercepted ，because the key contains rule ").append(_awVar._c).toString());
                                                    return new _o(true, (String) pair_a.first);
                                                }
                                            }
                                            _pVar_a = _pVar;
                                            it = it;
                                        }
                                        break;
                                    case 1:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str7 = _pVar._o;
                                        if (str7 != null) {
                                            arrayList.add(str7);
                                        }
                                        str4 = str5;
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 2:
                                        _pVar = _pVar2;
                                        ArrayList arrayList3 = new ArrayList();
                                        String str8 = _pVar._a;
                                        if (str8 != null) {
                                            arrayList3.add(str8);
                                        }
                                        str4 = str2;
                                        arrayList = arrayList3;
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 3:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        arrayList.add(String.valueOf(_pVar._b));
                                        str4 = "slotType";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 4:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str9 = _pVar._c;
                                        if (str9 != null) {
                                            arrayList.add(str9);
                                        }
                                        str4 = "consumerSlotId";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 5:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str10 = _pVar._d;
                                        if (str10 != null) {
                                            arrayList.add(str10);
                                        }
                                        str4 = "consumerType";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 6:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str11 = _pVar._f;
                                        if (str11 != null) {
                                            arrayList.add(str11);
                                        }
                                        str4 = "title";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 7:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str12 = _pVar._g;
                                        if (str12 != null) {
                                            arrayList.add(str12);
                                        }
                                        str4 = "desc";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 8:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        List<String> list = _pVar._e;
                                        if (list != null && !list.isEmpty()) {
                                            for (String str13 : _pVar._e) {
                                                if (!TextUtils.isEmpty(str13)) {
                                                    arrayList.add(str13);
                                                }
                                            }
                                        }
                                        str4 = "imgList";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 9:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str14 = _pVar._n;
                                        if (str14 != null) {
                                            arrayList.add(str14);
                                        }
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 10:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str15 = _pVar._i;
                                        if (str15 != null) {
                                            arrayList.add(str15);
                                        }
                                        str4 = "landingPageUrl";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 11:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str16 = _pVar._j;
                                        if (str16 != null) {
                                            arrayList.add(str16);
                                        }
                                        str4 = "deeplink";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 12:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str17 = _pVar._h;
                                        if (str17 != null) {
                                            arrayList.add(str17);
                                        }
                                        str4 = str6;
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 13:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str18 = _pVar._k;
                                        if (str18 != null) {
                                            arrayList.add(str18);
                                        }
                                        str4 = "appName";
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 14:
                                        _pVar = _pVar2;
                                        arrayList = new ArrayList();
                                        String str19 = _pVar._m;
                                        if (str19 != null) {
                                            arrayList.add(str19);
                                        }
                                        str4 = str;
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    case 15:
                                        try {
                                            arrayList = new ArrayList();
                                            _pVar = _pVar2;
                                            try {
                                                String str20 = _pVar._l;
                                                if (str20 != null) {
                                                    arrayList.add(str20);
                                                }
                                                str4 = "appDownloadUrl";
                                                map.put(str4, arrayList);
                                                _pVar_a = _pVar;
                                            } catch (Exception e2) {
                                                e = e2;
                                                map = map;
                                                e.printStackTrace();
                                                if (!map.isEmpty()) {
                                                    _awVar = _awVar2;
                                                    pair_a = _ly._a(map, _awVar._c, _pVar, i);
                                                    if (pair_a != null) {
                                                        Logger.e(_ie._a(" [Filter] Be intercepted ，because the key contains rule ").append(_awVar._c).toString());
                                                        return new _o(true, (String) pair_a.first);
                                                    }
                                                }
                                                _pVar_a = _pVar;
                                                it = it;
                                            }
                                        } catch (Exception e3) {
                                            e = e3;
                                            _pVar = _pVar2;
                                        }
                                        break;
                                    case 16:
                                        arrayList = new ArrayList();
                                        if (PtgAdSdk.getConfig() != null && PtgAdSdk.getConfig().getMediaId() != null) {
                                            arrayList.add(PtgAdSdk.getConfig().getMediaId());
                                        }
                                        str4 = "mediaId";
                                        _pVar = _pVar2;
                                        map.put(str4, arrayList);
                                        _pVar_a = _pVar;
                                        break;
                                    default:
                                        _pVar_a = _pVar2;
                                        break;
                                }
                            } catch (Exception e4) {
                                e = e4;
                                map = map;
                                _pVar = _pVar2;
                            }
                            if (!map.isEmpty()) {
                                _awVar = _awVar2;
                                pair_a = _ly._a(map, _awVar._c, _pVar, i);
                                if (pair_a != null) {
                                    Logger.e(_ie._a(" [Filter] Be intercepted ，because the key contains rule ").append(_awVar._c).toString());
                                    return new _o(true, (String) pair_a.first);
                                }
                            }
                            _pVar_a = _pVar;
                            it = it;
                        }
                        _pVar = _pVar_a;
                        it = it;
                        _awVar2 = _awVar2;
                        map = map;
                    } catch (Exception e5) {
                        e = e5;
                        _pVar = _pVar_a;
                        it = it;
                        _awVar2 = _awVar2;
                        map = map;
                    }
                    if (!map.isEmpty()) {
                        _awVar = _awVar2;
                        pair_a = _ly._a(map, _awVar._c, _pVar, i);
                        if (pair_a != null) {
                            Logger.e(_ie._a(" [Filter] Be intercepted ，because the key contains rule ").append(_awVar._c).toString());
                            return new _o(true, (String) pair_a.first);
                        }
                    }
                    _pVar_a = _pVar;
                    it = it;
                }
            }
        }
        return new _o(false, null);
    }
}
