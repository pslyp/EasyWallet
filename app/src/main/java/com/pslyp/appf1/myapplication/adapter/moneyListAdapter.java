package com.pslyp.appf1.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.pslyp.appf1.myapplication.R;
import com.pslyp.appf1.myapplication.model.InExMoney;

import java.util.ArrayList;

/**
 * Created by User on 10/12/2560.
 */

public class moneyListAdapter extends ArrayAdapter<InExMoney> {

    private Context mContext;
    private ArrayList<InExMoney> mMoney;
    private int mLayoutId;

    public moneyListAdapter(@NonNull Context context, int resource, ArrayList<InExMoney> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mMoney = objects;
        this.mLayoutId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(mLayoutId, null);

        ImageView inEx = (ImageView) v.findViewById(R.id.picImageVeiew);
        TextView title = (TextView) v.findViewById(R.id.titleTextView);
        TextView money = (TextView) v.findViewById(R.id.moneyTextView);

        InExMoney listMoney = mMoney.get(position);

        inEx.setImageResource(listMoney.getPicture());
        title.setText(listMoney.getDetails());
        //money.setText(listMoney.getMoney());

        return v;
    }
}
