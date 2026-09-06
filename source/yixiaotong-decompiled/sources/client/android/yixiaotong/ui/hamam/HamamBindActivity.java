package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterAreaInfo;
import client.android.yixiaotong.controller.bean.hamam.HamamBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamDetailListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.BindhamamDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamBindActivity extends BaseActivity {
    public static final String EXTRA_FROMSETPSW = "extra_fromsetpsw";
    public static final String EXTRA_WALLET = "extra_wallet";
    private HamamDetailAdapter hamamDetailAdapter;
    Button mBtnBind;
    GridView mGrid;
    private boolean mIsFromSetPSW;
    private PopupWindow mPopWindow;
    RelativeLayout mRel;
    TitleBar mTitleBar;
    TextView mTvAppName;
    TextView mTvQiehuan;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private String mRoomid = "";
    private String mId = "";
    private BindhamamDialogTip.BindDialogListener bindDialogListener = new BindhamamDialogTip.BindDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.2
        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
        public void onConfirm() {
            HamamBindActivity.this.bindHamam();
        }
    };
    private List<HamamDetailListBean> mRecordListBeans = new ArrayList();
    private int mSelectIndex = 0;
    popAdapter adapter = new popAdapter();
    List<AmmeterAreaInfo> ammeterAreaInfos = new ArrayList();

    static {
        StubApp.interface11(7283);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamBindActivity.class).putExtra("extra_wallet", walletModel).putExtra(EXTRA_FROMSETPSW, z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mGrid = (GridView) findViewById(R.id.grid);
        this.mRel = (RelativeLayout) findViewById(R.id.top);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mTvQiehuan = (TextView) findViewById(R.id.tv_qiehuan);
        this.mBtnBind = (Button) findViewById(R.id.v_btn_next);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("浴室绑定");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                HamamDetailListBean hamamDetailListBean = (HamamDetailListBean) adapterView.getAdapter().getItem(i);
                HamamBindActivity.this.mId = hamamDetailListBean.id;
                HamamBindActivity.this.hamamDetailAdapter.notifyDataSetChanged();
                HamamBindActivity.this.mBtnBind.setEnabled(true);
                HamamBindActivity.this.mBtnBind.setBackgroundResource(R.drawable.shape_blue_button_radius_normal);
            }
        });
    }

    private void initView() {
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamBindActivity.this.mId = "";
                HamamBindActivity.this.mBtnBind.setEnabled(false);
                HamamBindActivity.this.mBtnBind.setBackgroundResource(R.drawable.shape_dark_gray_button);
                HamamBindActivity hamamBindActivity = HamamBindActivity.this;
                hamamBindActivity.showPopupWindow(hamamBindActivity.mRel);
            }
        });
        this.mBtnBind.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNotEmpty(HamamBindActivity.this.mId)) {
                    new BindhamamDialogTip().showBindDialog(HamamBindActivity.this.getActivity(), HamamBindActivity.this.bindDialogListener, "是否绑定该浴室？绑定后解绑", "需等24小时后才能再次绑定", "暂不", "绑定");
                } else {
                    ToastUtils.show(HamamBindActivity.this.getContext(), "请选择要绑定的浴室");
                }
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    private void getAid() {
        BusinessControllers.getInstance().entranceGuardGetAreaInfo(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<List<AmmeterAreaInfo>>() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(HamamBindActivity.this.getActivity(), "加载中...", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AmmeterAreaInfo> list, Object... objArr) {
                if (HamamBindActivity.this.mIsEnable) {
                    if (list != null && list.size() > 0) {
                        HamamBindActivity.this.mTvAppName.setText(list.get(0).name);
                        HamamBindActivity.this.mRoomid = list.get(0).id;
                        HamamBindActivity.this.ammeterAreaInfos.clear();
                        HamamBindActivity.this.ammeterAreaInfos = list;
                        HamamBindActivity.this.adapter.notifyDataSetChanged();
                        HamamBindActivity.this.initData();
                        return;
                    }
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(HamamBindActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.5.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            HamamBindActivity.this.finish();
                        }
                    }, "获取澡堂区域信息失败");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamBindActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(HamamBindActivity.this.getActivity(), HamamBindActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().GenderId;
        LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid());
        BusinessControllers.getInstance().getHamamDetail(getLoginAccount(), this.mRoomid, i, "0", new Listener<List<HamamDetailListBean>>() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<HamamDetailListBean> list, Object... objArr) {
                if (HamamBindActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list == null || list.size() <= 0) {
                        return;
                    }
                    HamamBindActivity.this.mRecordListBeans.clear();
                    HamamBindActivity.this.mRecordListBeans = list;
                    HamamBindActivity.this.hamamDetailAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamBindActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(HamamBindActivity.this.getActivity(), HamamBindActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
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
            return HamamBindActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public HamamDetailListBean getItem(int i) {
            return (HamamDetailListBean) HamamBindActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(HamamBindActivity.this.getContext()).inflate(R.layout.hamam_bind_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            HamamDetailListBean hamamDetailListBean = (HamamDetailListBean) HamamBindActivity.this.mRecordListBeans.get(i);
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
            if (hamamDetailListBean.id == HamamBindActivity.this.mId) {
                viewHolder.btnyuyuestate.setImageResource(R.mipmap.l_hamam_select);
            } else {
                viewHolder.btnyuyuestate.setImageResource(R.mipmap.l_hamam_noselect);
            }
            return view;
        }

        class ViewHolder {
            public ImageView btnyuyuestate;
            public RelativeLayout lin;
            public TextView tvAddress;
            public TextView tvIdl;
            public TextView tvUse;

            public ViewHolder(View view) {
                this.tvAddress = (TextView) view.findViewById(R.id.tv_address);
                this.tvUse = (TextView) view.findViewById(R.id.tv_yizhanyong);
                this.tvIdl = (TextView) view.findViewById(R.id.tv_weizhanyong);
                this.btnyuyuestate = (ImageView) view.findViewById(R.id.yuyuestate);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow(View view) {
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopWindow.dismiss();
        }
        View viewInflate = getLayoutInflater().inflate(R.layout.listview_layout1, (ViewGroup) null);
        PopupWindow popupWindow2 = new PopupWindow(viewInflate);
        this.mPopWindow = popupWindow2;
        popupWindow2.setWidth(-1);
        this.mPopWindow.setHeight(-2);
        this.mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopWindow.setOutsideTouchable(true);
        this.mPopWindow.setFocusable(true);
        showAsDropDown(this.mPopWindow, view, 0, 0);
        ListView listView = (ListView) viewInflate.findViewById(R.id.list);
        listView.setAdapter((ListAdapter) this.adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.7
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                HamamBindActivity.this.mTvAppName.setText(HamamBindActivity.this.ammeterAreaInfos.get(i).name);
                HamamBindActivity.this.mPopWindow.dismiss();
                HamamBindActivity hamamBindActivity = HamamBindActivity.this;
                hamamBindActivity.mRoomid = hamamBindActivity.ammeterAreaInfos.get(i).id;
                HamamBindActivity.this.mRecordListBeans.clear();
                HamamBindActivity.this.hamamDetailAdapter.notifyDataSetChanged();
                HamamBindActivity.this.initData();
                HamamBindActivity.this.mSelectIndex = i;
            }
        });
    }

    private void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        popupWindow.setHeight(view.getResources().getDisplayMetrics().heightPixels - rect.bottom);
        popupWindow.showAsDropDown(view, i, i2);
    }

    class popAdapter extends BaseAdapter implements ListAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        popAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return HamamBindActivity.this.ammeterAreaInfos.size();
        }

        @Override // android.widget.Adapter
        public AmmeterAreaInfo getItem(int i) {
            return HamamBindActivity.this.ammeterAreaInfos.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(HamamBindActivity.this.getContext()).inflate(R.layout.chongzhi_popwindow, (ViewGroup) null);
            }
            View viewFindViewById = view.findViewById(R.id.line);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.tv_select);
            textView.setText(HamamBindActivity.this.ammeterAreaInfos.get(i).name);
            if (i == HamamBindActivity.this.mSelectIndex) {
                textView.setTextColor(-13516164);
                imageView.setVisibility(0);
            } else {
                textView.setTextColor(-10066330);
                imageView.setVisibility(4);
            }
            if (i == HamamBindActivity.this.ammeterAreaInfos.size() - 1) {
                viewFindViewById.setVisibility(0);
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindHamam() {
        RandomUtils.getRandNumMaxStringNonO(6);
        if (StringUtils.isNotEmpty(this.mId)) {
            BusinessControllers.getInstance().hamamBindingRoom(getLoginAccount(), this.mId, new Listener<HamamBindBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamBindActivity.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(HamamBindActivity.this.getActivity(), "正在绑定中..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, HamamBindBean hamamBindBean, Object... objArr) {
                    if (HamamBindActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        if (hamamBindBean != null) {
                            ToastUtils.show(HamamBindActivity.this.getActivity(), "浴室绑定成功！");
                            LocalBusinessStore.saveHamamRoomId(HamamBindActivity.this.getContext(), HamamBindActivity.this.getLoginAccount().getUid(), HamamBindActivity.this.mId);
                            if (HamamBindActivity.this.mIsFromSetPSW) {
                                HamamMainActivity.launch(HamamBindActivity.this.getActivity(), HamamBindActivity.this.mWalletModel);
                            }
                            HamamBindActivity.this.finish();
                            return;
                        }
                        ToastUtils.show(HamamBindActivity.this.getActivity(), "浴室绑定失败！");
                        HamamBindActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (HamamBindActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        if (clientException.getCode() == 4127) {
                            ToastUtils.show(HamamBindActivity.this.getActivity(), "浴室绑定成功");
                            if (HamamBindActivity.this.mIsFromSetPSW) {
                                HamamMainActivity.launch(HamamBindActivity.this.getActivity(), HamamBindActivity.this.mWalletModel);
                            }
                            LocalBusinessStore.saveHamamRoomId(HamamBindActivity.this.getContext(), HamamBindActivity.this.getLoginAccount().getUid(), clientException.getDetail());
                            HamamBindActivity.this.finish();
                            return;
                        }
                        ErrorUtil.onFailResult(HamamBindActivity.this.getActivity(), HamamBindActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                    }
                }
            });
        }
    }
}
