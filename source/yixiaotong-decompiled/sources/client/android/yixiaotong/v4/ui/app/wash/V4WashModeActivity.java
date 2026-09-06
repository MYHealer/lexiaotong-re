package client.android.yixiaotong.v4.ui.app.wash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.RechargeRecordActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ModeBean;
import client.android.yixiaotong.v4.http.bean.V4ModeDetailBean;
import client.android.yixiaotong.v4.ui.app.bath.V4BathDetailActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4WashModeActivity extends BaseActivity {
    public static final String TAG = "V4WashModeActivity";
    ListView mLvMode;
    private String mMac;
    private ModeAdapter mModeAdapter;
    private int mPlanFlag;
    private String mQrcode;
    TitleBar mTitleBar;
    TextView mTvAddress;
    TextView mTvNo;
    private int mTypeId;
    private List<V4ModeDetailBean> mModeBeanList = new ArrayList();
    private String mMachineId = "";
    private boolean mIsEnable = true;
    private int mWashLiquid = 0;

    static {
        StubApp.interface11(10824);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4WashModeActivity.class).putExtra("machineid", str).putExtra(Constant.KEY_MAC, str2).putExtra(RechargeRecordActivity.EXTRA_TYPEID, i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvNo = (TextView) findViewById(R.id.tv_no);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mLvMode = (ListView) findViewById(R.id.lv_mode);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(V4TypeIDSetUtil.getAppName(getActivity(), this.mTypeId) + getString(R.string.mode));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initView() {
        this.mTvNo.setText(this.mMachineId);
        ModeAdapter modeAdapter = new ModeAdapter();
        this.mModeAdapter = modeAdapter;
        this.mLvMode.setAdapter((ListAdapter) modeAdapter);
        this.mModeAdapter.notifyDataSetChanged();
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
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void getMode() {
        V4BusinessControllers.getInstance().getMode(getLoginAccount(), this.mMachineId, new Listener<V4ModeBean>() { // from class: client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取数据");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ModeBean v4ModeBean, Object... objArr) {
                if (V4WashModeActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (v4ModeBean != null) {
                        V4WashModeActivity.this.mTvAddress.setText(v4ModeBean.areaName + v4ModeBean.buildingName + v4ModeBean.floorName + v4ModeBean.roomName);
                    }
                    if (v4ModeBean == null || v4ModeBean.modeDOList == null || v4ModeBean.modeDOList.size() <= 0) {
                        V4WashModeActivity.this.showDialogNeedExit("未配置" + V4TypeIDSetUtil.getAppName(V4WashModeActivity.this.getActivity(), V4WashModeActivity.this.mTypeId) + "模式，请联系管理员");
                        return;
                    }
                    V4WashModeActivity.this.mModeBeanList.clear();
                    for (int i = 0; i < v4ModeBean.modeDOList.size(); i++) {
                        V4WashModeActivity.this.mModeBeanList.add(v4ModeBean.modeDOList.get(i));
                    }
                    Collections.sort(V4WashModeActivity.this.mModeBeanList, new TestComparator());
                    V4WashModeActivity.this.mModeAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4WashModeActivity.this.mIsEnable) {
                    V4WashModeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "", str, "", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity.2
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                V4WashModeActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onModeItemClick(final V4ModeDetailBean v4ModeDetailBean) {
        String str;
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mWashLiquid != 1 || v4ModeDetailBean.liquidSwitch == null || v4ModeDetailBean.liquidSwitch.intValue() != 1 || v4ModeDetailBean.liquidAmount == null) {
            str = "是否启用" + v4ModeDetailBean.washModeName + "？";
        } else {
            str = "是否启用" + v4ModeDetailBean.washModeName + (v4ModeDetailBean.isLiquidSelected ? "（含有洗衣液）？" : "（不含洗衣液）？");
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity.3
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4BathDetailActivity.launch(V4WashModeActivity.this.getActivity(), V4WashModeActivity.this.mMac, V4WashModeActivity.this.mMachineId, V4WashModeActivity.this.mTypeId, v4ModeDetailBean.washModeId + "", v4ModeDetailBean.isLiquidSelected);
                V4WashModeActivity.this.finish();
            }
        }, "提示", str, R.color.ff242933, "取消", "确认");
    }

    static class TestComparator implements Comparator<V4ModeDetailBean> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(V4ModeDetailBean v4ModeDetailBean, V4ModeDetailBean v4ModeDetailBean2) {
            return v4ModeDetailBean.washMode - v4ModeDetailBean2.washMode;
        }
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
            return V4WashModeActivity.this.mModeBeanList.size();
        }

        @Override // android.widget.Adapter
        public V4ModeDetailBean getItem(int i) {
            return (V4ModeDetailBean) V4WashModeActivity.this.mModeBeanList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4WashModeActivity.this.getContext()).inflate(R.layout.layout_washmode_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final V4ModeDetailBean item = getItem(i);
            viewHolder.tv_name.setText(item.washModeName);
            viewHolder.tv_money.setText(item.amount + V4WashModeActivity.this.getString(R.string.yuan));
            if (StringUtils.isEmpty(item.remark)) {
                viewHolder.tv_des.setVisibility(8);
            } else {
                viewHolder.tv_des.setVisibility(0);
                viewHolder.tv_des.setText(item.remark);
            }
            viewHolder.rel_bg.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity$ModeAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m497xd1f3bc0b(item, view2);
                }
            });
            boolean z = V4WashModeActivity.this.mWashLiquid == 1 && item.liquidSwitch != null && item.liquidSwitch.intValue() == 1 && item.liquidAmount != null;
            viewHolder.ll_liquid.setVisibility(z ? 0 : 8);
            if (z) {
                viewHolder.tv_liquid_price.setText(item.liquidAmount + V4WashModeActivity.this.getString(R.string.yuan));
                updateLiquidView(viewHolder, item);
                viewHolder.ll_liquid.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.wash.V4WashModeActivity$ModeAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f$0.m498x98ffa30c(item, viewHolder, view2);
                    }
                });
            } else {
                viewHolder.ll_liquid.setOnClickListener(null);
            }
            if (item.washMode == 1) {
                if (V4WashModeActivity.this.mTypeId != 4) {
                    if (V4WashModeActivity.this.mTypeId == 11) {
                        viewHolder.img.setImageResource(R.mipmap.tg);
                    }
                } else {
                    viewHolder.img.setImageResource(R.mipmap.tuoshui);
                }
            } else if (item.washMode == 2) {
                if (V4WashModeActivity.this.mTypeId != 4) {
                    if (V4WashModeActivity.this.mTypeId == 11) {
                        viewHolder.img.setImageResource(R.mipmap.bz);
                    }
                } else {
                    viewHolder.img.setImageResource(R.mipmap.jisuxi);
                }
            } else if (item.washMode == 3) {
                if (V4WashModeActivity.this.mTypeId != 4) {
                    if (V4WashModeActivity.this.mTypeId == 11) {
                        viewHolder.img.setImageResource(R.mipmap.kg);
                    }
                } else {
                    viewHolder.img.setImageResource(R.mipmap.biaozhunxi);
                }
            } else if (item.washMode == 4) {
                if (V4WashModeActivity.this.mTypeId != 4) {
                    if (V4WashModeActivity.this.mTypeId == 11) {
                        viewHolder.img.setImageResource(R.mipmap.js);
                    }
                } else {
                    viewHolder.img.setImageResource(R.mipmap.dajianxi);
                }
            }
            return view;
        }

        /* JADX INFO: renamed from: lambda$getView$0$client-android-yixiaotong-v4-ui-app-wash-V4WashModeActivity$ModeAdapter, reason: not valid java name */
        /* synthetic */ void m497xd1f3bc0b(V4ModeDetailBean v4ModeDetailBean, View view) {
            V4WashModeActivity.this.onModeItemClick(v4ModeDetailBean);
        }

        /* JADX INFO: renamed from: lambda$getView$1$client-android-yixiaotong-v4-ui-app-wash-V4WashModeActivity$ModeAdapter, reason: not valid java name */
        /* synthetic */ void m498x98ffa30c(V4ModeDetailBean v4ModeDetailBean, ViewHolder viewHolder, View view) {
            v4ModeDetailBean.isLiquidSelected = !v4ModeDetailBean.isLiquidSelected;
            updateLiquidView(viewHolder, v4ModeDetailBean);
        }

        private void updateLiquidView(ViewHolder viewHolder, V4ModeDetailBean v4ModeDetailBean) {
            if (v4ModeDetailBean.isLiquidSelected) {
                viewHolder.iv_liquid_icon.setImageResource(R.mipmap.sellcard_xz);
                viewHolder.ll_liquid.setBackgroundResource(R.drawable.bg_wash_mode_liquid_selected);
                try {
                    viewHolder.tv_money.setText((Double.parseDouble(v4ModeDetailBean.amount) + v4ModeDetailBean.liquidAmount.doubleValue()) + V4WashModeActivity.this.getString(R.string.yuan));
                    return;
                } catch (NumberFormatException unused) {
                    viewHolder.tv_money.setText(v4ModeDetailBean.amount + V4WashModeActivity.this.getString(R.string.yuan));
                    return;
                }
            }
            viewHolder.iv_liquid_icon.setImageResource(R.mipmap.sellcard_wxz);
            viewHolder.ll_liquid.setBackgroundResource(R.drawable.bg_wash_mode_liquid_normal);
            viewHolder.tv_money.setText(v4ModeDetailBean.amount + V4WashModeActivity.this.getString(R.string.yuan));
        }

        class ViewHolder {
            public ImageView img;
            public ImageView iv_liquid_icon;
            public LinearLayout ll_liquid;
            public RelativeLayout rel_bg;
            public TextView tv_des;
            public TextView tv_liquid_price;
            public TextView tv_money;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
                this.img = (ImageView) view.findViewById(R.id.iv_icon);
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_des = (TextView) view.findViewById(R.id.tv_des);
                this.ll_liquid = (LinearLayout) view.findViewById(R.id.ll_liquid);
                this.iv_liquid_icon = (ImageView) view.findViewById(R.id.iv_liquid_icon);
                this.tv_liquid_price = (TextView) view.findViewById(R.id.tv_liquid_price);
            }
        }
    }
}
