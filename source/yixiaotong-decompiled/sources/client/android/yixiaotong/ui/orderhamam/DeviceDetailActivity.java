package client.android.yixiaotong.ui.orderhamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceDetailActivity extends BaseActivity {
    ImageView mImgDown;
    RelativeLayout mRelAddress;
    TextView mTvAreaName;
    View mViewBackground;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private int mSelectIndex = 0;
    private List<String> mAreaData = new ArrayList();

    static {
        StubApp.interface11(7506);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceDetailActivity.class));
        }
    }

    private void initViewNew() {
        this.mImgDown = (ImageView) findViewById(R.id.img_down);
        this.mRelAddress = (RelativeLayout) findViewById(R.id.rel_address);
        this.mViewBackground = findViewById(R.id.view_background);
        this.mTvAreaName = (TextView) findViewById(R.id.tv_areaname);
    }

    private void initClickListeners() {
        findViewById(R.id.rel_address).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.orderhamam.DeviceDetailActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m166x580763b6(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-orderhamam-DeviceDetailActivity, reason: not valid java name */
    /* synthetic */ void m166x580763b6(View view) {
        initAnim(0.0f, 180.0f);
        this.mImgDown.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mRelAddress, this.mSelectIndex, this.mAreaData, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.ui.orderhamam.DeviceDetailActivity.1
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                DeviceDetailActivity.this.mTvAreaName.setText((CharSequence) DeviceDetailActivity.this.mAreaData.get(i));
                int unused = DeviceDetailActivity.this.mSelectIndex;
                DeviceDetailActivity.this.mSelectIndex = i;
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                DeviceDetailActivity.this.mViewBackground.setVisibility(8);
                DeviceDetailActivity.this.initAnim(180.0f, 360.0f);
                DeviceDetailActivity.this.mImgDown.startAnimation(DeviceDetailActivity.this.rotate);
            }
        });
    }

    private void backgroudAlpha() {
        this.mViewBackground.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }

    class DeviceAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public int getCount() {
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        DeviceAdapter() {
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = LayoutInflater.from(DeviceDetailActivity.this.getContext()).inflate(R.layout.orderhamam_item_layout, (ViewGroup) null);
            viewInflate.setTag(new ViewHolder(viewInflate));
            return viewInflate;
        }

        class ViewHolder {
            public ViewHolder(View view) {
            }
        }
    }
}
