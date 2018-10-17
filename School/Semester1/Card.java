/*
This program will model a playing card.

Programmer: Steven Crider
date: 11/21/17
 */

public class Card
{
        //data members
    private int rank;
    private char suit;

    //constructor

    public Card()       //default constructor, creates ace of spades
    {
        rank = 1;
        suit = 'S';
    }

    public Card(Card old)   //copy constructor
    {
        rank = old.rank ;
        suit = old.suit ;
    }

    public Card(int r, char s)
    {
        setCard(r, s);

    }

    //methods

    public void setCard(int r, char s)
    {
        if ( r >= 1 && r <= 13)
            rank = r;
        else
            throw new IllegalArgumentException("Rank should be 1-13: " +r);

        s = Character.toUpperCase(s);

        if(s == 'S' || s == 'D' || s == 'C' || s == 'H')
            suit = s;
        else
            throw new IllegalArgumentException("Suit should be: S, D, C, or H: " +s);
    }

    public int getRank()    //accessor method to retrieve rank
    {

      return rank;
    }

    public char getSuit()   //accessor method to retrieve suit
    {
        return suit;
    }

    public boolean equals(Card c)       //compare the ranks of two Cards
    {
        return rank == c.rank;

    }

    public int compareTo(Card c)    //compare rank of two cards to determine which is larger
    {
        if(rank < c.rank)
            return -1;
        if(rank > c.rank)
            return 1;

        return 0;

    }

    public String toString()
    {
        String s = " ";

        if( rank >= 2 && rank <= 10)
        s = s + rank;
        else if(rank == 1)
            s = s + 'A';
        else if(rank == 11)
            s = s + 'J';
        else if( rank == 12)
            s = s + 'Q';
        else
            s = s + 'K';

        return s + suit;
    }

}
