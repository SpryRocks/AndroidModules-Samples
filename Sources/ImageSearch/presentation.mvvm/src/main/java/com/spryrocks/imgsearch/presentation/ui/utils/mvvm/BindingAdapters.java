package com.spryrocks.imgsearch.presentation.ui.utils.mvvm;

import android.databinding.BindingAdapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.adapters.ImagesAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class BindingAdapters {
    @BindingAdapter("src")
    public static void setImageSrc(ImageView view, File file) {
        if (file != null) {
            Glide.with(view).load(file).into(view);
        } else {
            Glide.with(view).clear(view);
        }
    }

    @BindingAdapter("items")
    public static void setItems(RecyclerView recyclerView, Collection<Image> items) {
        ImagesAdapter adapter = new ImagesAdapter(recyclerView.getContext());

        ArrayList<ImagesAdapter.ImageItem> list = new ArrayList<>();

        if (items != null) {
            for (Image image : items) {
                list.add(new ImagesAdapter.ImageItem(image));
            }
        }

        adapter.setImages(list);

        recyclerView.setAdapter(adapter);
    }
}
