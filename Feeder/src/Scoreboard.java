public class Scoreboard
{
    private String team1Name, team2Name;
    private int whoseTurn;
    private int score1, score2;

    public Scoreboard(String team1, String team2)
    {
        team1Name = team1;
        team2Name = team2;
        whoseTurn = 1;
        score1 = 0;
        score2 = 0;
    }

    public void recordPlay(int points)
    {
        if (points == 0)
        {
            if (whoseTurn == 1)
            {
                whoseTurn = 2;
            }
            else
            {
                whoseTurn = 1;
            }
        }
        else
        {
            if (whoseTurn == 1)
            {
                score1 += points;
            }
            else
            {
                score2 += points;
            }
        }
    }

    public String getScore()
    {
        String result = score1 + "-" + score2 + "-";
        if (whoseTurn == 1)
        {
            result += team1Name;
        }
        else
        {
            result += team2Name;
        }
        return result;
    }
}

