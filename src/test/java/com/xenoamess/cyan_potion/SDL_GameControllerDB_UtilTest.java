package com.xenoamess.cyan_potion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

import static com.xenoamess.cyan_potion.SDL_GameControllerDB_Util.getSDL_GameControllerDB_String;
import static com.xenoamess.cyan_potion.SDL_GameControllerDB_Util.glfwUpdateGamepadMappings;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwUpdateGamepadMappings;

/**
 * @author XenoAmess
 */
public class SDL_GameControllerDB_UtilTest {

    @Test
    public void getSDL_GameControllerDB_StringTest() {
        String db = getSDL_GameControllerDB_String();
        System.out.println(db);
        Assertions.assertNotNull(db);
        Assertions.assertNotEquals(0, db.length());
    }

    @Test
    public void getSDL_GameControllerDB_ByteBufferTest() {
        ByteBuffer db = SDL_GameControllerDB_Util.getSDL_GameControllerDB_ByteBuffer();
        Assertions.assertNotNull(db);
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        assertTrue(glfwUpdateGamepadMappings(db));
    }

    @Test
    public void getSDL_GameControllerDB_ByteBufferTest2() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwUpdateGamepadMappings();
    }

    @Test
    public void getSDL_GameControllerDB_TempFileTest() {
        File tmpFile = SDL_GameControllerDB_Util.getSDL_GameControllerDB_TempFile();
        try (FileInputStream fileInputStream = new FileInputStream(tmpFile);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
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
            System.out.println(sb.toString());
            assertNotEquals("", sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!tmpFile.delete()) {
            tmpFile.deleteOnExit();
        }
    }
}