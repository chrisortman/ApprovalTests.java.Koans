package org.approvaltests.koans;

import org.approvaltests.Approvals;
import org.approvaltests.koans.helpers.IdeaDiffReporter;
import org.approvaltests.reporters.DiffReporter;
import org.approvaltests.reporters.JunitReporter;
import org.approvaltests.reporters.UseReporter;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by cortman on 7/21/16.
 */
@UseReporter(IdeaDiffReporter.class)
public class SimplestExampleTest {

    class Customer {
        public String firstName;
        public String lastName;

        public String fullName() {
            return firstName + " " + lastName;
        }
    }

    @Test
    public void fullNameIsFirstAndLastName() {
        Customer c = new Customer();
        c.firstName = "Bart";
        c.lastName = "Simpson";

        assertEquals("Bart Simpson", c.fullName());
    }

    @Test
    public void verifyFullName() throws Exception {
        Customer c = new Customer();
        c.firstName = "Bart";
        c.lastName = "Simpson";

        Approvals.verify(c.fullName());
    }
}
