package client.android.yixiaotong.v3.ui.appcontrol.dry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.GetModeBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.deviceinfo.ModeBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.InvestoridAndSchoolId;
import client.android.yixiaotong.v3.bean.login.SchoolInfosBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DryModeActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String TAG = "WashModeActivity";
    private static final int TYPEID = 16;
    private ListView mLvMode;
    private String mMac;
    private ModeAdapter mModeAdapter;
    private int mPlanFlag;
    private String mQrcode;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private TextView mTvNo;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private List<ModeBean> mModeBeanList = new ArrayList();
    private String mMachineId = "";
    private boolean mIsEnable = true;
    private boolean mIs4GDevice = false;
    private boolean mIsBluetoothDevice = false;

    static {
        StubApp.interface11(9294);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DryModeActivity.class).putExtra("qrcode", str));
        }
    }

    public static void launch(Activity activity, String str, String str2, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DryModeActivity.class).putExtra("qrcode", str).putExtra("machineid", str2).putExtra(Constant.KEY_MAC, str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvNo = (TextView) findViewById(R.id.tv_no);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mLvMode = (ListView) findViewById(R.id.lv_mode);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.mode));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initView() {
        this.mTvNo.setText(this.mMachineId);
        this.mModeAdapter = new ModeAdapter();
        this.mLvMode.setOnItemClickListener(this);
        this.mLvMode.setAdapter((ListAdapter) this.mModeAdapter);
        this.mModeAdapter.notifyDataSetChanged();
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

    private void getInfoByQRCode() {
        V3BusinessControllers.getInstance().getInfoByQRCode(getLoginAccount(), this.mQrcode, false, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取数据中");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (DryModeActivity.this.mIsEnable) {
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.deviceMac) || !StringUtils.isNotEmpty(machineByMacBean.machineId)) {
                        DryModeActivity.this.showDialogNeedExit("设备未授权，请联系管理员");
                        return;
                    }
                    DryModeActivity.this.mMachineId = machineByMacBean.machineId;
                    DryModeActivity.this.mMac = machineByMacBean.deviceMac;
                    DryModeActivity.this.mTvNo.setText(DryModeActivity.this.mMachineId);
                    DryModeActivity.this.getUseInfoByMachineId();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryModeActivity.this.mIsEnable) {
                    DryModeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getUseInfoByMachineId() {
        V3BusinessControllers.getInstance().getUseInfoByMachineId(getLoginAccount(), this.mMachineId, 16, new Listener<InvestoridAndSchoolId>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, InvestoridAndSchoolId investoridAndSchoolId, Object... objArr) {
                if (DryModeActivity.this.mIsEnable && StringUtils.isNotEmpty(investoridAndSchoolId.investorId) && StringUtils.isNotEmpty(investoridAndSchoolId.schoolId)) {
                    LogUtil.i("WashModeActivity", investoridAndSchoolId.schoolId + "  " + UserInfoUtilControl.getInstance().getSchoolId());
                    LogUtil.d("WashModeActivity", investoridAndSchoolId.investorId + "  " + InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId);
                    if (!investoridAndSchoolId.schoolId.equals(UserInfoUtilControl.getInstance().getSchoolId())) {
                        List<SchoolInfosBean> list = UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList;
                        boolean z = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).id == Long.parseLong(investoridAndSchoolId.schoolId)) {
                                UserInfoUtil.getInstance().saveSchoolInfosIndex(i);
                                z = true;
                            }
                        }
                        if (z) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                            LocalDataUtil.saveIsNeedLoadInvestorInfo(DryModeActivity.this.getContext(), true);
                            DryModeActivity.this.getInvestorInfo(investoridAndSchoolId.investorId);
                        }
                    } else if (!investoridAndSchoolId.investorId.equals(InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId)) {
                        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                        for (int i2 = 0; i2 < investorInfosV3.size(); i2++) {
                            if (investorInfosV3.get(i2).investorInfo.investorId.equals(investoridAndSchoolId.investorId)) {
                                InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i2);
                            }
                        }
                    }
                    DryModeActivity.this.getMode();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryModeActivity.this.mIsEnable) {
                    DryModeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getInvestorInfo(final String str) {
        V3BusinessControllers.getInstance().getInvestorInfo(getLoginAccount(), new Listener<List<InvestorInfosBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<InvestorInfosBean> list, Object... objArr) {
                if (DryModeActivity.this.mIsEnable) {
                    List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
                    for (int i = 0; i < investorInfosV3.size(); i++) {
                        if (investorInfosV3.get(i).investorInfo.investorId.equals(str)) {
                            InvestorInfoUtil.getInstance().saveInvestorInfosIndex(i);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryModeActivity.this.mIsEnable) {
                    DryModeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getMode() {
        V3BusinessControllers.getInstance().postGetMode(getLoginAccount(), 16, this.mMachineId, UserInfoUtil.getInstance().getLoginAccountV3().schoolList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()), new Listener<GetModeBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取数据");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, GetModeBean getModeBean, Object... objArr) {
                if (DryModeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (getModeBean != null) {
                        DryModeActivity.this.mTvAddress.setText(getModeBean.useAddress);
                    }
                    if (getModeBean == null || getModeBean.pminfo == null || getModeBean.pminfo.size() <= 0) {
                        DryModeActivity.this.showDialogNeedExit("未配置干衣模式，请联系管理员");
                        return;
                    }
                    DryModeActivity.this.mModeBeanList.clear();
                    for (int i = 0; i < getModeBean.pminfo.size(); i++) {
                        if (getModeBean.pminfo.get(i).flag == 1) {
                            DryModeActivity.this.mModeBeanList.add(getModeBean.pminfo.get(i));
                        }
                    }
                    DryModeActivity.this.mModeAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DryModeActivity.this.mIsEnable) {
                    DryModeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DryModeActivity.this.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")", "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.dry.DryModeActivity.6
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                DryModeActivity.this.finish();
            }
        });
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        DryDetailActivity.launch(getActivity(), this.mQrcode, this.mMac, this.mIsBluetoothDevice, this.mModeAdapter.getItem(i));
        finish();
    }

    class ModeAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        ModeAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DryModeActivity.this.mModeBeanList.size();
        }

        @Override // android.widget.Adapter
        public ModeBean getItem(int i) {
            return (ModeBean) DryModeActivity.this.mModeBeanList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DryModeActivity.this.getContext()).inflate(R.layout.layout_washmode_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            ModeBean item = getItem(i);
            viewHolder.tv_name.setText(item.name);
            viewHolder.tv_money.setText(DecimalUtil.divide(item.m + "", "100") + DryModeActivity.this.getString(R.string.yuan));
            viewHolder.tv_des.setText(item.msg);
            if (item.f == 1) {
                viewHolder.img.setImageResource(R.mipmap.tg);
            } else if (item.f == 2) {
                viewHolder.img.setImageResource(R.mipmap.bz);
            } else if (item.f == 3) {
                viewHolder.img.setImageResource(R.mipmap.kg);
            } else if (item.f == 4) {
                viewHolder.img.setImageResource(R.mipmap.js);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public RelativeLayout rel_bg;
            public TextView tv_des;
            public TextView tv_money;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.img = (ImageView) view.findViewById(R.id.iv_icon);
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_des = (TextView) view.findViewById(R.id.tv_des);
            }
        }
    }
}
