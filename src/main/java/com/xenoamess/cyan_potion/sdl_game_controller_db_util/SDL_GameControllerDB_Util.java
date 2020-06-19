package com.xenoamess.cyan_potion.sdl_game_controller_db_util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;

/**
 * @author XenoAmess
 */
public class SDL_GameControllerDB_Util {
    private static String SDL_GameControllerDB_String = null;
    private static ByteBuffer SDL_GameControllerDB_ByteBuffer = null;
    public static final String SDL_GameControllerDB_FilePath = "/gamecontrollerdb.txt";

    /**
     * get gamecontrollerdb.txt's content as String
     *
     * @return gamecontrollerdb.txt's content as String
     */
    public static String getSDL_GameControllerDB_String() {
        if (SDL_GameControllerDB_String == null) {
            SDL_GameControllerDB_String = loadFile(SDL_GameControllerDB_FilePath);
        }
        return SDL_GameControllerDB_String;
    }

    /**
     * get gamecontrollerdb.txt's content as ByteBuffer
     *
     * @return gamecontrollerdb.txt's content as ByteBuffer
     */
    public static ByteBuffer getSDL_GameControllerDB_ByteBuffer() {
        if (SDL_GameControllerDB_ByteBuffer == null) {
            getSDL_GameControllerDB_String();
            SDL_GameControllerDB_ByteBuffer = createByteBuffer(SDL_GameControllerDB_String.length() + 4);
            SDL_GameControllerDB_ByteBuffer.put(SDL_GameControllerDB_String.getBytes());
            SDL_GameControllerDB_ByteBuffer.put((byte) (0));
            SDL_GameControllerDB_ByteBuffer.flip();
        }
        return SDL_GameControllerDB_ByteBuffer;
    }

    /**
     * get gamecontrollerdb.txt's content and generate a temp file with it.
     * notice that once you after you used it you'd better delete it.
     *
     * @return gamecontrollerdb.txt's content and generate a temp file with it.
     */
    public static File getSDL_GameControllerDB_TempFile() {
        File res = null;
        try {
            res = Files.createTempFile("SDL_GameControllerDB_Util_gamecontrollerdb", null).toAbsolutePath().toFile();
            try (FileWriter fileWriter = new FileWriter(res)) {
                fileWriter.write(getSDL_GameControllerDB_String());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * Adds the specified SDL_GameControllerDB gamepad mappings.
     *
     * <p>This function parses the specified ASCII encoded string and updates the internal list with latest version
     * of
     * <a target="_blank" href="https://github.com/gabomdq/SDL_GameControllerDB/blob/master/gamecontrollerdb.txt">gamecontrollerdb</a></p>
     *
     * <p>See <a target="_blank" href="http://www.glfw.org/docs/latest/input.html#gamepad_mapping">gamepad_mapping</a>
     * for a description of the format.</p>
     *
     * <p>If there is already a gamepad mapping for a given GUID in the internal list, it will be replaced by the one
     * passed to this function. If the library is
     * terminated and re-initialized the internal list will revert to the built-in default.</p>
     *
     * <p>This function must only be called from the main thread.</p>
     *
     * <p>This function will not use internet, so don't be afraid.</p>
     *
     * @return {@code true}, or {@code false} if an error occurred
     *
     * @since version 3.3
     */
    public static boolean glfwUpdateGamepadMappings() {
        return org.lwjgl.glfw.GLFW.glfwUpdateGamepadMappings(getSDL_GameControllerDB_ByteBuffer());
    }

    private static URL getURL(String resourceFilePath) {
        return SDL_GameControllerDB_Util.class.getResource(resourceFilePath);
    }

    private static String loadFile(String resourceFilePath) {
        String res = "";
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(getURL(resourceFilePath).openStream()))
        ) {
            final StringBuilder sb = new StringBuilder();
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

    /**
     * Special Notice: this function is copied from LWJGL.
     * Allocates a direct native-ordered bytebuffer with the specified capacity.
     *
     * @param capacity The capacity, in bytes
     * @return a ByteBuffer
     */
    private static ByteBuffer createByteBuffer(int capacity) {
        return ByteBuffer.allocateDirect(capacity).order(ByteOrder.nativeOrder());
    }
}