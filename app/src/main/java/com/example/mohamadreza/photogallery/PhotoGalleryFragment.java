package com.example.mohamadreza.photogallery;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mohamadreza.photogallery.model.GalleryItem;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoGalleryFragment extends Fragment {


    private RecyclerView mRecyclerView;

    public static PhotoGalleryFragment newInstance() {
        Bundle args = new Bundle();
        PhotoGalleryFragment fragment = new PhotoGalleryFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public PhotoGalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_view_gallery);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),4));

        mRecyclerView.setAdapter(new PhotoAdapter(new ArrayList<GalleryItem>()));

        return view;
    }

    public class PhotoHolder extends RecyclerView.ViewHolder{

        private TextView mTitle;
        private GalleryItem mGalleryItem;

        public PhotoHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView;
        }

        public void bindGalleryItem(GalleryItem galleryItem){

            mTitle.setText(galleryItem.getTitle());
            mGalleryItem=galleryItem;
        }
    }

    public class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder>{

        private List<GalleryItem> mGalleryItems;

        public void setGalleryItems(List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        public PhotoAdapter(List<GalleryItem> galleryItems) {
            mGalleryItems = galleryItems;
        }

        @NonNull
        @Override
        public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PhotoHolder(new TextView(getActivity()));
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            GalleryItem galleryItem = mGalleryItems.get(position);
            holder.bindGalleryItem(galleryItem);
        }

        @Override
        public int getItemCount() {
            return mGalleryItems.size();
        }
    }

}
