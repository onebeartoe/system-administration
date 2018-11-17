
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

//evaluate( new File("ConfigurationPaths.groovy") )

//def configFilePath = "config.yaml";
def configFilePath = "/home/pi/.octoprint/config.yaml";

//def backupFilePath = "config.yaml.backup"
def backupFilePath = "/home/pi/.octoprint/config.yaml.backup"

// Does the Events configuration already exist?
def bytesArray = Files.readAllBytes( Paths.get(configFilePath) );

String configContents = new String(bytesArray, "ISO-8859-1");

def configExists = configContents.contains("events:") && configContents.contains("subscriptions:");

println "config exists: " + configExists

if(configExists)
{
    println "the configuration already exists, no operation performed."
}
else
{
    // Does the backup file exist?
    def backupFile = new File(backupFilePath);
    if( backupFile.exists() )
    {
        println "The backup file already exists, skipping backup of configuration"
    }
    else
    {
        // backup the configuration file in case a revert is needed
        def source = Paths.get(configFilePath);
        
        def outstream = new FileOutputStream(backupFile);
        
        Files.copy(source, outstream);        
    }
    
    // append the 'events:' block to the configuration file
    def outpath = Paths.get(configFilePath);
    
    def text = Files.readAllBytes( Paths.get("config.xml.events") )
    
    Files.write(outpath, text, StandardOpenOption.APPEND)
}
