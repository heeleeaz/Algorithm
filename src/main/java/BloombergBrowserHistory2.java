import java.util.ArrayList;
import java.util.List;

class BloombergBrowserHistory2 {
    private Node curr;

    public BloombergBrowserHistory2(String homepage) {
        curr = new Node(homepage, null);
    }

    public void visit(String url) {
        if (curr.forward != null) {
            curr.forward.backward = null;
        }

        curr = (curr.forward = new Node(url, curr));
    }

    public String back(int steps) {
        while (steps > 0 && curr.backward != null) {
            steps--;
            curr = curr.backward;
        }

        return curr.url;
    }

    public String forward(int steps) {
        while (steps > 0 && curr.forward != null) {
            steps--;
            curr = curr.forward;
        }

        return curr.url;
    }

    class Node {
        Node forward, backward;
        String url;

        Node(String url, Node backward) {
            this.url = url;
            this.backward = backward;
        }
    }
}
//p3
//1,2,3,4,5,6