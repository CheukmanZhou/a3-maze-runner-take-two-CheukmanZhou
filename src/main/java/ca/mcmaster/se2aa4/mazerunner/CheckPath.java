package ca.mcmaster.se2aa4.mazerunner;

public class CheckPath {
    public String check(String regCanonical, String regFactorized, String revCanonical, String revFactorized, String inputPath) {
        regCanonical = regCanonical.replaceAll("\\s+", "");
        regFactorized = regFactorized.replaceAll("\\s+", "");
        revCanonical = revCanonical.replaceAll("\\s+", "");
        revFactorized = revFactorized.replaceAll("\\s+", "");

        if (inputPath.equals(regCanonical)) {
            return "Correct Path";
        }

        if (inputPath.equals(regFactorized)) {
            return "Correct Path";
        }

        if (inputPath.equals(revCanonical)) {
            return "Correct Path";
        }

        if (inputPath.equals(revFactorized)) {
            return "Correct Path";
        }

        return "Incorrect Path";
    }
}
