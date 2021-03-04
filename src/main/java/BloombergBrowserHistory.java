import java.util.ArrayList;
import java.util.List;

class BloombergBrowserHistory {
    List<String> history = new ArrayList<>();
    int position = 0;

    public BloombergBrowserHistory(String homepage) {
        position = 0;
        history.add(homepage);
    }

    public void visit(String url) {
        history.subList(position + 1, history.size()).clear();
        history.add(url);
        position += 1;
    }

    public String back(int steps) {
        position = Math.max(position - steps, 0);
        return history.get(position);
    }

    public String forward(int steps) {
        position = Math.min(position + steps, history.size() - 1);
        return history.get(position);
    }
}
//p3
//1,2,3,4,5,6