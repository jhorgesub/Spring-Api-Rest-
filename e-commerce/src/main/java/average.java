import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class average {
    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(4,2,9,5,1,3);
        System.out.println("Promedio: " + calculateAvg(array));
        maxValue(array);
    }

    //promedio con streams
    private static double calculateAvg(List<Integer> array){
        return array.stream().collect(Collectors.averagingInt(Integer::intValue));
    }

    private static void maxValue(List<Integer> array) {
         Optional<Integer> max = array.stream().collect(Collectors.maxBy(Integer::compare));
         System.out.println("Máximo valor: " + max );

    }
}
