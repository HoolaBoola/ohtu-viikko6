package statistics.matcher;

public class QueryBuilder {
    
    private Matcher matcher = new All();
    
    public QueryBuilder playsIn(String team) {
        matcher = new And(matcher, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int amount, String attribute) {
        matcher = new And(matcher, new HasAtLeast(amount, attribute));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int amount, String attribute) {
        matcher = new And(matcher, new Not(new HasAtLeast(amount, attribute)));
        
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        matcher = new Or(matchers);
        return this;
    }
    
    public Matcher build() {
        Matcher re = matcher;
        matcher = new All();
        return re;
    }
}
