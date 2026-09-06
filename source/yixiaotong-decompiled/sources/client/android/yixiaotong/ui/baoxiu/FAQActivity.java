package client.android.yixiaotong.ui.baoxiu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FAQActivity extends BaseActivity {
    private GridAdater mGridAdater;
    private GridView mGridView;
    private ImageView mImgAddQuestion;
    private List<String> mListData = new ArrayList();
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(6368);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) FAQActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mImgAddQuestion = (ImageView) findViewById(R.id.img_add_question);
        this.mGridView = (GridView) findViewById(R.id.gridview);
    }

    private void initTitlebar() {
        this.mTitleBar.setTitleView("问题反馈");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mImgAddQuestion.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.baoxiu.FAQActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mListData.clear();
        this.mListData.add("热水设备使用说明热水设备使用说明");
        this.mListData.add("账户退款流程");
        this.mListData.add("如何进行卡片充值");
        this.mListData.add("订单异常");
        this.mListData.add("设备蓝牙连接");
        this.mListData.add("(查看更多)");
        GridAdater gridAdater = new GridAdater();
        this.mGridAdater = gridAdater;
        this.mGridView.setAdapter((ListAdapter) gridAdater);
        this.mGridAdater.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
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
            return FAQActivity.this.mListData.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return FAQActivity.this.mListData.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(FAQActivity.this.getContext()).inflate(R.layout.faq_grid_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.mBtnItem.setText((CharSequence) FAQActivity.this.mListData.get(i));
            if (i < 3) {
                viewHolder.line1.setVisibility(0);
                viewHolder.line2.setVisibility(8);
            } else {
                viewHolder.line1.setVisibility(8);
                viewHolder.line2.setVisibility(0);
            }
            if (i == 5) {
                viewHolder.img.setVisibility(0);
            }
            return view;
        }

        class ViewHolder {
            public ImageView img;
            public View line1;
            public View line2;
            public TextView mBtnItem;

            public ViewHolder(View view) {
                this.mBtnItem = (TextView) view.findViewById(R.id.griditem);
                this.img = (ImageView) view.findViewById(R.id.img);
                this.line1 = view.findViewById(R.id.line1);
                this.line2 = view.findViewById(R.id.line2);
            }
        }
    }
}
