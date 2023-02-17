package lad1.example.englishapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashSet;

public class NoteFragment extends Fragment {

    static ArrayList<String> notes = new ArrayList<>();
    static ArrayAdapter arrayAdapter;
    ListView listView;
    ImageView imgView;

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//
//        inflater.inflate(R.menu.note_menu, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        super.onOptionsItemSelected(item);
//
//        if(item.getItemId()==R.id.add_note){
//            Intent intent = new Intent(getContext(), NoteEditorActivity.class);
//            startActivity(intent);
//            return true;
//        }
//        return false;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgView=view.findViewById(R.id.imgView);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NoteEditorActivity.class);
                startActivity(intent);
            }
        });
        listView = view.findViewById(R.id.listView1);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences("lad1.example.englishapp", Context.MODE_PRIVATE);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("note", null);

        if(set == null) {
            notes.add("Example note");
        }else{
            notes = new ArrayList(set);
        }
        arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, notes);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), NoteEditorActivity.class);
                intent.putExtra("noteID",position);
                startActivity(intent);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                new AlertDialog.Builder(getContext())
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Cảnh báo!")
                        .setMessage("Bạn có chắc muốn xóa note này?")
                        .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        notes.remove(position);
                                        arrayAdapter.notifyDataSetChanged();
                                        SharedPreferences sharedPreferences = getContext().getSharedPreferences("lad1.example.englishapp", Context.MODE_PRIVATE);
                                        HashSet<String> set = new HashSet(NoteFragment.notes);
                                        sharedPreferences.edit().putStringSet("note", set).apply();
                                    }
                                }
                        )
                        .setNegativeButton("Không", null)
                        .show();

                return true;
            }
        });
    }
}