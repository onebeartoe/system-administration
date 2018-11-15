
import java.io.File;

def filePath = "~/.octoprint/config.yml"

def file = new File(filePath)

if( file.exists() )
{
    println "file found"
}
else
{
    println "file NOT found - not gonna do it"
}

if( file.canRead() )
{
    println "the file is readable"
}
else
{
    println "file CANNOT be read, not gonna read it"
}
