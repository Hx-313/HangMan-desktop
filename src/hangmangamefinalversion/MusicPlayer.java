package hangmangamefinalversion;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MusicPlayer implements Runnable {
    private static Clip clip;
    private static Thread musicThread;
    private String musicFilePath;

    public MusicPlayer(String musicFilePath) {
        this.musicFilePath = musicFilePath;
    }

    @Override
    public void run() {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(musicFilePath));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(MusicPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static synchronized void startMusic(String musicFilePath) {
        if (clip == null) {
            try {
                clip = AudioSystem.getClip();
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(musicFilePath));
                clip.open(audioIn);
                musicThread = new Thread(new MusicPlayer(musicFilePath));
                musicThread.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void stopMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
            musicThread = null;
        }
    }

    public static void main(String[] args) {
        MusicPlayer.startMusic("C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\hangmangamefinalversion\\1.wav");
    }
}
