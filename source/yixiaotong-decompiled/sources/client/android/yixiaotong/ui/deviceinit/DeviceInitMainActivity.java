package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.ammeter.AmmeterDataCollectionActivity;
import client.android.yixiaotong.ui.ammeter.HuaWeiScanActivity;
import client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity;
import client.android.yixiaotong.ui.widget.DrinkWaterDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInitMainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private InitAdapter mAdapter;
    private GridView mGridView;
    private TitleBar mTitleBar;
    private List<WalletModel> mWalletModels = new ArrayList();
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.9
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            PermissionUtil.requestPerssion(DeviceInitMainActivity.this.getActivity(), 1, DeviceInitMainActivity.this.permissionGrant);
        }
    };

    static {
        StubApp.interface11(6726);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceInitMainActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mGridView = (GridView) findViewById(R.id.gv_init);
    }

    private void initTitle() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("设备管理");
    }

    private void initView() {
        InitAdapter initAdapter = new InitAdapter();
        this.mAdapter = initAdapter;
        this.mGridView.setAdapter((ListAdapter) initAdapter);
        this.mGridView.setOnItemClickListener(this);
    }

    private void getWalletModels() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                for (WalletModel walletModel : list) {
                    if (AppAccountManager.getInstance().getAppManagerAccount(walletModel.typeId) == walletModel.typeId || (walletModel.typeId == 1 && DeviceInitMainActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1)) {
                        DeviceInitMainActivity.this.mWalletModels.add(walletModel);
                    }
                }
                DeviceInitMainActivity.this.mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        final WalletModel item = this.mAdapter.getItem(i);
        if (item.typeId == 1 || item.typeId == 6 || item.typeId == 11) {
            DeviceInitWayActivity.launch(getActivity(), item);
            return;
        }
        if (item.typeId == 7) {
            View viewInflate = View.inflate(getActivity(), R.layout.ammeter_select_operate, null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_init);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_set);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_destroy);
            TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_change);
            TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_rechargerecord);
            TextView textView6 = (TextView) viewInflate.findViewById(R.id.tv_chongzhi);
            TextView textView7 = (TextView) viewInflate.findViewById(R.id.tv_cancel);
            textView6.setVisibility(8);
            final DrinkWaterDialog drinkWaterDialog = new DrinkWaterDialog(getContext(), viewInflate, R.style.DrinkWateTextViewDialog);
            drinkWaterDialog.show();
            textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                    HuaWeiScanActivity.launch(DeviceInitMainActivity.this.getActivity(), item, 1);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                    SearchAmmeterActivity.launch(DeviceInitMainActivity.this.getActivity(), item, "", 2, 1);
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                    SearchAmmeterActivity.launch(DeviceInitMainActivity.this.getActivity(), item, "", 3, 1);
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                    AmmeterDataCollectionActivity.launch(DeviceInitMainActivity.this.getActivity(), item);
                }
            });
            textView5.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                    SearchAmmeterActivity.launch(DeviceInitMainActivity.this.getActivity(), item, "", 7, 1);
                }
            });
            textView6.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                }
            });
            textView7.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitMainActivity.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    drinkWaterDialog.dismiss();
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "设备暂不支持初始化");
    }

    private class InitAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private InitAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DeviceInitMainActivity.this.mWalletModels.size();
        }

        @Override // android.widget.Adapter
        public WalletModel getItem(int i) {
            return (WalletModel) DeviceInitMainActivity.this.mWalletModels.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DeviceInitMainActivity.this.getContext()).inflate(R.layout.init_item_layout, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            WalletModel item = getItem(i);
            if (item.typeId == 1) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_xizao);
            } else if (item.typeId == 2) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_gouwu);
            } else if (item.typeId == 3) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_xiyi);
            } else if (item.typeId == 4) {
                viewHolder.imageView.setImageResource(R.drawable.icon_pic_loding);
            } else if (item.typeId == 5) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_yongcan);
            } else if (item.typeId == 6) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_yinshui);
            } else if (item.typeId == 7) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_chongdian);
            } else if (item.typeId == 8) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_chuifeng);
            } else if (item.typeId == 9) {
                viewHolder.imageView.setImageResource(R.mipmap.l_init_sellcard);
            } else if (item.typeId == 10) {
                viewHolder.imageView.setImageResource(R.mipmap.l_init_menjin);
            } else if (item.typeId == 11) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_zaotang);
            } else if (item.typeId == 16) {
                viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_dry);
            }
            viewHolder.textView.setText(item.name);
            return view;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView textView;

            public ViewHolder(View view) {
                this.imageView = (ImageView) view.findViewById(R.id.iv_appicon);
                this.textView = (TextView) view.findViewById(R.id.tv_appname);
            }
        }
    }
}
