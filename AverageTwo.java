public class AverageTwo {
    int[] nums = {10, 29, 23, 50, 100};


   public static  int  findAverage(int[] numsParameter) {
    int sum = 0;
    for(int i = 0; i< numsParameter.length; i++){
        sum += numsParameter[i]; // sum = numsParameter[i] + sum
    
    }
    return sum / numsParameter.length;



   }
   
    public static void main(String[]args){
        int[] localNums = {50, 80, 23, 50, 100};
       int average = findAverage(localNums);
       System.out.println("Средна стойност:"+ average);

    }
}
