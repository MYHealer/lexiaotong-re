package client.android.yixiaotong.ui.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.BillOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.UriUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayOrderActivity extends BaseActivity {
    private List<BillOrderBean> mBillOrderBeans;
    SimpleDraweeView mIconView;
    TextView mMoneyView;
    TextView mNameView;
    Button mPayButton;
    TextView mTime;
    TitleBar mTitlebar;
    TextView mUseMoney;
    private WalletModel mWalletModel;
    TextView tvTemperature;
    TextView tvTemperatureDetail;
    private int mUseMoney1 = 0;
    private boolean mIsEnable = false;

    static {
        StubApp.interface11(7533);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, List<BillOrderBean> list) {
        Intent intent = new Intent(activity, (Class<?>) PayOrderActivity.class);
        intent.putExtra("applicationType", i);
        intent.putExtra("data", (Serializable) list);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mIconView = (SimpleDraweeView) findViewById(R.id.icon);
        this.mNameView = (TextView) findViewById(R.id.name);
        this.mMoneyView = (TextView) findViewById(R.id.money);
        this.mPayButton = (Button) findViewById(R.id.pay);
        this.mUseMoney = (TextView) findViewById(R.id.usemoney);
        this.mTime = (TextView) findViewById(R.id.time);
        this.tvTemperatureDetail = (TextView) findViewById(R.id.temperature);
        this.tvTemperature = (TextView) findViewById(R.id.tv_temperature);
    }

    private void initTitleBar() {
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
        this.mTitlebar.setTitleView("支付订单");
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void getOneApp() {
        BusinessControllers.getInstance().GetOneStudentApplication(getLoginAccount(), 1, new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.pay.PayOrderActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (PayOrderActivity.this.mIsEnable) {
                    if (list == null) {
                        ToastUtils.show(PayOrderActivity.this.getContext(), "数据异常，请重新登录");
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(BaseApplication.app);
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                        return;
                    }
                    if (list.size() > 0) {
                        String strDivide = DecimalUtil.divide(list.get(0).getBalance() + "", "100");
                        PayOrderActivity.this.mWalletModel = list.get(0);
                        LocalBusinessStore.saveOrderMoney(PayOrderActivity.this.getContext(), PayOrderActivity.this.mWalletModel.typeId, strDivide);
                        PayOrderActivity.this.mIconView.setImageURI(UriUtils.parseUri(PayOrderActivity.this.mWalletModel.icon));
                        PayOrderActivity.this.mNameView.setText(PayOrderActivity.this.mWalletModel.name);
                        PayOrderActivity.this.mMoneyView.setText(DecimalUtil.twoDecimal(strDivide) + "元");
                        ToastUtils.show(PayOrderActivity.this.getContext(), "支付订单成功", 1);
                        PayOrderActivity.this.mPayButton.setText("完成");
                        PayOrderActivity.this.mPayButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.pay.PayOrderActivity.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PayOrderActivity.this.finish();
                            }
                        });
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PayOrderActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(PayOrderActivity.this.getActivity(), PayOrderActivity.this.mTitlebar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    public void getWallet() {
        BusinessControllers.getInstance().syncWallets(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.pay.PayOrderActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (!PayOrderActivity.this.mIsEnable || list == null || list.size() <= 0) {
                    return;
                }
                for (WalletModel walletModel : list) {
                    if (walletModel.typeId == 1) {
                        String strDivide = DecimalUtil.divide(walletModel.getBalance() + "", "100");
                        PayOrderActivity.this.mWalletModel = walletModel;
                        LocalBusinessStore.saveOrderMoney(PayOrderActivity.this.getContext(), PayOrderActivity.this.mWalletModel.typeId, strDivide);
                        PayOrderActivity.this.mIconView.setImageURI(UriUtils.parseUri(PayOrderActivity.this.mWalletModel.icon));
                        PayOrderActivity.this.mNameView.setText(PayOrderActivity.this.mWalletModel.name);
                        PayOrderActivity.this.mMoneyView.setText(DecimalUtil.twoDecimal(strDivide) + "元");
                        ToastUtils.show(PayOrderActivity.this.getContext(), "支付订单成功", 1);
                        PayOrderActivity.this.mPayButton.setText("完成");
                        PayOrderActivity.this.mPayButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.pay.PayOrderActivity.2.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                PayOrderActivity.this.finish();
                            }
                        });
                    }
                }
            }
        });
    }
}
