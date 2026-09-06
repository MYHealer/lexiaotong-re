package client.android.yixiaotong.v3.ui.discountcoupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CashRedPackageDetailActivity extends BaseActivity {
    private static final String TAG = "CashRedPackageDetailActivity";
    private CouponBean mCouponBean;
    private int mIndex;
    private LinearLayout mLinHbbg;
    private int mState = 0;
    private TitleBar mTitleBar;
    private TextView mTvMoney;
    private TextView mTvName;
    private TextView mTvRenMinBi;
    private TextView mTvTime;
    private TextView mTvTotalMoney;
    private TextView mTvUseDevice;
    private TextView mTvUseServer;
    private TextView mTvUseTime;
    private TextView mTvUseTime2;

    static {
        StubApp.interface11(9900);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, CouponBean couponBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) CashRedPackageDetailActivity.class).putExtra("bean", couponBean).putExtra("state", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLinHbbg = (LinearLayout) findViewById(R.id.lin_hbbg);
        this.mTvRenMinBi = (TextView) findViewById(R.id.tv_renmimbi);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvName = (TextView) findViewById(R.id.tv_servername);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
        this.mTvUseTime = (TextView) findViewById(R.id.tv_usetime);
        this.mTvUseDevice = (TextView) findViewById(R.id.tv_usedevice);
        this.mTvUseServer = (TextView) findViewById(R.id.tv_useserver);
        this.mTvUseTime2 = (TextView) findViewById(R.id.tv_usetime2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("红包详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        int i = this.mState;
        if (i == 0) {
            this.mLinHbbg.setBackgroundResource(R.mipmap.hb);
        } else if (i == 1) {
            this.mLinHbbg.setBackgroundResource(R.mipmap.hb_refundind);
        }
        this.mTvMoney.setText(DecimalUtil.divide(this.mCouponBean.balance + "", "100"));
        this.mTvTotalMoney.setText(DecimalUtil.divide(this.mCouponBean.money + "", "100") + "元");
        this.mTvName.setText(this.mCouponBean.couponName);
        this.mTvTime.setText(this.mCouponBean.startDate + "至" + this.mCouponBean.endDate);
        this.mTvUseTime.setText(this.mCouponBean.startDate + "至" + this.mCouponBean.endDate);
        if (this.mCouponBean.typeId != null && this.mCouponBean.typeId.size() > 0) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            this.mIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
            List<PlanInfoBean> list = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(this.mIndex).investorInfo.planInfo;
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    List<TypeInfoBean> list2 = list.get(i2).typeInfo;
                    if (list2 != null && list2.size() > 0) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            arrayList.add(list.get(i2).typeInfo.get(i3));
                        }
                    }
                }
            }
            for (int i4 = 0; i4 < this.mCouponBean.typeId.size(); i4++) {
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    LogUtil.e(TAG, i4 + "  " + i5 + "  " + this.mCouponBean.typeId.get(i4) + "  " + ((TypeInfoBean) arrayList.get(i5)).base.typeId + "  " + sb.toString().contains(((TypeInfoBean) arrayList.get(i5)).base.appName));
                    if (this.mCouponBean.typeId.get(i4).intValue() == ((TypeInfoBean) arrayList.get(i5)).base.typeId && !sb.toString().contains(((TypeInfoBean) arrayList.get(i5)).base.appName)) {
                        sb.append(((TypeInfoBean) arrayList.get(i5)).base.appName + "/");
                    }
                }
            }
            if (sb.length() > 1) {
                this.mTvUseDevice.setText(sb.toString().substring(0, sb.length() - 1));
            }
        }
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        if (investorInfosV3 != null && investorInfosV3.size() > 0) {
            for (int i6 = 0; i6 < investorInfosV3.size(); i6++) {
                if (investorInfosV3.get(i6).investorInfo.investorId.equals(this.mCouponBean.investorId)) {
                    this.mTvUseServer.setText(investorInfosV3.get(i6).investorInfo.providerJson.providerName);
                }
            }
        }
        this.mTvUseTime2.setText(this.mCouponBean.startTime + "至" + this.mCouponBean.endTime);
    }
}
