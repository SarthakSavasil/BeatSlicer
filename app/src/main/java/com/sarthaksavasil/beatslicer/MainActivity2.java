package com.sarthaksavasil.beatslicer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;



public class MainActivity2 extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    Button playBtn;
    Button start;
    Button nextBtn;
    int c =0;
    int j;
    int i;

    int position = -1;
    int arr[][] = new int[8][5];
    //static ArrayList<MusicFiles> listSongs = new ArrayList<>();
    static Uri uri;
    static MediaPlayer mediaPlayer;
    static MediaPlayer mediaPlayer2;
    static MediaPlayer dummyPlayer;

    private Handler handler = new Handler();

    private Thread playThread,nextThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.w("log12", "onCreate:x "+ "i is" +j+" "+c);
        c++;

        playBtn = findViewById(R.id.rep);
        start = findViewById(R.id.start);
        nextBtn= findViewById(R.id.next);
        playBtn.setBackgroundResource(R.drawable.circular);
        start.setBackgroundResource(R.drawable.circular);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntentMethod();
                start.setVisibility(View.GONE);
                playBtn.setVisibility(View.VISIBLE);
            }
        });
        //getIntentMethod();
        Log.w("log13", "onCreate:x "+ "i is"+j +" "+c);
        c++;

        playBtn = findViewById(R.id.rep);
        start = findViewById(R.id.start);
        nextBtn= findViewById(R.id.next);

        MainActivity2.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer !=null)
                {
                    Log.w("log14", "onCreate:x "+ "i is"+j  +" "+c);
                    c++;
                }
                handler.postDelayed(this,500);
            }
        });

    }

    @Override
    protected void onResume() {
        Log.w("log16", "onCreate:x "+ "i is"+j  +" "+c);
        c++;
        playThreadBtn();
        nextThreadBtn();
        // prevThreadBtn();
        super.onResume();

    }


    private void nextThreadBtn() {
        Log.w("log26", "onCreate:x "+ "i is"  +" "+c);
        c++;
        nextThread = new Thread(){
            @Override
            public void run() {
                super.run();
                Log.w("log27", "onCreate:x "+ "i is"+j  +" "+c);
                c++;
                nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        nextBtnClicked();
                    }
                });
            }};
        nextThread.start();
    }

    private void nextBtnClicked() {
        Log.w("log28", "onCreate:x " + "i is" + j + " " + c);
        c++;

            if (mediaPlayer.isPlaying()) {
                Log.w("log29", "onCreate:x " + "i is" + j + " " + c);
                c++;
                mediaPlayer.stop();
                mediaPlayer.release();

                j = (j + 1) % 5;
                if (arr[0][j] == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.clap);
                } else {
                    mediaPlayer = MediaPlayer.create(this, R.raw.silence);
                }
                for (i=1;i<8;i++)
                {
                    if (arr[i][j] == 1) {
                        callMediaPlayer2(i);
                    }
                }
                MainActivity2.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.w("log30", "onCreate:x " + "i is" + j + " " + c);
                        c++;
                        if (mediaPlayer != null) {
                            Log.w("log31", "onCreate:x " + "i is" + " " + c);
                            c++;
                        }
                        handler.postDelayed(this, 500);
                    }
                });
                mediaPlayer.setOnCompletionListener(this);
                playBtn.setText("Play");
                //playBtn.setBackgroundResource(R.drawable.ic_pause);
                mediaPlayer.start();


            } else {
                Log.w("log32", "onCreate:x " + "i is" + j + " " + c);
                c++;
                mediaPlayer.stop();
                mediaPlayer.release();

                j = (j + 1) % 5;
                if (arr[0][j] == 1) {
                    mediaPlayer = MediaPlayer.create(this, R.raw.clap);
                } else {
                    mediaPlayer = MediaPlayer.create(this, R.raw.silence);
                }
                for (i=1;i<8;i++)
                {
                    if (arr[i][j] == 1) {
                        callMediaPlayer2(i);
                    }
                }
                //    position = (position+1)%(listSongs.size());

                MainActivity2.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mediaPlayer != null) {

                        }
                        handler.postDelayed(this, 500);
                    }
                });
                mediaPlayer.setOnCompletionListener(this);
                playBtn.setText("Pause");
                //playBtn.setBackgroundResource(R.drawable.ic_play);
            }
        }


    private void callMediaPlayer2(int n) {
        if(n==1)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.openhat);
            mediaPlayer2.start();
        }
        if(n==2)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.kick);
            mediaPlayer2.start();
        }if(n==3)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.tom);
            mediaPlayer2.start();
        }if(n==4)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.snare);
            mediaPlayer2.start();
        }if(n==5)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.pia1);
            mediaPlayer2.start();
        }
        if(n==6)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.d);
            mediaPlayer2.start();
        }if(n==7)
        {
            mediaPlayer2 = MediaPlayer.create(this, R.raw.e);
            mediaPlayer2.start();
        }
    }


//    private int getRandom(int i) {
//        Random random = new Random();
//
//        return random.nextInt(i+1);
//    }

    private void playThreadBtn() {
        Log.w("log1", "onCreate:x "+ "i is"+j  +" "+c);
        c++;
        playThread = new Thread(){
            @Override
            public void run() {
                super.run();
                Log.w("log2", "onCreate:x "+ "i is"+j  +" "+c);
                c++;
                playBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playBtnClicked();
                    }
                });
            }};
        playThread.start();
    }

    private void playBtnClicked() {
        Log.w("log3", "onCreate:x "+ "i is"+j +" "+c);
        c++;
        if(mediaPlayer.isPlaying())
        {
            Log.w("log4", "onCreate:x "+ "i is"+j  +" "+c);
            c++;
            playBtn.setText("Play");
            //playBtn.setImageResource(R.drawable.ic_play);
            mediaPlayer.pause();


            MainActivity2.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.w("log5", "onCreate:x "+ "i is"+j  +" "+c);
                    c++;
                    if(mediaPlayer !=null)
                    {
                        Log.w("log6", "onCreate:x "+ "i is"+j +" "+c);
                        c++;
                    }
                    handler.postDelayed(this,500);
                }
            });
        }
        else
        {
            Log.w("7", "onCreate:x "+ "i is"+j  +" "+c);
            c++;
            playBtn.setText("Pause");
            //playBtn.setImageResource(R.drawable.ic_pause);
            mediaPlayer.start();
            MainActivity2.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.w("log8", "onCreate:x "+ "i is"+j  +" "+c);
                    c++;
                    if(mediaPlayer !=null)
                    {
                    }
                    handler.postDelayed(this,500);
                }
            });

        }
    }

    private void getIntentMethod() {
//        position = getIntent().getIntExtra("position",-1);
        for(int i=0;i<8;i++)

            if(mediaPlayer !=null)
            {
                mediaPlayer.stop();
                mediaPlayer.release();
            }

        if(true)
        {
            playBtn.setText("Play");
            //playBtn.setImageResource(R.drawable.ic_pause);
            //uri = Uri.parse(listSongs.get(position).getPath());
        }

        j=0;
        if(arr[0][j]==1)
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.clap);
        }
        else
        {
            mediaPlayer = MediaPlayer.create(this,R.raw.silence);
        }

        //mediaPlayer = MediaPlayer.create(getApplicationContext(),uri);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(this);

    }


    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.w("log9", "onCreate:x "+ "i is"+j +" "+c);
        c++;
        nextBtnClicked();
        Log.w("log10", "onCreate:x "+ "i is"+j  +" "+c);
        c++;
        if(mediaPlayer!=null)
        {
            Log.w("log11", "onCreate:x "+ "i is"+j  +" "+c);
            c++;
            if(arr[0][j]==1)
            {
                mediaPlayer = MediaPlayer.create(this,R.raw.clap);
            }
            else
            {
                mediaPlayer = MediaPlayer.create(this,R.raw.silence);
            }
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(this);
        }
    }


    public void play11(View view){
        if(arr[0][0] == 0 )     arr[0][0]=1;
        else                    arr[0][0]=0;
        if(arr[0][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(1);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
        //playing(1);
    }
    public void play12(View view){
        if(arr[0][1] == 0 )     arr[0][1]=1;
        else                    arr[0][1]=0;
        if(arr[0][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(1);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play13(View view){
        if(arr[0][2] == 0 )     arr[0][2]=1;
        else                    arr[0][2]=0;
        if(arr[0][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(1);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play14(View view){
        if(arr[0][3] == 0 )     arr[0][3]=1;
        else                    arr[0][3]=0;
        if(arr[0][3] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(1);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play15(View view){
        if(arr[0][4] == 0 )     arr[0][4]=1;
        else                    arr[0][4]=0;
        if(arr[0][4] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(1);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
        Log.w("Sarthak", "play15: "+arr[0][4] );
    }

    public void play21(View view){
        if(arr[1][0] == 0 )     arr[1][0]=1;
        else                    arr[1][0]=0;
        if(arr[1][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(2);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play22(View view){
        if(arr[1][1] == 0 )     arr[1][1]=1;
        else                    arr[1][1]=0;
        if(arr[1][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(2);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play23(View view){
        if(arr[1][2] == 0 )     arr[1][2]=1;
        else                    arr[1][2]=0;
        if(arr[1][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(2);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play24(View view){
        if(arr[1][3] == 0 )     arr[1][3]=1;
        else                    arr[1][3]=0;
        if(arr[1][3] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(2);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play25(View view){
        if(arr[1][4] == 0 )     arr[1][4]=1;
        else                    arr[1][4]=0;
        if(arr[1][4] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(2);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }

    public void play31(View view) {
        if(arr[2][0] == 0 )     arr[2][0]=1;
        else                    arr[2][0]=0;
        if(arr[2][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(3);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play32(View view){
        if(arr[2][1] == 0 )     arr[2][1]=1;
        else                    arr[2][1]=0;
        if(arr[2][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(3);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play33(View view){
        if(arr[2][2] == 0 )     arr[2][2]=1;
        else                    arr[2][2]=0;
        if(arr[2][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(3);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play34(View view){
        if(arr[2][3] == 0 )     arr[2][3]=1;
        else                    arr[2][3]=0;
        if(arr[2][3] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(3);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play35(View view){
        if(arr[2][4] == 0 )     arr[2][4]=1;
        else                    arr[2][4]=0;
        if(arr[2][4] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(3);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }

    public void play41(View view){
        if(arr[3][0] == 0 )     arr[3][0]=1;
        else                    arr[3][0]=0;
        if(arr[3][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(4);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play42(View view){
        if(arr[3][1] == 0 )     arr[3][1]=1;
        else                    arr[3][1]=0;
        if(arr[3][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(4);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play43(View view){
        if(arr[3][2] == 0 )     arr[3][2]=1;
        else                    arr[3][2]=0;
        if(arr[3][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(4);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play44(View view){
        if(arr[3][3] == 0 )     arr[3][3]=1;
        else                    arr[3][3]=0;
        if(arr[3][3] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(4);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play45(View view){
        if(arr[3][4] == 0 )     arr[3][4]=1;
        else                    arr[3][4]=0;
        if(arr[3][4] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(4);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }

    public void play51(View view){
        if(arr[4][0] == 0 )     arr[4][0]=1;
        else                    arr[4][0]=0;
        if(arr[4][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(5);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play52(View view){
        if(arr[4][1] == 0 )     arr[4][1]=1;
        else                    arr[4][1]=0;
        if(arr[4][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(5);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play53(View view){
        if(arr[4][2] == 0 )     arr[4][2]=1;
        else                    arr[4][2]=0;
        if(arr[4][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(5);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play54(View view){
        if(arr[4][3] == 0 )     arr[4][3]=1;
        else                    arr[4][3]=0;
        if(arr[4][3] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(5);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }
    public void play55(View view){
        if(arr[4][4] == 0 )     arr[4][4]=1;
        else                    arr[4][4]=0;
        if(arr[4][4] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(5);
        }
        else {  view.setBackgroundResource(R.drawable.g); }

    }

    public void pia1(View view)
    {
        if(arr[5][0] == 0 )     arr[5][0]=1;
        else                    arr[5][0]=0;
        if(arr[5][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(6);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia2(View view)
    {
        if(arr[5][1] == 0 )     arr[5][1]=1;
        else                    arr[5][1]=0;
        if(arr[5][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(6);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia3(View view)
    {
        if(arr[5][2] == 0 )     arr[5][2]=1;
        else                    arr[5][2]=0;
        if(arr[5][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(6);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }

    public void pia4(View view)
    {
        if(arr[6][0] == 0 )     arr[6][0]=1;
        else                    arr[6][0]=0;
        if(arr[6][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(7);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia5(View view)
    {
        if(arr[6][1] == 0 )     arr[6][1]=1;
        else                    arr[6][1]=0;
        if(arr[6][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(7);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia6(View view)
    {
        if(arr[6][2] == 0 )     arr[6][2]=1;
        else                    arr[6][2]=0;
        if(arr[6][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(7);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }

    public void pia7(View view)
    {
        if(arr[7][0] == 0 )     arr[7][0]=1;
        else                    arr[7][0]=0;
        if(arr[7][0] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(8);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia8(View view)
    {
        if(arr[7][1] == 0 )     arr[7][1]=1;
        else                    arr[7][1]=0;
        if(arr[7][1] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(8);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }
    public void pia9(View view)
    {
        if(arr[7][2] == 0 )     arr[7][2]=1;
        else                    arr[7][2]=0;
        if(arr[7][2] == 1 ) {
            view.setBackgroundResource(R.drawable.blues);
            playBeat(8);
        }
        else {  view.setBackgroundResource(R.drawable.g); }
    }

    public void playBeat(int n){
        int i = n;
        if(i==1) {
            dummyPlayer = MediaPlayer.create(this, R.raw.clap);
        }
        if(i==2) {
            dummyPlayer = MediaPlayer.create(this, R.raw.openhat);
        }
        if(i==3){
            dummyPlayer = MediaPlayer.create(this, R.raw.kick);
        }
        if(i==4) {
            dummyPlayer = MediaPlayer.create(this, R.raw.tom);
        }
        if(i==5) {
            dummyPlayer = MediaPlayer.create(this, R.raw.snare);
        }
        if(i==6){
            dummyPlayer = MediaPlayer.create(this, R.raw.pia1);
        }
        if(i==7) {
            dummyPlayer = MediaPlayer.create(this, R.raw.d);
        }
        if(i==8) {
            dummyPlayer = MediaPlayer.create(this, R.raw.e);
        }
        dummyPlayer.start();
    }
    @Override
    public void onBackPressed() {
        if(mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        if(mediaPlayer2.isPlaying())
        {
            mediaPlayer2.stop();
            mediaPlayer2.release();
        }
        if (dummyPlayer.isPlaying())
        {
            dummyPlayer.stop();
            dummyPlayer.release();
        }
        Intent intent = new Intent(MainActivity2.this, SelectActivity.class);
        startActivity(intent);
        finish();
    }

}