import java.io.File;

public abstract class XMLLoader {
    private File file;
    public XMLLoader(File file) {
        this.file = file;
    }    

    public File getFile() {
        return file;
    }
}
