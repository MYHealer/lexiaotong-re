package client.android.yixiaotong.v3.ui.appcontrol.prepayment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentRedPackageDetailActivityActivity extends BaseActivity {
    private CouponBean mCouponBean;
    LinearLayout mLinHbbg;
    private int mState = 0;
    TitleBar mTitleBar;
    TextView mTvMoney;
    TextView mTvName;
    TextView mTvRenMinBi;
    TextView mTvTime;
    TextView mTvTotalMoney;
    TextView mTvUseServer;
    TextView mTvUseTime;

    static {
        StubApp.interface11(9422);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, CouponBean couponBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) PrepaymentRedPackageDetailActivityActivity.class).putExtra("bean", couponBean).putExtra("state", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLinHbbg = (LinearLayout) findViewById(R.id.lin_hbbg);
        this.mTvRenMinBi = (TextView) findViewById(R.id.tv_renmimbi);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvName = (TextView) findViewById(R.id.tv_servername);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvUseTime = (TextView) findViewById(R.id.tv_usetime);
        this.mTvTotalMoney = (TextView) findViewById(R.id.tv_totalmoney);
        this.mTvUseServer = (TextView) findViewById(R.id.tv_useserver);
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
            this.mLinHbbg.setBackgroundResource(R.mipmap.hbyy);
        } else {
            this.mLinHbbg.setBackgroundResource(R.mipmap.hbgq);
        }
        this.mTvMoney.setText(DecimalUtil.divide(this.mCouponBean.balance + "", "100"));
        this.mTvTotalMoney.setText(DecimalUtil.divide(this.mCouponBean.money + "", "100") + "元");
        this.mTvTime.setText(this.mCouponBean.startDate + " 至 " + this.mCouponBean.endDate);
        this.mTvUseTime.setText(this.mCouponBean.startDate + " 至 " + this.mCouponBean.endDate);
        if (this.mCouponBean.typeId != null && this.mCouponBean.typeId.size() > 0) {
            StringBuilder sb = new StringBuilder();
            List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
            for (int i2 = 0; i2 < this.mCouponBean.typeId.size(); i2++) {
                for (int i3 = 0; i3 < typeInfoBeans.size(); i3++) {
                    Log.e("test", i2 + "  " + i3 + "  " + this.mCouponBean.typeId.get(i2) + "  " + typeInfoBeans.get(i3).base.typeId + "  " + sb.toString().contains(typeInfoBeans.get(i3).base.appName));
                    if (this.mCouponBean.typeId.get(i2).intValue() == typeInfoBeans.get(i3).base.typeId && !sb.toString().contains(typeInfoBeans.get(i3).base.appName)) {
                        sb.append(typeInfoBeans.get(i3).base.appName + "/");
                    }
                }
            }
            sb.length();
        }
        InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        if (investorInfoBean == null || investorInfoBean.providerJson == null) {
            return;
        }
        this.mTvUseServer.setText(investorInfoBean.providerJson.providerName);
        this.mTvName.setText(investorInfoBean.providerJson.providerName);
    }
}
