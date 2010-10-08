package uk.co.caprica.vlcj.test.list;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.list.MediaList;
import uk.co.caprica.vlcj.player.list.MediaListPlayer;
import uk.co.caprica.vlcj.player.list.MediaListPlayerEventListener;

public class TestMediaListPlayer {

  public static void main(String[] args) throws Exception {
    String[] vlcArgs = {};
    
    MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(vlcArgs);
    
    MediaListPlayer mediaListPlayer = mediaPlayerFactory.newMediaListPlayer();
    
    mediaListPlayer.addMediaListPlayerEventListener(new MediaListPlayerEventListener() {});
    
    MediaList mediaList = mediaPlayerFactory.newMediaList();
    mediaList.addMedia("/big/PearlAndDeanIntro-16x9.avi");
    mediaList.addMedia("/home/mark/Desktop/nfs.mp4");
    
    mediaListPlayer.setMediaList(mediaList);

    mediaListPlayer.play();
    
//    Thread.sleep(5000);
    Thread.currentThread().join();
    
    mediaList.release();
    
    mediaListPlayer.release();
    
    mediaPlayerFactory.release();
  }
  
}