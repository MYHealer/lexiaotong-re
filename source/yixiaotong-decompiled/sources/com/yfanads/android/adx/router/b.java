package com.yfanads.android.adx.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hihonor.adsdk.base.c;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.core.TransparentActivity;
import com.yfanads.android.adx.core.impl.NativeAdImpl;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.d;
import com.yfanads.android.adx.webview.AdxWebViewActivity;
import com.yfanads.android.custom.view.BaseDialogFragment;
import com.yfanads.android.custom.view.CustomDialog;
import com.yfanads.android.qapp.QuickMgr;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: AdxRouter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9613a;
    public String b;
    public int c;
    public a d;
    public boolean e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public boolean n;
    public String o;
    public String p;
    public CustomDialog q;

    /* JADX INFO: compiled from: AdxRouter.java */
    public interface a {
    }

    public final boolean a(final Activity activity, Context context, final com.yfanads.android.adx.service.a aVar) {
        boolean zA = a(context);
        YFLog.high("navigation isDeepLink = " + zA + " showDialog=" + this.e + " dp=" + this.f9613a);
        if (!zA) {
            if (!TextUtils.isEmpty(this.f9613a)) {
                a(1, 5, "1");
                a(1, 3, new String[0]);
            }
            return false;
        }
        a(1, 2, new String[0]);
        if (this.e) {
            CustomDialog customDialogBindData = new CustomDialog.CustomDialogBuilder().setLayoutId(R.layout.adx_dialog_confirm_layout).setSize(-2, -2).setOffsetY(30).setGravity(80).build().bindData(new BaseDialogFragment.DialogBindData() { // from class: com.yfanads.android.adx.router.b$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.custom.view.BaseDialogFragment.DialogBindData
                public final void bindViewData(View view) {
                    this.f$0.c(activity, aVar, view);
                }
            });
            this.q = customDialogBindData;
            customDialogBindData.setCancelable(true);
            this.q.show(activity.getFragmentManager(), "confirm");
        } else {
            a(activity, aVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Activity activity, com.yfanads.android.adx.service.a aVar, View view) {
        CustomDialog customDialog = this.q;
        if (customDialog != null) {
            customDialog.dismissAllowingStateLoss();
            this.q = null;
        }
        a(activity, aVar);
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void c(final Activity activity, final com.yfanads.android.adx.service.a aVar, View view) {
        TextView textView = (TextView) view.findViewById(R.id.adx_open_other_app);
        int i = R.string.adx_open_other_app;
        Object[] objArr = new Object[2];
        AdxSdkConfig adxSdkConfig = d.c;
        objArr[0] = adxSdkConfig != null ? adxSdkConfig.appName : "";
        objArr[1] = !TextUtils.isEmpty(this.g) ? "\"" + this.g + "\"" : activity.getString(R.string.adx_other_app);
        textView.setText(activity.getString(i, objArr));
        view.findViewById(R.id.adx_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.router.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.a(view2);
            }
        });
        view.findViewById(R.id.adx_sure).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.router.b$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.b(activity, aVar, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        CustomDialog customDialog = this.q;
        if (customDialog != null) {
            customDialog.dismissAllowingStateLoss();
            this.q = null;
        }
        a(1, 5, "0");
        a(true, false, true, true);
    }

    public final boolean a(Context context) {
        if (context != null && !TextUtils.isEmpty(this.f9613a)) {
            try {
                return context.getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.f9613a)), 65536) != null;
            } catch (Throwable th) {
                th.printStackTrace();
                com.yfanads.android.adx.utils.a.b("isDeepLinkAvailable error " + th.getMessage());
            }
        }
        return false;
    }

    public final void a(Activity activity, com.yfanads.android.adx.service.a aVar) {
        if (TextUtils.isEmpty(this.f9613a)) {
            a(1, 5, "0");
            return;
        }
        a(1, 1, new String[0]);
        String str = this.h;
        String str2 = this.i;
        String str3 = this.g;
        String str4 = this.f9613a;
        if (QuickMgr.isBlocked(str4)) {
            com.yfanads.android.adx.utils.a.a("openThirdApp use system default");
            a(1, 5, "0");
            a(true, false, false, true);
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) TransparentActivity.class);
        intent.putExtra("package_name", str);
        intent.putExtra(TransparentActivity.EXTRA_REF_NAME, str2);
        intent.putExtra(TransparentActivity.EXTRA_TYPE, aVar);
        intent.putExtra("app_name", str3);
        intent.putExtra(TransparentActivity.EXTRA_NPD, this.o);
        intent.putExtra(TransparentActivity.EXTRA_NPDW, this.p);
        if (str4 != null) {
            intent.putExtra(TransparentActivity.EXTRA_LAUNCH_URI, str4);
        }
        TransparentActivity.setLaunchResultCallback(new com.yfanads.android.adx.router.a(this, activity));
        try {
            activity.startActivity(intent);
            activity.overridePendingTransition(0, 0);
            a(1, 4, new String[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            TransparentActivity.setLaunchResultCallback(null);
            a(1, 5, "0");
            a(false, new boolean[0]);
        }
    }

    public final boolean a(Activity activity) {
        a(2, 1, new String[0]);
        try {
            String str = "";
            if (this.n && a((Context) activity)) {
                str = this.f9613a;
            }
            YFLog.debug("dUrl: " + this.b + " , dL:" + str + " , isLpaa:" + this.n);
            String str2 = this.b;
            int i = AdxWebViewActivity.e;
            activity.startActivityForResult(new Intent(activity, (Class<?>) AdxWebViewActivity.class).putExtra("url", str2).putExtra(c.r1.hnadsd, str), 101);
            a(2, 4, new String[0]);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            a(2, 5, new String[0]);
            return false;
        }
    }

    public final void a(int i, int i2, String... strArr) {
        a aVar = this.d;
        if (aVar != null) {
            NativeAdImpl.c cVar = (NativeAdImpl.c) aVar;
            if (cVar.get() != null) {
                NativeAdImpl nativeAdImpl = cVar.get();
                nativeAdImpl.getClass();
                if (i == 1) {
                    if (i2 == 0) {
                        throw null;
                    }
                    int i3 = i2 - 1;
                    if (i3 == 0) {
                        nativeAdImpl.reportAdInfo(8, null);
                        return;
                    }
                    if (i3 == 1) {
                        nativeAdImpl.reportAdInfo(20, null);
                        return;
                    }
                    if (i3 == 2) {
                        nativeAdImpl.reportAdInfo(21, null);
                    } else if (i3 == 3) {
                        nativeAdImpl.reportAdInfo(9, null);
                    } else {
                        if (i3 != 4) {
                            return;
                        }
                        nativeAdImpl.reportAdInfo(10, strArr);
                    }
                }
            }
        }
    }

    public final void a(boolean z, boolean... zArr) {
        int i;
        a aVar = this.d;
        if (aVar != null) {
            NativeAdImpl.c cVar = (NativeAdImpl.c) aVar;
            if (cVar.get() != null) {
                NativeAdImpl nativeAdImpl = cVar.get();
                boolean z2 = cVar.b;
                boolean z3 = cVar.c;
                nativeAdImpl.getClass();
                int length = zArr.length;
                AdxNativeAd.AdInteractionListener adInteractionListener = nativeAdImpl.f9586a;
                boolean z4 = false;
                boolean z5 = length > 0 && zArr[0];
                boolean z6 = length > 1 && zArr[1];
                if (length > 2 && zArr[2]) {
                    z4 = true;
                }
                com.yfanads.android.adx.utils.a.c("handleSuccess start=" + z + " , isDirectDownload=" + z5 + ", isClick= " + z3 + ", isDpCancel= " + z6 + ", isBlocked= " + z4);
                nativeAdImpl.f = z;
                if (z && adInteractionListener != null) {
                    if (z3) {
                        adInteractionListener.onAdClickedSuccess(z2, z5, z4);
                    } else {
                        adInteractionListener.onAdShakeSuccess(z2, z5, z4);
                    }
                }
                if (nativeAdImpl.f && ((i = nativeAdImpl.d) == 2 || i == 1)) {
                    com.yfanads.android.adx.components.base.a.C1170a.f9566a.getClass();
                    com.yfanads.android.adx.components.base.a.b();
                }
                if (z6 && !z3 && adInteractionListener != null) {
                    adInteractionListener.onAdShakeCancel();
                }
                com.yfanads.android.adx.utils.a.c("handleSuccess end navigation =" + nativeAdImpl.f);
            }
        }
    }
}
