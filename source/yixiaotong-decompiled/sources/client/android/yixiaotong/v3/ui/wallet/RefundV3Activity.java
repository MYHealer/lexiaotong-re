package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.FileProvider;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.exception.HttpException;
import client.android.yixiaotong.ui.ammeter.AmmeterWalletDetailActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.util.BitmapUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.DialogUtils;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.http.bean.BaseBean;
import client.android.yixiaotong.util.imgutil.UploadImgUtil;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.PlanJsonBean;
import client.android.yixiaotong.v3.comman.AppPlanFlagUtil;
import client.android.yixiaotong.v3.ui.dialog.RefundDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.wallet.controlutil.RefundControlUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.yfanads.android.libs.net.UrlHttpUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundV3Activity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "RefundV3Activity";
    private ActivityResultLauncher<Intent> fromAlumn;
    private Button mBtnRefund;
    private EditText mEtRefundDes;
    private EditText mEtStudentNo;
    private int mGetPictureWay;
    private GridAdater mGridAdater;
    private GridView mGridImg;
    private String mId;
    private ImageView mImgAli;
    private ImageView mImgUnion;
    private ImageView mImgWechat;
    private LinearLayout mLinRefundDes;
    private LinearLayout mLinStudentNo;
    private WrapListView mLvRefundWay;
    private PlanJsonBean mPlanJsonBean;
    public String mRefundUrl;
    private RelativeLayout mRelAli;
    private RelativeLayout mRelUnion;
    private RelativeLayout mRelWeChat;
    private int mTotalMoney;
    private TextView mTvCount;
    private TextView mTvRefundText;
    private TextView mTvTip;
    private int mType;
    private UnionWayAdapter mUnionWayAdapter;
    private TitleBar mVTitleBar;
    private ActivityResultLauncher<Intent> takePhoto;
    private int mBanlance = 0;
    private boolean mIsEnable = true;
    private List<Integer> mPayFlagTypeList = new ArrayList();
    private int mIndexPayFlag = -1;
    private boolean mIsVisableUnion = false;
    private List<String> listimg = new ArrayList();
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                DialogUtils.showList(RefundV3Activity.this.getActivity(), "添加图片", R.array.sign, new MaterialDialog.ListCallback() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.4.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallback
                    public void onSelection(MaterialDialog materialDialog, View view, int i2, CharSequence charSequence) {
                        if (i2 == 0) {
                            RefundV3Activity.this.takePhoto();
                        } else if (i2 == 1) {
                            RefundV3Activity.this.openFile();
                        }
                    }
                });
            } else if (i == 2) {
                PermissionUtil.requestPerssion(RefundV3Activity.this.getActivity(), 3, RefundV3Activity.this.permissionGrant);
            } else {
                if (i != 3) {
                    return;
                }
                PermissionUtil.requestPerssion(RefundV3Activity.this.getActivity(), 0, RefundV3Activity.this.permissionGrant);
            }
        }
    };
    private int mSelectWay = -1;
    private List<Integer> mSubPayFlagTypeList = new ArrayList();
    private int mHasZgyh = 0;
    private int mHasNyyh = 0;
    private int mHasJsyh = 0;
    private int mHasGsyh = 0;
    private Uri imageUri = null;
    private File outputImage = null;

    static {
        StubApp.interface11(10292);
    }

    private void initUnionIndex() {
        this.mHasZgyh = 0;
        this.mHasNyyh = 0;
        this.mHasJsyh = 0;
        this.mHasGsyh = 0;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mLvRefundWay = (WrapListView) findViewById(R.id.listview);
        this.mImgWechat = (ImageView) findViewById(R.id.img_select_weixin);
        this.mImgAli = (ImageView) findViewById(R.id.img_select_ali);
        this.mImgUnion = (ImageView) findViewById(R.id.img_select_union);
        this.mRelAli = (RelativeLayout) findViewById(R.id.rel_alipay);
        this.mRelWeChat = (RelativeLayout) findViewById(R.id.rel_wechat);
        this.mRelUnion = (RelativeLayout) findViewById(R.id.rel_unionpay);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mBtnRefund = (Button) findViewById(R.id.btn_refund);
        this.mLinStudentNo = (LinearLayout) findViewById(R.id.lin_studentno);
        this.mEtStudentNo = (EditText) findViewById(R.id.et_studentno);
        this.mLinRefundDes = (LinearLayout) findViewById(R.id.lin_refunddes);
        this.mTvRefundText = (TextView) findViewById(R.id.tv_refundtext);
        this.mEtRefundDes = (EditText) findViewById(R.id.et_refunddes);
        this.mTvCount = (TextView) findViewById(R.id.tv_count);
        this.mGridImg = (GridView) findViewById(R.id.gridimg);
    }

    public static void launch(Activity activity, String str, int i, int i2, int i3) {
        Intent intent = new Intent(activity, (Class<?>) RefundV3Activity.class);
        intent.putExtra("id", str);
        intent.putExtra(AmmeterWalletDetailActivity.EXTRA_MONEY, i);
        intent.putExtra("totalmoney", i2);
        intent.putExtra("type", i3);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView(getString(R.string.applyrefund));
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        this.mVTitleBar.setRightView(getString(R.string.refundrule));
        this.mVTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff222222));
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundDialog.getInstance().showTipTimeOutDialog(RefundV3Activity.this.getActivity());
            }
        });
    }

    private void initData() {
        List<PlanInfoBean> planInfo = InvestorInfoUtilControl.getInstance().getPlanInfo();
        if (planInfo == null || planInfo.size() == 0) {
            return;
        }
        for (int i = 0; i < planInfo.size(); i++) {
            int i2 = planInfo.get(i).base.planFlag;
            int i3 = this.mType;
            if (i2 == i3) {
                PlanJsonBean planJsonBean = planInfo.get(i).planJson;
                this.mPlanJsonBean = planJsonBean;
                if (planJsonBean == null) {
                    return;
                }
                if (planJsonBean.manualRefundPayFlagTypeList != null && this.mPlanJsonBean.manualRefundPayFlagTypeList.size() > 0) {
                    setPayFlagList(this.mPlanJsonBean.manualRefundPayFlagTypeList);
                }
                if (this.mPlanJsonBean.autoTransferRefundPayFlagTypeList != null && this.mPlanJsonBean.autoTransferRefundPayFlagTypeList.size() > 0) {
                    setPayFlagList(this.mPlanJsonBean.autoTransferRefundPayFlagTypeList);
                }
                if (this.mPlanJsonBean.originalRouteRefundPayFlagTypeList != null && this.mPlanJsonBean.originalRouteRefundPayFlagTypeList.size() > 0) {
                    setPayFlagList(this.mPlanJsonBean.originalRouteRefundPayFlagTypeList);
                }
            } else if (i3 == 3) {
                this.mPayFlagTypeList.add(1);
                this.mPayFlagTypeList.add(2);
            } else if (i3 == 7) {
                PlanJsonBean planJsonBean2 = planInfo.get(i).planJson;
                this.mPlanJsonBean = planJsonBean2;
                if (planJsonBean2 != null && planJsonBean2.redPacketRefundPayFlagTypeList != null && this.mPlanJsonBean.redPacketRefundPayFlagTypeList.size() > 0) {
                    setPayFlagList(this.mPlanJsonBean.redPacketRefundPayFlagTypeList);
                }
            }
        }
    }

    private void setPayFlagList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if ((list.get(i).intValue() == 1 || list.get(i).intValue() == 2 || list.get(i).intValue() == 22 || list.get(i).intValue() == 23 || list.get(i).intValue() == 24 || list.get(i).intValue() == 25 || list.get(i).intValue() == -1 || list.get(i).intValue() == -2 || list.get(i).intValue() == -22 || list.get(i).intValue() == -23 || list.get(i).intValue() == -24 || list.get(i).intValue() == -25) && !isHasPayFlag(list.get(i).intValue())) {
                this.mPayFlagTypeList.add(list.get(i));
                LogUtil.e(TAG, "setPayFlagList 总:" + list.get(i));
            }
            if ((list.get(i).intValue() == 22 || list.get(i).intValue() == 23 || list.get(i).intValue() == 24 || list.get(i).intValue() == 25 || list.get(i).intValue() == -22 || list.get(i).intValue() == -23 || list.get(i).intValue() == -24 || list.get(i).intValue() == -25) && !isHasPayFlagUnion(list.get(i).intValue())) {
                this.mSubPayFlagTypeList.add(list.get(i));
                LogUtil.e(TAG, "setPayFlagList 银行卡:" + list.get(i));
            }
        }
    }

    private boolean isHasPayFlag(int i) {
        for (int i2 = 0; i2 < this.mPayFlagTypeList.size(); i2++) {
            if (this.mPayFlagTypeList.get(i2).intValue() == i) {
                return true;
            }
        }
        return false;
    }

    private boolean isHasPayFlagUnion(int i) {
        for (int i2 = 0; i2 < this.mSubPayFlagTypeList.size(); i2++) {
            if (this.mSubPayFlagTypeList.get(i2).intValue() == i) {
                return true;
            }
        }
        return false;
    }

    private void initView() {
        if (this.mPlanJsonBean == null && (this.mType == AppPlanFlagUtil.PLAN_WALLET || this.mType == AppPlanFlagUtil.PLAN_DEPOSITION || this.mType == AppPlanFlagUtil.PLAN_PREPAYMENT)) {
            finish();
        }
        for (int i = 0; i < this.mPayFlagTypeList.size(); i++) {
            if (this.mPayFlagTypeList.get(i).intValue() == 1 || this.mPayFlagTypeList.get(i).intValue() == -1) {
                this.mRelWeChat.setVisibility(0);
                this.mIndexPayFlag = 1;
            }
            if (this.mPayFlagTypeList.get(i).intValue() == 2 || this.mPayFlagTypeList.get(i).intValue() == -2) {
                this.mRelAli.setVisibility(0);
                if (this.mIndexPayFlag != 1) {
                    this.mIndexPayFlag = 2;
                }
            }
            if (this.mPayFlagTypeList.get(i).intValue() == 22 || this.mPayFlagTypeList.get(i).intValue() == -22 || this.mPayFlagTypeList.get(i).intValue() == 23 || this.mPayFlagTypeList.get(i).intValue() == -23 || this.mPayFlagTypeList.get(i).intValue() == 24 || this.mPayFlagTypeList.get(i).intValue() == -24 || this.mPayFlagTypeList.get(i).intValue() == 25 || this.mPayFlagTypeList.get(i).intValue() == -25) {
                this.mRelUnion.setVisibility(0);
                int i2 = this.mIndexPayFlag;
                if (i2 != 1 && i2 != 2) {
                    this.mIndexPayFlag = 3;
                }
            }
        }
        int i3 = this.mIndexPayFlag;
        if (i3 == 1) {
            this.mImgWechat.setImageResource(R.mipmap.xz1);
            this.mImgAli.setImageResource(R.mipmap.wxz);
            this.mImgUnion.setImageResource(R.mipmap.next);
        } else if (i3 == 2) {
            this.mImgWechat.setImageResource(R.mipmap.wxz);
            this.mImgAli.setImageResource(R.mipmap.xz1);
            this.mImgUnion.setImageResource(R.mipmap.next);
        } else if (i3 == 3) {
            this.mImgWechat.setImageResource(R.mipmap.wxz);
            this.mImgAli.setImageResource(R.mipmap.wxz);
            this.mImgUnion.setImageResource(R.mipmap.down);
            this.mSelectWay = 0;
            this.mLvRefundWay.setVisibility(0);
            this.mRelUnion.setEnabled(false);
            this.mImgUnion.setVisibility(8);
        }
        if (this.mType == AppPlanFlagUtil.PLAN_DEPOSITION) {
            if (this.mPlanJsonBean.refundReason == 1) {
                this.mLinRefundDes.setVisibility(0);
            }
            this.mBtnRefund.setText(getString(R.string.refunddeposit));
            this.mTvTip.setText(getString(R.string.refunddeposittime) + this.mPlanJsonBean.refundMoneyStartDate + "~" + this.mPlanJsonBean.refundMoneyStopDate);
            this.mTvRefundText.setText(getString(R.string.refunddepositreason));
            this.mEtRefundDes.setHint(getString(R.string.refunddepositreasondes));
        } else if (this.mType == AppPlanFlagUtil.PLAN_WALLET || this.mType == AppPlanFlagUtil.PLAN_PREPAYMENT) {
            if (this.mPlanJsonBean.refundReason == 1) {
                this.mLinRefundDes.setVisibility(0);
            }
            this.mTvTip.setText(getString(R.string.refundtime) + this.mPlanJsonBean.refundMoneyStartDate + "~" + this.mPlanJsonBean.refundMoneyStopDate);
        }
        PlanJsonBean planJsonBean = this.mPlanJsonBean;
        if (planJsonBean != null && planJsonBean.refundNeedStudentNumber != null && this.mPlanJsonBean.refundNeedStudentNumber.intValue() == 1) {
            this.mLinStudentNo.setVisibility(0);
        }
        this.mEtRefundDes.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                RefundV3Activity.this.mTvCount.setText(editable.toString().length() + "/150");
            }
        });
        GridAdater gridAdater = new GridAdater();
        this.mGridAdater = gridAdater;
        this.mGridImg.setAdapter((ListAdapter) gridAdater);
        this.mUnionWayAdapter = new UnionWayAdapter();
        this.mLvRefundWay.setOnItemClickListener(this);
        this.mLvRefundWay.setAdapter((ListAdapter) this.mUnionWayAdapter);
        this.mUnionWayAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toLaunch() {
        int i;
        LogUtil.e(TAG, "toLaunch:" + this.mIndexPayFlag);
        int i2 = this.mIndexPayFlag;
        if (i2 == 2) {
            if (isHasPayFlag(-2)) {
                refund(-2);
                return;
            } else if (this.mTotalMoney >= 10) {
                toLaunchActivity(2);
                return;
            } else {
                ToastUtils.show(getContext(), "当前余额低于支付宝退款额度，暂不支持退款");
                return;
            }
        }
        if (i2 == 1) {
            if (isHasPayFlag(-1)) {
                refund(-1);
                return;
            } else if (this.mTotalMoney >= 30) {
                toLaunchActivity(1);
                return;
            } else {
                ToastUtils.show(getContext(), "当前余额低于微信退款额度，暂不支持退款");
                return;
            }
        }
        if (i2 == 3 && (i = this.mSelectWay) >= 0 && i < this.mSubPayFlagTypeList.size()) {
            if (isHasPayFlag(-22) || isHasPayFlag(-23) || isHasPayFlag(-24) || isHasPayFlag(-25)) {
                refund(this.mSubPayFlagTypeList.get(this.mSelectWay).intValue());
                return;
            } else {
                toLaunchActivity(this.mSubPayFlagTypeList.get(this.mSelectWay).intValue());
                return;
            }
        }
        ToastUtils.show(getContext(), "请选择到账账户");
    }

    private void refund(int i) {
        int i2 = this.mType;
        if (i2 == 3) {
            RefundControlUtil.getInstance().refundCard(i, this.mId, this.mBanlance, "");
            return;
        }
        if (i2 == 6) {
            RefundControlUtil.getInstance().refundPrepayment(this.mId, this.mTotalMoney, i, UserInfoUtil.getInstance().getLoginAccountV3().studentMobile, UserInfoUtil.getInstance().getLoginAccountV3().studentName, "", "", this.mEtRefundDes.getText().toString(), this.mRefundUrl);
        } else {
            RefundControlUtil.getInstance().refund(this.mType, this.mId, this.mBanlance, i, UserInfoUtil.getInstance().getLoginAccountV3().studentMobile, UserInfoUtil.getInstance().getLoginAccountV3().studentName, "", "", this.mEtRefundDes.getText().toString(), this.mRefundUrl, this.mEtStudentNo.getText().toString());
        }
    }

    private void toLaunchActivity(int i) {
        RefundToAliV3Activity.launch(getActivity(), i, this.mId, this.mBanlance, this.mType, this.mEtRefundDes.getText().toString(), this.mRefundUrl, this.mEtStudentNo.getText().toString());
        finish();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_alipay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m429x72abf371(view);
            }
        });
        findViewById(R.id.rel_wechat).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m430x983ffc72(view);
            }
        });
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m431xbdd40573(view);
            }
        });
        findViewById(R.id.img_add).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m432xe3680e74(view);
            }
        });
        findViewById(R.id.rel_unionpay).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m433x8fc1775(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-wallet-RefundV3Activity, reason: not valid java name */
    /* synthetic */ void m429x72abf371(View view) {
        selectPaymentMethod(2);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-wallet-RefundV3Activity, reason: not valid java name */
    /* synthetic */ void m430x983ffc72(View view) {
        selectPaymentMethod(1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-wallet-RefundV3Activity, reason: not valid java name */
    /* synthetic */ void m431xbdd40573(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        handleRefundAction();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-wallet-RefundV3Activity, reason: not valid java name */
    /* synthetic */ void m432xe3680e74(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        requestStoragePermission();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-wallet-RefundV3Activity, reason: not valid java name */
    /* synthetic */ void m433x8fc1775(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        toggleUnionPay();
    }

    private void selectPaymentMethod(int i) {
        this.mIndexPayFlag = i;
        this.mImgWechat.setImageResource(i == 1 ? R.mipmap.xz1 : R.mipmap.wxz);
        this.mImgAli.setImageResource(i == 2 ? R.mipmap.xz1 : R.mipmap.wxz);
        this.mSelectWay = -1;
        initUnionIndex();
        this.mUnionWayAdapter.notifyDataSetChanged();
    }

    private void handleRefundAction() {
        if (checkStudentNo() && checkMoney()) {
            if (this.mPayFlagTypeList.isEmpty()) {
                ToastUtils.show(getContext(), "暂未开通退款通道");
            } else {
                uploadPic();
            }
        }
    }

    private void requestStoragePermission() {
        PermissionUtil.requestPerssion(getActivity(), 2, this.permissionGrant);
    }

    private void toggleUnionPay() {
        this.mIndexPayFlag = 3;
        this.mImgAli.setImageResource(R.mipmap.wxz);
        this.mImgWechat.setImageResource(R.mipmap.wxz);
        initUnionIndex();
        if (this.mIsVisableUnion) {
            this.mSelectWay = -1;
            this.mIsVisableUnion = false;
            this.mImgUnion.setImageResource(R.mipmap.next);
            this.mLvRefundWay.setVisibility(8);
        } else {
            this.mSelectWay = 0;
            this.mIsVisableUnion = true;
            this.mImgUnion.setImageResource(R.mipmap.down);
            this.mLvRefundWay.setVisibility(0);
        }
        this.mUnionWayAdapter.notifyDataSetChanged();
    }

    private boolean checkStudentNo() {
        PlanJsonBean planJsonBean = this.mPlanJsonBean;
        if (planJsonBean == null || planJsonBean.refundNeedStudentNumber == null || this.mPlanJsonBean.refundNeedStudentNumber.intValue() != 1 || !StringUtils.isEmpty(this.mEtStudentNo.getText().toString())) {
            return true;
        }
        ToastUtils.show(getActivity(), getString(R.string.refundinputstudentno));
        return false;
    }

    private boolean checkMoney() {
        int i = this.mTotalMoney;
        if (i == 0) {
            ToastUtils.show(getContext(), getString(R.string.refundbalance1));
            return false;
        }
        if (i >= 0) {
            return true;
        }
        ToastUtils.show(getContext(), getString(R.string.refundbalance2));
        return false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        RefundControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        RefundControlUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCropActivity(Uri uri) {
        if (uri == null) {
            return;
        }
        LogUtil.e(TAG, "startCropActivity2:" + uri.getPath());
        this.mGridImg.setVisibility(0);
        if (this.listimg.size() != 0) {
            this.listimg.clear();
        }
        this.listimg.add(uri.getPath());
        this.mGridAdater.notifyDataSetChanged();
    }

    private void uploadPic() {
        List<String> list = this.listimg;
        if (list != null && list.size() > 0) {
            BaseMaterialDialog.showMaterialDialog(getActivity(), "上传图片中", true);
            AsyncExecutor.getInstance().execute(new AnonymousClass3());
        } else {
            toLaunch();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UploadImgUtil.UpLoadImage(RefundV3Activity.this.getActivity(), RefundV3Activity.this.imageUri, new UploadImgUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.3.1
                @Override // client.android.yixiaotong.util.imgutil.UploadImgUtil.Listener
                public void onResponse(final BaseBean baseBean) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.3.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RefundV3Activity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                if (baseBean.Code == 0) {
                                    RefundV3Activity.this.mRefundUrl = baseBean.Data.toString();
                                    LogUtil.e(RefundV3Activity.TAG, RefundV3Activity.this.mRefundUrl);
                                    RefundV3Activity.this.toLaunch();
                                    return;
                                }
                                RefundV3Activity.this.onError(HttpException.filter(baseBean.Code, baseBean.getErrMsg(), baseBean.Data, baseBean.Serial));
                            }
                        }
                    });
                }

                @Override // client.android.yixiaotong.util.imgutil.UploadImgUtil.Listener
                public void onFailure(final String str) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.3.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RefundV3Activity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                SystemErrorTip.getInstance().showTipDialog(RefundV3Activity.this.getActivity(), str);
                            }
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mVTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private class GridAdater extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private GridAdater() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RefundV3Activity.this.listimg.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return RefundV3Activity.this.listimg.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(final int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            Bitmap bitmapDecodeStream = null;
            if (view == null) {
                view = LayoutInflater.from(RefundV3Activity.this.getContext()).inflate(R.layout.grid_item_img, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            LogUtil.e(RefundV3Activity.TAG, "img:" + i + "  " + ((String) RefundV3Activity.this.listimg.get(i)) + "  " + RefundV3Activity.this.listimg.size());
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(RefundV3Activity.this.getContentResolver().openInputStream(RefundV3Activity.this.imageUri));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            if (bitmapDecodeStream != null && RefundV3Activity.this.mGetPictureWay == 2) {
                try {
                    viewHolder.img.setImageBitmap(BitmapUtil.rotateIfRequired(bitmapDecodeStream, RefundV3Activity.this.outputImage));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } else {
                viewHolder.img.setImageBitmap(bitmapDecodeStream);
            }
            viewHolder.delect.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.GridAdater.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    RefundV3Activity.this.listimg.remove(i);
                    RefundV3Activity.this.mGridAdater.notifyDataSetChanged();
                }
            });
            return view;
        }

        class ViewHolder {
            ImageView delect;
            ImageView img;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img);
                this.delect = (ImageView) view.findViewById(R.id.delect);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (adapterView.getAdapter().toString().contains("UnionWayAdapter")) {
            initUnionIndex();
            this.mSelectWay = i;
            this.mUnionWayAdapter.notifyDataSetChanged();
        }
    }

    class UnionWayAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        UnionWayAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return RefundV3Activity.this.mSubPayFlagTypeList.size();
        }

        @Override // android.widget.Adapter
        public Integer getItem(int i) {
            return (Integer) RefundV3Activity.this.mSubPayFlagTypeList.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(RefundV3Activity.this.getContext()).inflate(R.layout.layout_rechargeway_item, viewGroup, false);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            int iIntValue = getItem(i).intValue();
            LogUtil.e(RefundV3Activity.TAG, "getView:" + i + PPSLabelView.Code + iIntValue + PPSLabelView.Code + RefundV3Activity.this.mSelectWay + PPSLabelView.Code + RefundV3Activity.this.mHasZgyh + PPSLabelView.Code + RefundV3Activity.this.mHasJsyh + PPSLabelView.Code + RefundV3Activity.this.mHasNyyh + PPSLabelView.Code + RefundV3Activity.this.mHasGsyh);
            if (RefundV3Activity.this.mSelectWay >= 0) {
                viewHolder.img2.setImageResource(R.mipmap.wxz);
                if (iIntValue == -22 || iIntValue == 22) {
                    viewHolder.img.setImageResource(R.mipmap.refund_zgyh);
                    viewHolder.tv_name.setText(RefundV3Activity.this.getString(R.string.zgyh));
                    if (RefundV3Activity.this.mHasZgyh != 0 && RefundV3Activity.this.mHasZgyh != iIntValue) {
                        viewHolder.rel_bg.setVisibility(8);
                    }
                    RefundV3Activity.this.mHasZgyh = iIntValue;
                } else if (iIntValue == -23 || iIntValue == 23) {
                    viewHolder.img.setImageResource(R.mipmap.refund_jsyh);
                    viewHolder.tv_name.setText(RefundV3Activity.this.getString(R.string.jsyh));
                    if (RefundV3Activity.this.mHasJsyh != 0 && RefundV3Activity.this.mHasJsyh != iIntValue) {
                        viewHolder.rel_bg.setVisibility(8);
                    }
                    RefundV3Activity.this.mHasJsyh = iIntValue;
                } else if (iIntValue == -24 || iIntValue == 24) {
                    viewHolder.img.setImageResource(R.mipmap.refund_nyyh);
                    viewHolder.tv_name.setText(RefundV3Activity.this.getString(R.string.nyyh));
                    if (RefundV3Activity.this.mHasNyyh != 0 && RefundV3Activity.this.mHasNyyh != iIntValue) {
                        viewHolder.rel_bg.setVisibility(8);
                    }
                    RefundV3Activity.this.mHasNyyh = iIntValue;
                } else if (iIntValue == -25 || iIntValue == 25) {
                    viewHolder.img.setImageResource(R.mipmap.refund_icbc);
                    viewHolder.tv_name.setText(RefundV3Activity.this.getString(R.string.icbc));
                    if (RefundV3Activity.this.mHasGsyh != 0 && RefundV3Activity.this.mHasGsyh != iIntValue) {
                        viewHolder.rel_bg.setVisibility(8);
                    }
                    RefundV3Activity.this.mHasGsyh = iIntValue;
                }
                if (RefundV3Activity.this.mSelectWay == i) {
                    viewHolder.img2.setImageResource(R.mipmap.xz1);
                }
            } else {
                viewHolder.rel_bg.setVisibility(8);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public ImageView img2;
            public RelativeLayout rel_bg;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.img = (ImageView) view.findViewById(R.id.img1);
                this.tv_name = (TextView) view.findViewById(R.id.textali);
                this.img2 = (ImageView) view.findViewById(R.id.img_select_ali);
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openFile() {
        this.mGetPictureWay = 1;
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType(UrlHttpUtil.FILE_TYPE_IMAGE);
        this.fromAlumn.launch(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void takePhoto() {
        this.mGetPictureWay = 2;
        File file = new File(getExternalCacheDir(), "refund_image.jpg");
        this.outputImage = file;
        if (file.exists()) {
            this.outputImage.delete();
        }
        try {
            if (this.outputImage.createNewFile()) {
                LogUtil.e("create", "新建文件成功 ");
            } else {
                LogUtil.e("create", "新建文件失败 ");
            }
            this.imageUri = FileProvider.getUriForFile(getActivity(), getPackageName() + ".fileprovider", this.outputImage);
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            intent.putExtra("output", this.imageUri);
            this.takePhoto.launch(intent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void initLaunch() {
        this.takePhoto = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.5
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult activityResult) {
                LogUtil.e(RefundV3Activity.TAG, "onActivityResult:" + activityResult.getResultCode());
                if (activityResult.getResultCode() == -1) {
                    RefundV3Activity refundV3Activity = RefundV3Activity.this;
                    refundV3Activity.startCropActivity(refundV3Activity.imageUri);
                }
            }
        });
        this.fromAlumn = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: client.android.yixiaotong.v3.ui.wallet.RefundV3Activity.6
            @Override // androidx.activity.result.ActivityResultCallback
            public void onActivityResult(ActivityResult activityResult) {
                Intent data = activityResult.getData();
                if (activityResult.getResultCode() != -1 || data == null) {
                    return;
                }
                LogUtil.e(RefundV3Activity.TAG, "registerForActivityResult:");
                RefundV3Activity.this.imageUri = data.getData();
                RefundV3Activity.this.startCropActivity(data.getData());
            }
        });
    }
}
