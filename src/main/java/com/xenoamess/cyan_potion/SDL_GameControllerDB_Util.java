package com.xenoamess.cyan_potion;

import org.lwjgl.BufferUtils;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author XenoAmess
 */
public class SDL_GameControllerDB_Util {
    private static String SDL_GameControllerDB_String = null;
    private static ByteBuffer SDL_GameControllerDB_ByteBuffer = null;
    public static final String SDL_GameControllerDB_FilePath = "/gamecontrollerdb.txt";

    public static String getSDL_GameControllerDB_String() {
        if (SDL_GameControllerDB_String == null) {
            SDL_GameControllerDB_String = loadFile(SDL_GameControllerDB_FilePath);
        }
        return SDL_GameControllerDB_String;
    }

    public static ByteBuffer getSDL_GameControllerDB_ByteBuffer() {
        if (SDL_GameControllerDB_ByteBuffer == null) {
            getSDL_GameControllerDB_String();
            SDL_GameControllerDB_ByteBuffer = BufferUtils.createByteBuffer(SDL_GameControllerDB_String.length() + 4);
            SDL_GameControllerDB_ByteBuffer.put(SDL_GameControllerDB_String.getBytes());
            SDL_GameControllerDB_ByteBuffer.put((byte) (0));
            SDL_GameControllerDB_ByteBuffer.flip();
        }
        return SDL_GameControllerDB_ByteBuffer;
    }

    private static URL getURL(String resourceFilePath) {
        final URL res = SDL_GameControllerDB_Util.class.getResource(resourceFilePath);
        return res;
    }

    private static File getFile(String resourceFilePath) {
        final URL resUrl = getURL(resourceFilePath);
        return new File(resUrl.getFile().replaceAll("%20", " "));
    }


    private static String loadFile(String resourceFilePath) {
        String res = "";
        try (
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(getURL(resourceFilePath).openStream()));
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

    /**
     * Reads the specified resource and returns the raw data as a ByteBuffer.
     *
     * @param resourceFile the resource file to read
     * @return the resource data
     */
    public static ByteBuffer loadFileBuffer(File resourceFile) {
        boolean success;

        ByteBuffer buffer = null;
        final String absolutePath = resourceFile.getAbsolutePath();
        Path path = Paths.get(absolutePath);
        if (Files.isReadable(path)) {
            try (SeekableByteChannel fc = Files.newByteChannel(path)) {
                buffer = BufferUtils.createByteBuffer((int) fc.size() + 1);
                while (fc.read(buffer) != -1) {
                    ;
                }
                success = true;
            } catch (IOException e) {
                e.printStackTrace();
                if (buffer != null) {
                    buffer.clear();
                }
                success = false;
            }
            if (success) {
                buffer.flip();
                return buffer.slice();
            }
        }


        try (
                InputStream source = new FileInputStream(resourceFile);
                ReadableByteChannel rbc = Channels.newChannel(source)
        ) {
            buffer = BufferUtils.createByteBuffer((int) resourceFile.length() + 1);

            while (true) {
                int bytes = rbc.read(buffer);
                if (bytes == -1) {
                    break;
                }
                //                //                    if (buffer.remaining() == 0) {
                //                //                        buffer = resizeBuffer(buffer, buffer.capacity() * 3 / 2);
                // 50%
                //                //                    }
            }
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
            success = false;
        }
        assert (success);
        buffer.flip();
        return buffer.slice();
    }

}