package com.kasimkartal866.mybookmedia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class SplashActivity extends AppCompatActivity {
    ImageView ivLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ivLogo = findViewById(R.id.imageView2);

        loadImage();


        Thread thread = new Thread() {
            @Override
            public void run () {
                try {

                    sleep(10000);
                }catch (Exception e) {

                    e.printStackTrace();
                }finally {

                    String name = MyPref.getInstance().getUserName();
                    if(name.equals(""))
                    {
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(intent);
                    }else
                    {
                        Intent intent = new Intent(getApplicationContext(),MainPageActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra(G.USER_NAME_INTENT_KEY, name);
                        finish();
                        startActivity(intent);
                    }
                }
            }
        };
        thread.start();
    }

    private void loadImage() {
        String url = "https://img.freepik.com/free-psd/ramadan-kareem-flyer-template_23-2148890463.jpg?w=740&t=st=1662725905~exp=1662726505~hmac=86eb571f1a2d5dba3814804361e6105b80dbe5c9e61ba721779a3e3cb7b6be82";

        Utilities.loadImage(this, url, ivLogo);
//        Glide
//                .with(this)
//                .load(url)
//                .centerCrop()
//                .placeholder(R.drawable.kitap)
//                .into(ivLogo);
    }


}