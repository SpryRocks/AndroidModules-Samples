package com.spryrocks.imgsearch.presentation.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImageViewHolder> {
    private final List<ImageItem> items;

    private final LayoutInflater layoutInflater;

    public ImagesAdapter(Context context) {
        items = new ArrayList<>();
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_image, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        ImageItem item = items.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setImages(Collection<ImageItem> images) {
        items.clear();
        items.addAll(images);
        notifyDataSetChanged();
    }

    public static class ImageItem {
        private final Image image;

        public ImageItem(Image image) {
            this.image = image;
        }
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(ImageItem item) {
            Glide.with(imageView).load(item.image.url).into(imageView);
        }
    }
}
