package lad1.example.englishapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CourseFragment2 extends Fragment {

    ArrayList<Courses> arrayList;
    CoursesAdapter coursesAdapter;
    ListView listView;
    ImageView imgback;

    public CourseFragment2(){

    }

    public static CourseFragment2 newInstance(int pos){
        Bundle bundle = new Bundle();
        bundle.putInt("course", pos);
        CourseFragment2 coursesFragment2 = new CourseFragment2();
        coursesFragment2.setArguments(bundle);
        return coursesFragment2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_course2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();

        imgback = view.findViewById(R.id.imgback);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Trở về", Toast.LENGTH_SHORT).show();
                Backpresses();
            }
        });

        listView = view.findViewById(R.id.listView1);

        arrayList = initinside(bundle.getInt("course"));

        coursesAdapter = new CoursesAdapter(getContext() , arrayList);

        listView.setAdapter(coursesAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("item", arrayList.get(position));
                startActivity(intent);
            }
        });
    }

    private void Backpresses(){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new CoursesFragment()).commit();
    }

    public ArrayList<Courses> initinside(int pos){
        ArrayList<Courses> tmp = new ArrayList<>();
        switch (pos){
            case 0:
                tmp.add(new Courses("Gia đình",R.drawable.giadinh ,R.string.giadinh,R.drawable.giadinh));
                tmp.add(new Courses("Nhà cửa", R.drawable.nhacua, R.string.nhacua, R.drawable.nhacua));
                tmp.add(new Courses("Cơ thể người", R.drawable.body, R.string.cothenguoi, R.drawable.body));
                tmp.add(new Courses("Động vật", R.drawable.animal, R.string.dongvat, R.drawable.animal));
                tmp.add(new Courses("Thực vật", R.drawable.plant, R.string.thucvat, R.drawable.plant));
                tmp.add(new Courses("Trường học", R.drawable.school, R.string.truonghoc, R.drawable.school));
                tmp.add(new Courses("",R.drawable.t, R.string.hello_blank_fragment));
                break;
            case 1:
                tmp.add(new Courses("Cách học Tiếng Anh thương mại", R.drawable.thuongmai, R.string.sale, R.drawable.thuongmai));
                tmp.add(new Courses("Mẫu hội thoại Tiếng Anh du lịch", R.drawable.dulich, R.string.dulich, R.drawable.dulich));
                tmp.add(new Courses("Mẫu hội thoại Tiếng Anh xây dựng", R.drawable.xaydung, R.string.xaydung, R.drawable.xaydung));
                tmp.add(new Courses("Mẫu hội thoại Tiếng Anh nhà hàng - khách sạn", R.drawable.nhahangkhachsan, R.string.nhahang, R.drawable.nhahangkhachsan));
                tmp.add(new Courses("",R.drawable.t, R.string.hello_blank_fragment));
                break;
            case 2:
                tmp.add(new Courses("1. Chào hỏi", R.drawable.chaohoi, R.string.chaohoi, R.drawable.chaohoi));
                tmp.add(new Courses("2. Nói chuyện qua điện thoại", R.drawable.dienthoai, R.string.dienthoai, R.drawable.dienthoai));
                tmp.add(new Courses("3. Thảo luận công việc", R.drawable.thaoluan, R.string.thaoluan, R.drawable.thaoluan));
                tmp.add(new Courses("4. Lên lịch họp", R.drawable.lenlichhop, R.string.lenlichhop, R.drawable.lenlichhop));
                tmp.add(new Courses("5. Chào tạm biệt", R.drawable.chaotambiet, R.string.chaotambiet, R.drawable.chaotambiet));
                tmp.add(new Courses("6. Nhân viên mới", R.drawable.nhanvienmoi, R.string.nhanvienmoi, R.drawable.nhanvienmoi));
                tmp.add(new Courses("7. Báo giá", R.drawable.baogia, R.string.baogia, R.drawable.baogia));
                tmp.add(new Courses("8. Biết ơn", R.drawable.bieton, R.string.bieton, R.drawable.bieton));
                tmp.add(new Courses("9. Báo giá", R.drawable.xinphepnghi, R.string.xinphepnghi, R.drawable.xinphepnghi));
                tmp.add(new Courses("",R.drawable.t, R.string.hello_blank_fragment));
                break;
            case 3:
                tmp.add(new Courses("1. Hiện tại đơn", R.drawable.htd, R.string.noidungHTD));
                tmp.add(new Courses("2. Hiện tại tiếp diễn", R.drawable.httd, R.string.noidungHTTD));
                tmp.add(new Courses("3. Hiện tại hoàn thành", R.drawable.htht, R.string.noidungHTHT));
                tmp.add(new Courses("4. Hiện tại hoàn thành tiếp diễn", R.drawable.hthttd, R.string.noidungHTHTTD));
                tmp.add(new Courses("5. Quá khứ đơn", R.drawable.qkd, R.string.noidungQKD));
                tmp.add(new Courses("6. Quá khứ tiếp diễn", R.drawable.qktd, R.string.noidungQKTD));
                tmp.add(new Courses("7. Quá khứ hoàn thành", R.drawable.qkht, R.string.noidungQKHT));
                tmp.add(new Courses("8. Quá khứ hoàn thành tiếp diễn", R.drawable.qkhttd, R.string.noidungQKHTTD));
                tmp.add(new Courses("9. Tương lai đơn", R.drawable.tld, R.string.noidungTLD));
                tmp.add(new Courses("10. Tương lai tiếp diễn", R.drawable.tltd, R.string.noidungTLTD));
                tmp.add(new Courses("11. Tương lai hoàn thành", R.drawable.tlht, R.string.noidungTLHT));
                tmp.add(new Courses("12. Tương lai hoàn thành tiếp diễn", R.drawable.tlhttd, R.string.noidungTLHTTD));
                tmp.add(new Courses("",R.drawable.t, R.string.hello_blank_fragment));
        }
        return tmp;
    }
}