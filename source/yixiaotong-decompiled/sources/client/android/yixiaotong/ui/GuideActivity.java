package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.v3.ui.V3MainActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.ui.V4MainActivity;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class GuideActivity extends BaseActivity {
    private static final String EXTRA_NEED_TO_LOGIN = "extra_need_to_login";
    private int[] imageIdArray;
    private ImageView[] ivDots;
    private List<View> listView = new ArrayList();
    Button mBtnStart;
    private GuidePagerAdater mGuidePagerAdater;
    ViewGroup mLinDot;
    ViewPager mViewPager;
    private boolean needToLogin;

    static {
        StubApp.interface11(5949);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mViewPager = (ViewPager) findViewById(R.id.vp_guide);
        this.mBtnStart = (Button) findViewById(R.id.start_btn);
        this.mLinDot = (ViewGroup) findViewById(R.id.ll_container);
    }

    public static void launch(Activity activity, boolean z) {
        Intent intent = new Intent(activity, (Class<?>) GuideActivity.class);
        intent.putExtra(EXTRA_NEED_TO_LOGIN, z);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LogUtil.e("GuideActivity", "onResume");
    }

    private void initView() {
        this.ivDots = new ImageView[this.imageIdArray.length];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(15, 15);
        for (int i = 0; i < this.imageIdArray.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            if (i == 0) {
                imageView.setImageResource(R.drawable.dot_selected);
            } else {
                layoutParams.leftMargin = 20;
                imageView.setImageResource(R.drawable.dot_normal);
            }
            this.ivDots[i] = imageView;
            this.mLinDot.addView(imageView);
        }
        this.mBtnStart.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.GuideActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GuideActivity.this.runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.GuideActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GuideActivity.this.needToLogin) {
                            LoginActivity.launch(GuideActivity.this.getActivity());
                            return;
                        }
                        if (LocalDataUtil.getPlatformInfo(GuideActivity.this.getContext()) == 4) {
                            V4MainActivity.launch(GuideActivity.this.getActivity());
                        } else if (LocalDataUtil.getPlatformInfo(GuideActivity.this.getContext()) == 1) {
                            V3MainActivity.launch(GuideActivity.this.getActivity());
                        } else {
                            MainActivity.launch(GuideActivity.this.getActivity());
                        }
                    }
                }, 100L);
            }
        });
    }

    private void initViewPager() {
        this.imageIdArray = new int[]{R.mipmap.l_yindao1, R.mipmap.l_yindao2, R.mipmap.l_yindao3};
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        int length = this.imageIdArray.length;
        for (int i = 0; i < length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            imageView.setBackgroundResource(this.imageIdArray[i]);
            this.listView.add(imageView);
        }
        GuidePagerAdater guidePagerAdater = new GuidePagerAdater();
        this.mGuidePagerAdater = guidePagerAdater;
        this.mViewPager.setAdapter(guidePagerAdater);
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.ui.GuideActivity.2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                int length2 = GuideActivity.this.imageIdArray.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    if (i3 == i2) {
                        GuideActivity.this.ivDots[i3].setImageResource(R.drawable.dot_selected);
                    } else {
                        GuideActivity.this.ivDots[i3].setImageResource(R.drawable.dot_normal);
                    }
                }
                if (length2 - 1 == i2) {
                    GuideActivity.this.mBtnStart.setVisibility(0);
                } else {
                    GuideActivity.this.mBtnStart.setVisibility(4);
                }
            }
        });
    }

    class GuidePagerAdater extends PagerAdapter {
        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        GuidePagerAdater() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (GuideActivity.this.listView != null) {
                return GuideActivity.this.listView.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) GuideActivity.this.listView.get(i));
            return GuideActivity.this.listView.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) GuideActivity.this.listView.get(i));
        }
    }
}
