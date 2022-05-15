package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.net.URL;
import javax.sound.sampled.Clip;
import javax.sound.sampled.*;

public class Sound {

    Clip clip;
    URL soundURL[] = new URL[30];

    public Sound() {

        //These values give each note an id so they can be played
        soundURL[0] = getClass().getResource("sound/C4.wav");
        soundURL[1] = getClass().getResource("sound/c.wav");
        soundURL[2] = getClass().getResource("sound/D4.wav");
        soundURL[3] = getClass().getResource("sound/d.wav");
        soundURL[4] = getClass().getResource("sound/E4.wav");
        soundURL[5] = getClass().getResource("sound/F4.wav");
        soundURL[6] = getClass().getResource("sound/f.wav");
        soundURL[7] = getClass().getResource("sound/G4.wav");
        soundURL[8] = getClass().getResource("sound/g.wav");
        soundURL[9] = getClass().getResource("sound/A4.wav");
        soundURL[10] = getClass().getResource("sound/a.wav");
        soundURL[11] = getClass().getResource("sound/B.wav");

        soundURL[12] = getClass().getResource("sound/Octave2/C5.wav");
        soundURL[13] = getClass().getResource("sound/Octave2/C#5.wav");
        soundURL[14] = getClass().getResource("sound/Octave2/D5.wav");
        soundURL[15] = getClass().getResource("sound/Octave2/D#5.wav");
        soundURL[16] = getClass().getResource("sound/Octave2/E5.wav");
        soundURL[17] = getClass().getResource("sound/Octave2/F5.wav");
        soundURL[18] = getClass().getResource("sound/Octave2/F#5.wav");
        soundURL[19] = getClass().getResource("sound/Octave2/G5.wav");
        soundURL[20] = getClass().getResource("sound/Octave2/G#5.wav");
        soundURL[21] = getClass().getResource("sound/Octave2/A5.wav");
        soundURL[22] = getClass().getResource("sound/Octave2/A#5.wav");
        soundURL[23] = getClass().getResource("sound/Octave2/B5.wav");





        soundURL[24] = getClass().getResource("sound/BlueBoyAdventure.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-30.0f); // Reduce volume by 20
        

        }catch(Exception e) {
        }

    }

    public void play() {
        clip.start();

    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop() {
        clip.stop();

    }


}