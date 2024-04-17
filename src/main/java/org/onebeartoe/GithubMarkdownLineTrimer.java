
package org.onebeartoe;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  This class is intended to trim whitespace of the lines in Github flavored Markdown.
 */
public class GithubMarkdownLineTrimer
{
    public static void main(String[] args) throws IOException
    {
        if(args.length == 0)
        {
            System.out.println("Provide the path to the imput file as command line argument.");
        }
        else
        {
            var app = new GithubMarkdownLineTrimer();

            app.trim(args);
        }
    }
    
    public void trim(String[] args) throws IOException
    {
        File infile = new File(args[0]);

        if(infile.exists())
        {
            trim(infile);
        }
        else
        {
            var message = "The input file does not exists: " + infile.getAbsolutePath();

            System.err.println(message);
        }
    }

    private void output(File outfile, List<String> trimmedLines) throws IOException
    {
        var outpath = outfile.toPath();
        
        Files.write(outpath, trimmedLines, StandardCharsets.UTF_8);
    }
    
    private void trim(File infile) throws IOException
    {
        var inpath = infile.toPath();

        List<String> trimmedLines = Files.lines(inpath)
                                        .map(line -> line.trim())
                                        .collect( Collectors.toList() );

        var outpath = infile.getAbsoluteFile() + ".trimmed.md";

        var outfile = new File(outpath);
        
        output(outfile, trimmedLines);
    }
}
