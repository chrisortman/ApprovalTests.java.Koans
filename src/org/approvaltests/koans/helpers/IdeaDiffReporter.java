package org.approvaltests.koans.helpers;

import org.approvaltests.reporters.GenericDiffReporter;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cortman on 7/21/16.
 */
public class IdeaDiffReporter extends GenericDiffReporter {
    private static final String DIFF_PROGRAM = "/usr/local/bin/idea";
    static final String MESSAGE = MessageFormat.format("Unable to find Idea at {0}", new Object[]{DIFF_PROGRAM});
    public static final IdeaDiffReporter INSTANCE = new IdeaDiffReporter();
    public static List<String> EXTENSIONS = Arrays.asList(new String[]{
        ".txt", ".csv", ".htm", ".html", ".xml", ".eml", ".java", ".css", ".js",
        ".png", ".gif", ".jpg", ".jpeg", ".bmp", ".tif", ".tiff"
    });

    public IdeaDiffReporter() {
        super(DIFF_PROGRAM, "diff %s %s", MESSAGE, EXTENSIONS);
    }

    @Override
    public String[] getCommandLine(String received, String approved) {
        String[] p = this.arguments.split(" ");
        String r = String.format(p[1], new Object[]{received});
        String a = String.format(p[2], new Object[]{approved});
        String[] commands = new String[]{this.diffProgram,p[0], r, a};
        System.out.println(Arrays.toString(commands));
        return commands;
    }
}
