package com.ubix.ssp.ad.h.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends b {
    int v;
    int w;
    private WindowManager x;
    private boolean y;

    public d(Context context, Bundle bundle) {
        super(context, bundle);
        this.y = false;
        this.v = r.a().h(getContext());
        this.w = r.a().c(getContext()) - com.ubix.ssp.ad.e.a0.c.e(getContext());
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
        return 6014;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.ubix.ssp.ad.e.c cVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int iB;
        int appInfoTop;
        int i9;
        int i10;
        int iB2;
        int iA;
        int measuredWidth;
        int measuredWidth2;
        int iA2;
        super.onLayout(z, i, i2, i3, i4);
        int i11 = this.f8969a;
        if (getResources().getConfiguration().orientation == 2) {
            i11 = this.b;
        }
        int i12 = i11;
        for (int i13 = 0; i13 < getChildCount(); i13++) {
            View childAt = getChildAt(i13);
            boolean z2 = true;
            switch (childAt.getId()) {
                case 400001:
                    int i14 = this.t;
                    if (i14 != 1) {
                        if (i14 == 2) {
                            int iB3 = this.v - r.b(24.0f);
                            i6 = this.j * 3;
                            i7 = iB3 - i6;
                            i8 = this.v - i6;
                            iB = r.b(24.0f);
                        } else if (i14 == 3 || i14 == 4) {
                            int iB4 = this.v - r.b(40.0f);
                            appInfoTop = this.j * 3;
                            i9 = iB4 - appInfoTop;
                            i10 = this.v - appInfoTop;
                            iB2 = r.b(16.0f) + (this.j * 3);
                        } else {
                            int i15 = this.v;
                            int iMin = Math.min(i15, this.w) / 16;
                            i6 = this.j * 3;
                            i7 = i15 - (iMin + i6);
                            int i16 = this.v;
                            i8 = i16 - i6;
                            iB = Math.min(i16, this.w) / 16;
                        }
                        childAt.layout(i7, i6, i8, iB + (this.j * 3));
                        break;
                    }
                    break;
                case 400002:
                    i9 = this.j * 3;
                    appInfoTop = getAppInfoTop() - (i12 / 28);
                    i10 = (this.j * 3) + (i12 / 12);
                    iB2 = getAppInfoTop();
                    break;
                case 400003:
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + childAt.getMeasuredWidth() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    continue;
                    break;
                case 400004:
                    int i17 = i3 - i;
                    int i18 = this.f8969a;
                    int i19 = i4 - i2;
                    int i20 = this.b;
                    childAt.layout((i17 - i18) / 2, (i19 - i20) / 2, (i17 + i18) / 2, (i19 + i20) / 2);
                    continue;
                    break;
                case 400005:
                    childAt.layout(0, 0, this.v, this.w);
                    continue;
                    break;
                case 400007:
                    int i21 = this.v;
                    int iMin2 = (i21 - (Math.min(i21, this.w) / 16)) - (this.j * 3);
                    int appInfoTop2 = getAppInfoTop() - (Math.min(this.v, this.w) / 16);
                    int i22 = this.j;
                    childAt.layout(iMin2, appInfoTop2 - i22, this.v - (i22 * 3), getAppInfoTop() - this.j);
                    continue;
                    break;
                case 400008:
                    childAt.setVisibility(0);
                    childAt.layout(0, 0, i3, i4);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    layoutParams.width = i3 - i;
                    layoutParams.height = i4 - i2;
                    continue;
                    break;
                case 910100:
                case 910200:
                    int top = findViewById(400002) != null ? findViewById(400002).getTop() : i4;
                    if (findViewById(910301) != null) {
                        top = findViewById(910301).getTop();
                    } else {
                        z2 = false;
                    }
                    findViewById(400004);
                    int measuredHeight = top - childAt.getMeasuredHeight();
                    int i23 = (this.v - this.f8969a) / 2;
                    if (getRealTemplateId() == 6003) {
                        measuredWidth2 = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i23;
                        iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                        measuredWidth = i23 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        iA2 = z2 ? r.a(20.0f) : 0;
                    } else {
                        int measuredWidth3 = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i23;
                        iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                        measuredWidth = i23 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(40.0f);
                            measuredWidth2 = measuredWidth3;
                        } else {
                            measuredWidth2 = measuredWidth3;
                        }
                    }
                    childAt.layout(measuredWidth2, iA, measuredWidth, top - iA2);
                    continue;
                    break;
                case 910301:
                    try {
                        int iMin3 = Math.min((int) (((double) this.v) * 0.8d * 0.212d), (int) (((double) r.a().c(getContext())) * 0.15d));
                        int i24 = (int) ((this.o * 25.0d) / 2.0d);
                        if (this.y) {
                            childAt.layout(((int) (((double) this.v) * 0.3d)) - i24, (((getAppInfoTop() - (i12 / 20)) - 50) - iMin3) - i24, ((int) (((double) this.v) * 0.7d)) + i24, ((getAppInfoTop() - (i12 / 20)) - 50) + i24);
                            cVar = (com.ubix.ssp.ad.e.c) childAt;
                            i5 = (int) (((double) this.v) * 0.4d);
                        } else {
                            childAt.layout(((int) (((double) this.v) * 0.1d)) - i24, (((getAppInfoTop() - (i12 / 20)) - 50) - iMin3) - i24, ((int) (((double) this.v) * 0.9d)) + i24, ((getAppInfoTop() - (i12 / 20)) - 50) + i24);
                            cVar = (com.ubix.ssp.ad.e.c) childAt;
                            i5 = (int) (((double) this.v) * 0.8d);
                        }
                        int i25 = i24 * 2;
                        cVar.a(i5 + i25, iMin3 + i25);
                        continue;
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    break;
                case 920101:
                    int i26 = this.j * 3;
                    int measuredHeight2 = this.w - childAt.getMeasuredHeight();
                    int i27 = this.j * 3;
                    childAt.layout(i26, measuredHeight2 - i27, this.v - i27, this.w - i27);
                    childAt.getLayoutParams().width = this.v - (this.j * 6);
                    continue;
                    break;
                case 920301:
                    int i28 = this.j * 3;
                    childAt.layout(i28, i28, r.b(20.0f) + (this.j * 3), r.b(12.0f) + (this.j * 3));
                    continue;
                    break;
                default:
                    continue;
                    break;
            }
            childAt.layout(i9, appInfoTop, i10, iB2);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.x == null) {
            this.x = (WindowManager) getContext().getSystemService("window");
        }
        int orientation = this.x.getDefaultDisplay().getOrientation();
        a(this.i);
        if (orientation == 1 || orientation == 3) {
            this.y = true;
        } else {
            this.y = false;
        }
        this.v = getWidth();
        this.w = getHeight() - com.ubix.ssp.ad.e.a0.c.e(getContext());
    }
}
