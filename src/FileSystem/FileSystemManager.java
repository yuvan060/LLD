package FileSystem;

import FileSystem.command.Command;
import FileSystem.context.Context;
import FileSystem.node.Node;

import java.util.HashMap;
import java.util.Map;

public class FileSystemManager {
    public final Node root;
    public final Map<String, Command> commands;
    public final Context context;

    public FileSystemManager(Node root) {
        this.root = root;
        this.commands = new HashMap<>();
        this.context = new Context(root);
    }

    public void handleInput(String command, String... args) {
        //handle non-existence of commands
        commands.get(command).execute(context, args);
    }
}
