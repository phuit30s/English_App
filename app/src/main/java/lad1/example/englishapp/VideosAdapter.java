package lad1.example.englishapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideosAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<Videos> videosList;

    public VideosAdapter(Context context, int layout, List<Videos> videosList) {
        this.context = context;
        this.layout = layout;
        this.videosList = videosList;
    }

    @Override
    public int getCount() {
        return videosList == null ? 0 : videosList.size();
    }

    @Override
    public Object getItem(int position) {
        return videosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgThumbnail;
        TextView txtTenVideo;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txtTenVideo = convertView.findViewById(R.id.txtTenVideo);
            holder.imgThumbnail=convertView.findViewById(R.id.imgThumbnail);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Videos videos = videosList.get(position);
        holder.txtTenVideo.setText(videos.getTenVideo());
        Picasso.with(context).load(videos.getThumbnail()).into(holder.imgThumbnail);

        return convertView;
    }
}
