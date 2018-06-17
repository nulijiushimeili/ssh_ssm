package other;

import org.junit.Test;

public class PlayMusicTest {

    @Test
    public void testPlay(){
        PlayMusic pm1 = PlayMusic.getInstance();
        pm1.playMusic("不讲究 李荣浩");
        PlayMusic pm2 = PlayMusic.getInstance();
        System.out.println(pm1 == pm2);
    }


}
