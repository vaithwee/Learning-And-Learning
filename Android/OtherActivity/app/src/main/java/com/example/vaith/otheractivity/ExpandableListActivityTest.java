package com.example.vaith.otheractivity;

import android.app.ExpandableListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/16.
 */
public class ExpandableListActivityTest extends ExpandableListActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        ExpandableListAdapter adapter = new ExpandableListAdapter() {

            int[] logos = new int[]{
                    R.drawable.logo_a,
                    R.drawable.logo_b,
                    R.drawable.logo_c
            };

            private String[] armTypes = new String[]{
              "神族","虫族","人族"
            };

            private String[][] arms = new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","电兵"},
                    {"小狗","刺蛇","飞龙","自爆飞机"},
                    {"机枪兵","护士MM","幽灵"}
            };

            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout layout = new LinearLayout(ExpandableListActivityTest.this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo = new ImageView(ExpandableListActivityTest.this);
                logo.setImageResource(logos[i]);
                layout.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(i).toString());
                layout.addView(textView);
                return layout;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView tv = getTextView();
                tv.setText(getChild(i, i1).toString());
                return tv;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return 0;
            }

            private TextView getTextView()
            {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableListActivityTest.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
        };

        setListAdapter(adapter);
    }

}
