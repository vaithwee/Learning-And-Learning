package com.example.vaith.activityforresult;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by Vaith on 16/8/16.
 */
public class SelectCityActivity extends ExpandableListActivity {

    private String[] proivces = new String[]{
            "广东", "广西", "湖南"
    };

    private String[][] cities = new String[][]{
            {"广州","深圳","珠海","中山"},
            {"桂林","柳州","南宁","北海"},
            {"长沙","岳阳","衡阳","株洲"}
    };

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        ExpandableListAdapter adapter = new ExpandableListAdapter() {
            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return proivces.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return cities[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return proivces[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return cities[i][i1];
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

            private TextView getTextView()
            {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView tv = new TextView(SelectCityActivity.this);
                tv.setLayoutParams(lp);
                tv.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                tv.setPadding(36,0,0,0);
                tv.setTextSize(20);
                return tv;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                TextView tv = getTextView();
                tv.setText(getGroup(i).toString());
                return tv;
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
        };
        setListAdapter(adapter);

        getExpandableListView().setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Intent intent = getIntent();
                intent.putExtra("city", cities[i][i1]);
                SelectCityActivity.this.setResult(0, intent);
                SelectCityActivity.this.finish();
                return false;
            }
        });
    }
}
