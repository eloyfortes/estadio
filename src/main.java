import java.util.Random;
import java.util.concurrent.Semaphore;

public class main {

	public static void main(String[] args) {
	    int permissoes = 1;
	    int  ingressos = 100;
        
        Semaphore semaforo = new Semaphore(permissoes);
        Random random = new Random();
    	
        for(int i=1; i<=300;i++){
        	
        	
        	if (ingressos != 0 ) {
        		int compra = random.nextInt(4) + 1;
        		ingressos = ingressos - compra;
	            Corredor c = new Corredor(i, semaforo, compra);
	            c.start();
	            
	           
	          
	         
        	}
            
        }  

	}

}
