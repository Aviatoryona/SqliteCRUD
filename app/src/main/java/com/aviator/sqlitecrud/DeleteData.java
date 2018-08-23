package com.aviator.sqlitecrud;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteData extends Fragment {

    DatabaseHelper databaseHelper;
    Button button;
    Spinner spinner;
    public DeleteData() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View V=inflater.inflate(R.layout.fragment_delete_data, container, false);
        databaseHelper=new DatabaseHelper(getContext());
        spinner=V.findViewById(R.id.spiner);
        button=V.findViewById(R.id.submit);
        GetData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               DeleteNow();
            }
        });
        return V;
    }


    private void DeleteNow() {
        int result=databaseHelper.DELETE_DATA(spinner.getSelectedItem().toString());
        Toast.makeText(getContext(), "Deleted. Affected Rows : "+result, Toast.LENGTH_SHORT).show();
    }

    void GetData(){

        Cursor cursor=databaseHelper.READ_DATA();
        ArrayList<String> arrayList=new ArrayList<>();
        if(cursor!=null && cursor.getCount()>0){

            while (cursor.moveToNext()){
                arrayList.add(cursor.getString(0));
            }

        }

        String[] data=new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            data[i]=arrayList.get(i);
        }
        spinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, data));
    }

    public String toString(){
        return "Delete";
    }

}
