package com.example.claudine.reservetables.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.claudine.reservetables.R;
import com.example.claudine.reservetables.models.Comment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by salmaali on 12/3/15.
 */
public class CommentsAdapter extends ArrayAdapter<Comment>{


    private ArrayList<Comment> comments;
    private Context context;

    public CommentsAdapter(Context context, ArrayList<Comment> comments) {
        super(context, R.layout.comment_cell, comments);
        this.comments = comments;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView;
        LayoutInflater inflater = LayoutInflater.from(getContext());

        if(convertView == null) {
            customView = inflater.inflate(R.layout.comment_cell, parent, false);
        } else {
            customView = convertView;
        }

        TextView name = (TextView) customView.findViewById(R.id.post_name);
        TextView text = (TextView) customView.findViewById(R.id.post_text);
        ImageView image = (ImageView) customView.findViewById(R.id.profile_image);

        name.setText(comments.get(position).getUser());
        text.setText(comments.get(position).getText());

        if (comments.get(position).getImageUrl().equals("ruba")) {
            Picasso.with(context).load(R.drawable.ruba).into(image);
        } else {
            Picasso.with(context).load(R.drawable.avatar_placeholder).into(image);
        }



        return customView;
    }
}
