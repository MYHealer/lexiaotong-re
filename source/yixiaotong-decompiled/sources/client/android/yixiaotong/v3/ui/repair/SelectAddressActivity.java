package client.android.yixiaotong.v3.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectAddressActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private AddressAdater mAddressAdater;
    private ListView mLvAddress;
    private TitleBar mVTitleBar;
    private List<String> mAddressData = new ArrayList();
    private int mSelectIndex = -1;

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.repair.SelectAddressActivity$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    static {
        StubApp.interface11(10190);
    }

    static /* synthetic */ void lambda$initClickListeners$1(View view) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) SelectAddressActivity.class));
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mLvAddress = (ListView) findViewById(R.id.lv_address);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("选择地址");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        AddressAdater addressAdater = new AddressAdater(this, null);
        this.mAddressAdater = addressAdater;
        this.mLvAddress.setAdapter((ListAdapter) addressAdater);
        this.mLvAddress.setOnItemClickListener(this);
        this.mAddressAdater.notifyDataSetChanged();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_selectaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.SelectAddressActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m419x4784ee0e(view);
            }
        });
        findViewById(R.id.btn_addaddress).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.repair.SelectAddressActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SelectAddressActivity.lambda$initClickListeners$1(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-repair-SelectAddressActivity, reason: not valid java name */
    /* synthetic */ void m419x4784ee0e(View view) {
        if (this.mSelectIndex == -1) {
            ToastUtils.show(getContext(), "请选择地址");
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mSelectIndex = i;
        this.mAddressAdater.notifyDataSetChanged();
    }

    private class AddressAdater extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        private AddressAdater() {
        }

        /* synthetic */ AddressAdater(SelectAddressActivity selectAddressActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SelectAddressActivity.this.mAddressData.size();
        }

        @Override // android.widget.Adapter
        public String getItem(int i) {
            return (String) SelectAddressActivity.this.mAddressData.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SelectAddressActivity.this.getContext()).inflate(R.layout.layout_repairaddress_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            String[] strArrSplit = getItem(i).split(",");
            viewHolder.tv_address.setText(strArrSplit[0]);
            viewHolder.tv_phone.setText("手机 " + strArrSplit[1].substring(0, 3) + "****" + strArrSplit[1].substring(7));
            if (i == SelectAddressActivity.this.mSelectIndex) {
                viewHolder.rel_bg.setBackgroundResource(R.drawable.shape_6f32fd_round_backgreund3);
            } else {
                viewHolder.rel_bg.setBackgroundResource(R.drawable.shape_a1a6b3_background);
            }
            return view;
        }

        class ViewHolder {
            RelativeLayout rel_bg;
            TextView tv_address;
            TextView tv_phone;

            public ViewHolder(View view) {
                this.tv_address = (TextView) view.findViewById(R.id.tv_address);
                this.tv_phone = (TextView) view.findViewById(R.id.tv_phone);
                this.rel_bg = (RelativeLayout) view.findViewById(R.id.rel_bg);
            }
        }
    }
}
