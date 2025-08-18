import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Log {
    public static String createLogFile(){
        try {
            LocalDateTime currentDateTime = LocalDateTime.now();

            //create logging folder if it doesn't already exist
            File logsFolders = new File("logs");
            logsFolders.mkdirs();

            //create current log file
            String logFilePath = logsFolders.getPath();
            File myLogFile = new File(logFilePath + "/err_" + currentDateTime + ".txt");
            myLogFile.createNewFile();

            if(myLogFile.createNewFile()){
                System.out.println("Log file created successfully.");
            } else {
                System.out.println("Unable to create log file, a file with the same name already exists.");
            }

            return myLogFile.getPath();
        } catch (IOException e) {
            System.out.println("Failed to create log file.");
            e.printStackTrace();
            return "err_  Unable to create log file.";
        }        
    }

    public static void addLoggingDetails(String filePath,String exception, String extraErrorDetails){
        try {
            FileWriter updateLog = new FileWriter(filePath);
            updateLog.write(exception + "\n\n" + extraErrorDetails);
            updateLog.close();
        } catch (IOException e) {
            System.out.println("Unable to update log file.");
            e.printStackTrace();
        }
    }
}
