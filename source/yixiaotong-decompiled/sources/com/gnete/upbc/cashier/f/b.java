package com.gnete.upbc.cashier.f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.gnete.upbc.cashier.R;

/* JADX INFO: compiled from: LoadingDialog.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class b extends DialogFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f3299a;

    public b() {
        setStyle(0, R.style.gneteLoadingDialogTheme);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.gnete_dialog_loading, viewGroup, false);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        setCancelable(false);
        if (getDialog() != null && getDialog().getWindow() != null) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = 0.0f;
            attributes.flags |= 2;
            window.setAttributes(attributes);
        }
        ((AnimationDrawable) this.f3299a.getDrawable()).start();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }
        this.f3299a = (ImageView) view.findViewById(R.id.gnete_image_loading);
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (fragmentManager.isDestroyed()) {
            return;
        }
        fragmentManager.beginTransaction().remove(this).commit();
        try {
            super.show(fragmentManager, str);
        } catch (Exception unused) {
        }
    }
}
