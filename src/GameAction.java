public class GameAction extends PlayerStatus {

    public GameAction(String nickname, int score, int lives, int health, String weaponInHand, double positionOX, double positionOY, String gameName) {
        super(nickname, score, 5, 100, weaponInHand, positionOX, positionOY, "MyGame");
    }

    public void getWeapon (String weaponInHand){
        if (weaponInHand.equals("knife")){
            if (score >= 1000){
                this.weaponInHand = weaponInHand;
                score -= 1000;
            }
        }
        if (weaponInHand.equals("sniper")){
            if (score >= 10000){
                this.weaponInHand = weaponInHand;
                score -= 10000;
            }
        }
        if (weaponInHand.equals("kalashnikov")){
            if (score >= 20000){
                this.weaponInHand = weaponInHand;
                score -= 20000;
            }
        }
    }

    public double distance(PlayerStatus player1, PlayerStatus player2){
        return Math.sqrt((player1.positionOX - player2.positionOX) + (player1.positionOY - player2.positionOY));
    }

    public void duel (PlayerStatus player1, PlayerStatus player2) {
        double player1WinChance;
        double player2WinChance;
        if (player1.weaponInHand.equals(player2.weaponInHand)) {
            player1WinChance = (3 * player1.health + player1.score / 1000) / 4;
            player2WinChance = (3 * player2.health + player2.score / 1000) / 4;
            if (player2WinChance > player1WinChance){
                System.out.println(player2 + " wins! ");
            }
            else{
                System.out.println(player1 + " wins! ");
            }
        }
        if (distance(player1, player2) > 1000){
            switch(player1.weaponInHand){
                case "sniper":
                    if (!player2.weaponInHand.equals("sniper")){
                        System.out.println(player1 + " wins!");
                    }
                    else {
                        System.out.println("draw");
                    }
                    break;
                case "kalashnikov":
                    if (player2.weaponInHand.equals("sniper")){
                        System.out.println(player2 + " wins!");
                    }
                    if (player2.weaponInHand.equals("knife")){
                        System.out.println(player1 + " wins!");
                    }
                    else{
                        System.out.println("Draw");
                    }
                case "knife":
                    if (!player2.weaponInHand.equals("knife")){
                        System.out.println(player2 + " wins!");
                    }
                    else {
                        System.out.println("Draw.");
                    }
            }
        }
        else{
            switch(player1.weaponInHand){
                case "kalashnikov":
                    if (!player2.weaponInHand.equals("kalashnikov")){
                        System.out.println(player1 + " wins!");
                    }
                    else {
                        System.out.println("draw");
                    }
                    break;
                case "sniper":
                    if (player2.weaponInHand.equals("kalashnikov")){
                        System.out.println(player2 + " wins!");
                    }
                    if (player2.weaponInHand.equals("knife")){
                        System.out.println(player1 + " wins!");
                    }
                    else{
                        System.out.println("Draw");
                    }
                case "knife":
                    if (!player2.weaponInHand.equals("knife")){
                        System.out.println(player2 + " wins!");
                    }
                    else {
                        System.out.println("Draw.");
                    }
            }
        }
    }

    public boolean isTrap(int number) {
        int lastDigit;
        int digitSum = 0;
        while (number > 0) {
            lastDigit = number % 10;
            digitSum += lastDigit;
            number /= 10;
        }
        return number % 2 == 0 && digitSum % 3 == 0;
    }


    public boolean isPrime(int a) {
        for(int i = 2; i < a; ++i) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPerfect (int a) {
        int divisorSum = 0;
        for (int i = 1 ; i <=a ; i++){
            if (a % i == 0){
                divisorSum += i;
            }
        }
        return a == divisorSum;
    }

    public void findArtifact(int artifactCode){
        if (isPerfect(artifactCode)){
            score += 5000;
            lives += 1;
            health = 100;
        }

        if (isPrime(artifactCode)){
            score += 100;
            lives += 2;
            health += 25;
        }
        if (isTrap(artifactCode) && !isPerfect(artifactCode)){
            score -= 3000;
            health -= 25;
        }
        else{
            score += artifactCode;
        }
    }
}
