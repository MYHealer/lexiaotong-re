package client.android.yixiaotong.ui.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import client.android.yixiaotong.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MyPopWindow {
    private LayoutInflater layoutInflater;
    private List<String> list = new ArrayList();
    private PopupWindow mPopWindow;
    private int mSelectIndex;

    public interface MyPopWindowListener {
        void onDiss();

        void onShow(int i);
    }

    public MyPopWindow(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void showPop(View view, int i, List<String> list, final MyPopWindowListener myPopWindowListener) {
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.mPopWindow.dismiss();
        }
        this.list = list;
        this.mSelectIndex = i;
        View viewInflate = this.layoutInflater.inflate(R.layout.listview_layout1, (ViewGroup) null);
        PopupWindow popupWindow2 = new PopupWindow(viewInflate);
        this.mPopWindow = popupWindow2;
        popupWindow2.setWidth(-1);
        this.mPopWindow.setHeight(-2);
        this.mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        this.mPopWindow.setOutsideTouchable(true);
        this.mPopWindow.setFocusable(true);
        showAsDropDown(this.mPopWindow, view, 0, 0);
        ListView listView = (ListView) viewInflate.findViewById(R.id.list);
        listView.setAdapter((ListAdapter) new PopAdapter());
        this.mPopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: client.android.yixiaotong.ui.adapter.MyPopWindow.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                myPopWindowListener.onDiss();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: client.android.yixiaotong.ui.adapter.MyPopWindow.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j) {
                MyPopWindow.this.mPopWindow.dismiss();
                MyPopWindow.this.mSelectIndex = i2;
                myPopWindowListener.onShow(i2);
            }
        });
    }

    public void dissPop() {
        PopupWindow popupWindow = this.mPopWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.mPopWindow.dismiss();
    }

    private void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        popupWindow.setHeight(view.getResources().getDisplayMetrics().heightPixels - rect.bottom);
        popupWindow.showAsDropDown(view, i, i2);
    }

    class PopAdapter extends BaseAdapter implements ListAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        PopAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return MyPopWindow.this.list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return MyPopWindow.this.list.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MyPopWindow.this.layoutInflater.inflate(R.layout.chongzhi_popwindow, (ViewGroup) null);
            }
            View viewFindViewById = view.findViewById(R.id.line);
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            ImageView imageView = (ImageView) view.findViewById(R.id.tv_select);
            textView.setText((CharSequence) MyPopWindow.this.list.get(i));
            if (i == MyPopWindow.this.mSelectIndex) {
                textView.setTextColor(-13516164);
                imageView.setVisibility(0);
            } else {
                textView.setTextColor(-10066330);
                imageView.setVisibility(4);
            }
            if (i == MyPopWindow.this.list.size() - 1) {
                viewFindViewById.setVisibility(0);
            }
            return view;
        }
    }
}
