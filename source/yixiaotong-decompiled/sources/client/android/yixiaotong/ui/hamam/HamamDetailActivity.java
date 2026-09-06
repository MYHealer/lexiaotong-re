package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamSpaceBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamDetailActivity extends BaseActivity {
    public static final String EXTRA_INDEX = "extra_index";
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final String EXTRA_YUYUESUCCESS = "extra_yuyuesuccess";
    private HamamDetailAdapter hamamDetailAdapter;
    GridView mGrid;
    private boolean mIsYuYueSuccess;
    private String mMachineid;
    private MaterialDialog mMaterialDialog;
    RelativeLayout mRel;
    TitleBar mTitleBar;
    TextView mTvNoData;
    private WalletModel mWalletModel;
    private String maid;
    private int mReserveIndex = -1;
    private boolean mIsEnable = true;
    private List<HamamDetailListBean> mRecordListBeans = new ArrayList();
    private List<HamamSpaceBean> bathspace = new ArrayList();

    static {
        StubApp.interface11(7292);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, int i, String str, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamDetailActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_index", i).putExtra("extra_machineid", str).putExtra("extra_yuyuesuccess", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mGrid = (GridView) findViewById(R.id.grid);
        this.mTvNoData = (TextView) findViewById(R.id.tv_nodata);
        this.mRel = (RelativeLayout) findViewById(R.id.rel);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备详情");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                HamamDetailListBean hamamDetailListBean = (HamamDetailListBean) adapterView.getAdapter().getItem(i);
                if (hamamDetailListBean.repeater == null || hamamDetailListBean.repeater.size() < 1 || HamamDetailActivity.this.mReserveIndex != -1) {
                    return;
                }
                HamamDetailAdapterActivity.launch(HamamDetailActivity.this.getActivity(), HamamDetailActivity.this.mWalletModel, HamamDetailActivity.this.mRecordListBeans);
                HamamDetailActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getAid();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void getAid() {
        BusinessControllers.getInstance().entranceGuardGetAreaInfo(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<List<AmmeterAreaInfo>>() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                HamamDetailActivity.this.showDialog("加载中...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AmmeterAreaInfo> list, Object... objArr) {
                if (HamamDetailActivity.this.mIsEnable) {
                    if (list != null) {
                        HamamDetailActivity.this.maid = list.get(0).id;
                        HamamDetailActivity.this.initData();
                    } else {
                        HamamDetailActivity.this.dismissDialog();
                        HamamDetailActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamDetailActivity.this.mIsEnable) {
                    HamamDetailActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(HamamDetailActivity.this.getActivity(), HamamDetailActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        BusinessControllers.getInstance().getHamamDetail(getLoginAccount(), "", getLoginAccount().getAccountManagetStore().getUserInfo().GenderId, LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid()), new Listener<List<HamamDetailListBean>>() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HamamDetailListBean> list, Object... objArr) {
                if (HamamDetailActivity.this.mIsEnable) {
                    HamamDetailActivity.this.dismissDialog();
                    if (list != null) {
                        if (list.size() > 0) {
                            HamamDetailActivity.this.mRecordListBeans.clear();
                            HamamDetailActivity.this.mRecordListBeans = list;
                            HamamDetailActivity.this.hamamDetailAdapter.notifyDataSetChanged();
                        } else {
                            HamamDetailActivity.this.mRel.setVisibility(8);
                            HamamDetailActivity.this.mTvNoData.setVisibility(0);
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamDetailActivity.this.mIsEnable) {
                    HamamDetailActivity.this.dismissDialog();
                    ErrorUtil.onFailResult(HamamDetailActivity.this.getActivity(), HamamDetailActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
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
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content(str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailActivity.4
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
            return HamamDetailActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public HamamDetailListBean getItem(int i) {
            return (HamamDetailListBean) HamamDetailActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HamamDetailActivity.this.getContext()).inflate(R.layout.hamam_detail_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final HamamDetailListBean hamamDetailListBean = (HamamDetailListBean) HamamDetailActivity.this.mRecordListBeans.get(i);
            if (hamamDetailListBean.repeater.size() > 0) {
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < hamamDetailListBean.repeater.size(); i4++) {
                    i2 += hamamDetailListBean.repeater.get(i4).i42;
                    i3 += hamamDetailListBean.repeater.get(i4).i43;
                }
                viewHolder.tvUse.setText(i2 + "");
                viewHolder.tvIdl.setText(i3 + "");
            }
            viewHolder.tvAddress.setText(hamamDetailListBean.bhname);
            if (HamamDetailActivity.this.mReserveIndex != -1) {
                viewHolder.lin.setVisibility(0);
                viewHolder.btnyuyuestate.setVisibility(0);
            } else {
                viewHolder.lin.setVisibility(8);
                viewHolder.btnyuyuestate.setVisibility(8);
            }
            viewHolder.btnyuyuestate.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamDetailActivity.HamamDetailAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (!StringUtils.isNotEmpty(HamamDetailActivity.this.mMachineid) || hamamDetailListBean.repeater == null || hamamDetailListBean.repeater.size() <= 0) {
                        return;
                    }
                    for (int i5 = 0; i5 < hamamDetailListBean.repeater.size(); i5++) {
                        if (hamamDetailListBean.repeater.get(i5).machineid.equals(HamamDetailActivity.this.mMachineid)) {
                            HamamDetailActivity.this.bathspace = hamamDetailListBean.repeater.get(i5).bathspace;
                            YuYueActivity.launch(HamamDetailActivity.this.getActivity(), HamamDetailActivity.this.mWalletModel, HamamDetailActivity.this.bathspace, HamamDetailActivity.this.mReserveIndex, HamamDetailActivity.this.mMachineid, HamamDetailActivity.this.mIsYuYueSuccess);
                        }
                    }
                }
            });
            return view;
        }

        class ViewHolder {
            public Button btnyuyuestate;
            public RelativeLayout lin;
            public TextView tvAddress;
            public TextView tvIdl;
            public TextView tvUse;

            public ViewHolder(View view) {
                this.tvAddress = (TextView) view.findViewById(R.id.tv_address);
                this.tvUse = (TextView) view.findViewById(R.id.tv_yizhanyong);
                this.tvIdl = (TextView) view.findViewById(R.id.tv_weizhanyong);
                this.btnyuyuestate = (Button) view.findViewById(R.id.yuyuestate);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
            }
        }
    }
}
