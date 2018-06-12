package com.example.knbhatt.animation;

    import android.content.Intent;
    import android.media.MediaPlayer;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.view.animation.Animation;
    import android.view.animation.AnimationUtils;
    import android.widget.Button;
    import android.widget.LinearLayout;

    public class MainActivity extends AppCompatActivity {
        LinearLayout l1, l2;
        Button b;
        Animation uptodown, downtoup;
        MediaPlayer s;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            s = MediaPlayer.create(MainActivity.this, R.raw.song);
            b = (Button) findViewById(R.id.button);
            l1 = (LinearLayout) findViewById(R.id.L1);
            l2 = (LinearLayout) findViewById(R.id.L2);
            uptodown = AnimationUtils.loadAnimation(this, R.anim.uptodown);
            l1.setAnimation(uptodown);
            downtoup = AnimationUtils.loadAnimation(this, R.anim.downtoup);
            l2.setAnimation(uptodown);
            OnClickButtonListener();
        }

        public void OnClickButtonListener() {
            b.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent("com.example.knbhatt.animation.secondactivity");
                            startActivity(intent);
                            play();
                        }
                    }
            );
        }
        public void play(){
          s.start();
          }


    }