
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

evaluate( new File("../../configuration/ConfigurationPaths.groovy") )

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
