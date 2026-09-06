package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v3.bean.elecmeter.BindElecMeterRoomInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.ErrorControlUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterAddressActivity extends BaseActivity {
    public static final int REQUESTCODE = 1;
    private AddressAdapter mAddressAdapter;
    private BindElecMeterRoomInfoBean mBindElecMeterRoomInfoBean;
    private int mCode;
    private String mInvestorId;
    private ListView mListView;
    private LoadMoreFooter mLoadMoreFootView;
    private MultiStateView mMultiStateView;
    private String mSchoolId;
    private String mStudentId;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private TextView mTvErrorTip;
    private boolean mIsEnable = true;
    private List<BindElecMeterRoomInfoBean> mAreaListBeans = new ArrayList();

    static {
        StubApp.interface11(9314);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean) {
        if (activity != null) {
            activity.startActivityForResult(new Intent(activity, (Class<?>) ElecMeterAddressActivity.class).putExtra("code", i).putExtra("bean", bindElecMeterRoomInfoBean), 1);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mListView = (ListView) findViewById(R.id.list);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.selectadderss));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        ErrorControlUtil.getInstance().onPause();
    }

    private void initView() {
        this.mAddressAdapter = new AddressAdapter();
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BindElecMeterRoomInfoBean bindElecMeterRoomInfoBean = (BindElecMeterRoomInfoBean) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent();
                intent.putExtra("bean", bindElecMeterRoomInfoBean);
                ElecMeterAddressActivity elecMeterAddressActivity = ElecMeterAddressActivity.this;
                elecMeterAddressActivity.setResult(elecMeterAddressActivity.mCode, intent);
                ElecMeterAddressActivity.this.finish();
            }
        });
        this.mListView.setAdapter((ListAdapter) this.mAddressAdapter);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mListView.addFooterView(loadMoreFooter);
        this.mListView.setFooterDividersEnabled(false);
        this.mLoadMoreFootView.setVisibility(8);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ElecMeterAddressActivity.this.mMultiStateView.setViewState(3);
                ElecMeterAddressActivity.this.initRid();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                ElecMeterAddressActivity.this.initRid();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                ElecMeterAddressActivity.this.initRid();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRid() {
        int i = this.mCode;
        if (i == 1) {
            getRegionalListElecMeter();
            return;
        }
        if (i == 2) {
            getBuildingListElecMeter();
        } else if (i == 3) {
            getFloorListElecMeter();
        } else {
            if (i != 4) {
                return;
            }
            getRoomlListElecMeter();
        }
    }

    private void getRegionalListElecMeter() {
        V3BusinessControllers.getInstance().getRegionalListElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, 1, this.mStudentId, new Listener<List<BindElecMeterRoomInfoBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BindElecMeterRoomInfoBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(0);
                    ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        ElecMeterAddressActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    ElecMeterAddressActivity.this.mAreaListBeans.clear();
                    ElecMeterAddressActivity.this.mAreaListBeans = list;
                    ElecMeterAddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(1);
                    ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        ErrorControlUtil.getInstance().onError(ElecMeterAddressActivity.this.getLoginAccount(), clientException, ElecMeterAddressActivity.this.getActivity(), false, ElecMeterAddressActivity.this.mTitleBar.getTitleViewContent());
                    }
                }
            }
        });
    }

    private void getBuildingListElecMeter() {
        V3BusinessControllers.getInstance().getBuildingListElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, 1, this.mBindElecMeterRoomInfoBean.regionalCode, new Listener<List<BindElecMeterRoomInfoBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BindElecMeterRoomInfoBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(0);
                    ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        ElecMeterAddressActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    ElecMeterAddressActivity.this.mAreaListBeans.clear();
                    ElecMeterAddressActivity.this.mAreaListBeans = list;
                    ElecMeterAddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(1);
                    ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        ErrorControlUtil.getInstance().onError(ElecMeterAddressActivity.this.getLoginAccount(), clientException, ElecMeterAddressActivity.this.getActivity(), false, ElecMeterAddressActivity.this.mTitleBar.getTitleViewContent());
                    }
                }
            }
        });
    }

    private void getFloorListElecMeter() {
        V3BusinessControllers.getInstance().getFloorListElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, 1, this.mBindElecMeterRoomInfoBean.regionalCode, this.mBindElecMeterRoomInfoBean.buildingCode, new Listener<List<BindElecMeterRoomInfoBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BindElecMeterRoomInfoBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(0);
                    ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        ElecMeterAddressActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    ElecMeterAddressActivity.this.mAreaListBeans.clear();
                    ElecMeterAddressActivity.this.mAreaListBeans = list;
                    ElecMeterAddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(1);
                    ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        ErrorControlUtil.getInstance().onError(ElecMeterAddressActivity.this.getLoginAccount(), clientException, ElecMeterAddressActivity.this.getActivity(), false, ElecMeterAddressActivity.this.mTitleBar.getTitleViewContent());
                    }
                }
            }
        });
    }

    private void getRoomlListElecMeter() {
        V3BusinessControllers.getInstance().getRoomListElecMeter(getLoginAccount(), this.mSchoolId, this.mInvestorId, 1, this.mBindElecMeterRoomInfoBean.regionalCode, this.mBindElecMeterRoomInfoBean.buildingCode, this.mBindElecMeterRoomInfoBean.floorCode, new Listener<List<BindElecMeterRoomInfoBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.electricitymeter.ElecMeterAddressActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<BindElecMeterRoomInfoBean> list, Object... objArr) {
                super.onComplete(controller, list, objArr);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(0);
                    ElecMeterAddressActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list == null || list.size() <= 0) {
                        ElecMeterAddressActivity.this.mMultiStateView.setViewState(2);
                        return;
                    }
                    ElecMeterAddressActivity.this.mAreaListBeans.clear();
                    ElecMeterAddressActivity.this.mAreaListBeans = list;
                    ElecMeterAddressActivity.this.mAddressAdapter.notifyDataSetChanged();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ElecMeterAddressActivity.this.mIsEnable) {
                    ElecMeterAddressActivity.this.mMultiStateView.setViewState(1);
                    ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    if (clientException.isNeedTip(clientException.getCode())) {
                        ElecMeterAddressActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    } else {
                        ErrorControlUtil.getInstance().onError(ElecMeterAddressActivity.this.getLoginAccount(), clientException, ElecMeterAddressActivity.this.getActivity(), false, ElecMeterAddressActivity.this.mTitleBar.getTitleViewContent());
                    }
                }
            }
        });
    }

    private class AddressAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AddressAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ElecMeterAddressActivity.this.mAreaListBeans.size();
        }

        @Override // android.widget.Adapter
        public BindElecMeterRoomInfoBean getItem(int i) {
            return (BindElecMeterRoomInfoBean) ElecMeterAddressActivity.this.mAreaListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(ElecMeterAddressActivity.this.getContext()).inflate(R.layout.address_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BindElecMeterRoomInfoBean item = getItem(i);
            viewHolder.textView.setText("");
            if (ElecMeterAddressActivity.this.mCode != 1) {
                if (ElecMeterAddressActivity.this.mCode != 2) {
                    if (ElecMeterAddressActivity.this.mCode != 3) {
                        if (ElecMeterAddressActivity.this.mCode == 4) {
                            viewHolder.textView.setText(item.roomName);
                        }
                    } else {
                        viewHolder.textView.setText(item.floorName);
                    }
                } else {
                    viewHolder.textView.setText(item.buildingName);
                }
            } else {
                viewHolder.textView.setText(item.regionalName);
            }
            return view;
        }

        class ViewHolder {
            public TextView textView;

            public ViewHolder(View view) {
                this.textView = (TextView) view.findViewById(R.id.name);
            }
        }
    }
}
