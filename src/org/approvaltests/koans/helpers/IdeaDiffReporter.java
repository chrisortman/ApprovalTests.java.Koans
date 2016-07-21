package org.approvaltests.koans.helpers;

import org.approvaltests.reporters.GenericDiffReporter;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * Created by cortman on 7/21/16.
 */
public class IdeaDiffReporter extends GenericDiffReporter {
    private static final String DIFF_PROGRAM = "/Applications/kdiff3.app/Contents/MacOS/kdiff3";
    static final String MESSAGE = MessageFormat.format("Unable to find KDiff3 at {0}", new Object[]{"/Applications/kdiff3.app/Contents/MacOS/kdiff3"});
    public static final org.approvaltests.reporters.macosx.KDiff3Reporter INSTANCE = new org.approvaltests.reporters.macosx.KDiff3Reporter();

    public IdeaDiffReporter() {
        super("/usr/local/bin/idea", "diff %s %s", MESSAGE, GenericDiffReporter.TEXT_FILE_EXTENSIONS);
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
