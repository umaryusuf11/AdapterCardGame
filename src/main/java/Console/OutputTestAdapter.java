package Console;

import java.util.ArrayList;
import java.util.List;

public class OutputTestAdapter implements Output {
    protected List<String> storeOutput = new ArrayList<String>();

    @Override
    public void output(String message){
        storeOutput.add(message);
        System.out.println(message);
    }

    @Override
    public List<String> getStoreOutput(){
        return storeOutput;
    }

}
