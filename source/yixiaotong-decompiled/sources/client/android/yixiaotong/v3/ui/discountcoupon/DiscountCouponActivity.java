package client.android.yixiaotong.v3.ui.discountcoupon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
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
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.order.CouponBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DiscountCouponActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private RecordsAdapter mApdater;
    private ImageView mIvTimeDrop;
    private LoadMoreFooter mLoadMoreFootView;
    private ListView mLvRecord;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private View mTopView;
    private TextView mTvOutOfDate;
    private TextView mTvTime;
    private TextView mTvUseText;
    private TextView mTvUsedText;
    private View mVLineUse;
    private View mVLineUsed;
    private View mVOutOfDate;
    private View mVPopBg;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private int mSelectDateIndex = 0;
    private List<String> mDateList = new ArrayList();
    private final List<CouponBean> mRecordListBeans = new ArrayList();
    public int mState = 0;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(9928);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DiscountCouponActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvUseText = (TextView) findViewById(R.id.tv_usetext);
        this.mVLineUse = findViewById(R.id.v_lineuse);
        this.mTvUsedText = (TextView) findViewById(R.id.tv_usedtext);
        this.mVLineUsed = findViewById(R.id.v_lineused);
        this.mTvOutOfDate = (TextView) findViewById(R.id.tv_outofdate);
        this.mVOutOfDate = findViewById(R.id.v_outofdate);
        this.mIvTimeDrop = (ImageView) findViewById(R.id.iv_timedrop);
        this.mTopView = findViewById(R.id.v_line);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mVPopBg = findViewById(R.id.v_popbg);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.discountcoupon));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i == 0) {
                    DiscountCouponActivity.this.mSwipeRefreshLayout.setEnabled(true);
                } else {
                    DiscountCouponActivity.this.mSwipeRefreshLayout.setEnabled(false);
                }
            }
        });
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initListener() {
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DiscountCouponActivity.this.mMultiStateView.setViewState(3);
                DiscountCouponActivity.this.getRecords();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                DiscountCouponActivity.this.mRecordListBeans.clear();
                DiscountCouponActivity.this.mApdater.notifyDataSetChanged();
                DiscountCouponActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                DiscountCouponActivity.this.mLoadMoreFootView.setNoMoreData("");
                DiscountCouponActivity.this.getRecords();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.4
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                DiscountCouponActivity.this.getRecords();
            }
        });
    }

    private void initData() {
        this.mDateList.add(getResources().getString(R.string.nearlyservendays));
        this.mDateList.add(getResources().getString(R.string.nearlyfifteendays));
        this.mDateList.add(getResources().getString(R.string.nearlyamonth));
        this.mDateList.add(getResources().getString(R.string.nearlythreemonth));
        this.mDateList.add(getResources().getString(R.string.all));
        getRecords();
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

    private void initClickListeners() {
        findViewById(R.id.rel_use).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m370x38e3b2f5(view);
            }
        });
        findViewById(R.id.rel_used).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m371x1c0f6636(view);
            }
        });
        findViewById(R.id.rel_outofdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m372xff3b1977(view);
            }
        });
        findViewById(R.id.rel_time).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m373xe266ccb8(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-discountcoupon-DiscountCouponActivity, reason: not valid java name */
    /* synthetic */ void m370x38e3b2f5(View view) {
        initViewTop(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-discountcoupon-DiscountCouponActivity, reason: not valid java name */
    /* synthetic */ void m371x1c0f6636(View view) {
        initViewTop(1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-discountcoupon-DiscountCouponActivity, reason: not valid java name */
    /* synthetic */ void m372xff3b1977(View view) {
        initViewTop(2);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-discountcoupon-DiscountCouponActivity, reason: not valid java name */
    /* synthetic */ void m373xe266ccb8(View view) {
        selectTime();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Log.e("test", "onItemClick:" + i);
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        CouponDetailActivity.launch(getActivity(), this.mApdater.getItem(i), this.mState);
    }

    private void initViewTop(int i) {
        if (i == 0) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvUseText.setTextSize(16.0f);
            this.mVLineUse.setVisibility(0);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUsedText.setTextSize(15.0f);
            this.mVLineUsed.setVisibility(8);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvOutOfDate.setTextSize(15.0f);
            this.mVOutOfDate.setVisibility(8);
        } else if (i == 1) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUseText.setTextSize(15.0f);
            this.mVLineUse.setVisibility(8);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvUsedText.setTextSize(16.0f);
            this.mVLineUsed.setVisibility(0);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvOutOfDate.setTextSize(15.0f);
            this.mVOutOfDate.setVisibility(8);
        } else if (i == 2) {
            this.mTvUseText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUseText.setTextSize(15.0f);
            this.mVLineUse.setVisibility(8);
            this.mTvUsedText.setTextColor(getResources().getColor(R.color.ffa1a6b3));
            this.mTvUsedText.setTextSize(15.0f);
            this.mVLineUsed.setVisibility(8);
            this.mTvOutOfDate.setTextColor(getResources().getColor(R.color.ff242933));
            this.mTvOutOfDate.setTextSize(16.0f);
            this.mVOutOfDate.setVisibility(0);
        }
        if (this.mState != i) {
            this.mState = i;
            getRecords();
        }
    }

    private void selectTime() {
        initAnim(0.0f, 180.0f);
        this.mIvTimeDrop.startAnimation(this.rotate);
        backgroudAlpha();
        this.myPopWindow.showPop(this.mTopView, this.mSelectDateIndex, this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.5
            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onShow(int i) {
                DiscountCouponActivity.this.mTvTime.setText((CharSequence) DiscountCouponActivity.this.mDateList.get(i));
                if (DiscountCouponActivity.this.mSelectDateIndex != i) {
                    DiscountCouponActivity.this.mRecordListBeans.clear();
                    DiscountCouponActivity.this.mApdater.notifyDataSetChanged();
                    DiscountCouponActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                    DiscountCouponActivity.this.mLoadMoreFootView.setNoMoreData("");
                    DiscountCouponActivity.this.mSelectDateIndex = i;
                    DiscountCouponActivity.this.getRecords();
                }
            }

            @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
            public void onDiss() {
                DiscountCouponActivity.this.mVPopBg.setVisibility(8);
                DiscountCouponActivity.this.initAnim(180.0f, 360.0f);
                DiscountCouponActivity.this.mIvTimeDrop.startAnimation(DiscountCouponActivity.this.rotate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getRecords() {
        V3BusinessControllers.getInstance().getCouponList(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mState, this.mSelectDateIndex + 1, 1, 0, "", UserInfoUtilControl.getInstance().getStudentId(), new Listener<List<CouponBean>>() { // from class: client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DiscountCouponActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                DiscountCouponActivity.this.mLoadMoreFootView.setNoMoreData("");
                DiscountCouponActivity.this.mMultiStateView.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<CouponBean> list, Object... objArr) {
                if (DiscountCouponActivity.this.mIsEnable) {
                    DiscountCouponActivity.this.mMultiStateView.setViewState(0);
                    DiscountCouponActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    if (list != null) {
                        DiscountCouponActivity.this.mRecordListBeans.clear();
                        DiscountCouponActivity.this.mRecordListBeans.addAll(list);
                        DiscountCouponActivity.this.mApdater.notifyDataSetChanged();
                        if (list.size() == 0) {
                            DiscountCouponActivity.this.mMultiStateView.setViewState(2);
                            return;
                        }
                        return;
                    }
                    DiscountCouponActivity.this.mMultiStateView.setViewState(2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DiscountCouponActivity.this.mIsEnable) {
                    DiscountCouponActivity.this.mMultiStateView.setViewState(1);
                    DiscountCouponActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                    DiscountCouponActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private void backgroudAlpha() {
        this.mVPopBg.setVisibility(0);
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
            return DiscountCouponActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public CouponBean getItem(int i) {
            return (CouponBean) DiscountCouponActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DiscountCouponActivity.this.getContext()).inflate(R.layout.layout_item_coupon, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (DiscountCouponActivity.this.mState == 2) {
                viewHolder.rel_yhq.setBackgroundResource(R.mipmap.yhqgq);
            } else {
                viewHolder.rel_yhq.setBackgroundResource(R.mipmap.yhq);
            }
            CouponBean item = getItem(i);
            viewHolder.tv_money.setText(DecimalUtil.divide(item.discountAmount + "", "100"));
            viewHolder.tv_time.setText(item.startDate + x.A + item.endDate);
            viewHolder.tv_nametext.setText(item.couponName);
            List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
            if (investorInfosV3 != null && investorInfosV3.size() > 0) {
                for (int i2 = 0; i2 < investorInfosV3.size(); i2++) {
                    if (investorInfosV3.get(i2).investorInfo.investorId.equals(item.investorId)) {
                        viewHolder.tv_servername.setText(investorInfosV3.get(i2).investorInfo.providerJson.providerName);
                    }
                }
            }
            return view;
        }

        class ViewHolder {
            private RelativeLayout rel_yhq;
            public TextView tv_money;
            public TextView tv_nametext;
            public TextView tv_servername;
            public TextView tv_time;

            public ViewHolder(View view) {
                this.tv_nametext = (TextView) view.findViewById(R.id.tv_nametext);
                this.tv_money = (TextView) view.findViewById(R.id.tv_money);
                this.tv_time = (TextView) view.findViewById(R.id.tv_time);
                this.tv_servername = (TextView) view.findViewById(R.id.tv_servername);
                this.rel_yhq = (RelativeLayout) view.findViewById(R.id.rel_yhq);
            }
        }
    }
}
