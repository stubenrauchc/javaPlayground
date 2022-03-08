public class Card {
    private int _suit, _value;
    public Card(int value, int suit){
        _value = value;
        _suit = suit;
    }
    public String toString(){
        String value = "";
        if(_value > 10){
            //the below switch is the modern style introduced in java 13
            //sometimes the font changes - > into an actual arrow
            switch (_value) {
                case 11 -> value = "Jack of ";
                case 12 -> value = "Queen of ";
                case 13 -> value = "King of ";
            }
        }
        else if(_value == 1){
            value = "Ace of ";
        }
        else
            value = "" + _value + " of ";
        String suit = "";
        if(_suit >= 1 && _suit <=4){
            //the below switch is the old style from before java 13
            switch(_suit){
                case 1:
                    value = "Clubs";
                    break;
                case 2:
                    value = "Diamonds";
                    break;
                case 3:
                    value = "Hearts";
                    break;
                case 4:
                    value = "Spades";
                    break;
            }
        }
        return value + suit;
    }
    public int getSuit(){
        return _suit;
    }
    public int getValue(){
        return _value;
    }
}
