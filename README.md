# SDL_GameControllerDB_Util

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.xenoamess.cyan_potion/SDL_GameControllerDB_Util/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.xenoamess.cyan_potion/SDL_GameControllerDB_Util)

A maven wrapper of SDL_GameControllerDB.

I will build and deploy it at least every month to catch up SDL_GameControllerDB updates, so if you use this you do not have to renew your gamecontrollerdb.txt everytime.

You can just get the latest version of this library.

That makes things far easier for java users.

##gabomdq/SDL_GameControllerDB or p-groarke/SDL_GameControllerDB2?
I will stay on gabomdq/SDL_GameControllerDB for a while.

If there be soem strong reasons for moving to p-groarke/SDL_GameControllerDB2 then I will do.

Otherwise let me just stay for a while.

Right now I will just raise a medium version(1.1.\* to 1.2.\*) to memorise the interesting fight happened(happening) and do nothing else.

#usage:

##when adding to maven:
```
<dependency>
    <groupId>com.xenoamess.cyan_potion</groupId>
    <artifactId>SDL_GameControllerDB_Util</artifactId>
    <version>[1.1.0,)</version>
</dependency>
```
Or if you are using maven 2 you can just use RELEASE.

##when coding:

get gamecontrollerdb.txt's content as a String:
```
SDL_GameControllerDB_Util.getSDL_GameControllerDB_String()
```
get gamecontrollerdb.txt's content as a ByteBuffer:
```
SDL_GameControllerDB_Util.getSDL_GameControllerDB_ByteBuffer()
```

get gamecontrollerdb.txt's content and put it to a generated temp file:
```
SDL_GameControllerDB_Util.getSDL_GameControllerDB_TempFile()
```
* notice that this file will not be deleted automatically.
you shall delete it after used.

##when building it yourself (not recommended)
notice that due to some reason, if you want to build this by yourself(but not getting it from center), you must \[mvn clean\] every time before you \[mvn build\].

#meanings of version num of this library:

We will choose 1.1.20190809 as an example.

If anything of the codes itself doesn't change, but at 2019/10/01 the gamecontrollerdb.txt updates, then that version will be 1.1.20191001.

If some small codes fragments change / doc fix happened at 2019/10/01, then it will still be 1.1.20191001.

If there be some function adding / bugfix or other critical things happened at 2019/10/01, but the codes who worked well in 1.1.20190809 still work well(or even works better), then the next version will be 1.2.20191001

If there be some critical change happened at 2019/10/01, so critical that some of your codes dealing with version 1.1.20190809 might fail, then the next version will be 2.0.20191001
