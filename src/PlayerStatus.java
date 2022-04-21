public class PlayerStatus {
    protected String nickname;
    protected int score;
    protected int lives;
    protected int health;
    protected String weaponInHand;
    protected double positionOX;
    protected double positionOY;
    protected String gameName;


    public PlayerStatus(String nickname, int score, int lives, int health, String weaponInHand, double positionOX, double positionOY, String gameName) {
        this.nickname = nickname;
        this.score = score;
        this.lives = lives;
        this.health = health;
        this.weaponInHand = weaponInHand;
        this.positionOX = positionOX;
        this.positionOY = positionOY;
        this.gameName = gameName;
    }

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
        if (lives == 0){
            System.out.println("Game Over");
        }
    }
}
