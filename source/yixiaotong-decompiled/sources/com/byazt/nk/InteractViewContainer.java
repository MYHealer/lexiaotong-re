package com.byazt.nk;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.oq.CircleLongPressView;
import com.byazt.oq.ClickSlideUpShakeView;
import com.byazt.oq.RippleView;
import com.byazt.oq.ShakeAnimationView;
import com.byazt.oq.WriggleGuideAnimationView;
import com.byazt.tm.DynamicBaseWidget;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 234, 2265})
public class InteractViewContainer extends FrameLayout implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2517a;
    public Context c;
    public boolean da;
    public int i;
    public sp n;
    public com.byazt.aq.da sl;
    public RippleView sp;
    public com.byazt.xl.u t;
    public DynamicBaseWidget tt;
    public View uj;
    public com.byazt.aq.sp ve;
    public View.OnTouchListener x;

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar) {
        super(context);
        this.c = context;
        this.tt = dynamicBaseWidget;
        this.ve = spVar;
        sp();
    }

    public InteractViewContainer(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.aq.sp spVar, com.byazt.aq.da daVar, com.byazt.xl.u uVar) {
        super(context);
        this.c = context;
        this.tt = dynamicBaseWidget;
        this.ve = spVar;
        this.sl = daVar;
        this.t = uVar;
        sp();
    }

    private void sp() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.f2517a = this.ve.aw();
        this.i = this.ve.bm();
        this.da = this.ve.kp();
        sp spVarC = i.c(this.c, this.tt, this.ve, this.sl, this.t);
        this.n = spVarC;
        if (spVarC != null) {
            this.uj = spVarC.ve();
            if (this.ve.ic()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.f2517a, "6")) {
                if (this.ve.b() && !TextUtils.isEmpty(this.ve.q())) {
                    this.sp = new RippleView(this.c, com.byazt.aq.sp.c(this.ve.q()));
                } else {
                    this.sp = new RippleView(this.c, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.c);
                frameLayout.addView(this.sp, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.byazt.nk.InteractViewContainer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.sp.tt();
                    }
                });
            }
            if (c(this.f2517a) && com.byazt.sr.uj.c()) {
                int color = Color.parseColor("#99000000");
                if (this.ve.b() && !TextUtils.isEmpty(this.ve.q())) {
                    try {
                        color = com.byazt.aq.sp.c(this.ve.q());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.c);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.n.ve());
            c(this.n.ve());
            setVisibility(0);
        }
    }

    private boolean c(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, BaseWrapper.ENTER_ID_SHORTCUT) || TextUtils.equals(str, "25") || TextUtils.equals(str, BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING) || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.x instanceof com.byazt.ij.ve) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void c(ViewGroup viewGroup) {
        if (this.uj == null) {
            return;
        }
        String str = this.f2517a;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                    b = 11;
                }
                break;
            case 1571:
                if (str.equals(BaseWrapper.ENTER_ID_AD_SDK)) {
                    b = 12;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = 13;
                }
                break;
            case 1574:
                if (str.equals(BaseWrapper.ENTER_ID_17)) {
                    b = 14;
                }
                break;
            case 1575:
                if (str.equals(BaseWrapper.ENTER_ID_18)) {
                    b = 15;
                }
                break;
            case 1598:
                if (str.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                    b = 16;
                }
                break;
            case 1600:
                if (str.equals(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING)) {
                    b = 17;
                }
                break;
            case 1601:
                if (str.equals(BaseWrapper.ENTER_ID_SHORTCUT)) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                this.x = new com.byazt.ij.n(this, this.i, this.t.h());
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.ve.b() || TextUtils.isEmpty(this.ve.q())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.x = new com.byazt.ij.a(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.x = new com.byazt.ij.tt(this, this);
                break;
            case 3:
                if (this.ve.b() && !TextUtils.isEmpty(this.ve.q())) {
                    setBackgroundColor(com.byazt.aq.sp.c(this.ve.q()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.x = new com.byazt.ij.ve(this);
                this.uj.setTag(2);
                break;
            case 6:
            case 9:
                this.tt.setClipChildren(false);
                this.tt.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.tt.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.x = new com.byazt.ij.a(this);
                break;
            case 7:
            case 14:
                this.uj.setTag(2);
                break;
            case 8:
                this.x = new com.byazt.ij.uj(this, this.i, this.da);
                break;
            case 10:
                this.x = new com.byazt.ij.ve(this);
                this.uj.setTag(2);
                break;
            case 11:
            case 19:
                if (this.f2517a.equals("24") && com.byazt.sr.uj.c()) {
                    this.tt.setClipChildren(false);
                    this.x = new com.byazt.ij.a(this);
                } else {
                    this.x = new com.byazt.ij.n(this, this.i, this.t.h());
                }
                break;
            case 12:
                this.x = new com.byazt.ij.tt(this, this);
                break;
            case 13:
                View view = this.uj;
                if (view != null && (view instanceof ShakeAnimationView) && ((ShakeAnimationView) view).getShakeLayout() != null) {
                    ((ShakeAnimationView) this.uj).getShakeLayout().setTag(2);
                }
                this.uj.setTag(2);
                break;
            case 15:
                View view2 = this.uj;
                if (view2 != null && (view2 instanceof WriggleGuideAnimationView) && ((WriggleGuideAnimationView) view2).getWriggleLayout() != null) {
                    ((WriggleGuideAnimationView) this.uj).getWriggleLayout().setTag(2);
                }
                this.uj.setTag(2);
                break;
            case 16:
                this.x = new com.byazt.ij.c(this, this.i, viewGroup);
                break;
            case 17:
                if (com.byazt.sr.uj.c()) {
                    this.x = new com.byazt.ij.x(this, this.da);
                } else {
                    this.x = new com.byazt.ij.sp(this, this.i, viewGroup);
                }
                break;
            case 18:
                if (com.byazt.sr.uj.c()) {
                    this.x = new com.byazt.ij.a(this);
                }
                break;
            case 20:
                if (com.byazt.sr.uj.c()) {
                    this.x = new com.byazt.ij.x(this, this.da);
                }
                break;
            case 21:
                View view3 = this.uj;
                if (view3 != null && (view3 instanceof ClickSlideUpShakeView) && ((ClickSlideUpShakeView) view3).getShakeView() != null) {
                    ((ClickSlideUpShakeView) this.uj).getShakeView().setTag(2);
                }
                this.x = new com.byazt.ij.n(this, this.i, this.t.h());
                break;
        }
        View.OnTouchListener onTouchListener = this.x;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (x()) {
            this.uj.setTag(2);
            setOnClickListener((View.OnClickListener) this.tt.getDynamicClickListener());
        }
    }

    private boolean x() {
        return (this.ve.kp() || TextUtils.equals("9", this.f2517a) || TextUtils.equals("16", this.f2517a) || TextUtils.equals(BaseWrapper.ENTER_ID_17, this.f2517a) || TextUtils.equals(BaseWrapper.ENTER_ID_18, this.f2517a) || TextUtils.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.f2517a) || TextUtils.equals("29", this.f2517a) || TextUtils.equals("10", this.f2517a)) ? false : true;
    }

    public void ve() {
        sp spVar = this.n;
        if (spVar != null) {
            spVar.c();
        }
    }

    public void uj() {
        sp spVar = this.n;
        if (spVar != null) {
            spVar.tt();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            sp spVar = this.n;
            if (spVar != null) {
                spVar.tt();
            }
        } catch (Exception e) {
            com.byazt.nr.m.ve(e.getMessage());
        }
    }

    public void n() {
        if (this.uj != null && TextUtils.equals(this.f2517a, "2")) {
            View view = this.uj;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).ve();
            }
        }
    }

    public void a() {
        if (this.uj != null && TextUtils.equals(this.f2517a, "2")) {
            View view = this.uj;
            if (view instanceof CircleLongPressView) {
                ((CircleLongPressView) view).uj();
            }
        }
    }

    @Override // com.byazt.nk.x
    public void c() {
        if (!TextUtils.equals(this.f2517a, "6")) {
            if (TextUtils.equals(this.f2517a, BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
                postDelayed(new Runnable() { // from class: com.byazt.nk.InteractViewContainer.3
                    @Override // java.lang.Runnable
                    public void run() {
                        InteractViewContainer.this.i();
                    }
                }, 400L);
                return;
            } else {
                i();
                return;
            }
        }
        RippleView rippleView = this.sp;
        if (rippleView != null) {
            rippleView.ve();
            postDelayed(new Runnable() { // from class: com.byazt.nk.InteractViewContainer.2
                @Override // java.lang.Runnable
                public void run() {
                    InteractViewContainer.this.i();
                }
            }, 300L);
        }
    }

    @Override // com.byazt.nk.x
    public void tt() {
        if (x()) {
            setOnClickListener((View.OnClickListener) this.tt.getDynamicClickListener());
            performClick();
            if (this.ve.ma()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.x != null) {
            setOnClickListener((View.OnClickListener) this.tt.getDynamicClickListener());
            performClick();
            if (this.ve.ma()) {
                return;
            }
            setVisibility(8);
        }
    }
}
