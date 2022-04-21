public class Main {
    public static void main(String[] args) {

        PlayerStatus player1 = new PlayerStatus("Player1");
        PlayerStatus player2 = new PlayerStatus("Player2", 10000,2);
        PlayerStatus player3 = new PlayerStatus("Player3", 3);

        player1.movePlayerTo(100.54, 50.32);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player1.findArtifact(13);
        player2.setWeaponInHand("sniper");
        player3.findArtifact(2000000);
        player3.setWeaponInHand("kalasnikov");
        System.out.println("player 1 pe player 3 : " + player1.shouldAttackOpponent(player3));
        System.out.println("player 2 pe player 3 : " + player2.shouldAttackOpponent(player3));

    }
}
