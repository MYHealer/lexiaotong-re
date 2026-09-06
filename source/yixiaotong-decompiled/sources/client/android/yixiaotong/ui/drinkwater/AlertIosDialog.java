package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AlertIosDialog {
    private static Dialog dialog;
    static Handler handler = new Handler() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.9
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                if (AlertIosDialog.timeCount > 0) {
                    AlertIosDialog.access$110();
                    AlertIosDialog.msgTextView.setText(AlertIosDialog.timeCount + AlertIosDialog.timeMessgae);
                    AlertIosDialog.handler.sendEmptyMessageDelayed(0, 1000L);
                } else {
                    AlertIosDialog.dialog.dismiss();
                    AlertIosDialog.handler.removeMessages(0);
                }
            } else {
                AlertIosDialog.handler.sendEmptyMessageDelayed(0, 1000L);
            }
            super.handleMessage(message);
        }
    };
    private static TextView msgTextView;
    private static int timeCount;
    private static String timeMessgae;
    private ViewGroup bgViewGroup;
    private Button cancleButton;
    private Context context;
    private Display display;
    private ViewGroup functionViewGroup;
    private TextView leftTextView;
    private ImageView lefticonImageView;
    private ViewGroup leftpanelViewGroup;
    private ImageView lineIamgeView;
    private List<ListItems> listListItems;
    private ViewGroup listViewGroup;
    private ScrollView mainScrollView;
    private ViewGroup mainViewGroup;
    private Button negButton;
    private Button posButton;
    private TextView rightTextView;
    private ImageView righticonImageView;
    private ViewGroup rightpanelViewGroup;
    private ViewGroup selectpanelViewGroup;
    private TextView titleTextView;
    private ViewGroup titleViewGroup;
    private boolean showTitle = false;
    private boolean showMsg = false;
    private boolean showPosBtn = false;
    private boolean showNegBtn = false;
    private boolean showSelsetPanel = false;
    private boolean setLeftOnClik = false;
    private boolean setRightOnClik = false;
    private boolean showList = false;
    private boolean showCountDown = false;
    private boolean showCanclebtn = false;

    public interface DialogItemClickListener {
        void confirm(String str);
    }

    public interface OnListItemsClickListener {
        void onClick(int i);
    }

    public interface OnTimeAlertViewClickListener {
        void confirm();
    }

    static /* synthetic */ int access$110() {
        int i = timeCount;
        timeCount = i - 1;
        return i;
    }

    private class ListItems {
        String itemname;
        ListItemsColor itemscolor;
        OnListItemsClickListener onListItemsClickListener;

        public ListItems(String str, ListItemsColor listItemsColor, OnListItemsClickListener onListItemsClickListener) {
            this.itemname = str;
            this.itemscolor = listItemsColor;
            this.onListItemsClickListener = onListItemsClickListener;
        }
    }

    public enum ListItemsColor {
        Blue("#037BFF"),
        Red("#FD4A2E");

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        ListItemsColor(String str) {
            this.name = str;
        }
    }

    public AlertIosDialog(Context context) {
        this.display = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.context = context;
    }

    private void init() {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.drink_water_view_alertdialog, (ViewGroup) null);
        this.bgViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_bg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_title);
        this.titleTextView = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_msg);
        msgTextView = textView2;
        textView2.setVisibility(8);
        Button button = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_neg);
        this.negButton = button;
        button.setVisibility(8);
        Button button2 = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_pos);
        this.posButton = button2;
        button2.setVisibility(8);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_line);
        this.lineIamgeView = imageView;
        imageView.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_select_panel);
        this.selectpanelViewGroup = viewGroup;
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_left_panel);
        this.leftpanelViewGroup = viewGroup2;
        viewGroup2.setVisibility(8);
        ViewGroup viewGroup3 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_right_panel);
        this.rightpanelViewGroup = viewGroup3;
        viewGroup3.setVisibility(8);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_right_icon);
        this.righticonImageView = imageView2;
        imageView2.setVisibility(8);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_left_icon);
        this.lefticonImageView = imageView3;
        imageView3.setVisibility(8);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_left_text);
        this.leftTextView = textView3;
        textView3.setVisibility(8);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_right_text);
        this.rightTextView = textView4;
        textView4.setVisibility(8);
        this.functionViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_function);
        ViewGroup viewGroup4 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_title);
        this.titleViewGroup = viewGroup4;
        viewGroup4.setVisibility(8);
        Button button3 = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_cancle);
        this.cancleButton = button3;
        button3.setVisibility(8);
        ViewGroup viewGroup5 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_list);
        this.listViewGroup = viewGroup5;
        viewGroup5.setVisibility(8);
        this.mainScrollView = (ScrollView) viewInflate.findViewById(R.id.view_alertdialog_scrollview_id);
        this.mainViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_mainview);
        this.bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (((double) this.display.getWidth()) * 0.85d), -2));
    }

    public AlertIosDialog builder(int i) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.drink_water_view_alertdialog, (ViewGroup) null);
        this.bgViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_bg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_title);
        this.titleTextView = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_msg);
        msgTextView = textView2;
        textView2.setVisibility(8);
        Button button = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_neg);
        this.negButton = button;
        button.setVisibility(8);
        Button button2 = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_pos);
        this.posButton = button2;
        button2.setVisibility(8);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_line);
        this.lineIamgeView = imageView;
        imageView.setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_select_panel);
        this.selectpanelViewGroup = viewGroup;
        viewGroup.setVisibility(8);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_left_panel);
        this.leftpanelViewGroup = viewGroup2;
        viewGroup2.setVisibility(8);
        ViewGroup viewGroup3 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_right_panel);
        this.rightpanelViewGroup = viewGroup3;
        viewGroup3.setVisibility(8);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_right_icon);
        this.righticonImageView = imageView2;
        imageView2.setVisibility(8);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.view_alertdialog_imageview_left_icon);
        this.lefticonImageView = imageView3;
        imageView3.setVisibility(8);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_left_text);
        this.leftTextView = textView3;
        textView3.setVisibility(8);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.view_alertdialog_textview_right_text);
        this.rightTextView = textView4;
        textView4.setVisibility(8);
        this.functionViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_function);
        ViewGroup viewGroup4 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_title);
        this.titleViewGroup = viewGroup4;
        viewGroup4.setVisibility(8);
        Button button3 = (Button) viewInflate.findViewById(R.id.view_alertdialog_button_cancle);
        this.cancleButton = button3;
        button3.setVisibility(8);
        ViewGroup viewGroup5 = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_list);
        this.listViewGroup = viewGroup5;
        viewGroup5.setVisibility(8);
        this.mainScrollView = (ScrollView) viewInflate.findViewById(R.id.view_alertdialog_scrollview_id);
        this.mainViewGroup = (ViewGroup) viewInflate.findViewById(R.id.view_alertdialog_layout_mainview);
        Dialog dialog2 = new Dialog(this.context, i);
        dialog = dialog2;
        dialog2.setContentView(viewInflate);
        if (i == R.style.ActionListDialogStyle) {
            Window window = dialog.getWindow();
            window.setGravity(83);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            window.setAttributes(attributes);
        }
        this.bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (((double) this.display.getWidth()) * 0.85d), -2));
        return this;
    }

    public AlertIosDialog setAlertDialogSize(double d) {
        this.bgViewGroup.setLayoutParams(new FrameLayout.LayoutParams((int) (((double) this.display.getWidth()) * d), -2));
        return this;
    }

    public AlertIosDialog setAlertDialogStyle(int i) {
        Dialog dialog2 = new Dialog(this.context, i);
        dialog = dialog2;
        Window window = dialog2.getWindow();
        window.setGravity(81);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.x = 0;
        attributes.y = 0;
        window.setAttributes(attributes);
        return this;
    }

    public AlertIosDialog setTitle(String str) {
        this.showTitle = true;
        if ("".equals(str)) {
            this.titleTextView.setText("标题");
        } else {
            this.titleTextView.setText(str);
            this.titleTextView.setTextSize(20.0f);
        }
        return this;
    }

    public AlertIosDialog setMsg(String str) {
        this.showMsg = true;
        if ("".equals(str)) {
            msgTextView.setText("内容");
        } else {
            msgTextView.setText(str);
            msgTextView.setGravity(3);
        }
        return this;
    }

    public AlertIosDialog setLoginMsg(String str) {
        this.showMsg = true;
        if ("".equals(str)) {
            msgTextView.setText("内容");
        } else {
            msgTextView.setText(str);
            msgTextView.setGravity(3);
        }
        return this;
    }

    public AlertIosDialog setSelsctPanel(int i, int i2, String str, String str2) {
        this.showSelsetPanel = true;
        if ("".equals(str)) {
            this.leftTextView.setVisibility(8);
        } else {
            this.leftTextView.setText(str);
            this.leftTextView.setVisibility(0);
        }
        if ("".equals(str2)) {
            this.rightTextView.setVisibility(8);
        } else {
            this.rightTextView.setText(str2);
            this.rightTextView.setVisibility(0);
        }
        if ("".equals(Integer.valueOf(i)) || i == 0) {
            this.lefticonImageView.setVisibility(8);
        } else {
            this.lefticonImageView.setBackgroundResource(i);
            this.lefticonImageView.setVisibility(0);
        }
        if ("".equals(Integer.valueOf(i2)) || i2 == 0) {
            this.righticonImageView.setVisibility(8);
        } else {
            this.righticonImageView.setBackgroundResource(i2);
            this.righticonImageView.setVisibility(0);
        }
        return this;
    }

    public AlertIosDialog setLeftPanelOnClick(final View.OnClickListener onClickListener) {
        this.setLeftOnClik = true;
        this.leftpanelViewGroup.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                AlertIosDialog.dialog.dismiss();
            }
        });
        return this;
    }

    public AlertIosDialog setRightPanelOnClick(final View.OnClickListener onClickListener) {
        this.setRightOnClik = true;
        this.rightpanelViewGroup.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                AlertIosDialog.dialog.dismiss();
            }
        });
        return this;
    }

    public AlertIosDialog setCancleable(boolean z) {
        dialog.setCancelable(z);
        return this;
    }

    public AlertIosDialog setPositiveButton(String str, final View.OnClickListener onClickListener, int i) {
        this.showPosBtn = true;
        if ("".equals(str)) {
            this.posButton.setText("确定");
        } else {
            this.posButton.setText(str);
            this.posButton.setTextColor(i);
        }
        this.posButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                AlertIosDialog.dialog.dismiss();
            }
        });
        return this;
    }

    public AlertIosDialog setCancleOnTouchOutside(boolean z) {
        dialog.setCanceledOnTouchOutside(z);
        return this;
    }

    public AlertIosDialog addListItems(String str, ListItemsColor listItemsColor, OnListItemsClickListener onListItemsClickListener) {
        this.showList = true;
        if (this.listListItems == null) {
            this.listListItems = new ArrayList();
        }
        this.listListItems.add(new ListItems(str, listItemsColor, onListItemsClickListener));
        return this;
    }

    public AlertIosDialog setCanaleBtnClickListener(String str, final View.OnClickListener onClickListener) {
        this.showCanclebtn = true;
        if ("".equals(str)) {
            this.cancleButton.setText("取消");
        } else {
            this.cancleButton.setText(str);
        }
        this.cancleButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                AlertIosDialog.dialog.dismiss();
            }
        });
        return this;
    }

    private void setListItems() {
        List<ListItems> list = this.listListItems;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = this.listListItems.size();
        if (size > 7) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mainScrollView.getLayoutParams();
            layoutParams.height = this.display.getHeight() / 2;
            this.mainScrollView.setLayoutParams(layoutParams);
        }
        for (final int i = 1; i <= size; i++) {
            ListItems listItems = this.listListItems.get(i - 1);
            String str = listItems.itemname;
            ListItemsColor listItemsColor = listItems.itemscolor;
            final OnListItemsClickListener onListItemsClickListener = listItems.onListItemsClickListener;
            TextView textView = new TextView(this.context);
            textView.setText(str);
            textView.setTextSize(18.0f);
            textView.setGravity(17);
            if (size == 1) {
                if (this.showTitle) {
                    textView.setBackgroundResource(R.drawable.selector_bottom_btn);
                } else {
                    textView.setBackgroundResource(R.drawable.selector_single_btn);
                }
            } else if (this.showTitle) {
                if (i >= 1 && i < size) {
                    textView.setBackgroundResource(R.drawable.selector_middle_btn);
                } else {
                    textView.setBackgroundResource(R.drawable.selector_bottom_btn);
                }
            } else if (i == 1) {
                textView.setBackgroundResource(R.drawable.selector_top_btn);
            } else if (i < size) {
                textView.setBackgroundResource(R.drawable.selector_middle_btn);
            } else {
                textView.setBackgroundResource(R.drawable.selector_bottom_btn);
            }
            if (listItemsColor == null) {
                textView.setTextColor(Color.parseColor(ListItemsColor.Blue.getName()));
            } else {
                textView.setTextColor(Color.parseColor(listItemsColor.getName()));
            }
            textView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) ((this.context.getResources().getDisplayMetrics().density * 45.0f) + 0.5f)));
            textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    onListItemsClickListener.onClick(i);
                    AlertIosDialog.dialog.dismiss();
                }
            });
            this.listViewGroup.addView(textView);
        }
    }

    public AlertIosDialog setNegativeButton(String str, final View.OnClickListener onClickListener, int i) {
        this.showNegBtn = true;
        if ("".equals(str)) {
            this.negButton.setText("取消");
        } else {
            this.negButton.setText(str);
            this.negButton.setTextColor(i);
        }
        this.negButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                AlertIosDialog.dialog.dismiss();
            }
        });
        return this;
    }

    public AlertIosDialog setCountDown(int i, String str, final OnTimeAlertViewClickListener onTimeAlertViewClickListener) {
        this.showCountDown = true;
        timeCount = i;
        timeMessgae = str;
        if ("".equals(str)) {
            msgTextView.setText("内容");
        } else {
            msgTextView.setText(timeCount + timeMessgae);
        }
        msgTextView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnTimeAlertViewClickListener onTimeAlertViewClickListener2 = onTimeAlertViewClickListener;
                if (onTimeAlertViewClickListener2 != null) {
                    onTimeAlertViewClickListener2.confirm();
                }
                AlertIosDialog.dialog.dismiss();
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.8
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                AlertIosDialog.handler.removeMessages(0);
                onTimeAlertViewClickListener.confirm();
            }
        });
        handler.sendEmptyMessage(-1);
        return this;
    }

    private void setLayout() {
        if (!this.showTitle && !this.showMsg && !this.showSelsetPanel && !this.showList) {
            this.titleTextView.setText("提示");
            this.titleTextView.setVisibility(0);
            this.titleViewGroup.setVisibility(0);
        }
        if (this.showTitle) {
            this.titleTextView.setVisibility(0);
            this.titleViewGroup.setVisibility(0);
        }
        if (this.showMsg) {
            msgTextView.setVisibility(0);
        }
        if (!this.showPosBtn && !this.showNegBtn && !this.showSelsetPanel && !this.showList) {
            this.posButton.setText("确定");
            this.posButton.setVisibility(0);
            this.functionViewGroup.setVisibility(0);
            this.posButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
            this.posButton.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.AlertIosDialog.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlertIosDialog.dialog.dismiss();
                }
            });
        }
        if (this.showPosBtn && this.showNegBtn && !this.showList) {
            this.posButton.setVisibility(0);
            this.posButton.setBackgroundResource(R.drawable.alertdialog_right_selector);
            this.negButton.setVisibility(0);
            this.negButton.setBackgroundResource(R.drawable.alertdialog_left_selector);
            this.lineIamgeView.setVisibility(0);
        }
        if (this.showPosBtn && !this.showNegBtn && !this.showList) {
            this.posButton.setVisibility(0);
            this.functionViewGroup.setVisibility(0);
            this.lineIamgeView.setVisibility(0);
            this.posButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
        if (!this.showPosBtn && this.showNegBtn && !this.showList) {
            this.negButton.setVisibility(0);
            this.functionViewGroup.setVisibility(0);
            this.lineIamgeView.setVisibility(0);
            this.negButton.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
        if (this.showSelsetPanel) {
            this.posButton.setVisibility(8);
            this.negButton.setVisibility(8);
            this.functionViewGroup.setVisibility(8);
            this.selectpanelViewGroup.setVisibility(0);
            this.leftpanelViewGroup.setVisibility(0);
            this.rightpanelViewGroup.setVisibility(0);
        }
        if (this.showList) {
            this.posButton.setVisibility(8);
            this.negButton.setVisibility(8);
            this.functionViewGroup.setVisibility(8);
            this.listViewGroup.setVisibility(0);
            setListItems();
        }
        if (this.showCountDown) {
            msgTextView.setVisibility(0);
        }
        if (this.showCanclebtn) {
            this.cancleButton.setVisibility(0);
        }
    }

    public void show() {
        setLayout();
        if (((Activity) this.context).isFinishing()) {
            return;
        }
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }
}
