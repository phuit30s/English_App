package lad1.example.englishapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CoursesFragment extends Fragment {

    ArrayList<Courses> arrayList;
    CoursesAdapter coursesAdapter;
    ListView listView;

    public CoursesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView1);

        arrayList = init();

        coursesAdapter = new CoursesAdapter(getContext() , arrayList);

        listView.setAdapter(coursesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, CourseFragment2.newInstance(position));
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }

    public ArrayList<Courses> init(){
        ArrayList<Courses> tmp = new ArrayList<>();
        tmp.add(new Courses("Từ vựng theo chủ đề", R.drawable.chude));
        tmp.add(new Courses("Tiếng Anh chuyên ngành", R.drawable.chuyennganh));
        tmp.add(new Courses("Tiếng Anh cho người đi làm", R.drawable.dilam));
        tmp.add(new Courses("Các thì trong Tiếng Anh", R.drawable.tense));
        tmp.add(new Courses("",R.drawable.t, R.string.hello_blank_fragment));
        return tmp;
    }

}