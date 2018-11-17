
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

def pwd = new File(".")
println "pwd: " + pwd.getAbsolutePath();

//evaluate( new File("ConfigurationPaths.groovy") )

def configFilePath = "/home/pi/.octoprint/config.yaml";
//def configFilePath = "~/.octoprint/config.yaml";

def backupFilePath = "/home/pi/.octoprint/config.yaml.backup"
//def backupFilePath = "~/.octoprint/config.yaml.backup"

def backupFile = new File(backupFilePath)

if( backupFile.exists() )
{
    println "backupFile found"
    
    if( backupFile.canRead() )
    {
        println "the backupFile is readable"
        
        def source = backupFile.toPath();

        def outstream = new FileOutputStream(configFilePath);

        Files.copy(soure, outstream);        
    }
    else
    {
        println "backupFile CANNOT be read, not gonna read it"
    }    
}
else
{
    println "backupFile NOT found - not gonna do it"
}
