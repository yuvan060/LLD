package FileSystem.node;

import FileSystem.metadata.Metadata;

public abstract class Node {
    public String name;
    public final Node parent;
    public final Metadata metadata;

    public Node(String name, Node parent, Metadata metadata) {
        this.name = name;
        this.parent = parent;
        this.metadata = metadata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public abstract long getSize();
    public abstract boolean isDirectory();
    public abstract boolean isFile();
}
