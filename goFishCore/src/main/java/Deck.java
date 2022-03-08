import java.util.Random;

public class Deck {
    private int count;
    private Card[] hand;
    private static final int Storage = 52;
    private static Random random = new Random();
    public Deck(){
        hand = new Card[Storage];
        count = 0;
    }

    public void fillDeck(){
        Card card;
        for(int i = 1; i <= 4; i++){
            for(int j = 1; j <= 13; j++){
                card = new Card(j,i);
                this.insertCard(card);
            }
        }
    }
    public void insertCard(Card card){
        if(count == hand.length){
            Card[] _temp = new Card[count + Storage];
            for(int i = 0; i < hand.length; i++){
                _temp[i] = hand[i];
            }
            hand = _temp;
        }
        hand[count] = card;
        count++;
    }
    public Card deleteValue(int value){
        Card temp;
        Card deleted;
        for(int i = 0; i < count; i++){
            temp = hand[i];
            if(temp.getValue() == value){
                deleted = temp;
                hand[i] = hand[count - 1];
                count--;
                return deleted;
            }
        }
        return null;
    }
    public Card deletedAnyCard(){
        if(count == 0){
            return null;}
        else{
            int randoIx = random.nextInt(count);
            Card temp = hand[randoIx];
            if(randoIx != count - 1){
                hand[randoIx] = hand[count - 1];
                count--;
            }
            return temp;
        }
    }
    public int checkBookBeginningDeal(){
        for(int i = 0; i < 4; i++){
            if(getCount(hand[i].getValue()) == 4){
                return hand[i].getValue();
            }
        }
        return 0;
    }
    public int getCount(int value){
        int occurrences = 0;
        for(int i = 0; i < count; i++){
            if(hand[i].getValue() == value){
                occurrences++;
            }
        }
        return occurrences;
    }
    public int getSize(){
        return count;
    }
    public String toString() {
        if (count != 0){
            String result = "User Deck: \n";
            for(int i = 0; i < count; i++){
                result = result + hand[i] + "\n";
            }
            return result;
        }
        return "Empty Hand;";
    }
}
