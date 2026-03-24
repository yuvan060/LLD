package FileSystem.context;

import FileSystem.node.Node;

public class Context {
    public Node currentDirectory;
    // other context like current users permission levels


    public Context(Node currentDirectory) {
        this.currentDirectory = currentDirectory;
    }
}
