package com.ubix.ssp.ad.h.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends b {
    int v;
    int w;
    WindowManager x;

    public a(Context context, Bundle bundle) {
        super(context, bundle);
        this.v = r.a().h(getContext());
        this.w = r.a().c(getContext()) - com.ubix.ssp.ad.e.a0.c.e(getContext());
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public boolean a(int i) {
        return super.a(i);
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public int getRealTemplateId() {
        return 6001;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x02c8 A[PHI: r8 r9 r10
  0x02c8: PHI (r8v28 int) = (r8v27 int), (r8v30 int) binds: [B:55:0x02c1, B:48:0x029d] A[DONT_GENERATE, DONT_INLINE]
  0x02c8: PHI (r9v32 int) = (r9v31 int), (r9v34 int) binds: [B:55:0x02c1, B:48:0x029d] A[DONT_GENERATE, DONT_INLINE]
  0x02c8: PHI (r10v25 int) = (r10v24 int), (r10v30 int) binds: [B:55:0x02c1, B:48:0x029d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        int top;
        int right2;
        int top2;
        int iMin;
        boolean z2;
        int measuredWidth;
        int iA;
        int measuredWidth2;
        int iA2;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.f8969a;
        if (getResources().getConfiguration().orientation == 2) {
            i5 = this.b;
        }
        int i6 = i5;
        for (int i7 = 0; i7 < getChildCount(); i7++) {
            View childAt = getChildAt(i7);
            int id = childAt.getId();
            switch (id) {
                case 400001:
                    right = findViewById(400004).getRight() - ((Math.min(this.v, this.w) / 16) + (this.j * 3));
                    top = findViewById(400004).getTop() + (this.j * 3);
                    right2 = findViewById(400004).getRight() - (this.j * 3);
                    top2 = findViewById(400004).getTop();
                    iMin = Math.min(this.v, this.w) / 16;
                    break;
                case 400002:
                    childAt.layout(findViewById(400004).getLeft() + (this.j * 3), getAppInfoTop() - (i6 / 28), findViewById(400004).getLeft() + (this.j * 3) + (i6 / 12), getAppInfoTop());
                    continue;
                    break;
                case 400003:
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + childAt.getMeasuredWidth() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    continue;
                    break;
                case 400004:
                    int i8 = this.v;
                    int i9 = this.f8969a;
                    int i10 = this.w;
                    int i11 = this.b;
                    childAt.layout((i8 - i9) / 2, (i10 - i11) / 2, (i8 + i9) / 2, (i10 + i11) / 2);
                    continue;
                    break;
                case 400005:
                    childAt.layout(0, 0, this.v, this.w);
                    continue;
                    break;
                default:
                    switch (id) {
                        case 910100:
                        case 910200:
                            int top3 = findViewById(400002) != null ? findViewById(400002).getTop() : i4;
                            if (findViewById(910301) != null) {
                                top3 = findViewById(910301).getTop();
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (findViewById(400004) != null) {
                                findViewById(400004).getBottom();
                            }
                            int measuredHeight = top3 - childAt.getMeasuredHeight();
                            int i12 = (this.v - this.f8969a) / 2;
                            if (getRealTemplateId() == 6003) {
                                measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i12;
                                iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                                measuredWidth2 = i12 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                                if (z2) {
                                    iA2 = r.a(20.0f);
                                } else {
                                    iA2 = 0;
                                }
                            } else {
                                measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i12;
                                iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                                measuredWidth2 = i12 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                                if (z2) {
                                    iA2 = r.a(40.0f);
                                } else {
                                    iA2 = 0;
                                }
                            }
                            childAt.layout(measuredWidth, iA, measuredWidth2, top3 - iA2);
                            continue;
                            break;
                        case 910301:
                            try {
                                int i13 = (int) ((this.o * 25.0d) / 2.0d);
                                int i14 = this.f8969a;
                                int i15 = this.j;
                                int i16 = (int) (((double) (i14 - (i15 * 6))) * 0.212d);
                                childAt.layout((((this.v - i14) / 2) + (i15 * 3)) - i13, (((getAppInfoTop() - (i6 / 20)) - 50) - i16) - i13, (((this.v + this.f8969a) / 2) - (this.j * 3)) + i13, ((getAppInfoTop() - (i6 / 20)) - 50) + i13);
                                int i17 = i13 * 2;
                                ((com.ubix.ssp.ad.e.c) childAt).a((this.f8969a - (this.j * 6)) + i17, i16 + i17);
                                continue;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            break;
                        case 910401:
                            View viewFindViewById2 = findViewById(920101);
                            int i18 = (int) ((this.o * 25.0d) / 2.0d);
                            int i19 = (int) (((double) (this.f8969a - (this.j * 6))) * 0.212d);
                            int height = viewFindViewById2 != null ? viewFindViewById2.getHeight() : 0;
                            int i20 = this.v;
                            int i21 = this.f8969a;
                            int i22 = (this.w + this.d) / 2;
                            double d = ((double) (height + (i6 / 20) + 50 + (i18 * 2) + i19)) * 1.6d;
                            childAt.layout((i20 - i21) / 2, (int) (((double) i22) - d), (i20 + i21) / 2, i22);
                            ((com.ubix.ssp.ad.e.e) childAt).a(this.f8969a, (int) d);
                            continue;
                            break;
                        case 920101:
                            childAt.layout(findViewById(400004).getLeft() + (this.j * 3), (findViewById(400004).getBottom() - childAt.getMeasuredHeight()) - (this.j * 3), findViewById(400004).getRight() - (this.j * 3), findViewById(400004).getBottom() - (this.j * 3));
                            childAt.getLayoutParams().width = this.f8969a - (this.j * 6);
                            continue;
                            break;
                        case 920301:
                            right = findViewById(400004).getLeft() + (this.j * 3);
                            top = findViewById(400004).getTop() + (this.j * 3);
                            right2 = findViewById(400004).getLeft() + r.b(20.0f) + (this.j * 3);
                            top2 = findViewById(400004).getTop();
                            iMin = r.b(12.0f);
                            break;
                        default:
                            continue;
                            break;
                    }
                    break;
            }
            childAt.layout(right, top, right2, top2 + iMin + (this.j * 3));
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int iG;
        super.onSizeChanged(i, i2, i3, i4);
        if (this.x == null) {
            this.x = (WindowManager) getContext().getSystemService("window");
        }
        int orientation = this.x.getDefaultDisplay().getOrientation();
        a(this.i);
        if (orientation == 1 || orientation == 3) {
            this.v = r.a().f(getContext());
            iG = r.a().g(getContext());
        } else {
            this.v = r.a().h(getContext());
            iG = r.a().c(getContext());
        }
        this.w = iG - com.ubix.ssp.ad.e.a0.c.e(getContext());
    }
}
