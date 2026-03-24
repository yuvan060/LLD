package FileSystem;

public class FileSystem {
    /*
    We need to find a file system,
    that should support directories & files
    and for directories, it should support the basic operations like addDirectory, removeDirectory, getDirectory, getNode
    and for file it should contain metadata & extensions of the file then read & edit the contents
    File system should handle the basic commands like mkDir, cd, touch...

    File System Design :-
        Entities  :
            abstract class Node : name, createdAt, permissions, Node parent; abs methods - isDirectory(), isFile(); getName(), getSize()
            Directory extended by Node: Map<String, Node> children; addNode(), getNode(), removeNode()
            File extended by Node: extension, byte[] content, size; readContent(), writeContent(), getExtension()
            Context : currentDirectory, permissionLevel
            Command : ; void execute(Context context, ...args[]) - extended by mkDir, touch, cd ....
            FileSystem : context, Map<String, Command>; handleInput(String args[])
        Enums :
            EXTENSION : txt, java, cpp, py
            PERMISSION : READ, WRITE
     */
}
