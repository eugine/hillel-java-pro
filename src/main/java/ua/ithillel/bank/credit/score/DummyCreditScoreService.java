package ua.ithillel.bank.credit.score;

public class DummyCreditScoreService implements CreditScoreService {

    @Override
    public int getScore(String personId) {
        return 50;
    }

}
