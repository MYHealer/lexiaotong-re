package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.MessageBean;
import client.android.yixiaotong.controller.bean.MessageRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.event.MessageFragmentSyncEvent;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.EventBusUtil;
import client.android.yixiaotong.util.ListUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RechargeRecordActivity extends BaseActivity {
    public static final String EXTRA_TYPEID = "typeid";
    ImageView mImgSanjiaoxing;
    ImageView mImgSanjiaoxing2;
    private LayoutInflater mInflater;
    LinearLayout mLinAll;
    private LoadMoreFooter mLoadMoreFootView;
    private MessageAdapter mMessageAdapter;
    PullRefreshLayout mPullRefreshLayout;
    RelativeLayout mRel;
    RelativeLayout mRel2;
    TitleBar mTitlebar;
    View mTopView;
    TextView mTvAppName;
    TextView mTvDate2;
    TextView mTvErrorTip;
    private int mTypeId;
    Button mVBtnReload;
    MultiStateView mVLoadingview;
    View mView;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    ListView vLvMessage;
    private final List<MessageBean> mMessageBeans = new ArrayList();
    private int mStart = 0;
    private final int mLimit = 99;
    private String mNextMonth = "0";
    private boolean mIsEnable = true;
    private boolean mHasMoreData = false;
    private int mTotalCount = 0;
    private int mSelectIndex = 0;
    private int mSelectDateIndex = 0;
    private List<WalletModel> mWalletModels = new ArrayList();
    private List<String> mTypeList = new ArrayList();
    private List<String> mDateList = new ArrayList();

    static {
        StubApp.interface11(6013);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$1312(RechargeRecordActivity rechargeRecordActivity, int i) {
        int i2 = rechargeRecordActivity.mStart + i;
        rechargeRecordActivity.mStart = i2;
        return i2;
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.vLvMessage = (ListView) findViewById(R.id.v_lv_message);
        this.mVLoadingview = (MultiStateView) findViewById(R.id.v_loadingview);
        this.mVBtnReload = (Button) findViewById(R.id.btn_reload);
        this.mTvErrorTip = (TextView) findViewById(R.id.tv_errortip);
        this.mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.pullRefreshLayout);
        this.mRel = (RelativeLayout) findViewById(R.id.rel);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mImgSanjiaoxing = (ImageView) findViewById(R.id.img);
        this.mRel2 = (RelativeLayout) findViewById(R.id.rel2);
        this.mTvDate2 = (TextView) findViewById(R.id.tv_date2);
        this.mImgSanjiaoxing2 = (ImageView) findViewById(R.id.img2);
        this.mView = findViewById(R.id.view);
        this.mTopView = findViewById(R.id.v_view);
        this.mLinAll = (LinearLayout) findViewById(R.id.rel_all);
    }

    public static void launch(Activity activity, int i) {
        Intent intent = new Intent(activity, (Class<?>) RechargeRecordActivity.class);
        intent.putExtra(EXTRA_TYPEID, i);
        activity.startActivity(intent);
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
        this.mTitlebar.setTitleView("充值记录");
        this.mTitlebar.setLeftView(R.mipmap.back);
        this.mTitlebar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mInflater = LayoutInflater.from(getActivity());
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.vLvMessage.addFooterView(loadMoreFooter);
        MessageAdapter messageAdapter = new MessageAdapter();
        this.mMessageAdapter = messageAdapter;
        this.vLvMessage.setAdapter((ListAdapter) messageAdapter);
        this.vLvMessage.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!RechargeRecordActivity.this.mHasMoreData || i + i2 < i3 || i3 <= RechargeRecordActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                RechargeRecordActivity.this.mTotalCount = i3;
                RechargeRecordActivity.this.initData();
                RechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mVBtnReload.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRecordActivity.this.mVLoadingview.setViewState(3);
                RechargeRecordActivity.this.initData();
            }
        });
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRecordActivity.this.initAnim(0.0f, 180.0f);
                RechargeRecordActivity.this.mImgSanjiaoxing.startAnimation(RechargeRecordActivity.this.rotate);
                RechargeRecordActivity.this.backgroudAlpha();
                RechargeRecordActivity.this.myPopWindow.showPop(RechargeRecordActivity.this.mTopView, RechargeRecordActivity.this.mSelectIndex, RechargeRecordActivity.this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.3.1
                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onShow(int i) {
                        RechargeRecordActivity.this.mTvAppName.setText(((WalletModel) RechargeRecordActivity.this.mWalletModels.get(i)).name);
                        if (RechargeRecordActivity.this.mSelectIndex != i) {
                            RechargeRecordActivity.this.mTypeId = ((WalletModel) RechargeRecordActivity.this.mWalletModels.get(i)).typeId;
                            RechargeRecordActivity.this.mMessageBeans.clear();
                            RechargeRecordActivity.this.mMessageAdapter.notifyDataSetChanged();
                            RechargeRecordActivity.this.mStart = 0;
                            RechargeRecordActivity.this.mNextMonth = "0";
                            RechargeRecordActivity.this.mTotalCount = 0;
                            RechargeRecordActivity.this.initData();
                        }
                        RechargeRecordActivity.this.mSelectIndex = i;
                    }

                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onDiss() {
                        RechargeRecordActivity.this.mView.setVisibility(8);
                        RechargeRecordActivity.this.initAnim(180.0f, 360.0f);
                        RechargeRecordActivity.this.mImgSanjiaoxing.startAnimation(RechargeRecordActivity.this.rotate);
                    }
                });
            }
        });
        this.mRel2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RechargeRecordActivity.this.initAnim(0.0f, 180.0f);
                RechargeRecordActivity.this.mImgSanjiaoxing2.startAnimation(RechargeRecordActivity.this.rotate);
                RechargeRecordActivity.this.backgroudAlpha();
                RechargeRecordActivity.this.myPopWindow.showPop(RechargeRecordActivity.this.mTopView, RechargeRecordActivity.this.mSelectDateIndex, RechargeRecordActivity.this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.4.1
                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onShow(int i) {
                        if (i == RechargeRecordActivity.this.mDateList.size() - 1) {
                            RechargeRecordActivity.this.mTvDate2.setText((CharSequence) RechargeRecordActivity.this.mDateList.get(i));
                        } else {
                            RechargeRecordActivity.this.mTvDate2.setText("近" + ((String) RechargeRecordActivity.this.mDateList.get(i)));
                        }
                        if (RechargeRecordActivity.this.mSelectDateIndex != i) {
                            RechargeRecordActivity.this.mMessageBeans.clear();
                            RechargeRecordActivity.this.mMessageAdapter.notifyDataSetChanged();
                            RechargeRecordActivity.this.mStart = 0;
                            RechargeRecordActivity.this.mNextMonth = "0";
                            RechargeRecordActivity.this.mTotalCount = 0;
                            RechargeRecordActivity.this.mSelectDateIndex = i;
                            RechargeRecordActivity.this.initData();
                        }
                        RechargeRecordActivity.this.mSelectDateIndex = i;
                    }

                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onDiss() {
                        RechargeRecordActivity.this.mView.setVisibility(8);
                        RechargeRecordActivity.this.initAnim(180.0f, 360.0f);
                        RechargeRecordActivity.this.mImgSanjiaoxing2.startAnimation(RechargeRecordActivity.this.rotate);
                    }
                });
            }
        });
        if (this.mTypeId == 0) {
            this.mRel.setEnabled(true);
        } else {
            this.mRel.setEnabled(false);
            this.mImgSanjiaoxing.setVisibility(4);
        }
    }

    private void initListener() {
        this.mPullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.5
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RechargeRecordActivity.this.mStart = 0;
                RechargeRecordActivity.this.mNextMonth = "0";
                RechargeRecordActivity.this.mTotalCount = 0;
                RechargeRecordActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.6
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                RechargeRecordActivity.this.initData();
            }
        });
    }

    public void onEventMainThread(MessageFragmentSyncEvent messageFragmentSyncEvent) {
        this.mStart = 0;
        this.mNextMonth = "0";
        initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        BusinessControllers.getInstance().GetRechargeMessageList(getLoginAccount(), 0, 99, this.mNextMonth, this.mTypeId, new Listener<MessageRecordListBean>() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                RechargeRecordActivity.this.mHasMoreData = false;
                if (RechargeRecordActivity.this.mStart == 0) {
                    RechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData("");
                } else {
                    RechargeRecordActivity.this.mLoadMoreFootView.loadMoreData();
                }
                RechargeRecordActivity.this.mVLoadingview.getView(3);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MessageRecordListBean messageRecordListBean, Object... objArr) {
                super.onComplete(controller, messageRecordListBean, objArr);
                if (!RechargeRecordActivity.this.mIsEnable || RechargeRecordActivity.this.mVLoadingview == null || RechargeRecordActivity.this.mPullRefreshLayout == null) {
                    return;
                }
                RechargeRecordActivity.this.mVLoadingview.setViewState(0);
                RechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                if (messageRecordListBean != null) {
                    if (RechargeRecordActivity.this.mStart == 0) {
                        RechargeRecordActivity.this.mMessageBeans.clear();
                    }
                    if (RechargeRecordActivity.this.mStart == 0) {
                        RechargeRecordActivity.this.mMessageBeans.clear();
                        ListUtils.addList(RechargeRecordActivity.this.mMessageBeans, messageRecordListBean.Records);
                        if (RechargeRecordActivity.this.mMessageBeans.size() == 0) {
                            RechargeRecordActivity.this.mVLoadingview.setViewState(2);
                        }
                    } else {
                        ListUtils.addList(RechargeRecordActivity.this.mMessageBeans, messageRecordListBean.Records);
                    }
                    RechargeRecordActivity.this.mMessageAdapter.notifyDataSetChanged();
                    if ("-1".equals(messageRecordListBean.NextMonth)) {
                        RechargeRecordActivity.this.mLoadMoreFootView.setNoMoreData();
                        return;
                    }
                    RechargeRecordActivity.this.mHasMoreData = true;
                    RechargeRecordActivity.this.mNextMonth = messageRecordListBean.NextMonth;
                    RechargeRecordActivity.access$1312(RechargeRecordActivity.this, 1);
                    RechargeRecordActivity.this.mLoadMoreFootView.setVisibility(0);
                    RechargeRecordActivity.this.mLoadMoreFootView.reset();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (RechargeRecordActivity.this.mIsEnable) {
                    if (RechargeRecordActivity.this.mStart != 0 || RechargeRecordActivity.this.mVLoadingview == null) {
                        RechargeRecordActivity.this.mLoadMoreFootView.resetForFail();
                    } else {
                        RechargeRecordActivity.this.mVLoadingview.setViewState(1);
                        RechargeRecordActivity.this.mTvErrorTip.setText(clientException.getDetail());
                    }
                    if (RechargeRecordActivity.this.mPullRefreshLayout != null) {
                        RechargeRecordActivity.this.mPullRefreshLayout.setRefreshing(false);
                    }
                    SystemErrorTip.getInstance().showTipDialog(RechargeRecordActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    class MessageAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        MessageAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RechargeRecordActivity.this.mMessageBeans.size();
        }

        @Override // android.widget.Adapter
        public MessageBean getItem(int i) {
            return (MessageBean) RechargeRecordActivity.this.mMessageBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = RechargeRecordActivity.this.mInflater.inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            MessageBean messageBean = (MessageBean) RechargeRecordActivity.this.mMessageBeans.get(i);
            if (i == 0) {
                viewHolder.line.setVisibility(4);
            } else {
                viewHolder.line.setVisibility(0);
            }
            viewHolder.datetime.setText(TimeUtils.formatDateTime(messageBean.time));
            viewHolder.money.setText("+" + messageBean.amount);
            viewHolder.money.setTextColor(-13516164);
            String string = RechargeRecordActivity.this.mTvAppName.getText().toString();
            viewHolder.tvchongzhi.setText("充值金额");
            if (messageBean.paytype == 1) {
                viewHolder.chongzhistate.setText(string + "-微信充值");
            } else if (messageBean.paytype == 2) {
                viewHolder.chongzhistate.setText(string + "-支付宝充值");
            } else if (messageBean.paytype == 3) {
                viewHolder.chongzhistate.setText(string + "-银联充值");
            } else if (messageBean.paytype == 4) {
                viewHolder.chongzhistate.setText(string + "-龙支付充值");
            } else if (messageBean.paytype == 5) {
                viewHolder.chongzhistate.setText(string + "-后台充值");
            } else if (messageBean.paytype == 7) {
                viewHolder.chongzhistate.setText(string + "-农行充值");
            }
            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.MessageAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                }
            });
            return view;
        }
    }

    static class ViewHolder {
        public TextView chongzhistate;
        public TextView datetime;
        public RelativeLayout lin;
        public View line;
        public TextView money;
        public TextView tvchongzhi;

        public ViewHolder(View view) {
            this.line = view.findViewById(R.id.line1);
            this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
            this.money = (TextView) view.findViewById(R.id.tv_money);
            this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
            this.tvchongzhi = (TextView) view.findViewById(R.id.tv_xiaofei);
            this.lin = (RelativeLayout) view.findViewById(R.id.lin);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        EventBusUtil.getInstance().getCommonEventBus().unregister(this);
    }

    private void initWalletModel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.RechargeRecordActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                RechargeRecordActivity.this.setWalletData(list);
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
            int i2 = this.mTypeId;
            if (i2 != 0) {
                if (i2 == list.get(i).typeId) {
                    this.mWalletModels.add(list.get(i));
                }
            } else if (list.get(i).typeId != 7 && list.get(i).typeId != 9 && list.get(i).typeId != 10) {
                this.mWalletModels.add(list.get(i));
                this.mTypeList.add(list.get(i).name);
            }
        }
        if (this.mWalletModels.size() > 0) {
            this.mTypeId = this.mWalletModels.get(0).typeId;
            this.mTvAppName.setText(this.mWalletModels.get(0).name);
            initData();
        }
        this.mDateList.add("三天");
        this.mDateList.add("一周");
        this.mDateList.add("一个月");
        this.mDateList.add("三个月");
        this.mDateList.add("全部");
        this.mTvDate2.setText("全部");
        this.mRel2.setEnabled(false);
        this.mImgSanjiaoxing2.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroudAlpha() {
        this.mView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAnim(float f, float f2) {
        RotateAnimation rotateAnimation = new RotateAnimation(f, f2, 1, 0.5f, 1, 0.5f);
        this.rotate = rotateAnimation;
        rotateAnimation.setDuration(500L);
        this.rotate.setFillAfter(true);
    }
}
