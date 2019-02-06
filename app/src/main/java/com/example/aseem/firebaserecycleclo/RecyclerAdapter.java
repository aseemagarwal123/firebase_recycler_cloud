package com.example.aseem.firebaserecycleclo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MHolder>{
    List<DModel> list;
    Context ctx;

    public RecyclerAdapter(List<DModel> list, Context ctx){
        this.list = list;
        this.ctx = ctx;
    }

    class MHolder extends RecyclerView.ViewHolder{
        TextView name,age;


        public MHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            age = itemView.findViewById(R.id.item_age);

        }
    }

    @Override
    public MHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(ctx).inflate(R.layout.item,parent,false);
        MHolder myHolder = new MHolder(view);

        return myHolder;
    }
    @Override
    public void onBindViewHolder(MHolder holder, int position) {
        DModel data=list.get(position);
        holder.age.setText(data.getName());
        holder.name.setText(data.getAge());
    }
    @Override
    public int getItemCount() {
        int ar = 0;
        try{
            if(list.size()==0){
                ar = 0;
            }
            else{
                ar=list.size();
            }
        }catch (Exception e){

        }
        return ar;
    }

}
