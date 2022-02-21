package ru.kpfu.itis.genatulin;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NodeListIterator implements Iterator<Node> {

    private List<Node> nodeList;
    private Integer cursor;

    public NodeListIterator(NodeList nodeList) {
        this.nodeList = castNodeListToList(nodeList);
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor < nodeList.size();
    }

    @Override
    public Node next() {
        Node resultNode;
        if (this.hasNext()) {
            this.cursor += 1;
            resultNode = nodeList.get(cursor);
        }
        else {
            resultNode = null;
        }
        return resultNode;
    }

    @Override
    public void remove() {
        if (this.hasNext()) {
            nodeList.remove(cursor.intValue());
        }
    }

    private List<Node> castNodeListToList(NodeList nodeList) {
        List<Node> resultList = new ArrayList<>();
        for (int i = 1; i <= nodeList.getLength(); i++) {
            resultList.add(nodeList.item(i));
        }
        return resultList;
    }
}
