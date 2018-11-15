
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.nio.file.Path;
    
evaluate( new File("ConfigurationPaths.groovyyyy") )

// Does the Events configuration already exists?
def configContents = Files.readAllBytes( Path.get(configFilePath) );

def configExists = configContents.contains("events:") && configContents.contains("subscriptions:");

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
        def source = Path.get(configFilePath);
        
        def outstream = FileOutputStream(backupFile);
        
        Files.copy(source, outstream);        
    }
    
    // append the 'events:' block to the configuration file
    def outpath = Path.get(configFilePath);
    def text = Files.readAllBytes("config.xml.events")
    Files.write(outpath, text, StandardOpenOption.APPEND)
}
