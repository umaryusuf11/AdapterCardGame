package Console;

import java.util.Scanner;

public class InputTestAdapter implements Input {
    private Scanner userInput = new Scanner(System.in);
    protected Output userOutput;

    public InputTestAdapter(Output userOutput){
        this.userOutput = userOutput;
    }

    @Override
    public String getString(){
        return userInput.nextLine();
    }

    protected int convertToInteger(String input){
        return Integer.parseInt(input);
    }

    @Override
    public int getInteger(){
        boolean found = false;
        int result = -1;
        String input = null;
        do {
            try {
                input = getString();
                result = convertToInteger(input);
                found = true;
            } catch (NumberFormatException exception) {
                userOutput.output("Please enter a integer");
                //throw exception;
            }
        } while (!found);

        return result;
    }

    @Override
    public void setUserInput(Scanner userInput){
        this.userInput = userInput;
    }

}
