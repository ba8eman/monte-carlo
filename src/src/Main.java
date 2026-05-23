import java.util.*;

public class Main {
    public static void main(String[] args) {
        simulate();
    }

    static void simulate(){
        float average=0;
        int runCount=1;
        int loops=0;

        while(runCount<=1000000){
            loops += doRun();
            average = (float)loops/runCount;
            runCount++;
        }
        System.out.println("The average after simulation is "+average);
    }

    static int doRun(){
        // Randomly allocate 100 from 0 to 99 to different ends of 50 strings
        HashMap<Integer,Integer>ends=new HashMap<>();
        int loops = 0;
        List<Integer> bag= new ArrayList<>();
        for(int i=0;i<100;i++){
            bag.add(i);
        }
        // shuffled the bag to have random permutation of 0-99
        Collections.shuffle(bag);
        // attach ends of strings in the mapping
        for(int i=0;i<100;i=i+2){
            ends.put(bag.get(i),bag.get(i+1));
            ends.put(bag.get(i+1),bag.get(i));
        }
        Random random = new Random();
        // now lets pick two ends at a time and combine them
        while(!bag.isEmpty()){
            int firstEndIndex = random.nextInt(bag.size());
            int firstEnd = bag.remove(firstEndIndex);
            int secondEndIndex = random.nextInt(bag.size());
            int secondEnd = bag.remove(secondEndIndex);

            int firstStringOtherEnd = ends.get(firstEnd);
            int secondStringOtherEnd = ends.get(secondEnd);

            // if both loose ends belong to the same string,
            // tying them forms a loop
            if (firstStringOtherEnd == secondEnd) {
                loops++;
                ends.remove(firstEnd);
                ends.remove(secondEnd);

            } else {
                // remove old connections
                ends.remove(firstEnd);
                ends.remove(firstStringOtherEnd);
                ends.remove(secondEnd);
                ends.remove(secondStringOtherEnd);
                // remaining loose ends become connected
                ends.put(firstStringOtherEnd, secondStringOtherEnd);
                ends.put(secondStringOtherEnd, firstStringOtherEnd);
            }
        }
        return loops;
    }
}