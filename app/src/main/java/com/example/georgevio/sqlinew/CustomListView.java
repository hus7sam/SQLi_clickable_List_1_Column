package com.example.georgevio.sqlinew;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListView  extends ArrayAdapter<Empl> {
    private LayoutInflater mInflater;
    private ArrayList<Empl> empls;
    private int mViewResourceId;

    public CustomListView(Context context, int textViewResourceId, ArrayList<Empl> empls) {
        super(context, textViewResourceId, empls);
        this.empls = empls;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        Empl empl = empls.get(position);

        if (empl != null) {
            TextView Name = (TextView) convertView.findViewById(R.id.NameText);
            TextView phone = (TextView) convertView.findViewById(R.id.phoneText);
            TextView emile = (TextView) convertView.findViewById(R.id.emileText);
            TextView Age = (TextView) convertView.findViewById(R.id.AgeText);
            if (Name != null) {
                Name.setText(empl.getName());
            }
            if (phone != null) {
                phone.setText((empl.getPhone()));
            }

            if (emile != null) {
                emile.setText((empl.getEmail()));
            }
            if (Age != null) {
                Age.setText(empl.getName());
            }
        }

        return convertView;
    }
}
