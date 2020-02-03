package com.example.chatting_project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<ChatData> mDataset;
    private String nick;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView TextView_NickName;
        public TextView TextView_Msg;
        public MyViewHolder(View v) {
            super(v);
            TextView_NickName=v.findViewById(R.id.TextView_NickName);
            TextView_Msg=v.findViewById(R.id.TextView_Msg);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<ChatData> myDataset, String nick) {
        mDataset = myDataset;
        this.nick=nick;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_row, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        ChatData chat = mDataset.get(position);
        holder.TextView_NickName.setText(chat.getNickName());
        holder.TextView_Msg.setText(chat.getMsg());
        if(nick.equals(chat.getNickName())){
            holder.TextView_NickName.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            holder.TextView_Msg.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset != null ? mDataset.size() : 0;
    }
    public void addChat(ChatData chatData){
        mDataset.add(chatData);
        notifyItemInserted(mDataset.size()-1);
    }
}
