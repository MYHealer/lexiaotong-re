package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g7 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5441a;
    public Context b;

    public g7(Activity activity, Context context, int i) {
        super(activity, i);
        this.b = context;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(this.b).inflate(a0.m0, (ViewGroup) null, false);
        setContentView(viewInflate);
        ImageView imageView = (ImageView) viewInflate.findViewById(a0.l0);
        TextView textView = (TextView) viewInflate.findViewById(a0.R2);
        if (this.f5441a) {
            imageView.setImageResource(a0.y5);
            i = a0.o;
        } else {
            imageView.setImageResource(a0.z4);
            i = a0.Q;
        }
        textView.setText(i);
        getWindow().setDimAmount(0.0f);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
