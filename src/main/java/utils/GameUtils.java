package utils;

public class GameUtils {

    public static void pauseForEffect(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        }
        catch (Exception e){
            System.out.println("Exception " + e);
        }
    }
}
