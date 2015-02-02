/*********************************************************************

Nombre: Juan Antonio Echeverrías Aranda
Última revisión: 13/5/13
* 
********************************************************************/
package examendaa;

/**
 *
 * //utiliza la clase Algoritmos
 */
public class ExamenDAA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("BUSQUEDA BINARIA");
        int [] vector= {1,2,3,4,5,6,7,8,9,23};
        System.out.println(Algoritmos.toString(vector));
        System.out.println(Algoritmos.busquedaBinaria(vector,0,vector.length-1,45));
        System.out.println(Algoritmos.busquedaBinaria(vector,45));
        System.out.println();
        
        System.out.println("QUICKSORT");
        int [] vector2= {9,6,1,4,3,8,2,5,10,7};
        int [] vector3= {9,6,1,4,3,8,2,5,10,7};
        Algoritmos.quicksort(vector2,vector3,0,vector2.length-1);
        System.out.println(Algoritmos.toString(vector2));
        System.out.println(Algoritmos.toString(vector3));
        System.out.println();
        
        
        
        
        System.out.println("SELECCION DE ACTIVIDADES");
          int [] actividadesinicio= {11,12,13,16,17,20};
        int [] actividadesfin   = {13,13,15,18,19,21};
        
     
        System.out.println(Algoritmos.toString(actividadesinicio));
        System.out.println(Algoritmos.toString(actividadesfin));
        System.out.println(Algoritmos.toString(Algoritmos.seleccionActividades(actividadesinicio,actividadesfin)));
        System.out.println();
        
        System.out.println("CAMBIO DE MONEDAS");
          int [] monedas= {200, 100, 50,  20,  10,  5,   2,   1};
        int cambio=356;
        System.out.println(Algoritmos.toString(monedas));
        System.out.println(Algoritmos.toString(Algoritmos.cambioMonedas(monedas,cambio)));
        System.out.println();
        
        
        
        
        
         System.out.println("MOCHILA");
          //float [] pesos=         {5,5,5,75,5,5,5,10};
          //float [] beneficios   = {10,10,10,10,10,10,10,1};
           float [] pesos=         {5,10,2,2,70,2,3,50};
          float [] beneficios    = {1,50,4,4,140,4,9,5};
          int[] unidades   =    {20,2,1,4,1,4,4,5};
          int capacidad=83;
        
     
        System.out.println(Algoritmos.toString(pesos));
        System.out.println(Algoritmos.toString(beneficios));
        System.out.println(Algoritmos.toString(Algoritmos.mochila(pesos,beneficios,capacidad)));
        System.out.println(Algoritmos.datosMochila(pesos,beneficios,Algoritmos.mochila(pesos,beneficios,capacidad)));
        System.out.println();
        System.out.println(Algoritmos.toString(pesos));
        System.out.println(Algoritmos.toString(beneficios));
        System.out.println(Algoritmos.toString(unidades));
        System.out.println(Algoritmos.toString(Algoritmos.mochila(pesos,beneficios,unidades,capacidad)));
        System.out.println(Algoritmos.datosMochila(pesos,beneficios,Algoritmos.mochila(pesos,beneficios,unidades,capacidad)));
        System.out.println();
        
        
        System.out.println("PRIM");
        int [] [] grafo= {{100,5,8,100,10},{5,100,10,100,100},{8,10,100,4,7},{100,100,4,100,8},{10,100,7,8,100}};
        int nodo=0;
        System.out.println(Algoritmos.toString(grafo));
        System.out.println();
        System.out.println(Algoritmos.toString(Algoritmos.prim(grafo,nodo)));
       System.out.println();
      
        
        
        
        System.out.println("KRUSKAL");
        int [] [] grafo2= {{100,5,8,1000,10},{5,100,10,100,100},{8,10,100,4,7},{100,100,4,100,8},{10,100,7,8,100}};
        System.out.println(Algoritmos.toString(grafo));
        System.out.println();
        System.out.println(Algoritmos.toString(Algoritmos.kruskal(grafo)));
        System.out.println();
       
        
         System.out.println("DJKSTRA");
        int [] [] grafo3= {{1111,5,1111,1111,1111,1111,1111,1111},
                            {1111,1111,20,1111,1111,1111,1111,1111},
                            {1111,1111,1111,30,3,1111,1111,1111},
                            {1111,17,1111,1111,40,10,20,60},
                            {10,1111,1111,1111,1111,1111,1111,1111},
                            {1111,1111,1111,1111,1111,1111,1111,50},
                            {1111,1111,1111,1111,1111,1111,1111,30},
                            {1111,1111,1111,1111,1111,1111,1111,1111}};
        int []distancias=new int [grafo3.length];
        int []predecesores=new int [grafo3.length];
       
        int origen=0;
        Algoritmos.dijkstra(grafo3,distancias,predecesores,origen);
        int destino=7;
        System.out.println("Distancia:"+distancias[destino]);
        System.out.println("Camino: "+Algoritmos.mostrarCamino(predecesores,destino));
        System.out.println();
        
        
         System.out.println("INTRUSO");
        int [] intruso= {2, 4, 6, 12, 8, 16, 18, 20, 22, 24};
         System.out.println(Algoritmos.toString(intruso));
        System.out.println(Algoritmos.intruso(intruso,0,intruso.length-1));
        System.out.println();
        
         System.out.println("MAXIMO");
        int [] maximo= {2, 18, 22, 12, 8, 16, 13, 24, 6, 20};
         System.out.println(Algoritmos.toString(maximo));
        System.out.println(Algoritmos.maximo(maximo,0,maximo.length-1));
        System.out.println();
        
        
        System.out.println("MEDIANA");
        int [] mediana1= {2,3,3,4,5,6,8,8,9,9};
        int [] mediana2= {1,1,1,2,4,6,6,7,8,9};
        System.out.println(Algoritmos.mediana(mediana1,mediana2,0,9,0,9));
        System.out.println();
         
         System.out.println("MEDIA");
        int [] media= {2,3,3,4,5,6,8,8,9,9};
        System.out.println(Algoritmos.media(media,0,9));
        System.out.println();
         
      /*     System.out.println("N-REINAS");  //NO FUNCIONA
        int [] nreinas= {-111,-51,-1,-919};
         System.out.println(Algoritmos.toString(nreinas));
        Algoritmos.nreinas(nreinas,0,4);
        System.out.println(Algoritmos.toString(Algoritmos.getNReinas()));
        System.out.println();
        */
    }
}
