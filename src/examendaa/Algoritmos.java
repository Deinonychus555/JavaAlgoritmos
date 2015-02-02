/*********************************************************************

Nombre: Juan Antonio Echeverrías Aranda
Última revisión: 13/5/13
Algoritmos:
* busquedaBinaria (DYV)
* busquedaBinaria (iterativa)
* quicksort (DYV)
* seleccionActividades (voraz)
* cambioMonedas (voraz)
* mochila (voraz)
* prim (voraz)
* kruskal (voraz)
* dijkstra (voraz)
* intruso (DYV)
* maximo (DYV)
* mediana (DYV)
Notas: los algoritmos 'prim' 'kruskal' y 'dijkstra' son las últimas versiones 
mejoradas y aparentemente funcionan correctamente aunque no he hecho muchas pruebas       
********************************************************************/
package examendaa;

/**
 *
 * @author Juanan
 */

//Nota nreinas: 2 reinas estan en la misma diafonal si mismo valor de fila-columna o fila + columna

public class Algoritmos {
    
    
    
    public static int busquedaBinaria (int [] vector, int inicio, int fin, int x){ //divide y venceras
        //{PRE:el vector que se le pasa debe estar ordenado crecientemente}
        //{POST: devuelve la posicion del vector donde se encuentra el elemento a buscar y -1 si el elemento no se encuentra en el vector}
        int solucion=-1;
        if (x<vector [inicio] || x>vector [fin]){ // compruebo que el elemento pueda estar en el vector
            return -1;
        }
        //CASO BASE
        else if (inicio==fin){ //se ha alcanzado el caso base cuando recibe un vector de tamaño 1
            if (vector[inicio]==x){  // el elemnto se encuentra
                return inicio;
            }
            else{   //el elemento no se encuentra
                return -1;
            }
        }
        //CASO RECURSIVO
        else {
            int m = (inicio+fin)/ 2; // divido el problema por la mitad
            if (vector[m]==x){  // el elemento es el de en medio
               return m;
            }
            else if (vector[m]>x){
                return busquedaBinaria(vector,inicio,m-1,x);
            }
            else{
                return busquedaBinaria(vector,m+1,fin,x);
            }
            }
        
    }
    
  
    
    public static int busquedaBinaria (int []vector, int dato){//forma iterativa
        int centro;
        int inicio =0;
        int fin = vector.length-1;
        while (inicio <=fin) {
            centro=(inicio+fin)/2;
            if (vector[centro]==dato){
                return centro;
            }
            else if (vector[centro]>dato){
                fin=centro-1;
            }
            else{
                inicio=centro+1;
            }   
        }
        return -1;
                
            }
            
            
    public static void quicksort (int []vector, int inicio, int fin){//divide y venceras
        //{POST: ordena el vector que se le pasa}
        int pivote=(inicio+fin)/2;  //divido el problema por la mitad
        int i=inicio; //inicializo los punteros
        int j=fin;
        do{
            //voy a ordenar las dos mitades de tal forma que en la mitad izq todos los elementos sean menor al pivote y en la dcha mayores
           while (vector[i]<vector[pivote]){ //avanzo en la parte izqda mientras todos los elementos sean menor que el pivote
               i++;
           }
           while (vector[j]>vector[pivote]){//retrocedo en la parte dcha mientras todos los elementos sean mayor que el pivote
               j--;
           }
           if (i<=j){ // no se han cruzado todavia los punteros, por lo que alguna de las mitades no esta ordenada aun ¡importante: '<='!
               int aux=vector[i];
               vector[i]=vector[j];
               vector[j]=aux;
               i++; //actualizamos los punteros
               j--;
            }
     
        } while (i<=j); //ya estan colocados bien los elementos respecto el pivote ¡importante: '<='!
        if (inicio<j){  // la mitad izq no esta ordenada
            quicksort(vector,inicio,j);
        }
         if (fin>i){ //la mita dcha no esta ordenada
            quicksort(vector,i,fin);
        }
     
    } 
    
    
     public static void quicksort (int []vector, int []vector2, int inicio, int fin){//divide y venceras
         /*{POST:ordena el primer vector de menor a mayor 
                 y realiza en el segundo  los mismos cambios que en el primero}*/
        int pivote=(inicio+fin)/2;  //divido el problema por la mitad
        int i=inicio;
        int j=fin;
        do{
            //voy a ordenar las dos mitades de tal forma que en la mitad izq todos los elementos sean menor al pivote y en la dcha mayores
           while (vector[i]<vector[pivote]){ //avanzo en la parte izqda mientras todos los elementos sean menor que el pivote
               i++;
           }
           while (vector[j]>vector[pivote]){//retrocedo en la parte dcha mientras todos los elementos sean mayor que el pivote
               j--;
           }
           if (i<=j){ // no se han cruzado todavia los punteros, por lo que alguna de las mitades no esta ordenada aun ¡importante: '<='!
               int aux=vector[i];
               int aux2=vector2[i];
               vector[i]=vector[j];
               vector2[i]=vector2[j];
               vector[j]=aux;
               vector2[j]=aux;
               i++;
               j--;
            }
     
        } while (i<=j); //ya estan colocados bien los elemntos respecto el pivote ¡importante: '<='!
        if (inicio<j){  // la mitad izq no esta ordenada
            quicksort(vector,vector2,inicio,j);
        }
         if (fin>i){ //la mita dcha no esta ordenada
            quicksort(vector,vector2,i,fin);
        }
     
    } 
    
    public static boolean [] seleccionActividades (int []ti, int [] tf){//TECNICA VORAZ
        //{PRE:ti debe estar ordenado crecientemente ya que mi funcion de seleccion es prioridad ante las tareas que empiecen antes}
        //{POST:devuelve un vector booleano con las actividades a realizar con el fin de que se puedan realizar el maximo de tareas}
        //ti:vector tiempo inicio actividades
        //tf:vector tiempo fin actividades
        //sol:vector solucion done quedan a true las activides que no se solapan
        boolean []solucion= new boolean [ti.length];
        int n=ti.length;// numero total de actividades
        solucion [0]=true; //cojo la primera actividad poruqe al estar ordenadas es la que se realiza mas temprano (funcion de seleccion)
        int j=0;// me indica el fin de la actividad
        for (int i=2; i<n;i++){
            if(ti[i]>=tf[j]){
                solucion[i]=true;
                j=i;// importante, imaginar que la actividad acaba muy tarde y varias de las actividades siguientes se solapan
            }
            
        }
        return solucion;
        
    }
    
    public static int [] cambioMonedas (int[]monedas, int cambio){//TECNICA VORAZ
        //{PRE:monedas debe estar ordenado crecientemente}
        //{POST:devuelve un vector indicando el numero de monedas a devolver de cada tipo para que el total de monedas sea minimo}
        int[]solucion=new int [monedas.length];
        int vuelta=0;
        int i=0;//numero de candidatos
        int seleccion;
        while ((vuelta != cambio) && (i<monedas.length)){//mientras no se haya aldanzado la solucion y siga habiendo candidatos
            seleccion=monedas[i];//seleccionamos el tipo de moneda
            if ((vuelta+seleccion)<=cambio){//comprobamos que sea candidato
                solucion[i]=solucion[i]+1; //es candidato y lo añadimos a la solucion
                vuelta=vuelta+seleccion;
            }
            else{//no es candidato
                i++;//lo desechamos de la solcion
            }
           
        }
        
        return solucion;
    }
    
   
     public static boolean [] mochila (float [] peso, float [] beneficio, int capacidad){//TECNICA VORAZ
         //{PRE:recibe un vector con el peso de los objetos, otro con su beneficio y la capacidad de la mochila}
         //{POST:devuelve un vector de booleanos indicando los objetos a meter en la mochila para que su beneficio sea maximo}
        boolean []solucion =new boolean[peso.length];
        float pesototal=0;
        int candidatos=peso.length;
        boolean [] sacado= new boolean [candidatos]; //los objetos no disponibles están a true
        int candidato;
        while ((pesototal!=capacidad)&& (candidatos!=0)){// (antes:pesototal<capacidad)
            int j=0;
            boolean encontrado=false;
            while ((j<peso.length) && (!encontrado)){//buscamos el primer objeto disponible
                if(!sacado[j]) {
                    encontrado=true;
                }
                else{
                    j++;
                }
            }
            
            candidato=j;//inicializamos candidato
            for (int i=j; i<peso.length;i++){//vamos seleccionando los objetos restantes
                if ((!sacado[i])&&((beneficio[i]/peso[i])>=(beneficio[candidato]/peso[candidato]))){//funcion de seleccion de un objeto mejor
                    if((beneficio[i]/peso[i])==(beneficio[candidato]/peso[candidato])){//tienen la misma proporcion de beneficio
                        if((beneficio[i]>beneficio[candidato])){//elige el objeto que pesa mas
                            candidato=i;
                        }
                    }
                    else{//el objeto i tiene mas proporcion de beneficio y pasa a ser el candidato
                        candidato=i;
                        
                    }
                }//if
            }//for
            sacado[candidato]=true;//retiramos el objeto del conjunto
            candidatos=candidatos-1; //actualizamos el numero de candidatos posibles
            if(pesototal+peso[candidato]<=capacidad){// comprobamos que puede formar parte de la solucion
                solucion[candidato]=true; //añadimos el candidato a la solucion
                pesototal=pesototal+peso[candidato];//actualizamos la solucion
                
            }
            
            
        }
       
        
        return solucion;
    }
   
     
     public static int [] mochila (float [] peso, float [] beneficio,int [] unidades, int capacidad ){//TECNICA VORAZ //algoritmo no comprobado
         //{PRE:recibe un vector con el peso de los objetos, otro con su beneficio, otrocon el numero de unidades y la capacidad de la mochila}
         //{POST:devuelve un vector con el numero de objetosde cada clase a introducir para obtener el beneficio maximo}
        int []solucion =new int[peso.length];
        float pesototal=0;
        int candidatos=peso.length;
        boolean [] sacado= new boolean [candidatos]; //los objetos no disponibles están a true
        int candidato;
        while ((pesototal!=capacidad)&& (candidatos!=0)){// (antes:pesototal<capacidad)
            int j=0;
            boolean encontrado=false;
            while ((j<peso.length) && (!encontrado)){//buscamos el primer objeto disponible
                if(!sacado[j]) {
                    encontrado=true;
                }
                else{
                    j++;
                }
            }
            
            candidato=j;//inicializamos candidato
            for (int i=j; i<peso.length;i++){//vamos seleccionando los objetos restantes
                if ((!sacado[i])&&((beneficio[i]/peso[i])>=(beneficio[candidato]/peso[candidato]))){//funcion de seleccion de un objeto mejor
                    if((beneficio[i]/peso[i])==(beneficio[candidato]/peso[candidato])){//tienen la misma proporcion de beneficio
                        if((beneficio[i]>beneficio[candidato])){//elige el objeto que pesa mas
                            candidato=i;
                        }
                    }
                    else{//el objeto i tiene mas proporcion de beneficio y pasa a ser el candidato
                        candidato=i;
                        
                    }
                }//if
            }//for
            
            candidatos=candidatos-1; //actualizamos el numero de candidatos posibles
            if(pesototal+peso[candidato]<=capacidad){// comprobamos que puede formar parte de la solucion
                solucion[candidato]=solucion[candidato]+1; //añadimos el candidato a la solucion
                pesototal=pesototal+peso[candidato];//actualizamos la solucion
                unidades[candidato]=unidades[candidato]-1;//actualizamos las unidades
                if(unidades[candidato]==0){//ya no quedan mas unidades de ese objeto
                   sacado[candidato]=true;//retiramos el objeto del conjunto 
                }
                
            }
            else{
                sacado[candidato]=true;//retiramos el objeto del conjunto
            }
            
        }
       
        
        return solucion;
    }
     
     
    public static StringBuilder datosMochila (float []peso, float[]beneficio, boolean []mochila){
        //{POST:devuelve un String con los datos de la mochila}
        StringBuilder datos=new StringBuilder();
        float pesototal=0;
        float beneficiototal=0;
        for(int i=0; i<peso.length;i++){
            if(mochila[i]){
                pesototal=pesototal+peso[i];
                beneficiototal=beneficiototal+beneficio[i];
            }
        }
        datos.append("Peso: "+pesototal+"  Beneficio: "+beneficiototal);
        return datos;
    }
    
    public static StringBuilder datosMochila (float []peso, float[]beneficio,int []mochila){
        //{POST:devuelve un String con los datos de la mochila}
        StringBuilder datos=new StringBuilder();
        float pesototal=0;
        float beneficiototal=0;
        for(int i=0; i<peso.length;i++){
            
                pesototal=pesototal+(peso[i]*mochila[i]);
                beneficiototal=beneficiototal+(beneficio[i]*mochila[i]);
            
        }
        datos.append("Peso: "+pesototal+"  Beneficio: "+beneficiototal);
        return datos;
    }
     
  
      
      public static int [] [] prim ( int[][] grafo, int nodo){//version ultima mejorada con una matriz de desechados del conjunto de candidatos
        //{PRE:las aristas nulas deben valer 0}
        //{POST:devuelve una matriz de las que forman el ARM con su peso correspondiente}  
        int [][]solucion= new int [grafo.length][grafo.length];
        boolean [][]desechados= new boolean [grafo.length][grafo.length];
        boolean []nodos=new boolean [grafo.length];// nodos visistados
        int na=0; // numero de aristas del ARM (deben ser iguales a grafo.length-1
        int candidatos=0; //numero de aristas candidatas
        int []candidato =new int[2];//guarda las coordenadas de la arista candidata
        boolean encontrado;
        //CONJUNTO DE CANDIDATOS
        for(int i=0;i<grafo.length;i++){//se inicializa la matriz de aristas desechadas
            for (int j=0;j<grafo[i].length;j++){//calculamos el numero de aristas candidatas
                if((grafo[i][j]!=0)&&(j>i)){//aristas no nulas y no repetidas
                    candidatos=candidatos+1;
                }
                else{// se desechan las aristas nulas y aristas repetidas
                    desechados [i][j]=true; //desechamos los vertices
                }
            }
        }    
      
        nodos[nodo]=true;//empezamos a explorar po el nodo indicado y lo añadimos a la solucion
       
        
         //FUNCION SOLUCION
        while ((na<grafo.length-1)&& (candidatos!=0)) {
            int i=0;
            int j=0;
            encontrado=false;
            while ((i<desechados.length) && (!encontrado)){// buscamos la primera arista disponible
                while ((j<desechados.length) && (!encontrado)){
                    if (!desechados[i][j]){
                         candidato[0]=i;  
                         candidato[1]=j;
                         encontrado=true;
                    }
                    else{
                        j++;
                    }
                }// while j
                i++; 
            }// while i
           
            //FUNCION DE SELECCION
            for(i=0;i<grafo.length;i++){//comparamos para obtener un candidato mejor al seleccionado
                for (j=0;j<grafo[i].length;j++){
                    if((!desechados[i][j])&&(nodos[i]||nodos[j])&&(grafo[i][j]<grafo[candidato[0]][candidato[1]])){//funcion de seleccion
                        candidato[0]=i;
                        candidato[1]=j;
                    }//if

                }  //for    
           }//for
            desechados[candidato[0]][candidato[1]]=true;//quitamos el candidato del conjunto de candidatos
            candidatos=candidatos-1;
            //FUNCION DE FACTIBILIDAD
            if (!(nodos[candidato[0]]&&nodos[candidato[1]])){//comprobamos que pueda formar parte de la solucion
                solucion[candidato[0]][candidato[1]]=grafo[candidato[0]][candidato[1]];
                nodos[candidato[0]]=true; 
                nodos[candidato[1]]=true; 
                //FUNCION ONJETIVO
                na=na+1;
            }
            
        }//while
        return solucion;
    }    
      
      
     
       
      public static int [] [] kruskal ( int[][] grafo){//ultima version mejorada con una matriz de desechados del conjunto de candidatos
           //{PRE:las aristas nulas deben valer 0}
            //{POST:devuelve una matriz con el ARM del grafo y el peso correspondiente de sus aristas  }
          int [][]solucion= new int [grafo.length][grafo.length];
         boolean [][]desechados= new boolean [grafo.length][grafo.length];
        int []cc=new int [grafo.length];// componentes conexas
        int na=0; // numero de aristas del ARM que deben ser de g.length-1
        boolean encontrado;
        int candidatos=0; //numero de aristas candidatas
        int []candidato =new int[2];
        //CONJUNTO DE CANDIDATOS
        for(int i=0;i<grafo.length;i++){//inicializamos la matriz de aristas desechadas  (no candidatas)
            for (int j=0;j<grafo[i].length;j++){//calculamos el numero de aristas candidatas
                if((grafo[i][j]!=0)&&(j>i)){//para que no sea ni una arista nula ni una arista ya contemplada
                    candidatos=candidatos+1;
                }
                else{//desechamos las aristas nulas y repetidas
                    desechados [i][j]=true; //desechamos los vertices
                }
            }
        }    
        
        for (int i=0; i<cc.length;i++){// inicializamos el vector de componentes conexas
            cc[i]=i;
        }
       
        //FUNCION SOLUCION
        while ((na<grafo.length-1)&& (candidatos!=0)) {
            int i=0;
            int j=0;
            encontrado=false;
            while ((i<desechados.length) && (!encontrado)){// buscamos la primera arista disponible
                while ((j<desechados.length) && (!encontrado)){
                    if (!desechados[i][j]){
                         candidato[0]=i;  
                         candidato[1]=j;
                         encontrado=true;
                    }
                    else{
                        j++;
                    }
                }// while j
                i++; 
            }// while i
            //FUNCION DE SELECCION
            for( i=0;i<grafo.length;i++){
                for ( j=0;j<grafo[i].length;j++){//recorremos el grafo en busca de uan arista mejor
                    if((!desechados[i][j])&&(grafo[i][j]<grafo[candidato[0]][candidato[1]])){//funcion de seleccion
                        candidato[0]=i;
                        candidato[1]=j;
                    }//if

                }  //for    
           }//for
            desechados[candidato[0]][candidato[1]]=true;
            candidatos=candidatos-1;
            //FUNCION DE FACTIBILIDAD
            if((cc[candidato[0]]!=cc[candidato[1]])){
                solucion[candidato[0]][candidato[1]]=grafo[candidato[0]][candidato[1]];
                int aux=cc[candidato[1]];
                for(i=0; i<cc.length;i++){//funcion de coloreado
                    if(cc[i]==aux){
                        cc[i]=cc[candidato[0]];
                    }

                }
                //FUNCION OBJETIVO
                na=na+1; //actualizo el numero de componentes conexas
            }//if
        }//while
        return solucion;
    }    
      
      
     
          

      
      public static void dijkstra(int [][] grafo,int [] distancia, int [] precedente, int inicio){//version mejorada
           //{PRE:las aristas nulas deben valer 'infinito'}
            //{POST:devuelve un vector distancias del nodo origen a los demas y un vector del precedente de cada nodo}
          boolean [] seleccionados =new boolean [grafo.length];
          int s=0; //numero de nodos visitados
          boolean encontrado;
          int candidato;
          for(int i=0;i<distancia.length;i++){//inicializamos el vector distancias a infinito
              distancia[i]=1000;
          }    
              
          distancia[inicio]=0;//ponemos el nodo origen a 0 para que sea el primero en ser seleccionado
          precedente[inicio]=-1;//ya que el nodo origen no tiene precedente
          while (s<seleccionados.length-1){//mientras haya nodos sin visitar reorecmos el grafo
            int j=0;
            
           
            encontrado=false;
            while ((j<seleccionados.length) && (!encontrado)){//buscamos el primer nodo no visitado
                if(!seleccionados[j]) {
                    encontrado=true;
                }
                else{
                    j++;
                }
            }
            candidato=j;
            for(int i=j;i<distancia.length;i++){//seleccionamos el nodo no visitado con menor distanica acumulada
                if((seleccionados[i]==false)&&(distancia[i]<distancia[candidato])){
                     candidato=i;
                 }
                
            }//for
            
            
            seleccionados[candidato]=true;//añadimos el nodo a los visitados, su distancia y predecesor quedan ya fijos
            s=s+1;//incrementamos el numero de nodos visitados
            for (int i=0;i<distancia.length;i++){//calculamos la distancia a sus nodos adyacentes y las vamos actualizando
                if (!seleccionados[i]&&(distancia[i]>(distancia[candidato]+grafo[candidato][i]))){
                    distancia[i]=distancia[candidato]+grafo[candidato][i];//actualizamos la distancia al nodo i
                    precedente[i]=candidato; //actualizamos el predecesor del nodo i
                 }
            }//for
                 
        }//fin while       
          
}
      
   public static StringBuilder mostrarCamino (int [] vector, int destino){
    StringBuilder camino= new StringBuilder();
    boolean fin=false;
    int lugar=destino;
    while (!fin) {
        camino.append(vector[lugar]+" ");
        if(vector[lugar]==0){
            fin=true;
        }
        else{
            lugar=vector[lugar];
        }
        
    }
    return camino;   
    } 
           
   public static int intruso(int[]vector, int inicio, int fin){
       //{POST:Devuelve la posicion del intruso}
       if ((fin-inicio)==1){//se ha alcanzado el caso base con una pareja de elementos
           if (vector[fin]<vector[inicio]){//se ha encontrado el intruso; el numero de la derecha es menor que el de la izquierda
               return fin;
           }
           else{
               return -1;//no se encuentra el intruso
           }
       }//fin caso base
       else{
           int m=(fin+inicio)/2;// dividimos el problema por la mitad
           if (vector[m]<vector[m-1]){//compruebo justo el elemento donde hago la particion
                return m;
            }
           else {//para asegurar el caso base (vector de dos elementos) pasare en los dos subvectores el elemento intermedio m
            int izq= intruso(vector,inicio,m);
            int dch= intruso(vector,m,fin);
            int solucion =(izq<dch)?dch:izq;//funcion de combinacion para determinar en que parte esta el intruso
            return solucion;
           }
           
       }   
   }//fin intruso
   
   
    public static int maximo(int[]vector, int inicio, int fin){
        //{POST:Devuelve la posicion del elemento maximo del vector}
       if ((fin-inicio)==1){//se ha alcanzao el caso base con una pareja de elementos
          return  (vector[fin]<vector[inicio])?inicio:fin;//devuelve el elemento mayor
       }
       else{
           int m=(fin+inicio)/2;// dividimos el problema por la mitad
           //para asegurar el caso base (vector de dos elementos) pasare en los dos subvectores el elemento intermedio m
           int izq= maximo(vector,inicio,m);
           int dch= maximo(vector,m,fin);
           return (vector[izq]<vector[dch])?dch:izq;
       }   
   }//fin maximo   
    
   public static void trasponer (int[][] m, int a, int b, int c, int d){//algoritmo de Manuel Bustillo
       //{PRE: a y b son inicio y fin de columnas y c y d son inicio y fin de filas}
       //{POST: la matriz inicial la convierte a su traspuesta}
        int aux;
        int lado =b-a+1;//¡IMPORTANTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if(lado==2){ //Caso base
            aux=m[c][b];
            m[c][b]=m[d][a];
            m[d][a]=aux;
        }
        else{ //Caso recursivo
            trasponer(m, a, (b+a)/2, c, (c+d)/2);
            trasponer(m, a, (b+a)/2, (c+d)/2+1, d);
            trasponer(m, (a+b)/2+1, b, c, (c+d)/2);
            trasponer(m, (a+b)/2+1, b, (c+d)/2+1, d);
            lado/=2;//¡IMPORTANTE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            for(int i=a+lado;i<=b;i++)  //funcion de combinacion
                for(int j=c;j<c+lado;j++){ //Realizamos el intercambio
                    aux=m[i][j];
                    m[i][j]=m[i-lado][j+lado];
                    m[i-lado][j+lado]=aux;
                }
        }
    }
   
 
   
   //NOTA: CUIDADO AL CORTAR Y PEGAR, ASEGURARSE DE CAMBIAR EL NOMBRE DEL METODO EN LAS LLAMADAS RECURSIVAS!!!!!!!!!
    
   
    
  public static int mediana (int[]x, int[]y, int inix, int finx, int iniy, int finy){//realizado por Manuel Bustillo
      //{PRE:los dos vectores estan orenados crecientemente}
      //{POST:te devuelve el elemento de la mediana si uniesemos los dos vectores (quedando los elementos ordenados crecientemente)}
  if((finx-inix)==0){//caso base el subvector tiene solo un elemento
    return(x[inix]<y[iniy])?x[inix]:y[iniy];//se comparan los dos subvectores y se devuelve el MENOR
  }
  else{//si las medianas de ambos vectores son iguales, esa sera la mediana resultante de la union
    //¡CUIDADO: COMO TENEMOS DOS VECTORES HAY QUE CALCULAR LA POSICION DE EN MEDIO PARA LOS DOS!
    int mx = (finx+inix)/2;
    int my = (finy+iniy)/2;
    if (x[mx]==y[my]){//Coinciden las medianas
      return mx; 
    }
    else{//las medianas no coinciden
      if(x[mx]>y[my]){//se coge la primera mitad de x incluyendo su mediana y la SEGUNDA mitad de y DESECHANDO SU MEDIANA
        return mediana (x, y, inix, mx, my+1, finy);
      }
      else //se coge la primera mitad de y incluyendo su mediana y la SEGUNDA mitad de x DESECHANDO SU MEDIANA
          return mediana(x, y, mx+1, finx, iniy, my);
    }
  }
}
    
  
   public static int media (int[]v,int inicio, int fin){//divide y venceras // NO FUNCIONA
     
      //{POST:te devuelve la media aritmetica de los elementos del vector)}
  if((fin-inicio)==0){//caso base el subvector tiene solo un elemento
    return v[inicio]/v.length;
  }
  else{
    int m = (inicio+fin)/2;
    int soluciona= media (v,inicio,m);
    int solucionb= media(v,m+1,fin);
    int solucion= soluciona+solucionb; //funcion de combinacion
    return solucion;
    }
 
}
  
    public static StringBuilder toString (int [] vector){
        StringBuilder v= new StringBuilder();
        for(int i=0; i<vector.length;i++){
            v.append(vector[i]+" ");
        }
        return v;
    }
    
    
    public static StringBuilder toString (float [] vector){
        StringBuilder v= new StringBuilder();
        for(int i=0; i<vector.length;i++){
            v.append((int)vector[i]+" ");
        }
        return v;
    }
      public static StringBuilder toString (boolean [] vector){
        StringBuilder v= new StringBuilder();
        for(int i=0; i<vector.length;i++){
            v.append(vector[i]+" ");
        }
        return v;
    }
    
     public static StringBuilder toString (int [] []grafo){
        StringBuilder v= new StringBuilder();
        for(int i=0;i<grafo.length;i++){
              v.append("\n");  
              for (int j=0;j<grafo[i].length;j++){//calculamos el numero de aristas candidatas
                   v.append(grafo[i][j]+" ");
                 }
          }    
        return v;
     }
    
     
      public static StringBuilder toString (boolean [] []grafo){
        StringBuilder v= new StringBuilder();
        for(int i=0;i<grafo.length;i++){
              v.append("\n");  
              for (int j=0;j<grafo[i].length;j++){//calculamos el numero de aristas candidatas
                   v.append(grafo[i][j]+" ");
                 }
          }    
        return v;
     }
    
  /*  public static boolean posvalida(int columna, int fila, int[]tablero){//metodo asociado a nreinas que no funciona
        
        boolean solucion;
        boolean valido=true;
        if (tablero[columna]>=0){ // en esa columna ya hay una reina
            return false;
        }
        else{
            int i=0; //TE DEVUELVE SIEMPRE FALSE!!!!!!!!!!!!
            while ((i <tablero.length)&&valido){
                    //condiciones para que sea dada una columna i la reina se peuda poner en un fila j
                    if ((i==fila)||(i==columna)||(tablero[i]+i==fila+columna)||(tablero[i]-i==fila-columna)){
                        valido=false;
                    
                    }
                    else {
                        i=i+1;
                    }
            }
            return valido;    
            }
        }
        
      public static void nreinas ( int []tablero, int columna,int filas){//NO FUNCIONA!!!!!
        
       
        for (int i=0; i<filas;i++){
           
	if (posvalida(columna,i,tablero)){
                tablero[columna]=i;
                   if   ( columna==tablero.length-1){
                    ajedrez =copia(tablero);
                    }
                              
                
                
                    
                else{
                      nreinas (tablero,columna+1,filas);
                }
                 tablero[columna]=-1;
                    
        }//fin if estado valido
           
       } //fin for i
      
       
    }//fin reinas   
      
   
   public static int []copia(int[]vector){
       int [] v= new int [vector.length];
       for (int i=0; i<v.length;i++){
           v[i]=vector[i];
       }
       return v;
   }
 
   public static int [] getNReinas(){
       return ajedrez;
   }
 */  
}