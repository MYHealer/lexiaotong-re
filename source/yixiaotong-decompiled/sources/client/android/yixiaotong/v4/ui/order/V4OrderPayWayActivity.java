package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.alipay.AliPayUtils;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.order.NoPayOrderResultBean;
import client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.enumconfig.EnumPayFlag;
import client.android.yixiaotong.wxapi.WxPayUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4OrderPayWayActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4OrderPayWayActivity";
    private boolean mIsEnable;
    private LinearLayout mLinPayWay;
    private WrapListView mLvRechargeWay;
    private int mPayMoney;
    private String mPayUrl;
    private RechargeWayAdapter mRechargeWayAdapter;
    private TitleBar mTitleBar;
    private TextView mTvPayMoney;
    private int mTypeId;
    private int mSelectWay = 0;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private boolean mIsNeedLoadOrder = false;
    private int mICBCIndex = 1;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.order.V4OrderPayWayActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(V4OrderPayWayActivity.TAG, "onPermissionGranted:" + i + "");
            if (i == 4 && ((Integer) V4OrderPayWayActivity.this.mPayFlagTypeList.get(V4OrderPayWayActivity.this.mSelectWay)).intValue() == 12) {
                ICBCPayWayDialog.getInstance().showDialog(V4OrderPayWayActivity.this.getActivity(), new ICBCPayWayDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.order.V4OrderPayWayActivity.2.1
                    @Override // client.android.yixiaotong.v3.ui.dialog.ICBCPayWayDialog.Listener
                    public void onPay(int i2) {
                        V4OrderPayWayActivity.this.mICBCIndex = i2;
                        V4OrderPayWayActivity.this.payOrders();
                    }
                }, DecimalUtil.divide(V4OrderPayWayActivity.this.mPayMoney + "", "100"));
            }
        }
    };

    static {
        StubApp.interface11(10976);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void payOrders() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4OrderPayWayActivity.class).putExtra("paymoney", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvPayMoney = (TextView) findViewById(R.id.tv_paymoney);
        this.mLinPayWay = (LinearLayout) findViewById(R.id.lin_payway);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("确认支付");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvPayMoney.setText("¥" + DecimalUtil.divide(this.mPayMoney + "", "100"));
        this.mRechargeWayAdapter = new RechargeWayAdapter();
        this.mLvRechargeWay.setOnItemClickListener(this);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mRechargeWayAdapter);
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void initData() {
        this.mPayFlagTypeList.clear();
        this.mPayFlagTypeList.add(Integer.valueOf(EnumPayFlag.WEIXIN.getValue()));
        this.mPayFlagTypeList.add(Integer.valueOf(EnumPayFlag.ZFB.getValue()));
        if (this.mPayFlagTypeList.size() == 0) {
            this.mLinPayWay.setVisibility(4);
        } else {
            this.mLinPayWay.setVisibility(0);
        }
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4OrderPayWayActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m532x8a9d509f(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-order-V4OrderPayWayActivity, reason: not valid java name */
    /* synthetic */ void m532x8a9d509f(View view) {
        LogUtil.e(TAG, "Pay button clicked");
        handlePayment();
    }

    private void handlePayment() {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        payOrders();
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

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        this.mSelectWay = i;
        this.mRechargeWayAdapter.notifyDataSetChanged();
    }

    private void pay(NoPayOrderResultBean noPayOrderResultBean) {
        String str;
        if (noPayOrderResultBean.payInfo != null && (StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.tradeNo) || StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.orderString))) {
            if (noPayOrderResultBean.payInfo.mode == 0) {
                str = noPayOrderResultBean.payInfo.orderString;
            } else {
                str = noPayOrderResultBean.payInfo.mode == 1 ? noPayOrderResultBean.payInfo.tradeNo : "";
            }
            AliPayUtils.pay(getActivity(), str, new AliPayUtils.OnPayListener() { // from class: client.android.yixiaotong.v4.ui.order.V4OrderPayWayActivity.1
                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void paySuccess() {
                    ToastUtils.show(V4OrderPayWayActivity.this.getContext(), "支付成功");
                    V4OrderPayWayActivity.this.finish();
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payWaitting() {
                    ToastUtils.show(V4OrderPayWayActivity.this.getContext(), "正在等待支付结果,稍后会收到服务器确认的支付结果");
                }

                @Override // client.android.yixiaotong.alipay.AliPayUtils.OnPayListener
                public void payFail() {
                    ToastUtils.show(V4OrderPayWayActivity.this.getContext(), "支付失败");
                }
            });
            return;
        }
        if (noPayOrderResultBean.payInfo == null || !StringUtils.isNotEmpty(noPayOrderResultBean.payInfo.appid)) {
            return;
        }
        this.mIsNeedLoadOrder = true;
        WxPayUtils.pay(getActivity(), noPayOrderResultBean.payInfo.appid, noPayOrderResultBean.payInfo.partnerid, noPayOrderResultBean.payInfo.prepayid, noPayOrderResultBean.payInfo.noncestr, noPayOrderResultBean.payInfo.timestamp, noPayOrderResultBean.payInfo.sign);
    }

    private void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    class RechargeWayAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        RechargeWayAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V4OrderPayWayActivity.this.mPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) V4OrderPayWayActivity.this.mPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4OrderPayWayActivity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            viewHolder.img2.setImageResource(R.mipmap.wxz);
            if (iIntValue == 1) {
                viewHolder.img.setImageResource(R.mipmap.wx);
                viewHolder.tv_name.setText("微信支付");
            } else if (iIntValue == 2) {
                viewHolder.img.setImageResource(R.mipmap.zfb);
                viewHolder.tv_name.setText("支付宝支付");
            } else if (iIntValue == 3) {
                viewHolder.img.setImageResource(R.mipmap.yl);
                viewHolder.tv_name.setText("银联支付");
            } else if (iIntValue == 31) {
                viewHolder.img.setImageResource(R.mipmap.refund_zgyh);
                viewHolder.tv_name.setText(V4OrderPayWayActivity.this.getString(R.string.zgyhjhzf));
            } else {
                viewHolder.img.setVisibility(8);
                viewHolder.tv_name.setText("第三方支付");
            }
            if (V4OrderPayWayActivity.this.mSelectWay == i) {
                viewHolder.img2.setImageResource(R.mipmap.xz1);
            }
            if (iIntValue == 12) {
                viewHolder.img.setImageResource(R.mipmap.icbc);
                viewHolder.tv_name.setText(V4OrderPayWayActivity.this.getString(R.string.icbcjhzf));
                viewHolder.img2.setImageResource(R.mipmap.next);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public ImageView img2;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img1);
                this.tv_name = (TextView) view.findViewById(R.id.textali);
                this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
            }
        }
    }
}
