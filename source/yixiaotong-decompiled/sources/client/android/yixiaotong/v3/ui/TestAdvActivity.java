package client.android.yixiaotong.v3.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.InsertUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TestAdvActivity extends BaseActivity {
    private static final String TAG = "TestAdvActivity";
    private AdvControlUtil.AdvListener mAdvListener;
    private InsertUtil mInsertUtil;
    private TextView mTvText;
    private View overlayView;
    private WindowManager windowManager;

    static {
        StubApp.interface11(8788);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) TestAdvActivity.class));
        }
    }

    private void initViewNew() {
        this.mTvText = (TextView) findViewById(R.id.tv_text);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.TestAdvActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AdvControlUtil.AdvListener {
        @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
        public void onAdClosed(Common.AdvType advType) {
        }

        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
        public void isOpen(int i, int i2, int i3, int i4, int i5) {
            if (i == 1) {
                TestAdvActivity.this.mInsertUtil.initInsert(TestAdvActivity.this.getActivity(), TestAdvActivity.this.mAdvListener, true, "", 1);
                TestAdvActivity.this.mInsertUtil.onInsert();
            }
        }

        @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
        public void onRenderSuccess(View view, int i) {
            LogUtil.e(TestAdvActivity.TAG, "onRenderSuccess:");
        }

        @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
        public void onAdShow(String str, Common.AdvType advType) {
            LogUtil.e(TestAdvActivity.TAG, "onAdShow:" + advType);
            if (advType == Common.AdvType.advinsert) {
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.TestAdvActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TestAdvActivity.this.showPopupWindow();
                    }
                }, 6000L);
            }
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        InsertUtil insertUtil = this.mInsertUtil;
        if (insertUtil != null) {
            insertUtil.onDestroy(getActivity());
        }
    }

    public void addOverlay() {
        this.windowManager = (WindowManager) getSystemService("window");
        this.overlayView = View.inflate(getActivity(), R.layout.overlay_layout, null);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
        layoutParams.gravity = BadgeDrawable.TOP_START;
        this.windowManager.addView(this.overlayView, layoutParams);
        View rootView = getWindow().getDecorView().getRootView();
        int width = rootView.getWidth();
        rootView.getHeight();
        double d = ((double) width) * 0.2d;
        Math.sqrt(d);
        Button button = (Button) this.overlayView.findViewById(R.id.close_button);
        ViewGroup.LayoutParams layoutParams2 = button.getLayoutParams();
        layoutParams2.width = (int) d;
        layoutParams2.height = (int) (d * 0.5d);
        button.setLayoutParams(layoutParams2);
        button.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.TestAdvActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TestAdvActivity.this.finish();
            }
        });
        LogUtil.e(TAG, "addOverlay:");
    }

    private void removeOverlay() {
        WindowManager windowManager;
        View view = this.overlayView;
        if (view == null || (windowManager = this.windowManager) == null) {
            return;
        }
        windowManager.removeView(view);
        this.overlayView = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow() {
        LogUtil.e(TAG, "showPopupWindow:");
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.overlay_layout, (ViewGroup) null);
        final PopupWindow popupWindow = new PopupWindow(viewInflate, -2, -2);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        ((Button) viewInflate.findViewById(R.id.close_button)).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.TestAdvActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                popupWindow.dismiss();
                TestAdvActivity.this.finish();
            }
        });
        if (popupWindow.isShowing()) {
            return;
        }
        popupWindow.showAsDropDown(this.mTvText);
    }
}
