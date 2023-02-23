
import javax.swing.*;

public class Grafo
{
    public Lista LVertices;

    public Grafo() {
        LVertices = new Lista();
    }

    public void crearVertice(String nomV){
        LVertices.insertarUlt(new Vertice(nomV));
    }

    public Vertice buscarVertice(String nomV)
    {
        Vertice vertice;
        int i=0;
        while (i<LVertices.dim())
        {
                vertice =(Vertice)LVertices.getElem(i);
                if (vertice.getNombre().equals(nomV))
                    return vertice;
                i++;
        }
         return null;
    }

    public void insertarArco(String X,String Y, float co)
    {
        Vertice vo = buscarVertice(X);
        Vertice vd = buscarVertice(Y);
        vo.insertarArco(new Arco(vd, co));
    }
        
    public void imprimir(JTextArea jta){
        int i = 0,j; Vertice v; Arco a;
        while (i < LVertices.dim())
        {
            v = (Vertice)LVertices.getElem(i);
            j=0; 
            while (j<v.LArcos.dim())
            {
                jta.append(v.getNombre());
                jta.append("-->");
                a = (Arco)v.LArcos.getElem(j); //Muestra el arco donde apunto
                jta.append(a.getNombreVertD() + "  " + a.getCosto());
                jta.append("\n");
                j++;
            }
            i++;                    
        }
    }              
    
    public float peso()
    {
        int i = 0;
        Vertice v; float s = 0;
        while (i < LVertices.dim())
        {
            v = (Vertice)LVertices.getElem(i);
            int j=0; Arco a;
            while(j < v.LArcos.dim())
            {
                  a=(Arco)v.LArcos.getElem(j);
                  s = s + a.getCosto();
                  j++;
            }
                i++;
        }
        return s;
    }
    
  
        
}  //end class