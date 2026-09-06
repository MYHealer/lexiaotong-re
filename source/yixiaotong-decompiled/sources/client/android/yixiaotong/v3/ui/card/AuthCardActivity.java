package client.android.yixiaotong.v3.ui.card;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.card.BindCardExtendJson;
import client.android.yixiaotong.v3.bean.card.SchoolCardInfoBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AuthCardActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = "AuthCardActivity";
    private RecordsAdapter mApdater;
    private String mCardId;
    private ListView mLvRecord;
    private TitleBar mTitleBar;
    private List<TypeInfoBean> mAppDatas = new ArrayList();
    private List<BindCardExtendJson> mExtendJsons = new ArrayList();
    private List<BindCardExtendJson> mAllExtendJsons = new ArrayList();
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(9614);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, List<BindCardExtendJson> list, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AuthCardActivity.class).putExtra("bean", (Serializable) list).putExtra("cardid", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mLvRecord = (ListView) findViewById(R.id.lv_record);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.deviceauthmanage));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initData() {
        List<TypeInfoBean> typeInfoBeans = InvestorInfoUtilControl.getInstance().getTypeInfoBeans();
        if (typeInfoBeans == null || typeInfoBeans.size() <= 0) {
            return;
        }
        for (int i = 0; i < typeInfoBeans.size(); i++) {
            LogUtil.e(TAG, i + "  " + typeInfoBeans.get(i).base.typeId + "  " + typeInfoBeans.get(i).base.appName + "  " + typeInfoBeans.get(i).useToolsJson.useCardFlag);
            for (int i2 = 0; i2 < this.mAllExtendJsons.size(); i2++) {
                if (this.mAllExtendJsons.get(i2).typeid == typeInfoBeans.get(i).base.typeId) {
                    this.mExtendJsons.add(this.mAllExtendJsons.get(i2));
                }
            }
            if (typeInfoBeans.get(i).useToolsJson.useCardFlag == 1) {
                this.mAppDatas.add(typeInfoBeans.get(i));
                int i3 = 0;
                while (true) {
                    if (i3 < this.mExtendJsons.size()) {
                        if (this.mExtendJsons.get(i3).typeid == typeInfoBeans.get(i).base.typeId) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        BindCardExtendJson bindCardExtendJson = new BindCardExtendJson();
                        bindCardExtendJson.typeid = typeInfoBeans.get(i).base.typeId;
                        bindCardExtendJson.status = 1;
                        this.mExtendJsons.add(bindCardExtendJson);
                        break;
                    }
                }
            } else {
                for (int i4 = 0; i4 < this.mExtendJsons.size(); i4++) {
                    if (this.mExtendJsons.get(i4).typeid == typeInfoBeans.get(i).base.typeId) {
                        List<BindCardExtendJson> list = this.mExtendJsons;
                        list.remove(list.get(i4));
                    }
                }
            }
        }
    }

    private void initView() {
        RecordsAdapter recordsAdapter = new RecordsAdapter();
        this.mApdater = recordsAdapter;
        this.mLvRecord.setAdapter((ListAdapter) recordsAdapter);
        this.mLvRecord.setOnItemClickListener(this);
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        LogUtil.e("test", "onItemClick:" + i);
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        BindCardExtendJson item = this.mApdater.getItem(i);
        BindCardExtendJson bindCardExtendJson = new BindCardExtendJson();
        bindCardExtendJson.typeid = item.typeid;
        bindCardExtendJson.createtime = item.createtime;
        bindCardExtendJson.logouttime = item.logouttime;
        if (item.status == 0) {
            bindCardExtendJson.status = 1;
            closeAuth(i, bindCardExtendJson);
        } else {
            bindCardExtendJson.status = 0;
            openAuth(i, bindCardExtendJson);
        }
    }

    private void openAuth(final int i, final BindCardExtendJson bindCardExtendJson) {
        if (StringUtils.isNotEmpty(this.mCardId)) {
            V3BusinessControllers.getInstance().postOpenApplyCard(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mCardId, bindCardExtendJson.typeid, new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.AuthCardActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BaseMaterialDialog.showMaterialDialog(AuthCardActivity.this.getActivity(), "正在授权中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                    if (AuthCardActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(AuthCardActivity.this.getContext(), "授权成功！");
                        AuthCardActivity.this.mExtendJsons.set(i, bindCardExtendJson);
                        AuthCardActivity.this.mApdater.notifyDataSetChanged();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (AuthCardActivity.this.mIsEnable) {
                        AuthCardActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    private void closeAuth(final int i, final BindCardExtendJson bindCardExtendJson) {
        if (StringUtils.isNotEmpty(this.mCardId)) {
            V3BusinessControllers.getInstance().postCloseApplyCard(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mCardId, bindCardExtendJson.typeid, new Listener<SchoolCardInfoBean>() { // from class: client.android.yixiaotong.v3.ui.card.AuthCardActivity.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    super.onStart(controller);
                    BaseMaterialDialog.showMaterialDialog(AuthCardActivity.this.getActivity(), "正在关闭授权中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SchoolCardInfoBean schoolCardInfoBean, Object... objArr) {
                    if (AuthCardActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(AuthCardActivity.this.getContext(), "关闭授权成功！");
                        AuthCardActivity.this.mExtendJsons.set(i, bindCardExtendJson);
                        AuthCardActivity.this.mApdater.notifyDataSetChanged();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (AuthCardActivity.this.mIsEnable) {
                        AuthCardActivity.this.onError(clientException);
                    }
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
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
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
            return AuthCardActivity.this.mExtendJsons.size();
        }

        @Override // android.widget.Adapter
        public BindCardExtendJson getItem(int i) {
            return (BindCardExtendJson) AuthCardActivity.this.mExtendJsons.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(AuthCardActivity.this.getContext()).inflate(R.layout.layout_authapp_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BindCardExtendJson item = getItem(i);
            for (int i2 = 0; i2 < AuthCardActivity.this.mAppDatas.size(); i2++) {
                if (((TypeInfoBean) AuthCardActivity.this.mAppDatas.get(i2)).base.typeId == item.typeid) {
                    viewHolder.tv_name.setText(LanguageUtils.getAppName(AuthCardActivity.this.getActivity(), ((TypeInfoBean) AuthCardActivity.this.mAppDatas.get(i2)).base.typeId, ((TypeInfoBean) AuthCardActivity.this.mAppDatas.get(i2)).base.appName));
                    if (item.status == 0) {
                        viewHolder.iv_switch.setImageResource(R.mipmap.open2);
                    } else {
                        viewHolder.iv_switch.setImageResource(R.mipmap.close2);
                    }
                }
            }
            return view;
        }

        class ViewHolder {
            public ImageView iv_switch;
            public TextView tv_name;

            public ViewHolder(View view) {
                this.tv_name = (TextView) view.findViewById(R.id.tv_name);
                this.iv_switch = (ImageView) view.findViewById(R.id.iv_switch);
            }
        }
    }
}
