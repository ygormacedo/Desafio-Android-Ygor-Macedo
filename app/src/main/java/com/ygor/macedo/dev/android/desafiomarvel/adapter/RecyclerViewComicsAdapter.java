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
import com.ygor.macedo.dev.android.desafiomarvel.data.model.Result;
import com.ygor.macedo.dev.android.desafiomarvel.view.HqDetailActivity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewComicsAdapter extends RecyclerView.Adapter<RecyclerViewComicsAdapter.ViewHolder> {

    private List<Result> results;

    public RecyclerViewComicsAdapter(List<Result> results) {
        this.results = results;
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
        Result result = results.get(position);
        viewHolder.bind(result);

        viewHolder.itemView.setOnClickListener(v -> {

            String transitionName = "image_" + position;
            Intent intent = new Intent(viewHolder.itemView.getContext(), HqDetailActivity.class);
            intent.putExtra("comic", result);
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
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewHq;
        private TextView textViewHqNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHq = itemView.findViewById(R.id.imageViewHq);
            textViewHqNumber = itemView.findViewById(R.id.textViewHqNumber);
        }

        private void bind(Result result) {
            Picasso.get().load(result.getThumbnail().getPath() + "/portrait_incredible." + result.getThumbnail().getExtension())
                    .placeholder(R.drawable.logo_marvel)
                    .error(R.drawable.logo_marvel)
                    .into(imageViewHq);

            textViewHqNumber.setText("# " + result.getIssueNumber());
        }
    }

    public void update(List<Result> resultList) {
        this.results = resultList;
        notifyDataSetChanged();
    }
}
