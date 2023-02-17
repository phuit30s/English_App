package lad1.example.englishapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CoursesAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    TextView txtTenKhoaHoc;
    ImageView imgTenKhoaHoc;
    Context context;
    ArrayList<Courses> arrayList;

    public CoursesAdapter(Context context, ArrayList<Courses> list){
        arrayList = list;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.layout_item_courses, null);

        View divider = (View)view.findViewById(R.id.customdivider);

        txtTenKhoaHoc = view.findViewById(R.id.txtTenKhoaHoc);
        txtTenKhoaHoc.setText(arrayList.get(position).name);

        imgTenKhoaHoc = view.findViewById(R.id.imgTenKhoaHoc);
        imgTenKhoaHoc.setImageResource(arrayList.get(position).image);

        if (position == getCount()-1) {
            view.setEnabled(false);
            view.setClickable(false);
            view.setFocusable(false);
            view.setOnClickListener(null);
            divider.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        return view;
    }
}
