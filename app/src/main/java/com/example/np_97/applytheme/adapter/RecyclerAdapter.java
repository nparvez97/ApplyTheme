package com.example.np_97.applytheme.adapter;


import android.content.Context;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.np_97.applytheme.R;
import com.example.np_97.applytheme.model.Landscape;

import org.w3c.dom.Text;

import java.util.List;

import static android.content.ContentValues.TAG;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<Landscape> mDataList;
    private LayoutInflater mInflater;

    public RecyclerAdapter(Context context, List<Landscape> data){
        this.mDataList=data;
        this.mInflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG,"onCreatedViewHolder");
        View view= mInflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder "+ position);

        Landscape currentObj =mDataList.get(position);
        holder.setData(currentObj,position);
        holder.setListeners();
    }


    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void removeItem(int position){
        mDataList.remove(position);
        notifyItemRemoved(position);
    }
    public void addItem(int position,Landscape landscape){
        mDataList.add(position,landscape);
        notifyItemInserted(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title;
        ImageView imgThumb,imgDelete,imgAdd;
        int position;
        Landscape current;

        public MyViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb= (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete= (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd= (ImageView) itemView.findViewById(R.id.img_row_add);
        }

//        public MyViewHolder(View itemView) {
//            super(itemView);
//        }

        public void setData(Landscape current, int position) {
            this.title.setText(current.getTitle());
            this.imgThumb.setImageResource(current.getImageID());
            this.position = position;
            this.current= current;
        }

        public  void setListeners(){
           imgDelete.setOnClickListener(MyViewHolder.this);
            imgAdd.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v) {
            Log.i(TAG,"onclick before operation at position : " + position + " size : " + mDataList.size());
            switch (v.getId()){
                case R.id.img_row:
                    removeItem(position);
                    break;

                case R.id.img_row_add:
                    addItem(position,current);
                    break;
            }
            Log.i(TAG,"Onclick after operation size "+ mDataList.size());
        }
    }

}
