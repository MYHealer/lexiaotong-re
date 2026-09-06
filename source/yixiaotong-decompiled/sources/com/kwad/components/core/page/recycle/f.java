package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.utils.az;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    final RecyclerView afs;
    final RecyclerView.LayoutManager aft;

    private f(RecyclerView recyclerView) {
        this.afs = recyclerView;
        this.aft = recyclerView.getLayoutManager();
    }

    public static f b(RecyclerView recyclerView) {
        az.checkNotNull(recyclerView);
        return new f(recyclerView);
    }

    public final int findFirstVisibleItemPosition() {
        View viewA = a(0, this.aft.getChildCount(), false, true);
        if (viewA == null) {
            return -1;
        }
        return this.afs.getChildAdapterPosition(viewA);
    }

    public final int findLastVisibleItemPosition() {
        View viewA = a(this.aft.getChildCount() - 1, -1, false, true);
        if (viewA == null) {
            return -1;
        }
        return this.afs.getChildAdapterPosition(viewA);
    }

    private View a(int i, int i2, boolean z, boolean z2) {
        OrientationHelper orientationHelperCreateHorizontalHelper;
        if (this.aft.canScrollVertically()) {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createVerticalHelper(this.aft);
        } else {
            orientationHelperCreateHorizontalHelper = OrientationHelper.createHorizontalHelper(this.aft);
        }
        int startAfterPadding = orientationHelperCreateHorizontalHelper.getStartAfterPadding();
        int endAfterPadding = orientationHelperCreateHorizontalHelper.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View childAt = this.aft.getChildAt(i);
            int decoratedStart = orientationHelperCreateHorizontalHelper.getDecoratedStart(childAt);
            int decoratedEnd = orientationHelperCreateHorizontalHelper.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }
}
