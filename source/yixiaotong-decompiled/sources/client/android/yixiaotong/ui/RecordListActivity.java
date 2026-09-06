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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.RecordBean;
import client.android.yixiaotong.controller.bean.RecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordBean;
import client.android.yixiaotong.controller.bean.SoundWaveCardRecordListBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterRecordListBean;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamRecordListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.adapter.MyPopWindow;
import client.android.yixiaotong.ui.bluetoothtwo.BathRecordDetailActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.hamam.HamamRecordDetailActivity;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.sellcard.SellCardRecordDetailActivity;
import client.android.yixiaotong.ui.wash.WashRecordDetailActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RecordListActivity extends BaseActivity {
    private RecordsAdapter mApdater;
    ImageView mImgSanjiaoxing;
    ImageView mImgSanjiaoxing2;
    LinearLayout mLinAll;
    private LoadMoreFooter mLoadMoreFootView;
    ListView mLvRecord;
    MultiStateView mMultiStateView;
    RelativeLayout mRel;
    RelativeLayout mRel2;
    PullRefreshLayout mSwipeRefreshLayout;
    TitleBar mTitlebar;
    View mTopView;
    TextView mTvAppName;
    TextView mTvDate2;
    TextView mTvErrorTip;
    private int mTypeId;
    View mView;
    private MyPopWindow myPopWindow;
    private RotateAnimation rotate;
    private boolean mHasMoreData = false;
    private final List<Object> mRecordListBeans = new ArrayList();
    private final int mPageSize = 200;
    private int mStart = 0;
    private String mNextMonth = "0";
    private int mTotalCount = 0;
    private String mBeforeMonth = "0";
    private boolean mIsEnable = true;
    private List<WalletModel> mWalletModels = new ArrayList();
    private List<String> mTypeList = new ArrayList();
    private List<String> mDateList = new ArrayList();
    private int mSelectIndex = 0;
    private int mSelectDateIndex = 4;

    static {
        StubApp.interface11(6043);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$1408(RecordListActivity recordListActivity) {
        int i = recordListActivity.mStart;
        recordListActivity.mStart = i + 1;
        return i;
    }

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
        this.mRel = (RelativeLayout) findViewById(R.id.rel);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mRel2 = (RelativeLayout) findViewById(R.id.rel2);
        this.mTvDate2 = (TextView) findViewById(R.id.tv_date2);
        this.mImgSanjiaoxing2 = (ImageView) findViewById(R.id.img2);
        this.mView = findViewById(R.id.view);
        this.mTopView = findViewById(R.id.v_view);
        this.mImgSanjiaoxing = (ImageView) findViewById(R.id.img);
        this.mLinAll = (LinearLayout) findViewById(R.id.rel_all);
    }

    public static void launch(Activity activity, int i) {
        Intent intent = new Intent(activity, (Class<?>) RecordListActivity.class);
        intent.putExtra("typeId", i);
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
        this.mTitlebar.setTitleView("消费记录");
        this.mTitlebar.setLeftViewIsBack();
        this.mTitlebar.setLeftViewOnClickBack(this);
    }

    private void initView() {
        initFooterView();
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (!RecordListActivity.this.mHasMoreData || i + i2 < i3 || i3 <= RecordListActivity.this.mTotalCount || i2 <= 1) {
                    return;
                }
                RecordListActivity.this.mTotalCount = i3;
                RecordListActivity.this.initData();
                RecordListActivity.this.mLoadMoreFootView.loadMoreData();
            }
        });
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.this.initAnim(0.0f, 180.0f);
                RecordListActivity.this.mImgSanjiaoxing.startAnimation(RecordListActivity.this.rotate);
                RecordListActivity.this.backgroudAlpha();
                RecordListActivity.this.myPopWindow.showPop(RecordListActivity.this.mTopView, RecordListActivity.this.mSelectIndex, RecordListActivity.this.mTypeList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.2.1
                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onShow(int i) {
                        RecordListActivity.this.mTvAppName.setText(((WalletModel) RecordListActivity.this.mWalletModels.get(i)).name);
                        if (RecordListActivity.this.mSelectIndex != i) {
                            RecordListActivity.this.mTypeId = ((WalletModel) RecordListActivity.this.mWalletModels.get(i)).typeId;
                            RecordListActivity.this.mRecordListBeans.clear();
                            RecordListActivity.this.mApdater.notifyDataSetChanged();
                            RecordListActivity.this.mStart = 0;
                            RecordListActivity.this.mNextMonth = "0";
                            RecordListActivity.this.mTotalCount = 0;
                            RecordListActivity.this.mBeforeMonth = "0";
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                            RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                            if (RecordListActivity.this.mTypeId == 6 || RecordListActivity.this.mTypeId == 8) {
                                RecordListActivity.this.mTvDate2.setText("近三天");
                                RecordListActivity.this.mRel2.setEnabled(true);
                                RecordListActivity.this.mImgSanjiaoxing2.setVisibility(0);
                                RecordListActivity.this.mSelectDateIndex = 0;
                            } else {
                                RecordListActivity.this.mTvDate2.setText("全部");
                                RecordListActivity.this.mRel2.setEnabled(false);
                                RecordListActivity.this.mImgSanjiaoxing2.setVisibility(4);
                                RecordListActivity.this.mImgSanjiaoxing2.clearAnimation();
                                RecordListActivity.this.mSelectDateIndex = 4;
                            }
                            RecordListActivity.this.initData();
                        }
                        RecordListActivity.this.mSelectIndex = i;
                    }

                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onDiss() {
                        RecordListActivity.this.mView.setVisibility(8);
                        RecordListActivity.this.initAnim(180.0f, 360.0f);
                        RecordListActivity.this.mImgSanjiaoxing.startAnimation(RecordListActivity.this.rotate);
                    }
                });
            }
        });
        this.mRel2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.this.initAnim(0.0f, 180.0f);
                RecordListActivity.this.mImgSanjiaoxing2.startAnimation(RecordListActivity.this.rotate);
                RecordListActivity.this.backgroudAlpha();
                RecordListActivity.this.myPopWindow.showPop(RecordListActivity.this.mTopView, RecordListActivity.this.mSelectDateIndex, RecordListActivity.this.mDateList, new MyPopWindow.MyPopWindowListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.3.1
                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onShow(int i) {
                        if (i == RecordListActivity.this.mDateList.size() - 1) {
                            RecordListActivity.this.mTvDate2.setText((CharSequence) RecordListActivity.this.mDateList.get(i));
                        } else {
                            RecordListActivity.this.mTvDate2.setText("近" + ((String) RecordListActivity.this.mDateList.get(i)));
                        }
                        if (RecordListActivity.this.mSelectDateIndex != i) {
                            RecordListActivity.this.mRecordListBeans.clear();
                            RecordListActivity.this.mApdater.notifyDataSetChanged();
                            RecordListActivity.this.mStart = 0;
                            RecordListActivity.this.mNextMonth = "0";
                            RecordListActivity.this.mTotalCount = 0;
                            RecordListActivity.this.mBeforeMonth = "0";
                            RecordListActivity.this.mSelectDateIndex = i;
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                            RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                            RecordListActivity.this.initData();
                        }
                        RecordListActivity.this.mSelectDateIndex = i;
                    }

                    @Override // client.android.yixiaotong.ui.adapter.MyPopWindow.MyPopWindowListener
                    public void onDiss() {
                        RecordListActivity.this.mView.setVisibility(8);
                        RecordListActivity.this.initAnim(180.0f, 360.0f);
                        RecordListActivity.this.mImgSanjiaoxing2.startAnimation(RecordListActivity.this.rotate);
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

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        this.mLvRecord.addFooterView(loadMoreFooter);
    }

    private void initWalletModel() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.RecordListActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                RecordListActivity.this.setWalletData(list);
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
            } else if (list.get(i).typeId != 7 && list.get(i).typeId != 10) {
                this.mTypeList.add(list.get(i).name);
                this.mWalletModels.add(list.get(i));
            }
        }
        this.mDateList.add("三天");
        this.mDateList.add("一周");
        this.mDateList.add("一个月");
        this.mDateList.add("三个月");
        this.mDateList.add("全部");
        if (this.mWalletModels.size() > 0) {
            int i3 = this.mTypeId;
            if (i3 == 6 || i3 == 8) {
                this.mTvDate2.setText("近三天");
                this.mRel2.setEnabled(true);
                this.mImgSanjiaoxing2.setVisibility(0);
                if (this.mWalletModels.size() == 1) {
                    this.mSelectDateIndex = 0;
                }
            } else {
                this.mTvDate2.setText("全部");
                this.mRel2.setEnabled(false);
                this.mImgSanjiaoxing2.setVisibility(4);
                this.mImgSanjiaoxing2.clearAnimation();
            }
        }
        if (this.mWalletModels.size() > 0) {
            this.mTypeId = this.mWalletModels.get(0).typeId;
            this.mTvAppName.setText(this.mWalletModels.get(0).name);
            initData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        getRecordList();
    }

    private void initListener() {
        this.mTvErrorTip = (TextView) this.mMultiStateView.getView(1).findViewById(R.id.tv_errortip);
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.this.mMultiStateView.setViewState(3);
                RecordListActivity.this.initData();
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.6
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                RecordListActivity.this.mStart = 0;
                RecordListActivity.this.mNextMonth = "0";
                RecordListActivity.this.mTotalCount = 0;
                RecordListActivity.this.mBeforeMonth = "0";
                RecordListActivity.this.mRecordListBeans.clear();
                RecordListActivity.this.mApdater.notifyDataSetChanged();
                RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                RecordListActivity.this.initData();
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.7
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
                RecordListActivity.this.initData();
            }
        });
    }

    private void getRecordList() {
        int i = this.mTypeId;
        if (i == 1 || i == 5) {
            BusinessControllers.getInstance().getRecordList(getLoginAccount(), this.mTypeId, this.mNextMonth, 0, 200, new Listener<RecordListBean>() { // from class: client.android.yixiaotong.ui.RecordListActivity.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    RecordListActivity.this.mHasMoreData = false;
                    if (RecordListActivity.this.mStart != 0 || RecordListActivity.this.mSwipeRefreshLayout == null) {
                        RecordListActivity.this.mLoadMoreFootView.loadMoreData();
                    } else {
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                    }
                    RecordListActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, RecordListBean recordListBean, Object... objArr) {
                    super.onComplete(controller, recordListBean, objArr);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 1 || RecordListActivity.this.mTypeId == 5) {
                            RecordListActivity.this.mMultiStateView.setViewState(0);
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            if (recordListBean != null) {
                                if (RecordListActivity.this.mStart == 0) {
                                    RecordListActivity.this.mRecordListBeans.clear();
                                    RecordListActivity.this.mRecordListBeans.addAll(recordListBean.getSortList());
                                } else {
                                    RecordListActivity.this.mRecordListBeans.addAll(recordListBean.getSortList());
                                }
                                RecordListActivity.this.mApdater.notifyDataSetChanged();
                                if (!"-1".equals(recordListBean.NextMonth)) {
                                    RecordListActivity.this.mHasMoreData = true;
                                    RecordListActivity.this.mNextMonth = recordListBean.NextMonth;
                                    RecordListActivity.access$1408(RecordListActivity.this);
                                    RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                    RecordListActivity.this.mLoadMoreFootView.reset();
                                } else {
                                    RecordListActivity.this.mLoadMoreFootView.setNoMoreData();
                                }
                                if (recordListBean.Total == 0) {
                                    RecordListActivity.this.mMultiStateView.setViewState(2);
                                }
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 1 || RecordListActivity.this.mTypeId == 5) {
                            if (RecordListActivity.this.mStart != 0) {
                                RecordListActivity.this.mLoadMoreFootView.resetForFail();
                            } else {
                                RecordListActivity.this.mMultiStateView.setViewState(1);
                                RecordListActivity.this.mTvErrorTip.setText(clientException.getDetail());
                            }
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            SystemErrorTip.getInstance().showTipDialog(RecordListActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                }
            });
            return;
        }
        if (i == 3 || i == 16) {
            BusinessControllers.getInstance().getWashRecordList(getLoginAccount(), this.mTypeId, this.mStart, "", "", "", new Listener<SoundWaveCardRecordListBean>() { // from class: client.android.yixiaotong.ui.RecordListActivity.9
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    RecordListActivity.this.mHasMoreData = false;
                    if (RecordListActivity.this.mStart != 0) {
                        RecordListActivity.this.mLoadMoreFootView.loadMoreData();
                    } else {
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                    }
                    RecordListActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SoundWaveCardRecordListBean soundWaveCardRecordListBean, Object... objArr) {
                    super.onComplete(controller, soundWaveCardRecordListBean, objArr);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 3 || RecordListActivity.this.mTypeId == 16) {
                            RecordListActivity.this.mMultiStateView.setViewState(0);
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            if (soundWaveCardRecordListBean != null) {
                                if (RecordListActivity.this.mStart == 0) {
                                    RecordListActivity.this.mRecordListBeans.clear();
                                    RecordListActivity.this.mRecordListBeans.addAll(soundWaveCardRecordListBean.getSortList());
                                } else {
                                    RecordListActivity.this.mRecordListBeans.addAll(soundWaveCardRecordListBean.getSortList());
                                }
                                RecordListActivity.this.mApdater.notifyDataSetChanged();
                                if (soundWaveCardRecordListBean.pageCount - 1 > soundWaveCardRecordListBean.pageIndex) {
                                    RecordListActivity.this.mHasMoreData = true;
                                    RecordListActivity.access$1408(RecordListActivity.this);
                                    RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                    RecordListActivity.this.mLoadMoreFootView.reset();
                                } else {
                                    RecordListActivity.this.mLoadMoreFootView.setNoMoreData();
                                }
                                if (soundWaveCardRecordListBean.count == 0) {
                                    RecordListActivity.this.mMultiStateView.setViewState(2);
                                }
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 3 || RecordListActivity.this.mTypeId == 16) {
                            if (RecordListActivity.this.mStart != 0) {
                                RecordListActivity.this.mLoadMoreFootView.resetForFail();
                            } else {
                                RecordListActivity.this.mMultiStateView.setViewState(1);
                                RecordListActivity.this.mTvErrorTip.setText(clientException.getDetail());
                            }
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            SystemErrorTip.getInstance().showTipDialog(RecordListActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                }
            });
            return;
        }
        if (i == 6 || i == 8) {
            BusinessControllers.getInstance().getDrinkWaterRecordList2(getLoginAccount(), this.mTypeId, this.mStart, this.mSelectDateIndex, this.mBeforeMonth, "", "", new Listener<SoundWaveDrinkWaterRecordListBean>() { // from class: client.android.yixiaotong.ui.RecordListActivity.10
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    RecordListActivity.this.mHasMoreData = false;
                    if (RecordListActivity.this.mRecordListBeans.size() != 0) {
                        RecordListActivity.this.mLoadMoreFootView.loadMoreData();
                    }
                    RecordListActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SoundWaveDrinkWaterRecordListBean soundWaveDrinkWaterRecordListBean, Object... objArr) {
                    super.onComplete(controller, soundWaveDrinkWaterRecordListBean, objArr);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 6 || RecordListActivity.this.mTypeId == 8) {
                            RecordListActivity.this.mMultiStateView.setViewState(0);
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            if (soundWaveDrinkWaterRecordListBean != null) {
                                RecordListActivity.this.mRecordListBeans.addAll(soundWaveDrinkWaterRecordListBean.getSortList());
                                if (soundWaveDrinkWaterRecordListBean.pageCount - 1 > soundWaveDrinkWaterRecordListBean.pageIndex) {
                                    RecordListActivity.this.mHasMoreData = true;
                                    RecordListActivity.access$1408(RecordListActivity.this);
                                    RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                    RecordListActivity.this.mLoadMoreFootView.reset();
                                    return;
                                }
                                if (RecordListActivity.this.mSelectDateIndex != 4 || !StringUtils.isNotEmpty(soundWaveDrinkWaterRecordListBean.beforeMonth) || soundWaveDrinkWaterRecordListBean.beforeMonth.length() <= 2) {
                                    RecordListActivity.this.mLoadMoreFootView.setNoMoreData();
                                    if (RecordListActivity.this.mRecordListBeans.size() == 0) {
                                        RecordListActivity.this.mMultiStateView.setViewState(2);
                                        return;
                                    }
                                    return;
                                }
                                RecordListActivity.this.mHasMoreData = true;
                                RecordListActivity.this.mStart = 0;
                                RecordListActivity.this.mBeforeMonth = soundWaveDrinkWaterRecordListBean.beforeMonth;
                                RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                RecordListActivity.this.mLoadMoreFootView.reset();
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (RecordListActivity.this.mIsEnable) {
                        if (RecordListActivity.this.mTypeId == 6 || RecordListActivity.this.mTypeId == 8) {
                            if (RecordListActivity.this.mStart != 0) {
                                RecordListActivity.this.mLoadMoreFootView.resetForFail();
                            } else {
                                RecordListActivity.this.mMultiStateView.setViewState(1);
                                RecordListActivity.this.mTvErrorTip.setText(clientException.getDetail());
                            }
                            RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                            SystemErrorTip.getInstance().showTipDialog(RecordListActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                }
            });
            return;
        }
        if (i == 9) {
            BusinessControllers.getInstance().getCardSalesList(getLoginAccount(), this.mTypeId, this.mStart, "", "", new Listener<SoundWaveCardRecordListBean>() { // from class: client.android.yixiaotong.ui.RecordListActivity.11
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    RecordListActivity.this.mHasMoreData = false;
                    if (RecordListActivity.this.mStart != 0) {
                        RecordListActivity.this.mLoadMoreFootView.loadMoreData();
                    } else {
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                    }
                    RecordListActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SoundWaveCardRecordListBean soundWaveCardRecordListBean, Object... objArr) {
                    super.onComplete(controller, soundWaveCardRecordListBean, objArr);
                    if (RecordListActivity.this.mIsEnable && RecordListActivity.this.mTypeId == 9) {
                        RecordListActivity.this.mMultiStateView.setViewState(0);
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (soundWaveCardRecordListBean != null) {
                            if (RecordListActivity.this.mStart == 0) {
                                RecordListActivity.this.mRecordListBeans.clear();
                                RecordListActivity.this.mRecordListBeans.addAll(soundWaveCardRecordListBean.getSortList());
                            } else {
                                RecordListActivity.this.mRecordListBeans.addAll(soundWaveCardRecordListBean.getSortList());
                            }
                            RecordListActivity.this.mApdater.notifyDataSetChanged();
                            if (soundWaveCardRecordListBean.pageCount - 1 > soundWaveCardRecordListBean.pageIndex) {
                                RecordListActivity.this.mHasMoreData = true;
                                RecordListActivity.access$1408(RecordListActivity.this);
                                RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                RecordListActivity.this.mLoadMoreFootView.reset();
                            } else {
                                RecordListActivity.this.mLoadMoreFootView.setNoMoreData();
                            }
                            if (soundWaveCardRecordListBean.count == 0) {
                                RecordListActivity.this.mMultiStateView.setViewState(2);
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (RecordListActivity.this.mIsEnable && RecordListActivity.this.mTypeId == 9) {
                        if (RecordListActivity.this.mStart != 0) {
                            RecordListActivity.this.mLoadMoreFootView.resetForFail();
                        } else {
                            RecordListActivity.this.mMultiStateView.setViewState(1);
                            RecordListActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        }
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        SystemErrorTip.getInstance().showTipDialog(RecordListActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
            return;
        }
        if (i == 11) {
            int i2 = this.mStart;
            if (i2 == 0) {
                this.mStart = i2 + 1;
            }
            BusinessControllers.getInstance().getHamamRecordList(getLoginAccount(), this.mStart, new Listener<HamamRecordListBean>() { // from class: client.android.yixiaotong.ui.RecordListActivity.12
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    RecordListActivity.this.mHasMoreData = false;
                    if (RecordListActivity.this.mStart != 1 || RecordListActivity.this.mSwipeRefreshLayout == null) {
                        RecordListActivity.this.mLoadMoreFootView.loadMoreData();
                    } else {
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(true);
                        RecordListActivity.this.mLoadMoreFootView.setNoMoreData("");
                    }
                    RecordListActivity.this.mMultiStateView.getView(3);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, HamamRecordListBean hamamRecordListBean, Object... objArr) {
                    super.onComplete(controller, hamamRecordListBean, objArr);
                    if (RecordListActivity.this.mIsEnable && RecordListActivity.this.mTypeId == 11) {
                        RecordListActivity.this.mMultiStateView.setViewState(0);
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        if (hamamRecordListBean != null) {
                            if (RecordListActivity.this.mStart == 1) {
                                RecordListActivity.this.mRecordListBeans.clear();
                                RecordListActivity.this.mRecordListBeans.addAll(hamamRecordListBean.Records);
                            } else {
                                RecordListActivity.this.mRecordListBeans.addAll(hamamRecordListBean.Records);
                            }
                            RecordListActivity.this.mApdater.notifyDataSetChanged();
                            if (hamamRecordListBean.totalPage > hamamRecordListBean.currentPage) {
                                RecordListActivity.this.mHasMoreData = true;
                                RecordListActivity.access$1408(RecordListActivity.this);
                                RecordListActivity.this.mLoadMoreFootView.setVisibility(0);
                                RecordListActivity.this.mLoadMoreFootView.reset();
                            } else {
                                RecordListActivity.this.mLoadMoreFootView.setNoMoreData();
                            }
                            if (hamamRecordListBean.totalRecord == 0) {
                                RecordListActivity.this.mMultiStateView.setViewState(2);
                            }
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (RecordListActivity.this.mIsEnable && RecordListActivity.this.mTypeId == 11) {
                        if (RecordListActivity.this.mStart != 1) {
                            RecordListActivity.this.mLoadMoreFootView.resetForFail();
                        } else {
                            RecordListActivity.this.mMultiStateView.setViewState(1);
                            RecordListActivity.this.mTvErrorTip.setText(clientException.getDetail());
                        }
                        RecordListActivity.this.mSwipeRefreshLayout.setRefreshing(false);
                        SystemErrorTip.getInstance().showTipDialog(RecordListActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
            return;
        }
        this.mMultiStateView.setViewState(2);
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
            return RecordListActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return RecordListActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            final ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(RecordListActivity.this.getContext()).inflate(R.layout.wash_record_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            if (i == 0) {
                viewHolder.line.setVisibility(4);
            } else {
                viewHolder.line.setVisibility(0);
            }
            if (RecordListActivity.this.mTypeId != 1) {
                if (RecordListActivity.this.mTypeId != 5) {
                    if (RecordListActivity.this.mTypeId != 6) {
                        if (RecordListActivity.this.mTypeId != 8) {
                            if (RecordListActivity.this.mTypeId != 3) {
                                if (RecordListActivity.this.mTypeId != 16) {
                                    if (RecordListActivity.this.mTypeId != 9) {
                                        if (RecordListActivity.this.mTypeId == 11) {
                                            final HamamRecordBean hamamRecordBean = (HamamRecordBean) RecordListActivity.this.mRecordListBeans.get(i);
                                            if (StringUtils.isNotEmpty(hamamRecordBean.pay)) {
                                                viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.pay + "", "100")));
                                            }
                                            final String strTwoDecimal = DecimalUtil.twoDecimal(DecimalUtil.divide(hamamRecordBean.i42 + "", AdnConfig.b.hnadsa));
                                            if (hamamRecordBean.sysflag == 1) {
                                                viewHolder.chongzhistate.setText("公共浴室-未结算");
                                                if (StringUtils.isNotEmpty(hamamRecordBean.posDatetime)) {
                                                    viewHolder.datetime.setText(TimeUtils.formatDateTime(Long.parseLong(hamamRecordBean.posDatetime)));
                                                }
                                            } else if (hamamRecordBean.sysflag == 2) {
                                                viewHolder.chongzhistate.setText("公共浴室-已结算");
                                                if (StringUtils.isNotEmpty(hamamRecordBean.payDatetime)) {
                                                    viewHolder.datetime.setText(TimeUtils.formatDateTime(Long.parseLong(hamamRecordBean.payDatetime)));
                                                }
                                            } else {
                                                viewHolder.chongzhistate.setText("公共浴室-未知");
                                            }
                                            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.13
                                                @Override // android.view.View.OnClickListener
                                                public void onClick(View view2) {
                                                    HamamRecordDetailActivity.launch(RecordListActivity.this.getActivity(), viewHolder.money.getText().toString(), viewHolder.datetime.getText().toString(), hamamRecordBean.orderid, strTwoDecimal, hamamRecordBean.sysflag);
                                                }
                                            });
                                        }
                                    } else {
                                        final SoundWaveCardRecordBean soundWaveCardRecordBean = (SoundWaveCardRecordBean) getItem(i);
                                        viewHolder.chongzhistate.setText("售卡-未知");
                                        if (StringUtils.isNotEmpty(soundWaveCardRecordBean.realPay) && StringUtils.isNotEmpty(soundWaveCardRecordBean.orderid)) {
                                            viewHolder.datetime.setText(soundWaveCardRecordBean.payDate + PPSLabelView.Code + soundWaveCardRecordBean.payTime);
                                            viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean.realPay, "100")));
                                            if (soundWaveCardRecordBean.sysflag == 0) {
                                                viewHolder.chongzhistate.setText("售卡-未支付");
                                            } else if (soundWaveCardRecordBean.sysflag == 1) {
                                                viewHolder.chongzhistate.setText("售卡-未激活");
                                            } else if (soundWaveCardRecordBean.sysflag == 2) {
                                                viewHolder.chongzhistate.setText("售卡-待校验");
                                            } else {
                                                viewHolder.chongzhistate.setText("售卡-已完成");
                                            }
                                        }
                                        viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.11
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view2) {
                                                if (!viewHolder.chongzhistate.getText().toString().equals("售卡-已完成") && !viewHolder.chongzhistate.getText().equals("售卡-未支付")) {
                                                    for (WalletModel walletModel : RecordListActivity.this.mWalletModels) {
                                                        if (walletModel.typeId == 9) {
                                                            if (AppUtils.isUserHuaWeiScan()) {
                                                                ScanQrcodeOrBarcodeActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean.orderid + "," + soundWaveCardRecordBean.realPay, 9);
                                                            } else {
                                                                ZxingScanActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean.orderid + "," + soundWaveCardRecordBean.realPay, 9);
                                                            }
                                                            RecordListActivity.this.getActivity().finish();
                                                        }
                                                    }
                                                    return;
                                                }
                                                if (viewHolder.chongzhistate.getText().toString().equals("售卡-已完成") || viewHolder.chongzhistate.getText().toString().equals("售卡-未支付")) {
                                                    SellCardRecordDetailActivity.launch(RecordListActivity.this.getActivity(), DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean.realPay, "100")), soundWaveCardRecordBean.payDate + PPSLabelView.Code + soundWaveCardRecordBean.payTime, soundWaveCardRecordBean.orderid, soundWaveCardRecordBean.sysflag);
                                                }
                                            }
                                        });
                                        viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.12
                                            @Override // android.view.View.OnLongClickListener
                                            public boolean onLongClick(View view2) {
                                                SellCardRecordDetailActivity.launch(RecordListActivity.this.getActivity(), DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean.realPay, "100")), soundWaveCardRecordBean.payDate + PPSLabelView.Code + soundWaveCardRecordBean.payTime, soundWaveCardRecordBean.orderid, soundWaveCardRecordBean.sysflag);
                                                return false;
                                            }
                                        });
                                    }
                                } else {
                                    final SoundWaveCardRecordBean soundWaveCardRecordBean2 = (SoundWaveCardRecordBean) getItem(i);
                                    if (StringUtils.isNotEmpty(soundWaveCardRecordBean2.payDate) && StringUtils.isNotEmpty(soundWaveCardRecordBean2.payTime) && StringUtils.isNotEmpty(soundWaveCardRecordBean2.realPay) && StringUtils.isNotEmpty(soundWaveCardRecordBean2.orderid)) {
                                        viewHolder.datetime.setText(soundWaveCardRecordBean2.payDate + PPSLabelView.Code + soundWaveCardRecordBean2.payTime);
                                        viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean2.realPay, "100")));
                                        if (soundWaveCardRecordBean2.sysflag == 1) {
                                            viewHolder.chongzhistate.setText("干衣-未激活");
                                        } else if (soundWaveCardRecordBean2.sysflag == 2) {
                                            viewHolder.chongzhistate.setText("干衣-待校验");
                                        } else {
                                            viewHolder.chongzhistate.setText("干衣-已完成");
                                        }
                                        viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.9
                                            @Override // android.view.View.OnClickListener
                                            public void onClick(View view2) {
                                                String str;
                                                if (!viewHolder.chongzhistate.getText().toString().equals("干衣-已完成")) {
                                                    for (WalletModel walletModel : RecordListActivity.this.mWalletModels) {
                                                        if (walletModel.typeId == 16) {
                                                            if (AppUtils.isUserHuaWeiScan()) {
                                                                ScanQrcodeOrBarcodeActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean2.orderid + "," + Integer.parseInt(soundWaveCardRecordBean2.realPay), 16);
                                                            } else {
                                                                ZxingScanActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean2.orderid + "," + Integer.parseInt(soundWaveCardRecordBean2.realPay), 16);
                                                            }
                                                        }
                                                    }
                                                    return;
                                                }
                                                String strTwoDecimal2 = DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean2.realPay, "100"));
                                                String str2 = soundWaveCardRecordBean2.payDate + PPSLabelView.Code + soundWaveCardRecordBean2.payTime;
                                                String str3 = soundWaveCardRecordBean2.orderid;
                                                if (soundWaveCardRecordBean2.i41 == 1) {
                                                    str = "从基本钱包划扣";
                                                } else if (soundWaveCardRecordBean2.i41 == 2) {
                                                    str = "从赠送钱包划扣";
                                                } else {
                                                    str = soundWaveCardRecordBean2.i41 == 3 ? "从周期钱包划扣" : "";
                                                }
                                                WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), RecordListActivity.this.mTypeId, strTwoDecimal2, str2, str3, str, soundWaveCardRecordBean2.sysflag, soundWaveCardRecordBean2.i42);
                                            }
                                        });
                                        viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.10
                                            @Override // android.view.View.OnLongClickListener
                                            public boolean onLongClick(View view2) {
                                                String str;
                                                String strTwoDecimal2 = DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean2.realPay, "100"));
                                                String str2 = soundWaveCardRecordBean2.payDate + PPSLabelView.Code + soundWaveCardRecordBean2.payTime;
                                                String str3 = soundWaveCardRecordBean2.orderid;
                                                if (soundWaveCardRecordBean2.i41 == 1) {
                                                    str = "从基本钱包划扣";
                                                } else if (soundWaveCardRecordBean2.i41 == 2) {
                                                    str = "从赠送钱包划扣";
                                                } else {
                                                    str = soundWaveCardRecordBean2.i41 == 3 ? "从周期钱包划扣" : "";
                                                }
                                                WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), RecordListActivity.this.mTypeId, strTwoDecimal2, str2, str3, str, soundWaveCardRecordBean2.sysflag, soundWaveCardRecordBean2.i42);
                                                return false;
                                            }
                                        });
                                    }
                                }
                            } else {
                                final SoundWaveCardRecordBean soundWaveCardRecordBean3 = (SoundWaveCardRecordBean) getItem(i);
                                if (StringUtils.isNotEmpty(soundWaveCardRecordBean3.payDate) && StringUtils.isNotEmpty(soundWaveCardRecordBean3.payTime) && StringUtils.isNotEmpty(soundWaveCardRecordBean3.realPay) && StringUtils.isNotEmpty(soundWaveCardRecordBean3.orderid)) {
                                    viewHolder.datetime.setText(soundWaveCardRecordBean3.payDate + PPSLabelView.Code + soundWaveCardRecordBean3.payTime);
                                    viewHolder.money.setText(x.A + DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean3.realPay, "100")));
                                    if (soundWaveCardRecordBean3.sysflag == 1) {
                                        viewHolder.chongzhistate.setText("洗衣-未激活");
                                    } else if (soundWaveCardRecordBean3.sysflag == 2) {
                                        viewHolder.chongzhistate.setText("洗衣-待校验");
                                    } else {
                                        viewHolder.chongzhistate.setText("洗衣-已完成");
                                    }
                                    viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.7
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view2) {
                                            String str;
                                            if (!viewHolder.chongzhistate.getText().toString().equals("洗衣-已完成")) {
                                                for (WalletModel walletModel : RecordListActivity.this.mWalletModels) {
                                                    if (walletModel.typeId == 3) {
                                                        if (AppUtils.isUserHuaWeiScan()) {
                                                            ScanQrcodeOrBarcodeActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean3.orderid + "," + Integer.parseInt(soundWaveCardRecordBean3.realPay), 3);
                                                        } else {
                                                            ZxingScanActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveCardRecordBean3.orderid + "," + Integer.parseInt(soundWaveCardRecordBean3.realPay), 3);
                                                        }
                                                    }
                                                }
                                                return;
                                            }
                                            String strTwoDecimal2 = DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean3.realPay, "100"));
                                            String str2 = soundWaveCardRecordBean3.payDate + PPSLabelView.Code + soundWaveCardRecordBean3.payTime;
                                            String str3 = soundWaveCardRecordBean3.orderid;
                                            if (soundWaveCardRecordBean3.i41 == 1) {
                                                str = "从基本钱包划扣";
                                            } else if (soundWaveCardRecordBean3.i41 == 2) {
                                                str = "从赠送钱包划扣";
                                            } else {
                                                str = soundWaveCardRecordBean3.i41 == 3 ? "从周期钱包划扣" : "";
                                            }
                                            WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), RecordListActivity.this.mTypeId, strTwoDecimal2, str2, str3, str, soundWaveCardRecordBean3.sysflag, soundWaveCardRecordBean3.i42);
                                        }
                                    });
                                    viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.8
                                        @Override // android.view.View.OnLongClickListener
                                        public boolean onLongClick(View view2) {
                                            String str;
                                            String strTwoDecimal2 = DecimalUtil.twoDecimal(DecimalUtil.divide(soundWaveCardRecordBean3.realPay, "100"));
                                            String str2 = soundWaveCardRecordBean3.payDate + PPSLabelView.Code + soundWaveCardRecordBean3.payTime;
                                            String str3 = soundWaveCardRecordBean3.orderid;
                                            if (soundWaveCardRecordBean3.i41 == 1) {
                                                str = "从基本钱包划扣";
                                            } else if (soundWaveCardRecordBean3.i41 == 2) {
                                                str = "从赠送钱包划扣";
                                            } else {
                                                str = soundWaveCardRecordBean3.i41 == 3 ? "从周期钱包划扣" : "";
                                            }
                                            WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), RecordListActivity.this.mTypeId, strTwoDecimal2, str2, str3, str, soundWaveCardRecordBean3.sysflag, soundWaveCardRecordBean3.i42);
                                            return false;
                                        }
                                    });
                                }
                            }
                        } else {
                            final SoundWaveDrinkWaterRecordBean soundWaveDrinkWaterRecordBean = (SoundWaveDrinkWaterRecordBean) getItem(i);
                            if (StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean.getPayDate()) && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean.getPayTime()) && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean.getRealPay() + "") && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean.getOrderid())) {
                                viewHolder.datetime.setText(soundWaveDrinkWaterRecordBean.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean.getPayTime());
                                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                                final String str = decimalFormat.format(((double) ((soundWaveDrinkWaterRecordBean.getRealPay() * 100) / 100)) / 100.0d);
                                viewHolder.money.setText(x.A + str);
                                if (soundWaveDrinkWaterRecordBean.getSysflag() == 1) {
                                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((soundWaveDrinkWaterRecordBean.getPayMoney() * 100) / 100)) / 100.0d));
                                    viewHolder.chongzhistate.setText("吹风-未激活");
                                } else if (soundWaveDrinkWaterRecordBean.getSysflag() == 2) {
                                    viewHolder.money.setText(x.A + decimalFormat.format(((double) ((soundWaveDrinkWaterRecordBean.getPayMoney() * 100) / 100)) / 100.0d));
                                    viewHolder.chongzhistate.setText("吹风-待校验");
                                } else {
                                    viewHolder.chongzhistate.setText("吹风-已完成");
                                }
                                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.5
                                    @Override // android.view.View.OnClickListener
                                    public void onClick(View view2) {
                                        String str2;
                                        String str3;
                                        if (soundWaveDrinkWaterRecordBean.getSysflag() == 1 || soundWaveDrinkWaterRecordBean.getSysflag() == 2) {
                                            for (WalletModel walletModel : RecordListActivity.this.mWalletModels) {
                                                if (walletModel.typeId == 8) {
                                                    ScanQrcodeOrBarcodeActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveDrinkWaterRecordBean.getOrderid(), 8);
                                                }
                                            }
                                            return;
                                        }
                                        String str4 = soundWaveDrinkWaterRecordBean.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean.getPayTime();
                                        String orderid = soundWaveDrinkWaterRecordBean.getOrderid();
                                        if (soundWaveDrinkWaterRecordBean.getI41() == 1) {
                                            str3 = "从基本钱包划扣";
                                        } else {
                                            if (soundWaveDrinkWaterRecordBean.getI41() != 2) {
                                                if (soundWaveDrinkWaterRecordBean.getI41() == 3) {
                                                    str3 = "从周期钱包划扣";
                                                } else {
                                                    str2 = "";
                                                }
                                                WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str, str4, orderid, str2, soundWaveDrinkWaterRecordBean.getSysflag(), soundWaveDrinkWaterRecordBean.payMoney + "");
                                            }
                                            str3 = "从赠送钱包划扣";
                                        }
                                        str2 = str3;
                                        WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str, str4, orderid, str2, soundWaveDrinkWaterRecordBean.getSysflag(), soundWaveDrinkWaterRecordBean.payMoney + "");
                                    }
                                });
                                viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.6
                                    @Override // android.view.View.OnLongClickListener
                                    public boolean onLongClick(View view2) {
                                        String str2;
                                        String str3;
                                        String str4 = soundWaveDrinkWaterRecordBean.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean.getPayTime();
                                        String orderid = soundWaveDrinkWaterRecordBean.getOrderid();
                                        if (soundWaveDrinkWaterRecordBean.getI41() == 1) {
                                            str3 = "从基本钱包划扣";
                                        } else {
                                            if (soundWaveDrinkWaterRecordBean.getI41() != 2) {
                                                if (soundWaveDrinkWaterRecordBean.getI41() == 3) {
                                                    str3 = "从周期钱包划扣";
                                                } else {
                                                    str2 = "";
                                                }
                                                WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str, str4, orderid, str2, soundWaveDrinkWaterRecordBean.getSysflag(), soundWaveDrinkWaterRecordBean.payMoney + "");
                                                return false;
                                            }
                                            str3 = "从赠送钱包划扣";
                                        }
                                        str2 = str3;
                                        WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str, str4, orderid, str2, soundWaveDrinkWaterRecordBean.getSysflag(), soundWaveDrinkWaterRecordBean.payMoney + "");
                                        return false;
                                    }
                                });
                            }
                        }
                    } else {
                        final SoundWaveDrinkWaterRecordBean soundWaveDrinkWaterRecordBean2 = (SoundWaveDrinkWaterRecordBean) getItem(i);
                        if (StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean2.getPayDate()) && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean2.getPayTime()) && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean2.getRealPay() + "") && StringUtils.isNotEmpty(soundWaveDrinkWaterRecordBean2.getOrderid())) {
                            viewHolder.datetime.setText(soundWaveDrinkWaterRecordBean2.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean2.getPayTime());
                            DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
                            final String str2 = decimalFormat2.format(((double) ((soundWaveDrinkWaterRecordBean2.getRealPay() * 100) / 100)) / 100.0d);
                            viewHolder.money.setText(x.A + str2);
                            if (soundWaveDrinkWaterRecordBean2.getSysflag() == 1) {
                                viewHolder.money.setText(x.A + decimalFormat2.format(((double) ((soundWaveDrinkWaterRecordBean2.getPayMoney() * 100) / 100)) / 100.0d));
                                viewHolder.chongzhistate.setText("饮水-未激活");
                            } else if (soundWaveDrinkWaterRecordBean2.getSysflag() == 2) {
                                viewHolder.money.setText(x.A + decimalFormat2.format(((double) ((soundWaveDrinkWaterRecordBean2.getPayMoney() * 100) / 100)) / 100.0d));
                                viewHolder.chongzhistate.setText("饮水-待校验");
                            } else {
                                viewHolder.chongzhistate.setText("饮水-已完成");
                            }
                            viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view2) {
                                    String str3;
                                    String str4;
                                    if (soundWaveDrinkWaterRecordBean2.getSysflag() == 1 || soundWaveDrinkWaterRecordBean2.getSysflag() == 2) {
                                        for (WalletModel walletModel : RecordListActivity.this.mWalletModels) {
                                            if (walletModel.typeId == 6) {
                                                ScanQrcodeOrBarcodeActivity.launch(RecordListActivity.this.getActivity(), walletModel, soundWaveDrinkWaterRecordBean2.getOrderid(), 6);
                                            }
                                        }
                                        return;
                                    }
                                    String str5 = soundWaveDrinkWaterRecordBean2.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean2.getPayTime();
                                    String orderid = soundWaveDrinkWaterRecordBean2.getOrderid();
                                    if (soundWaveDrinkWaterRecordBean2.getI41() == 1) {
                                        str4 = "从基本钱包划扣";
                                    } else {
                                        if (soundWaveDrinkWaterRecordBean2.getI41() != 2) {
                                            if (soundWaveDrinkWaterRecordBean2.getI41() == 3) {
                                                str4 = "从周期钱包划扣";
                                            } else {
                                                str3 = "";
                                            }
                                            WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str2, str5, orderid, str3, soundWaveDrinkWaterRecordBean2.getSysflag(), soundWaveDrinkWaterRecordBean2.payMoney + "");
                                        }
                                        str4 = "从赠送钱包划扣";
                                    }
                                    str3 = str4;
                                    WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str2, str5, orderid, str3, soundWaveDrinkWaterRecordBean2.getSysflag(), soundWaveDrinkWaterRecordBean2.payMoney + "");
                                }
                            });
                            viewHolder.lin.setOnLongClickListener(new View.OnLongClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.4
                                @Override // android.view.View.OnLongClickListener
                                public boolean onLongClick(View view2) {
                                    String str3;
                                    String str4;
                                    String str5 = soundWaveDrinkWaterRecordBean2.getPayDate() + PPSLabelView.Code + soundWaveDrinkWaterRecordBean2.getPayTime();
                                    String orderid = soundWaveDrinkWaterRecordBean2.getOrderid();
                                    if (soundWaveDrinkWaterRecordBean2.getI41() == 1) {
                                        str4 = "从基本钱包划扣";
                                    } else {
                                        if (soundWaveDrinkWaterRecordBean2.getI41() != 2) {
                                            if (soundWaveDrinkWaterRecordBean2.getI41() == 3) {
                                                str4 = "从周期钱包划扣";
                                            } else {
                                                str3 = "";
                                            }
                                            WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str2, str5, orderid, str3, soundWaveDrinkWaterRecordBean2.getSysflag(), soundWaveDrinkWaterRecordBean2.payMoney + "");
                                            return false;
                                        }
                                        str4 = "从赠送钱包划扣";
                                    }
                                    str3 = str4;
                                    WashRecordDetailActivity.launch(RecordListActivity.this.getActivity(), str2, str5, orderid, str3, soundWaveDrinkWaterRecordBean2.getSysflag(), soundWaveDrinkWaterRecordBean2.payMoney + "");
                                    return false;
                                }
                            });
                        }
                    }
                } else {
                    final RecordBean recordBean = (RecordBean) getItem(i);
                    viewHolder.datetime.setText(TimeUtils.formatDateTime(recordBean.ConsumeTime));
                    viewHolder.money.setText(x.A + recordBean.ConsumeAmount);
                    viewHolder.chongzhistate.setText("用餐-已完成");
                    viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            BathRecordDetailActivity.launch(RecordListActivity.this.getActivity(), recordBean.ConsumeAmount + "", TimeUtils.formatDateTime(recordBean.ConsumeTime), 5);
                        }
                    });
                }
            } else {
                final RecordBean recordBean2 = (RecordBean) getItem(i);
                viewHolder.datetime.setText(TimeUtils.formatDateTime(recordBean2.ConsumeTime));
                viewHolder.money.setText(x.A + recordBean2.ConsumeAmount);
                viewHolder.chongzhistate.setText("洗澡-已完成");
                viewHolder.lin.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.RecordListActivity.RecordsAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BathRecordDetailActivity.launch(RecordListActivity.this.getActivity(), recordBean2.ConsumeAmount + "", TimeUtils.formatDateTime(recordBean2.ConsumeTime), recordBean2.IsOnline + "", recordBean2.OffLineTimes);
                    }
                });
            }
            return view;
        }

        class ViewHolder {
            public TextView chongzhistate;
            public TextView datetime;
            public RelativeLayout lin;
            public View line;
            public TextView money;

            public ViewHolder(View view) {
                this.line = view.findViewById(R.id.line1);
                this.datetime = (TextView) view.findViewById(R.id.tv_datetime);
                this.money = (TextView) view.findViewById(R.id.tv_money);
                this.chongzhistate = (TextView) view.findViewById(R.id.tv_chongzhistate);
                this.lin = (RelativeLayout) view.findViewById(R.id.lin);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroudAlpha() {
        this.mView.setVisibility(0);
    }
}
