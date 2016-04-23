package statistics.matcher;


/**
 *
 * @author arto
 */
public class QueryBuilder {
    Matcher matcher;
    
    public QueryBuilder(){
        
    }
    public QueryBuilder playsIn(String team){
        
        changeMatcher(new PlaysIn(team));
        return this;
    }
    public QueryBuilder hasAtLeast(int value, String category){
        changeMatcher(new HasAtLeast(value,category));
        return this;
    }
    public QueryBuilder oneOf(Matcher...m){
        matcher = new Or(m);
        return this;
    }
    public QueryBuilder noneOf(Matcher...m){
        matcher = new Not(m);
        return this;
    }
    public QueryBuilder hasFewerThan(int value, String category){
        changeMatcher(new HasFewerThan(value,category));
        return this;
    }
    public Matcher build(){
        Matcher output = this.matcher;
        this.matcher = null;
        return output;
    }
    private void changeMatcher(Matcher m){
        if(this.matcher == null){
            this.matcher = m;
        }else {
            this.matcher = new And(matcher,m);
        }
        
    }
}
