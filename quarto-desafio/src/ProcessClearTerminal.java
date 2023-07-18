import java.io.IOException;

public final class ProcessClearTerminal {
    private final static String OPERATIONAL_SYSTEM_NAME = System.getProperties().getProperty("os.name");

    private ProcessClearTerminal(){}
    private static ProcessClearTerminal instance = null;
    private static ProcessBuilder process = null;

    public static ProcessClearTerminal getInstanceProcessClearTerminal() {
        if ( instance == null ) {
            if ( OPERATIONAL_SYSTEM_NAME.equals("Linux") ) {
                process = new ProcessBuilder("bash", "-c", "clear").inheritIO();
            
            } else if (OPERATIONAL_SYSTEM_NAME.equals("Windows")) {  
                process = new ProcessBuilder("cmd", "/c", "cls").inheritIO();
                        
            } else {
                process = new ProcessBuilder("bash", "-c", "printf '\033c'").inheritIO(); // macOS
            }
            instance = new ProcessClearTerminal();
        }
        return instance;
    }

    public void clear() {
        try {
            process.start().waitFor();
            
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
