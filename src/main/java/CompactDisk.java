import java.util.ArrayList;

public class CompactDisk{
  private String mTitle;
  private static ArrayList<CompactDisk> instances = new ArrayList<CompactDisk>();

  public CompactDisk(String title) {
    mTitle = title;
    instances.add(this);
  }

  public String getTitle(){
    return mTitle;
   }

  public static ArrayList<CompactDisk> all() {
    return instances;
  }

}
