package com.example.claudine.reservetables;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Intent;
import android.widget.Button;

import android.widget.EditText;//

public class MainActivity extends AppCompatActivity {
    EditText NameEditText,editTextPhoneNumber,wordEditText;//
    ListView postsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NameEditText=(EditText)findViewById(R.id.editText);//
        wordEditText=(EditText)findViewById(R.id.editText2);//
        postsList = (ListView) findViewById(R.id.posts_list);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void signUpMethod(View view){
    Intent intent= new Intent(MainActivity.this,SignUp.class);
    startActivity(intent);
}

    public void WelcomePageMethod(View view){
        final String Name=NameEditText.getText().toString();
        final String word=wordEditText.getText().toString();
        if(Name.length()==0)
        {
            NameEditText.requestFocus();
            NameEditText.setError("FIELD CANNOT BE EMPTY");
        }
        else if(!Name.matches("[a-zA-Z ]+"))
        {
            NameEditText.requestFocus();
            NameEditText.setError("ENTER ONLY ALPHABETICAL CHARACTER");
        }
        else if(word.length()==0)
        {
            wordEditText.requestFocus();
            wordEditText.setError("FIELD CANNOT BE EMPTY");
        }




        else{
        Intent intent= new Intent(MainActivity.this,WelcomePage.class);
        startActivity(intent);
    }
    }

    public void MyProfileMethod(View view){
        Intent intent= new Intent(MainActivity.this,MyProfile.class);
        startActivity(intent);
    }
    

//    private void setupMessageButton(){
//        Button loginButton=(Button) findViewById(R.id.button);
//        loginButton.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v){
//                Toast.makeText(MainActivity.this, "You clicked it!",Toast.LENGTH_LONG).show();
//
//           startActivity(new Intent(MainActivity.this, WelcomePage.class));
//            }
//        });
//    }
}
