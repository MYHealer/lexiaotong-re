package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailBean;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamSpaceBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamDetailAdapterActivity extends BaseActivity {
    public static final String EXTRA_DATA = "extra_data";
    public static final String EXTRA_WALLET = "extra_wallet";
    private HamamDetailAdapter hamamDetailAdapter;
    GridView mGrid;
    private MaterialDialog mMaterialDialog;
    private List<HamamDetailListBean> mRecordListBeans;
    RelativeLayout mRel;
    TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private String maid;
    private List<HamamDetailBean> mRecordBeans = new ArrayList();
    private boolean mIsEnable = true;
    private List<HamamSpaceBean> bathspace = new ArrayList();

    static {
        StubApp.interface11(AVMDLDataLoader.KeyIsDownloadDir);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, List<HamamDetailListBean> list) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamDetailAdapterActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_data", (Serializable) list));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mGrid = (GridView) findViewById(R.id.grid);
        this.mRel = (RelativeLayout) findViewById(R.id.rel);
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

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void getAid() {
        BusinessControllers.getInstance().entranceGuardGetAreaInfo(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<List<AmmeterAreaInfo>>() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailAdapterActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                HamamDetailAdapterActivity.this.showDialog("加载中...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AmmeterAreaInfo> list, Object... objArr) {
                if (list != null) {
                    HamamDetailAdapterActivity.this.maid = list.get(0).id;
                    HamamDetailAdapterActivity.this.initData();
                    return;
                }
                HamamDetailAdapterActivity.this.dismissDialog();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                HamamDetailAdapterActivity.this.dismissDialog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        BusinessControllers.getInstance().getHamamDetail(getLoginAccount(), this.maid, getLoginAccount().getAccountManagetStore().getUserInfo().GenderId, LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid()), new Listener<List<HamamDetailListBean>>() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailAdapterActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HamamDetailListBean> list, Object... objArr) {
                if (HamamDetailAdapterActivity.this.mIsEnable) {
                    HamamDetailAdapterActivity.this.dismissDialog();
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    HamamDetailAdapterActivity.this.mRecordListBeans.clear();
                    HamamDetailAdapterActivity.this.mRecordListBeans = list;
                    HamamDetailAdapterActivity.this.hamamDetailAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamDetailAdapterActivity.this.mIsEnable) {
                    HamamDetailAdapterActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(HamamDetailAdapterActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailAdapterActivity.2.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamDetailAdapterActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    private boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        if (isShowingDialog()) {
            return;
        }
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content(str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailAdapterActivity.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    private class HamamDetailAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private HamamDetailAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return HamamDetailAdapterActivity.this.mRecordBeans.size();
        }

        @Override // android.widget.Adapter
        public HamamDetailBean getItem(int i) {
            return (HamamDetailBean) HamamDetailAdapterActivity.this.mRecordBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HamamDetailAdapterActivity.this.getContext()).inflate(R.layout.hamam_detail_adapter_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final HamamDetailBean hamamDetailBean = (HamamDetailBean) HamamDetailAdapterActivity.this.mRecordBeans.get(i);
            viewHolder.tvUse.setText(hamamDetailBean.i42 + "");
            viewHolder.tvIdl.setText(hamamDetailBean.i43 + "");
            viewHolder.tvAddress.setText(hamamDetailBean.dervicename);
            if (hamamDetailBean.i43 == 0) {
                if (hamamDetailBean.deviceStatus == 2) {
                    viewHolder.yuyue.setText("设备异常");
                }
                viewHolder.yuyue.setEnabled(false);
                viewHolder.yuyue.setBackgroundResource(R.drawable.shape_e8e8e8_oval_background);
            } else if (hamamDetailBean.deviceStatus == 2) {
                viewHolder.yuyue.setText("设备异常");
                viewHolder.yuyue.setEnabled(false);
                viewHolder.yuyue.setBackgroundResource(R.drawable.shape_e8e8e8_oval_background);
            } else {
                viewHolder.yuyue.setEnabled(true);
                viewHolder.yuyue.setBackgroundResource(R.drawable.shape_4a90e2_oval_background);
                viewHolder.yuyue.setText("查看状态");
            }
            viewHolder.yuyue.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailAdapterActivity.HamamDetailAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (hamamDetailBean.bathspace == null || hamamDetailBean.bathspace.size() <= 0 || hamamDetailBean.i43 == 0) {
                        ToastUtils.show(HamamDetailAdapterActivity.this.getContext(), "该集中器没有澡位！");
                        return;
                    }
                    HamamDetailAdapterActivity.this.bathspace = hamamDetailBean.bathspace;
                    YuYueActivity.launch(HamamDetailAdapterActivity.this.getActivity(), HamamDetailAdapterActivity.this.mWalletModel, HamamDetailAdapterActivity.this.bathspace, -1, hamamDetailBean.machineid, false);
                }
            });
            return view;
        }

        class ViewHolder {
            public TextView tvAddress;
            public TextView tvIdl;
            public TextView tvUse;
            public TextView yuyue;

            public ViewHolder(View view) {
                this.tvAddress = (TextView) view.findViewById(R.id.tv_address);
                this.tvUse = (TextView) view.findViewById(R.id.tv_yizhanyong);
                this.tvIdl = (TextView) view.findViewById(R.id.tv_weizhanyong);
                this.yuyue = (TextView) view.findViewById(R.id.btn_yuyue);
            }
        }
    }
}
