import org.junit.*;
import static org.junit.Assert.*;

public class CompactDiskTest{

 @Test
 public void CompactDisk_intantiatesCorrectly_true() {
   CompactDisk testCompactDisk = new CompactDisk("Generic title", "Generic artist");
   assertEquals(true, testCompactDisk instanceof CompactDisk);
 }

 @Test
 public void CompactDisk_intantiatesCorrectly_String() {
   CompactDisk testCompactDisk = new CompactDisk("Generic title", "Generic artist");
   assertEquals("Generic title", testCompactDisk.getTitle());
 }

@Test
public void all_returnsAllInstancesOfCompactDisk_true() {
  CompactDisk firstCompactDisk = new CompactDisk("Generic title", "Generic artist");
  CompactDisk secondCompactDisk = new CompactDisk("Summer rose", "Ruby Rose");
  assertTrue(CompactDisk.all().contains(firstCompactDisk));
  assertTrue(CompactDisk.all().contains(secondCompactDisk));
}

@Test
public void getArtist_instatiatesCorretly_GenericArtist() {
  CompactDisk testCompactDisk = new CompactDisk("Generic title", "Generic artist");
  assertEquals("Generic artist", testCompactDisk.getArtist());
}

@Test
public void clear_emptiesAllTasksFromArrayList_0() {
  CompactDisk myCompactDisk = new CompactDisk("Generic title", "Generic artist");
  CompactDisk.clear();
  assertEquals(CompactDisk.all().size(), 0);
}

@Test
public void getId_compactDisksInstatiateWithAnID_1() {
  CompactDisk.clear();
  CompactDisk myCompactDisk = new CompactDisk("Generic title", "Generic artist");
  assertEquals(1, myCompactDisk.getId());
}

}
