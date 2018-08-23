package com.aviator.sqlitecrud;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.aviator.sqlitecrud.com.aviator.adapter.MyModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateData extends Fragment {

    DatabaseHelper databaseHelper;
    EditText edtName,edtEng,edtMath,edtKis;
    Button button;
    Spinner spinner;
    public UpdateData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_update_data, container, false);
        databaseHelper=new DatabaseHelper(getContext());
        Init(view);
        return  view;
    }


    void Init(View V){
        edtName=V.findViewById(R.id.edtName);
        edtEng=V.findViewById(R.id.edtEng);
        edtMath=V.findViewById(R.id.edtMath);
        edtKis=V.findViewById(R.id.edtKis);
        button=V.findViewById(R.id.submit);

        spinner=V.findViewById(R.id.spiner);
        GetData();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateNow();
            }
        });
    }

    void GetData(){

        try {
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
        } catch (Exception e) {
            Toast.makeText(getContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    void UpdateNow(){

        if(TextUtils.isEmpty(edtName.getText().toString())){
            edtName.setError("Required");
            return;
        }
        if(TextUtils.isEmpty(edtEng.getText().toString())){
            edtEng.setError("Required");
            return;
        }
        if(TextUtils.isEmpty(edtMath.getText().toString())){
            edtMath.setError("Required");
            return;
        }
        if(TextUtils.isEmpty(edtKis.getText().toString())){
            edtKis.setError("Required");
            return;
        }

        String name=edtName.getText().toString();
        String eng=edtEng.getText().toString();
        String math=edtMath.getText().toString();
        String kis=edtKis.getText().toString();

        boolean bool=databaseHelper.UPDATE_DATA(spinner.getSelectedItem().toString(),name,eng,math,kis);
        if(bool){
            Toast.makeText(getContext(), "Data updated", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();


    }

    public String toString(){
        return "Update";
    }

}
