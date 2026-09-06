package com.gnete.upbc.cashier.f;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.gnete.upbc.cashier.R;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a extends DialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f3298a;
    private TextView b;
    private TextView c;
    private TextView d;
    private String e;
    private String f;
    private String g;
    private String h;
    private b i;
    private InterfaceC0390a j;

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AlertDialog.java */
    public interface InterfaceC0390a {
        void a();
    }

    /* JADX INFO: compiled from: AlertDialog.java */
    public interface b {
        void a();
    }

    public a a(String str) {
        this.f = str;
        return this;
    }

    public a a(String str, InterfaceC0390a interfaceC0390a) {
        this.h = str;
        this.j = interfaceC0390a;
        return this;
    }

    public a a(String str, b bVar) {
        this.g = str;
        this.i = bVar;
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.gnete_text_confirm) {
            dismissAllowingStateLoss();
            b bVar = this.i;
            if (bVar == null) {
                return;
            }
            bVar.a();
            return;
        }
        if (id == R.id.gnete_text_cancel) {
            dismissAllowingStateLoss();
            InterfaceC0390a interfaceC0390a = this.j;
            if (interfaceC0390a == null) {
                return;
            }
            interfaceC0390a.a();
        }
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.setCanceledOnTouchOutside(false);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.gneteDialogTheme);
            }
        }
        return layoutInflater.inflate(R.layout.gnete_dialog_alert, viewGroup);
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onStart() {
        super.onStart();
        if (!TextUtils.isEmpty(this.e)) {
            this.f3298a.setText(this.e);
        }
        if (!TextUtils.isEmpty(this.f)) {
            this.b.setText(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            this.c.setText(this.g);
        }
        if (!TextUtils.isEmpty(this.h)) {
            this.d.setText(this.h);
        }
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f3298a = (TextView) view.findViewById(R.id.gnete_text_title);
        this.b = (TextView) view.findViewById(R.id.gnete_text_content);
        this.c = (TextView) view.findViewById(R.id.gnete_text_confirm);
        this.d = (TextView) view.findViewById(R.id.gnete_text_cancel);
    }

    public a a(InterfaceC0390a interfaceC0390a) {
        return a((String) null, interfaceC0390a);
    }
}
