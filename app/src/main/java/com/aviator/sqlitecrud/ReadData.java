package com.aviator.sqlitecrud;


import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aviator.sqlitecrud.com.aviator.adapter.MyModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadData extends Fragment {
DatabaseHelper databaseHelper;
RecyclerView recyclerView;
    public ReadData() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_read_data, container, false);
        databaseHelper=new DatabaseHelper(getContext());
        Init(view);
        return view;
    }

    void  Init(View V){

        FloatingActionButton fab = V.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData();
            }
        });

        recyclerView=V.findViewById(R.id.rec);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }


    void GetData(){

        Cursor cursor=databaseHelper.READ_DATA();
        ArrayList<MyModel> myModelArrayList=new ArrayList<>();

        if(cursor!=null && cursor.getCount()>0){

            while (cursor.moveToNext()){
                MyModel myModel=new MyModel();
                myModel.setId(cursor.getString(0));
                myModel.setName(cursor.getString(1));
                myModel.setEng(cursor.getString(2));
                myModel.setMath(cursor.getString(3));
                myModel.setKis(cursor.getString(4));
                myModelArrayList.add(myModel);
            }

        }


        recyclerView.setAdapter(new MyAdapter(myModelArrayList));

    }

    public String toString(){
        return "Read";
    }

    class MyAdapter extends RecyclerView.Adapter<MyCViewHolder>{

        ArrayList<MyModel> arrayList;

        public MyAdapter(ArrayList<MyModel> arrayList) {
            this.arrayList = arrayList;
        }

        @Override
        public MyCViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.rec_model,parent,false);

            MyCViewHolder myCViewHolder=new MyCViewHolder(view);

            return myCViewHolder;
        }

        @Override
        public void onBindViewHolder(MyCViewHolder holder, int position) {

            MyModel myModel=arrayList.get(position);
            holder.tid.setText(myModel.getId());
            holder.tname.setText(myModel.getName());
            holder.teng.setText(myModel.getEng());
            holder.tmath.setText(myModel.getMath());
            holder.tkis.setText(myModel.getKis());

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
    }

    class MyCViewHolder extends RecyclerView.ViewHolder{
        TextView tid,tname,teng,tmath,tkis;
        public MyCViewHolder(View itemView) {
            super(itemView);
            tid=itemView.findViewById(R.id.TID);
            tname=itemView.findViewById(R.id.TNAME);
            teng=itemView.findViewById(R.id.TENG);
            tmath=itemView.findViewById(R.id.TMATH);
            tkis=itemView.findViewById(R.id.TKIS);
        }
    }

}
