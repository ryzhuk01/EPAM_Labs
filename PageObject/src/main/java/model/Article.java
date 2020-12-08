package model;

public enum Article {
    US1("N10S.2017.FG"),
    US2("AGUW.2001.FG"),
    US3("AGUS.2004.FG"),
    US4("PROW.2031.FG"),
    US5("XPAW.2031.FG");

    private final String article;

    Article(String article) {
        this.article = article;
    }

    public String getArticle() {
        return article;
    }
}
