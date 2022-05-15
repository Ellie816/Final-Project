package main;

public class GamePanel{

    public GamePanel(){
        
    }


    

    public void playC(){
        playMusic(0);
    }

    public void playCSharp(){
        playMusic(1);
    }

    public void playD(){
        playMusic(2);
    }

    public void playDSharp(){
        playMusic(3);
    }

    public void playE(){
        playMusic(4);
    }

    public void playF(){
        playMusic(5);
    }

    public void playFSharp(){
        playMusic(6);
    }
    
    public void playG(){
        playMusic(7);
    }

    public void playGSharp(){
        playMusic(8);
    }

    public void playA(){
        playMusic(9);
    }

    public void playASharp(){
        playMusic(10);
    }

    public void playB(){
        playMusic(11);
    }






    
    public void playC1(){
        playMusic(12);
    }

    public void playCSharp1(){
        playMusic(13);
    }

    public void playD1(){
        playMusic(14);
    }

    public void playDSharp1(){
        playMusic(15);
    }

    public void playE1(){
        playMusic(16);
    }

    public void playF1(){
        playMusic(17);
    }

    public void playFSharp1(){
        playMusic(18);
    }
    
    public void playG1(){
        playMusic(19);
    }

    public void playGSharp1(){
        playMusic(20);
    }
    public void playA1(){
        playMusic(21);
    }

    public void playASharp1(){
        playMusic(22);
    }

    public void playB1(){
        playMusic(23);
    }






    public void playNote(int x){
        playMusic(x);
    }

  

    Sound sound = new Sound();



    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

}
