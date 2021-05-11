package com.example.a16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class listAdapter extends RecyclerView.Adapter<listAdapter.WorldViewHolder> {
    private final LinkedList<String> mWordlist;
    private LayoutInflater mInflater;

    public listAdapter(Context context, LinkedList<String> mWordlist) {
        mInflater = LayoutInflater.from(context);
        this.mWordlist = mWordlist;
    }

    @NonNull
    @Override
    public listAdapter.WorldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.activity_container, parent, false);
        return new WorldViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull listAdapter.WorldViewHolder holder, int position) {
        String mCurrent = mWordlist.get(position);
        holder.mWord.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordlist.size();
    }

    public class WorldViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mWord;
        final listAdapter mAdapter;
        public WorldViewHolder(@NonNull View itemView, listAdapter mAdapter) {
            super(itemView);

            mWord = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();
            String element = mWordlist.get(mPosition);
            mWordlist.set(mPosition, " Clicked " + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
