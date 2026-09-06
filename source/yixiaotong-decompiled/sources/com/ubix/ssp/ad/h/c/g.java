package com.ubix.ssp.ad.h.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends b {
    int v;
    int w;
    WindowManager x;
    int y;

    public g(Context context, Bundle bundle) {
        super(context, bundle);
        this.y = 6012;
        this.y = bundle.getInt("TEMPLATE_ID");
        this.v = r.a().h(getContext());
        this.w = r.a().c(getContext()) - com.ubix.ssp.ad.e.a0.c.e(getContext());
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public boolean a(int i) {
        return super.a(i);
    }

    @Override // com.ubix.ssp.ad.h.c.b
    public int getRealTemplateId() {
        return 6012;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:43:0x01a1 A[PHI: r2 r4 r5 r6
  0x01a1: PHI (r2v35 float) = (r2v34 float), (r2v0 float) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r4v33 int) = (r4v32 int), (r4v36 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r5v26 int) = (r5v25 int), (r5v29 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x01a1: PHI (r6v16 int) = (r6v15 int), (r6v22 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x01a6 A[PHI: r4 r5 r6
  0x01a6: PHI (r4v35 int) = (r4v32 int), (r4v36 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x01a6: PHI (r5v28 int) = (r5v25 int), (r5v29 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]
  0x01a6: PHI (r6v18 int) = (r6v15 int), (r6v22 int) binds: [B:42:0x019f, B:35:0x017e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int right;
        int top;
        int right2;
        int top2;
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
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt = getChildAt(i6);
            float f = 20.0f;
            switch (childAt.getId()) {
                case 400001:
                    right = findViewById(400004).getRight() - ((Math.min(this.v, this.w) / 16) + (this.j * 3));
                    top = findViewById(400004).getTop() + (this.j * 3);
                    right2 = findViewById(400004).getRight() - (this.j * 3);
                    top2 = findViewById(400004).getTop() + (Math.min(this.v, this.w) / 16) + (this.j * 3);
                    childAt.layout(right, top, right2, top2);
                    break;
                case 400002:
                    right = findViewById(400004).getLeft() + (this.j * 3);
                    top = getAppInfoTop() - (i5 / 28);
                    right2 = findViewById(400004).getLeft() + (this.j * 3) + (i5 / 12);
                    top2 = getAppInfoTop();
                    childAt.layout(right, top, right2, top2);
                    break;
                case 400003:
                    View viewFindViewById = findViewById(400002);
                    childAt.layout(viewFindViewById.getRight() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() - childAt.getMeasuredHeight()) / 2), viewFindViewById.getRight() + childAt.getMeasuredWidth() + this.j, viewFindViewById.getTop() + ((viewFindViewById.getHeight() + childAt.getMeasuredHeight()) / 2));
                    break;
                case 400004:
                    int i7 = this.v;
                    int i8 = this.f8969a;
                    int i9 = this.w;
                    int i10 = this.b;
                    childAt.layout((i7 - i8) / 2, (i9 - i10) / 2, (i7 + i8) / 2, (i9 + i10) / 2);
                    break;
                case 400005:
                    childAt.layout(0, 0, this.v, this.w);
                    break;
                case 400007:
                    int i11 = this.v;
                    int iMin = (((this.f8969a + i11) / 2) - (Math.min(i11, this.w) / 16)) - (this.j * 3);
                    int appInfoTop = getAppInfoTop() - (Math.min(this.v, this.w) / 16);
                    int i12 = this.j;
                    childAt.layout(iMin, appInfoTop - i12, ((this.v + this.f8969a) / 2) - (i12 * 3), getAppInfoTop() - this.j);
                    break;
                case 400008:
                    childAt.setBackgroundColor(-16777216);
                    childAt.setVisibility(0);
                    int i13 = this.v;
                    int i14 = this.f8969a;
                    int i15 = this.w;
                    int i16 = this.b;
                    childAt.layout((i13 - i14) / 2, (i15 - i16) / 2, (i13 + i14) / 2, (i15 + i16) / 2);
                    break;
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
                    int i17 = (this.v - this.f8969a) / 2;
                    if (getRealTemplateId() == 6003) {
                        measuredWidth = ((this.f8969a - childAt.getMeasuredWidth()) / 2) + i17;
                        iA = measuredHeight - (z2 ? r.a(20.0f) : 0);
                        measuredWidth2 = i17 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(f);
                        } else {
                            iA2 = 0;
                        }
                    } else {
                        measuredWidth = i17 + ((this.f8969a - childAt.getMeasuredWidth()) / 2);
                        f = 40.0f;
                        iA = measuredHeight - (z2 ? r.a(40.0f) : 0);
                        measuredWidth2 = i17 + ((this.f8969a + childAt.getMeasuredWidth()) / 2);
                        if (z2) {
                            iA2 = r.a(f);
                        } else {
                            iA2 = 0;
                        }
                    }
                    childAt.layout(measuredWidth, iA, measuredWidth2, top3 - iA2);
                    break;
                case 910301:
                    try {
                        int i18 = (int) ((this.o * 25.0d) / 2.0d);
                        int i19 = this.f8969a;
                        int i20 = this.j;
                        int i21 = (int) (((double) (i19 - (i20 * 6))) * 0.212d);
                        childAt.layout((((this.v - i19) / 2) + (i20 * 3)) - i18, (((getAppInfoTop() - (i5 / 20)) - 50) - i21) - i18, (((this.v + this.f8969a) / 2) - (this.j * 3)) + i18, ((getAppInfoTop() - (i5 / 20)) - 50) + i18);
                        int i22 = i18 * 2;
                        ((com.ubix.ssp.ad.e.c) childAt).a((this.f8969a - (this.j * 6)) + i22, i21 + i22);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 920101:
                    childAt.layout(findViewById(400004).getLeft() + (this.j * 3), (findViewById(400004).getBottom() - childAt.getMeasuredHeight()) - (this.j * 3), findViewById(400004).getRight() - (this.j * 3), findViewById(400004).getBottom() - (this.j * 3));
                    childAt.getLayoutParams().width = this.f8969a - (this.j * 6);
                    break;
                case 920301:
                    childAt.layout(findViewById(400004).getLeft() + (this.j * 3), findViewById(400004).getTop() + (this.j * 3), findViewById(400004).getLeft() + r.b(20.0f) + (this.j * 3), findViewById(400004).getTop() + r.b(12.0f) + (this.j * 3));
                    break;
            }
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
        View viewFindViewById = findViewById(400008);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        layoutParams.width = this.f8969a;
        layoutParams.height = this.b;
        viewFindViewById.setLayoutParams(layoutParams);
    }
}
