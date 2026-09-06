package client.android.yixiaotong.v4.ui.debug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.util.LogReceivedUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4LogViewerActivity extends Activity {
    private static final long POLL_INTERVAL_MS = 1000;
    private V4LogAdapter mAdapter;
    private TextView[] mFilterViews;
    private LinearLayoutManager mLayoutManager;
    private RecyclerView mRvLogs;
    private TextView mTvAutoScroll;
    private TextView mTvClear;
    private TextView mTvClose;
    private TextView mTvFilterAll;
    private TextView mTvFilterD;
    private TextView mTvFilterE;
    private TextView mTvFilterI;
    private TextView mTvFilterV;
    private TextView mTvFilterW;
    private TextView mTvLogCount;
    private TextView mTvPause;
    private V4LogEntry.Level mFilterLevel = null;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mAutoScroll = true;
    private boolean mPaused = false;
    private int mLastReadPos = 0;
    private int mNextEntryId = 1;
    private final List<V4LogEntry> mAllEntries = new ArrayList();
    private final Runnable mPollRunnable = new Runnable() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity.2
        @Override // java.lang.Runnable
        public void run() {
            if (V4LogViewerActivity.this.isFinishing() || V4LogViewerActivity.this.isDestroyed()) {
                return;
            }
            V4LogViewerActivity.this.pollNewLogs();
            V4LogViewerActivity.this.mHandler.postDelayed(this, 1000L);
        }
    };

    static {
        StubApp.interface11(10884);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Context context) {
        Intent intent = new Intent(context, (Class<?>) V4LogViewerActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private int getWindowHeightThreeFourths() {
        return (getResources().getDisplayMetrics().heightPixels * 3) / 4;
    }

    private void initViews() {
        this.mRvLogs = (RecyclerView) findViewById(R.id.rv_logs);
        this.mTvLogCount = (TextView) findViewById(R.id.tv_log_count);
        this.mTvAutoScroll = (TextView) findViewById(R.id.tv_auto_scroll);
        this.mTvPause = (TextView) findViewById(R.id.tv_pause);
        this.mTvClear = (TextView) findViewById(R.id.tv_clear);
        this.mTvClose = (TextView) findViewById(R.id.tv_close);
        this.mTvFilterAll = (TextView) findViewById(R.id.tv_filter_all);
        this.mTvFilterV = (TextView) findViewById(R.id.tv_filter_v);
        this.mTvFilterD = (TextView) findViewById(R.id.tv_filter_d);
        this.mTvFilterI = (TextView) findViewById(R.id.tv_filter_i);
        this.mTvFilterW = (TextView) findViewById(R.id.tv_filter_w);
        TextView textView = (TextView) findViewById(R.id.tv_filter_e);
        this.mTvFilterE = textView;
        this.mFilterViews = new TextView[]{this.mTvFilterAll, this.mTvFilterV, this.mTvFilterD, this.mTvFilterI, this.mTvFilterW, textView};
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager = linearLayoutManager;
        linearLayoutManager.setStackFromEnd(true);
        this.mRvLogs.setLayoutManager(this.mLayoutManager);
        V4LogAdapter v4LogAdapter = new V4LogAdapter();
        this.mAdapter = v4LogAdapter;
        this.mRvLogs.setAdapter(v4LogAdapter);
        this.mRvLogs.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (i2 < 0) {
                    V4LogViewerActivity.this.mAutoScroll = false;
                    V4LogViewerActivity.this.updateAutoScrollUI();
                } else {
                    if (i2 <= 0 || V4LogViewerActivity.this.mLayoutManager.findLastCompletelyVisibleItemPosition() < V4LogViewerActivity.this.mAdapter.getItemCount() - 1) {
                        return;
                    }
                    V4LogViewerActivity.this.mAutoScroll = true;
                    V4LogViewerActivity.this.updateAutoScrollUI();
                }
            }
        });
    }

    private void initListeners() {
        this.mTvClose.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m508xf62b0273(view);
            }
        });
        this.mTvAutoScroll.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m509x6e0cf34(view);
            }
        });
        this.mTvPause.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m510x17969bf5(view);
            }
        });
        this.mTvClear.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m511x284c68b6(view);
            }
        });
        final int i = 0;
        while (true) {
            TextView[] textViewArr = this.mFilterViews;
            if (i >= textViewArr.length) {
                return;
            }
            textViewArr[i].setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.m512x39023577(i, view);
                }
            });
            i++;
        }
    }

    /* JADX INFO: renamed from: lambda$initListeners$0$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m508xf62b0273(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initListeners$1$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m509x6e0cf34(View view) {
        this.mAutoScroll = !this.mAutoScroll;
        updateAutoScrollUI();
        if (this.mAutoScroll) {
            scrollToBottom();
        }
    }

    /* JADX INFO: renamed from: lambda$initListeners$2$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m510x17969bf5(View view) {
        boolean z = !this.mPaused;
        this.mPaused = z;
        this.mTvPause.setText(z ? "继续" : "暂停");
    }

    /* JADX INFO: renamed from: lambda$initListeners$3$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m511x284c68b6(View view) {
        this.mAllEntries.clear();
        this.mAdapter.clear();
        this.mNextEntryId = 1;
        this.mLastReadPos = 0;
        LogReceivedUtil.getInstance().clearData();
        updateLogCount();
    }

    /* JADX INFO: renamed from: lambda$initListeners$4$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m512x39023577(int i, View view) {
        selectFilter(i);
    }

    private void selectFilter(int i) {
        int i2 = 0;
        while (true) {
            TextView[] textViewArr = this.mFilterViews;
            if (i2 >= textViewArr.length) {
                break;
            }
            if (i2 == i) {
                textViewArr[i2].setBackgroundResource(R.drawable.bg_log_filter_selected);
                this.mFilterViews[i2].setTextColor(-1);
            } else {
                textViewArr[i2].setBackgroundResource(R.drawable.bg_log_filter_normal);
                String str = (String) this.mFilterViews[i2].getTag();
                if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equals(str)) {
                    this.mFilterViews[i2].setTextColor(-6969946);
                } else if ("D".equals(str)) {
                    this.mFilterViews[i2].setTextColor(-13330213);
                } else if ("I".equals(str)) {
                    this.mFilterViews[i2].setTextColor(-14176672);
                } else if ("W".equals(str)) {
                    this.mFilterViews[i2].setTextColor(-1671646);
                } else if (ExifInterface.LONGITUDE_EAST.equals(str)) {
                    this.mFilterViews[i2].setTextColor(-1618884);
                } else {
                    this.mFilterViews[i2].setTextColor(-13421773);
                }
            }
            i2++;
        }
        if (i == 1) {
            this.mFilterLevel = V4LogEntry.Level.V;
        } else if (i == 2) {
            this.mFilterLevel = V4LogEntry.Level.D;
        } else if (i == 3) {
            this.mFilterLevel = V4LogEntry.Level.I;
        } else if (i == 4) {
            this.mFilterLevel = V4LogEntry.Level.W;
        } else if (i != 5) {
            this.mFilterLevel = null;
        } else {
            this.mFilterLevel = V4LogEntry.Level.E;
        }
        applyFilter();
    }

    private void loadExistingLogs() {
        String allData = LogReceivedUtil.getInstance().getAllData();
        if (allData == null || allData.isEmpty() || "暂无日志".equals(allData)) {
            return;
        }
        this.mLastReadPos = allData.length();
        List<V4LogEntry> logLines = parseLogLines(allData);
        if (logLines.isEmpty()) {
            return;
        }
        this.mAllEntries.addAll(logLines);
        this.mNextEntryId = this.mAllEntries.size() + 1;
        applyFilter();
        scrollToBottom();
    }

    private void startPolling() {
        this.mHandler.postDelayed(this.mPollRunnable, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pollNewLogs() {
        String allData;
        int length;
        int i;
        if (this.mPaused || (allData = LogReceivedUtil.getInstance().getAllData()) == null || allData.isEmpty() || "暂无日志".equals(allData) || (length = allData.length()) <= (i = this.mLastReadPos)) {
            return;
        }
        String strSubstring = allData.substring(i);
        this.mLastReadPos = length;
        List<V4LogEntry> logLines = parseLogLines(strSubstring);
        if (logLines.isEmpty()) {
            return;
        }
        this.mAllEntries.addAll(logLines);
        if (this.mFilterLevel == null) {
            this.mAdapter.addEntries(logLines);
        } else {
            applyFilter();
        }
        updateLogCount();
        if (this.mAutoScroll) {
            scrollToBottom();
        }
    }

    private List<V4LogEntry> parseLogLines(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            for (String str2 : str.split("\\n")) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty()) {
                    arrayList.add(new V4LogEntry(this.mNextEntryId, System.currentTimeMillis(), V4LogEntry.parseLevel(strTrim), strTrim));
                    this.mNextEntryId++;
                }
            }
        }
        return arrayList;
    }

    private void applyFilter() {
        if (this.mFilterLevel == null) {
            this.mAdapter.setData(new ArrayList(this.mAllEntries));
        } else {
            ArrayList arrayList = new ArrayList();
            for (V4LogEntry v4LogEntry : this.mAllEntries) {
                if (v4LogEntry.level == this.mFilterLevel) {
                    arrayList.add(v4LogEntry);
                }
            }
            this.mAdapter.setData(arrayList);
        }
        updateLogCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAutoScrollUI() {
        this.mTvAutoScroll.setText(this.mAutoScroll ? "自动滚底: ON" : "自动滚底: OFF");
    }

    private void scrollToBottom() {
        if (this.mAdapter.getItemCount() > 0) {
            this.mRvLogs.post(new Runnable() { // from class: client.android.yixiaotong.v4.ui.debug.V4LogViewerActivity$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m513x773ed36();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$scrollToBottom$5$client-android-yixiaotong-v4-ui-debug-V4LogViewerActivity, reason: not valid java name */
    /* synthetic */ void m513x773ed36() {
        this.mRvLogs.smoothScrollToPosition(this.mAdapter.getItemCount() - 1);
    }

    private void updateLogCount() {
        this.mTvLogCount.setText((this.mFilterLevel == null ? this.mAllEntries.size() : this.mAdapter.getItemCount()) + "条");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacks(this.mPollRunnable);
    }
}
