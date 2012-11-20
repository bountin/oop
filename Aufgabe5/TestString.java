/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Johannes Wawerda <johannes.wawerda@student.tuwien.ac.at>
 */
public class TestString implements Shorter<TestString> {

    private String s;

    public TestString(String s) {
        this.s = s;
    }

    @Override
    public boolean shorter(TestString element) {
        if (this.s.length() < element.toString().length()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestString other = (TestString) obj;
        if ((this.s == null) ? (other.s != null) : !this.s.equals(other.s)) {
            return false;
        }
        return true;
    }
}
