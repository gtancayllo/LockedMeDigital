package FileStructure;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Comparable<Directory> {

    private String name;
    private List<Directory> listDirectories = new ArrayList<>();
    private List<File> listFiles = new ArrayList<>();

    private String fullPath;

    public Directory(String name, String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Directory> getListDirectories() {
        return listDirectories;
    }

    public void setListDirectories(List<Directory> listDirectories) {
        this.listDirectories = listDirectories;
    }

    public List<File> getListFiles() {
        return listFiles;
    }

    public void setListFiles(List<File> listFiles) {
        this.listFiles = listFiles;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public int compareTo(Directory o) {
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
}
