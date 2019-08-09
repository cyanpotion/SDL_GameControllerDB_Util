import com.xenoamess.cyan_potion.SDL_GameControllerDB_Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        System.out.println(SDL_GameControllerDB_Util.getSDL_GameControllerDB_String());
        System.out.println(SDL_GameControllerDB_Util.getSDL_GameControllerDB_ByteBuffer());
        File tmpFile = SDL_GameControllerDB_Util.getSDL_GameControllerDB_TempFile();
        System.out.println(loadFile(tmpFile));
        tmpFile.delete();
    }

    private static String loadFile(File file) {
        String res = "";
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(file.toURL().openStream()))
        ) {
            final StringBuffer sb = new StringBuffer();
            String tmp;
            while (true) {
                tmp = bufferedReader.readLine();
                if (tmp == null) {
                    break;
                }
                sb.append(tmp);
                sb.append("\n");
            }
            res = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}