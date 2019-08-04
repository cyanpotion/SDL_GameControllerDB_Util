# SDL_GameControllerDB_Util

A maven wrapper of SDL_GameControllerDB.

usage:


when build (maven):
```
<dependency>
    <groupId>com.xenoamess.cyan_potion</groupId>
    <artifactId>SDL_GameControllerDB_Util</artifactId>
    <version>${SDL_GameControllerDB_Util.version}</version>
</dependency>
```
get gamecontrollerdb.txt's content as a String:
```
SDL_GameControllerDB_Util.getSDL_GameControllerDB_String()
```
get gamecontrollerdb.txt's content as a ByteBuffer:
```
SDL_GameControllerDB_Util.getSDL_GameControllerDB_ByteBuffer()
```

notice that due to some reason, if you want to build this by yourself(but not getting it from center), you must mvn clean every time before you build.