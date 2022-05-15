package main;
import java.awt.Color;
import java.util.ArrayList;

import main.projectStem.Picture;



public class MyMethods {
    public static ArrayList<Integer> encodeString(String s)
     {
         //Upper case letter represent major keys and lower case letter represent minor keys
         String notes = "AaBCcDdEFfGg0123456789xy";

         ArrayList<Integer> result = new ArrayList<Integer>();
         for (int i = 0; i < s.length(); i++)
         {
             if (s.substring(i,i+1).equals(" "))
             {
                 result.add(60);
             }
             else
             {
                 result.add(notes.indexOf(s.substring(i,i+1))+1);
             }
         }
         result.add(0);
         return result;
     }

     /**
       * Returns the string represented by the codes arraylist.
       * 1-13 = notes, 14 = rest
       * @param codes encoded string
       * @return decoded string
       */
     public static String decodeString(ArrayList<Integer> codes){
          String result="";
          String notes = "AaBCcDdEFfGg0123456789xy";
          for (int i=0; i < codes.size(); i++)
          {
              if (codes.get(i) == 60)
              {
                  result = result + " ";
              }
              else
              {
                  result = result +
                    notes.substring(codes.get(i)-1,codes.get(i));
              }
          }
          return result;
     }

     /**
       * Given a number from 0 to 63, creates and returns a 3-element
       * int array consisting of the integers representing the
       * pairs of bits in the number from right to left.
       * @param num number to be broken up
       * @return bit pairs in number
       */
     private static int[] getBitPairs(int num)
     {
         int[] bits=new int[3];
         int code = num;
         for (int i=0; i < 3; i++)
         {
             bits[i] = code % 4;
             code = code / 4;
         }
         return bits;
     }

    /**
     * Hide a string (characters must be contained in the notes string) in a
     * picture.
     * The string always starts in the upper left corner.
     * @param source picture to hide string in
     * @param s string to hide
     * @return pic with hidden string
     */
    public static main.projectStem.Picture hideText(main.projectStem.Picture source, String s){
        main.projectStem.Pixel leftPixel = null;
        main.projectStem.Picture newPic = new main.projectStem.Picture(source);
        main.projectStem.Pixel[][] pixels = newPic.getPixels2D();
        Color leftColor = null;
        // create the list of integers representing encoded message
        ArrayList<Integer> eCode = encodeString(s);
        int currentCharNum = 0;
        for (int row = 0;
            row < pixels.length && currentCharNum < eCode.size(); row++)
        {
            for (int col = 0; col < pixels[0].length &&
                currentCharNum < eCode.size(); col++)
            {
                leftPixel = pixels[row][col];
                main.projectStem.Steganography.clearLow(leftPixel);
                leftColor = leftPixel.getColor();
                int [] bits = getBitPairs(eCode.get(currentCharNum));
                leftPixel.setColor(new Color(leftColor.getRed()+bits[0],
                    leftColor.getGreen()+bits[1],
                    leftColor.getBlue()+bits[2]));
                currentCharNum++;
            }
        }
        return newPic;
    }

    /**
      * Returns a string hidden in the picture
      * @param source picture with hidden string
      * @return revealed string
      */
     public static String revealText(main.projectStem.Picture source){
         main.projectStem.Pixel leftPixel = null;
         main.projectStem.Pixel[][] pixels = source.getPixels2D();
         Color leftColor = null;
         String result = "";
         ArrayList<Integer> codes = new ArrayList<Integer>();
         boolean finished = false;
         for (int row = 0; row < pixels.length && !finished; row++)
         {
             for (int col = 0; col < pixels[0].length && !finished;
                col++)
             {
                 leftPixel = pixels[row][col];
                 leftColor = leftPixel.getColor();
                 int code = leftColor.getRed() % 4 +
                   (leftColor.getGreen()% 4) * 4 +
                   (leftColor.getBlue() % 4) * 16;
                 if (code == 0)
                 {
                     finished = true;
                 }
                 else
                 {
                     codes.add(code);
                 }
             }
         }
         return decodeString(codes);
    }

    public static void revealMusic(main.projectStem.Picture source){
        Picture sourcePicture = source;
        String music = revealText(sourcePicture);

        for (int j = 0; j<music.length()-1; j+=2){
            
            playNote(j+1, music);
            playNote(j, music);
  
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       
    }

    public static void playNote(int index, String music1){
        
            GamePanel gp = new GamePanel();
            int i = index;
            String music = music1;
                
            if (music.substring(i,i+1).equals("A")){
                gp.playA();
                //System.out.print("𝅘𝅥𝅮");
            }
            if (music.substring(i,i+1).equals("a")){
                gp.playASharp();
                //System.out.print("𝅘𝅥𝅮");
            }
            if (music.substring(i,i+1).equals("B")){
                gp.playB();
                //System.out.print("𝅘𝅥𝅮");
            }
            if (music.substring(i,i+1).equals("C")){
                gp.playC();
            }
            if (music.substring(i,i+1).equals("c")){
                gp.playCSharp();
            }
            if (music.substring(i,i+1).equals("D")){
                gp.playD();
            }
            if (music.substring(i,i+1).equals("d")){
                gp.playDSharp();
            }
            if (music.substring(i,i+1).equals("E")){
                gp.playE();
            }
            if (music.substring(i,i+1).equals("F")){
                gp.playF();
            }
            if (music.substring(i,i+1).equals("f")){
                gp.playFSharp();
            }
            if (music.substring(i,i+1).equals("G")){
                gp.playG();
            }
            if (music.substring(i,i+1).equals("g")){
                gp.playGSharp();
            }
            
            if (music.substring(i,i+1).equals("0")){
                gp.playC1();
            }
            if (music.substring(i,i+1).equals("1")){
                gp.playCSharp1();
            }
            if (music.substring(i,i+1).equals("2")){
                gp.playD1();
            }
            if (music.substring(i,i+1).equals("3")){
                gp.playDSharp1();
            }
            if (music.substring(i,i+1).equals("4")){
                gp.playE1();
            }
            if (music.substring(i,i+1).equals("5")){
                gp.playF1();
            }
            if (music.substring(i,i+1).equals("6")){
                gp.playFSharp1();
            }
            if (music.substring(i,i+1).equals("7")){
                gp.playG1();
            }
            if (music.substring(i,i+1).equals("8")){
                gp.playGSharp1();
            }
            if (music.substring(i,i+1).equals("9")){
                gp.playA1();
                //System.out.print("𝅘𝅥𝅮");
            }
            if (music.substring(i,i+1).equals("x")){
                gp.playASharp1();
                //System.out.print("𝅘𝅥𝅮");
            }
            if (music.substring(i,i+1).equals("y")){
                gp.playB1();
                //System.out.print("𝅘𝅥𝅮");
            }
            

            
            


            if (music.substring(i,i+1).equals(" ")){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        
    






    public static void main(String[] args){


        main.projectStem.Picture swan = new main.projectStem.Picture("main/images/swan.jpg"); //Creates a new Image object using the swan picture
        main.projectStem.Picture swan1 = hideText(swan, "EG  Ga  a2  24  47  7x    9 2 a G 7 2 a G 6 2 a G 7 2 a G 7 0 A F 5 0 A F 4 0 A F 5 a G E 4 a G E 3 a G E 4 a G E 4 A F D 2 A F D 1 A F D 2 A F D   92a G a 2 72a G a 2 62a G a 2 72a G a 2x3 0 f 0 393 0 f 0 383 0 f 0 3y2 a G a 2x2 a G a 292 a G a 2x2 a G a 292 a E a 272 a E 5 2 a E 4 3 a E  9 2 a G 7 2 a G 6 2 a G 7 2 a G 7 0 A F 5 0 A F 4 0 A F 5 a G E 4 a G E 3 a G E 4 a G E 4 A F D 2 A F D 1 A F D 2 A F D"); 
        
        
        swan1.explore(); //The picture with the secret music
        swan.explore(); //The original picture


        revealMusic(swan1); //Plays the music hidden in swan1


        /* Uncomment to play the song
        main.projectStem.Picture swan2 = hideText(swan, "C C G G A A G    F F E E D D C "); //hides the notes to Twinkle Twinkle Little Star in the image
        revealMusic(swan2); //Uncomment swan1 and swan3 to listen to the music.
        */
        

        /* Uncomment to play the song
        main.projectStem.Picture swan3 = hideText(swan, "D d E   D D   d E     0 2   0 2   0 a  A   G F  C D d E D D E F   0 5 2 0 a A G F5  F5  A F     "); 
        revealMusic(swan3);
        */
        
    }

}
