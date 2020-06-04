package com.xenoamess.cyan_potion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

import static com.xenoamess.cyan_potion.SDL_GameControllerDB_Util.getSDL_GameControllerDB_String;
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
        glfwUpdateGamepadMappings(db);
    }
}