package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.utils.Logger;
import com.huawei.openalliance.ad.constant.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n {
    /* JADX WARN: Code duplicated, block: B:148:0x01b7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x0103 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:91:0x0197  */
    /* JADX WARN: Code duplicated, block: B:93:0x019f  */
    /* JADX WARN: Code duplicated, block: B:96:0x01af  */
    public static boolean _a(_m _mVar, _os _osVar) {
        _nj _njVar;
        _p _pVar_a;
        _cf _cfVar;
        boolean z;
        HashSet hashSet;
        HashSet hashSet2;
        StringBuilder sb;
        String str;
        if (_mVar == null || (_pVar_a = (_njVar = (_nj) _mVar)._a()) == null) {
            return true;
        }
        String str2 = _pVar_a._a;
        String str3 = _pVar_a._c;
        String str4 = _pVar_a._d;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || (_cfVar = _if._f._b) == null) {
            return true;
        }
        _cg _cgVar = _cfVar._c;
        List<_ci> listEmptyList = _cgVar == null ? null : (List) _cgVar._a.get(str2);
        if (listEmptyList == null) {
            listEmptyList = Collections.emptyList();
        }
        for (_ci _ciVar : listEmptyList) {
            if (_ciVar != null && str4.equals(_ciVar._c) && str3.equals(_ciVar._e())) {
                HashSet hashSet3 = _ciVar._M;
                HashSet<String> hashSet4 = _ciVar._N;
                if (hashSet3 != null && !hashSet3.isEmpty()) {
                    _p _pVar_a2 = _njVar._a();
                    if (hashSet3.size() <= 0 || _pVar_a2 == null) {
                        z = true;
                        break;
                    }
                    Iterator it = hashSet3.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z = true;
                            break;
                        }
                        String str5 = (String) it.next();
                        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(_pVar_a2._m) && str5.equalsIgnoreCase(_pVar_a2._m)) {
                            Logger.e(_ie._a(" [Filter] Be intercepted ，because the packageName is ").append(_pVar_a2._m).toString());
                            Logger.e("ad（" + str4 + x.bQ + str3 + ") is intercepted [app black list]");
                            _osVar._t._g(2);
                            _osVar._t._h("blackAppList");
                            z = false;
                            break;
                        }
                    }
                } else {
                    z = true;
                    break;
                }
                if (z && hashSet4 != null && !hashSet4.isEmpty()) {
                    _p _pVar_a3 = _njVar._a();
                    if (hashSet4.size() > 0 && _pVar_a3 != null) {
                        loop2: for (String str6 : hashSet4) {
                            if (!TextUtils.isEmpty(str6)) {
                                if (!TextUtils.isEmpty(_pVar_a3._f) && _pVar_a3._f.contains(str6)) {
                                    sb = new StringBuilder();
                                    str = " [Filter] Be intercepted ，because the title contains keywords ";
                                } else if (TextUtils.isEmpty(_pVar_a3._g) || !_pVar_a3._g.contains(str6)) {
                                    try {
                                        if (_nj._c.matcher(str6).find()) {
                                            List<String> list = _pVar_a3._e;
                                            if (list != null && !list.isEmpty()) {
                                                Iterator<String> it2 = _pVar_a3._e.iterator();
                                                while (true) {
                                                    if (it2.hasNext()) {
                                                        String next = it2.next();
                                                        if (next != null && TextUtils.equals(next, str6)) {
                                                            sb = new StringBuilder();
                                                            str = " [Filter] Be intercepted ，because the image url contains keywords ";
                                                        }
                                                    } else if (!TextUtils.isEmpty(_pVar_a3._j)) {
                                                        if (!TextUtils.isEmpty(_pVar_a3._i)) {
                                                            if (TextUtils.isEmpty(_pVar_a3._l)) {
                                                                continue;
                                                            }
                                                        } else if (TextUtils.isEmpty(_pVar_a3._l)) {
                                                            continue;
                                                        }
                                                    } else if (!TextUtils.isEmpty(_pVar_a3._i)) {
                                                        if (TextUtils.isEmpty(_pVar_a3._l)) {
                                                            continue;
                                                        }
                                                    } else if (TextUtils.isEmpty(_pVar_a3._l)) {
                                                        continue;
                                                    }
                                                }
                                            } else if (!TextUtils.isEmpty(_pVar_a3._j) && _pVar_a3._j.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the deep link contains keywords ";
                                            } else if (!TextUtils.isEmpty(_pVar_a3._i) && _pVar_a3._i.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the page url contains keywords ";
                                            } else if (TextUtils.isEmpty(_pVar_a3._l) && _pVar_a3._l.contains(str6)) {
                                                sb = new StringBuilder();
                                                str = " [Filter] Be intercepted ，because the download url contains keywords ";
                                            }
                                        } else {
                                            continue;
                                        }
                                    } catch (Exception unused) {
                                        continue;
                                    }
                                } else {
                                    sb = new StringBuilder();
                                    str = " [Filter] Be intercepted ，because the description contains keywords ";
                                }
                                Logger.e(sb.append(str).append(str6).toString());
                                Logger.e("ad（" + str4 + x.bQ + str3 + ") is intercepted [keyword black list]");
                                _osVar._t._g(2);
                                _osVar._t._h("blackKeywordList");
                                z = false;
                                break;
                            }
                        }
                    }
                }
                if (z && (hashSet2 = _ciVar._K) != null && !hashSet2.isEmpty()) {
                    _o _oVar_a = _njVar._a(hashSet2, 1);
                    if (_oVar_a._a) {
                        Logger.e("ad（" + str4 + x.bQ + str3 + ") is intercepted [app white list]");
                        _osVar._t._g(1);
                        _osVar._t._h(_oVar_a._b);
                        return true;
                    }
                }
                if (z && (hashSet = _ciVar._L) != null && !hashSet.isEmpty()) {
                    _o _oVar_a2 = _njVar._a(hashSet, 2);
                    if (_oVar_a2._a) {
                        Logger.e("ad（" + str4 + x.bQ + str3 + ") is intercepted [app block packet list]");
                        _osVar._t._g(2);
                        _osVar._t._h(_oVar_a2._b);
                        return false;
                    }
                }
                return z;
            }
        }
        return true;
    }
}
