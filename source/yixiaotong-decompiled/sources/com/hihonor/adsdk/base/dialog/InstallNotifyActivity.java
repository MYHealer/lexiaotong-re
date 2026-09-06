package com.hihonor.adsdk.base.dialog;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.hihonor.adsdk.base.init.ActivateStyle;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.safe.SafeIntent;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InstallNotifyActivity extends com.hihonor.adsdk.base.widget.base.a {
    private static final String hnadse = "InstallNotifyActivity";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsa(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onAdsCreate start show", new Object[0]);
        if (isDestroyed()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "activity is Destroyed", new Object[0]);
        } else {
            a.hnadsc().hnadsa(view, new PopupWindow.OnDismissListener() { // from class: com.hihonor.adsdk.base.dialog.InstallNotifyActivity$$ExternalSyntheticLambda1
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    this.f$0.hnadsc();
                }
            }, String.valueOf(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "window onDismiss", new Object[0]);
        if (isDestroyed()) {
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "finish current activity", new Object[0]);
        finish();
    }

    private void hnadsd() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.alpha = 0.1f;
        if (!u.hnadsc((Context) this) && Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        getWindow().setAttributes(layoutParams);
        View view = new View(this);
        view.setBackgroundColor(-16777216);
        setContentView(view);
    }

    @Override // com.hihonor.adsdk.base.widget.base.a
    protected void hnadsb(Bundle bundle) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadse, "onAdsCreate", new Object[0]);
        if (hnadsb() == ActivateStyle.CONFIRM_DIALOG) {
            hnadsd();
        }
        final View rootView = getWindow().getDecorView().getRootView();
        if (rootView != null) {
            rootView.post(new Runnable() { // from class: com.hihonor.adsdk.base.dialog.InstallNotifyActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.hnadsa(rootView);
                }
            });
        }
    }

    private ActivateStyle hnadsb() {
        ActivateStyle activateStyle = ActivateStyle.DISMISS_DIALOG;
        Serializable serializableExtra = new SafeIntent(getIntent()).getSerializableExtra(a.hnadsk);
        return serializableExtra != null ? (ActivateStyle) serializableExtra : activateStyle;
    }
}
