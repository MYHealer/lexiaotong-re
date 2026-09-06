package client.android.yixiaotong.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.RepairProcessBean;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RepairDetailAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<RepairProcessBean> repairDetailBeanList;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public RepairDetailAdapter(LayoutInflater layoutInflater, List<RepairProcessBean> list) {
        this.repairDetailBeanList = list;
        this.mInflater = layoutInflater;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.repairDetailBeanList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.repairDetailBeanList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view != null) {
            viewHolder = (ViewHolder) view.getTag();
        } else {
            view = this.mInflater.inflate(R.layout.repair_process_record_item, (ViewGroup) null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }
        RepairProcessBean repairProcessBean = this.repairDetailBeanList.get(i);
        viewHolder.head.setImageURI(UriUtil.parseUriOrNull(repairProcessBean.icon));
        viewHolder.name.setText(repairProcessBean.name);
        viewHolder.date.setText(repairProcessBean.time);
        viewHolder.content.setText(repairProcessBean.content.replace("\\n", IOUtils.LINE_SEPARATOR_UNIX));
        return view;
    }

    static class ViewHolder {
        TextView content;
        TextView date;
        SimpleDraweeView head;
        TextView name;

        private void initViewNew(View view) {
            this.head = (SimpleDraweeView) view.findViewById(R.id.iv_head);
            this.name = (TextView) view.findViewById(R.id.tv_name);
            this.date = (TextView) view.findViewById(R.id.tv_date);
            this.content = (TextView) view.findViewById(R.id.tv_content);
        }

        ViewHolder(View view) {
            initViewNew(view);
        }
    }
}
