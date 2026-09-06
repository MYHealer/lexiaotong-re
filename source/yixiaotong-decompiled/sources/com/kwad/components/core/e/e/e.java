package com.kwad.components.core.e.e;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.core.proxy.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e extends j {
    private com.kwad.components.core.e.d.a.C0661a RL;
    private boolean RP = false;
    private Activity mActivity;

    public static void a(Activity activity, com.kwad.components.core.e.d.a.C0661a c0661a) {
        if (activity == null || c0661a == null) {
            return;
        }
        e eVar = new e();
        eVar.RL = c0661a;
        eVar.mActivity = activity;
        eVar.show(activity.getFragmentManager(), "second_confirm_dialog");
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        g.qK().qL();
        com.kwad.components.core.e.d.a.C0661a c0661a = this.RL;
        if (c0661a != null) {
            com.kwad.sdk.core.adlog.c.b(c0661a.getAdTemplate(), 229, (JSONObject) null);
        }
        return super.onCreateDialog(bundle);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        g.qK().qM();
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.RP) {
            return;
        }
        dismiss();
    }

    @Override // com.kwad.components.core.proxy.j
    public final View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        try {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getDialog().setCanceledOnTouchOutside(false);
            getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.kwad.components.core.e.e.e.1
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    return i == 4;
                }
            });
            if (this.mActivity == null || this.RL == null) {
                this.RP = false;
                return null;
            }
            this.RP = true;
            return new a(this.mActivity, this, this.RL);
        } catch (Exception e) {
            this.RP = false;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
