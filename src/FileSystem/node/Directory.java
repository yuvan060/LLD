package FileSystem.node;

import FileSystem.metadata.Metadata;

import java.util.HashMap;
import java.util.Map;

public class Directory extends Node{
    public final Map<String, Node> children;

    public Directory(String name, Node parent, Metadata metadata) {
        super(name, parent, metadata);
        this.children = new HashMap<>();
    }

    public void addNode(Node node) {
        //handle conflict
        children.put(node.name, node);
    }

    public void removeNode(String node) {
        //handle permissions & so on
        children.remove(node);
    }

    public Node getNode(String name) {
        return children.get(name);
    }

    @Override
    public long getSize() {
        long size = 0;
        for(Node node : children.values()) {
            size += node.getSize();
        }
        return size;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    @Override
    public boolean isFile() {
        return false;
    }
}
