package com.ygor.macedo.dev.android.desafiomarvel.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.ygor.macedo.dev.android.desafiomarvel.R;
import com.ygor.macedo.dev.android.desafiomarvel.data.model.MarvelResults;
import com.ygor.macedo.dev.android.desafiomarvel.view.MarvelDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MarvelRecyclerViewAdapter extends RecyclerView.Adapter<MarvelRecyclerViewAdapter.ViewHolder> {

    private List<MarvelResults> marvelResults;

    public MarvelRecyclerViewAdapter(List<MarvelResults> marvelResults) {
        this.marvelResults = marvelResults;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_hq_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MarvelResults marvelResults = this.marvelResults.get(position);
        viewHolder.bind(marvelResults);

        viewHolder.itemView.setOnClickListener(v -> {

            String transitionName = "image_" + position;
            Intent intent = new Intent(viewHolder.itemView.getContext(), MarvelDetailActivity.class);
            intent.putExtra("comic", marvelResults);
            intent.putExtra("transitionName", transitionName);

            viewHolder.imageViewHq.setTransitionName(transitionName);

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) viewHolder.itemView.getContext(),
                            viewHolder.imageViewHq, transitionName);

            viewHolder.itemView.getContext().startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return marvelResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewHq;
        private TextView textViewHqNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHq = itemView.findViewById(R.id.imageViewHq);
            textViewHqNumber = itemView.findViewById(R.id.textViewHqNumber);
        }

        private void bind(MarvelResults marvelResults) {
            Picasso.get().load(marvelResults.getMarvelThumbnail().getPath() + "/portrait_incredible." + marvelResults.getMarvelThumbnail().getExtension())
                    .placeholder(R.drawable.marvel_logo)
                    .error(R.drawable.marvel_logo)
                    .into(imageViewHq);

            textViewHqNumber.setText("# " + marvelResults.getIssueNumber());
        }
    }

    public void update(List<MarvelResults> marvelResultsList) {
        this.marvelResults = marvelResultsList;
        notifyDataSetChanged();
    }
}
