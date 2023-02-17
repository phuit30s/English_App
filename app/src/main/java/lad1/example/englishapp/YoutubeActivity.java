package lad1.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class YoutubeActivity extends YouTubeBaseActivity {

    public static String API_KEY="AIzaSyD8kG5d2zyYPgXqB5AEeEHDBJ2eyavHjf8";
    public static String ID_PLAYLIST="RDLVjuKd26qkNAw";
    public static String urlGetJson = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&playlistId="+ ID_PLAYLIST +"&key="+ API_KEY +"&maxResults=50";

    ListView listVideo;
    ArrayList<Videos> arrayList;
    VideosAdapter videosAdapter, adapter;
    ImageView imgBack;
    ArrayList<Videos> arrayListSearch;
    ToggleButton btnsort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        initSearchWidgets();
        btnsort = findViewById(R.id.btnsort);
        btnsort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    if (arrayListSearch!=null){
                        Collections.sort(arrayListSearch, Videos.VideosNameAZComparator);
                        videosAdapter.notifyDataSetChanged();
                    }else
                    {
                        Collections.sort(arrayList, Videos.VideosNameAZComparator);
                        videosAdapter.notifyDataSetChanged();
                    }
                }
                else
                {
                    if (arrayListSearch!=null) {
                        Collections.sort(arrayListSearch, Videos.VideosNameZAComparator);
                        videosAdapter.notifyDataSetChanged();
                    }else
                    {
                        Collections.sort(arrayList, Videos.VideosNameZAComparator);
                        videosAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        imgBack = findViewById(R.id.imgback);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listVideo = findViewById(R.id.listViewVideo);
        arrayList = new ArrayList<>();

        videosAdapter = new VideosAdapter(this, R.layout.row_video_youtube, arrayList);
        listVideo.setAdapter(videosAdapter);

        GetJsonYoutube(urlGetJson);

        listVideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(YoutubeActivity.this, DetailYoutubeActivity.class);
                intent.putExtra("idVideo",arrayList.get(position).getIdVideo());

                startActivity(intent);
            }
        });
    }

    private void GetJsonYoutube(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
//                            Toast.makeText(YoutubeActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                            JSONArray jsonItems = response.getJSONArray("items");

                            String TenVideo=""; String url =""; String idVideo = "";

                            for (int i=0;i<jsonItems.length();i++){
                                JSONObject jsonItem = jsonItems.getJSONObject(i);

                                JSONObject jsonSnippet = jsonItem.getJSONObject("snippet");

                                TenVideo = jsonSnippet.getString("title");

                                JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");

                                JSONObject jsonMedium = jsonThumbnail.getJSONObject("medium");

                                url=jsonMedium.getString("url");

                                JSONObject jsonResourceID = jsonSnippet.getJSONObject("resourceId");

                                idVideo = jsonResourceID.getString("videoId");

                                arrayList.add(new Videos(TenVideo, url, idVideo));
                            }
                            videosAdapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(YoutubeActivity.this, "Loi", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonObjectRequest);
    }

    public void initSearchWidgets(){
        SearchView searchView = (SearchView)findViewById(R.id.searchView);
        searchView.setIconifiedByDefault(true);
        searchView.setFocusable(true);
        searchView.setIconified(false);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayListSearch = new ArrayList<>();
                for(Videos videos: arrayList){
                    if (videos.getTenVideo().toLowerCase().contains(newText.toLowerCase()))
                    {
                        arrayListSearch.add(videos);
                    }
                }

                videosAdapter = new VideosAdapter(getApplicationContext(),R.layout.row_video_youtube,arrayListSearch);
                listVideo.setAdapter(videosAdapter);
                return false;
            }
        });
    }
}