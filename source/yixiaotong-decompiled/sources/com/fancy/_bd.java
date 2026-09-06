package com.fancy;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Base64;
import com.byazt.tk.AdBaseConstants;
import com.cdo.oaps.ad.OapsKey;
import com.facebook.common.util.UriUtil;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.hihonor.adsdk.base.g.j.e.a;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bd implements InvocationHandler {
    public final Context _a;
    public final Object _b;
    public final AtomicLong _c = new AtomicLong(0);

    public _bd(Context context, Object obj) {
        this._a = context;
        this._b = obj;
    }

    public static _m6 _a(Context context, Uri uri) throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ParcelFileDescriptor parcelFileDescriptor = null;
        try {
            parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, t.k);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Exception unused) {
                    }
                }
                return null;
            }
            try {
                try {
                    String str = com.fancy.adsdk.lib.utils._a._a(_oi._a(), Base64.decode("+CkjPCHq8VuHjQKfnZ8ZvA==".getBytes("UTF-8"), 2)) + parcelFileDescriptorOpenFileDescriptor.getFd();
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
                    if (packageArchiveInfo == null) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Exception unused2) {
                        }
                        return null;
                    }
                    _m6 _m6Var = new _m6();
                    String str2 = packageArchiveInfo.packageName;
                    _m6Var._a = str2;
                    _m6Var._b = packageArchiveInfo.versionName;
                    try {
                        packageManager.getPackageInfo(str2, 0);
                        _m6Var._c = 2;
                    } catch (Exception unused3) {
                        _m6Var._c = 1;
                    }
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Exception unused4) {
                    }
                    return _m6Var;
                } catch (Throwable th) {
                    th = th;
                    parcelFileDescriptor = parcelFileDescriptorOpenFileDescriptor;
                    if (parcelFileDescriptor != null) {
                        try {
                            parcelFileDescriptor.close();
                        } catch (Exception unused5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused6) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Exception unused7) {
                    }
                }
                return null;
            }
        } catch (Exception unused8) {
            parcelFileDescriptorOpenFileDescriptor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:110:0x01d8 A[Catch: Exception -> 0x01db, TRY_LEAVE, TryCatch #2 {Exception -> 0x01db, blocks: (B:99:0x019f, B:108:0x01bd, B:110:0x01d8), top: B:120:0x019f }] */
    /* JADX WARN: Code duplicated, block: B:118:0x0199 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:0x01db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:130:0x017f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:133:0x0171 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:81:0x015e  */
    /* JADX WARN: Code duplicated, block: B:84:0x016d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0177  */
    /* JADX WARN: Code duplicated, block: B:91:0x0185  */
    /* JADX WARN: Code duplicated, block: B:93:0x018d  */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Intent intent;
        Uri data;
        Uri data2;
        _or _orVar_b;
        String str_a;
        List<String> dpWhiteList;
        Iterator<String> it;
        String next;
        ComponentName component;
        ResolveInfo resolveInfoResolveActivity;
        ActivityInfo activityInfo;
        boolean z;
        ComponentName component2;
        String shortClassName;
        if ("startActivity".equals(method.getName())) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String string = null;
            if (objArr == null) {
                intent = null;
                break;
            }
            int length = objArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    intent = null;
                    break;
                }
                Object obj2 = objArr[i];
                if (obj2 instanceof Intent) {
                    intent = (Intent) obj2;
                    break;
                }
                i++;
            }
            if (intent != null && (component2 = intent.getComponent()) != null && (shortClassName = component2.getShortClassName()) != null && shortClassName.endsWith("PtgLaunchActivity")) {
                this._c.set(jCurrentTimeMillis);
            } else if (jCurrentTimeMillis - this._c.get() >= 500 && intent != null) {
                if (PtgAdSdk.getConfig().getLinc() == 1) {
                    boolean zEquals = "android.intent.action.VIEW".equals(intent.getAction());
                    boolean zEquals2 = "android.intent.action.INSTALL_PACKAGE".equals(intent.getAction());
                    if (zEquals || zEquals2) {
                        boolean zEquals3 = AdBaseConstants.MIME_APK.equals(intent.getType());
                        Uri data3 = intent.getData();
                        if (data3 != null) {
                            String lowerCase = data3.toString().toLowerCase();
                            if (lowerCase.endsWith(".apk") || lowerCase.contains(".apk?")) {
                                z = true;
                            } else {
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                        if (zEquals3 || z) {
                            com.fancy.adsdk.lib.utils._d._b(new _bc(this, intent));
                        }
                    }
                }
                if (PtgAdSdk.getConfig().getLind() == 1 && "android.intent.action.VIEW".equals(intent.getAction()) && (data = intent.getData()) != null) {
                    String scheme = data.getScheme();
                    if (!TextUtil.isEmpty(scheme)) {
                        if (TextUtil.isEmpty(scheme)) {
                            try {
                                component = intent.getComponent();
                                String packageName = this._a.getPackageName();
                                if ((component != null || !packageName.equals(component.getPackageName())) && ((resolveInfoResolveActivity = this._a.getPackageManager().resolveActivity(intent, 65536)) == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || !packageName.equals(activityInfo.packageName))) {
                                    if (TextUtil.isEmpty(scheme)) {
                                        if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                            intent.hasCategory("android.intent.category.DEFAULT");
                                        }
                                        data2 = intent.getData();
                                        if (data2 != null) {
                                            try {
                                                string = data2.toString();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        if (string != null) {
                                            try {
                                                _os _osVar = new _os(_n4._a);
                                                _osVar._c = "idp";
                                                _orVar_b = _osVar._b();
                                                try {
                                                    synchronized (_orVar_b._a) {
                                                        _orVar_b._a.put(t.q, string);
                                                    }
                                                } catch (Exception unused2) {
                                                }
                                                _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                                str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
                                                if (TextUtil.isNotEmpty(str_a)) {
                                                    NetUtils._a(str_a);
                                                }
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    } else {
                                        dpWhiteList = PtgAdSdk.getConfig().getDpWhiteList();
                                        if (TextUtil.isEmpty(dpWhiteList)) {
                                            if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                                intent.hasCategory("android.intent.category.DEFAULT");
                                            }
                                            data2 = intent.getData();
                                            if (data2 != null) {
                                                string = data2.toString();
                                            }
                                            if (string != null) {
                                                _os _osVar2 = new _os(_n4._a);
                                                _osVar2._c = "idp";
                                                _orVar_b = _osVar2._b();
                                                synchronized (_orVar_b._a) {
                                                    _orVar_b._a.put(t.q, string);
                                                    _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                                    str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar2);
                                                    if (TextUtil.isNotEmpty(str_a)) {
                                                        NetUtils._a(str_a);
                                                    }
                                                }
                                            }
                                        } else {
                                            it = dpWhiteList.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    next = it.next();
                                                    if (next == null && scheme.startsWith(next)) {
                                                        break;
                                                    }
                                                }
                                            }
                                            if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                                intent.hasCategory("android.intent.category.DEFAULT");
                                            }
                                            data2 = intent.getData();
                                            if (data2 != null) {
                                                string = data2.toString();
                                            }
                                            if (string != null) {
                                                _os _osVar3 = new _os(_n4._a);
                                                _osVar3._c = "idp";
                                                _orVar_b = _osVar3._b();
                                                synchronized (_orVar_b._a) {
                                                    _orVar_b._a.put(t.q, string);
                                                    _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                                    str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar3);
                                                    if (TextUtil.isNotEmpty(str_a)) {
                                                        NetUtils._a(str_a);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } catch (Exception unused4) {
                            }
                        } else {
                            String[] strArr = {"tel", "mailto", "sms", a.H0, "settings", "data", "javascript", "blob", "about", OapsKey.KEY_FILE_TYPE, "ldap", "news", "gopher", "http", "https", UriUtil.LOCAL_FILE_SCHEME, "content", "android_asset", "android_resource"};
                            for (int i2 = 0; i2 < 19; i2++) {
                                if (!strArr[i2].equalsIgnoreCase(scheme)) {
                                }
                            }
                            component = intent.getComponent();
                            String packageName2 = this._a.getPackageName();
                            if (component != null) {
                                if (TextUtil.isEmpty(scheme)) {
                                    if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                        intent.hasCategory("android.intent.category.DEFAULT");
                                    }
                                    data2 = intent.getData();
                                    if (data2 != null) {
                                        string = data2.toString();
                                    }
                                    if (string != null) {
                                        _os _osVar4 = new _os(_n4._a);
                                        _osVar4._c = "idp";
                                        _orVar_b = _osVar4._b();
                                        synchronized (_orVar_b._a) {
                                            _orVar_b._a.put(t.q, string);
                                            _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                            str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar4);
                                            if (TextUtil.isNotEmpty(str_a)) {
                                                NetUtils._a(str_a);
                                            }
                                        }
                                    }
                                } else {
                                    dpWhiteList = PtgAdSdk.getConfig().getDpWhiteList();
                                    if (TextUtil.isEmpty(dpWhiteList)) {
                                        if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                            intent.hasCategory("android.intent.category.DEFAULT");
                                        }
                                        data2 = intent.getData();
                                        if (data2 != null) {
                                            string = data2.toString();
                                        }
                                        if (string != null) {
                                            _os _osVar5 = new _os(_n4._a);
                                            _osVar5._c = "idp";
                                            _orVar_b = _osVar5._b();
                                            synchronized (_orVar_b._a) {
                                                _orVar_b._a.put(t.q, string);
                                                _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                                str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar5);
                                                if (TextUtil.isNotEmpty(str_a)) {
                                                    NetUtils._a(str_a);
                                                }
                                            }
                                        }
                                    } else {
                                        it = dpWhiteList.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                next = it.next();
                                                if (next == null) {
                                                }
                                            }
                                        }
                                        if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                            intent.hasCategory("android.intent.category.DEFAULT");
                                        }
                                        data2 = intent.getData();
                                        if (data2 != null) {
                                            string = data2.toString();
                                        }
                                        if (string != null) {
                                            _os _osVar6 = new _os(_n4._a);
                                            _osVar6._c = "idp";
                                            _orVar_b = _osVar6._b();
                                            synchronized (_orVar_b._a) {
                                                _orVar_b._a.put(t.q, string);
                                                _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                                str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar6);
                                                if (TextUtil.isNotEmpty(str_a)) {
                                                    NetUtils._a(str_a);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (TextUtil.isEmpty(scheme)) {
                                if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                    intent.hasCategory("android.intent.category.DEFAULT");
                                }
                                data2 = intent.getData();
                                if (data2 != null) {
                                    string = data2.toString();
                                }
                                if (string != null) {
                                    _os _osVar7 = new _os(_n4._a);
                                    _osVar7._c = "idp";
                                    _orVar_b = _osVar7._b();
                                    synchronized (_orVar_b._a) {
                                        _orVar_b._a.put(t.q, string);
                                        _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                        str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar7);
                                        if (TextUtil.isNotEmpty(str_a)) {
                                            NetUtils._a(str_a);
                                        }
                                    }
                                }
                            } else {
                                dpWhiteList = PtgAdSdk.getConfig().getDpWhiteList();
                                if (TextUtil.isEmpty(dpWhiteList)) {
                                    if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                        intent.hasCategory("android.intent.category.DEFAULT");
                                    }
                                    data2 = intent.getData();
                                    if (data2 != null) {
                                        string = data2.toString();
                                    }
                                    if (string != null) {
                                        _os _osVar8 = new _os(_n4._a);
                                        _osVar8._c = "idp";
                                        _orVar_b = _osVar8._b();
                                        synchronized (_orVar_b._a) {
                                            _orVar_b._a.put(t.q, string);
                                            _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                            str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar8);
                                            if (TextUtil.isNotEmpty(str_a)) {
                                                NetUtils._a(str_a);
                                            }
                                        }
                                    }
                                } else {
                                    it = dpWhiteList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            next = it.next();
                                            if (next == null) {
                                            }
                                        }
                                    }
                                    if (!intent.hasCategory("android.intent.category.BROWSABLE")) {
                                        intent.hasCategory("android.intent.category.DEFAULT");
                                    }
                                    data2 = intent.getData();
                                    if (data2 != null) {
                                        string = data2.toString();
                                    }
                                    if (string != null) {
                                        _os _osVar9 = new _os(_n4._a);
                                        _osVar9._c = "idp";
                                        _orVar_b = _osVar9._b();
                                        synchronized (_orVar_b._a) {
                                            _orVar_b._a.put(t.q, string);
                                            _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
                                            str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar9);
                                            if (TextUtil.isNotEmpty(str_a)) {
                                                NetUtils._a(str_a);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return method.invoke(this._b, objArr);
    }
}
