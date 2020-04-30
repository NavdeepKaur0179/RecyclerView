package com.app.recyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordListAdapter2 extends RecyclerView.Adapter<WordListAdapter2.WordViewHolder2> {
    private final LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private ItemClickListener clickListener;


    public WordListAdapter2(Context context,
                           LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder2(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordViewHolder2 holder, final int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
        holder.wordItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Use that to access the affected item in mWordList.
                String element = mWordList.get(position);
                // Change the word in the mWordList.
                mWordList.set(position, "Clicked! " + element);
                // Notify the adapter, that the data has changed so it can
                // update the RecyclerView to display the data.
                holder.wordItemView.setText("Clicked!!!! " + element);
               // Toast.makeText(this, mWordList.get(position)+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    public class WordViewHolder2 extends RecyclerView.ViewHolder {
        final TextView wordItemView;
        final WordListAdapter2 mAdapter;
        public WordViewHolder2(@NonNull View itemView, WordListAdapter2 wordListAdapter) {
            super(itemView);
            wordItemView=itemView.findViewById(R.id.word);
            this.mAdapter= wordListAdapter;
        }
    }
}
