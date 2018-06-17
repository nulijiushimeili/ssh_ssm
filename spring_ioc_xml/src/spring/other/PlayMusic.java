package spring.other;

public class PlayMusic {

    private PlayMusic(){}

    private static PlayMusic playMusic;

    //得到PlayMusic的实例
    public static PlayMusic getInstance(){
        if(playMusic == null){
            playMusic = new PlayMusic();
        }
        return playMusic;
    }

    public void play(String music){
        System.out.println("正在播放" + music );
    }
}
