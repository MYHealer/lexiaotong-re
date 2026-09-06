package client.android.yixiaotong.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import client.android.yixiaotong.R;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public final class ActivityDoorLockMeBinding implements ViewBinding {
    public final TextView btnRecord;
    public final TextView btnUserinfo;
    public final ImageView imgBack;
    public final ImageView imgIndenfity;
    public final ImageView imgRoom;
    public final ImageView imgSex;
    public final SimpleDraweeView ivMeIcon;
    public final LinearLayout linInfo;
    public final ListView lvList;
    public final RelativeLayout rel1;
    public final RelativeLayout relAboutme;
    public final RelativeLayout relIndenfity;
    public final RelativeLayout relRepair;
    public final RelativeLayout relRoom;
    public final RelativeLayout relTofeedback;
    public final RelativeLayout relTop;
    private final RelativeLayout rootView;
    public final ScrollView scrollview;
    public final TextView tvAbouttext;
    public final TextView tvFeedbacktext;
    public final TextView tvGetrecordtop;
    public final TextView tvId;
    public final TextView tvName;
    public final TextView tvRepairtext;
    public final TextView tvRoomaddress;
    public final TextView tvRoomtext;
    public final TextView tvTextid;
    public final TextView tvToabout;
    public final TextView tvTochangeaddress;
    public final TextView tvTofeedback;
    public final TextView tvTorepair;
    public final TextView tvVerfitytext;
    public final View view;
    public final View view1;

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    private ActivityDoorLockMeBinding(RelativeLayout relativeLayout, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, SimpleDraweeView simpleDraweeView, LinearLayout linearLayout, ListView listView, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, ScrollView scrollView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, View view, View view2) {
        this.rootView = relativeLayout;
        this.btnRecord = textView;
        this.btnUserinfo = textView2;
        this.imgBack = imageView;
        this.imgIndenfity = imageView2;
        this.imgRoom = imageView3;
        this.imgSex = imageView4;
        this.ivMeIcon = simpleDraweeView;
        this.linInfo = linearLayout;
        this.lvList = listView;
        this.rel1 = relativeLayout2;
        this.relAboutme = relativeLayout3;
        this.relIndenfity = relativeLayout4;
        this.relRepair = relativeLayout5;
        this.relRoom = relativeLayout6;
        this.relTofeedback = relativeLayout7;
        this.relTop = relativeLayout8;
        this.scrollview = scrollView;
        this.tvAbouttext = textView3;
        this.tvFeedbacktext = textView4;
        this.tvGetrecordtop = textView5;
        this.tvId = textView6;
        this.tvName = textView7;
        this.tvRepairtext = textView8;
        this.tvRoomaddress = textView9;
        this.tvRoomtext = textView10;
        this.tvTextid = textView11;
        this.tvToabout = textView12;
        this.tvTochangeaddress = textView13;
        this.tvTofeedback = textView14;
        this.tvTorepair = textView15;
        this.tvVerfitytext = textView16;
        this.view = view;
        this.view1 = view2;
    }

    public static ActivityDoorLockMeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityDoorLockMeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_door_lock_me, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityDoorLockMeBinding bind(View view) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.btn_record;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_userinfo;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.img_back;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.img_indenfity;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.img_room;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.img_sex;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.iv_me_icon;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ViewBindings.findChildViewById(view, i);
                                if (simpleDraweeView != null) {
                                    i = R.id.lin_info;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.lv_list;
                                        ListView listView = (ListView) ViewBindings.findChildViewById(view, i);
                                        if (listView != null) {
                                            i = R.id.rel1;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                            if (relativeLayout != null) {
                                                i = R.id.rel_aboutme;
                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                if (relativeLayout2 != null) {
                                                    i = R.id.rel_indenfity;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                    if (relativeLayout3 != null) {
                                                        i = R.id.rel_repair;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                        if (relativeLayout4 != null) {
                                                            i = R.id.rel_room;
                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                            if (relativeLayout5 != null) {
                                                                i = R.id.rel_tofeedback;
                                                                RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                if (relativeLayout6 != null) {
                                                                    i = R.id.rel_top;
                                                                    RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (relativeLayout7 != null) {
                                                                        i = R.id.scrollview;
                                                                        ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, i);
                                                                        if (scrollView != null) {
                                                                            i = R.id.tv_abouttext;
                                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView3 != null) {
                                                                                i = R.id.tv_feedbacktext;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.tv_getrecordtop;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView5 != null) {
                                                                                        i = R.id.tv_id;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.tv_name;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.tv_repairtext;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.tv_roomaddress;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.tv_roomtext;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.tv_textid;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.tv_toabout;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.tv_tochangeaddress;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i = R.id.tv_tofeedback;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView14 != null) {
                                                                                                                            i = R.id.tv_torepair;
                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView15 != null) {
                                                                                                                                i = R.id.tv_verfitytext;
                                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView16 != null && (viewFindChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view))) != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view1))) != null) {
                                                                                                                                    return new ActivityDoorLockMeBinding((RelativeLayout) view, textView, textView2, imageView, imageView2, imageView3, imageView4, simpleDraweeView, linearLayout, listView, relativeLayout, relativeLayout2, relativeLayout3, relativeLayout4, relativeLayout5, relativeLayout6, relativeLayout7, scrollView, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, viewFindChildViewById, viewFindChildViewById2);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
