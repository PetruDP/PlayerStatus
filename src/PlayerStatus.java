public class PlayerStatus {
    private String nickname;
    private int score;
    private int lives;
    private int health;
    private String weaponInHand;
    private double positionOX;
    private double positionOY;
    private static String gameName;


    public PlayerStatus(String nickname) {
        this.nickname = nickname;
    }

    public PlayerStatus(String nickname, int lives) {
        this.nickname = nickname;
        this.lives = lives;
    }

    public PlayerStatus(String nickname, int score, int lives) {
        this.nickname = nickname;
        this.score = score;
        this.lives = lives;
    }

    public String getNickname() {
        return nickname;
    }

    public void checkHealth (){
        if (this.health <= 0){
            this.lives -= 1;
            this.health = 100;
        }
        if (this.health > 100){
            this.health = 100;
        }
    }

    public void checkLives (){
        if (this.lives == 0){
            System.out.println("Game Over");
        }
    }

    public static String getGameName() {
        return gameName;
    }

    static void setGameName(String gameName) {
        PlayerStatus.gameName = gameName;
    }

    public double getPositionOX() {
        return positionOX;
    }

    public void setPositionOX(double positionOX) {
        this.positionOX = positionOX;
    }

    public double getPositionOY() {
        return positionOY;
    }

    public void setPositionOY(double positionOY) {
        this.positionOY = positionOY;
    }

    public String getWeaponInHand() {
    return weaponInHand;
}

public boolean setWeaponInHand (String weaponInHand){
    if (weaponInHand.toLowerCase().equals("knife")){
        if (this.score >= 1000){
            this.weaponInHand = weaponInHand;
            this.score -= 1000;
            return true;
        }
    }
    if (weaponInHand.toLowerCase().equals("sniper")){
        if (this.score >= 10000){
            this.weaponInHand = weaponInHand;
            this.score -= 10000;
            return true;
        }
    }
    if (weaponInHand.toLowerCase().equals("kalashnikov")){
        if (this.score >= 20000){
            this.weaponInHand = weaponInHand;
            this.score -= 20000;
            return true;
        }
    }
    return false;
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
            this.score += 5000;
            this.lives += 1;
            this.health = 100;
        }

        if (isPrime(artifactCode)){
            this.score += 100;
            this.lives += 2;
            this.health += 25;
        }
        if (isTrap(artifactCode) && !isPerfect(artifactCode)){
            this.score -= 3000;
            this.health -= 25;
        }
        else{
            this.score += artifactCode;
        }
    }

    public void movePlayerTo (double positionOX, double positionOY){
        this.positionOX = positionOX;
        this.positionOY = positionOY;
    }

    public double distance(PlayerStatus player2){
        return Math.sqrt((getPositionOX() - player2.getPositionOX()) + (getPositionOY() - player2.getPositionOY()));
    }

    public double probability(){
        return (3 * this.health + (double)this.score / 1000) / 4;
    }


    public boolean shouldAttackOpponent(PlayerStatus opponent){
        if (this.weaponInHand == null && opponent.getWeaponInHand() == null){
            double player1WinChance = (3 * this.health + this.score / 1000) / 4;
            double player2WinChance = (3 * opponent.health + opponent.score / 1000) / 4;
            return player1WinChance >  player2WinChance;
        }
        if (this.weaponInHand == null) { return false; }
        if (opponent.weaponInHand == null) { return true; }
        if (this.weaponInHand.equals(opponent.getWeaponInHand())){
            return probability() > opponent.probability();
        }
        if (distance(opponent) < 1000){
            if (this.weaponInHand.equals("kalasnikov")){
                return true;
            }else if (this.weaponInHand.equals("sniper")){
                return !opponent.getWeaponInHand().equals("kalasnikov");
            }else if (this.weaponInHand.equals("knife")){
                if (opponent.weaponInHand.isEmpty()){
                    return true;
                }
                return false;
            }
            return false;

        }else if (this.weaponInHand.equals("sniper")){
            return true;
        }else if (this.weaponInHand.equals("kalasnikov") && opponent.getWeaponInHand().equals("sniper")){
            return false;
        }
        return true;
    }

}
