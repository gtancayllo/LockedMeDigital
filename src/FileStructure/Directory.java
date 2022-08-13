package FileStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * class that represents a Directory
 */
public class Directory implements Comparable<Directory> {
    /**
     * name of the directory
     */
    private String name;
    /**
     * list of subdirectories
     */
    private List<Directory> listDirectories = new ArrayList<>();
    /**
     * list of files of the current directory
     */
    private List<File> listFiles = new ArrayList<>();

    /**
     * full path of the directory
     */
    private String fullPath;

    /**
     * constructor of the directory class
     * @param name name of the directory
     * @param fullPath full path of the directory
     */
    public Directory(String name, String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    /**
     * getter of the name member
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter of the name member
     * @param name name to update
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the list of directories member
     * @return list of directories
     */
    public List<Directory> getListDirectories() {
        return listDirectories;
    }

    /**
     * setter of the list of directories member
     * @param listDirectories list of directories to update
     */
    public void setListDirectories(List<Directory> listDirectories) {
        this.listDirectories = listDirectories;
    }

    /**
     * getter for the list of files member
     * @return list of files
     */
    public List<File> getListFiles() {
        return listFiles;
    }

    /**
     * setter of the list of files member
     * @param listFiles list of files to update
     */
    public void setListFiles(List<File> listFiles) {
        this.listFiles = listFiles;
    }

    /**
     * getter of the full path member
     * @return full path
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * setter of the full path member
     * @param fullPath full path to update
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    /**
     * implementation of the compareTo method
     * @param o object to be compared
     * @return comparison result
     */
    @Override
    public int compareTo(Directory o) {
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
}
