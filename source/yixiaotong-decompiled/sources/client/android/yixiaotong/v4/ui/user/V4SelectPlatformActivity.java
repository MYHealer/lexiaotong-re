package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4PlatformInfoBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.selectplatform.SearchCacheManager;
import client.android.yixiaotong.v4.util.selectplatform.SearchItem;
import client.android.yixiaotong.v4.util.selectplatform.SearchItemAdapter;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectPlatformActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "V4SelectPlatformActivity";
    private SearchItemAdapter adapter;
    private RecordsAdapter mApdater;
    private EditText mEtSchoolName;
    private boolean mIsEnable;
    private ListView mLvRecord;
    private RelativeLayout mRelQrcode;
    private TitleBar mTitleBar;
    private TextView mTvNoData;
    private RecyclerView recyclerView;
    private final List<V4PlatformInfoBean> mRecordListBeans = new ArrayList();
    private List<SearchItem> cachedItems = new ArrayList();
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(V4SelectPlatformActivity.TAG, "onPermissionGranted:" + i + "");
            if (i != 0) {
                return;
            }
            ScanQrcodeOrBarcodeActivity.launch(V4SelectPlatformActivity.this.getActivity(), 101);
            V4SelectPlatformActivity.this.finish();
        }
    };

    static {
        StubApp.interface11(11077);
    }

    private void performSearch(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4SelectPlatformActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtSchoolName = (EditText) findViewById(R.id.et_name);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
        this.mTvNoData = (TextView) findViewById(R.id.tv_nodata);
        this.mRelQrcode = (RelativeLayout) findViewById(R.id.rel_qrcode);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.selectschool));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
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
        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m549xeeb574d6(view);
            }
        });
        findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m550xe244f917(view);
            }
        });
        dragView(this.mRelQrcode);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-user-V4SelectPlatformActivity, reason: not valid java name */
    /* synthetic */ void m549xeeb574d6(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-user-V4SelectPlatformActivity, reason: not valid java name */
    /* synthetic */ void m550xe244f917(View view) {
        String string = this.mEtSchoolName.getText().toString();
        if (!StringUtils.isNotEmpty(string) || string.length() < 3) {
            ToastUtils.show(getActivity(), "请输入至少三位关键字");
        } else {
            getData();
        }
    }

    private void initView() {
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
    }

    private void getData() {
        V4BusinessControllers.getInstance().getSchoolPlatform(getLoginAccount(), this.mEtSchoolName.getText().toString(), new Listener<List<V4PlatformInfoBean>>() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                V4SelectPlatformActivity.this.mTvNoData.setVisibility(8);
                BaseMaterialDialog.showMaterialDialog(V4SelectPlatformActivity.this.getActivity(), "加载中..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4PlatformInfoBean> list, Object... objArr) {
                if (V4SelectPlatformActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (list != null) {
                        V4SelectPlatformActivity.this.mRecordListBeans.clear();
                        V4SelectPlatformActivity.this.mRecordListBeans.addAll(list);
                        V4SelectPlatformActivity.this.mApdater.notifyDataSetChanged();
                        if (list.size() == 0) {
                            V4SelectPlatformActivity.this.mTvNoData.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    V4SelectPlatformActivity.this.mTvNoData.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SelectPlatformActivity.this.mIsEnable) {
                    V4SelectPlatformActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4PlatformInfoBean item = this.mApdater.getItem(i);
        String str = item.schoolName;
        if (StringUtils.isEmpty(str)) {
            str = item.schoolAlias;
        }
        int i2 = 4;
        if (item.sysVersion != 4) {
            i2 = item.sysVersion == 3 ? 1 : 0;
        }
        LocalDataUtil.savePlatformInfo(getActivity(), i2);
        LocalDataUtil.savePlatformSchoolName(getActivity(), str);
        saveItem(str, i2);
        finish();
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
            return V4SelectPlatformActivity.this.mRecordListBeans.size();
        }

        @Override // android.widget.Adapter
        public V4PlatformInfoBean getItem(int i) {
            return (V4PlatformInfoBean) V4SelectPlatformActivity.this.mRecordListBeans.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(V4SelectPlatformActivity.this.getContext()).inflate(R.layout.address_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            V4PlatformInfoBean item = getItem(i);
            String str = item.schoolName;
            if (StringUtils.isEmpty(str)) {
                str = item.schoolAlias;
            }
            viewHolder.name.setText(str);
            return view;
        }

        class ViewHolder {
            public TextView name;

            public ViewHolder(View view) {
                this.name = (TextView) view.findViewById(R.id.name);
            }
        }
    }

    private void initHistoryView() {
        SearchItemAdapter searchItemAdapter = new SearchItemAdapter(this.cachedItems, new SearchItemAdapter.OnItemClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity$$ExternalSyntheticLambda2
            @Override // client.android.yixiaotong.v4.util.selectplatform.SearchItemAdapter.OnItemClickListener
            public final void onItemClick(SearchItem searchItem) {
                this.f$0.m551xd4cde0(searchItem);
            }
        }, new SearchItemAdapter.OnItemDeleteListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity$$ExternalSyntheticLambda3
            @Override // client.android.yixiaotong.v4.util.selectplatform.SearchItemAdapter.OnItemDeleteListener
            public final void onItemDelete(SearchItem searchItem) {
                this.f$0.m552xf4645221(searchItem);
            }
        });
        this.adapter = searchItemAdapter;
        this.recyclerView.setAdapter(searchItemAdapter);
        setupSearchView();
        loadCachedItems();
        if (this.cachedItems.size() > 0) {
            this.recyclerView.setVisibility(0);
        }
        LogUtil.e(TAG, "initHistoryView:" + this.cachedItems);
    }

    /* JADX INFO: renamed from: lambda$initHistoryView$2$client-android-yixiaotong-v4-ui-user-V4SelectPlatformActivity, reason: not valid java name */
    /* synthetic */ void m551xd4cde0(SearchItem searchItem) {
        hideHistoryList();
        LocalDataUtil.savePlatformInfo(getActivity(), searchItem.getPlatform());
        LocalDataUtil.savePlatformSchoolName(getActivity(), searchItem.getSchoolName());
        finish();
    }

    /* JADX INFO: renamed from: lambda$initHistoryView$3$client-android-yixiaotong-v4-ui-user-V4SelectPlatformActivity, reason: not valid java name */
    /* synthetic */ void m552xf4645221(SearchItem searchItem) {
        SearchCacheManager.removeItem(this, searchItem.getId());
        loadCachedItems();
    }

    private void setupSearchView() {
        this.mEtSchoolName.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isEmpty(V4SelectPlatformActivity.this.mEtSchoolName.getText().toString())) {
                    V4SelectPlatformActivity.this.loadCachedItems();
                    if (V4SelectPlatformActivity.this.cachedItems.isEmpty()) {
                        return;
                    }
                    V4SelectPlatformActivity.this.showHistoryList();
                    return;
                }
                V4SelectPlatformActivity.this.hideHistoryList();
            }
        });
    }

    private void saveItem(String str, int i) {
        SearchCacheManager.saveSearchItem(getActivity(), new SearchItem(UUID.randomUUID().toString(), str, i));
        hideHistoryList();
        performSearch(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadCachedItems() {
        List<SearchItem> cachedItems = SearchCacheManager.getCachedItems(this);
        this.cachedItems = cachedItems;
        this.adapter.updateItems(cachedItems);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHistoryList() {
        this.recyclerView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHistoryList() {
        this.recyclerView.setVisibility(8);
    }

    private void dragView(View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int i = displayMetrics.widthPixels;
        final int i2 = displayMetrics.heightPixels;
        view.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity.4
            private float dX;
            private float dY;
            private int lastAction;
            private float startX;
            private float startY;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.startX = motionEvent.getRawX();
                    this.startY = motionEvent.getRawY();
                    this.dX = view2.getX() - motionEvent.getRawX();
                    this.dY = view2.getY() - motionEvent.getRawY();
                    this.lastAction = 0;
                } else if (action != 1) {
                    if (action != 2) {
                        return false;
                    }
                    float fAbs = Math.abs(motionEvent.getRawX() - this.startX);
                    float fAbs2 = Math.abs(motionEvent.getRawY() - this.startY);
                    if (fAbs > 8.0f || fAbs2 > 8.0f) {
                        float rawX = motionEvent.getRawX() + this.dX;
                        float rawY = motionEvent.getRawY() + this.dY;
                        if (rawX < 0.0f) {
                            rawX = 0.0f;
                        }
                        if (rawY < 0.0f) {
                            rawY = 0.0f;
                        }
                        float width = view2.getWidth() + rawX;
                        int i3 = i;
                        if (width > i3) {
                            rawX = i3 - view2.getWidth();
                        }
                        float height = view2.getHeight() + rawY;
                        int i4 = i2;
                        if (height > i4) {
                            rawY = i4 - view2.getHeight();
                        }
                        view2.setX(rawX);
                        view2.setY(rawY);
                        this.lastAction = 2;
                    }
                } else if (this.lastAction == 0 && !ClickUtil.isFastDoubleClick()) {
                    if (LocalBusinessStore.getPerssionTip(V4SelectPlatformActivity.this.getActivity(), 1)) {
                        PermissionUtil.requestPerssion(V4SelectPlatformActivity.this.getActivity(), 0, V4SelectPlatformActivity.this.permissionGrant);
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(V4SelectPlatformActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity.4.1
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                LocalBusinessStore.savePerssionTip(V4SelectPlatformActivity.this.getActivity(), 1);
                                LocalDataUtil.savePermissIndex(V4SelectPlatformActivity.this.getActivity(), 1);
                                PermissionUtil.requestPerssion(V4SelectPlatformActivity.this.getActivity(), 0, V4SelectPlatformActivity.this.permissionGrant);
                            }
                        }, "需要开启相机权限，用于扫描学校二维码");
                    }
                }
                return true;
            }
        });
    }
}
