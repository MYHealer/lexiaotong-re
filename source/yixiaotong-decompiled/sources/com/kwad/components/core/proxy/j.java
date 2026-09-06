package com.kwad.components.core.proxy;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.q;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class j extends DialogFragment {
    protected abstract View a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onAttach(Context context) {
        q.checkInitSDK(context);
        super.onAttach(com.kwad.sdk.wrapper.m.wrapContextIfNeed(context));
    }

    @Override // android.app.Fragment
    public Context getContext() {
        return com.kwad.sdk.wrapper.m.wrapContextIfNeed(super.getContext());
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return com.kwad.sdk.wrapper.m.eU(com.kwad.sdk.wrapper.m.wrapContextIfNeed(super.onGetLayoutInflater(bundle).getContext()));
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterEU = com.kwad.sdk.wrapper.m.eU(com.kwad.sdk.wrapper.m.wrapContextIfNeed(layoutInflater.getContext()));
        if (getDialog() != null) {
            getDialog().requestWindowFeature(1);
        }
        return a(layoutInflaterEU, viewGroup);
    }

    @Override // android.app.DialogFragment
    public int show(FragmentTransaction fragmentTransaction, String str) {
        try {
            return super.show(fragmentTransaction, str);
        } catch (Throwable unused) {
            return a(fragmentTransaction, str);
        }
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        try {
            try {
                super.show(fragmentManager, str);
            } catch (Throwable unused) {
                ab.callMethod(this, "showAllowingStateLoss", fragmentManager, str);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            a(fragmentManager.beginTransaction(), str);
        }
    }

    private int a(FragmentTransaction fragmentTransaction, String str) {
        try {
            ab.a(this, "mDismissed", Boolean.FALSE);
            ab.a(this, "mShownByMe", Boolean.TRUE);
            ab.a(this, "mViewDestroyed", Boolean.FALSE);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return fragmentTransaction.add(this, str).commitAllowingStateLoss();
    }

    @Override // android.app.DialogFragment
    public void dismiss() {
        try {
            if (getActivity() != null && !getActivity().isFinishing()) {
                super.dismissAllowingStateLoss();
            } else if (getActivity() == null) {
                super.dismissAllowingStateLoss();
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public final boolean isShowing() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            return dialog.isShowing();
        }
        return false;
    }

    public final void a(FragmentManager fragmentManager, String str) {
        try {
            if (isAdded()) {
                return;
            }
            show(fragmentManager, str);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }
}
