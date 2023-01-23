import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChallengeTPC {

	public static void main(String[] args) {
		String arrayString = args[0];
		List<String> arrayTemp = parseArray(arrayString);

		List<Integer> array = arrayTemp.stream().map(Integer::parseInt).collect(Collectors.toList());
		Integer target = Integer.valueOf(args[1]);
		
		String result = calculate(array, target);
		
		System.out.print(result);
//		System.out.println("Target: "+target);
//		for (Integer integer : array) {
//			System.out.println("Array element: "+integer);
//		}
	}
	
	private static String calculate(List<Integer> array, Integer target) {
		int i = 0;
		while (i < array.size()-1) {
			int j = i+1;
			while (j < array.size()) {
				if ((array.get(i) + array.get(j)) == target)
					return ("["+i+","+j+"]");
				j++;
			}
			i++;
		}
		
		return "No se encontro resultado!";
	}

	private static List<String> parseArray(String arrayString) {
		arrayString = arrayString.substring(1,arrayString.length()-1);
		return Arrays.asList(arrayString.split(","));
	}

}
