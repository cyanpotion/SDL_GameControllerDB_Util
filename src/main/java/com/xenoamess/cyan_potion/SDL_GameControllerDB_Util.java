package com.xenoamess.cyan_potion;

import java.io.File;
import java.nio.ByteBuffer;

/**
 * @deprecated use {@link com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util} instead.
 * @author XenoAmess
 */
@Deprecated
public class SDL_GameControllerDB_Util {

    /**
     * get gamecontrollerdb.txt's content as String
     *
     * @deprecated use {@link com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util#getSDL_GameControllerDB_String()} instead
     * @return gamecontrollerdb.txt's content as String
     */
    @Deprecated
    public static String getSDL_GameControllerDB_String() {
        return com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util.getSDL_GameControllerDB_String();
    }

    /**
     * get gamecontrollerdb.txt's content as ByteBuffer
     *
     * @deprecated use {@link com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util#getSDL_GameControllerDB_ByteBuffer()} instead
     * @return gamecontrollerdb.txt's content as ByteBuffer
     */
    @Deprecated
    public static ByteBuffer getSDL_GameControllerDB_ByteBuffer() {
        return com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util.getSDL_GameControllerDB_ByteBuffer();
    }

    /**
     * get gamecontrollerdb.txt's content and generate a temp file with it.
     * notice that once you after you used it you'd better delete it.
     *
     * @deprecated use {@link com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util#getSDL_GameControllerDB_TempFile()} instead
     * @return gamecontrollerdb.txt's content and generate a temp file with it.
     */
    @Deprecated
    public static File getSDL_GameControllerDB_TempFile() {
        return com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util.getSDL_GameControllerDB_TempFile();
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
     * @deprecated use {@link com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util#glfwUpdateGamepadMappings()} instead
     * @return {@code true}, or {@code false} if an error occurred
     */
    @Deprecated
    public static boolean glfwUpdateGamepadMappings() {
        return com.xenoamess.cyan_potion.sdl_game_controller_db_util.SDL_GameControllerDB_Util.glfwUpdateGamepadMappings();
    }
}
