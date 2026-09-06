package client.android.yixiaotong.v3.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.v3.bean.order.BuyClubCardDetailBean;
import client.android.yixiaotong.v3.bean.wallet.ExtendJsonBean;
import client.android.yixiaotong.v3.bean.wallet.LogBean;
import client.android.yixiaotong.v3.bean.wallet.WalletRefundDetailBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import com.google.gson.reflect.TypeToken;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DepositRefundDetailActivity extends BaseActivity {
    private BuyClubCardDetailBean mBuyClubCardDetailBean;
    private ListView mLvMesage;
    private RecordsAdapter mRecordsAdapter;
    private RelativeLayout mRelAccount;
    private RelativeLayout mRelAccountTime;
    private RelativeLayout mRelPromotion;
    private TitleBar mTitleBar;
    private TextView mTvAccount;
    private TextView mTvAccountTime;
    private TextView mTvOrderNo;
    private TextView mTvPromotion;
    private TextView mTvRefundMoney;
    private TextView mTvRefundWay;
    private TextView mTvState;
    private TextView mTvTime;
    private boolean mIsEnable = true;
    private List<LogBean> mDataList = new ArrayList();

    static {
        StubApp.interface11(10038);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, BuyClubCardDetailBean buyClubCardDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DepositRefundDetailActivity.class).putExtra("bean", buyClubCardDetailBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderNo = (TextView) findViewById(R.id.tv_orderno);
        this.mRelAccount = (RelativeLayout) findViewById(R.id.rel_account);
        this.mTvRefundMoney = (TextView) findViewById(R.id.tv_refundmoney);
        this.mTvAccount = (TextView) findViewById(R.id.tv_account);
        this.mTvRefundWay = (TextView) findViewById(R.id.tv_refundway);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mRelAccountTime = (RelativeLayout) findViewById(R.id.rel_accounttime);
        this.mTvAccountTime = (TextView) findViewById(R.id.tv_timeend);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mRelPromotion = (RelativeLayout) findViewById(R.id.rel_promotion);
        this.mTvPromotion = (TextView) findViewById(R.id.tv_promotion);
        this.mLvMesage = (ListView) findViewById(R.id.lv_message);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("退押详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void initView(WalletRefundDetailBean walletRefundDetailBean) {
        ExtendJsonBean extendJsonBean = null;
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mRecordsAdapter = recordsAdapter;
        this.mLvMesage.setAdapter((ListAdapter) recordsAdapter);
        this.mTvOrderNo.setText(this.mTvOrderNo.getText().toString() + walletRefundDetailBean.orderId);
        this.mTvRefundMoney.setText(this.mTvRefundMoney.getText().toString() + DecimalUtil.divide(walletRefundDetailBean.price + "", "100"));
        this.mTvAccount.setText(walletRefundDetailBean.studentPayContactId);
        if (walletRefundDetailBean.payFlagType == 1 || walletRefundDetailBean.payFlagType == -1) {
            this.mTvRefundWay.setText(getString(R.string.weixin));
            this.mRelAccount.setVisibility(8);
        } else if (walletRefundDetailBean.payFlagType == 2 || walletRefundDetailBean.payFlagType == -2) {
            this.mTvRefundWay.setText(getString(R.string.alipay));
        } else if (walletRefundDetailBean.payFlagType == 22 || walletRefundDetailBean.payFlagType == -22) {
            this.mTvRefundWay.setText(getString(R.string.zgyh));
        } else if (walletRefundDetailBean.payFlagType == 23 || walletRefundDetailBean.payFlagType == -23) {
            this.mTvRefundWay.setText(getString(R.string.jsyh));
        } else if (walletRefundDetailBean.payFlagType == 24 || walletRefundDetailBean.payFlagType == -24) {
            this.mTvRefundWay.setText(getString(R.string.nyyh));
        } else if (walletRefundDetailBean.payFlagType == 25 || walletRefundDetailBean.payFlagType == -25) {
            this.mTvRefundWay.setText(getString(R.string.icbc));
        } else {
            this.mTvRefundWay.setText("后台");
        }
        this.mTvTime.setText(walletRefundDetailBean.createDateTime);
        if (StringUtils.isNotEmpty(walletRefundDetailBean.payDateTime)) {
            this.mTvAccountTime.setText(walletRefundDetailBean.payDateTime);
        } else {
            this.mRelAccountTime.setVisibility(8);
        }
        if (walletRefundDetailBean.statusFlag == 1) {
            this.mTvState.setText("学生申请");
        } else if (walletRefundDetailBean.statusFlag == 2) {
            this.mTvState.setText("撤销申请");
        } else if (walletRefundDetailBean.statusFlag == 3) {
            this.mTvState.setText("拒绝退款");
        } else if (walletRefundDetailBean.statusFlag == 4) {
            this.mTvState.setText("平台退款");
        } else if (walletRefundDetailBean.statusFlag == 5) {
            this.mTvState.setText("商户人工退款");
        }
        if (StringUtils.isNotEmpty(walletRefundDetailBean.extendJson)) {
            try {
                extendJsonBean = (ExtendJsonBean) GsonUtils.getInstance().parse(new TypeToken<ExtendJsonBean>() { // from class: client.android.yixiaotong.v3.ui.order.DepositRefundDetailActivity.1
                }.getType(), walletRefundDetailBean.extendJson);
            } catch (ClientException e) {
                e.printStackTrace();
            }
            if (extendJsonBean != null && extendJsonBean.log != null && extendJsonBean.log.size() > 0) {
                for (int i = 0; i < extendJsonBean.log.size(); i++) {
                    this.mDataList = extendJsonBean.log;
                    this.mRecordsAdapter.notifyDataSetChanged();
                }
            }
            if (extendJsonBean == null || !StringUtils.isNotEmpty(extendJsonBean.promotion)) {
                return;
            }
            this.mRelPromotion.setVisibility(0);
            this.mTvPromotion.setText(extendJsonBean.promotion);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
    }

    private void getRefundDetail() {
        V3BusinessControllers.getInstance().getSurrenderIdInfo(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mBuyClubCardDetailBean.orderId, new Listener<WalletRefundDetailBean>() { // from class: client.android.yixiaotong.v3.ui.order.DepositRefundDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(DepositRefundDetailActivity.this.getActivity(), "正在获取数据", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, WalletRefundDetailBean walletRefundDetailBean, Object... objArr) {
                if (DepositRefundDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DepositRefundDetailActivity.this.initView(walletRefundDetailBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DepositRefundDetailActivity.this.mIsEnable) {
                    DepositRefundDetailActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private class RecordsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RecordsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DepositRefundDetailActivity.this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public LogBean getItem(int i) {
            return (LogBean) DepositRefundDetailActivity.this.mDataList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DepositRefundDetailActivity.this.getContext()).inflate(R.layout.layout_item_refund, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            LogBean item = getItem(i);
            if (StringUtils.isNotEmpty(item.msg)) {
                viewHolder.tv_message.setText("(" + item.code + ")" + item.msg);
            } else {
                viewHolder.tv_message.setText("(" + item.code + ")");
            }
            viewHolder.tv_time.setText(TimeUtils.formatDateTime(item.time));
            return view;
        }

        class ViewHolder {
            public TextView tv_message;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_message = (TextView) view.findViewById(R.id.tv_message);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
            }
        }
    }
}
