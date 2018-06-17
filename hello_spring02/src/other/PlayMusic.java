package other;

public class PlayMusic {
    //单例模式
    //step1 : 构造方法私有化

    private PlayMusic (){}

    private static PlayMusic pm;

    //得到改类的实例


    public static PlayMusic getInstance() {
        if (pm == null){
            pm =  new PlayMusic();
        }
        return pm;
    }

    public void playMusic(String music){
        System.out.println("正在播放" + music + "...");
    }


}
