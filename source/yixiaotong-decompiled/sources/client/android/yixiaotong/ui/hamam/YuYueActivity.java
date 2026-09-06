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
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.hamam.HamamSpaceBean;
import client.android.yixiaotong.controller.bean.hamam.HamamYuYueBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapGridView;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class YuYueActivity extends BaseActivity {
    public static final String EXTRA_DETAIL = "extra_detail";
    public static final String EXTRA_INDEX = "extra_index";
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final String EXTRA_YUYUESUCCESS = "extra_yuyuesuccess";
    private HamamDetailAdapter hamamDetailAdapter;
    WrapGridView mGrid;
    private boolean mIsYuYueSuccess;
    private String mMachineid;
    private MaterialDialog mMaterialDialog;
    TitleBar mTitleBar;
    private WalletModel mWalletModel;
    Button mYuYuebtn;
    private String maid;
    private List<HamamSpaceBean> mHamamSpaceBean = new ArrayList();
    private int mReserveIndex = -1;
    private boolean mIsYUYueing = false;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7401);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, List<HamamSpaceBean> list, int i, String str, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) YuYueActivity.class).putExtra("extra_wallet", walletModel).putExtra(EXTRA_DETAIL, (Serializable) list).putExtra("extra_index", i).putExtra("extra_machineid", str).putExtra("extra_yuyuesuccess", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mGrid = (WrapGridView) findViewById(R.id.grid);
        this.mYuYuebtn = (Button) findViewById(R.id.yuyuebtn);
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
        this.mTitleBar.setTitleView("设备状态");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mYuYuebtn.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.YuYueActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                YuYueActivity yuYueActivity = YuYueActivity.this;
                yuYueActivity.yuyue(yuYueActivity.mReserveIndex);
            }
        });
        this.mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.hamam.YuYueActivity.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        if (this.mReserveIndex != -1) {
            this.mYuYuebtn.setText("预约成功");
            this.mYuYuebtn.setEnabled(false);
            this.mGrid.setEnabled(false);
            selectIsYuYue();
        }
        if (this.mIsYuYueSuccess) {
            this.mYuYuebtn.setText("预约成功");
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
            return YuYueActivity.this.mHamamSpaceBean.size();
        }

        @Override // android.widget.Adapter
        public HamamSpaceBean getItem(int i) {
            return (HamamSpaceBean) YuYueActivity.this.mHamamSpaceBean.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(YuYueActivity.this.getContext()).inflate(R.layout.hamam_yuyue_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            HamamSpaceBean hamamSpaceBean = (HamamSpaceBean) YuYueActivity.this.mHamamSpaceBean.get(i);
            for (int i2 = 0; i2 < YuYueActivity.this.mHamamSpaceBean.size(); i2++) {
                if (hamamSpaceBean.bathspaceIndex == YuYueActivity.this.mReserveIndex) {
                    viewHolder.img.setImageResource(R.mipmap.l_hamam_yixuan_da);
                } else if (hamamSpaceBean.status == 0) {
                    viewHolder.img.setImageResource(R.mipmap.l_hamam_keyuyue_da);
                } else {
                    viewHolder.img.setImageResource(R.mipmap.l_hamam_noyuyue_da);
                }
                viewHolder.no.setText(hamamSpaceBean.bathspaceIndex + "");
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public TextView no;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img_item);
                this.no = (TextView) view.findViewById(R.id.no);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yuyue(int i) {
        if (i != -1) {
            BusinessControllers.getInstance().getHamamYuYue(getLoginAccount(), LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid()), this.mMachineid, i + "", RandomUtils.getRandNumMaxStringNonO(6), new Listener<HamamYuYueBean>() { // from class: client.android.yixiaotong.ui.hamam.YuYueActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    YuYueActivity.this.showDialog("正在预约中");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, HamamYuYueBean hamamYuYueBean, Object... objArr) {
                    if (YuYueActivity.this.mIsEnable) {
                        YuYueActivity.this.dismissDialog();
                        if (hamamYuYueBean != null) {
                            YuYueActivity.this.mYuYuebtn.setText("预约成功");
                            YuYueActivity.this.mGrid.setEnabled(false);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    YuYueActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(YuYueActivity.this.getActivity(), clientException.getDetail());
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "请选择澡位");
    }

    private void selectIsYuYue() {
        String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().getHamamIsYuYue(getLoginAccount(), LocalBusinessStore.getHamamRoomId(getContext(), getLoginAccount().getUid()), randNumMaxStringNonO, new Listener<HamamYuYueBean>() { // from class: client.android.yixiaotong.ui.hamam.YuYueActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamYuYueBean hamamYuYueBean, Object... objArr) {
                if (hamamYuYueBean != null) {
                    if ((hamamYuYueBean.reservestatus == 1 || hamamYuYueBean.reservestatus == 2) && hamamYuYueBean.reservestatus == 2) {
                        YuYueActivity.this.mYuYuebtn.setText("预约成功");
                        YuYueActivity.this.mIsYuYueSuccess = true;
                    }
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
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content(str).progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.hamam.YuYueActivity.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }
}
