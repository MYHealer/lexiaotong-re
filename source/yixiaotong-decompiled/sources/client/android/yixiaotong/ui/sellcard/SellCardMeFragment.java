package client.android.yixiaotong.ui.sellcard;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.RecordListActivity;
import client.android.yixiaotong.ui.baoxiu.MalfunctionRepairActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SellCardMeFragment extends BaseFragment {
    SimpleDraweeView mIvMeIcon;
    RelativeLayout mRel;
    RelativeLayout mRelXiaoFei;
    TitleBar mTitleBar;
    EditText mTvMeId;
    EditText mTvMeName;
    EditText mTvMeXueHao;
    private UserInfoBean mUserInfoBean;
    private WalletModel mWalletModel;

    private void initViewNew(View view) {
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mRel = (RelativeLayout) view.findViewById(R.id.rel);
        this.mIvMeIcon = (SimpleDraweeView) view.findViewById(R.id.iv_me_icon);
        this.mTvMeName = (EditText) view.findViewById(R.id.tv_me_name);
        this.mTvMeId = (EditText) view.findViewById(R.id.tv_me_id);
        this.mTvMeXueHao = (EditText) view.findViewById(R.id.tv_me_xuehao);
        this.mRelXiaoFei = (RelativeLayout) view.findViewById(R.id.rel_xiaofei);
    }

    public static SellCardMeFragment newInstance() {
        return new SellCardMeFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_sell_card_me, viewGroup, false);
        initViewNew(viewInflate);
        initTitleBar();
        initInfoView();
        initView();
        return viewInflate;
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("开卡");
    }

    private void initInfoView() {
        UserInfoBean userInfo = getLoginAccount().getAccountManagetStore().getUserInfo();
        this.mUserInfoBean = userInfo;
        if (userInfo == null) {
            return;
        }
        this.mIvMeIcon.setImageURI(UriUtil.parseUriOrNull(userInfo.Icon));
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentName)) {
            this.mTvMeName.setText(this.mUserInfoBean.StudentName);
        }
        String str = this.mUserInfoBean.ID + "";
        if (StringUtils.isNotEmpty(str) && str.length() > 4) {
            this.mTvMeId.setText("**************" + str.substring(str.length() - 4, str.length()));
        }
        if (StringUtils.isNotEmpty(this.mUserInfoBean.StudentNo)) {
            this.mTvMeXueHao.setText(this.mUserInfoBean.StudentNo);
        }
    }

    private void initView() {
        UserInfoBean userInfoBean = this.mUserInfoBean;
        if (userInfoBean != null && userInfoBean.UserType == 1) {
            this.mRel.setVisibility(8);
        }
        this.mRel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardMeFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MalfunctionRepairActivity.launch(SellCardMeFragment.this.getActivity(), 9);
            }
        });
        this.mRelXiaoFei.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.sellcard.SellCardMeFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RecordListActivity.launch(SellCardMeFragment.this.getActivity(), 9);
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
}
