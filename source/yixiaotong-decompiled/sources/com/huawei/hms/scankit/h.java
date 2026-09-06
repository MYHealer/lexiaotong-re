package com.huawei.hms.scankit;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.scankit.drawable.ScanDrawable;
import com.huawei.hms.scankit.p.d7;
import com.huawei.hms.scankit.p.y6;
import java.util.Locale;

/* JADX INFO: compiled from: IRemoteLocalViewDelegateImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h extends i implements View.OnClickListener {
    private ScanDrawable E;
    private ImageView F;
    private ImageView G;
    private ImageView H;
    private ImageView I;
    private ImageView J;
    private RelativeLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private int P;
    private int Q;
    private LinearLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private LinearLayout W;

    /* JADX INFO: compiled from: IRemoteLocalViewDelegateImpl.java */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            Context context = h.this.c;
            if (context == null) {
                return;
            }
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            if (y6.c((Activity) h.this.c)) {
                return;
            }
            int width = ((Activity) h.this.c).getWindow().getDecorView().getRootView().getWidth() - rect.right;
            if (!y6.c()) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.O.getLayoutParams();
                if (width != 0) {
                    int marginEnd = layoutParams.getMarginEnd();
                    h hVar = h.this;
                    if (marginEnd != d7.a(hVar.c, hVar.P - 12)) {
                        h hVar2 = h.this;
                        layoutParams.setMarginEnd(d7.a(hVar2.c, hVar2.P - 12));
                        return;
                    }
                    return;
                }
                int marginEnd2 = layoutParams.getMarginEnd();
                h hVar3 = h.this;
                if (marginEnd2 != d7.a(hVar3.c, hVar3.P - 12) + d7.a(h.this.c)) {
                    h hVar4 = h.this;
                    layoutParams.setMarginEnd(d7.a(hVar4.c, hVar4.P - 12) + d7.a(h.this.c));
                    return;
                }
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) h.this.K.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) h.this.W.getLayoutParams();
            if (width != 0) {
                int marginStart = layoutParams2.getMarginStart();
                h hVar5 = h.this;
                if (marginStart != d7.a(hVar5.c, hVar5.P - 12)) {
                    h hVar6 = h.this;
                    layoutParams2.setMarginStart(d7.a(hVar6.c, hVar6.P - 12));
                }
                int marginStart2 = layoutParams3.getMarginStart();
                h hVar7 = h.this;
                if (marginStart2 != d7.a(hVar7.c, hVar7.P - 12)) {
                    h hVar8 = h.this;
                    layoutParams3.setMarginStart(d7.a(hVar8.c, hVar8.P - 12));
                    return;
                }
                return;
            }
            int marginStart3 = layoutParams2.getMarginStart();
            h hVar9 = h.this;
            if (marginStart3 != d7.a(hVar9.c, hVar9.P - 12) + d7.a(h.this.c)) {
                h hVar10 = h.this;
                layoutParams2.setMarginStart(d7.a(hVar10.c, hVar10.P - 12) + d7.a(h.this.c));
            }
            int marginStart4 = layoutParams3.getMarginStart();
            h hVar11 = h.this;
            if (marginStart4 != d7.a(hVar11.c, hVar11.P - 12) + d7.a(h.this.c)) {
                h hVar12 = h.this;
                layoutParams3.setMarginStart(d7.a(hVar12.c, hVar12.P - 12) + d7.a(h.this.c));
            }
        }
    }

    public h(Context context, int i, IObjectWrapper iObjectWrapper, boolean z, boolean z2, int i2) {
        super(context, i, iObjectWrapper, z, z2);
        this.P = 24;
        this.Q = i2;
    }

    private void p() {
        ((RelativeLayout.LayoutParams) this.L.getLayoutParams()).setMarginStart(d7.a(this.c, this.P - 12));
        ((RelativeLayout.LayoutParams) this.M.getLayoutParams()).setMarginEnd(d7.a(this.c, this.P - 12));
        ((RelativeLayout.LayoutParams) this.N.getLayoutParams()).setMarginStart(d7.a(this.c, this.P - 12));
        ((RelativeLayout.LayoutParams) this.O.getLayoutParams()).setMarginEnd(d7.a(this.c, this.P - 12));
    }

    private void q() {
        Context context = this.c;
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    private void r() {
        this.d.findViewById(R.id.scan_title_landscape).setVisibility(8);
        this.d.findViewById(R.id.scan_title).setVisibility(0);
    }

    private void s() {
        int currentModeType = ((UiModeManager) ((Activity) this.c).getSystemService("uimode")).getCurrentModeType();
        if (currentModeType == 3) {
            this.P = 32;
            return;
        }
        if (currentModeType == 4) {
            this.P = 48;
        } else if (currentModeType != 6) {
            this.P = 24;
        } else {
            this.P = 26;
        }
    }

    private void u() {
        this.R.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
        layoutParams.setMargins(0, l(), 0, 0);
        this.K.setLayoutParams(layoutParams);
        this.d.findViewById(R.id.scan_title_landscape).setVisibility(0);
        this.d.findViewById(R.id.scan_title).setVisibility(8);
    }

    @Override // com.huawei.hms.scankit.i, com.huawei.hms.scankit.e
    protected void e() {
        super.e();
        this.F = (ImageView) this.d.findViewById(R.id.ivScan);
        this.G = (ImageView) this.d.findViewById(R.id.back_img_in);
        this.H = (ImageView) this.d.findViewById(R.id.img_btn);
        this.I = (ImageView) this.d.findViewById(R.id.scankit_back_img_in_land);
        this.J = (ImageView) this.d.findViewById(R.id.scankit_img_btn_in_land);
        this.K = (RelativeLayout) this.d.findViewById(R.id.scan_title_landscape);
        this.L = (LinearLayout) this.d.findViewById(R.id.back_layout);
        this.M = (LinearLayout) this.d.findViewById(R.id.gallery_Layout);
        this.N = (LinearLayout) this.d.findViewById(R.id.back_layout_landscape);
        this.O = (LinearLayout) this.d.findViewById(R.id.gallery_Layout_landscape);
        this.R = (LinearLayout) this.d.findViewById(R.id.scan_title_layout);
        this.S = (TextView) this.d.findViewById(R.id.title_scan);
        this.T = (TextView) this.d.findViewById(R.id.title_scan_level_two);
        this.U = (TextView) this.d.findViewById(R.id.scankit_title_scan_land);
        this.V = (TextView) this.d.findViewById(R.id.scankit_title_scan_land_level_two);
        this.W = (LinearLayout) this.d.findViewById(R.id.scanLayout);
        this.L.setOnClickListener(this);
        this.M.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.O.setOnClickListener(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.R.getLayoutParams();
        layoutParams.setMargins(0, d7.a(this.c, 80) + y6.c(this.c), 0, 0);
        layoutParams.addRule(6);
        this.R.setLayoutParams(layoutParams);
        this.R.bringToFront();
        this.R.setVisibility(0);
        s();
        p();
        if (this.Q == 0) {
            this.S.setText(R.string.scankit_title_all);
            TextView textView = this.S;
            textView.setContentDescription(textView.getResources().getString(R.string.scankit_title_all));
            this.T.setText(R.string.scankit_title_all_level_two);
            this.U.setText(R.string.scankit_title_all);
            TextView textView2 = this.U;
            textView2.setContentDescription(textView2.getResources().getString(R.string.scankit_title_all));
            this.V.setText(R.string.scankit_title_all_level_two);
        } else {
            this.S.setText(R.string.scankit_title_qr);
            TextView textView3 = this.S;
            textView3.setContentDescription(textView3.getResources().getString(R.string.scankit_title_qr));
            this.T.setText(R.string.scankit_title_qr_level_two);
            this.U.setText(R.string.scankit_title_qr);
            TextView textView4 = this.U;
            textView4.setContentDescription(textView4.getResources().getString(R.string.scankit_title_qr));
            this.V.setText(R.string.scankit_title_qr_level_two);
        }
        this.V.bringToFront();
        try {
            ImageView imageView = this.F;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                if (d7.b(this.c).x > d7.a(this.c, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX)) {
                    layoutParams2.width = d7.b(this.c).x / 2;
                } else {
                    layoutParams2.width = d7.b(this.c).x;
                }
                this.F.setLayoutParams(layoutParams2);
                ScanDrawable scanDrawable = new ScanDrawable(this.c.getResources());
                this.E = scanDrawable;
                this.F.setImageDrawable(scanDrawable);
            }
            if (!y6.i(this.c)) {
                if (y6.c((Activity) this.c)) {
                    r();
                } else {
                    t();
                }
                if (y6.e(this.c) && !y6.b((Activity) this.c) && !y6.g(this.c)) {
                    if (y6.e()) {
                        t();
                    } else {
                        u();
                    }
                }
            }
            if (y6.e(this.c)) {
                LinearLayout linearLayout = (LinearLayout) this.d.findViewById(R.id.scan_title_layout);
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                if (y6.b((Activity) this.c)) {
                    layoutParams3.setMargins(0, d7.a(this.c, 80), 0, 0);
                    layoutParams3.addRule(10);
                } else if (!y6.g(this.c)) {
                    if (y6.e()) {
                        layoutParams3.setMargins(0, d7.a(this.c, 80), 0, 0);
                        layoutParams3.addRule(10);
                    } else {
                        layoutParams3.setMargins(0, d7.a(this.c, 0), 0, 0);
                        layoutParams3.addRule(12);
                    }
                }
                linearLayout.setLayoutParams(layoutParams3);
                linearLayout.bringToFront();
            }
            if (!y6.c((Activity) this.c) && y6.j(this.c) && !y6.i(this.c) && !y6.e(this.c)) {
                if (Locale.getDefault() == null || !y6.c()) {
                    ((RelativeLayout.LayoutParams) this.O.getLayoutParams()).setMarginEnd(d7.a(this.c, this.P - 12) + d7.a(this.c));
                } else {
                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.K.getLayoutParams();
                    layoutParams4.setMarginEnd(d7.a(this.c, 0));
                    layoutParams4.setMarginStart(d7.a(this.c, this.P - 12) + d7.a(this.c));
                    RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.W.getLayoutParams();
                    layoutParams5.setMarginEnd(d7.a(this.c, 0));
                    layoutParams5.setMarginStart(d7.a(this.c, this.P - 12) + d7.a(this.c));
                }
            }
            if (!y6.c((Activity) this.c) && y6.h(this.c)) {
                i();
            }
        } catch (NullPointerException unused) {
            Log.e("scankitSDk", "initView: NullPoint");
        } catch (RuntimeException unused2) {
            Log.e("scankitSDk", "initView: Exception");
        }
        ((RelativeLayout) this.d.findViewById(R.id.scan_parent_view)).getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    @Override // com.huawei.hms.scankit.i
    protected void j() {
        if (Locale.getDefault() == null || !y6.c()) {
            return;
        }
        this.G = (ImageView) this.d.findViewById(R.id.back_img_in);
        this.I = (ImageView) this.d.findViewById(R.id.scankit_back_img_in_land);
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.scankit_ic_back_mirroring);
            this.I.setImageResource(R.drawable.scankit_ic_back_mirroring);
        }
        k();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.back_layout) {
            q();
        }
        if (view.getId() == R.id.back_layout_landscape) {
            q();
        }
        if (view.getId() == R.id.back_img_in) {
            q();
        }
        if (view.getId() == R.id.scankit_back_img_in_land) {
            q();
        }
        if (view.getId() == R.id.gallery_Layout) {
            this.i.onClick(view);
        }
        if (view.getId() == R.id.gallery_Layout_landscape) {
            this.i.onClick(view);
        }
        if (view.getId() == R.id.scankit_img_btn_in_land) {
            this.i.onClick(view);
        }
        if (view.getId() == R.id.img_btn) {
            this.i.onClick(view);
        }
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStart() {
        super.onStart();
        ScanDrawable scanDrawable = this.E;
        if (scanDrawable != null) {
            if (scanDrawable.isRunning()) {
                return;
            }
            this.E.start();
        } else {
            ScanDrawable scanDrawable2 = new ScanDrawable(this.c.getResources());
            this.E = scanDrawable2;
            this.F.setImageDrawable(scanDrawable2);
            this.E.start();
        }
    }

    @Override // com.huawei.hms.scankit.e, com.huawei.hms.hmsscankit.api.IRemoteViewDelegate
    public void onStop() {
        super.onStop();
        ScanDrawable scanDrawable = this.E;
        if (scanDrawable != null && scanDrawable.isRunning()) {
            this.E.stop();
        }
    }

    @Override // com.huawei.hms.scankit.i, com.huawei.hms.scankit.e
    protected ProviderRemoteView d() {
        return new ProviderRemoteView(DynamicModuleInitializer.getContext() == null ? this.c : DynamicModuleInitializer.getContext(), false, false);
    }

    private void t() {
        WindowManager windowManager;
        int i;
        Context context = this.c;
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            windowManager = (WindowManager) context.getSystemService("window");
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (y6.c((Activity) this.c)) {
            i = point.x;
        } else {
            i = point.y;
        }
        if (defaultDisplay.getWidth() < i) {
            r();
        } else {
            u();
        }
    }
}
