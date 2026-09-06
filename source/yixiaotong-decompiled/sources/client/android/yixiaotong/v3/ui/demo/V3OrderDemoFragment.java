package client.android.yixiaotong.v3.ui.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderDetailBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bean.order.OrderDetailBean;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3OrderDemoFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private static final String TAG = "V3OrderDemoFragment";
    private RecordsAdapter mApdater;
    private ImageView mIvPayStateDrop;
    private ImageView mIvTimeDrop;
    private ImageView mIvTypeDrop;
    private LinearLayout mLinTitle;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private RelativeLayout mRelPay;
    private RelativeLayout mRelPayState;
    private RelativeLayout mRelType;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private View mTopView;
    private TextView mTvAppName;
    private TextView mTvErrorTip;
    private TextView mTvPayState;
    private TextView mTvTime;
    private TextView mTvTotalMoney;
    private View mVPopBg;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private int mSelectWay = 0;
    private boolean mIsEnable = true;
    private final List<Object> mRecordListBeans = new ArrayList();
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private List<String> mTypeList = new ArrayList();
    private List<String> mDateList = new ArrayList();
    private List<String> mPayStateList = new ArrayList();
    private int mTypeId = 1;
    private int mSelectTypeIndex = 0;
    private int mSelectDateIndex = 0;
    private int mSelectPayStateIndex = 0;
    private int mCurrentPage = 1;
    private boolean mIsNeedLoadOrder = true;
    private PayState mPayState = PayState.pay;
    private boolean mIsError = false;

    private enum PayState {
        pay,
        nopay,
        refund
    }

    static /* synthetic */ void lambda$initClickListeners$3(View view) {
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public static V3OrderDemoFragment newInstance() {
        return new V3OrderDemoFragment();
    }

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.titleBar);
        this.mLinTitle = (LinearLayout) view.findViewById(R.id.lin_title);
        this.mLvRecord = (ListView) view.findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) view.findViewById(R.id.multiStateView);
        this.mRelType = (RelativeLayout) view.findViewById(R.id.rel_type);
        this.mRelPayState = (RelativeLayout) view.findViewById(R.id.rel_paystate);
        this.mTvAppName = (TextView) view.findViewById(R.id.tv_appname);
        this.mIvTypeDrop = (ImageView) view.findViewById(R.id.iv_typedrop);
        this.mTvTime = (TextView) view.findViewById(R.id.tv_time);
        this.mIvTimeDrop = (ImageView) view.findViewById(R.id.iv_timedrop);
        this.mTvPayState = (TextView) view.findViewById(R.id.tv_paystate);
        this.mIvPayStateDrop = (ImageView) view.findViewById(R.id.iv_paydrop);
        this.mTopView = view.findViewById(R.id.v_line);
        this.mVPopBg = view.findViewById(R.id.v_popbg);
        this.mRelPay = (RelativeLayout) view.findViewById(R.id.rel_pay);
        this.mTvTotalMoney = (TextView) view.findViewById(R.id.tv_totalmoney);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_order_demo, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        initTitleBar();
        initData();
        this.myPopWindow = new MyPopWindow(getContext());
        initView();
        initListener();
        EventBus.getDefault().register(this);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备消费订单");
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_type).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m356xc8167121(view2);
            }
        });
        view.findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m357x55038840(view2);
            }
        });
        view.findViewById(R.id.rel_paystate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m358xe1f09f5f(view2);
            }
        });
        view.findViewById(R.id.btn_pay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3OrderDemoFragment.lambda$initClickListeners$3(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-demo-V3OrderDemoFragment, reason: not valid java name */
    /* synthetic */ void m356xc8167121(View view) {
        selectType();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-V3OrderDemoFragment, reason: not valid java name */
    /* synthetic */ void m357x55038840(View view) {
        selectTime();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-demo-V3OrderDemoFragment, reason: not valid java name */
    /* synthetic */ void m358xe1f09f5f(View view) {
        selectPayState();
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index);
        if (uIVisableBean.index != 3) {
            this.mIsEnable = false;
        }
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume  " + this.mIsNeedLoadOrder + "  " + this.mPayState + "  " + this.mIsEnable);
        if (!this.mIsEnable || this.mIsError) {
            return;
        }
        this.mIsNeedLoadOrder = false;
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        LogUtil.e(TAG, "onPause  " + this.mIsNeedLoadOrder + "  " + this.mPayState);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V3OrderDemoFragment.this.mMultiStateView.setViewState(3);
                PayState unused = V3OrderDemoFragment.this.mPayState;
                PayState payState = PayState.nopay;
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V3OrderDemoFragment.this.mCurrentPage = 1;
                V3OrderDemoFragment.this.mTotalCount = 0;
                V3OrderDemoFragment.this.mRecordListBeans.clear();
                V3OrderDemoFragment.this.mApdater.notifyDataSetChanged();
                V3OrderDemoFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                V3OrderDemoFragment.this.mLoadMoreFootView.setNoMoreData("");
                V3OrderDemoFragment.this.mMultiStateView.setViewState(2);
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                PayState unused = V3OrderDemoFragment.this.mPayState;
                PayState payState = PayState.nopay;
            }
        });
    }

    private void initView() {
        if (this.mPayState == PayState.nopay) {
            this.mLinTitle.setVisibility(8);
        }
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.4
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    V3OrderDemoFragment.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    V3OrderDemoFragment.this.mSwipeRefreshLayout.setEnabled(false);
                }
                if (!V3OrderDemoFragment.this.mHasMoreData || i + i2 < i3 || i3 <= V3OrderDemoFragment.this.mTotalCount || i2 <= 1) {
                    return;
                }
                V3OrderDemoFragment.this.mCurrentPage++;
                V3OrderDemoFragment.this.mTotalCount = i3;
                PayState unused = V3OrderDemoFragment.this.mPayState;
                PayState payState = PayState.nopay;
                V3OrderDemoFragment.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mMultiStateView.setViewState(2);
    }

    private void initData() {
        this.mIsEnable = true;
        this.mTypeId = 1;
        this.mSelectTypeIndex = 0;
        this.mSelectDateIndex = 0;
        this.mSelectPayStateIndex = 0;
        this.mCurrentPage = 1;
        this.mPayState = PayState.pay;
        this.mAppDatas.clear();
        this.mTypeList.clear();
        this.mDateList.clear();
        this.mPayStateList.clear();
        this.mRecordListBeans.clear();
        this.mRelPay.setVisibility(8);
        TypeInfoBean typeInfoBean = new TypeInfoBean();
        TypeInfoBaseInfoBean typeInfoBaseInfoBean = new TypeInfoBaseInfoBean();
        typeInfoBaseInfoBean.appName = "洗澡";
        typeInfoBaseInfoBean.typeId = 1;
        typeInfoBean.base = typeInfoBaseInfoBean;
        this.mAppDatas.clear();
        this.mAppDatas.add(typeInfoBean);
        if (this.mAppDatas.size() > 0) {
            for (int i = 0; i < this.mAppDatas.size(); i++) {
                if (this.mTypeId != 0) {
                    if (this.mAppDatas.get(i).base.typeId == this.mTypeId) {
                        this.mTypeList.add(this.mAppDatas.get(i).base.appName);
                        this.mTypeId = this.mAppDatas.get(i).base.typeId;
                    }
                } else {
                    this.mTypeList.add(this.mAppDatas.get(i).base.appName);
                }
            }
            if (this.mTypeId == 0) {
                this.mTypeId = this.mAppDatas.get(0).base.typeId;
            }
            if (this.mTypeList.size() > 0) {
                this.mTvAppName.setText(this.mTypeList.get(0));
            }
        }
        this.mDateList.add("近七天");
        this.mDateList.add("近十五天");
        this.mDateList.add("近一个月");
        this.mDateList.add("近三个月");
        this.mDateList.add("全部");
        this.mTvTime.setText(this.mDateList.get(0));
        this.mPayStateList.add("已支付");
        this.mPayStateList.add("未支付");
        this.mTvPayState.setText(this.mPayStateList.get(0));
    }

    private void selectType() {
        LogUtil.e(TAG, this.mAppDatas.size() + "  " + this.mTypeList.size());
        if (this.mAppDatas.size() == this.mTypeList.size()) {
            initAnim(0.0f, 180.0f);
            this.mIvTypeDrop.startAnimation(this.rotate);
            backgroudAlpha();
            this.myPopWindow.showPop(this.mTopView, this.mSelectTypeIndex, this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.5
                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onShow(int i) {
                    V3OrderDemoFragment.this.mTvAppName.setText(((TypeInfoBean) V3OrderDemoFragment.this.mAppDatas.get(i)).base.appName);
                    LogUtil.e(V3OrderDemoFragment.TAG, "onShow:" + V3OrderDemoFragment.this.mSelectTypeIndex + "  " + i + PPSLabelView.Code + ((TypeInfoBean) V3OrderDemoFragment.this.mAppDatas.get(i)).base.appName);
                    if (V3OrderDemoFragment.this.mSelectTypeIndex != i) {
                        V3OrderDemoFragment v3OrderDemoFragment = V3OrderDemoFragment.this;
                        v3OrderDemoFragment.mTypeId = ((TypeInfoBean) v3OrderDemoFragment.mAppDatas.get(i)).base.typeId;
                        if (V3OrderDemoFragment.this.mTypeId != 20 && V3OrderDemoFragment.this.mPayState == PayState.refund) {
                            V3OrderDemoFragment.this.mTvPayState.setText((CharSequence) V3OrderDemoFragment.this.mPayStateList.get(0));
                            V3OrderDemoFragment.this.mPayState = PayState.pay;
                            V3OrderDemoFragment.this.mRelPay.setVisibility(8);
                        }
                        V3OrderDemoFragment.this.mRecordListBeans.clear();
                        V3OrderDemoFragment.this.mApdater.notifyDataSetChanged();
                        V3OrderDemoFragment.this.mTotalCount = 0;
                        V3OrderDemoFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                        V3OrderDemoFragment.this.mLoadMoreFootView.setNoMoreData("");
                        V3OrderDemoFragment.this.mCurrentPage = 1;
                        PayState unused = V3OrderDemoFragment.this.mPayState;
                        PayState payState = PayState.nopay;
                    }
                    V3OrderDemoFragment.this.mSelectTypeIndex = i;
                }

                @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                public void onDiss() {
                    V3OrderDemoFragment.this.mVPopBg.setVisibility(8);
                    V3OrderDemoFragment.this.initAnim(180.0f, 360.0f);
                    V3OrderDemoFragment.this.mIvTypeDrop.startAnimation(V3OrderDemoFragment.this.rotate);
                }
            });
        }
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectDateIndex, this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.6
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V3OrderDemoFragment.this.mTvTime.setText((CharSequence) V3OrderDemoFragment.this.mDateList.get(i));
                if (V3OrderDemoFragment.this.mSelectDateIndex != i) {
                    V3OrderDemoFragment.this.mRecordListBeans.clear();
                    V3OrderDemoFragment.this.mApdater.notifyDataSetChanged();
                    V3OrderDemoFragment.this.mTotalCount = 0;
                    V3OrderDemoFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                    V3OrderDemoFragment.this.mLoadMoreFootView.setNoMoreData("");
                    V3OrderDemoFragment.this.mCurrentPage = 1;
                    V3OrderDemoFragment.this.mSelectDateIndex = i;
                    PayState unused = V3OrderDemoFragment.this.mPayState;
                    PayState payState = PayState.nopay;
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V3OrderDemoFragment.this.mVPopBg.setVisibility(8);
                V3OrderDemoFragment.this.initAnim(180.0f, 360.0f);
                V3OrderDemoFragment.this.mIvTimeDrop.startAnimation(V3OrderDemoFragment.this.rotate);
            }
        });
    }

    private void selectPayState() {
        if (this.mTypeId == 20) {
            if (this.mAppDatas.get(this.mSelectTypeIndex).extendJson != null && this.mAppDatas.get(this.mSelectTypeIndex).extendJson.type == 1) {
                if (this.mPayStateList.size() <= 2) {
                    this.mPayStateList.add("退款");
                }
            } else if (this.mPayStateList.size() > 2) {
                this.mPayStateList.remove(2);
                this.mSelectPayStateIndex = 0;
            }
        } else if (this.mPayStateList.size() > 2) {
            this.mPayStateList.remove(2);
            this.mSelectPayStateIndex = 0;
        }
        initAnim(0.0f, 180.0f);
        this.mIvPayStateDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectPayStateIndex, this.mPayStateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3OrderDemoFragment.7
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                V3OrderDemoFragment.this.mTvPayState.setText((CharSequence) V3OrderDemoFragment.this.mPayStateList.get(i));
                if (V3OrderDemoFragment.this.mSelectPayStateIndex != i) {
                    V3OrderDemoFragment.this.mRecordListBeans.clear();
                    V3OrderDemoFragment.this.mApdater.notifyDataSetChanged();
                    V3OrderDemoFragment.this.mTotalCount = 0;
                    V3OrderDemoFragment.this.mSwipeRefreshLayout.setRefreshing(false);
                    V3OrderDemoFragment.this.mLoadMoreFootView.setNoMoreData("");
                    V3OrderDemoFragment.this.mCurrentPage = 1;
                    if (i == 2) {
                        V3OrderDemoFragment.this.mPayState = PayState.refund;
                    } else if (i == 1) {
                        V3OrderDemoFragment.this.mPayState = PayState.nopay;
                    } else {
                        V3OrderDemoFragment.this.mPayState = PayState.pay;
                        V3OrderDemoFragment.this.mRelPay.setVisibility(8);
                    }
                }
                V3OrderDemoFragment.this.mSelectPayStateIndex = i;
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                V3OrderDemoFragment.this.mVPopBg.setVisibility(8);
                V3OrderDemoFragment.this.initAnim(180.0f, 360.0f);
                V3OrderDemoFragment.this.mIvPayStateDrop.startAnimation(V3OrderDemoFragment.this.rotate);
            }
        });
    }

    private class RecordsAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private RecordsAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return V3OrderDemoFragment.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return V3OrderDemoFragment.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V3OrderDemoFragment.this.getContext()).inflate(R.layout.layout_orderrecord_item_v3, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tv_type.setText(V3OrderDemoFragment.this.mTvAppName.getText().toString());
            if (V3OrderDemoFragment.this.mPayState != PayState.nopay) {
                if (V3OrderDemoFragment.this.mTypeId == 20) {
                    DMOrderDetailBean dMOrderDetailBean = (DMOrderDetailBean) getItem(i);
                    viewHolder.tv_orderid.setText("订单号：" + dMOrderDetailBean.orderId);
                    if (V3OrderDemoFragment.this.mPayState == PayState.refund) {
                        viewHolder.tv_money.setText("¥" + DecimalUtil.divide(dMOrderDetailBean.chargeMoney + "", "100"));
                        if (StringUtils.isNotEmpty(dMOrderDetailBean.payDateTime)) {
                            viewHolder.tv_time.setText(dMOrderDetailBean.payDateTime);
                        } else {
                            viewHolder.tv_time.setText(dMOrderDetailBean.createDateTime);
                        }
                        if (dMOrderDetailBean.statusFlag == 2) {
                            viewHolder.tv_state.setText("订单退款成功");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.ffa1a6b3));
                        } else if (dMOrderDetailBean.statusFlag == 1) {
                            viewHolder.tv_state.setText("订单创建");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 3) {
                            viewHolder.tv_state.setText("订单退款失败");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        }
                    } else {
                        viewHolder.tv_money.setText("¥" + DecimalUtil.divide(dMOrderDetailBean.chargeMoney + "", "100"));
                        if (StringUtils.isNotEmpty(dMOrderDetailBean.payDateTime)) {
                            viewHolder.tv_time.setText(dMOrderDetailBean.payDateTime);
                        } else {
                            viewHolder.tv_time.setText(dMOrderDetailBean.createDateTime);
                        }
                        if (dMOrderDetailBean.statusFlag == 3) {
                            viewHolder.tv_state.setText("订单已充值");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.ffa1a6b3));
                        } else if (dMOrderDetailBean.statusFlag == 1) {
                            viewHolder.tv_state.setText("订单创建");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 2) {
                            viewHolder.tv_state.setText("订单支付");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 4) {
                            viewHolder.tv_state.setText("订单充值失败");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 5) {
                            viewHolder.tv_state.setText("订单已取消");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 6) {
                            viewHolder.tv_state.setText("订单已锁定");
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        } else if (dMOrderDetailBean.statusFlag == 7) {
                            viewHolder.tv_state.setText(V3OrderDemoFragment.this.getResources().getString(R.string.orderrefund));
                            viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                        }
                    }
                } else {
                    OrderDetailBean orderDetailBean = (OrderDetailBean) getItem(i);
                    viewHolder.tv_orderid.setText("订单号：" + orderDetailBean.orderId);
                    viewHolder.tv_money.setText("¥" + DecimalUtil.divide(orderDetailBean.posPrice + "", "100"));
                    viewHolder.tv_time.setText(orderDetailBean.posDateTime);
                    if (orderDetailBean.payCode == 1) {
                        viewHolder.tv_state.setText("已支付");
                        viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.ffa1a6b3));
                    } else {
                        viewHolder.tv_state.setText("待支付");
                        viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
                    }
                }
            } else {
                NoPayOrderBean noPayOrderBean = (NoPayOrderBean) getItem(i);
                viewHolder.tv_orderid.setText("订单号：" + noPayOrderBean.orderId);
                viewHolder.tv_money.setText("¥" + DecimalUtil.divide(noPayOrderBean.price + "", "100"));
                viewHolder.tv_time.setText(noPayOrderBean.posDateTime);
                viewHolder.tv_state.setText("待支付");
                viewHolder.tv_state.setTextColor(V3OrderDemoFragment.this.getResources().getColor(R.color.fff3382a));
            }
            return view;
        }

        class ViewHolder {
            public TextView tv_money;
            public TextView tv_orderid;
            public TextView tv_state;
            public TextView tv_time;
            public TextView tv_type;

            public ViewHolder(View view) {
                this.tv_orderid = (TextView) view.findViewById(R.id.tv_orderid);
                this.tv_type = (TextView) view.findViewById(R.id.tv_type);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_state = (TextView) view.findViewById(R.id.tv_state);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }

    private void backgroudAlpha() {
        this.mVPopBg.setVisibility(0);
    }
}
