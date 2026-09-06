package client.android.yixiaotong.ui;

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
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindRoomBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.event.BalanceSyncEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MessageFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    GridView mListView;
    private RechargeRecordAdapter mRechargeRecordAdapter;
    TitleBar mTitleBar;
    private List<WalletModel> mWalletModels = new ArrayList();

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mListView = (GridView) view.findViewById(R.id.lv_chongzhi);
    }

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_message, (ViewGroup) null);
        initViewNew(viewInflate);
        initTitleBar();
        initView();
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("充值中心");
    }

    private void initView() {
        this.mRechargeRecordAdapter = new RechargeRecordAdapter();
        this.mListView.setOnItemClickListener(this);
        this.mListView.setAdapter((ListAdapter) this.mRechargeRecordAdapter);
    }

    public void onEventMainThread(BalanceSyncEvent balanceSyncEvent) {
        initData();
    }

    private void initData() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.MessageFragment.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                MessageFragment.this.setWalletData(list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWalletData(List<WalletModel> list) {
        if (list == null) {
            return;
        }
        this.mWalletModels.clear();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).typeId != 9 && list.get(i).typeId != 10) {
                this.mWalletModels.add(list.get(i));
            }
        }
        this.mRechargeRecordAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        EventBusUtil.getInstance().getCommonEventBus().unregister(this);
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        EventBusUtil.getInstance().getCommonEventBus().register(this);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        initData();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        final WalletModel item = this.mRechargeRecordAdapter.getItem(i);
        if (item.typeId == 7) {
            BusinessControllers.getInstance().ammeterIsBindRoom(getLoginAccount(), item.typeId + "", getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", new Listener<AmmeterBindRoomBean>() { // from class: client.android.yixiaotong.ui.MessageFragment.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterBindRoomBean ammeterBindRoomBean, Object... objArr) {
                    if (StringUtils.isNotEmpty(ammeterBindRoomBean.machineid) && StringUtils.isNotEmpty(ammeterBindRoomBean.devicemac)) {
                        AmmeterWalletDetailActivity.launch(MessageFragment.this.getActivity(), item, ammeterBindRoomBean.devicemac, false, "", "", ammeterBindRoomBean.machineid);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (clientException.getCode() == 4048) {
                        ToastUtils.show(MessageFragment.this.getActivity(), "请先绑定宿舍！");
                        SelectAmmeterAddressActivity.launch(MessageFragment.this.getActivity(), 1, item);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(MessageFragment.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        } else if (item.typeId == 2) {
            ToastUtils.show(getContext(), "暂未开通，敬请期待");
        } else {
            WalletDetailActivity.launch(getActivity(), item);
        }
    }

    private class RechargeRecordAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RechargeRecordAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MessageFragment.this.mWalletModels.size();
        }

        @Override // android.widget.Adapter
        public WalletModel getItem(int i) {
            return (WalletModel) MessageFragment.this.mWalletModels.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(MessageFragment.this.getContext()).inflate(R.layout.recharge_record_item, viewGroup, false);
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
            } else if (item.typeId != 4) {
                if (item.typeId == 5) {
                    viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_yongcan);
                } else if (item.typeId == 6) {
                    viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_yinshui);
                } else if (item.typeId == 7) {
                    viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_chongdian);
                } else if (item.typeId == 8) {
                    viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_chuifeng);
                } else if (item.typeId != 10) {
                    if (item.typeId == 11) {
                        viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_zaotang);
                    } else if (item.typeId == 15) {
                        viewHolder.imageView.setImageResource(R.mipmap.duoyingyong);
                    } else if (item.typeId == 16) {
                        viewHolder.imageView.setImageResource(R.mipmap.l_chongzhi_dry);
                    } else if (item.typeId == 17) {
                        viewHolder.imageView.setImageResource(R.mipmap.l_init_qrcodebath);
                    } else if (item.typeId == 18) {
                        viewHolder.imageView.setImageResource(R.mipmap.l_main_yuanchuan);
                    }
                }
            }
            viewHolder.textView.setText(item.name);
            String strDivide = DecimalUtil.divide(item.getBalance() + "", "100");
            if (item.typeId == 7) {
                viewHolder.tvBalance.setCompoundDrawables(null, null, null, null);
                viewHolder.tvBalance.setText("预付费");
            } else {
                viewHolder.tvBalance.setText(DecimalUtil.twoDecimal(strDivide) + "");
            }
            return view;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView textView;
            public TextView tvBalance;

            public ViewHolder(View view) {
                this.imageView = (ImageView) view.findViewById(R.id.iv_appicon);
                this.textView = (TextView) view.findViewById(R.id.tv_appname);
                this.tvBalance = (TextView) view.findViewById(R.id.tv_balance);
            }
        }
    }
}
