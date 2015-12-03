package com.example.claudine.reservetables;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.claudine.reservetables.adapters.PostsAdapter;
import com.example.claudine.reservetables.models.Post;

import java.util.ArrayList;

public class MyProfile extends AppCompatActivity {

    private ListView postsList;
    private PostsAdapter postsAdapter;
    private EditText postEditText;
    private ArrayList<Post> posts;

    public void followersMethod(View view){
        Intent intent= new Intent(MyProfile.this,followersPage.class);
        startActivity(intent);
    }


    public void followingMethod(View view){
        Intent intent= new Intent(MyProfile.this,following.class);
        startActivity(intent);
    }

    public void LikedReastaurantsMethod(View view){
        Intent intent= new Intent(MyProfile.this,LikedRestaurants.class);
        startActivity(intent);
    }

    public void post(View view) {
        if (postEditText.getText().toString().equals(""))
            return;
        Post p = new Post(0, postEditText.getText().toString(), "Ruba Ashraf", "ruba");
        posts.add(0, p);
        postsAdapter.notifyDataSetChanged();
        //scrollMyListViewToBottom();
        postEditText.setText("");
    }

    private void scrollMyListViewToBottom() {
        postsList.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                postsList.setSelection(postsList.getCount() - 1);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
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

        postsList = (ListView)findViewById(R.id.posts_list);
        postEditText = (EditText)findViewById(R.id.post_edit_text);


        Post p1 = new Post(6, "What is love?", "Claudine Yehia");
        Post p2 = new Post(2, "Baby don't hurt me!", "Radwa Khaled");
        Post p3 = new Post(23, "Ana Hanam! Hanam! Hanam!", "Ereeny Youhana");
        posts = new ArrayList<>();
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        postsAdapter = new PostsAdapter(this, posts);
        postsList.setAdapter(postsAdapter);


        postsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MyProfile.this, PostActivity.class);
                intent.putExtra("postName", posts.get(i).getUser());
                intent.putExtra("postText", posts.get(i).getText());
                intent.putExtra("comments", posts.get(i).getComments());
                intent.putExtra("image", posts.get(i).getImageUrl());
                startActivity(intent);
            }
        });

    }

}
