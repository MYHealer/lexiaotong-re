package com.byazt.ff;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.nr.m;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 2442})
public class FlowLayout extends ViewGroup {
    public List<List<View>> c;
    public List<Integer> tt;

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new ArrayList();
        this.tt = new ArrayList();
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int iMax = 0;
        int i3 = 0;
        int i4 = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i6 = i4 + measuredWidth;
            if (i6 - marginLayoutParams.rightMargin > (size - getPaddingLeft()) - getPaddingRight()) {
                iMax = Math.max(iMax, i4);
                i3 += iMax2;
                iMax2 = measuredHeight;
                i4 = measuredWidth;
            } else {
                iMax2 = Math.max(iMax2, measuredHeight);
                i4 = i6;
            }
            if (i5 == childCount - 1) {
                iMax = Math.max(i4, iMax);
                i3 += iMax2;
            }
        }
        m.uj("TAG", "sizeWidth = " + size + "|sizeHeight = " + size2);
        m.uj("TAG", "width = " + iMax + ", height = " + i3);
        if (mode != 1073741824) {
            size = getPaddingRight() + iMax + getPaddingLeft();
        }
        if (mode2 != 1073741824) {
            size2 = i3 + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m.uj("TAG", "onLayout");
        this.c.clear();
        this.tt.clear();
        int width = getWidth();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int iMax = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            i5++;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if ((measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin) * i5 > (width - getPaddingLeft()) - getPaddingRight()) {
                this.tt.add(Integer.valueOf(iMax));
                this.c.add(arrayList);
                iMax = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight;
                arrayList = new ArrayList();
                i5 = 1;
            }
            int i7 = marginLayoutParams.leftMargin;
            int i8 = marginLayoutParams.rightMargin;
            iMax = Math.max(iMax, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.tt.add(Integer.valueOf(iMax));
        this.c.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.c.size();
        for (int i9 = 0; i9 < size; i9++) {
            List<View> list = this.c.get(i9);
            int iIntValue = this.tt.get(i9).intValue();
            for (int i10 = 0; i10 < list.size(); i10++) {
                View view = list.get(i10);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i11 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i12 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i11, i12, view.getMeasuredWidth() + i11, view.getMeasuredHeight() + i12);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += iIntValue;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }
}
