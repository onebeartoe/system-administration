
import java.io.File;

evaluate( new File("ConfigurationPaths.groovy") )

def filePath = "~/.octoprint/config.yml"

def file = new File(filePath)

if( file.exists() )
{
    println "file found"
}
else
{
    println "file NOT found"
}

if( file.canRead() )
{
    println "the file is readable"
}
else
{
    println "file CANNOT be read"
}
