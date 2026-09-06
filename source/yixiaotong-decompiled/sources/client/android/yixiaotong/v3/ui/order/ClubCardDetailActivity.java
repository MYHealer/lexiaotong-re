package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ClubCardDetailActivity extends BaseActivity {
    private BuyClubCardDetailBean mBuyClubCardDetailBean;
    private TitleBar mTitleBar;
    private TextView mTvBuyTime;
    private TextView mTvOrderId;
    private TextView mTvPayMoney;
    private TextView mTvPayTime;
    private TextView mTvPayWay;
    private TextView mTvProductDes;
    private TextView mTvProductType;
    private TextView mTvState;
    private TextView mTvUseServer;
    private TextView mTvUseType;

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsEnableEventInfo);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, BuyClubCardDetailBean buyClubCardDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ClubCardDetailActivity.class).putExtra("bean", buyClubCardDetailBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvBuyTime = (TextView) findViewById(R.id.tv_consumetime);
        this.mTvProductType = (TextView) findViewById(R.id.tv_consumemoney);
        this.mTvProductDes = (TextView) findViewById(R.id.tv_discountamount);
        this.mTvUseType = (TextView) findViewById(R.id.tv_usetype);
        this.mTvUseServer = (TextView) findViewById(R.id.tv_useserver);
        this.mTvPayMoney = (TextView) findViewById(R.id.paymoney);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("订单详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvOrderId.setText("订单号：" + this.mBuyClubCardDetailBean.orderId);
        if (this.mBuyClubCardDetailBean.payCode == 0) {
            this.mTvState.setText("未支付");
        } else {
            this.mTvState.setText("已支付");
        }
        this.mTvBuyTime.setText(this.mBuyClubCardDetailBean.payDateTime);
        if (this.mBuyClubCardDetailBean.cardGroup == 1) {
            this.mTvProductType.setText("周卡");
        } else if (this.mBuyClubCardDetailBean.cardGroup == 2) {
            this.mTvProductType.setText("月卡");
        } else if (this.mBuyClubCardDetailBean.cardGroup == 3) {
            this.mTvProductType.setText("季卡");
        } else if (this.mBuyClubCardDetailBean.cardGroup == 4) {
            this.mTvProductType.setText("年卡");
        }
        if (this.mBuyClubCardDetailBean.discountValue == 100) {
            this.mTvProductDes.setText("不免费");
        } else if (this.mBuyClubCardDetailBean.discountValue == 0) {
            this.mTvProductDes.setText("免费");
        } else {
            this.mTvProductDes.setText((this.mBuyClubCardDetailBean.discountValue / 10.0f) + "折");
        }
        getAppName();
        this.mTvUseServer.setText(this.mBuyClubCardDetailBean.providerName);
        this.mTvPayMoney.setText("¥" + DecimalUtil.divide(this.mBuyClubCardDetailBean.price + "", "100"));
        this.mTvPayTime.setText(this.mBuyClubCardDetailBean.payDateTime);
        if (this.mBuyClubCardDetailBean.payFlagType == 1) {
            this.mTvPayWay.setText("微信");
        } else if (this.mBuyClubCardDetailBean.payFlagType == 2) {
            this.mTvPayWay.setText("支付宝");
        } else {
            this.mTvPayWay.setText("未知");
        }
    }

    private void getAppName() {
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        List<PlanInfoBean> list = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(InvestorInfoUtil.getInstance().getInvestorInfosIndex()).investorInfo.planInfo;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                List<TypeInfoBean> list2 = list.get(i).typeInfo;
                if (list2 != null && list2.size() > 0) {
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        arrayList.add(list.get(i).typeInfo.get(i2));
                    }
                }
            }
        }
        for (int i3 = 0; i3 < this.mBuyClubCardDetailBean.typeidJsonb.size(); i3++) {
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                Log.e("test", i3 + "  " + i4 + "  " + this.mBuyClubCardDetailBean.typeidJsonb.get(i3) + "  " + ((TypeInfoBean) arrayList.get(i4)).base.typeId + "  " + sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName));
                if (this.mBuyClubCardDetailBean.typeidJsonb.get(i3).intValue() == ((TypeInfoBean) arrayList.get(i4)).base.typeId && !sb.toString().contains(((TypeInfoBean) arrayList.get(i4)).base.appName)) {
                    sb.append(((TypeInfoBean) arrayList.get(i4)).base.appName + "/");
                }
            }
        }
        if (sb.length() > 1) {
            this.mTvUseType.setText(sb.toString().substring(0, sb.length() - 1));
        }
    }
}
