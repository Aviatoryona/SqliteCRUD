package com.aviator.sqlitecrud;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertData extends Fragment {

    DatabaseHelper databaseHelper;
    EditText edtName,edtEng,edtMath,edtKis;
    Button button;
    public InsertData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_insert_data, container, false);
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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertNow();
            }
        });
    }


    void InsertNow(){

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

        boolean bool=databaseHelper.INSERT_DATA(name,eng,math,kis);
        if(bool){
            Toast.makeText(getContext(), "Data inserted", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();


    }

    public String toString(){
        return "Insert";
    }

}
