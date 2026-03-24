package FileSystem.utils;

import FileSystem.node.Directory;
import FileSystem.node.Node;

public class PathResolverUtils {
    private PathResolverUtils() {
        //utility class, so preventing fron object creation
    }
    public static Node parsePath(String path, Directory currentDirectory,Node root) {
        if (path == null || path.isEmpty()) return currentDirectory;

        // Determine starting point
        Node cursor = path.startsWith("/") ? root : currentDirectory;
        String[] components = path.split("/");

        for (String component : components) {
            if (component.isEmpty() || component.equals(".")) continue;

            if (component.equals("..")) {
                cursor = (cursor.getParent() != null) ? cursor.getParent() : cursor;
            } else if (cursor instanceof Directory) {
                cursor = ((Directory) cursor).children.get(component);
            } else {
                return null; // Path breaks (trying to enter a file as a directory)
            }

            if (cursor == null) return null; // Path not found
        }
        return cursor;
    }
}
