package client.android.yixiaotong.v4.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.WrapListView;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4AreaBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4SelectionDialog {
    private ArrayAdapter<V4AreaBean> adapter;
    private Button btnCancel;
    private Button btnConfirm;
    private Dialog dialog;
    private WrapListView listView;
    private OnSelectionCompleteListener listener;
    private Account mAccount;
    private Activity mActivity;
    private V4AreaBean mAreaBean;
    private String selectedBuilding;
    private String selectedRegion;
    private String selectedRoom;
    private int currentStep = 0;
    private String mId = "";
    private List<V4AreaBean> mAreaListData = new ArrayList();
    private int selectedPosition = 0;

    public interface OnSelectionCompleteListener {
        void onSelectionComplete(String str, String str2, String str3);
    }

    public V4SelectionDialog(Activity activity, Account account, OnSelectionCompleteListener onSelectionCompleteListener) {
        this.mAccount = account;
        this.mActivity = activity;
        this.listener = onSelectionCompleteListener;
        initDialog();
    }

    private void initDialog() {
        Dialog dialog = new Dialog(this.mActivity);
        this.dialog = dialog;
        dialog.setContentView(R.layout.v4_dialog_selection);
        this.dialog.setCancelable(false);
        this.listView = (WrapListView) this.dialog.findViewById(R.id.lv_selection);
        this.btnCancel = (Button) this.dialog.findViewById(R.id.btn_cancel);
        this.btnConfirm = (Button) this.dialog.findViewById(R.id.btn_confirm);
        this.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4SelectionDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m523x2e5730c8(view);
            }
        });
        this.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4SelectionDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m524xbb4447e7(view);
            }
        });
        ArrayAdapter<V4AreaBean> arrayAdapter = new ArrayAdapter<V4AreaBean>(this.mActivity, R.layout.v4_item_selection, R.id.textView, this.mAreaListData) { // from class: client.android.yixiaotong.v4.ui.dialog.V4SelectionDialog.1
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                TextView textView = (TextView) view2.findViewById(R.id.textView);
                textView.setText(getItem(i).name);
                if (i == V4SelectionDialog.this.selectedPosition) {
                    textView.setTextColor(-16776961);
                    textView.setTextSize(18.0f);
                } else {
                    textView.setTextColor(-16777216);
                    textView.setTextSize(16.0f);
                }
                return view2;
            }
        };
        this.adapter = arrayAdapter;
        this.listView.setAdapter((ListAdapter) arrayAdapter);
        setListViewHeightBasedOnItems(this.listView, 3);
        this.listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: client.android.yixiaotong.v4.ui.dialog.V4SelectionDialog.2
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    int firstVisiblePosition = V4SelectionDialog.this.listView.getFirstVisiblePosition();
                    View childAt = V4SelectionDialog.this.listView.getChildAt(0);
                    if (childAt != null) {
                        int height = childAt.getHeight();
                        int height2 = (((-childAt.getTop()) + (firstVisiblePosition * height)) + (V4SelectionDialog.this.listView.getHeight() / 2)) / height;
                        if (height2 < 0 || height2 >= V4SelectionDialog.this.mAreaListData.size()) {
                            return;
                        }
                        V4SelectionDialog.this.selectedPosition = height2;
                        V4SelectionDialog.this.adapter.notifyDataSetChanged();
                        V4SelectionDialog.this.listView.smoothScrollToPositionFromTop(V4SelectionDialog.this.selectedPosition, (V4SelectionDialog.this.listView.getHeight() / 2) - (height / 2));
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int i4 = i + (i2 / 2);
                if (i4 == V4SelectionDialog.this.selectedPosition || i4 < 0 || i4 >= V4SelectionDialog.this.mAreaListData.size()) {
                    return;
                }
                V4SelectionDialog.this.selectedPosition = i4;
                V4SelectionDialog.this.adapter.notifyDataSetChanged();
            }
        });
        getArea();
    }

    /* JADX INFO: renamed from: lambda$initDialog$0$client-android-yixiaotong-v4-ui-dialog-V4SelectionDialog, reason: not valid java name */
    /* synthetic */ void m523x2e5730c8(View view) {
        this.dialog.dismiss();
    }

    /* JADX INFO: renamed from: lambda$initDialog$1$client-android-yixiaotong-v4-ui-dialog-V4SelectionDialog, reason: not valid java name */
    /* synthetic */ void m524xbb4447e7(View view) {
        int i = this.currentStep;
        if (i == 2) {
            V4AreaBean v4AreaBean = this.mAreaListData.get(this.selectedPosition);
            this.mAreaBean = v4AreaBean;
            String str = v4AreaBean.name;
            this.selectedRoom = str;
            OnSelectionCompleteListener onSelectionCompleteListener = this.listener;
            if (onSelectionCompleteListener != null) {
                onSelectionCompleteListener.onSelectionComplete(this.selectedRegion, this.selectedBuilding, str);
            }
            this.dialog.dismiss();
            return;
        }
        if (i == 0) {
            V4AreaBean v4AreaBean2 = this.mAreaListData.get(this.selectedPosition);
            this.mAreaBean = v4AreaBean2;
            this.selectedRegion = v4AreaBean2.name;
            this.currentStep = 1;
            this.btnConfirm.setText("下一步");
            getArea();
            return;
        }
        if (i == 1) {
            V4AreaBean v4AreaBean3 = this.mAreaListData.get(this.selectedPosition);
            this.mAreaBean = v4AreaBean3;
            this.selectedBuilding = v4AreaBean3.name;
            this.currentStep = 2;
            this.btnConfirm.setText("完成");
            getArea();
        }
    }

    public void show() {
        this.dialog.show();
    }

    public void dismiss() {
        this.dialog.dismiss();
    }

    private void setListViewHeightBasedOnItems(ListView listView, int i) {
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            return;
        }
        int measuredHeight = 0;
        for (int i2 = 0; i2 < Math.min(i, adapter.getCount()); i2++) {
            View view = adapter.getView(i2, null, listView);
            view.measure(0, 0);
            measuredHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams layoutParams = listView.getLayoutParams();
        layoutParams.height = measuredHeight + (listView.getDividerHeight() * (i - 1));
        listView.setLayoutParams(layoutParams);
    }

    private void getArea() {
        V4AreaBean v4AreaBean = this.mAreaBean;
        if (v4AreaBean == null) {
            this.mId = "";
        } else {
            this.mId = v4AreaBean.id;
        }
        V4BusinessControllers.getInstance().getAreaList(this.mAccount, this.mId, new Listener<List<V4AreaBean>>() { // from class: client.android.yixiaotong.v4.ui.dialog.V4SelectionDialog.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<V4AreaBean> list, Object... objArr) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                V4SelectionDialog.this.mAreaListData.clear();
                V4SelectionDialog.this.mAreaListData = list;
                V4SelectionDialog.this.adapter.notifyDataSetChanged();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4SelectionDialog.this.dialog.isShowing()) {
                    SystemErrorTip.getInstance().showTipDialog(V4SelectionDialog.this.mActivity, clientException.getDetail());
                }
            }
        });
    }
}
