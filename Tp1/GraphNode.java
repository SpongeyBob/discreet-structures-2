package Tp1;

import java.util.LinkedList;

import static Tp1.objetType.*;


public class GraphNode{
    private int id;
    private int objetA;
    private int objetB;
    private int objetC;
    private LinkedList<Objet> listeObjet;
    private LinkedList<GraphEdge> edges;

    GraphNode(int id, int a , int b, int c){
        listeObjet = new LinkedList<>();
        edges = new LinkedList<>();
        this.id = id;
        objetB =0;
        objetC =0;
        objetA =0;
        add(A,a);
        add(B,b);
        add(C,c);
    }

    public int getId(){return id;}

    /**
     * @param objet type of object
     * @return number of objet still in the node
     */
    public int getQtty(objetType objet){
        switch (objet) {
            case A: return objetA;
            case B: return objetB;
            case C: return objetC;
            default: return 0;
        }
    }
    private boolean remove(objetType objet){
        switch (objet) {
            case A:
                if (objetA != 0 ) {
                    objetA--;
                    listeObjet.remove(new Objet(A));
                    return true;
                }
                else return false;
            case B:
                if (objetB != 0 ) {
                    objetB--;
                    listeObjet.remove(new Objet(B));
                    return true;
                }
                else return false;
            case C:
                if (objetC != 0 ) {
                    objetC--;
                    listeObjet.remove(new Objet(C));
                    return true;
                }
                else return false;
            default:
                return false;
        }
    }
    /**
     * @param objet type of objet you wanna remove
     * @param occurence number of objects you wnna remove
     * @return true if all removal succeeds
     * */
    boolean remove(objetType objet, int occurence){
        if(occurence <= 0 ) return false;
        if(occurence > getQtty(objet)) return false;
        while(occurence != 0){
            remove(objet);
            --occurence;
        }
        return true;
    }
    private void add(objetType objet){
        if(objet==A) {
            listeObjet.add(new Objet(A));
            objetA++;
        }
        if(objet == B) {
            listeObjet.add(new Objet(B));
            objetB++;
        }
        if(objet == C) {
            listeObjet.add(new Objet(C));
            objetC++;
        }
    }
    /**
     * @param objet type of objet to add
     * @param occurence number of object to add
     */
    public void add(objetType objet, int occurence){
        if(occurence == 0 ) return ;
        for(;occurence>0;occurence--){
            add(objet);
        }
    }

    LinkedList<GraphEdge> getEdges(){return edges;}

    public void addEdge(GraphEdge edge){ edges.add(edge); }
    public boolean isEqual(GraphNode node){
        if(edges.size()==node.edges.size()) {
            for(int i =0; i<edges.size();++i){
                if(!edges.get(i).isEqual(node.edges.get(i))) return false;
            }
        }
        return (id == node.id && objetA == node.objetA && objetB == node.objetB && objetC==node.objetC
                && listeObjet.size()==node.listeObjet.size()
                && edges.size()==node.edges.size());
    }
}
