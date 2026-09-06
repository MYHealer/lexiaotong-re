package client.android.yixiaotong.v3.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.PickerView;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RepairActivity extends BaseActivity {
    private PickerView lv_list;
    private EditText mAddressEt;
    private EditText mEtDeviceNo;
    private int mHeight;
    private InvestorInfoBean mInvestorInfoBean;
    private EditText mMobileEt;
    private PopupWindow mPopWindow;
    private RelativeLayout mRelSelectType;
    private EditText mReportEt;
    private TitleBar mTitleBar;
    private TextView mTvAppName;
    private int mWidth;
    private ScrollView scrollView;
    private View view;
    private int mTypeId = 0;
    private boolean mIsEnable = true;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private List<String> mData = new ArrayList();
    private int mSelectIndex = -1;
    private int mSelectTypeid = 0;

    static {
        StubApp.interface11(10172);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RepairActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mMobileEt = (EditText) findViewById(R.id.et_mobile);
        this.mAddressEt = (EditText) findViewById(R.id.et_address);
        this.mReportEt = (EditText) findViewById(R.id.et_report);
        this.mRelSelectType = (RelativeLayout) findViewById(R.id.rel_selecttype);
        this.mTvAppName = (TextView) findViewById(R.id.tv_appname);
        this.mEtDeviceNo = (EditText) findViewById(R.id.et_deviceno);
        this.scrollView = (ScrollView) findViewById(R.id.scrollview);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("故障报修");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initData() {
        int investorInfosIndex = InvestorInfoUtil.getInstance().getInvestorInfosIndex();
        if (InvestorInfoUtil.getInstance().getInvestorInfosV3() != null && InvestorInfoUtil.getInstance().getInvestorInfosV3().size() > 0 && InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex) != null) {
            this.mInvestorInfoBean = InvestorInfoUtil.getInstance().getInvestorInfosV3().get(investorInfosIndex).investorInfo;
            this.mAppDatas.clear();
            if (this.mInvestorInfoBean != null) {
                for (int i = 0; i < this.mInvestorInfoBean.planInfo.size(); i++) {
                    for (int i2 = 0; i2 < this.mInvestorInfoBean.planInfo.get(i).typeInfo.size(); i2++) {
                        this.mAppDatas.add(this.mInvestorInfoBean.planInfo.get(i).typeInfo.get(i2));
                    }
                }
            }
        }
        List<TypeInfoBean> list = this.mAppDatas;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.mAppDatas.size(); i3++) {
            this.mData.add(this.mAppDatas.get(i3).base.appName);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.btn_complete).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m418xf1dbb015(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-repair-RepairActivity, reason: not valid java name */
    /* synthetic */ void m418xf1dbb015(View view) {
        String string = this.mMobileEt.getText().toString();
        String string2 = this.mAddressEt.getText().toString();
        String string3 = this.mReportEt.getText().toString();
        if (StringUtils.isEmpty(string3.trim())) {
            ToastUtils.show(getContext(), "请填写反馈内容");
            return;
        }
        if (this.mTypeId == 0 && this.mSelectIndex == -1) {
            ToastUtils.show(getContext(), "请选择设备类型");
            return;
        }
        if (StringUtils.isEmpty(string.trim())) {
            ToastUtils.show(getContext(), "请填写联系电话");
        } else if (StringUtils.isEmpty(string2.trim())) {
            ToastUtils.show(getContext(), "请填写设备地址");
        } else {
            submit(string, string2, string3);
        }
    }

    private void initView() {
        int i = this.mTypeId;
        if (i == 0) {
            this.mRelSelectType.setVisibility(0);
        } else {
            this.mSelectTypeid = i;
            this.mRelSelectType.setVisibility(8);
        }
        this.mRelSelectType.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RepairActivity.hideKeyboard(view);
                RepairActivity.this.showPopupWindow();
            }
        });
        this.mReportEt.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                if ((motionEvent.getAction() & 255) == 1) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        });
        final int[] iArr = {0};
        this.scrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                RepairActivity repairActivity = RepairActivity.this;
                repairActivity.doScrollEvent(repairActivity.scrollView, iArr, RepairActivity.this.mEtDeviceNo, RepairActivity.this.mMobileEt, RepairActivity.this.mAddressEt);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScrollEvent(ScrollView scrollView, int[] iArr, EditText... editTextArr) {
        Rect rect = new Rect();
        scrollView.getWindowVisibleDisplayFrame(rect);
        int height = scrollView.getHeight() - rect.bottom;
        int scrollY = scrollView.getScrollY();
        for (EditText editText : editTextArr) {
            if (editText.isFocused()) {
                if (height > 100) {
                    int[] iArr2 = new int[2];
                    iArr[0] = scrollY;
                    editText.getLocationInWindow(iArr2);
                    int height2 = editText.getHeight();
                    if (iArr2[1] + height2 > rect.bottom - (height2 * 6)) {
                        scrollView.scrollBy(0, height - 100);
                        return;
                    }
                    return;
                }
                int i = iArr[0];
                if (i != scrollY) {
                    scrollView.scrollTo(0, i);
                }
                iArr[0] = scrollView.getScrollY();
                return;
            }
        }
    }

    private void submit(String str, String str2, String str3) {
        BusinessControllers.getInstance().newAddReportsV3(getLoginAccount(), "", UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", UserInfoUtil.getInstance().getLoginAccountV3().studentId, this.mEtDeviceNo.getText().toString(), str, this.mSelectTypeid, str2, "", str3, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(RepairActivity.this.getActivity(), "正在提交报修..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (RepairActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LocalBusinessStore.saveIsUploadRepair(RepairActivity.this.getContext(), true);
                    ToastUtils.show(RepairActivity.this.getContext(), "报修成功");
                    RepairActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RepairActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    RepairActivity.this.onError(clientException);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void backgroudAlpha(float f) {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.alpha = f;
        getWindow().setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopupWindow() {
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            this.view = getLayoutInflater().inflate(R.layout.listview_layout, (ViewGroup) null);
            PopupWindow popupWindow2 = new PopupWindow(this.view);
            this.mPopWindow = popupWindow2;
            popupWindow2.setWidth(-1);
            this.mPopWindow.setHeight((this.mHeight * 5) / 12);
            this.mPopWindow.showAtLocation(getActivity().findViewById(R.id.lin), 81, 0, 0);
            backgroudAlpha(0.5f);
            this.lv_list = (PickerView) this.view.findViewById(R.id.list);
            TextView textView = (TextView) this.view.findViewById(R.id.tv_canle);
            TextView textView2 = (TextView) this.view.findViewById(R.id.tv_postive);
            this.lv_list.setData(this.mData);
            textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RepairActivity.this.mPopWindow != null && RepairActivity.this.mPopWindow.isShowing()) {
                        RepairActivity.this.mPopWindow.dismiss();
                    }
                    RepairActivity.this.backgroudAlpha(1.0f);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.RepairActivity.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (RepairActivity.this.mPopWindow != null && RepairActivity.this.mPopWindow.isShowing()) {
                        RepairActivity.this.mPopWindow.dismiss();
                    }
                    RepairActivity.this.backgroudAlpha(1.0f);
                    RepairActivity repairActivity = RepairActivity.this;
                    repairActivity.mSelectIndex = repairActivity.lv_list.getPosition();
                    RepairActivity.this.mTvAppName.setText(((TypeInfoBean) RepairActivity.this.mAppDatas.get(RepairActivity.this.mSelectIndex)).base.appName);
                    RepairActivity repairActivity2 = RepairActivity.this;
                    repairActivity2.mSelectTypeid = ((TypeInfoBean) repairActivity2.mAppDatas.get(RepairActivity.this.mSelectIndex)).base.typeId;
                }
            });
        }
    }

    private void getWeightAndHeight() {
        Window window = getActivity().getWindow();
        Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
        window.getAttributes();
        this.mHeight = (int) (((double) defaultDisplay.getHeight()) * 0.8d);
        this.mWidth = (int) (((double) defaultDisplay.getWidth()) * 0.8d);
    }
}
