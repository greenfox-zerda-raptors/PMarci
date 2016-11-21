/**
 * Created by posam on 2016-11-21.
 * WHAAAAAAAAAAAAAAAASSSSSUUUUUP
 */
public class App {
    public static void main(String[] args) {
        WordToolbox wSource = new WordToolbox("Tarzan's toenails");
        System.out.printf ("countHowMany(\"a\")=%d\n", wSource.countHowMany('a')); // countHowMany("a")=3
        System.out.printf ("countHowMany(\"T\")=%d\n", wSource.countHowMany('T')); // countHowMany("T")=2
        System.out.printf ("countHowMany(\"t\")=%d\n", wSource.countHowMany('t')); // countHowMany("t")=2
        System.out.printf ("countHowMany(\"x\")=%d\n", wSource.countHowMany('x')); // countHowMany("x")=0
        System.out.printf ("countHowMany(\"\")=%d\n", wSource.countHowMany('0')); // countHowMany("")=0
        System.out.printf ("countHowMany(\" \")=%d\n", wSource.countHowMany(' ')); // countHowMany(" ")=1
//
//        WordToolbox w = new WordToolbox ("folate");
//        w.setS("folate");
//        String [] alternatives = {"falsetto", "latest", "foetal","aloft","float","flota"};
//        for (String s : alternatives) {
//            System.out.printf("is %s an anagram of %s = %s\n", s, w.getS(), w.isAnAnagram(s));
//        }
//        System.out.println("\nNew test");
//        w.setS("aloft");
//        for (String s : alternatives) {
//            System.out.printf("is %s an anagram of %s = %s\n", s, w.getS(), w.isAnAnagram(s));
//        }
    }
}
