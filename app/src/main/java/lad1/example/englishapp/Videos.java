package lad1.example.englishapp;

import java.util.Comparator;

public class Videos {
    String TenVideo;
    String Thumbnail;
    String IdVideo;

    public Videos(String tenVideo, String thumbnail, String idVideo) {
        TenVideo = tenVideo;
        Thumbnail = thumbnail;
        IdVideo = idVideo;
    }

    public static Comparator<Videos> VideosNameAZComparator = new Comparator<Videos>() {
        @Override
        public int compare(Videos o1, Videos o2) {
            return o1.getTenVideo().compareTo(o2.getTenVideo() );
        }
    };
    public static Comparator<Videos> VideosNameZAComparator = new Comparator<Videos>() {
        @Override
        public int compare(Videos o1, Videos o2) {
            return o2.getTenVideo().compareTo(o1.getTenVideo() );
        }
    };

    public String getTenVideo() {
        return TenVideo;
    }

    public void setTenVideo(String tenVideo) {
        TenVideo = tenVideo;
    }

    public String getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        Thumbnail = thumbnail;
    }

    public String getIdVideo() {
        return IdVideo;
    }

    public void setIdVideo(String idVideo) {
        IdVideo = idVideo;
    }
}
