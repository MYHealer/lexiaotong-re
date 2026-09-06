package com.hihonor.adsdk.base.dialog.installnotify;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.dialog.CustomRelativeLayout;
import com.hihonor.adsdk.base.i.e;
import com.hihonor.adsdk.common.f.p;
import com.huawei.openalliance.ad.constant.br;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b extends PopupWindow {
    private static final String hnadsi = "BaseInstallNotifyWindow";
    public static final int hnadsj = 1;
    public static final int hnadsk = 2;
    public static final int hnadsl = 3;
    public static final int hnadsm = 4;
    public static final int hnadsn = 12;
    private static final int hnadso = -1000;
    private Context hnadsa;
    private final InstallNotifyBean hnadsb;
    private int hnadsc;
    private d hnadsd;
    private c hnadsf;
    private CustomRelativeLayout hnadsg;
    private long hnadse = 0;
    private int hnadsh = 12;

    class a extends p {
        a() {
        }

        @Override // com.hihonor.adsdk.common.f.p
        protected void hnadsa(View view) {
            b.this.hnadsh = 1;
            b.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.dialog.installnotify.b$b, reason: collision with other inner class name */
    class C0429b extends p {
        C0429b() {
        }

        @Override // com.hihonor.adsdk.common.f.p
        protected void hnadsa(View view) {
            b.this.hnadsh = 3;
            b.this.dismiss();
            e.hnadsa(b.this.hnadsb).hnadsa(true).hnadsa().hnadsa(b.this.hnadsb()).start();
        }
    }

    private static class c extends Handler {
        final WeakReference<b> hnadsa;

        c(b bVar) {
            this.hnadsa = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            b bVar = this.hnadsa.get();
            if (bVar != null) {
                com.hihonor.adsdk.common.b.b.hnadsc(b.hnadsi, "dispatchMessage dismiss", new Object[0]);
                bVar.hnadsh = 2;
                bVar.dismiss();
            }
        }
    }

    public interface d {
        void hnadsa(int i, long j, int i2);
    }

    public b(Context context, InstallNotifyBean installNotifyBean) {
        this.hnadsa = context;
        this.hnadsb = installNotifyBean;
    }

    private void hnadsc() {
        ViewGroup viewGroup = (ViewGroup) getContentView();
        if (viewGroup == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "handleConfigurationChanged contentView is null", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleConfigurationChanged", new Object[0]);
        try {
            viewGroup.removeAllViews();
            viewGroup.addView(hnadse(), new ViewGroup.LayoutParams(-1, -2));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "handleConfigurationChanged error msg = " + e.getMessage(), new Object[0]);
        }
    }

    private void hnadsd() {
        setWidth(-1);
        setHeight(-2);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, br.b.C, new Object[0]);
        if (this.hnadsd != null) {
            this.hnadsd.hnadsa(this.hnadsh, this.hnadsh == 2 ? this.hnadsc : System.currentTimeMillis() - this.hnadse, this.hnadsc);
            this.hnadsd = null;
        }
        c cVar = this.hnadsf;
        if (cVar != null) {
            cVar.removeCallbacksAndMessages(null);
            this.hnadsf = null;
        }
        CustomRelativeLayout customRelativeLayout = this.hnadsg;
        if (customRelativeLayout != null) {
            customRelativeLayout.setOnConfigurationChangedListener(null);
            this.hnadsg = null;
        }
        this.hnadsa = null;
        super.dismiss();
    }

    public abstract int hnadsa();

    public void hnadsa(d dVar) {
        this.hnadsd = dVar;
    }

    protected abstract int hnadsb();

    private View hnadse() {
        Context context = this.hnadsa;
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "initView mContext is null", new Object[0]);
            return null;
        }
        InstallNotifyBean installNotifyBean = this.hnadsb;
        if (installNotifyBean == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "initView mGuideDialogBean is null", new Object[0]);
            return null;
        }
        View viewHnadsa = com.hihonor.adsdk.base.dialog.b.hnadsa(context, installNotifyBean, hnadsa());
        if (viewHnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "initView rootView is null", new Object[0]);
            return null;
        }
        ImageView imageView = (ImageView) viewHnadsa.findViewById(R.id.ad_install_notify_close_img);
        View viewFindViewById = viewHnadsa.findViewById(R.id.ad_install_notify_open_btn);
        imageView.setOnClickListener(new a());
        viewFindViewById.setOnClickListener(new C0429b());
        CustomRelativeLayout customRelativeLayout = (CustomRelativeLayout) viewHnadsa.findViewById(R.id.ad_down_root);
        this.hnadsg = customRelativeLayout;
        customRelativeLayout.setOnConfigurationChangedListener(new CustomRelativeLayout.a() { // from class: com.hihonor.adsdk.base.dialog.installnotify.b$$ExternalSyntheticLambda0
            @Override // com.hihonor.adsdk.base.dialog.CustomRelativeLayout.a
            public final void onConfigurationChanged(Configuration configuration) {
                this.f$0.hnadsa(configuration);
            }
        });
        return viewHnadsa;
    }

    private void hnadsf() {
        if (this.hnadsc != -1000) {
            c cVar = new c(this);
            this.hnadsf = cVar;
            cVar.sendEmptyMessageDelayed(0, this.hnadsc);
        }
    }

    public void hnadsa(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "showInstallNotify", new Object[0]);
        this.hnadsc = i;
        hnadsd();
        setContentView(hnadse());
        this.hnadse = System.currentTimeMillis();
        hnadsf();
        super.showAtLocation(view, 80, 0, 0);
    }

    protected void hnadsa(FrameLayout frameLayout, WindowManager.LayoutParams layoutParams) {
        if (frameLayout != null && layoutParams != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "preInvokePopup", new Object[0]);
            if (Build.VERSION.SDK_INT >= 28) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "preInvokePopup SDK_INT is Greater than or equal to P", new Object[0]);
                layoutParams.layoutInDisplayCutoutMode = 1;
                return;
            }
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsi, "preInvokePopup decorView or layoutParams is null", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(Configuration configuration) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "onConfigurationChanged", new Object[0]);
        if (isShowing()) {
            hnadsc();
        }
    }

    public void hnadsa(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsi, "dismiss closeReason = " + i, new Object[0]);
        this.hnadsh = i;
        dismiss();
    }
}
