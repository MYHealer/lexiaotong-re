package crossoverone.statuslib;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AndroidBug5497Workaround {
    private int addedStatusHeight;
    private FrameLayout.LayoutParams frameLayoutParams;
    private int height;
    private boolean isFirst;
    private Activity mActivity;
    private View mChildOfContent;
    private int usableHeightPrevious;

    public static void assistActivity(Activity activity) {
        new AndroidBug5497Workaround(activity);
    }

    private AndroidBug5497Workaround(Activity activity) {
        this.mActivity = activity;
        View childAt = ((FrameLayout) activity.findViewById(android.R.id.content)).getChildAt(0);
        this.mChildOfContent = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: crossoverone.statuslib.AndroidBug5497Workaround.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent();
            }
        });
        this.frameLayoutParams = (FrameLayout.LayoutParams) this.mChildOfContent.getLayoutParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void possiblyResizeChildOfContent() {
        int iComputeUsableHeight = computeUsableHeight();
        if (!this.isFirst || iComputeUsableHeight == this.height + StatusUtil.getNavigationBarHeight(this.mActivity) || iComputeUsableHeight == this.height - StatusUtil.getNavigationBarHeight(this.mActivity)) {
            this.isFirst = true;
            this.height = computeUsableHeight();
        }
        if (iComputeUsableHeight != this.usableHeightPrevious || getStatusHeightChange()) {
            int i = this.height;
            int i2 = i - iComputeUsableHeight;
            if (i2 > i / 4) {
                this.frameLayoutParams.height = (i - i2) + this.addedStatusHeight;
            } else {
                this.frameLayoutParams.height = i + this.addedStatusHeight;
            }
            if (this.frameLayoutParams.height > this.mChildOfContent.getRootView().getHeight()) {
                this.frameLayoutParams.height = this.mChildOfContent.getRootView().getHeight();
            }
            this.mChildOfContent.requestLayout();
            this.usableHeightPrevious = iComputeUsableHeight;
        }
    }

    private int computeUsableHeight() {
        Rect rect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    private boolean getStatusHeightChange() {
        int systemUiVisibility = this.mActivity.getWindow().getDecorView().getSystemUiVisibility();
        if (this.addedStatusHeight == StatusUtil.getStatusBarHeight(this.mActivity) && (systemUiVisibility & 1024) == 0) {
            this.addedStatusHeight = 0;
            return true;
        }
        if (this.addedStatusHeight != 0 || (systemUiVisibility & 1024) <= 0) {
            return false;
        }
        this.addedStatusHeight = StatusUtil.getStatusBarHeight(this.mActivity);
        return true;
    }
}
