package App;

public class File {
    private String[] fileContent;
    private String fileName;
    public File(String[] fileContent, String fileName) {
        this.fileContent = fileContent;
        this.fileName = fileName;
    }
    public int count(String wordToCount) {
        int accountant = 0;
        for(String word : this.fileContent) {
            word = word.replaceAll("[.,;()\n]+", "");
            if(word.equalsIgnoreCase(wordToCount)) {
                accountant++;
            }
        }
        return accountant;
    }
    public String getFileName() {
        return fileName;
    }
}
