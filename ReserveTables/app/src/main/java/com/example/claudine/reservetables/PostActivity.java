package com.example.claudine.reservetables;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.claudine.reservetables.R;
import com.example.claudine.reservetables.adapters.CommentsAdapter;
import com.example.claudine.reservetables.models.Comment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PostActivity extends AppCompatActivity {

    private ListView commentsList;
    private TextView name;
    private TextView postText;
    private TextView nComments;
    private ImageView imageView;
    private ArrayList<Comment> comments;
    private CommentsAdapter commentsAdapter;
    private EditText commentEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        commentsList = (ListView) findViewById(R.id.comments_list);
        name = (TextView) findViewById(R.id.post_name);
        postText = (TextView) findViewById(R.id.post_text);
        nComments = (TextView) findViewById(R.id.n_comments);
        imageView = (ImageView) findViewById(R.id.profile_image);
        commentEdit = (EditText) findViewById(R.id.comment_edit);

        try {
            Intent i = getIntent();
            String postName = i.getStringExtra("postName");
            String text = i.getStringExtra("postText");
            int comments = i.getIntExtra("comments", 0);
            String url = i.getStringExtra("image");

            name.setText(postName);
            postText.setText(text);
            nComments.setText(comments + " comments");

            if (url.equals("ruba")) {
                Picasso.with(this)
                        .load(R.drawable.ruba)
                        .into(imageView);
            }

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        Comment c1 = new Comment("", "khaleek hadyyy..3adyyy", "Ereeny Youhana");
        Comment c2 = new Comment("", "Hal7asek", "Salma Ali");
        comments = new ArrayList<>();
        comments.add(c1);
        comments.add(c2);
        commentsAdapter = new CommentsAdapter(this, comments);
        commentsList.setAdapter(commentsAdapter);
    }

    public void comment(View view) {
        if (commentEdit.getText().toString().equals(""))
            return;
        Comment c = new Comment("ruba" ,commentEdit.getText().toString(), "Ruba Ashraf");
        comments.add(c);
        commentsAdapter.notifyDataSetChanged();
        scrollMyListViewToBottom();
        commentEdit.setText("");
    }

    private void scrollMyListViewToBottom() {
        commentsList.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                commentsList.setSelection(commentsList.getCount() - 1);
            }
        });
    }
}

