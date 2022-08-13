package FileStructure;

public class File implements Comparable<File> {
    String name;
    String fullPath;

    public File(String name,  String fullPath) {
        this.name = name;
        this.fullPath = fullPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public int compareTo(File o) {
        return getName().toLowerCase().compareTo(o.getName().toLowerCase());
    }
}
