public class Survey {
    private int rank;
    private int downloads;

    public Survey(int rank, int downloads) {
        this.rank = rank;
        this.downloads = downloads;
    }

    // Getters
    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getDownloads() {
        return downloads;
    }

    public int getRank() {
        return rank;
    }
}