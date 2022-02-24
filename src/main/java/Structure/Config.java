package Structure;

import java.util.List;
import java.util.Scanner;

public interface Config {
    public void setPropertyReader(Scanner propertyReader);
    public List<String> getConfig();
}
