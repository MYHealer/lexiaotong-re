package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.pay.PayMoneyInfoBean;
import client.android.yixiaotong.v3.ui.adapter.PayMoneyAdapter;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ElecMeterInfoBean;
import client.android.yixiaotong.v4.http.bean.V4RechargeBean;
import client.android.yixiaotong.v4.ui.adapter.V4PayWayAdapter;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterRechargeActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4ElecMeterRechargeActivity";
    private V4ElecMeterInfoBean mBindElecMeterInfoBean;
    EditText mEtInputMoney;
    LinearLayout mLinDefined;
    LinearLayout mLinOrherMoney;
    WrapGridView mLvRechargeMoney;
    WrapListView mLvRechargeWay;
    private PayMoneyAdapter mPayMoneyAdapter;
    private V4PayWayAdapter mPayWayAdapter;
    private int mProductId;
    RelativeLayout mRelUserNo;
    TitleBar mTitleBar;
    TextView mTvDeviceNo;
    TextView mTvMoney;
    TextView mTvRoomAddress;
    TextView mTvUserNo;
    private boolean mIsEnable = true;
    private List<PayMoneyInfoBean> mPayMoneyInfoBeans = new ArrayList();
    private List<Integer> mPayWayDatas = new ArrayList();
    private int mPayWayIndex = 0;
    private int mPayMoneyIndex = 0;
    private ArrayList<Integer> mMoneys = new ArrayList<>();
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 1) {
                return;
            }
            V4ElecMeterRechargeActivity.this.checkIsOpenBluetooth();
        }
    };

    static {
        StubApp.interface11(10760);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, V4ElecMeterInfoBean v4ElecMeterInfoBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterRechargeActivity.class).putExtra("bean", v4ElecMeterInfoBean).putExtra("productid", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mRelUserNo = (RelativeLayout) findViewById(R.id.rel_userno);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mTvUserNo = (TextView) findViewById(R.id.tv_userno);
        this.mTvRoomAddress = (TextView) findViewById(R.id.tv_roomaddress);
        this.mTvDeviceNo = (TextView) findViewById(R.id.tv_deviceno);
        this.mLvRechargeWay = (WrapListView) findViewById(R.id.listview);
        this.mLvRechargeMoney = (WrapGridView) findViewById(R.id.lv_chongzhi);
        this.mLinDefined = (LinearLayout) findViewById(R.id.lin_defined);
        this.mLinOrherMoney = (LinearLayout) findViewById(R.id.lin_othermoney);
        this.mEtInputMoney = (EditText) findViewById(R.id.et_inputmoney);
    }

    private void initTitleBar() {
        int i = this.mProductId;
        if (i == 12) {
            this.mTitleBar.setTitleView(getString(R.string.elecmeterrecharge));
        } else if (i == 6) {
            this.mTitleBar.setTitleView(getString(R.string.rechargewatermeter));
        } else if (i == 13) {
            this.mTitleBar.setTitleView(getString(R.string.airconditioningrecharge));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        if (this.mProductId == 12) {
            this.mRelUserNo.setVisibility(0);
        } else {
            this.mRelUserNo.setVisibility(8);
        }
        this.mTvDeviceNo.setText(this.mBindElecMeterInfoBean.mac);
        this.mTvUserNo.setText(this.mBindElecMeterInfoBean.eleSn);
        this.mTvRoomAddress.setText(this.mBindElecMeterInfoBean.address);
        this.mPayMoneyAdapter = new PayMoneyAdapter(getActivity(), new PayMoneyAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.1
            @Override // client.android.yixiaotong.v3.ui.adapter.PayMoneyAdapter.OnItemClickListener
            public void onItemClick(int i) {
                LogUtil.e(V4ElecMeterRechargeActivity.TAG, "onItemClick:" + i);
                V4ElecMeterRechargeActivity.this.mPayMoneyIndex = i;
                V4ElecMeterRechargeActivity.this.mTvMoney.setText(V4ElecMeterRechargeActivity.this.mMoneys.get(V4ElecMeterRechargeActivity.this.mPayMoneyIndex) + "");
                V4ElecMeterRechargeActivity.this.mPayMoneyAdapter.notifyDataSetChanged();
            }
        });
        this.mMoneys.add(10);
        this.mMoneys.add(30);
        this.mMoneys.add(50);
        this.mMoneys.add(100);
        this.mMoneys.add(200);
        this.mMoneys.add(300);
        this.mPayMoneyInfoBeans.clear();
        for (int i = 0; i < this.mMoneys.size(); i++) {
            PayMoneyInfoBean payMoneyInfoBean = new PayMoneyInfoBean();
            payMoneyInfoBean.payMoney = this.mMoneys.get(i) + "";
            this.mPayMoneyInfoBeans.add(payMoneyInfoBean);
        }
        this.mPayMoneyAdapter.setData(this.mPayMoneyInfoBeans);
        this.mLvRechargeMoney.setOnItemClickListener(this.mPayMoneyAdapter);
        this.mLvRechargeMoney.setAdapter((ListAdapter) this.mPayMoneyAdapter);
        this.mPayMoneyAdapter.notifyDataSetChanged();
        this.mTvMoney.setText(this.mMoneys.get(this.mPayMoneyIndex) + "");
        V4PayWayAdapter v4PayWayAdapter = new V4PayWayAdapter(getActivity(), new V4PayWayAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.2
            @Override // client.android.yixiaotong.v4.ui.adapter.V4PayWayAdapter.OnItemClickListener
            public void onItemClick(int i2) {
                LogUtil.e(V4ElecMeterRechargeActivity.TAG, "onItemClick:" + i2);
                V4ElecMeterRechargeActivity.this.mPayWayIndex = i2;
                V4ElecMeterRechargeActivity.this.mPayWayAdapter.notifyDataSetChanged();
            }
        });
        this.mPayWayAdapter = v4PayWayAdapter;
        this.mLvRechargeWay.setOnItemClickListener(v4PayWayAdapter);
        this.mLvRechargeWay.setAdapter((ListAdapter) this.mPayWayAdapter);
        this.mPayWayDatas.add(3);
        this.mPayWayAdapter.setData(this.mPayWayDatas, this.mBindElecMeterInfoBean.cpersonBalance, this.mBindElecMeterInfoBean.cpersonGiftBalance);
        this.mPayWayAdapter.notifyDataSetChanged();
        this.mEtInputMoney.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(editable.toString())) {
                    if (V4ElecMeterRechargeActivity.this.mTvMoney.getText().toString().length() == 1 && V4ElecMeterRechargeActivity.this.mPayMoneyIndex == -1) {
                        V4ElecMeterRechargeActivity.this.mTvMoney.setText("");
                        return;
                    }
                    return;
                }
                V4ElecMeterRechargeActivity.this.mTvMoney.setText(editable.toString());
                V4ElecMeterRechargeActivity.this.mPayMoneyIndex = -1;
                V4ElecMeterRechargeActivity.this.mPayMoneyAdapter.setSelectIndex(V4ElecMeterRechargeActivity.this.mPayMoneyIndex);
                V4ElecMeterRechargeActivity.this.mPayMoneyAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.lin_defined).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4ElecMeterRechargeActivity.this.mLinDefined.setVisibility(8);
                V4ElecMeterRechargeActivity.this.mLinOrherMoney.setVisibility(0);
            }
        });
        findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick() || !V4ElecMeterRechargeActivity.this.check()) {
                    return;
                }
                PermissionUtil.requestPerssion(V4ElecMeterRechargeActivity.this.getActivity(), 1, V4ElecMeterRechargeActivity.this.permissionGrant);
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtil.e(TAG, adapterView.getAdapter().toString());
        if (adapterView.getAdapter().toString().contains("PayMoneyAdapter")) {
            this.mPayMoneyIndex = i;
            this.mPayMoneyAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean check() {
        if (StringUtils.isEmpty(this.mTvMoney.getText().toString())) {
            ToastUtils.show(getContext(), getString(R.string.selectrechargeamounts));
            return false;
        }
        List<Integer> list = this.mPayWayDatas;
        if (list == null || list.size() <= 0) {
            ToastUtils.show(getContext(), getString(R.string.noopenpayway));
            return false;
        }
        if (Pattern.compile("^\\d+(\\.\\d{1,2})?$").matcher(this.mTvMoney.getText().toString()).matches()) {
            return true;
        }
        ToastUtils.show(getActivity(), "至多保留两位小数");
        return false;
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            createOrder();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    }

    private void createOrder() {
        String string;
        if (this.mPayMoneyIndex == -1) {
            string = this.mEtInputMoney.getText().toString();
        } else {
            string = this.mMoneys.get(this.mPayMoneyIndex) + "";
        }
        V4BusinessControllers.getInstance().postCreateElecMeterOrderId(getLoginAccount(), this.mPayWayDatas.get(this.mPayWayIndex).intValue(), string, this.mBindElecMeterInfoBean.mac, this.mProductId, new Listener<V4RechargeBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4ElecMeterRechargeActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4ElecMeterRechargeActivity.this.getActivity(), "下单中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4RechargeBean v4RechargeBean, Object... objArr) {
                super.onComplete(controller, v4RechargeBean, objArr);
                if (V4ElecMeterRechargeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ElecMeterRechargeActivity.this.getContext(), "支付成功");
                    V4DeviceRechargeActivity.launch(V4ElecMeterRechargeActivity.this.getActivity(), V4ElecMeterRechargeActivity.this.mBindElecMeterInfoBean.bluetoothMac, V4ElecMeterRechargeActivity.this.mBindElecMeterInfoBean.mac, V4ElecMeterRechargeActivity.this.mProductId, v4RechargeBean != null ? v4RechargeBean.sysRandom : "");
                    V4ElecMeterRechargeActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ElecMeterRechargeActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4ElecMeterRechargeActivity.this.getActivity(), false);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            createOrder();
        }
    }
}
