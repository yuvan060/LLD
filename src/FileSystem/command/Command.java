package FileSystem.command;

import FileSystem.context.Context;

public interface Command {
    void execute(Context context, String... args);
}
