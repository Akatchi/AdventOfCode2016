package Event2016.Day6;

import java.util.ArrayList;
import java.util.List;

public class InputSwapper
{
    public List<String> swapListOfStrings(List<String> input)
    {
        List<String> swappedInput = new ArrayList<>();

        for(String item : input) {
            for(int i = 0; i < item.length(); i++) {
                String inputToSet = String.valueOf(item.charAt(i));

                if(swappedInput.size() > i) {
                    inputToSet = swappedInput.get(i) + inputToSet;
                    swappedInput.remove(i);
                }

                swappedInput.add(i, inputToSet);
            }
        }

        return swappedInput;
    }
}
