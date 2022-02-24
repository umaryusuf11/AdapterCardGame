package Structure;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadTestAdapter implements Config {
    final static String configPath = "src/main/resources/playersNames.cfg";
    protected List<String> propertyData = new ArrayList<String>();
    protected Scanner propertyReader;

    public LoadTestAdapter(){
        File propertyFile = new File(this.configPath);
        Scanner propertyReader = null;
        try {
            propertyReader = new Scanner(propertyFile);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        this.propertyReader = propertyReader;
    }

    public void setPropertyReader(Scanner propertyReader){
        this.propertyReader = propertyReader;
    }

    protected void populatePropertyData(){
        try {
            while (propertyReader.hasNextLine()) {
                String propertyRow = propertyReader.nextLine();
                this.propertyData.add(propertyRow);
            }
            propertyReader.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<String> getConfig(){
        if (this.propertyData.isEmpty()) {
            populatePropertyData();
        }
        return propertyData;
    }

}
