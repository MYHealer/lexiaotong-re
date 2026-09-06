package client.android.yixiaotong.v3.ui.appcontrol.drawmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.OperationTimeJsonBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeListBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DrawMoneyControlActivity extends BaseActivity {
    private static final String TAG = "DrawMoneyControlActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private NativeUtil mNativeUtil;
    private String mOpenTime;
    private OperationTimeJsonBean mOperationTimeJsonBean;
    private RelativeLayout mRelWarningError;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TypeInfoBean mTypeInfoBean;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 0) {
                return;
            }
            LocalDataUtil.saveUnFinshOrderId(DrawMoneyControlActivity.this.getContext(), "");
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch(DrawMoneyControlActivity.this.getActivity(), 8);
            } else {
                ZxingScanV3Activity.launch(DrawMoneyControlActivity.this.getActivity(), 8);
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(9161);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DrawMoneyControlActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelWarningError = (RelativeLayout) findViewById(R.id.rel_warningerror);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        if (StringUtils.isNotEmpty(this.mTypeInfoBean.base.appName)) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.drawmoney));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        showError50XTip();
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DrawMoneyControlActivity.this.checkPre(0);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ConsumeRecordActivity.launch(DrawMoneyControlActivity.this.getActivity(), DrawMoneyControlActivity.this.mTypeInfoBean.base.typeId);
            }
        });
        findViewById(R.id.iv_drawmoneyhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtils.show(DrawMoneyControlActivity.this.getContext(), DrawMoneyControlActivity.this.getString(R.string.notopen));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkPre(int i) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mTypeInfoBean.base.statusFlag == 1) {
            OperationTimeJsonBean operationTimeJsonBean = this.mOperationTimeJsonBean;
            if (operationTimeJsonBean != null && operationTimeJsonBean.operationFlag == 2) {
                if (isOpenTime()) {
                    toOpen(i);
                    return;
                } else {
                    showDialog("暂停服务，开放时间为\n每日" + this.mOpenTime);
                    return;
                }
            }
            toOpen(i);
            return;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), getString(R.string.appstop));
    }

    private void toOpen(int i) {
        if (i == 0) {
            PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
        } else {
            if (i != 1) {
                return;
            }
            ToastUtils.show(getContext(), getString(R.string.notopen));
        }
    }

    private boolean isOpenTime() {
        this.mOpenTime = "";
        List<OperationTimeListBean> list = this.mOperationTimeJsonBean.operationTimeList;
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            this.mOpenTime += list.get(i).startTime + "至" + list.get(i).stopTime + "时\n";
            int i2 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[0]);
            int i3 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[1]);
            int i4 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[0]);
            int i5 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[1]);
            Log.e("test", i2 + "  " + i3 + "  " + i4 + "  " + i5);
            if (TimeUtils.isCurrentInTimeScope(i2, i3, i4, i5)) {
                return true;
            }
        }
        return false;
    }

    private void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    private void showError50XTip() {
        if (Error50XUtil.isInterrupt(getActivity())) {
            this.mRelWarningError.setVisibility(0);
        } else {
            this.mRelWarningError.setVisibility(8);
        }
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drawmoney.DrawMoneyControlActivity.5
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    DrawMoneyControlActivity.this.mNativeUtil.initNative(DrawMoneyControlActivity.this.getActivity(), DrawMoneyControlActivity.this.mAdvListener, 1);
                    DrawMoneyControlActivity.this.mNativeUtil.onNative(DrawMoneyControlActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                DrawMoneyControlActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
