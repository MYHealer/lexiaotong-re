package com.huawei.hms.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.nativead.R;
import com.huawei.hms.ads.template.downloadbuttonstyle.RemoteButtonStyleAttr;
import com.huawei.hms.ads.template.downloadbuttonstyle.d;
import com.huawei.hms.ads.template.downloadbuttonstyle.e;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.views.PPSNativeView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cm extends com.huawei.hms.ads.uiengine.c.b {
    private WeakReference<PPSNativeView> A;
    private AdContentData E;
    private com.huawei.openalliance.ad.inter.data.l G;
    private IPPSUiEngineCallback H;
    private String J;
    private a K;
    private Context y;
    private WeakReference<Context> z;

    private static class a implements AppDownloadListener {
        private final WeakReference<cm> Code;

        public a(cm cmVar) {
            this.Code = new WeakReference<>(cmVar);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(AppStatus appStatus, com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            cm cmVar = this.Code.get();
            if (cmVar == null) {
                return;
            }
            cmVar.Code("onAppOpen", (String) null);
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, int i) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void V(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        }
    }

    public cm(Context context, PPSNativeView pPSNativeView, com.huawei.openalliance.ad.inter.data.l lVar) {
        this.y = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.z = new WeakReference<>(context);
        this.A = new WeakReference<>(pPSNativeView);
        this.G = lVar;
        this.E = lVar != null ? lVar.q() : null;
        if (lVar == null || lVar.E() == null) {
            return;
        }
        this.K = new a(this);
        com.huawei.openalliance.ad.download.a.Code().V(this.K);
    }

    private void B(Bundle bundle) {
        AdContentData adContentData = this.E;
        if (adContentData == null) {
            fh.V("NativeProxy", "contentRecord is null");
            return;
        }
        if (bundle != null) {
            try {
                if (adContentData.D() != null && this.E.D().equals(this.J)) {
                    fh.V("NativeProxy", "Duplicate escalation videoTime event for %s", this.E.D());
                    return;
                }
                this.E.B(bundle.getLong(com.huawei.openalliance.ad.constant.br.f.H));
                jk.V(this.y, this.E, com.huawei.openalliance.ad.constant.aj.h);
                this.J = this.E.D();
            } catch (Throwable th) {
                fh.I("NativeProxy", "reportPlayTime err: %s", th.getClass().getSimpleName());
            }
        }
    }

    private com.huawei.hms.ads.template.downloadbuttonstyle.a Code(int i, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        fh.Code("NativeProxy", "btnStyle: %s", Integer.valueOf(i));
        if (1 == i) {
            return new d(this.y, appDownloadButton);
        }
        if (2 == i) {
            return new com.huawei.hms.ads.template.downloadbuttonstyle.c(this.y, appDownloadButton);
        }
        return 3 == i ? new e(this.y, appDownloadButton, remoteButtonStyleAttr) : new com.huawei.hms.ads.template.downloadbuttonstyle.b(this.y, appDownloadButton);
    }

    private String Code(boolean z, String str, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (remoteButtonStyleAttr == null) {
            return str;
        }
        if (z) {
            return remoteButtonStyleAttr.v();
        }
        int iL_ = this.G.l_();
        return ((iL_ == 1 || iL_ == 3) && !TextUtils.isEmpty(remoteButtonStyleAttr.v())) ? remoteButtonStyleAttr.v() : str;
    }

    private void Code(int i, String str, VideoInfo videoInfo) {
        if (videoInfo != null) {
            videoInfo.I(Boolean.TRUE.toString());
            videoInfo.Code(i);
            videoInfo.Code(str);
        }
    }

    private void Code(Bundle bundle, PPSNativeView pPSNativeView, int i, String str) {
        if (this.G.ay() == null || this.G.ay().intValue() != 3) {
            return;
        }
        try {
            if (fh.Code()) {
                fh.Code("NativeProxy", "video_info: %s, preview_image_info: %s, video_alias %s", bundle.getString(com.huawei.openalliance.ad.constant.bf.aO), bundle.getString(com.huawei.openalliance.ad.constant.bf.aP), bundle.getString(com.huawei.openalliance.ad.constant.bf.aQ));
            }
            com.huawei.openalliance.ad.beans.metadata.VideoInfo videoInfo = (com.huawei.openalliance.ad.beans.metadata.VideoInfo) com.huawei.openalliance.ad.utils.ad.V(bundle.getString(com.huawei.openalliance.ad.constant.bf.aO), com.huawei.openalliance.ad.beans.metadata.VideoInfo.class, new Class[0]);
            if (videoInfo != null) {
                VideoInfo videoInfo2 = new VideoInfo(videoInfo);
                videoInfo2.Code(i);
                videoInfo2.I(Boolean.TRUE.toString());
                videoInfo2.Code(str);
                pPSNativeView.setVideoInfo(videoInfo2);
            }
            ImageInfo imageInfo = (ImageInfo) com.huawei.openalliance.ad.utils.ad.V(bundle.getString(com.huawei.openalliance.ad.constant.bf.aP), ImageInfo.class, new Class[0]);
            if (imageInfo != null) {
                com.huawei.openalliance.ad.inter.data.ImageInfo imageInfo2 = new com.huawei.openalliance.ad.inter.data.ImageInfo(imageInfo);
                ArrayList arrayList = new ArrayList();
                arrayList.add(imageInfo2);
                pPSNativeView.setImageInfos(arrayList);
            }
            pPSNativeView.setVideoAlias(bundle.getString(com.huawei.openalliance.ad.constant.bf.aQ));
        } catch (Throwable th) {
            fh.I("NativeProxy", "resetMetaDataAndProgress ex: %s", th.getClass().getSimpleName());
        }
    }

    private void Code(IObjectWrapper iObjectWrapper, int i, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButtonI = I(iObjectWrapper);
        if (appDownloadButtonI == null) {
            fh.I("NativeProxy", "btn null");
        } else {
            fh.V("NativeProxy", "update btn style start");
            new e(this.y, appDownloadButtonI, remoteButtonStyleAttr).Code(this.y);
        }
    }

    private void Code(IObjectWrapper iObjectWrapper, String str, int i, RemoteButtonStyleAttr remoteButtonStyleAttr) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof com.huawei.openalliance.ad.views.AppDownloadButton) {
                fh.V("NativeProxy", "registerDownloadBtn");
                final com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
                final PPSNativeView pPSNativeView = this.A.get();
                com.huawei.hms.ads.template.downloadbuttonstyle.a aVarCode = Code(i, appDownloadButton, remoteButtonStyleAttr);
                boolean zD = D();
                if (pPSNativeView != null) {
                    if (Code(zD, remoteButtonStyleAttr != null && remoteButtonStyleAttr.w())) {
                        pPSNativeView.setNativeAd(this.G);
                        if (pPSNativeView.Code((ll) appDownloadButton)) {
                            fh.Code("NativeProxy", "register succ");
                            Code(zD, remoteButtonStyleAttr, appDownloadButton, str);
                            Code(appDownloadButton);
                            appDownloadButton.setNeedAppendProgress(true);
                            aVarCode.Code(this.y);
                            appDownloadButton.V();
                        } else {
                            view.setVisibility(8);
                        }
                        V(appDownloadButton);
                        return;
                    }
                    if (this.G.l_() == 0) {
                        view.setVisibility(8);
                        return;
                    }
                    fh.Code("NativeProxy", "show btn");
                    if (F()) {
                        appDownloadButton.Code(this.G);
                    }
                    appDownloadButton.Code(new View.OnClickListener() { // from class: com.huawei.hms.ads.cm.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            PPSNativeView pPSNativeView2 = pPSNativeView;
                            if (pPSNativeView2 != null) {
                                pPSNativeView2.Code((View) appDownloadButton, 1, true, cm.this.G);
                            }
                        }
                    });
                    aVarCode.Code(this.y);
                    final String strCode = Code(zD, str, remoteButtonStyleAttr);
                    aVarCode.Code(strCode);
                    Code(strCode, appDownloadButton);
                    appDownloadButton.setButtonTextWatcherInner(new com.huawei.openalliance.ad.views.AppDownloadButton.d() { // from class: com.huawei.hms.ads.cm.3
                        @Override // com.huawei.openalliance.ad.views.AppDownloadButton.d
                        public CharSequence Code(CharSequence charSequence, AppStatus appStatus) {
                            if (cm.this.G.l_() == 7) {
                                return AppStatus.INSTALLED == appStatus ? charSequence : cm.this.y.getString(R.string.hiad_learn_more);
                            }
                            return com.huawei.hms.ads.utils.a.Code(strCode, cm.this.y.getString(R.string.hiad_detail));
                        }
                    });
                    appDownloadButton.V();
                }
            }
        }
    }

    private void Code(RemoteButtonStyleAttr remoteButtonStyleAttr, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        if (remoteButtonStyleAttr == null) {
            fh.I("NativeProxy", "reset err, attr is null");
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.r())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.r());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.s())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.s());
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.t())) {
            appDownloadButton.setRemoteBfDlBtnTxt(remoteButtonStyleAttr.t());
        }
        if (TextUtils.isEmpty(remoteButtonStyleAttr.u())) {
            return;
        }
        appDownloadButton.setRemoteAfDlBtnText(remoteButtonStyleAttr.u());
    }

    private void Code(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        com.huawei.openalliance.ad.inter.data.AppInfo appInfo;
        MetaData metaDataJ_ = this.G.j_();
        if (metaDataJ_ == null || metaDataJ_.e() == null || (appInfo = appDownloadButton.getAppInfo()) == null) {
            return;
        }
        ApkInfo apkInfoE = metaDataJ_.e();
        apkInfoE.i(appInfo.l());
        apkInfoE.j(appInfo.m());
    }

    private void Code(String str, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        if (this.G.l_() == 1 && TextUtils.isEmpty(appDownloadButton.getText())) {
            fh.Code("NativeProxy", "resetWebBtnText promtTxt: %s", str);
            if (TextUtils.isEmpty(str)) {
                str = this.y.getString(R.string.hiad_detail);
            }
            appDownloadButton.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("app_status_method", str);
        if (str2 != null) {
            bundle.putString("app_status", str2);
        }
        Code("notifyAppStatus", bundle);
    }

    private void Code(boolean z, RemoteButtonStyleAttr remoteButtonStyleAttr, com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton, String str) {
        int iL_ = this.G.l_();
        if (remoteButtonStyleAttr == null) {
            if (iL_ == 2 || iL_ == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
            return;
        }
        if (z) {
            Code(remoteButtonStyleAttr, appDownloadButton);
            return;
        }
        if (!TextUtils.isEmpty(remoteButtonStyleAttr.r())) {
            appDownloadButton.setBfDlBtnTxt(remoteButtonStyleAttr.r());
        }
        if (iL_ != 8 && !TextUtils.isEmpty(remoteButtonStyleAttr.s())) {
            appDownloadButton.setAfDlBtnText(remoteButtonStyleAttr.s());
        } else {
            if (iL_ == 2 || iL_ == 5) {
                return;
            }
            appDownloadButton.setAfDlBtnText(str);
        }
    }

    private boolean Code(boolean z, boolean z2) {
        if (F()) {
            return false;
        }
        if (z) {
            return z2;
        }
        int iL_ = this.G.l_();
        return iL_ == 2 || iL_ == 5 || iL_ == 4 || iL_ == 8 || (iL_ == 3 && this.G.E() != null);
    }

    private boolean D() {
        return h.Code() != null && Integer.parseInt(h.Code()) >= 30468100;
    }

    private boolean F() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.G;
        return (lVar == null || lVar.E() == null || this.G.l_() != 7 || com.huawei.openalliance.ad.utils.h.Code(this.y, this.G.E().Code())) ? false : true;
    }

    private RemoteButtonStyleAttr I(Bundle bundle) {
        if (new el(bundle).i(com.huawei.openalliance.ad.constant.br.a.Code) != 3) {
            return null;
        }
        return Z(bundle);
    }

    private com.huawei.openalliance.ad.views.AppDownloadButton I(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        if (!(view instanceof com.huawei.openalliance.ad.views.AppDownloadButton)) {
            return null;
        }
        com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton = (com.huawei.openalliance.ad.views.AppDownloadButton) view;
        if (this.A.get() == null) {
            return null;
        }
        return appDownloadButton;
    }

    private void I(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        fh.V("NativeProxy", "update btn style");
        RemoteButtonStyleAttr remoteButtonStyleAttrI = I(bundle);
        if (remoteButtonStyleAttrI == null) {
            fh.I("NativeProxy", "attr null");
        } else {
            Code(iObjectWrapper, 3, remoteButtonStyleAttrI);
        }
    }

    private void V(Bundle bundle) {
        String strW = new el(bundle).w(TraceUrlData.JsonKeyOld.KEY_EVENT_TYPE);
        PPSNativeView pPSNativeView = this.A.get();
        if (com.huawei.openalliance.ad.constant.aj.Code.equals(strW) && pPSNativeView != null && pPSNativeView.a()) {
            pPSNativeView.setNativeAd(this.G);
            com.huawei.openalliance.ad.inter.data.l lVar = this.G;
            if (lVar != null) {
                lVar.I(false);
                this.G.C(false);
                this.G.Z(true);
            }
        }
    }

    private void V(IObjectWrapper iObjectWrapper, Bundle bundle) {
        String str;
        if (iObjectWrapper == null || bundle == null) {
            return;
        }
        fh.V("NativeProxy", "update btn text");
        RemoteButtonStyleAttr remoteButtonStyleAttrI = I(bundle);
        if (remoteButtonStyleAttrI == null) {
            str = "attr null";
        } else {
            com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButtonI = I(iObjectWrapper);
            if (appDownloadButtonI != null) {
                Code(remoteButtonStyleAttrI, appDownloadButtonI);
                return;
            }
            str = "btn null";
        }
        fh.I("NativeProxy", str);
    }

    private void V(com.huawei.openalliance.ad.views.AppDownloadButton appDownloadButton) {
        appDownloadButton.setOnDownloadStatusChangedListener(new com.huawei.openalliance.ad.views.AppDownloadButton.e() { // from class: com.huawei.hms.ads.cm.4
            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
            public void Code(AppStatus appStatus) {
                fh.Code("NativeProxy", "onStatusChanged: %s", appStatus);
                if (appStatus == null) {
                    appStatus = AppStatus.DOWNLOAD;
                }
                cm.this.Code("onStatusChanged", appStatus.name());
            }

            @Override // com.huawei.openalliance.ad.views.AppDownloadButton.e
            public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
                cm.this.Code("onUserCancel", (String) null);
            }
        });
    }

    private RemoteButtonStyleAttr Z(Bundle bundle) {
        try {
            RemoteButtonStyleAttr remoteButtonStyleAttr = (RemoteButtonStyleAttr) com.huawei.openalliance.ad.utils.ad.V(bundle.getString(com.huawei.openalliance.ad.constant.br.a.V), RemoteButtonStyleAttr.class, new Class[0]);
            if (remoteButtonStyleAttr != null) {
                IBinder binder = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.I);
                if (binder != null) {
                    remoteButtonStyleAttr.Code((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder));
                }
                IBinder binder2 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.Z);
                if (binder2 != null) {
                    remoteButtonStyleAttr.V((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder2));
                }
                IBinder binder3 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.B);
                if (binder3 != null) {
                    remoteButtonStyleAttr.I((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder3));
                }
                IBinder binder4 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.C);
                if (binder4 != null) {
                    remoteButtonStyleAttr.Z((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder4));
                }
                IBinder binder5 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.D);
                if (binder5 != null) {
                    remoteButtonStyleAttr.B((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder5));
                }
                IBinder binder6 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.L);
                if (binder6 != null) {
                    remoteButtonStyleAttr.F((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder6));
                }
                IBinder binder7 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.f4440a);
                if (binder7 != null) {
                    remoteButtonStyleAttr.D((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder7));
                }
                IBinder binder8 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.b);
                if (binder8 != null) {
                    remoteButtonStyleAttr.L((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder8));
                }
                IBinder binder9 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.S);
                if (binder9 != null) {
                    remoteButtonStyleAttr.C((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder9));
                }
                IBinder binder10 = bundle.getBinder(com.huawei.openalliance.ad.constant.br.a.F);
                if (binder10 != null) {
                    remoteButtonStyleAttr.S((Drawable) ObjectWrapper.unwrap((IObjectWrapper) binder10));
                }
                remoteButtonStyleAttr.V(bundle.getString(com.huawei.openalliance.ad.constant.br.a.d));
                remoteButtonStyleAttr.I(bundle.getString(com.huawei.openalliance.ad.constant.br.a.e));
                remoteButtonStyleAttr.C(bundle.getString(com.huawei.openalliance.ad.constant.br.a.f));
                remoteButtonStyleAttr.I(bundle.getBoolean(com.huawei.openalliance.ad.constant.br.a.c, false));
                remoteButtonStyleAttr.Z(bundle.getString(com.huawei.openalliance.ad.constant.br.a.g));
                remoteButtonStyleAttr.B(bundle.getString(com.huawei.openalliance.ad.constant.br.a.h));
            }
            return remoteButtonStyleAttr;
        } catch (Throwable th) {
            fh.I("NativeProxy", "getAttrs err: %s", th.getClass().getSimpleName());
            return null;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean B() {
        try {
            boolean zBooleanValue = ((Boolean) com.huawei.openalliance.ad.utils.be.Code(new Callable<Boolean>() { // from class: com.huawei.hms.ads.cm.1
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    if (cm.this.E == null) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("apiVer", cm.this.E.aF());
                        jSONObject.put("content_id", cm.this.E.a());
                        jSONObject.put("templateId", cm.this.E.aE());
                        jSONObject.put("slotid", cm.this.E.L());
                        jSONObject.put("unique_id", cm.this.E.aa());
                        fh.V("NativeProxy", "downloadVideos, uniqueId: %s", cm.this.E.aa());
                    } catch (Throwable th) {
                        fh.V("NativeProxy", "construct json err: %s", th.getClass().getSimpleName());
                    }
                    return Boolean.valueOf(Boolean.TRUE.toString().equals(com.huawei.openalliance.ad.ipc.b.Code(cm.this.y).Code(com.huawei.openalliance.ad.constant.s.y, jSONObject.toString(), String.class).getData()));
                }
            }, false)).booleanValue();
            fh.Code("NativeProxy", "result = %s", Boolean.valueOf(zBooleanValue));
            return zBooleanValue;
        } catch (Throwable th) {
            fh.V("NativeProxy", "downloadVideos err: %s", th.getClass().getSimpleName());
            return false;
        }
    }

    public void C() {
        com.huawei.openalliance.ad.download.a.Code().I(this.K);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code() {
        PPSNativeView pPSNativeView = this.A.get();
        if (pPSNativeView != null) {
            pPSNativeView.L();
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(int i) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.G;
        if (lVar == null || lVar.E() == null) {
            return;
        }
        if (i == 0) {
            fh.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: DESC");
            Context context = this.z.get();
            if (context == null) {
                fh.V("NativeProxy", "jump context is null.");
                return;
            }
            PPSNativeView pPSNativeView = this.A.get();
            if (pPSNativeView == null || pPSNativeView.getClickInfo() == null) {
                this.G.V(context);
                return;
            } else {
                fh.Code("NativeProxy", pPSNativeView.getClickInfo().toString());
                this.G.Code(context, pPSNativeView.getClickInfo());
                return;
            }
        }
        if (i == 1) {
            fh.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: Privacy");
            this.G.E().Code(this.y);
        } else {
            if (i != 2) {
                return;
            }
            fh.V("NativeProxy", " decouple's AIDL: onAdClickSixElementsBtn: Permission");
            if (!TextUtils.isEmpty(this.G.E().t())) {
                this.G.E().V(this.y);
                return;
            }
            PPSNativeView pPSNativeView2 = this.A.get();
            if (pPSNativeView2 != null) {
                com.huawei.openalliance.ad.download.app.j.Code(pPSNativeView2.getContext(), this.G.E());
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(long j) {
        fh.Code("NativeProxy", "updateStartShowTime: %s", Long.valueOf(j));
        com.huawei.openalliance.ad.inter.data.l lVar = this.G;
        if (lVar != null) {
            lVar.Code(j);
        }
        AdContentData adContentData = this.E;
        if (adContentData == null) {
            return;
        }
        adContentData.Z(j);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(long j, long j2) {
        dd.Code(this.y, this.E, j, j2);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(Bundle bundle) {
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.A.get();
            if (view == null || pPSNativeView == null) {
                return;
            }
            pPSNativeView.showFeedback(view);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, int i) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.A.get();
            if (pPSNativeView != null) {
                pPSNativeView.Code(view, i, true, this.G);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            PPSNativeView pPSNativeView = this.A.get();
            pPSNativeView.setNativeAd(this.G);
            el elVar = new el(bundle);
            int i = elVar.i(com.huawei.openalliance.ad.constant.br.c.Code);
            String strW = elVar.w("click_info");
            boolean zCode = elVar.Code(com.huawei.openalliance.ad.constant.br.f.u, true);
            MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.ad.V(strW, MaterialClickInfo.class, new Class[0]);
            int i2 = elVar.i(com.huawei.openalliance.ad.constant.bf.q);
            String strCode = elVar.Code(com.huawei.openalliance.ad.constant.bf.r, "n");
            Code(i2, strCode, this.G.C());
            if (pPSNativeView == null) {
                return;
            }
            Code(elVar.Code(), pPSNativeView, i2, strCode);
            pPSNativeView.setMaterialClickInfo(materialClickInfo);
            String strW2 = elVar.w(com.huawei.openalliance.ad.constant.br.f.v);
            if (com.huawei.openalliance.ad.utils.bc.Code(strW2)) {
                pPSNativeView.Code(view, i, zCode, this.G);
            } else {
                pPSNativeView.Code(view, i, strW2);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str) {
        Code(iObjectWrapper, str, 0, (RemoteButtonStyleAttr) null);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IObjectWrapper iObjectWrapper, String str, Bundle bundle) {
        int i = bundle.getInt(com.huawei.openalliance.ad.constant.br.a.Code);
        if (3 == i) {
            RemoteButtonStyleAttr remoteButtonStyleAttrZ = Z(bundle);
            if (remoteButtonStyleAttrZ != null) {
                Code(iObjectWrapper, str, i, remoteButtonStyleAttrZ);
                return;
            }
            i = 2;
        }
        Code(iObjectWrapper, str, i, (RemoteButtonStyleAttr) null);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(IPPSUiEngineCallback iPPSUiEngineCallback) {
        this.H = iPPSUiEngineCallback;
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str) {
        fh.Code("NativeProxy", "updateContent: %s", str);
        com.huawei.openalliance.ad.inter.data.l lVar = this.G;
        if (lVar != null) {
            lVar.B(str);
        }
        AdContentData adContentData = this.E;
        if (adContentData == null) {
            return;
        }
        adContentData.I(str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, int i) {
        PPSNativeView pPSNativeView = this.A.get();
        if (!com.huawei.openalliance.ad.constant.aj.e.equals(str)) {
            if (pPSNativeView != null) {
                pPSNativeView.setNativeAd(this.G);
                pPSNativeView.Code(Integer.valueOf(i), false);
                return;
            }
            return;
        }
        ji.a aVar = new ji.a();
        aVar.V(Integer.valueOf(i));
        String strCode = com.huawei.openalliance.ad.utils.bg.Code((gc) pPSNativeView);
        com.huawei.openalliance.ad.inter.data.l lVar = this.G;
        if (lVar != null) {
            fh.Code("NativeProxy", "slotId: %s, contentId: %s, slot pos: %s", lVar.r(), this.G.d(), strCode);
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(strCode)) {
            aVar.B(strCode);
        }
        if (pPSNativeView != null) {
            aVar.I(com.huawei.openalliance.ad.utils.b.Code(pPSNativeView));
        }
        jk.Code(this.y, this.E, aVar.Code(), com.huawei.openalliance.ad.constant.aj.e);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, long j, long j2, int i, int i2) {
        Context context;
        AdContentData adContentData;
        String str2;
        Context context2;
        AdContentData adContentData2;
        String str3;
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "playPause":
                context = this.y;
                adContentData = this.E;
                str2 = com.huawei.openalliance.ad.constant.aj.C;
                jk.Code(context, adContentData, str2, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2));
                break;
            case "playStart":
                context2 = this.y;
                adContentData2 = this.E;
                str3 = com.huawei.openalliance.ad.constant.aj.B;
                jk.Code(context2, adContentData2, str3, (Long) null, (Long) null, (Integer) null, (Integer) null);
                break;
            case "playEnd":
                context = this.y;
                adContentData = this.E;
                str2 = com.huawei.openalliance.ad.constant.aj.Z;
                jk.Code(context, adContentData, str2, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2));
                break;
            case "playResume":
                context2 = this.y;
                adContentData2 = this.E;
                str3 = com.huawei.openalliance.ad.constant.aj.S;
                jk.Code(context2, adContentData2, str3, (Long) null, (Long) null, (Integer) null, (Integer) null);
                break;
        }
    }

    public void Code(String str, Bundle bundle) {
        if (this.H == null) {
            fh.I("NativeProxy", "on call back, call back is null");
            return;
        }
        fh.V("NativeProxy", "onCallback, method: %s", str);
        try {
            this.H.onCallResult(str, bundle);
        } catch (Throwable th) {
            fh.I("NativeProxy", "onCallback ex: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(String str, IObjectWrapper iObjectWrapper, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
        }
        fh.V("NativeProxy", "callMethod: %s", str);
        str.hashCode();
        switch (str) {
            case "update_btn_txt":
                V(iObjectWrapper, bundle);
                break;
            case "reportCommonEvent":
                V(bundle);
                new jj(this.y).Code(bundle, this.E);
                break;
            case "onCommonAnalysis":
                new df(this.y).Code(bundle, this.E);
                break;
            case "update_btn_style":
                I(iObjectWrapper, bundle);
                break;
            default:
                fh.V("NativeProxy", "call method fall to default.");
                break;
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void Code(boolean z) {
        jk.Code(this.y, this.E, z);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public String I() {
        AdContentData adContentData = this.E;
        if (adContentData != null) {
            return adContentData.D();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V() {
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            View view = (View) ObjectWrapper.unwrap(iObjectWrapper);
            if (view instanceof com.huawei.openalliance.ad.views.AppDownloadButton) {
                fh.V("NativeProxy", "updateDownBtn");
                ((com.huawei.openalliance.ad.views.AppDownloadButton) view).Code(this.G);
            }
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(String str, long j, long j2, int i, int i2) {
        jk.Code(this.y, this.E, com.huawei.openalliance.ad.constant.aj.f, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str);
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public void V(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals(com.huawei.openalliance.ad.constant.aj.h)) {
            B(bundle);
        }
    }

    @Override // com.huawei.hms.ads.uiengine.c
    public boolean Z() {
        return this.G.ak();
    }
}
