package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.download.DownloadService;
import com.fancy.mpsdk.download.beans.RequestInfo;
import com.google.android.exoplayer2.C;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cv {
    public static final HashMap _a = new HashMap();
    public static AtomicBoolean _b = new AtomicBoolean(false);
    public static AtomicBoolean _c = new AtomicBoolean(false);
    public static final Handler _d = new Handler(Looper.getMainLooper());
    public static final _b _e = new _b();

    public class _a implements _c {
        public final /* synthetic */ _eq _a;
        public final /* synthetic */ String _b;
        public final /* synthetic */ String _c;
        public final /* synthetic */ Context _d;
        public final /* synthetic */ _f _e;
        public final /* synthetic */ String _f;
        public final /* synthetic */ AdSlot _g;

        public _a(_eq _eqVar, String str, String str2, Context context, _f _fVar, String str3, AdSlot adSlot) {
            this._a = _eqVar;
            this._b = str;
            this._c = str2;
            this._d = context;
            this._e = _fVar;
            this._f = str3;
            this._g = adSlot;
        }

        public final void _a(int i, int i2, String str) {
            _d3._a _aVar;
            Logger.d("PTG_QM_TAG result " + i + " - " + i2);
            boolean z = true;
            if (2 != i) {
                if (1 != i) {
                    _eq _eqVar = this._a;
                    if (_eqVar != null) {
                        _eqVar._a(str);
                        return;
                    }
                    return;
                }
                _eq _eqVar2 = this._a;
                if (_eqVar2 != null) {
                    _eqVar2._a();
                }
                _f _fVar = this._e;
                if (_fVar != null) {
                    _fVar._a = 1;
                }
                _b3._a(this._d, _fVar, this._g);
                return;
            }
            _eq _eqVar3 = this._a;
            if (_eqVar3 != null) {
                _eqVar3._a();
            }
            _d3 _d3Var = _d3._b;
            String str2 = this._b;
            String str3 = this._c;
            _d3Var.getClass();
            RequestInfo requestInfo = new RequestInfo(str3);
            requestInfo._d = 10;
            requestInfo._g = null;
            requestInfo._a = str2;
            requestInfo._b = ".apk";
            requestInfo._f = new _d1(str3, str2);
            requestInfo._h = true;
            HashMap map = _d3._d;
            synchronized (map) {
                _aVar = (_d3._a) map.get(com.fancy.adsdk.lib.utils._a._c(requestInfo._c));
            }
            if (_aVar != null && (!_aVar._b.isEmpty())) {
                Context context = this._d;
                WeakReference<Toast> weakReference = _on._a;
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                Toast toast = _on._a.get();
                if (toast != null) {
                    toast.cancel();
                }
                Toast toastMakeText = Toast.makeText(origApplicationContext, "正在下载中...", 1);
                toastMakeText.show();
                _on._a = new WeakReference<>(toastMakeText);
                return;
            }
            Context context2 = this._d;
            _f _fVar2 = this._e;
            String str4 = this._f;
            String str5 = this._c;
            _eq _eqVar4 = this._a;
            boolean z2 = _gx._b(PtgAdSdk.getContext()) == 0;
            if ((!z2 || PtgAdSdk.getConfig().isAllowDirectDownloadOverMobileNetwork()) && (z2 || PtgAdSdk.getConfig().isAllowDirectDownloadOverWifiNetwork())) {
                z = false;
            }
            if (!(context2 instanceof Activity) || !z) {
                _cv._a(context2, _fVar2, str4, str5);
                if (_eqVar4 != null) {
                    _eqVar4._b();
                    return;
                }
                return;
            }
            Activity activity = (Activity) context2;
            String str6 = "是否开始下载" + str4;
            _cw _cwVar = new _cw(context2, _fVar2, str4, str5, _eqVar4);
            _cp _cpVar = _9._a;
            if (_cpVar != null) {
                _cpVar.dismiss();
                _9._a = null;
            }
            _cp _cpVar2 = new _cp(activity);
            _9._a = _cpVar2;
            _cpVar2._f = str6;
            TextView textView = _cpVar2._d;
            if (textView != null) {
                textView.setText(str6);
            }
            _9._a.setOnDismissListener(new _6(_cwVar));
            _cp _cpVar3 = _9._a;
            _cpVar3._g = new _7(_cwVar);
            _cpVar3.setOnKeyListener(new _8());
            Logger.d("PTG_QM_TAG show() ");
            _9._a.show();
        }
    }

    public class _b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            Context context = PtgAdSdk.getContext();
            String str_d = context == null ? "" : _kr._d(context, "uninstall_apk_path");
            Context context2 = PtgAdSdk.getContext();
            String str_d2 = context2 != null ? _kr._d(context2, "uninstall_apk_download_url") : "";
            Context context3 = PtgAdSdk.getContext();
            if (context3 != null) {
                _kr._d(context3, "uninstall_apk_app_name");
            }
            if (!TextUtils.isEmpty(str_d2) && !TextUtils.isEmpty(str_d2)) {
                _cv._a(PtgAdSdk.getContext(), str_d);
            }
            _hq._a(PtgAdSdk.getContext());
        }
    }

    public interface _c {
    }

    public static PtgAppDownloadListener _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (PtgAppDownloadListener) _a.get(com.fancy.adsdk.lib.utils._a._c(str));
    }

    public static void _a(Context context, _f _fVar, AdSlot adSlot, _eq _eqVar) {
        if (_fVar == null) {
            _eqVar._a("资源数据异常！[ad]");
            return;
        }
        if (_fVar._a != 0) {
            _eqVar._a("资源数据异常！[action]");
            return;
        }
        String str = _fVar._i;
        if (TextUtils.isEmpty(str)) {
            _eqVar._a("资源数据异常！[url]");
            return;
        }
        String str_c = _fVar._c();
        String str_a = _d6._a(str_c, ".apk");
        File file_a = _d6._a(context, str_a);
        if (_d6._a(file_a)) {
            _eqVar._a();
            String absolutePath = file_a.getAbsolutePath();
            if (context == null || TextUtils.isEmpty(absolutePath)) {
                return;
            }
            _hq._a(context);
            try {
                File file = new File(absolutePath);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.addFlags(1);
                intent.addFlags(2);
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                _b.set(true);
                return;
            } catch (Exception e) {
                _b.set(false);
                Logger.e(e.getMessage());
                return;
            }
        }
        _a _aVar = new _a(_eqVar, str_a, str, context, _fVar, str_c, adSlot);
        if (_fVar._a != 0) {
            _aVar._a(0, PtgErrorCode.SDK_RESOURCE_ERROR, "资源数据异常！[action]");
            return;
        }
        if (TextUtils.isEmpty(_fVar._i)) {
            _aVar._a(0, PtgErrorCode.SDK_RESOURCE_ERROR, "资源数据异常！[url]");
            return;
        }
        int i = _fVar._k;
        if (i != 0) {
            _aVar._a(i, -1, "");
            return;
        }
        _d3 _d3Var = _d3._b;
        _d3Var.getClass();
        String str2 = _fVar._i;
        String str_c2 = com.fancy.adsdk.lib.utils._a._c(str2);
        synchronized (_d3Var._a) {
            if (!_d3Var._a.containsKey(str_c2)) {
                _d3Var._a.put(str_c2, str_c2);
                try {
                    new _cu(str2, new _d2(_d3Var, str_c2, _fVar, _aVar));
                } catch (Exception e2) {
                    _d3Var._a(0, PtgErrorCode.SDK_RESOURCE_ERROR, e2.getMessage(), str_c2, _fVar, _aVar);
                }
            }
        }
    }

    public static boolean _a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            _hq._a(context);
            try {
                File file = new File(str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.addFlags(1);
                intent.addFlags(2);
                intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file), AdBaseConstants.MIME_APK);
                context.startActivity(intent);
                _b.set(true);
                return true;
            } catch (Exception e) {
                _b.set(false);
                Logger.e(e.getMessage());
            }
        }
        return false;
    }

    public static void _a(Context context, _f _fVar) {
        AppInfo appInfo;
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(context == null ? "" : _kr._d(context, "uninstall_apk_path"))) {
            Handler handler = _d;
            _b _bVar = _e;
            handler.removeCallbacks(_bVar);
            handler.postDelayed(_bVar, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            return;
        }
        if (_fVar == null || _fVar._a != 0 || (appInfo = _fVar._c) == null) {
            return;
        }
        String package_name = appInfo.getPackage_name();
        if (TextUtils.isEmpty(package_name)) {
            return;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(package_name, 1);
            if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) == 0 || packageInfo.versionCode <= 0) {
                return;
            }
            com.fancy.adsdk.lib.utils._d._c(new _cz(_fVar._i, _fVar._c()));
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0099 A[Catch: all -> 0x00c6, TryCatch #3 {, blocks: (B:31:0x0091, B:33:0x0099, B:35:0x00af, B:37:0x00b5, B:38:0x00b6, B:39:0x00ba, B:45:0x00c4, B:46:0x00c5, B:34:0x00aa, B:36:0x00b0), top: B:69:0x0091, outer: #0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa A[Catch: all -> 0x00c6, TryCatch #3 {, blocks: (B:31:0x0091, B:33:0x0099, B:35:0x00af, B:37:0x00b5, B:38:0x00b6, B:39:0x00ba, B:45:0x00c4, B:46:0x00c5, B:34:0x00aa, B:36:0x00b0), top: B:69:0x0091, outer: #0, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x008e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0051 A[SYNTHETIC] */
    public static void _a(Context context, _f _fVar, String str, String str2) {
        _d3._a _aVar;
        boolean z;
        _cq _cqVar;
        HashMap map;
        _d3._a _aVar2;
        Messenger messenger;
        _cx _cxVar = new _cx();
        _d3 _d3Var = _d3._b;
        _cy _cyVar = new _cy(_fVar, context, _cxVar);
        _d3Var.getClass();
        RequestInfo requestInfo = new RequestInfo(str2);
        requestInfo._d = 10;
        requestInfo._g = _cyVar;
        requestInfo._a = str;
        requestInfo._b = ".apk";
        requestInfo._f = new _d1(str2, str);
        requestInfo._h = true;
        HashMap map2 = _d3._c;
        map2.put(com.fancy.adsdk.lib.utils._a._c(str2), requestInfo);
        synchronized (_d3Var) {
            try {
                if (map2.isEmpty()) {
                    return;
                }
                Intent intent = new Intent(context, (Class<?>) DownloadService.class);
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                for (RequestInfo requestInfo2 : map2.values()) {
                    if (requestInfo2 != null) {
                        HashMap map3 = _d3._d;
                        synchronized (map3) {
                            _aVar = (_d3._a) map3.get(com.fancy.adsdk.lib.utils._a._c(requestInfo2._c));
                        }
                        if (_aVar != null && (!_aVar._b.isEmpty())) {
                            z = true;
                        }
                        if (!requestInfo2._h && z) {
                            Logger.d("skip single download task");
                        } else {
                            _cqVar = requestInfo2._g;
                            if (_cqVar != null) {
                                map = _d3._d;
                                synchronized (map) {
                                    _aVar2 = (_d3._a) map.get(requestInfo2);
                                    if (_aVar2 == null) {
                                        _aVar2 = new _d3._a(requestInfo2._c);
                                        map.put(com.fancy.adsdk.lib.utils._a._c(requestInfo2._c), _aVar2);
                                    } else {
                                        Logger.e("download seed has exist");
                                    }
                                    synchronized (_aVar2) {
                                        try {
                                            _aVar2._b.add(_cqVar);
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                    messenger = _aVar2._c;
                                    requestInfo2._e = messenger;
                                }
                                if (messenger == null && !z) {
                                    arrayList.add(requestInfo2);
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    z = false;
                    if (!requestInfo2._h) {
                    }
                    _cqVar = requestInfo2._g;
                    if (_cqVar != null) {
                        map = _d3._d;
                        synchronized (map) {
                            _aVar2 = (_d3._a) map.get(requestInfo2);
                            if (_aVar2 == null) {
                                _aVar2 = new _d3._a(requestInfo2._c);
                                map.put(com.fancy.adsdk.lib.utils._a._c(requestInfo2._c), _aVar2);
                            } else {
                                Logger.e("download seed has exist");
                            }
                            synchronized (_aVar2) {
                                _aVar2._b.add(_cqVar);
                                messenger = _aVar2._c;
                                requestInfo2._e = messenger;
                                if (messenger == null) {
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                }
                if (!arrayList.isEmpty()) {
                    intent.putParcelableArrayListExtra("service_intent_extra", arrayList);
                    try {
                        context.startService(intent);
                    } catch (Exception unused) {
                    }
                }
                _d3._c.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
