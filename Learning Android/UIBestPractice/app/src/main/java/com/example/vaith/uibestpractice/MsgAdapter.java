package com.example.vaith.uibestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vaith on 16/8/3.
 */
public class MsgAdapter extends ArrayAdapter<Msg>
{
    private int resourceID;
    public MsgAdapter(Context ctx, int resourceID, List<Msg> objects)
    {
        super(ctx, resourceID, objects);
        this.resourceID = resourceID;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent)
    {
        Msg msg = getItem(postion);
        View view;
        ViewHolder viewHolder;
        if (convertView != null)
        {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        else
        {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder = new ViewHolder();
            viewHolder.leftLayout = (LinearLayout) view.findViewById(R.id.left_layout);
            viewHolder.leftMsg = (TextView) view.findViewById(R.id.left_msg_lable);
            viewHolder.rightLayout = (LinearLayout) view.findViewById(R.id.right_layout);
            viewHolder.rightMsg = (TextView) view.findViewById(R.id.right_msg_label);
            view.setTag(viewHolder);
        }

        if (Msg.TYPE_RECEIVED == msg.getType())
        {
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }
        else if(Msg.TYPE_SEND == msg.getType())
        {
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }

        return view;
    }
}


class ViewHolder
{
    LinearLayout leftLayout;
    LinearLayout rightLayout;
    TextView leftMsg;
    TextView rightMsg;
}
