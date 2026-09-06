package client.android.yixiaotong.ui.pullrefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PullToScrollView extends ScrollView implements Pullable {
    @Override // client.android.yixiaotong.ui.pullrefresh.Pullable
    public boolean canPullDown() {
        return true;
    }

    @Override // client.android.yixiaotong.ui.pullrefresh.Pullable
    public boolean canPullUp() {
        return true;
    }

    public PullToScrollView(Context context) {
        super(context);
    }

    public PullToScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
