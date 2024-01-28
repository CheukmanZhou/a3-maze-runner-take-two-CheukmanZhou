package ca.mcmaster.se2aa4.mazerunner;

public class SpaceFormatter {
    public String format(String path) {
        String spacedPath = Character.toString(path.charAt(0));

        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i - 1) == path.charAt(i)) {
                spacedPath = spacedPath + path.charAt(i);
            }

            else {
                spacedPath = spacedPath + " " + path.charAt(i);
            }
        }

        return spacedPath;
    }
}