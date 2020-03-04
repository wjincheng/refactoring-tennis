package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;
    private String player1Name;
    private String player2Name;
    private static String LOVE = "Love";
    private static String FIFTEEN = "Fifteen";
    private static String THIRTY = "Thirty";
    private static String FORTY = "Forty";

    public TennisGame1(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName){
        if (playerName.equals(player1Name)) {
            mScore1++;
        } else {
            mScore2++;
        }
    }

    @Override
    public String getScore(){
        if (isDeuce()) {
            return "Deuce";
        } else if (isEqualNotDeuce()) {
            return getScore(mScore1) + "-All";
        } else if (isNotEndButScoreBiggerThanFour()) {
            return "Advantage " + getHighScoreName();
        } else if (isEnd()) {
            return "Win for " + getHighScoreName();
        } else {
            return getScore(mScore1) + "-" + getScore(mScore2);
        }
    }

    private boolean isEnd(){
        return (mScore1 >= 4 || mScore2 >= 4) && Math.abs(mScore1 - mScore2) >= 2;
    }

    private boolean isNotEndButScoreBiggerThanFour(){
        return (mScore1 >= 4 || mScore2 >= 4) && Math.abs(mScore1 - mScore2) == 1;
    }

    private boolean isDeuce(){
        return (mScore1 == mScore2) && mScore1 > 2;
    }

    private boolean isEqualNotDeuce(){
        return (mScore1 == mScore2) && mScore1 < 3;
    }

    private String getScore(int tempScore){
        switch (tempScore) {
            case 0:
                return LOVE;
            case 1:
                return FIFTEEN;
            case 2:
                return THIRTY;
            case 3:
                return FORTY;
            default:
                return "";
        }
    }

    private String getHighScoreName(){
        return mScore1 > mScore2 ? player1Name : player2Name;
    }
}