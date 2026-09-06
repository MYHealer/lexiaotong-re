package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.scankit.p.d7;
import com.huawei.hms.scankit.p.y6;
import java.util.Locale;

/* JADX INFO: compiled from: IRemoteViewDelegateImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class i extends e {
    protected ImageView A;
    private ImageView B;
    private TextView C;
    private IObjectWrapper D;
    protected ViewfinderView z;

    /* JADX INFO: compiled from: IRemoteViewDelegateImpl.java */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View.OnClickListener onClickListener = i.this.i;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    /* JADX INFO: compiled from: IRemoteViewDelegateImpl.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                i.this.f();
                i.this.o();
                i.this.B.setContentDescription(i.this.B.getResources().getString(R.string.scankit_light));
            } else {
                i.this.g();
                view.setSelected(true);
                i.this.C.setText(R.string.scankit_light_off);
                i.this.B.setContentDescription(i.this.B.getResources().getString(R.string.scankit_light_off));
            }
        }
    }

    public i(Context context, int i, IObjectWrapper iObjectWrapper, boolean z, boolean z2) {
        super(context, i, null, iObjectWrapper, z, false, z2);
        this.D = iObjectWrapper;
        this.c = context;
        this.b = i;
        this.p = z;
        this.n = new Rect(-1, -1, -1, -1);
        this.s = z2;
    }

    private boolean n() {
        return this.c.getResources().getDisplayMetrics().widthPixels > 1990 && this.c.getResources().getDisplayMetrics().widthPixels < 2300 && this.c.getResources().getDisplayMetrics().heightPixels > 2190 && this.c.getResources().getDisplayMetrics().heightPixels < 2600;
    }

    @Override // com.huawei.hms.scankit.e
    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext(), false);
    }

    @Override // com.huawei.hms.scankit.e
    protected void e() {
        ProviderRemoteView providerRemoteViewD = d();
        this.d = providerRemoteViewD;
        RelativeLayout relativeLayout = (RelativeLayout) providerRemoteViewD.findViewById(R.id.scan_title);
        if ((!y6.e(this.c) || !y6.b((Activity) this.c)) && relativeLayout != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relativeLayout.getLayoutParams().width, relativeLayout.getLayoutParams().height);
            layoutParams.setMargins(0, m(), 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        this.e = (TextureView) this.d.findViewById(R.id.surfaceView);
        this.z = (ViewfinderView) this.d.findViewById(R.id.viewfinderView);
        com.huawei.hms.scankit.b bVar = new com.huawei.hms.scankit.b(this.c, this.e, this.z, this.n, this.b, this.D, this.p, "DefaultView", false);
        this.f = bVar;
        bVar.b(this.s);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.img_btn);
        this.A = imageView;
        imageView.setOnClickListener(new a());
        this.v = (LinearLayout) this.d.findViewById(R.id.flash_light_ll);
        this.B = (ImageView) this.d.findViewById(R.id.ivFlash);
        c();
        this.B.setOnClickListener(new b());
        this.C = (TextView) this.d.findViewById(R.id.flash_light_text);
        a(true);
        j();
        k();
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public IObjectWrapper getView() {
        return ObjectWrapper.wrap(this.d);
    }

    protected void i() {
        RelativeLayout relativeLayout = (RelativeLayout) this.d.findViewById(R.id.scan_parent_view);
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.v = linearLayout;
        linearLayout.setVisibility(0);
        this.v.setOrientation(1);
        ViewGroup viewGroup = (ViewGroup) this.B.getParent();
        viewGroup.removeView(this.B);
        viewGroup.removeView(this.C);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = d7.a(this.c, 6);
        this.v.setGravity(16);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(d7.a(this.c, 214), -1);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(d7.a(this.c, 24), 0, d7.a(this.c, 24), 0);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.setGravity(16);
        linearLayout2.setOrientation(1);
        ((LinearLayout.LayoutParams) this.B.getLayoutParams()).setMargins(0, 0, 0, 0);
        linearLayout2.addView(this.B);
        linearLayout2.addView(this.C, layoutParams);
        this.v.addView(linearLayout2);
        relativeLayout.addView(this.v, layoutParams2);
    }

    protected void j() {
        if (Locale.getDefault() == null || !y6.c()) {
            return;
        }
        TextView textView = (TextView) this.d.findViewById(R.id.title_scan);
        ImageView imageView = (ImageView) this.d.findViewById(R.id.back_img_in);
        if (imageView != null) {
            imageView.setRotation(180.0f);
        }
        if (textView != null) {
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                layoutParams2.addRule(1, R.id.img_btn);
                layoutParams2.rightMargin = 200;
                textView.setLayoutParams(layoutParams);
            }
        }
        k();
    }

    protected void k() {
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        Context context = this.c;
        if (context == null || context.getResources() == null || this.c.getResources().getDisplayMetrics() == null || !n() || !(layoutParams instanceof FrameLayout.LayoutParams)) {
            return;
        }
        ((FrameLayout.LayoutParams) layoutParams).bottomMargin = 150;
        this.v.setLayoutParams(layoutParams);
    }

    protected int l() {
        int iM = m();
        Context context = this.c;
        if (context == null || context.getResources() == null) {
            return iM;
        }
        try {
            int identifier = this.c.getResources().getIdentifier("hw_multiwindow_height_of_drag_bar", "dimen", "androidhwext");
            return identifier > 0 ? this.c.getResources().getDimensionPixelSize(identifier) : iM;
        } catch (Exception e) {
            Log.e("IRemoteViewDelegateImpl", "getMultiWindowDragBarHeight exception: " + e.getMessage());
            return iM;
        }
    }

    protected int m() {
        int identifier;
        Context context = this.c;
        if (context == null || context.getResources() == null || (identifier = this.c.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return this.c.getResources().getDimensionPixelSize(identifier);
    }

    @Override // com.huawei.hms.scankit.e, android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onResume() {
        com.huawei.hms.scankit.b bVar = this.f;
        if (bVar.i == null) {
            bVar.i = this.e;
        }
        bVar.f();
        o();
        SensorManager sensorManager = this.h;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(5), 2);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void setOnClickListener(IObjectWrapper iObjectWrapper) {
        this.i = (View.OnClickListener) ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOffLight() throws RemoteException {
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void turnOnLight() throws RemoteException {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        ImageView imageView = this.B;
        if (imageView != null) {
            imageView.setSelected(false);
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(R.string.scankit_light);
        }
    }

    @Override // com.huawei.hms.scankit.e
    protected void c() {
        super.c();
        if (this.j || !this.t) {
            return;
        }
        this.v.setVisibility(0);
    }
}
