package uet.oop.bomberman.Sound;

//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//import javazoom.jl.player.*;
import java.io.InputStream;

public class SoundEffect {
    private Clip game_over;
    private Clip bomb_explode;
    private Clip item_get;
    private Clip die;
    private Clip pause;
    private Clip theme;

    private AudioInputStream game_overStream;
    private AudioInputStream item_getStream;
    private AudioInputStream dieStream;
    private AudioInputStream pauseStream;
    private AudioInputStream bombStream;
    private AudioInputStream themeStream;


    public SoundEffect(){
    }


    public void playBombExplode(){
        try {
            InputStream inputStream4 = this.getClass().getResourceAsStream("/sound/BOM_11_S.wav");
            bombStream = AudioSystem.getAudioInputStream(inputStream4);

            bomb_explode = AudioSystem.getClip();
            bomb_explode.open(bombStream);
            bomb_explode.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void playItemGet(){
        try {
            InputStream inputStream1 = this.getClass().getResourceAsStream("/sound/ITEM_GET.wav");
            item_getStream = AudioSystem.getAudioInputStream(inputStream1);

            item_get = AudioSystem.getClip();
            item_get.open(item_getStream);
            item_get.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void playDieSound(){
        try {
            InputStream inputStream4 = this.getClass().getResourceAsStream("/sound/NO.wav");
            dieStream = AudioSystem.getAudioInputStream(inputStream4);

            die = AudioSystem.getClip();
            die.open(dieStream);
            die.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void playGameOver(){
        try{
            InputStream inputStream = this.getClass().getResourceAsStream("/sound/GAME_OVER.wav");
            game_overStream = AudioSystem.getAudioInputStream(inputStream);

            game_over = AudioSystem.getClip();
            game_over.open(game_overStream);
            game_over.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void playPause(){
        try{
            InputStream inputStream3 = this.getClass().getResourceAsStream("/sound/PAUSE.wav");
            pauseStream = AudioSystem.getAudioInputStream(inputStream3);

            pause = AudioSystem.getClip();
            pause.open(pauseStream);
            pause.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void playTheme(){
//        try{
//            AudioPlayer player = AudioPlayer.player;
//            AudioData data = null;
//            ContinuousAudioDataStream loop;
//            InputStream is = this.getClass().getResourceAsStream("/sound/THEME.wav");
//            AudioStream auStream = new AudioStream(is);
//            data = auStream.getData();
//            loop = new ContinuousAudioDataStream(data);
//            player.start(loop);

//        }catch(Exception e){
//            e.printStackTrace();
//        }
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/sound/MAINS.wav");
            themeStream = AudioSystem.getAudioInputStream(inputStream);
            theme = AudioSystem.getClip();
            theme.open(themeStream);
            theme.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
