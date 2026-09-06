package client.android.yixiaotong.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PullToRefreshLinLayout extends LinearLayout implements Pullable {
    @Override // client.android.yixiaotong.ui.pullrefresh.Pullable
    public boolean canPullDown() {
        return true;
    }

    @Override // client.android.yixiaotong.ui.pullrefresh.Pullable
    public boolean canPullUp() {
        return true;
    }

    public PullToRefreshLinLayout(Context context) {
        super(context);
    }

    public PullToRefreshLinLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshLinLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
