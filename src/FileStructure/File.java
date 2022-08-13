package FileStructure;

/**
 * class that represents a file in memory
 */
public class File implements Comparable<File> {
    String name;
    String fullPath;

    /**
     * constructor
     * @param name file name
     * @param fullPath file path
     */
    public File(String name,  String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    /**
     * getter for the name member
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for the name member
     * @param name name of the file
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for the full path member
     * @return full path
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * setter for the full path
     * @param fullPath full path to set
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    /**
     * method that handles file comparison
     * @param o file to be compare
     * @return the file comparison
     */
    @Override
    public int compareTo(File o) {
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
}
