public class Card {


    private int rank;
    private String suite;




    public Card(int rank , String suite){
        this.rank = rank;
        this.suite = suite;
    }


    public int getRank() {
        return rank;
    }

    public String getSuite() {
        return suite;
    }

    @Override
    public String toString() {
        return "Card [" +
                "rank= " + rank +
                ", suite= " + suite+
                "]\n";
    }
}
