package com.gameflag.gameflag;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class useradapter extends BaseAdapter {
    private LayoutInflater userInflater;
    private List<user> userList;

    public useradapter(Activity activity, List<user> userList) {
        userInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.userList = userList;
    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View lineView;
        lineView = userInflater.inflate(R.layout.extra_adapter_list, null);
        TextView textViewName = (TextView) lineView.findViewById(R.id.text1);
        TextView textViewskor = (TextView) lineView.findViewById(R.id.text2);

        user istek = userList.get(i);
        textViewName.setText(istek.getUserName());
        textViewskor.setText(istek.getUserImage());
        return lineView;
    }
}
