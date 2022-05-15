package main;




/* Although code can be run in Main.java I recomend that you run in 
** MyMethods.java like Project STEM formats their activity
**
** This program was used to test the conversion from string to .wav file using the Sound.java methods
**
*/



class Main{


    public static void main(String[] args) {
        
        GamePanel gp = new GamePanel();
       
        for (int i=0; i<23; i++){ //chromatic ascending scale
            
            gp.playNote(i);

            try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    
        }
        
    }
    
