public class Deck extends Pile
{



    public Deck()
    {

        super(52);

        for( int r = 1; r <=13; r++)
        {
            addCard(new Card(r, 'H'));
            addCard(new Card(r, 'D'));
            addCard(new Card(r, 'S'));
            addCard(new Card(r, 'C'));




        }


    }



}

