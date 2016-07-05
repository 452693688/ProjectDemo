package com.framebase.base.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.framebase.app.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/12.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> dataList = new ArrayList<String>();

    public ListAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Handler handler;
        if (convertView == null) {
            handler = new Handler();
            convertView = LayoutInflater.from(context).inflate(R.layout.test_list_item, null);
            handler.tv = (TextView) convertView.findViewById(R.id.test_tv);
            convertView.setTag(handler);
        } else {
            handler = (Handler) convertView.getTag();
        }
        handler.tv.setText(dataList.get(position));
        return convertView;
    }

    class Handler {
        public TextView tv;
    }
}

