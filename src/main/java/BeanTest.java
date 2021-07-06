import java.lang.reflect.Array;
import java.util.ArrayList;

public class BeanTest {

    public static void main(String[] args) {
        Album help = new Album();
        Author fg = new Author("Forest", "Gump");
        Author aw = new Author("Austin", "Whitley");
        Author tb = new Author("The", "Beatles");
        Author hl = new Author("Heath", "Ledger");


        Quote quoteOne = new Quote("Shit happens", fg);
        Quote quoteTwo = new Quote("Someday, you will find yourself and realise that you are not as significant as once thought.", aw);
        Quote quoteThree = new Quote("Help me if you can im feeling down", tb);
        Quote quoteFour = new Quote("Well then a fox you shall be, my foxy lady", hl);

        ArrayList<Quote> quoteList = new ArrayList<>();
        quoteList.add(quoteOne);
        quoteList.add(quoteTwo);
        quoteList.add(quoteThree);
        quoteList.add(quoteFour);

        System.out.println("The list of quotes:");
        for(Quote quote: quoteList){
            System.out.print(quote.getAuthor().getFirstName() + " " + quote.getAuthor().getLastName() + " : ");
            System.out.print("\"" + quote.getContent() + "\"\n");
        }

    }
}
