package com.example.claudine.reservetables.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.claudine.reservetables.R;
import com.example.claudine.reservetables.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by salmaali on 12/3/15.
 */
public class PostsAdapter extends ArrayAdapter<Post> {

    private ArrayList<Post> posts;
    private Context context;

    public PostsAdapter(Context context, ArrayList<Post> posts) {
        super(context, R.layout.post_cell, posts);
        this.posts = posts;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView;
        LayoutInflater inflater = LayoutInflater.from(getContext());

        if(convertView == null) {
            customView = inflater.inflate(R.layout.post_cell, parent, false);
        } else {
            customView = convertView;
        }

        TextView name = (TextView) customView.findViewById(R.id.post_name);
        TextView postsText = (TextView) customView.findViewById(R.id.post_text);
        TextView nComments = (TextView) customView.findViewById(R.id.n_comments);
        ImageView profileImage = (ImageView) customView.findViewById(R.id.profile_image);

        name.setText(posts.get(position).getUser());
        postsText.setText(posts.get(position).getText());
        nComments.setText(posts.get(position).getComments() + " comments");
        String imageName = posts.get(position).getImageUrl();
        if (imageName == "ruba") {
            Picasso.with(context)
                    .load(R.drawable.ruba)
                    .into(profileImage);
        } else {
            Picasso.with(context)
                    .load(R.drawable.avatar_placeholder)
                    .into(profileImage);
        }




        return customView;
    }
}
