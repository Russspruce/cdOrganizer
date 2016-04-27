import org.junit.*;
import static org.junit.Assert.*;

public class CompactDiskTest{

 @Test
 public void CompactDisk_intantiatesCorrectly_true() {
   CompactDisk myCompactDisk = new CompactDisk("Generic title");
   assertEquals(true, myCompactDisk instanceof CompactDisk);
 }

}
