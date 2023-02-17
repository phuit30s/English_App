package lad1.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class DetailYoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    YouTubePlayerView youTubePlayerView;
    String id = "";
    int VAN_ANH_NGU=1603;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_youtube);

        youTubePlayerView = findViewById(R.id.myYoutube);

        Intent intent = getIntent();
        id=intent.getStringExtra("idVideo");

        youTubePlayerView.initialize(YoutubeActivity.API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo(id);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(DetailYoutubeActivity.this, VAN_ANH_NGU);
        }else{
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==VAN_ANH_NGU){
            youTubePlayerView.initialize(YoutubeActivity.API_KEY, DetailYoutubeActivity.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}