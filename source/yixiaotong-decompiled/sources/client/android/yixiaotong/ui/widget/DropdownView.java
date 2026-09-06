package client.android.yixiaotong.ui.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DropdownView extends LinearLayout {
    private List<String> items;
    private ListView listView;
    private OnItemSelectedListener listener;
    private PopupWindow popupWindow;
    private TextView selectedItemView;

    public interface OnItemSelectedListener {
        void onItemSelected(int i, String str);
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.listener = onItemSelectedListener;
    }

    public DropdownView(Context context) {
        super(context);
        init(context);
    }

    public DropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        setOrientation(1);
        TextView textView = new TextView(context);
        this.selectedItemView = textView;
        textView.setPadding(16, 16, 16, 16);
        this.selectedItemView.setBackgroundResource(R.drawable.edit_text);
        addView(this.selectedItemView);
        setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.widget.DropdownView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m178lambda$init$0$clientandroidyixiaotonguiwidgetDropdownView(view);
            }
        });
        initPopupWindow(context);
    }

    /* JADX INFO: renamed from: lambda$init$0$client-android-yixiaotong-ui-widget-DropdownView, reason: not valid java name */
    /* synthetic */ void m178lambda$init$0$clientandroidyixiaotonguiwidgetDropdownView(View view) {
        toggleDropdown();
    }

    private void initPopupWindow(Context context) {
        ListView listView = new ListView(context);
        this.listView = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.widget.DropdownView$$ExternalSyntheticLambda1
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                this.f$0.m179x284df998(adapterView, view, i, j);
            }
        });
        PopupWindow popupWindow = new PopupWindow(this.listView, -1, -2);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.edit_text));
        this.popupWindow.setFocusable(true);
        this.popupWindow.setOutsideTouchable(true);
    }

    /* JADX INFO: renamed from: lambda$initPopupWindow$1$client-android-yixiaotong-ui-widget-DropdownView, reason: not valid java name */
    /* synthetic */ void m179x284df998(AdapterView adapterView, View view, int i, long j) {
        List<String> list = this.items;
        if (list == null || i >= list.size()) {
            return;
        }
        setSelectedItem(this.items.get(i));
        OnItemSelectedListener onItemSelectedListener = this.listener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(i, this.items.get(i));
        }
        this.popupWindow.dismiss();
    }

    public void setItems(List<String> list) {
        this.items = list;
        this.listView.setAdapter((ListAdapter) new ArrayAdapter(getContext(), R.layout.simple_list_item_1, list));
        if (list.isEmpty()) {
            return;
        }
        setSelectedItem(list.get(0));
    }

    public void setSelectedItem(String str) {
        this.selectedItemView.setText(str);
    }

    public String getSelectedItem() {
        return this.selectedItemView.getText().toString();
    }

    private void toggleDropdown() {
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
            return;
        }
        this.listView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.popupWindow.setWidth(getWidth());
        this.popupWindow.showAsDropDown(this);
    }
}
