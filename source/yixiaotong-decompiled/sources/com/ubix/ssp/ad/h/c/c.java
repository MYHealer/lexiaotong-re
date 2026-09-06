package com.ubix.ssp.ad.h.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends b {
    int v;
    int w;
    int x;
    private WindowManager y;
    private boolean z;

    public c(Context context, Bundle bundle) {
        super(context, bundle);
        this.z = false;
        this.x = com.ubix.ssp.ad.e.a0.c.e(getContext());
        this.v = r.a().h(StubApp.getOrigApplicationContext(getContext().getApplicationContext()));
        this.w = r.a().c(StubApp.getOrigApplicationContext(getContext().getApplicationContext())) - this.x;
        this.r = bundle.getInt("RENDER_MODE", 0);
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public boolean a(int i) {
        return super.a(i);
    }

    @Override // com.ubix.ssp.ad.h.c.b
    protected int getAppInfoTop() {
        int top;
        int i;
        View viewFindViewById = findViewById(920101);
        if (viewFindViewById == null || viewFindViewById.getVisibility() == 8) {
            top = this.w;
            i = this.j * 3;
        } else {
            top = viewFindViewById.getTop();
            i = this.j * 2;
        }
        return top - i;
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public int getRealTemplateId() {
        return 6004;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int appInfoTop;
        int i5;
        int i6;
        int iB;
        com.ubix.ssp.ad.e.t.a.e eVar;
        ImageView.ScaleType scaleType;
        int i7;
        com.ubix.ssp.ad.e.c cVar;
        double d;
        int iA;
        int measuredWidth;
        int measuredWidth2;
        int iA2;
        double d2;
        double d3;
        double d4;
        int i8;
        com.ubix.ssp.ad.e.e eVar2;
        double d5;
        double d6;
        super.onLayout(z, i, i2, i3, i4);
        int i9 = this.f8969a;
        if (getResources().getConfiguration().orientation == 2) {
            i9 = this.b;
        }
        int i10 = i9;
        int i11 = 0;
        int i12 = 0;
        while (i12 < getChildCount()) {
            View childAt = getChildAt(i12);
            int id = childAt.getId();
            boolean z2 = true;
            switch (id) {
                case 400001:
                    int i13 = this.t;
                    if (i13 != 1) {
                        if (i13 == 2) {
                            int iB2 = this.v - r.b(24.0f);
                            int i14 = this.j * 3;
                            childAt.layout(iB2 - i14, i14, this.v - i14, r.b(24.0f) + (this.j * 3));
                        } else if (i13 == 3 || i13 == 4) {
                            int iB3 = this.v - r.b(40.0f);
                            appInfoTop = this.j * 3;
                            i5 = iB3 - appInfoTop;
                            i6 = this.v - appInfoTop;
                            iB = r.b(16.0f) + (this.j * 3);
                            childAt.layout(i5, appInfoTop, i6, iB);
                        } else {
                            int i15 = this.v;
                            int i16 = i3 - i;
                            int i17 = i4 - i2;
                            int iMin = Math.min(i16, i17 - this.x) / 16;
                            int i18 = this.j * 3;
                            childAt.layout(i15 - (iMin + i18), i18, this.v - i18, (Math.min(i16, i17 - this.x) / 16) + (this.j * 3));
                        }
                    }
                    i7 = i12;
                    break;
                case 400002:
                    i5 = this.j * 3;
                    appInfoTop = getAppInfoTop() - (i10 / 28);
                    i6 = (this.j * 3) + (i10 / 12);
                    iB = getAppInfoTop();
                    childAt.layout(i5, appInfoTop, i6, iB);
                    i7 = i12;
                    break;
                case 400003:
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + childAt.getMeasuredWidth() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    i7 = i12;
                    break;
                case 400004:
                    int i19 = this.r;
                    if (i19 == 1) {
                        childAt.layout(i11, i11, i3, i4 - this.x);
                        eVar = (com.ubix.ssp.ad.e.t.a.e) childAt;
                        scaleType = ImageView.ScaleType.FIT_CENTER;
                    } else {
                        childAt.layout(i11, i11, i3, i4);
                        eVar = (com.ubix.ssp.ad.e.t.a.e) childAt;
                        scaleType = i19 == 2 ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_XY;
                    }
                    eVar.setScaleType(scaleType);
                    i7 = i12;
                    break;
                case 400005:
                    childAt.layout(i11, i11, i3 - i, (i4 - i2) - this.x);
                    i7 = i12;
                    break;
                default:
                    switch (id) {
                        case 910100:
                        case 910200:
                            i7 = i12;
                            int top = findViewById(400002) != null ? findViewById(400002).getTop() : i4;
                            if (findViewById(910301) != null) {
                                top = findViewById(910301).getTop();
                            } else {
                                z2 = false;
                            }
                            findViewById(400004);
                            int measuredHeight = top - childAt.getMeasuredHeight();
                            int i20 = (this.v - this.f8969a) / 2;
                            if (getRealTemplateId() == 6003) {
                                measuredWidth2 = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i20;
                                iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                                measuredWidth = i20 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                                iA2 = z2 ? r.a(20.0f) : 0;
                            } else {
                                int measuredWidth3 = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i20;
                                iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                                measuredWidth = i20 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                                if (z2) {
                                    iA2 = r.a(40.0f);
                                    measuredWidth2 = measuredWidth3;
                                } else {
                                    measuredWidth2 = measuredWidth3;
                                }
                            }
                            childAt.layout(measuredWidth2, iA, measuredWidth, top - iA2);
                            continue;
                        case 910301:
                            try {
                                int iMin2 = Math.min((int) (((double) this.v) * 0.8d * 0.212d), (int) (((double) r.a().c(getContext())) * 0.15d));
                                int i21 = (int) ((this.o * 25.0d) / 2.0d);
                                if (this.z) {
                                    i7 = i12;
                                    try {
                                        childAt.layout(((int) (((double) this.v) * 0.3d)) - i21, ((getAppInfoTop() - (i10 / 20)) - iMin2) - i21, ((int) (((double) this.v) * 0.7d)) + i21, (getAppInfoTop() - (i10 / 20)) + i21);
                                        cVar = (com.ubix.ssp.ad.e.c) childAt;
                                        d = ((double) this.v) * 0.4d;
                                    } catch (Exception e) {
                                        e = e;
                                        e.printStackTrace();
                                    }
                                    break;
                                } else {
                                    i7 = i12;
                                    childAt.layout(((int) (((double) this.v) * 0.1d)) - i21, ((getAppInfoTop() - (i10 / 20)) - iMin2) - i21, ((int) (((double) this.v) * 0.9d)) + i21, (getAppInfoTop() - (i10 / 20)) + i21);
                                    cVar = (com.ubix.ssp.ad.e.c) childAt;
                                    d = ((double) this.v) * 0.8d;
                                }
                                int i22 = i21 * 2;
                                cVar.a(((int) d) + i22, iMin2 + i22);
                                continue;
                            } catch (Exception e2) {
                                e = e2;
                                i7 = i12;
                            }
                            break;
                        case 910401:
                            View viewFindViewById2 = findViewById(920101);
                            int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : i11;
                            if (com.ubix.ssp.ad.e.a0.c.h(getContext())) {
                                if (this.z) {
                                    d5 = height;
                                    d6 = ((double) i4) * 0.5d;
                                } else {
                                    d5 = height;
                                    d6 = ((double) i4) * 0.4d;
                                }
                                childAt.layout(i11, i4 - ((int) (d5 + d6)), i3, i4);
                                eVar2 = (com.ubix.ssp.ad.e.e) childAt;
                                i8 = (int) d6;
                            } else {
                                if (this.z) {
                                    d2 = height;
                                    d3 = i4;
                                    d4 = 0.65d;
                                } else {
                                    d2 = height;
                                    d3 = i4;
                                    d4 = 0.45d;
                                }
                                i8 = (int) (d2 + (d3 * d4));
                                childAt.layout(i11, i4 - i8, i3, i4);
                                eVar2 = (com.ubix.ssp.ad.e.e) childAt;
                            }
                            eVar2.a(i3, i8);
                            break;
                        case 920101:
                            int i23 = this.j * 3;
                            int i24 = i4 - i2;
                            int measuredHeight2 = (i24 - this.x) - childAt.getMeasuredHeight();
                            int i25 = this.j * 3;
                            childAt.layout(i23, measuredHeight2 - i25, this.v - i25, (i24 - this.x) - i25);
                            childAt.getLayoutParams().width = this.v - (this.j * 6);
                            break;
                        case 920301:
                            int i26 = this.j * 3;
                            childAt.layout(i26, i26, r.b(20.0f) + (this.j * 3), r.b(12.0f) + (this.j * 3));
                            break;
                    }
                    i7 = i12;
                    break;
            }
            i12 = i7 + 1;
            i11 = 0;
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.y == null) {
            this.y = (WindowManager) getContext().getSystemService("window");
        }
        int orientation = this.y.getDefaultDisplay().getOrientation();
        a(this.i);
        if (orientation == 1 || orientation == 3) {
            this.z = true;
        } else {
            this.z = false;
        }
        this.v = getWidth();
        this.w = getHeight() - com.ubix.ssp.ad.e.a0.c.e(getContext());
    }
}
