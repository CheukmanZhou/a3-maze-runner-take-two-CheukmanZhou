package ca.mcmaster.se2aa4.mazerunner;

public class FactorizedPath {
    public String convert(String path) {
        String[] splitPath = path.split(" ");
        String factorizedPath = "";

        String instruction = splitPath[0];
        factorizedPath = Integer.toString(instruction.length()) + instruction.charAt(0);

        for (int i = 1; i < splitPath.length; i++) {
            instruction = splitPath[i];

            factorizedPath = factorizedPath + " " + instruction.length() + instruction.charAt(0);
        }

        return factorizedPath;
    }
}
