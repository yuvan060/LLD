package FileSystem.command;

import FileSystem.context.Context;
import FileSystem.node.Directory;
import FileSystem.node.Node;
import FileSystem.utils.PathResolverUtils;

public class CdCommand implements Command {
    public Node root;
    public CdCommand(Node root) {
        this.root = root;
    }
    @Override
    public void execute(Context context, String... args) {
        if (args.length == 0) return;

        String path = args[0];
        // Note: You'll need to pass 'root' to the context or manager
        Node target = PathResolverUtils.parsePath(path, (Directory) context.currentDirectory, root);

        if (target != null && target.isDirectory()) {
            context.currentDirectory = target;
        } else {
            System.out.println("Path not found: " + path);
        }
    }
}