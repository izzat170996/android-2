package com.dicoding.picodiploma.vespa.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.vespa.DetailActivity;
import com.dicoding.picodiploma.vespa.MoveActivity;
import com.dicoding.picodiploma.vespa.R;
import com.dicoding.picodiploma.vespa.Vespa;

import java.util.ArrayList;

public class ListVespaAdapter extends RecyclerView.Adapter<ListVespaAdapter.ListViewHolder> {
    private ArrayList<Vespa> listVespa;

    public ListVespaAdapter(ArrayList<Vespa> list) {
        this.listVespa = list;
    }

    private OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_vespa, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Vespa vespa = listVespa.get(position);
        Glide.with(holder.itemView.getContext())
                .load(vespa.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgphoto);
        holder.tvName.setText(vespa.getName());
        holder.tvDetail.setText(vespa.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listVespa.get(holder.getAdapterPosition()));

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);

                intent.putExtra("vespaImage", vespa.getPhoto());
                intent.putExtra("vespaNames", vespa.getName());
                intent.putExtra("vespaDetails", vespa.getDetail());

                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listVespa.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgphoto;
        TextView tvName, tvDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgphoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Vespa data);
    }
}
