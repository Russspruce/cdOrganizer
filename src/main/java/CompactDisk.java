import java.util.ArrayList;

public class CompactDisk{
  private String mTitle;
  private static ArrayList<CompactDisk> instances = new ArrayList<CompactDisk>();
  private String mArtist;
  private int mId;

  public CompactDisk(String title, String artist) {
    mTitle = title;
    mArtist = artist;
    instances.add(this);
    mId = instances.size();
  }

  public String getTitle(){
    return mTitle;
   }

  public static ArrayList<CompactDisk> all() {
    return instances;
  }

  public String getArtist(){
    return mArtist;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

}
