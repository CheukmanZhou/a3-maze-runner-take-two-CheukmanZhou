package ca.mcmaster.se2aa4.mazerunner;

public class SpaceFormatter {
    public String format(String path) {
        String spacedPath = "";

        for (int i = 0; i < path.length() - 1; i++) {
            if (path.charAt(i) == path.charAt(i + 1)) {
                spacedPath = spacedPath + path.charAt(i) + path.charAt(i + 1);
            }

            else {
                spacedPath = spacedPath + path.charAt(i) + " " + path.charAt(i + 1);
            }
        }

        return spacedPath;
    }
}