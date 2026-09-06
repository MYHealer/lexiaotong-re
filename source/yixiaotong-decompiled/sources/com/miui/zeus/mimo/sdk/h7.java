package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h7 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5453a;
    public View.OnClickListener b;
    public i8 c;
    public Activity d;
    public TextView e;
    public MimoAdInfo f;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.miui.zeus.mimo.sdk.b.a(AdEvent.POPUP_WINDOW_QUIT, h7.this.f);
            View.OnClickListener onClickListener = h7.this.b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            h7.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.miui.zeus.mimo.sdk.b.a(AdEvent.POPUP_WINDOW_CONTINUE, h7.this.f);
            h7.this.getClass();
            h7.this.dismiss();
        }
    }

    public h7(Activity activity, Context context, MimoAdInfo mimoAdInfo, int i) {
        super(activity, i);
        this.d = activity;
        this.f5453a = context;
        this.f = mimoAdInfo;
    }

    public int a() {
        return a0.T4;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x009b  */
    /* JADX WARN: Code duplicated, block: B:24:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:25:0x00cc  */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        TextView textView;
        String strD;
        Window window;
        Window window2;
        WindowManager.LayoutParams attributes;
        int i;
        TextView textView2;
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(this.f5453a).inflate(a(), (ViewGroup) null, false);
        setContentView(viewInflate);
        viewInflate.findViewById(a0.f0).setOnClickListener(new a());
        TextView textView3 = (TextView) viewInflate.findViewById(a0.c1);
        textView3.setOnClickListener(new b());
        this.e = (TextView) viewInflate.findViewById(a0.z5);
        if (!this.f.A() || (textView2 = this.e) == null) {
            if (this.f.y() && (textView = this.e) != null) {
                textView.setText(ijiami_1011.s.s.s.d(new byte[]{-114, -106, -90, -46, -68, -51, -122, -33, -11, -124, -84, -6, -113, -101, -75, -48, -67, -14, -124, -63, -16, -121, -69, -44}, "f9352d"));
                strD = ijiami_1011.s.s.s.d(new byte[]{-124, -35, -107, -43, -117, -104, -119, -53, -13, -123, -65, -52}, "cf2205");
            }
            window = getWindow();
            if (window != null) {
                window.setGravity(80);
            }
            window2 = getWindow();
            if (window2 != null && (attributes = window2.getAttributes()) != null) {
                if (this.d.getResources().getConfiguration().orientation == 2) {
                    i = this.d.getResources().getDisplayMetrics().heightPixels;
                } else {
                    i = this.d.getResources().getDisplayMetrics().widthPixels;
                }
                attributes.width = i - (f9.a(this.f5453a, 20.0f) * 2);
                attributes.y = f9.a(this.f5453a, 27.0f);
                attributes.height = -2;
                window2.setAttributes(attributes);
                window2.addFlags(2);
                window2.setDimAmount(0.3f);
            }
            setCanceledOnTouchOutside(false);
            setCancelable(false);
        }
        textView2.setText(ijiami_1011.s.s.s.d(new byte[]{-36, -35, -77, -47, -118, -123, -124, -54, -22, -124, -71, -11, -34, -20, -75, -47, -76, -123, -120, -58, -32, -121, -66, -13, -35, -64, -82, -36, -67, -119, SignedBytes.MAX_POWER_OF_TWO}, "8e8978"));
        strD = ijiami_1011.s.s.s.d(new byte[]{-121, -32, -75, -46, -100, -21, -122, -55, -17}, "bf851b");
        textView3.setText(strD);
        window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        window2 = getWindow();
        if (window2 != null) {
            if (this.d.getResources().getConfiguration().orientation == 2) {
                i = this.d.getResources().getDisplayMetrics().heightPixels;
            } else {
                i = this.d.getResources().getDisplayMetrics().widthPixels;
            }
            attributes.width = i - (f9.a(this.f5453a, 20.0f) * 2);
            attributes.y = f9.a(this.f5453a, 27.0f);
            attributes.height = -2;
            window2.setAttributes(attributes);
            window2.addFlags(2);
            window2.setDimAmount(0.3f);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        com.miui.zeus.mimo.sdk.b.a(AdEvent.POPUP_WINDOW_VIEW, this.f);
    }
}
