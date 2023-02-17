package lad1.example.englishapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txtTitle, txtNoiDung;
    ImageView imgBack, image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle=findViewById(R.id.txtTitle);
        txtNoiDung=findViewById(R.id.txtNoiDung);
        imgBack=findViewById(R.id.imgback);
        image2=findViewById(R.id.image2);

        Intent intent = getIntent();
        Courses courses = (Courses) intent.getSerializableExtra("item");
        if (courses != null){
            txtTitle.setText(courses.getName());
            txtNoiDung.setText(courses.getNoidung());
            image2.setImageResource(courses.getImage2());
        }

        //txtTitle.setText("Gia đình");
        //txtNoiDung.setText(R.string.giadinh);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}