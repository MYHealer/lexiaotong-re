package client.android.yixiaotong.v3.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.BuyClubCardBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.BuyClubCardRecordActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BuyCardActivity extends BaseActivity {
    private ImageView[] ivDots;
    private GuidePagerAdater mGuidePagerAdater;
    private ViewGroup mLinDot;
    private TitleBar mTitleBar;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private ViewPager mViewPager;
    private boolean mIsEnable = true;
    private List<BuyClubCardBean> mClubCardBeans = new ArrayList();
    private int mSelectIndex = 0;
    private List<View> listView = new ArrayList();

    static {
        StubApp.interface11(9621);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, TypeInfoBaseInfoBean typeInfoBaseInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BuyCardActivity.class).putExtra("bean", typeInfoBaseInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mViewPager = (ViewPager) findViewById(R.id.vp_card);
        this.mLinDot = (ViewGroup) findViewById(R.id.ll_container);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("购买会员折扣卡");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        this.ivDots = new ImageView[this.mClubCardBeans.size()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(40, 20);
        for (int i = 0; i < this.mClubCardBeans.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(layoutParams);
            if (i == 0) {
                imageView.setImageResource(R.drawable.shape_6f32fd_line_background);
            } else {
                layoutParams.leftMargin = 20;
                imageView.setImageResource(R.drawable.shape_99ffffff_line_background);
            }
            this.ivDots[i] = imageView;
            this.mLinDot.addView(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initViewPager() {
        int size = this.mClubCardBeans.size();
        for (int i = 0; i < size; i++) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_item_buyclubcard, (ViewGroup) null);
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.rel_bg);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_noactivate);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_name);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_servername);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_money);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_day);
            textView2.setText(this.mClubCardBeans.get(i).cardName);
            textView3.setText(InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.providerJson.providerName);
            String strConcat = "";
            textView4.setText(DecimalUtil.divide(this.mClubCardBeans.get(i).howmuchMoney + "", "100"));
            if (this.mClubCardBeans.get(i).cardGroup == 1) {
                relativeLayout.setBackgroundResource(R.mipmap.bg2);
                strConcat = "周卡";
            } else if (this.mClubCardBeans.get(i).cardGroup == 2) {
                relativeLayout.setBackgroundResource(R.mipmap.bg3);
                strConcat = "月卡";
            } else if (this.mClubCardBeans.get(i).cardGroup == 3) {
                relativeLayout.setBackgroundResource(R.mipmap.bg4);
                strConcat = "季卡";
            } else if (this.mClubCardBeans.get(i).cardGroup == 4) {
                relativeLayout.setBackgroundResource(R.mipmap.bg5);
                strConcat = "年卡";
            }
            if (this.mClubCardBeans.get(i).statusFlag == 2) {
                textView.setVisibility(0);
                relativeLayout.setBackgroundResource(R.mipmap.bg6);
            }
            if (this.mClubCardBeans.get(i).discountValue != 100) {
                if (this.mClubCardBeans.get(i).discountValue == 0) {
                    relativeLayout.setBackgroundResource(R.mipmap.bg1);
                    strConcat = "免费 ".concat(strConcat);
                } else {
                    strConcat = (this.mClubCardBeans.get(i).discountValue / 10.0f) + "折 " + strConcat;
                }
            }
            textView5.setText(strConcat);
            this.listView.add(viewInflate);
        }
        GuidePagerAdater guidePagerAdater = new GuidePagerAdater();
        this.mGuidePagerAdater = guidePagerAdater;
        this.mViewPager.setAdapter(guidePagerAdater);
        this.mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardActivity.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i3) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                int size2 = BuyCardActivity.this.mClubCardBeans.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    if (i3 == i2) {
                        BuyCardActivity.this.ivDots[i3].setImageResource(R.drawable.shape_6f32fd_line_background);
                    } else {
                        BuyCardActivity.this.ivDots[i3].setImageResource(R.drawable.shape_99ffffff_line_background);
                    }
                }
                BuyCardActivity.this.mSelectIndex = i2;
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_buycard).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BuyCardActivity.this.mClubCardBeans == null || BuyCardActivity.this.mClubCardBeans.size() <= 0) {
                    ToastUtils.show(BuyCardActivity.this.getContext(), "暂时没有可购买的会员卡");
                } else {
                    BuyCardDetailActivity.launch(BuyCardActivity.this.getActivity(), (BuyClubCardBean) BuyCardActivity.this.mClubCardBeans.get(BuyCardActivity.this.mSelectIndex), BuyCardActivity.this.mTypeInfoBaseInfoBean);
                    BuyCardActivity.this.finish();
                }
            }
        });
        findViewById(R.id.iv_buycardrecord).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BuyClubCardRecordActivity.launch(BuyCardActivity.this.getActivity());
                BuyCardActivity.this.finish();
            }
        });
    }

    private void getClubCard() {
        V3BusinessControllers.getInstance().getClubCardListByInvestorid(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.investorId, new Listener<List<BuyClubCardBean>>() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(BuyCardActivity.this.getActivity(), "获取数据.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BuyClubCardBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (BuyCardActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0) {
                        ToastUtils.show(BuyCardActivity.this.getContext(), "暂时没有可购买的会员卡");
                        return;
                    }
                    BuyCardActivity.this.mClubCardBeans = list;
                    BuyCardActivity.this.initViewPager();
                    BuyCardActivity.this.initView();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (BuyCardActivity.this.mIsEnable) {
                    BuyCardActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.card.BuyCardActivity.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BuyCardActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
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
            if (BuyCardActivity.this.listView != null) {
                return BuyCardActivity.this.listView.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) BuyCardActivity.this.listView.get(i));
            return BuyCardActivity.this.listView.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) BuyCardActivity.this.listView.get(i));
        }
    }
}
