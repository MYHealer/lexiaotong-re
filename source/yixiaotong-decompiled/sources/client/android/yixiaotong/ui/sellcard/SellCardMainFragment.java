package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardMainFragment extends BaseFragment {
    ImageView mImgSex;
    private boolean mIsManager = false;
    SimpleDraweeView mIvMeIcon;
    ImageView mQiDong;
    TitleBar mTitleBar;
    TextView mTvChakanRecored;
    TextView mTvMeId;
    TextView mTvMeName;
    TextView mTvMeXueHao;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mImgSex = (ImageView) view.findViewById(R.id.img_sex);
        this.mTvMeName = (TextView) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (TextView) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (TextView) view.findViewById(R.id.tv_me_xuehao);
        this.mQiDong = (ImageView) view.findViewById(R.id.qidong);
        this.mTvChakanRecored = (TextView) view.findViewById(R.id.tv_chakanrecord);
    }

    public static SellCardMainFragment newInstance() {
        return new SellCardMainFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_sell_card_main, viewGroup, false);
        if (this.mWalletModel == null) {
            getActivity().finish();
            return viewInflate;
        }
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        initView();
        if (AppAccountManager.getInstance().getAppManagerAccount(this.mWalletModel.typeId) == this.mWalletModel.typeId) {
            this.mIsManager = true;
        }
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("开卡");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        Log.e("test", userInfo.Icon);
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(this.mUserInfoBean.Icon));
        if (this.mUserInfoBean.GenderId == 1) {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_boy));
        } else {
            this.mImgSex.setImageDrawable(getResources().getDrawable(R.mipmap.l_shouye_girl));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("ID：**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText("学号：" + this.mUserInfoBean.StudentNo);
        }
    }

    private void initView() {
        this.mQiDong.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardMainFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BluetoothManager.getInstance().isBluetoothOn()) {
                    if (AppUtils.isUserHuaWeiScan()) {
                        ScanQrcodeOrBarcodeActivity.launch(SellCardMainFragment.this.getActivity(), SellCardMainFragment.this.mWalletModel, "", 9);
                        return;
                    } else {
                        ZxingScanActivity.launch(SellCardMainFragment.this.getActivity(), SellCardMainFragment.this.mWalletModel, "", 9);
                        return;
                    }
                }
                SellCardMainFragment.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
            }
        });
        this.mTvChakanRecored.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardMainFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(SellCardMainFragment.this.getActivity(), 9);
            }
        });
        this.mQiDong.setOnTouchListener(new View.OnTouchListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardMainFragment.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return motionEvent.getX() < 100.0f || motionEvent.getY() < 100.0f || motionEvent.getX() > 480.0f || motionEvent.getY() > 480.0f;
            }
        });
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mWalletModel = ((SellCardMainActivity) activity).getmWalletModel();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001 && i2 == -1) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeOrBarcodeActivity.launch(getActivity(), this.mWalletModel, "", 9);
            } else {
                ZxingScanActivity.launch(getActivity(), this.mWalletModel, "", 9);
            }
        }
    }
}
