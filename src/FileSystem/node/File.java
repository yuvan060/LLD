package FileSystem.node;

import FileSystem.ENUM.EXTENSION;
import FileSystem.metadata.Metadata;

public class File extends Node{
    public EXTENSION extension;
    public Byte[] content;

    public File(String name, Node parent, Metadata metadata, Byte[] content, EXTENSION extension) {
        super(name, parent, metadata);
        this.content = content;
        this.extension = extension;
    }

    public Byte[] getContent() {
        return content;
    }

    public void setContent(Byte[] content) {
        //this should not be like this, we have to handle the logic for content update
        this.content = content;
    }

    @Override
    public long getSize() {
        return content.length;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isFile() {
        return true;
    }
}
