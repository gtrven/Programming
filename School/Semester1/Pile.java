import java.lang.invoke.MutableCallSite;
import java.util.ArrayList;
import java.util.Collections;

public class Pile
{

    //data member
    private ArrayList<Card> mcPile;

    //constructors
    public Pile()           //default constructor
    {
        mcPile = new ArrayList<Card>();

    }

    public Pile(Pile old)      //copy constructor
    {
        mcPile = new ArrayList<Card>(old.mcPile);

    }


    public Pile(int size)       //can throw IllegalArgumentException
    {
        mcPile = new ArrayList<Card>(size);


    }



    //methods


    public Card dealCard()
    {                   //can throw IndexOutOfBounds exception
        Card temp = new Card(mcPile.get(0)); //uses copy constructor

        return temp;

    }

    public void addCard(Card c)
    {
        mcPile.add(c);
    }

    public void addPile(Pile p)
    {
        mcPile.addAll(p.mcPile);

    }

    public Card getCard(int location)
    {
        return mcPile.get(location);
    }


    public int getCount()
    {
        return mcPile.size();
    }

    public void shuffle()
    {
        Collections.shuffle(mcPile);
    }

    public String toString()
    {
        String str = " ";

        for(int i = 0; i < mcPile.size(); i++)
        {
            if(i % 10 == 0)
                str += "\n";

            str = str + String.format("%5s", mcPile.get(i).toString());


        }
        return str;

    }


}
